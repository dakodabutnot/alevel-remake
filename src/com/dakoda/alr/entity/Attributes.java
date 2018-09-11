package com.dakoda.alr.entity;
import com.dakoda.alr.game.character.Profession;
import java.util.Arrays;

public class Attributes {

    private int courage;        // affects health,
    private int dexterity;      // affects speed, dodge chance
    private int wisdom;         // affects mana (or energy), spell (or skill) damage
    private int charisma;       // affects speech dialog success and likableness
    private int luck;           // affects chance of something good happening

    public Attributes(Profession.Type professionType) {
        Attributes b = Base.getProfessionBaseAttributes(professionType);
        this.courage = b.courage;
        this.dexterity = b.dexterity;
        this.wisdom = b.wisdom;
        this.charisma = b.charisma;
        this.luck = b.luck;
    }

    private Attributes(int c, int d, int w, int ch, int l) {
        this.courage = c;
        this.dexterity = d;
        this.wisdom = w;
        this.charisma = ch;
        this.luck = l;
    }

    private enum Base {
        //                            c  d  w  ch l
        DUELIST("Duelist",            7, 3, 1, 2, 2), // 15
        PALADIN("Paladin",            8, 2, 3, 1, 1), // 15
        ANTIQUER("Antiquer",          7, 2, 4, 1, 1), // 15
        PERFORATOR("Perforator",      9, 2, 1, 2, 1), // 15
        //                            c  d  w  ch l
        ARCHER("Archer",              3, 6, 2, 2, 2), // 15
        ASSASSIN("Assassin",          4, 7, 1, 1, 2), // 15
        NAGUAL("Nagual",              5, 6, 1, 1, 2), // 15
        HUNTER("Hunter",              1, 8, 2, 2, 2), // 15
        //                            c  d  w  ch l
        SHAMAN("Shaman",              3, 2, 7, 2, 1), // 15
        PRIEST("Priest",              2, 3, 7, 1, 2), // 15
        CHRONOL("Chronol",            2, 2, 8, 2, 1), // 15
        BARD("Bard",                  1, 3, 5, 3, 3); // 15

        private final String name;
        private final int courage;
        private final int dexterity;
        private final int wisdom;
        private final int charisma;
        private final int luck;

        Base(
                String name,
                int courage,
                int dexterity,
                int wisdom,
                int charisma,
                int luck
        ) {
            this.name = name;
            this.courage = courage;
            this.dexterity = dexterity;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.luck = luck;
        }

        public String getProfessionName() {
            return name;
        }

        public static Attributes getProfessionBaseAttributes(Profession.Type profession) {
            Attributes.Base baseAttr = Arrays.stream(Base.values())
                    .filter(base -> base.getProfessionName().equalsIgnoreCase(profession.getDisplayText()))
                    .findFirst().orElse(null);
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