package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.registrars.ContentRegistrar;
import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.entity.type.Entity_Hostile;

public class ContentEntity_Default extends ContentRegistrar {

    public void init() {
        //register Entities here
        //NPCs

        //Hostiles
        register(0, new Entity_Hostile()
                .withName("Zombie")
                .withLoot(new Loot()
                        .withDrop(ContentFinder.findItemByID(0), 1)
                )
        );
        //Merchants

    }
}