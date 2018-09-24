package com.dakoda.alr.content.registrars;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.entity.type.Entity_Hostile;

public class Registrar_Entity extends Registrar {

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