package com.ankit.school_management.exception;

public class ResultNotFoundException
        extends RuntimeException {

    public ResultNotFoundException(
            String message) {

        super(message);
    }
}