package com.example.springmysqljpashiroproject.exceptions;

public class StudentNotExistException extends RuntimeException{

    public StudentNotExistException(String message) {
        super(message);
    }
}
