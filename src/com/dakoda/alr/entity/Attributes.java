package com.dakoda.alr.entity;
import com.dakoda.alr.game.character.Profession;
import java.util.Arrays;

public class Attributes {

    private final Profession profession;

    private int courage;        // affects health,
    private int dexterity;      // affects speed, dodge chance
    private int wisdom;         // affects mana (or energy), spell (or skill) damage
    private int charisma;       // affects speech dialog success and likableness
    private int luck;           // affects chance of something good happening

    public Attributes(Profession profession) {
        this.profession = profession;
    }

    private Attributes(int c, int d, int w, int ch, int l) {
        this.courage = c;
        this.dexterity = d;
        this.wisdom = w;
        this.charisma = ch;
        this.luck = l;
        this.profession = null;
    }

    public Profession getProfession() {
        return profession;
    }

    private enum Base {
        //                                          c  d  w  ch l
        DUELIST(Profession.Type.DUELIST,            7, 3, 1, 2, 2), // 15
        PALADIN(Profession.Type.PALADIN,            8, 2, 3, 1, 1), // 15
        ANTIQUER(Profession.Type.ANTIQUER,          7, 2, 4, 1, 1), // 15
        PERFORATOR(Profession.Type.PERFORATOR,      9, 2, 1, 2, 1), // 15
        //                                          c  d  w  ch l
        ARCHER(Profession.Type.ARCHER,              3, 6, 2, 2, 2), // 15
        ASSASSIN(Profession.Type.ASSASSIN,          4, 7, 1, 1, 2), // 15
        NAGUAL(Profession.Type.NAGUAL,              5, 6, 1, 1, 2), // 15
        HUNTER(Profession.Type.HUNTER,              1, 8, 2, 2, 2), // 15
        //                                          c  d  w  ch l
        SHAMAN(Profession.Type.SHAMAN,              3, 2, 7, 2, 1), // 15
        PRIEST(Profession.Type.PRIEST,              2, 3, 7, 1, 2), // 15
        CHRONOL(Profession.Type.CHRONOL,            2, 2, 8, 2, 1), // 15
        BARD(Profession.Type.BARD,                  1, 3, 5, 3, 3); // 15

        private final Profession.Type profession;
        private final int courage;
        private final int dexterity;
        private final int wisdom;
        private final int charisma;
        private final int luck;

        Base(
                Profession.Type profession,
                int courage,
                int dexterity,
                int wisdom,
                int charisma,
                int luck
        ) {
            this.profession = profession;
            this.courage = courage;
            this.dexterity = dexterity;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.luck = luck;
        }

        public int getCourage() {
            return courage;
        }

        public int getDexterity() {
            return dexterity;
        }

        public int getWisdom() {
            return wisdom;
        }

        public int getCharisma() {
            return charisma;
        }

        public int getLuck() {
            return luck;
        }

        public Profession.Type getProfession() {
            return profession;
        }

        private Attributes getProfessionBaseAttributes(Profession.Type profession) {
            Attributes.Base baseAttr = Arrays.stream(Base.values()).filter(base -> base.getProfession() == profession).findFirst().orElse(null);
            try {
                return new Attributes(
                        baseAttr.courage,
                        baseAttr.dexterity,
                        baseAttr.wisdom,
                        baseAttr.charisma,
                        baseAttr.luck
                );
            } catch (NullPointerException e) {
                throw new RuntimeException("You tried to instantiate an Attributes class with null parameters.");
            }
        }
    }

    public int getCourage() {
        return courage;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getLuck() {
        return luck;
    }
}