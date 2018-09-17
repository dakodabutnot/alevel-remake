package com.dakoda.alr.game.battle;

import com.dakoda.alr.game.world.item.Item;

import java.util.HashMap;

public class Loot {

    private HashMap<Item, Integer> drops = new HashMap<>();

    public HashMap<Item, Integer> getDrops() {
        return drops;
    }

    public static final class Builder {

        HashMap<Item, Integer> drops = new HashMap<>();

        public Builder drop(Item item, Integer maximum) {
            this.drops.put(item, maximum);
            return this;
        }

        public Loot build() {
            Loot loot = new Loot();
            loot.drops = this.drops;
            return loot;
        }
    }
}
