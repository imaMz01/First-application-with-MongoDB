package com.Evenement.CrudWithMongoDB.Exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException() {
        super(ExceptionMessages.EVENT_NOT_FOUND.getMessage());
    }
}
