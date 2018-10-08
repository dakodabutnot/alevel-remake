package com.dakoda.alr.client.fakecli.states.charactercreate;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.TextJumbos;

import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_CreateChar_Race implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private static final String name = "CREATE_CHARACTER_RACE";

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
        if (currentInput.length() > 0) {
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

    public void deactivateAndPushMultiple(GameState ... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }
}
