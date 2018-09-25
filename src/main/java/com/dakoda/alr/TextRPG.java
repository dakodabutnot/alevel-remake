package com.dakoda.alr;

import com.dakoda.alr.client.cli.CLIMain;
import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.ContentMaster;
import com.dakoda.alr.content.registrars.base.*;
import com.dakoda.alr.game.GameMaster;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.item.Inventory;

public class TextRPG {

    public static GameMaster master = new GameMaster();

    public static void main(String[] args) {
        content();
        CLIMain.run();
    }

    public static void content() {
        //IMPORTANT
        //Game objects should be registered in this order:
        //  ITEM -> RECIPE -> ENTITY -> OTHER
        //Item registrars
        master.addContent(new ContentItem_Default());
        //Recipe registrars
        master.addContent(new ContentRecipe_Default());
        //Entity registrars
        master.addContent(new ContentEntity_Default());
        //Other registrars
        master.addContent(new ContentLocation_Default());
        master.addContent(new ContentQuest_Default());

        //temp player init
        master.playerInit("Player",
                new Making(),
                Progression.Profession.BARD,
                new Inventory()
                        .withCurrencyValue(10L)
        );
    }
}