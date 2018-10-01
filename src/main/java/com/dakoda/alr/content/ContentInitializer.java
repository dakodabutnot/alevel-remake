package com.dakoda.alr.content;

import com.dakoda.alr.content.registrars.base.*;
import com.dakoda.alr.game.GameMaster;

public interface ContentInitializer {

    static void initialize(GameMaster master) {
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
    }

}
