package com.dakoda.alr.game.exception;

public class NullInventoryMutationException extends ALRGameException {

    public NullInventoryMutationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullInventoryMutationException(String message) {
        super(message);
    }
}
