package com.dakoda.alr.client.fakecli.state.states.charcreate;

import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.TextJumbos;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;

import java.io.IOException;
import java.util.Arrays;

import static com.dakoda.alr.client.fakecli.state.GameState.askForInput;
import static com.dakoda.alr.client.fakecli.state.GameState.master;
import static com.dakoda.alr.client.fakecli.state.GameState.print;
import static com.dakoda.alr.client.fakecli.state.states.charcreate.CharacterCreator.*;

public class CreateProfessionState implements GameState {

    private boolean active = false;

    public String name() {
        return "CHARACTER_CREATE_PROFESSION";
    }

    public void activate() throws IOException {
        this.active = true;
        loop();
    }

    public void deactivate() {
        this.active = false;
    }

    public void loop() throws IOException {
        while (active) {
            print(infoDisplay());
            print(optionsDisplay());
            validateInput(askForInput(this));
        }
    }

    public String infoDisplay() {
        return TextJumbos.CREATE_PROFESSION.value();
    }

    public String optionsDisplay() {
        return CreationOptions.PROFESSION.value();
    }

    public void validateInput(String input) {
        try {
            Progression.Profession selected = Arrays
                    .stream(Progression.Profession.values())
                    .filter(prof -> prof.name().equalsIgnoreCase(input)).findFirst().get();
            player.withMaking(new Making().withRace(player.making().getRace())).withProfession(selected);
            deactivate();
            master().flushStateAndPush(master().getState("PLAY"));
        } catch (Exception ignored) { }
    }

    public void swapState(GameState state) {

    }

    public void flushAndSwapState(GameState state) {

    }
}
