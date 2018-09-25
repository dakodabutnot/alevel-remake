package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.registrars.Registrar;
import com.dakoda.alr.game.world.location.type.Location_Settlement;

public class ContentLocation_Default extends Registrar {

    public void init() {
        //register Locations here
        register(0, new Location_Settlement()
                .withName("Brighton")
                .withHostileEncounter(ContentFinder.findHostileByID(0))
        );
    }
}