package com.dakoda.alr.client.fakecli.state.states.charcreate;

import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.TextJumbos;
import com.dakoda.alr.game.world.entity.Making;

import java.io.IOException;

import static com.dakoda.alr.client.fakecli.state.GameState.askForInput;
import static com.dakoda.alr.client.fakecli.state.GameState.print;
import static com.dakoda.alr.client.fakecli.state.states.charcreate.CharacterCreator.player;

public class CreateRaceState implements GameState {

    private boolean active = false;

    public String name() {
        return "CHARACTER_CREATE_RACE";
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
        return TextJumbos.CREATE_RACE.value();
    }

    public String optionsDisplay() {
        return CreationOptions.RACE.value();
    }

    public void validateInput(String input) {
        switch (input.toLowerCase()) {
            case "human":
                if (player.making() == null) {
                    player.withMaking(new Making());
                }
                player.withMaking(new Making().withRace(Making.Race.HUMAN));
                deactivate();
            case "fendan":
                player.withMaking(new Making().withRace(Making.Race.FENDAN));
                deactivate();
            default:
        }
    }

    public void swapState(GameState state) {

    }

    public void flushAndSwapState(GameState state) {

    }
}
