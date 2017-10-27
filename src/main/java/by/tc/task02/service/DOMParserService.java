package by.tc.task02.service;

import by.tc.task02.entity.Document;
import by.tc.task02.entity.Element;

import java.nio.file.Path;

public interface DOMParserService {

    Document parse(Path path) throws DOMParserServiceException;
}
