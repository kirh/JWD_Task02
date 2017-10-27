package by.tc.task02.main;

import by.tc.task02.entity.Document;
import by.tc.task02.entity.Element;
import by.tc.task02.entity.Node;
import by.tc.task02.entity.ValueNode;

import java.util.List;
import java.util.Map;

public class PrintDocument {

    private static int indent = 1;
    private static final int DEFAULT_INDENT = 4;

    public static void print(Document document) {
        print(document.getRootNode());
    }

    private static void print(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            print(element);
        } else if (node instanceof ValueNode) {
            ValueNode valueNode = (ValueNode) node;
            print(valueNode);
        }
    }

    private static void print(Element element) {

        System.out.printf("%" + indent + "c%s%s", ' ', "<", element.getTagName());
        if (element.hasAttributes()) {
            printAttributes(element);
        }
        if (element.hasChildNodes()) {
            printChildNodes(element);
            System.out.printf("%" + indent + "c</%s>\n", ' ', element.getTagName());
        } else {
            System.out.println("/>");
        }
    }

    private static void print(ValueNode valueNode) {
        System.out.printf("%" + indent + "c%s\n", ' ', valueNode.getValue());
    }

    private static void printChildNodes(Element element) {
        indent += DEFAULT_INDENT;
        System.out.println(">");
        List<Node> childNodes = element.getChildNodes();
        childNodes.forEach(child -> print(child));
        indent -= DEFAULT_INDENT;
    }

    private static void printAttributes(Element element) {
        Map<String, String> attributes = element.getAttributes();
        attributes.forEach((key, value) -> {
            System.out.printf("%s=%s", key, value);
        });
    }
}
