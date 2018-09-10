package com.dakoda.alr.entity;
import com.dakoda.alr.game.character.Profession;

public class EntityStats {

    private final Profession profession;

    private int courage; // affects health,
    private int dexterity; // affects speed, dodge chance
    private int wisdom; // affects mana (or energy), spell (or skill) damage
    private int charisma; // affects speech dialog success and likableness
    private int luck; // affects chance of fortitude

    private void loadBaseStats() {
        // TODO: 09/09/2018 ProfessionBaseStat
    }

    public EntityStats(Profession profession) {
        this.profession = profession;
        loadBaseStats();
    }

    public Profession getProfession() {
        return profession;
    }
}