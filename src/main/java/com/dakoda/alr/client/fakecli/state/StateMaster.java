package com.dakoda.alr.client.fakecli.state;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StateMaster {

    private Stack<GameState> stateStack = new Stack<>();
    private Set<GameState> states = new HashSet<>();

    public void registerState(GameState state) {
        states.add(state);
    }

    public void pushState(GameState state) {
        stateStack.push(state);
    }

    public void nextState() throws IOException {
        stateStack.pop().activate();
    }

    public void flushState() {
        stateStack.removeAllElements();
    }

    public void flushStateAndPush(GameState state) {
        flushState();
        pushState(state);
    }

    public boolean isStackEmpty() {
        return stateStack.empty();
    }

    private Set<GameState> states() {
        return states;
    }

    public GameState getState(String name) {
        try {
            return states().stream().filter(state -> state.name().equalsIgnoreCase(name)).findFirst().get();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
