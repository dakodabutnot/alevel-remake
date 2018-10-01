package com.dakoda.alr.client.fakecli.state;

import com.dakoda.alr.TextRPG;

import java.io.IOException;
import java.util.ArrayList;

public interface GameStateSequence extends GameState {

    String name();

    String sequencePrefix();

    ArrayList<String> sequence();

    void activate() throws IOException;

    void deactivate();

    void loop() throws IOException;

    void swapState(GameState state);

    void flushAndSwapState(GameState state);

    static StateMaster master() {
        return TextRPG.stateMaster;
    }

    static void flushState() {
        master().flushState();
    }

}
