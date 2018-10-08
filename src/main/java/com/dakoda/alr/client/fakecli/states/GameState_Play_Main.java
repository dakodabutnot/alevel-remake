package com.dakoda.alr.client.fakecli.states;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;

import static com.dakoda.alr.client.fakecli.states.GameState.findState;
import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_Play_Main implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private String name = "PLAY_MAIN";

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
        print("\n");
    }

    public void printOptions() {
        print(new FCLIOptionList(
                false,
                new FCLIText("map", "#ffff70"),
                new FCLIText("inventory", "#a0ffff"),
                new FCLIText("quests", "a0ff00"),
                new FCLIText("character", "#ffa0ab")
        ).getFinalTextBundle());
    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        switch(currentInput) {
            case "inventory":

            case "quests":

            case "character":
            default:
                reset();
                break;
        }
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void deactivateAndPush(GameState state) {
        this.active = false;
        FCLIMaster.instance().stateMaster().pushState(state);
    }

    public void deactivateAndPush(GameState ... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }

    public void retainAndPush(GameState state) {
        deactivateAndPush(
                findState(this.name),
                state
        );
    }

    public void retainAndPush(GameState ... states) {
        deactivateAndPush(findState(this.name));
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }

    public void activate() {
        this.active = true;
    }
}
