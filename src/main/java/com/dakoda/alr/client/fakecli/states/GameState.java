package com.dakoda.alr.client.fakecli.states;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.client.fakecli.components.FCLIText;

import java.util.ArrayList;

public interface GameState {

    void reset();

    String name();

    void set();

    boolean active();

    void printInfo();

    void printOptions();

    void parseInput(String s);

    void triggerInputValidation();

    String getCurrentInput();

    void deactivateAndPush(GameState state);

    void activate();

    static void print(String s) {
        FCLIMaster.instance().fxMaster().fcliDisplay().pushLine(s);
    }

    static void print(String s, String colour) {
        FCLIMaster.instance().fxMaster().fcliDisplay().pushLine(s, colour);
    }

    static void print(FCLIText fcliText) {
        FCLIMaster.instance().fxMaster().fcliDisplay().pushLine(fcliText.toString(), fcliText.getColour());
    }

    static void print(FCLITextBundle fcliTextBundle) {
        for (FCLIText text : fcliTextBundle.getTexts()) {
            print(text);
        }
    }

    static void print(ArrayList<FCLITextBundle> fcliTextBundles) {
        for (FCLITextBundle fcliTextBundle : fcliTextBundles) {
            print(fcliTextBundle);
        }
    }

    static GameState findState(String name) {
        return FCLIMaster.instance().stateMaster().getState(name);
    }
}
