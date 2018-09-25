package com.dakoda.alr.client.cli.state;

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
