package by.tc.task02.dao;

import by.tc.task02.dao.impl.DocumentBuilderImpl;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public DocumentBuilder getXmlDocumentDAO() {
        return new DocumentBuilderImpl();
    }

    public static DAOFactory getInstance() {
        return instance;
    }


}
