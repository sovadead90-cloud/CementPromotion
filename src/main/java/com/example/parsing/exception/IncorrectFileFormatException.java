package com.example.parsing.exception;

public class IncorrectFileFormatException extends RuntimeException {
    public IncorrectFileFormatException(String message) {
        super(message);
    }
}
