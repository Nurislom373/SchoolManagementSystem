package org.khasanof.attendanceservice.exception.exceptions;

public class InvalidValidationException extends RuntimeException {
    public InvalidValidationException() {
    }

    public InvalidValidationException(String message) {
        super(message);
    }
}
