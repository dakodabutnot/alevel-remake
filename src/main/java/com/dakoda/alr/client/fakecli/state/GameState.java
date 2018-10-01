package com.dakoda.alr.client.fakecli.state;

import com.dakoda.alr.TextRPG;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface GameState {

    String name();

    void activate() throws IOException;

    void deactivate();

    void loop() throws IOException;

    String infoDisplay();

    String optionsDisplay();

    void validateInput(String input);

    void swapState(GameState state);

    void flushAndSwapState(GameState state);

    static String askForInput(GameState state) throws IOException {
        TextRPG.askingForInput = state;
        while (!(TextRPG.entry.length() >= 1)) {

        }
        String returned = TextRPG.entry;
        TextRPG.clearWait();
        return TextRPG.entry;
    }

    static StateMaster master() {
        return TextRPG.stateMaster;
    }

    static void flushState() {
        master().flushState();
    }

    static void flushDisplay() {
        TextRPG.display.clear();
    }

    static void print(String string) {
        TextRPG.display.pushLine(string);
    }

    static void close() {

    }

    static void initialState(String state) {
        master().pushState(GameState.master().getState(state));

    }
}