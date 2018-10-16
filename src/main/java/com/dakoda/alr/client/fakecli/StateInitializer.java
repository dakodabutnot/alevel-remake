package com.dakoda.alr.client.fakecli;

import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.play.GameState_Play_Character;
import com.dakoda.alr.client.fakecli.states.play.inventory.GameState_Play_Inventory;
import com.dakoda.alr.client.fakecli.states.play.GameState_Play_Main;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Name;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Profession;
import com.dakoda.alr.client.fakecli.states.charactercreate.GameState_CreateChar_Race;
import com.dakoda.alr.client.fakecli.states.menu.GameState_Menu_Splash;

import java.util.ArrayList;
import java.util.Arrays;

public interface StateInitializer {

    static void initStates(ArrayList<GameState> allStates) {
        allStates.addAll(Arrays.asList(
                new GameState_Menu_Splash(),
                new GameState_CreateChar_Name(),
                new GameState_CreateChar_Race(),
                new GameState_CreateChar_Profession(),
                new GameState_Play_Main(),
                new GameState_Play_Character(),
                new GameState_Play_Inventory()
        ));
    }
}
