package com.dakoda.alr.game;

import com.dakoda.alr.content.ContentMaster;
import com.dakoda.alr.content.registrars.ContentRegistrar;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.location.LocationMaster;
import com.dakoda.alr.game.world.quest.QuestMaster;

public final class GameMaster {

    public ContentMaster content = new ContentMaster();
    public QuestMaster quest = new QuestMaster();
    public LocationMaster location = new LocationMaster();

    //Player
    public Player player = new Player();

    public void addContent(ContentRegistrar registrar) {
        registrar.init();
    }

    public void playerInit(
            String name, Making making, Progression.Profession profession, Inventory inventory
    ) {
        System.out.print("#PLAYER | building... -> ");
        player.withName(name)
                .withMaking(making)
                .withProfession(profession)
                .withInitialInventory(inventory);
        System.out.println("DONE!");
    }
}
