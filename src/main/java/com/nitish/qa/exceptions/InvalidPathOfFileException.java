package com.nitish.qa.exceptions;

public final class InvalidPathOfFileException extends FrameworkException {

    public InvalidPathOfFileException(String message) {
        super(message);
    }

    public InvalidPathOfFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
