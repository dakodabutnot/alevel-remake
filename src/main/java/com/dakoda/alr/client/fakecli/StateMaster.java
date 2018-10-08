package com.dakoda.alr.client.fakecli;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Name;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Profession;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Race;
import com.dakoda.alr.client.fakecli.states.menu.GameState_Menu_Splash;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StateMaster {

    private static StateMaster INSTANCE = new StateMaster();
    public Stack<GameState> stateStack = new Stack<>();
    private GameState currentState = null;
    public static final Object stateWait = new Object();
    private String input = null;

    private static final ArrayList<GameState> allStates = new ArrayList<>();

    private StateMaster() {

    }

    public static void initStates() {
        StateInitializer.initStates(allStates);
    }

    public static ArrayList<GameState> getAllStates() {
        return allStates;
    }

    public GameState getCurrentState() {
        return currentState;
    }


    public static StateMaster instance() {
        return INSTANCE;
    }

    public void pushState(GameState s) {
        stateStack.push(s);
    }

    public GameState popState() {
        return stateStack.pop();
    }

    public GameState peekState() {
        return stateStack.peek();
    }

    public void stateLoop() {
        while (!isStackEmpty()) {
            currentState = stateStack.pop();
            TextRPG.debugMessage("#STATE | Popped next state");
            currentState.set();
            TextRPG.debugMessage("#STATE | Set initial state condition");
            while (currentState.active()) {
                Platform.runLater(() -> {
                    FCLIMaster.instance().fxMaster().fcliDisplay().flush();
                    currentState.printInfo();
                    currentState.printOptions();
                    FCLIMaster.instance().fxMaster().fcliDisplay().refresh();
                });
                synchronized (StateMaster.stateWait) {
                    try {
                        System.out.println("#STATE | Moved to state -> " + currentState.name());
                        stateWait.wait();
                        currentState.parseInput(input);
                        input = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void notifyWithString(String s) {
        input = s;
        synchronized (stateWait) {
            stateWait.notify();
        }
    }

    public boolean isStackEmpty() {
        return stateStack.empty() && currentState == null;
    }

    public GameState getState(String name) {
        return allStates.stream().filter(state -> state.name().equalsIgnoreCase(name)).findFirst().get();
    }
}
