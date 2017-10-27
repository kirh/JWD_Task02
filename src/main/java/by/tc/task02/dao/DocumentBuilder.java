package by.tc.task02.dao;

import by.tc.task02.entity.Document;

import java.nio.file.Path;

public interface DocumentBuilder {

    Document parse(Path path) throws DAOException;
}
