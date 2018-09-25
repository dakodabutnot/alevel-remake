package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.registrars.ContentRegistrar;
import com.dakoda.alr.game.world.item.type.Item_Generic;

public class ContentItem_Default extends ContentRegistrar {

    public void init() {
        //register Items here
        register(0, new Item_Generic()
                .withName("Zombie Brain")
                .withCurrencyValue(1)
        );
    }
}