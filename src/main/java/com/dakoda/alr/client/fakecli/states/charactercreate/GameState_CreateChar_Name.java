package com.dakoda.alr.client.fakecli.states.charactercreate;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.TextJumbos;

import static com.dakoda.alr.client.fakecli.states.GameState.*;

public class GameState_CreateChar_Name implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private static final String name = "CREATE_CHARACTER_NAME";

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
        print(TextJumbos.CREATE_NAME.value());
    }

    public void printOptions() {
        print(CreationDescriptions.NAME.value());
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
