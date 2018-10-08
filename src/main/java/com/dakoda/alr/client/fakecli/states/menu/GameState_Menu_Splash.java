package com.dakoda.alr.client.fakecli.states.menu;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.TextJumbos;

import static com.dakoda.alr.client.fakecli.states.GameState.findState;
import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_Menu_Splash implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private static final String name = "SPLASH";

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
        print(TextJumbos.SPLASH.value());
    }

    public void printOptions() {
        print(new FCLIOptionList(
                true,
                new FCLIText("Start", "#00ff00"),
                new FCLIText("Load", "#ffff00"),
                new FCLIText("Exit", "ff0000")
        ).getFinalTextBundle());
    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        switch(currentInput) {
            case "start":
                deactivateAndPushMultiple(
                        findState("CREATE_CHARACTER_PROFESSION"),
                        findState("CREATE_CHARACTER_RACE"),
                        findState("CREATE_CHARACTER_NAME")
                );
                break;
            case "load":
                deactivateAndPush(findState("LOAD_SAVE"));
                break;
            case "exit":
                deactivateAndPush(findState("EXIT"));
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

    public void deactivateAndPushMultiple(GameState ... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }

    public void activate() {
        this.active = true;
    }
}
