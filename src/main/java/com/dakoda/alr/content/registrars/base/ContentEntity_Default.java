package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.ContentRegistrar;
import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.entity.type.Entity_Hostile;

public class ContentEntity_Default extends ContentRegistrar {

    private Integer ID = 0;

    protected Integer ID() {
        return ID++;
    }

    public void init() {
        npc();
        hostile();
        merchant();
    }

    private void npc() {

    }

    private void hostile() {
        register(0, new Entity_Hostile()
                .withName("Zombie")
                .withLoot(new Loot()
                        .withDrop(ContentFinder.findItemByID(0), 1, 1)
                )
        );
    }

    private void merchant() {

    }
}