package by.tc.task02.dao;

public class DAOException extends Exception {

    public DAOException(final String message,final Throwable cause) {
        super(message, cause);
    }

    public DAOException(final Throwable cause) {
        super(cause);
    }

    public DAOException() {
    }
}
