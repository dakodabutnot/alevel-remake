package com.dakoda.alr.entity.player;
import com.dakoda.alr.entity.Entity;

public final class Player extends Entity {

    private Inventory inv;

    public Player() {

    }

    public Inventory inventory() {
        return inv;
    }
}
