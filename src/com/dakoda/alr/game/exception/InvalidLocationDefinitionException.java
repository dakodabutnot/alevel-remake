package com.dakoda.alr.game.exception;

import com.dakoda.alr.game.exception.ALRGameException;

public class InvalidLocationDefinitionException extends ALRGameException {

    public InvalidLocationDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLocationDefinitionException(String message) {
        super(message);
    }

}