package com.dakoda.alr.game.exception;

public class NullEquipException extends ALRGameException {

    public NullEquipException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullEquipException(String message) {
        super(message);
    }
}
