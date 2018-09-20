package com.dakoda.alr.game.character;

public enum Profession {

    DUELIST     (7, 3, 1, 2, 2),
    PALADIN     (8, 2, 3, 1, 1),
    ANTIQUER    (7, 2, 4, 1, 1),
    PERFORATOR  (9, 2, 1, 2, 1),
    ARCHER      (3, 6, 2, 2, 2),
    ASSASSIN    (4, 7, 1, 1, 2),
    NAGUAL      (5, 6, 1, 1, 2),
    HUNTER      (1, 8, 2, 2, 2),
    SHAMAN      (3, 2, 7, 2, 1),
    PRIEST      (2, 3, 7, 1, 2),
    CHRONOL     (2, 2, 8, 2, 1),
    BARD        (1, 3, 5, 3, 3);

    private final int baseCourage;
    private final int baseDexterity;
    private final int baseWisdom;
    private final int baseCharisma;
    private final int baseLuck;

    Profession(
            int baseCourage,
            int baseDexterity,
            int baseWisdom,
            int baseCharisma,
            int baseLuck
    ) {

        this.baseCourage = baseCourage;
        this.baseDexterity = baseDexterity;
        this.baseWisdom = baseWisdom;
        this.baseCharisma = baseCharisma;
        this.baseLuck = baseLuck;
    }

    public int baseCourage() {
        return baseCourage;
    }

    public int baseDexterity() {
        return baseDexterity;
    }

    public int baseWisdom() {
        return baseWisdom;
    }

    public int baseCharisma() {
        return baseCharisma;
    }

    public int baseLuck() {
        return baseLuck;
    }
}