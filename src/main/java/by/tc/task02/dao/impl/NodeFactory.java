package by.tc.task02.dao.impl;

import by.tc.task02.entity.Element;
import by.tc.task02.entity.Node;
import by.tc.task02.entity.ValueNode;

final class NodeFactory {

    private static final NodeFactory INSTANCE = new NodeFactory();

    private NodeFactory() {
    }

    Node getNode(final XMLToken xmlToken) throws NodeFactoryException {

        if (xmlToken.isOpeningTag() || xmlToken.isSelfClosingTag()) {
            return createElement(xmlToken);
        }

        if (xmlToken.isText() || xmlToken.isComment()) {
            return createValueNode(xmlToken);
        }

        if (xmlToken.isDescriptor()) {
            return null;
        }

        throw new NodeFactoryException("No proper factory for \"" + xmlToken.getXmlTokenLine() + "\"");

    }

    private Node createValueNode(final XMLToken xmlToken) {
        ValueNode valueNode = new ValueNode();
        valueNode.setValue(xmlToken.getTitle());
        return valueNode;
    }

    private Node createElement(final XMLToken xmlToken) {
        Element element = new Element();
        element.setTagName(xmlToken.getTitle());
        element.setAttributes(xmlToken.getAttributes());
        return element;
    }

    public static NodeFactory getInstance() {
        return INSTANCE;
    }
}
