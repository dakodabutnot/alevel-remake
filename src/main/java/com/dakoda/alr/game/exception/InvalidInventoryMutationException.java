package com.dakoda.alr.game.exception;

public class InvalidInventoryMutationException extends ALRGameException {

    public InvalidInventoryMutationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInventoryMutationException(String message) {
        super(message);
    }
}
