package com.dakoda.alr.content.registrars;

import com.dakoda.alr.game.world.item.type.ItemGeneric;

public class Registrar_Item extends Registrar {

    public void init() {
        //register Items here
        register(0, new ItemGeneric()
                .withName("Zombie Brain")
                .withCurrencyValue(1)
        );
    }
}