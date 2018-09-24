package com.dakoda.alr.game.world.recipe;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipe implements GameObject {

    private final Item finalItem;
    private HashMap<Item, Integer> criteria = new HashMap<>();

    public Recipe(Item finalItem) {
        this.finalItem = finalItem;
    }

    public Recipe withCriterium(Item item, Integer amount) {
        this.criteria.put(item, amount);
        return this;
    }

    public HashMap<Item, Integer> criteria() {
        return criteria;
    }

    public Item finalItem() {
        return finalItem;
    }

    public String name() {
        return finalItem.name();
    }

    public Type objectType() {
        return Type.RECIPE;
    }
}
