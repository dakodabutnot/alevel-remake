package com.dakoda.alr.client.fakecli.states.play;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.Keyword;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.states.GameState;

import static com.dakoda.alr.client.fakecli.states.GameState.findState;
import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_Play_Main implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private String name = "PLAY_MAIN";

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
        print("");
    }

    public void printOptions() {
        print(new FCLIOptionList(
                false,
                new FCLIText(Keyword.MAP.name().toLowerCase(), Keyword.MAP.hex()),
                new FCLIText(Keyword.INVENTORY.name().toLowerCase(), Keyword.INVENTORY.hex()),
                new FCLIText(Keyword.QUESTS.name().toLowerCase(), Keyword.QUESTS.hex()),
                new FCLIText(Keyword.CHARACTER.name().toLowerCase(), Keyword.CHARACTER.hex())
        ).getFinalTextBundle());
    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        switch(currentInput) {
            case "m":
            case "map":
                break;
            case "i":
            case "inv":
            case "inventory":
                retainAndPush(findState("PLAY_INVENTORY"));
                break;
            case "q":
            case "quest":
            case "quests":
                break;
            case "c":
            case "char":
            case "character":
                retainAndPush(findState("PLAY_CHARACTER"));
                break;
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
