package com.dago.todo_api.exceptions;

public class UnableToProcessException extends RuntimeException {

    public UnableToProcessException(String message) {
        super(message);
    }
}
