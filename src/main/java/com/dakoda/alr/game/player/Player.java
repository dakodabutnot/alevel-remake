package com.dakoda.alr.game.player;
import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.character.Inventory;
import com.dakoda.alr.game.character.Profession;
import com.dakoda.alr.game.character.Progression;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

public final class Player implements Entity {

    private String name;
    private Making making;
    private Progression progression;
    private Inventory inv;

    public Player withName(String name) {
        this.name = name;
        return this;
    }

    public Player withMaking(Making making) {
        this.making = making;
        return this;
    }


    public Player withProfession(Profession profession) {
        this.progression = new Progression(profession);
        return this;
    }

    public Player atLocation(Location location) {
        return this;
    }

    public Location location() {
        return TextRPG.master.currentLocation();
    }

    public Inventory inventory() {
        return inv;
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

    // Prerequisite lovelies ----------------------------------------
    public boolean reqProfessionIs(Profession profession) {
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
