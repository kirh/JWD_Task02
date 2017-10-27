package by.tc.task02.service;

public class DOMParserServiceException extends Exception {
    public DOMParserServiceException() {
    }

    public DOMParserServiceException(final String message,final Throwable cause) {
        super(message, cause);
    }

    public DOMParserServiceException(final Throwable cause) {
        super(cause);
    }
}
