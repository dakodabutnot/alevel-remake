package com.dakoda.alr.client.fakecli.states.charactercreate;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.TextJumbos;
import com.dakoda.alr.game.Player;
import com.dakoda.alr.game.PlayerInitializer;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;

import java.util.Arrays;

import static com.dakoda.alr.client.fakecli.states.GameState.print;
import static com.dakoda.alr.game.PlayerInitializer.*;

public class GameState_CreateChar_Race implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private static final String name = "CREATE_CHARACTER_RACE";

    public void preloop() {
        modify(player().withMaking(new Making()));
    }

    public String name() {
        return name;
    }

    public void reset() {
        currentInput = "";
    }

    public void set() {
        this.active = true;
        reset();
    }

    public boolean active() {
        return active;
    }

    public void printInfo() {
        print(TextJumbos.CREATE_RACE.value());
        print(CreationDescriptions.RACE.value());
    }

    public void printOptions() {
        print(new FCLIOptionList(
                true,
                new FCLIText("Human", "#c0ff00"),
                new FCLIText("Fendan", "#00ff00")
        ).getFinalTextBundle());
    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        Making.Race r = Arrays.stream(Making.Race.values())
                .filter(race -> race.name().equalsIgnoreCase(currentInput)).findFirst().orElse(null);
        if (r != null) {
            player().setRace(r);
            deactivate();
        }
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void deactivate() {
        this.active = false;
    }

    public void deactivateAndPush(GameState state) {
        this.active = false;
        FCLIMaster.instance().stateMaster().pushState(state);
    }

    public void activate() {
        this.active = true;
    }

    public void deactivateAndPushMultiple(GameState... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }
}
