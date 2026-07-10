package com.ankit.school_management.exception;

public class StudentNotFoundException
        extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}