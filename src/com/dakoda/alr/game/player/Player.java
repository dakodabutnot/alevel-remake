package com.dakoda.alr.game.player;
import com.dakoda.alr.world.entity.Entity;

public final class Player extends Entity {

    private Inventory inv;

    public Player() {

    }

    public Inventory inventory() {
        return inv;
    }
}
