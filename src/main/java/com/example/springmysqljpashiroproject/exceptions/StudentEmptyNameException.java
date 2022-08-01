package com.example.springmysqljpashiroproject.exceptions;

public class StudentEmptyNameException extends RuntimeException{
    public StudentEmptyNameException(String message) {
        super(message);
    }
}
