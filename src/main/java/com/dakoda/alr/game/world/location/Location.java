package com.dakoda.alr.game.world.location;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.entity.type.Entity_Hostile;
import com.dakoda.alr.game.world.entity.type.Entity_NPC;
import com.dakoda.alr.game.world.quest.Questable;

import java.util.HashSet;

@SuppressWarnings("UnusedReturnValue")
public interface Location extends Questable, GameObject {

    Location withName(String name);

    Location withLevel(Integer level);

    Location withHostileEncounter(Entity_Hostile hostile);

    Location withNPC(Entity_NPC npc);

    Location linkedTo(Location location);

    String name();

    Boolean restable();

    Boolean encounterable();

    Integer level();

    Type type();

    HashSet<Entity_Hostile> hostiles();

    HashSet<Entity_NPC> NPCs();

    HashSet<Location> linkedLocations();

    enum Type {
        FIELD, SETTLEMENT, ESTATE, CAMP
    }

}
