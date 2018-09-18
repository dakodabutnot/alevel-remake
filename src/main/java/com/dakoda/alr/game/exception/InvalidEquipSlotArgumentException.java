package com.dakoda.alr.game.exception;

public class InvalidEquipSlotArgumentException extends ALRGameException {

    public InvalidEquipSlotArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEquipSlotArgumentException(String message) {
        super(message);
    }
}
