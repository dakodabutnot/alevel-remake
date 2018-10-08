package com.dakoda.alr.client.fakecli;

import com.dakoda.alr.client.fakecli.states.GameState;

public class FCLIMaster {

    private boolean playing = false;
    private static FCLIMaster INSTANCE = new FCLIMaster();
    private StateMaster stateMaster = StateMaster.instance();
    private FXMaster fxMaster = FXMaster.instance();

    private FCLIMaster() {

    }

    public void initialize(GameState state) {
        StateMaster.initStates();
        stateMaster.pushState(state);
        playing = true;
        Thread gameThread = new Thread(this::loop);
        gameThread.start();
    }

    public void loop() {
        while (playing) {
            stateMaster.stateLoop();
            if (stateMaster.isStackEmpty()) {
                playing = false;
            } else {
                throw new RuntimeException("State loop exited without the state stack being emptied.");
            }
        }
    }

    public static FCLIMaster instance() {
        return INSTANCE;
    }

    public void parseInput(String inp) {

    }

    public StateMaster stateMaster() {
        return stateMaster;
    }

    public FXMaster fxMaster() {
        return fxMaster;
    }
}
