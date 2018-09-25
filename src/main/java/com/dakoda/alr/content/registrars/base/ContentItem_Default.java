package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentRegistrar;
import com.dakoda.alr.game.world.item.type.Item_Generic;

public class ContentItem_Default extends ContentRegistrar {

    private Integer ID = 0;

    protected Integer ID() {
        return ID++;
    }

    public void init() {
        generic();
        consumable();
        weapon();
        armour();
    }

    private void generic() {
        register(ID(), new Item_Generic()
                .withName("Zombie Brain")
                .withCurrencyValue(1)
        );
    }

    private void consumable() {

    }

    private void weapon() {

    }

    private void armour() {

    }
}