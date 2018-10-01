package com.dakoda.alr.client.fakecli.state.states.charcreate;

import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.TextJumbos;

import java.io.IOException;

import static com.dakoda.alr.client.fakecli.state.GameState.askForInput;
import static com.dakoda.alr.client.fakecli.state.GameState.print;
import static com.dakoda.alr.client.fakecli.state.states.charcreate.CharacterCreator.player;

public class CreateNameState implements GameState {

    private boolean active = false;

    public String name() {
        return "CHARACTER_CREATE_NAME";
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
        return TextJumbos.CREATE_NAME.value();
    }

    public String optionsDisplay() {
        return CreationOptions.NAME.value();
    }

    public void validateInput(String input) {
        if (input.length() >= 1) {
            player = player.withName(input);
            deactivate();
        }
    }

    public void swapState(GameState state) {

    }

    public void flushAndSwapState(GameState state) {

    }
}
