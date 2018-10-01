package com.dakoda.alr.game.battle;

import com.dakoda.alr.game.world.item.Item;

import java.util.HashMap;

public class Loot {

    private HashMap<Item, Entry> drops = new HashMap<>();

    @SuppressWarnings("WeakerAccess")
    public HashMap<Item, Entry> drops() {
        return drops;
    }

    public Loot withDrop(Item item, Integer max, Integer weight) {
        this.drops.put(item, new Entry(max, weight));
        return this;
    }

    public Entry get(Item item) {
        return drops.get(item);
    }

    class Entry {

        private Integer max;
        private Integer weight;

        Entry(Integer max, Integer weight) {
            this.max = max;
            this.weight = weight;
        }

        public Integer max() {
            return max;
        }

        public Integer weight() {
            return weight;
        }
    }
}
