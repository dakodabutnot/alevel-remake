package com.dakoda.alr.game.player;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.character.Progression;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

public final class Player implements Entity {

    private String name;
    private Making making;
    private Progression progression;
    private Inventory inventory;

    public GameObject.Type objectType() {
        return GameObject.Type.ENTITY;
    }

    public Player withName(String name) {
        this.name = name;
        return this;
    }

    public Player withMaking(Making making) {
        this.making = making;
        return this;
    }

    public Player withProfession(Progression.Profession profession) {
        this.progression = new Progression(profession);
        return this;
    }

    public Player withProfession(Progression.Profession profession, Integer level) {
        this.progression = new Progression(profession, level);
        return this;
    }

    public Player withInitialInventory(Inventory initialInventory) {
        this.inventory = initialInventory;
        return this;
    }

    public Player atLocation(Location location) {
        return this;
    }

    public Location location() {
        return TextRPG.master.currentLocation();
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
