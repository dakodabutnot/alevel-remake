package com.dakoda.alr.game.mechanic;

import java.io.Serializable;

public interface Prerequisite extends Serializable {

    boolean requirement();
}