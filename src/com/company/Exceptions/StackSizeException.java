package com.company.Exceptions;

public class StackSizeException extends Exception {
    public StackSizeException() {
        super();
    }

    public StackSizeException(String message) {
        super(message);
    }

    public StackSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
