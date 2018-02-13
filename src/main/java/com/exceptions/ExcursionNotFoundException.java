package com.exceptions;

public class ExcursionNotFoundException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcursionNotFoundException(String message) {
        super(String.format("Excursion with id/port_id: ( %s ) not exist",message));
    }
}
