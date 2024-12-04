package com.Evenement.CrudWithMongoDB.Exceptions;


public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException() {
        super(ExceptionMessages.GUEST_NOT_FOUND.getMessage());
    }
}

