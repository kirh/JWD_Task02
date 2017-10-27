package by.tc.task02.dao.impl;

import by.tc.task02.dao.DAOException;
import by.tc.task02.entity.Element;
import by.tc.task02.entity.Node;
import by.tc.task02.entity.ValueNode;

class NodeFactory {

    private static final NodeFactory instance = new NodeFactory();

    private NodeFactory() {
    }

    Node getNode(XMLToken xmlToken) throws DAOException {

        if (xmlToken.isOpeningTag() || xmlToken.isSelfClosingTag()) {
            Element element = new Element();
            element.setTagName(xmlToken.getTitle());
            element.setAttributes(xmlToken.getAttributes());
            return element;
        }

        if (xmlToken.isText() || xmlToken.isComment()) {
            ValueNode valueNode = new ValueNode();
            valueNode.setValue(xmlToken.getTitle());
            return valueNode;
        }

        if (xmlToken.isDescriptor()) {
            return null;
        }

        throw new DAOException();

    }

    public static NodeFactory getInstance() {
        return instance;
    }
}
