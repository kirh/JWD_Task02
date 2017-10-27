package by.tc.task02.dao.impl;

import by.tc.task02.dao.DAOException;
import by.tc.task02.entity.Document;
import by.tc.task02.entity.Element;
import by.tc.task02.entity.Node;

import java.io.IOException;
import java.nio.file.Path;

public class DocumentBuilderImpl implements by.tc.task02.dao.DocumentBuilder {

    private final NodeFactory nodeFactory = NodeFactory.getInstance();

    private final Document document = new Document();

    private Element currentElement;

    private Document build(){
        return document;
    }

    private void append(XMLToken xmlToken) throws DAOException {

        if (xmlToken.isClosingTag()) {
            currentElement = currentElement.getParent();
        } else {
            Node node = nodeFactory.getNode(xmlToken);
            if (currentElement == null) {
                currentElement = (Element) node;
                document.setRootNode(currentElement);
            } else {
                currentElement.addChild(node);
                if (xmlToken.isOpeningTag()) {
                    currentElement = (Element) node;
                }
            }
        }
    }

    public Document parse(Path path) throws DAOException{
        try(XMLResource xmlResource = new XMLResource(path)){
            while (xmlResource.hasNext()){
                append(xmlResource.next());
            }

        } catch (IOException e) {
            throw new DAOException(e);
        }
        return build();
    }
}