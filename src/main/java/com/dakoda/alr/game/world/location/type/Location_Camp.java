package com.dakoda.alr.game.world.location.type;

import com.dakoda.alr.game.world.entity.type.Entity_Hostile;
import com.dakoda.alr.game.world.entity.type.Entity_NPC;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.GameObject;

import java.util.HashSet;

import static com.dakoda.alr.game.world.location.Location.Type.ESTATE;

public class Location_Camp implements Location {

    private String name = "";
    private Boolean restable = true;
    private Boolean encounterable = true;
    private Integer level = -1;
    private Type type = ESTATE;
    private HashSet<Entity_Hostile> hostiles = null;
    private HashSet<Entity_NPC> NPCs = null;
    private HashSet<Location> linkedLocations = null;

    public GameObject.Type objectType() {
        return GameObject.Type.LOCATION;
    }

    public Location_Camp withName(String name) {
        this.name = name;
        return this;
    }

    public Location_Camp withLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Location_Camp withHostileEncounter(Entity_Hostile hostile) {
        if (hostiles == null) hostiles = new HashSet<>();
        this.hostiles.add(hostile);
        return this;
    }

    public Location_Camp withNPC(Entity_NPC npc) {
        if (NPCs == null) NPCs = new HashSet<>();
        this.NPCs.add(npc);
        npc.atLocation(this);
        return this;
    }

    public Location_Camp linkedTo(Location location) {
        if (linkedLocations == null) linkedLocations = new HashSet<>();
        this.linkedLocations.add(location);
        location.linkedTo(this);
        return this;
    }

    public String name() {
        return name;
    }

    public Boolean restable() {
        return restable;
    }

    public Boolean encounterable() {
        return encounterable;
    }

    public Integer level() {
        return level;
    }

    public Type type() {
        return type;
    }

    public HashSet<Entity_Hostile> hostiles() {
        return hostiles;
    }

    public HashSet<Entity_NPC> NPCs() {
        return NPCs;
    }

    public HashSet<Location> linkedLocations() {
        return linkedLocations;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Location_Camp locObj = (Location_Camp) obj;
            return locObj.name().equals(name())
                    && locObj.type().equals(type());
        } catch (Exception e) {
            return false;
        }
    }
}
