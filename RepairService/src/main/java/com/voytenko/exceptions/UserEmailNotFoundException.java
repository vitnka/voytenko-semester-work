package com.voytenko.exceptions;

public class UserEmailNotFoundException extends RuntimeException {

    public UserEmailNotFoundException(String clientEmail) {
        super("User with email " + clientEmail + " not found.");
    }

}
