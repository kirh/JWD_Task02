package by.tc.task02.dao.impl;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class XMLToken {

    private static final String NAME_REGEX = "[a-zA-Z_][\\w-.]*";

    private static final String TEXT_REGEX = "[^<>&]+";

    private static final String ATTRIBUTE_VALUE_REGEX = "(\"" + TEXT_REGEX + "\")|('" + TEXT_REGEX + "')";

    private static final String ATTRIBUTE_REGEX = "(\\s+" + NAME_REGEX + "=" + ATTRIBUTE_VALUE_REGEX + ")";


    private static final Pattern NAME = Pattern.compile(NAME_REGEX);

    private static final Pattern ATTRIBUTE = Pattern.compile(ATTRIBUTE_REGEX);

    private static final Pattern XML_DESCRIPTOR = Pattern.compile("<\\?.*\\?>");

    private static final Pattern OPENING_TAG = Pattern.compile("^<" + NAME_REGEX + ATTRIBUTE + "*>$");

    private static final Pattern CLOSING_TAG = Pattern.compile("^</" + NAME_REGEX + ">$");

    private static final Pattern TEXT = Pattern.compile(TEXT_REGEX);

    private static final Pattern COMMENT = Pattern.compile("<!--" + TEXT_REGEX + "-->");

    private static final Pattern SELF_CLOSING_TAG = Pattern.compile("<" + NAME_REGEX + "/>");

    private String xmlTokenLine;

    private String title;

    private Map<String, String> attributes;

    XMLToken(String xmlTokenLine) {
        this.xmlTokenLine = xmlTokenLine;
        parseTitle();
    }

    public String getXmlTokenLine() {
        return xmlTokenLine;
    }

    String getTitle() {
        return title;
    }

    Map<String, String> getAttributes() {
        if (attributes == null) {
            parseAttributes();
        }
        return attributes;
    }

    boolean isOpeningTag() {
        return OPENING_TAG.matcher(xmlTokenLine).matches();
    }

    boolean isClosingTag() {
        return CLOSING_TAG.matcher(xmlTokenLine).matches();
    }

    boolean isSelfClosingTag() {
        return SELF_CLOSING_TAG.matcher(xmlTokenLine).matches();
    }

    boolean isTag() {
        return isClosingTag() || isOpeningTag() || isSelfClosingTag();
    }

    boolean isText() {
        return TEXT.matcher(xmlTokenLine).matches();
    }

    boolean isComment() {
        return COMMENT.matcher(xmlTokenLine).matches();
    }

    boolean isDescriptor() {
        return XML_DESCRIPTOR.matcher(xmlTokenLine).matches();
    }


    private void parseAttributes() {
        if (isOpeningTag() || isSelfClosingTag()) {

            attributes = new HashMap<>();

            Matcher matcher = ATTRIBUTE.matcher(xmlTokenLine);

            while (matcher.find()) {

                parseAttribute(matcher);
            }
        }
    }

    private void parseAttribute(final Matcher matcher) {

        final int KEY = 0;
        final int VALUE = 1;

        String attributeLine = xmlTokenLine.substring(matcher.start(), matcher.end());

        attributeLine.trim();

        attributeLine = attributeLine.replaceAll("\"", "");

        String[] entry = attributeLine.split("=");

        attributes.put(entry[KEY], entry[VALUE]);
    }

    private void parseTitle() {

        Matcher matcher = NAME.matcher(xmlTokenLine);

        if (isTag()) {
            matcher.find();
        } else {
            matcher.usePattern(TEXT).find();
        }
        title = xmlTokenLine.substring(matcher.start(), matcher.end());
    }
}
