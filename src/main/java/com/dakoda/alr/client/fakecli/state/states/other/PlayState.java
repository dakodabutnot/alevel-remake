package com.dakoda.alr.client.fakecli.state.states.other;

import com.dakoda.alr.client.fakecli.state.GameState;

import java.io.IOException;

import static com.dakoda.alr.client.fakecli.state.GameState.askForInput;
import static com.dakoda.alr.client.fakecli.state.GameState.print;

public class PlayState implements GameState {

    private boolean active = false;

    public String name() {
        return "PLAY";
    }

    public void activate() throws IOException {
        active = true;
        loop();
    }

    public void deactivate() {
        active = false;
    }

    public void loop() throws IOException {
        while (active) {
            print(infoDisplay());
            print(optionsDisplay());
            validateInput(askForInput(this));
        }
    }

    public String infoDisplay() {
        return "PLAY";
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
