package com.dakoda.alr.client.cli.state;

public interface State {

    String name();

    void activate();

    void deactivate();

    void loop();

    String mainUI();

    String optionUI();

    String getOptionInput();
}