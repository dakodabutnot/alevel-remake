package com.dakoda.alr.client.fakecli.state.states.charcreate;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.Player;

public class CharacterCreator {

    public static Player player = new Player();

    static void finalise() {
        TextRPG.master.setPlayer(player);
    }
}
