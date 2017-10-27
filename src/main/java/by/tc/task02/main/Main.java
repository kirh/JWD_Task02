package by.tc.task02.main;

import by.tc.task02.entity.Document;
import by.tc.task02.service.DOMParserService;
import by.tc.task02.service.DOMParserServiceException;
import by.tc.task02.service.ServiceFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {

    public static final String XML_FILE_PATH = "/books.xml";

    public static void main(String[] args) throws URISyntaxException, IOException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        DOMParserService domParserService = serviceFactory.getDOMParserService();

        URL resource = Main.class.getResource(XML_FILE_PATH);

        Document document = null;

        try {

            document = domParserService.parse(Paths.get(resource.toURI()));

        } catch (DOMParserServiceException e) {
            e.printStackTrace();
        }

        PrintDocument.print(document);

    }

}
