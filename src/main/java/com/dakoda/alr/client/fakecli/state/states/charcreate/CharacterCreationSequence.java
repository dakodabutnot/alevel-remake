package com.dakoda.alr.client.fakecli.state.states.charcreate;

import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.GameStateSequence;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dakoda.alr.client.fakecli.state.GameState.flushDisplay;

public class CharacterCreationSequence implements GameStateSequence {

    private ArrayList<String> sequence = new ArrayList<>(Arrays.asList(
            "PROFESSION", "RACE", "NAME"
    ));
    private boolean active = false;

    public String name() {
        return "CHARACTER_CREATE_ROOT";
    }

    public String sequencePrefix() {
        return "CHARACTER_CREATE_";
    }

    public ArrayList<String> sequence() {
        return sequence;
    }

    public void activate() {
        active = true;
        loop();
    }

    public void deactivate() {
        active = false;
    }

    public void loop() {
        while (active) {
            for (String state : sequence) {
                swapState(GameState.master().getState(sequencePrefix() + state));
            }
            deactivate();
        }
    }

    public String infoDisplay() {
        return "info";
    }

    public String optionsDisplay() {
        return "options";
    }

    public void validateInput(String input) {

    }

    public void swapState(GameState state) {
        deactivate();
        flushDisplay();
        GameStateSequence.master().pushState(state);
    }

    public void flushAndSwapState(GameState state) {
        deactivate();
        flushDisplay();
        GameStateSequence.flushState();
        GameState.master().pushState(state);
    }
}
