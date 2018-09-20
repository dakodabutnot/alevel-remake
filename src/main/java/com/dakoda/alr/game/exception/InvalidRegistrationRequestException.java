package com.dakoda.alr.game.exception;

public class InvalidRegistrationRequestException extends ALRGameException {

    public InvalidRegistrationRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRegistrationRequestException(String message) {
        super(message);
    }
}
