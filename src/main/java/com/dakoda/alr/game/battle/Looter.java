package com.dakoda.alr.game.battle;

import com.dakoda.alr.game.world.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public interface Looter {

    /**
     * Returns an item chosen randomly from the drops available, based on the weight values
     * for each drop. Works flexibly based on weight values.
     * Weights of 1 and 5 will grant equal chances as weights of 5 and 25. (i.e. 1/6 for the 1, 5/6 for the 5)
     *
     * @param loot The loot item to take the drops from.
     * @return The randomly selected loot drop.
     */
    static Item getRandomDrop(Loot loot) {
        ArrayList<Weight> weights = new ArrayList<>();
        HashMap<Integer, Item> drops = new HashMap<>();
        Integer identifier = 1;
        for (Map.Entry<Item, Loot.Entry> entry : loot.drops().entrySet()) {
            drops.put(identifier, entry.getKey());
            for (int i = 0; i < entry.getValue().weight(); i++) {
                weights.add(new Weight(identifier));
            }
        }
        return drops.get(weights.get(new Random().nextInt(weights.size())).id);
    }

    class Weight {

        private Integer id;

        Weight(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Weight) {
                return ((Weight) obj).id.equals(this.id);
            } else {
                return false;
            }
        }
    }
}
