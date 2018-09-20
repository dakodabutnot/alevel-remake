package com.dakoda.alr.game.exception;

public class NullItemRequestException extends ALRGameException {
    public NullItemRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullItemRequestException(String message) {
        super(message);
    }
}
