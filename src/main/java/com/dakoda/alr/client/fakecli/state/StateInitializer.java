package com.dakoda.alr.client.fakecli.state;

import com.dakoda.alr.client.fakecli.state.states.battle.BattleEndState;
import com.dakoda.alr.client.fakecli.state.states.battle.BattleState;
import com.dakoda.alr.client.fakecli.state.states.charcreate.*;
import com.dakoda.alr.client.fakecli.state.states.other.*;

import static com.dakoda.alr.TextRPG.stateMaster;

public interface StateInitializer {

    static void initialize() {
        GameState[] reg = {
                new SplashState(),
                new ShopState(),
                new PlayState(),
                new NPCState(),
                new InventoryState(),
                new BattleEndState(),
                new BattleState(),
                new CharacterCreationSequence(),
                new CreateNameState(),
                new CreateProfessionState(),
                new CreateRaceState()
        };
        for (GameState state : reg) {
            stateMaster.registerState(state);
        }
    }

}
