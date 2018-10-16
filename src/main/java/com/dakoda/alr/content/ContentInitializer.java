package com.dakoda.alr.content;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.content.ContentRegistrar.Content_Default;
import com.dakoda.alr.content.registrars.base.*;
import com.dakoda.alr.game.GameMaster;

import static com.dakoda.alr.TextRPG.debugMessage;

public interface ContentInitializer {

    static void initialize(GameMaster master) {
        //IMPORTANT
        //Game objects should be registered in this order:
        //  ITEM -> RECIPE -> ENTITY -> OTHER
        //Default registrats
        divStart();
        master.addContent(new Content_Default());
        div("item");
        //Item registrars
        master.addContent(new ContentItem_Default());
        div("recipe");
        //Recipe registrars
        master.addContent(new ContentRecipe_Default());
        div("entitie");
        //Entity registrars
        master.addContent(new ContentEntity_Default());
        div("location");
        //Other registrars
        master.addContent(new ContentLocation_Default());
        div("quest");
        master.addContent(new ContentQuest_Default());
    }

    static void div(String next) {
        debugMessage("#REG | now for " + next + "s...");
    }

    static void divStart() {
        debugMessage("#REG | let's start building stuff, eh?");
    }

}
