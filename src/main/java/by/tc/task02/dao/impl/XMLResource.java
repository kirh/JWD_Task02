package by.tc.task02.dao.impl;


import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class XMLResource implements Closeable {

    private static final String BEFORE_OR_AFTER_TAG = "((?<=>)\\s*(?=<))|((?=<)|(?<=>))";

    private final Scanner resourceScanner;

    private boolean closed;

    XMLResource(Path path) throws IOException {
        resourceScanner = new Scanner(path);
        resourceScanner.useDelimiter(BEFORE_OR_AFTER_TAG);

    }

    boolean hasNext() {
        return resourceScanner.hasNext();
    }

    XMLToken next() {
        return new XMLToken(resourceScanner.next());
    }

    @Override
    public void close() {
        if (!closed) {
            resourceScanner.close();
            closed = true;
        }
    }
}
