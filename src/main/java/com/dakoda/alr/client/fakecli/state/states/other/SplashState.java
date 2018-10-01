package com.dakoda.alr.client.fakecli.state.states.other;

import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.TextJumbos;

import java.io.IOException;

import static com.dakoda.alr.client.fakecli.state.GameState.*;

/**
 * -> GameState pattern. <-
 * <p>
 * Essentially the class can only have limited states.
 * In my example, only 'active' or 'inactive'.
 * <p>
 * The behaviour of the class should change based on the state.
 * In my example, the other screen won't be displayed
 * while in the inactive state. VERY SIMPLE EXAMPLE.
 */
public class SplashState implements GameState {

    private boolean active = false;

    public String name() {
        return "SPLASH";
    }

    public void activate() throws IOException {
        active = true;
        loop();
    }

    public void loop() throws IOException {
        while (active) {
            print(infoDisplay());
            print(optionsDisplay());
            validateInput(askForInput(this));
        }
    }

    public String infoDisplay() {
        return TextJumbos.SPLASH.value();
    }

    public String optionsDisplay() {
        return  "|> Start\n" +
                "|> Load\n" +
                "|> Exit\n" +
                " -> ";
    }

    public void validateInput(String input) {
        switch (input.toLowerCase()) {
            case "start":
                swapState(master().getState("CHARACTER_CREATE_ROOT"));
                break;
            case "load":
                swapState(master().getState("SPLASH"));
                break;
            case "exit":
                deactivate();
                break;
        }
    }

    public void swapState(GameState state) {
        deactivate();
        master().pushState(state);
    }

    public void flushAndSwapState(GameState state) {
        deactivate();
        master().flushStateAndPush(state);
    }

    public void deactivate() {
        active = false;
    }
}