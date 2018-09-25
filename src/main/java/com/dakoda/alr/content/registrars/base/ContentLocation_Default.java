package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.ContentRegistrar;
import com.dakoda.alr.game.world.location.type.Location_Settlement;

public class ContentLocation_Default extends ContentRegistrar {

    private Integer ID = 0;

    protected Integer ID() {
        return ID++;
    }

    public void init() {
        //register Locations here
        register(0, new Location_Settlement()
                .withName("Brighton")
                .withHostileEncounter(ContentFinder.findHostileByID(0))
        );
    }
}