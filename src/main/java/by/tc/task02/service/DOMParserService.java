package by.tc.task02.service;

import by.tc.task02.entity.Document;

import java.nio.file.Path;

public interface DOMParserService {

    Document parse(final Path path) throws DOMParserServiceException;
}
