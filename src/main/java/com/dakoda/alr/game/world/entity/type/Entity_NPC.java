package com.dakoda.alr.game.world.entity.type;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.Quest;

import java.util.ArrayList;

public class Entity_NPC implements Entity {

    String name;
    Making making;
    private Type type = Type.NPC;
    Progression progression;
    ArrayList<Quest> quests = new ArrayList<>();
    Location location;

    public GameObject.Type objectType() {
        return GameObject.Type.ENTITY;
    }

    public String name() {
        return name;
    }

    public Type type() {
        return type;
    }

    public Making making() {
        return making;
    }

    public Progression progression() {
        return progression;
    }

    public Location location() {
        return location;
    }

    public void registerQuest(Quest quest) {
        quests.add(quest);
    }

    public Entity_NPC withName(String name) {
        this.name = name;
        return this;
    }

    public Entity_NPC withMaking(Making making) {
        this.making = making;
        return this;
    }

    public Entity_NPC withProfession(Progression.Profession profession) {
        this.progression = new Progression(profession);
        return this;
    }

    public Entity_NPC atLocation(Location location) {
        this.location = location;
        location.withNPC(this);
        return this;
    }
}
