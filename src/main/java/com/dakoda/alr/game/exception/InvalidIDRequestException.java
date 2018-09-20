package com.dakoda.alr.game.exception;

public class InvalidIDRequestException extends ALRGameException {

    public InvalidIDRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIDRequestException(String message) {
        super(message);
    }
}
