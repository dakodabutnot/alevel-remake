package com.dakoda.alr.client.cli.state;

/**
 * -> State pattern. <-
 *
 * Essentially the class can only have limited states.
 * In my example, only 'active' or 'inactive'.
 *
 * The behaviour of the class should change based on the state.
 * In my example, the menu screen won't be displayed
 * while in the inactive state.
 */
public class MenuState implements State {

    private boolean active = false;

    public String name() {
        return "MENU";
    }

    public void activate() {
        active = true;
        loop();
    }

    public void loop() {
        while (active) {

        }
    }

    public String mainUI() {
        return null;
    }

    public String optionUI() {
        return null;
    }

    public String getOptionInput() {
        return null;
    }

    public void deactivate() {
        active = false;
    }
}