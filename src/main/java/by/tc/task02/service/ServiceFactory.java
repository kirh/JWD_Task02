package by.tc.task02.service;

import by.tc.task02.service.impl.DOMParserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final DOMParserService domParserService = new DOMParserServiceImpl();

    private ServiceFactory() { }

    public DOMParserService getDOMParserService() {
        return domParserService;
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }
}
