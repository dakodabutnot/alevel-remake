package com.dakoda.alr.game.exception;

public class InvalidCurrencyChangeException extends ALRGameException {

    public InvalidCurrencyChangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCurrencyChangeException(String message) {
        super(message);
    }
}
