package com.dakoda.alr.game.character;

public class Progression {

    private Profession profession;

    private int level, experience, nextLevel;
    private int courage;
    private int dexterity;
    private int wisdom;
    private int charisma;
    private int luck;

    public Progression(Profession profession) {
        //defaults level 1
        this.profession = profession;
        assignBaseStats();
    }

    public Progression(Profession profession, Integer level) {
        this.profession = profession;
        assignBaseStats();
        scale(level);
    }

    private void scale(Integer level) {
        // TODO: 21/09/2018 scale based on level
    }

    private void assignBaseStats() {
        this.level = 1;
        this.experience = 0;
        this.nextLevel = 10;
        this.courage = profession().baseCourage();
        this.dexterity = profession().baseDexterity();
        this.wisdom = profession().baseWisdom();
        this.charisma = profession().baseCharisma();
        this.luck = profession().baseLuck();
    }

    public Profession profession() {
        return profession;
    }

    public int courage() {
        return courage;
    }

    public int dexterity() {
        return dexterity;
    }

    public int wisdom() {
        return wisdom;
    }

    public int charisma() {
        return charisma;
    }

    public int luck() {
        return luck;
    }

    public int currentLevel() {
        return level;
    }

    public int currentExperience() {
        return experience;
    }

    public int experienceToNextLevel() {
        return nextLevel;
    }
}
