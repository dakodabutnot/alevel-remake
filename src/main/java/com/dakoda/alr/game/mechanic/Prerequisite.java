package com.dakoda.alr.game.mechanic;

import java.io.Serializable;

@FunctionalInterface
public interface Prerequisite extends Serializable {

    boolean requirement();
}