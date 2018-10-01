package com.dakoda.alr.client.fakecli.state.states.battle;

import com.dakoda.alr.client.fakecli.state.GameState;

import java.io.IOException;

public class BattleEndState implements GameState {

    public String name() {
        return "BATTLE_END";
    }

    public void activate() throws IOException {

    }

    public void deactivate() {

    }

    public void loop() throws IOException {

    }

    public String infoDisplay() {
        return null;
    }

    public String optionsDisplay() {
        return null;
    }

    public void validateInput(String input) {

    }

    public void swapState(GameState state) {

    }

    public void flushAndSwapState(GameState state) {

    }
}
