package com.dakoda.alr.content.registrars;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.game.world.location.type.Location_Settlement;

public class Registrar_Location extends Registrar {

    public void init() {
        //register Locations here
        register(0, new Location_Settlement()
                .withName("Brighton")
                .withHostileEncounter(ContentFinder.findHostileByID(0))
        );
    }
}