package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.registrars.Registrar;
import com.dakoda.alr.game.world.item.type.ItemGeneric;

public class ContentItem_Default extends Registrar {

    public void init() {
        //register Items here
        register(0, new ItemGeneric()
                .withName("Zombie Brain")
                .withCurrencyValue(1)
        );
    }
}