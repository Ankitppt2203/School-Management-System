package com.ankit.school_management.exception;

public class CourseNotFoundException
        extends RuntimeException {

    public CourseNotFoundException(
            String message) {

        super(message);
    }
}