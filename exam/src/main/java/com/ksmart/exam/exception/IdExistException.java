package com.ksmart.exam.exception;

public class IdExistException extends RuntimeException {
    public IdExistException(String message) {
        super(message);
    }
}
