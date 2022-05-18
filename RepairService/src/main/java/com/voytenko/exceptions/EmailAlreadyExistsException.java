package com.voytenko.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("user with email " + email + " already exists.");
    }

}
