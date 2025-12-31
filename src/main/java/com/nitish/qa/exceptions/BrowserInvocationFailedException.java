package com.nitish.qa.exceptions;

public final class BrowserInvocationFailedException extends FrameworkException {
    public BrowserInvocationFailedException(String message) {
        super(message);
    }

    public BrowserInvocationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
