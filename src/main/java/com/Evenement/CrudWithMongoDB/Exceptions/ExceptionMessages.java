package com.Evenement.CrudWithMongoDB.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    EVENT_NOT_FOUND("Event not found"),
    GUEST_NOT_FOUND("GUEST not found");


    private final String message;


    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
