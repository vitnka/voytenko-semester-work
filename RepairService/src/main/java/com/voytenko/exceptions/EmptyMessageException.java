package com.voytenko.exceptions;

public class EmptyMessageException extends RuntimeException {
    public EmptyMessageException() {
        super("You can't send empty message.");
    }

}
