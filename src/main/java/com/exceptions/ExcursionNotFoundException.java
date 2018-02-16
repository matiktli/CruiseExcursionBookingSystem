package com.exceptions;

public class ExcursionNotFoundException extends RuntimeException {

    public ExcursionNotFoundException() {
    }

    public ExcursionNotFoundException(String message) {
        super(message);
    }
}
