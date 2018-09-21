package com.dakoda.alr.game.battle;

import com.dakoda.alr.game.world.item.Item;

import java.util.HashMap;

public class Loot {

    private HashMap<Item, Integer> drops = new HashMap<>();

    public HashMap<Item, Integer> drops() {
        return drops;
    }

    public Loot withDrop(Item item, Integer max) {
        this.drops.put(item, max);
        return this;
    }
}
