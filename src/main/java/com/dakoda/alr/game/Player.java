package com.dakoda.alr.game;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

public class Player implements Entity {

    private static Player INSTANCE;

    private String name;
    private Making making;
    private Progression progression;
    private Inventory inventory;
    private boolean built = false;

    public Player() {

    }

    public static Player instance() {
        return INSTANCE;
    }

    public void finalise() {
        if (!built) {
            this.built = true;
            Player.INSTANCE = this;
        }
    }

    public GameObject.Type objectType() {
        return GameObject.Type.ENTITY;
    }

    public Player withName(String name) {
        if (!built) {
            this.name = name;
            return this;
        }
        return null;
    }

    public Player withMaking(Making making) {
        if (!built) {
            this.making = making;
            return this;
        }
        return null;
    }

    public Player withProfession(Progression.Profession profession) {
        if (!built) {
            this.progression = new Progression(profession);
            return this;
        }
        return null;
    }

    public Player withProfession(Progression.Profession profession, Integer level) {
        if (!built) {
            this.progression = new Progression(profession, level);
            return this;
        }
        return null;
    }

    public Player withInitialInventory(Inventory initialInventory) {
        if (!built) {
            this.inventory = initialInventory;
            return this;
        }
        return null;
    }

    public Player atLocation(Location location) {
        if (!built) {
            return this;
        }
        return null;
    }

    public Location location() {
        return TextRPG.master.location.currentLocation();
    }

    public Inventory inventory() {
        return inventory;
    }

    public String name() {
        return name;
    }

    public Making making() {
        return making;
    }

    public Type type() {
        return Type.PLAYER;
    }

    public Progression progression() {
        return progression;
    }

    // Prerequisite lovelies ----------------------------------------
    public boolean reqProfessionIs(Progression.Profession profession) {
        return progression.profession().equals(profession);
    }

    public boolean reqHasItem(Item item) {
        return inventory().hasItem(item);
    }

    public boolean reqIsLevel(Integer level) {
        return progression().currentLevel() >= level;
    }

    public boolean reqCourage(Integer value) {
        return progression().courage() >= value;
    }

    public boolean reqWisdom(Integer value) {
        return progression().wisdom() >= value;
    }

    public boolean reqDexterity(Integer value) {
        return progression().dexterity() >= value;
    }

    public boolean reqCharisma(Integer value) {
        return progression().charisma() >= value;
    }

    public boolean reqLuck(Integer value) {
        return progression().luck() >= value;
    }
}