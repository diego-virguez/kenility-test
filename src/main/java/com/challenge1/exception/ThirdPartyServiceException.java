package com.challenge1.exception;

public class ThirdPartyServiceException extends RuntimeException {
    public ThirdPartyServiceException(String message) {
        super(message);
    }

    public ThirdPartyServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
