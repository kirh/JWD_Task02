package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOException;
import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.DocumentBuilder;
import by.tc.task02.entity.Document;
import by.tc.task02.service.DOMParserService;
import by.tc.task02.service.DOMParserServiceException;

import java.nio.file.Path;

public class DOMParserServiceImpl  implements DOMParserService{

    @Override
    public Document parse(Path path) throws DOMParserServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();

        DocumentBuilder documentBuilder = daoFactory.getXmlDocumentDAO();

        try {
            return documentBuilder.parse(path);
        } catch (DAOException e) {
            throw new DOMParserServiceException(e);
        }
    }
}
