package com.dakoda.alr.game.exception;

public class ALRGameException extends RuntimeException {

    public ALRGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ALRGameException(String message) {
        super(message);
    }
}
