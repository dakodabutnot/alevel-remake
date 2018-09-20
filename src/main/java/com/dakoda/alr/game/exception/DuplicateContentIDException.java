package com.dakoda.alr.game.exception;

public class DuplicateContentIDException extends ALRGameException {

    public DuplicateContentIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateContentIDException(String message) {
        super(message);
    }
}
