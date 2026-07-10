package com.ankit.school_management.exception;

public class ExamNotFoundException
        extends RuntimeException {

    public ExamNotFoundException(
            String message) {

        super(message);
    }
}