package com.dakoda.alr.game;

import com.dakoda.alr.game.world.item.Inventory;

import static com.dakoda.alr.TextRPG.master;

public class PlayerInitializer {

    private static Player tempPlayer = null;

    public static void create() {
        tempPlayer = new Player();
    }

    public static Player player() {
        return tempPlayer;
    }

    public static Player newInventory() {
        tempPlayer = tempPlayer.withInitialInventory(new Inventory());
        return tempPlayer;
    }

    public static void modify(Player player) {
        tempPlayer = player;
    }

    public static void finalise() {
        tempPlayer.finalise();
        master.setPlayer(Player.instance());
    }
}
