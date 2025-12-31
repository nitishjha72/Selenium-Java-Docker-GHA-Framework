package com.nitish.qa.exceptions;

public class InvalidConfigurationException extends FrameworkException {
    public InvalidConfigurationException(String message) {
        super(message);
    }
    public InvalidConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
