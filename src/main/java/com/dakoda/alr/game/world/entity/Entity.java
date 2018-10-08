package com.dakoda.alr.game.world.entity;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.entity.Progression.Profession;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.Questable;

public interface Entity extends GameObject, Questable {

    String name();

    Making making();

    Type type();

    Progression progression();

    Location location();

    Entity withName(String name);

    Entity withMaking(Making making);

    Entity withProfession(Profession profession);

    Entity atLocation(Location location);

    enum Type {
        NPC, HOSTILE, MERCHANT, PLAYER
    }

}

