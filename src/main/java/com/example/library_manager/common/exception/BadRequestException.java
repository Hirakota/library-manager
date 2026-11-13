package com.example.library_manager.common.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String name) {
        super(name);
    }
}
