package com.dakoda.alr.client.fakecli.states.play;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.client.fakecli.states.GameState;

import static com.dakoda.alr.TextRPG.master;
import static com.dakoda.alr.client.fakecli.states.GameState.findState;
import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_Play_Character implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private String name = "PLAY_CHARACTER";

    public void preloop() {

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
        print(new FCLITextBundle(
                new FCLIText(master.player.name(), true),
                new FCLIText("Level " + master.player.progression().currentLevel() + " "
                        + master.player.making().getRace().name() + " "
                        + master.player.progression().profession().name())
        ));
    }

    public void printOptions() {

    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        switch (currentInput) {
            case "\n":
            case "back":
            case "return":
            case "<":
                deactivate();
                break;
            default:
                reset();
                break;
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
