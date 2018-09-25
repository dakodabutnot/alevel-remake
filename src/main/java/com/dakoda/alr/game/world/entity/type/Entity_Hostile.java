package com.dakoda.alr.game.world.entity.type;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.location.Location;

public class Entity_Hostile implements Entity {

    private String name;
    private Type type = Type.HOSTILE;
    private Making making;
    private Progression progression;
    private Location location;
    private Loot loot;

    public GameObject.Type objectType() {
        return GameObject.Type.ENTITY;
    }

    public Loot loot() {
        return loot;
    }

    public Type type() {
        return type;
    }

    public String name() {
        return name;
    }

    public Making making() {
        return making;
    }

    public Progression progression() {
        return progression;
    }

    public Location location() {
        return null;
    }

    public Entity_Hostile withName(String name) {
        this.name = name;
        return this;
    }

    public Entity_Hostile withLoot(Loot loot) {
        this.loot = loot;
        return this;
    }


    public Entity_Hostile withMaking(Making making) {
        this.making = making;
        return this;
    }

    public Entity_Hostile withProfession(Progression.Profession profession) {
        this.progression = new Progression(profession);
        return this;
    }

    public Entity_Hostile atLocation(Location location) {
        return this;
    }
}
