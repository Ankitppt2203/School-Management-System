package com.ankit.school_management.exception;

public class TeacherNotFoundException
        extends RuntimeException {

    public TeacherNotFoundException(
            String message) {

        super(message);
    }
}