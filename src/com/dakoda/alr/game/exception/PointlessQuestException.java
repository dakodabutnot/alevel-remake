package com.dakoda.alr.game.exception;

import com.dakoda.alr.game.exception.ALRGameException;

public class PointlessQuestException extends ALRGameException {

    public PointlessQuestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointlessQuestException(String message) {
        super(message);
    }
}
