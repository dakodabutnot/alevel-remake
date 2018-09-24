package com.dakoda.alr.game.world.location.type;

import com.dakoda.alr.game.world.entity.type.Entity_Hostile;
import com.dakoda.alr.game.world.entity.type.Entity_NPC;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.GameObject;

import java.util.HashSet;

import static com.dakoda.alr.game.world.location.Location.Type.ESTATE;

public class Location_Estate implements Location {

    private String name = "";
    private Boolean restable = false;
    private Boolean encounterable = false;
    private Integer level = -1;
    private Type type = ESTATE;
    private HashSet<Entity_Hostile> hostiles = null;
    private HashSet<Entity_NPC> NPCs = null;
    private HashSet<Location> linkedLocations = null;

    public GameObject.Type objectType() {
        return GameObject.Type.LOCATION;
    }

    public Location_Estate withName(String name) {
        this.name = name;
        return this;
    }

    public Location_Estate withLevel(Integer level) {
        return this;
    }

    public Location_Estate withHostileEncounter(Entity_Hostile hostile) {
        return this;
    }

    public Location_Estate asInn() {
        restable = true;
        return this;
    }

    public Location_Estate withNPC(Entity_NPC npc) {
        if (NPCs == null) NPCs = new HashSet<>();
        this.NPCs.add(npc);
        npc.atLocation(this);
        return this;
    }

    public Location_Estate linkedTo(Location location) {
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
            Location_Estate locObj = (Location_Estate) obj;
            return locObj.name().equals(name())
                    && locObj.type().equals(type());
        } catch (Exception e) {
            return false;
        }
    }
}
