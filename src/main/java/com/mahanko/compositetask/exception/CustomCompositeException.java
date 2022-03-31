package com.mahanko.compositetask.exception;

public class CustomCompositeException extends Exception {
    public CustomCompositeException() {
    }

    public CustomCompositeException(String message) {
        super(message);
    }

    public CustomCompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomCompositeException(Throwable cause) {
        super(cause);
    }
}
