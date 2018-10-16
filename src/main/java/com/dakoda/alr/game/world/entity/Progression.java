package com.dakoda.alr.game.world.entity;

import static com.dakoda.alr.game.world.entity.Progression.Profession.*;

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
        this.level = level;
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

    public enum Profession {

        DUELIST(7, 3, 1, 2, 2),
        PALADIN(8, 2, 3, 1, 1),
        ANTIQUER(7, 2, 4, 1, 1),
        PERFORATOR(9, 2, 1, 2, 1),

        ARCHER(3, 6, 2, 2, 2),
        ASSASSIN(4, 7, 1, 1, 2),
        NAGUAL(5, 6, 1, 1, 2),
        HUNTER(1, 8, 2, 2, 2),

        SHAMAN(3, 2, 7, 2, 1),
        PRIEST(2, 3, 7, 1, 2),
        CHRONOL(2, 2, 8, 2, 1),
        BARD(1, 3, 5, 3, 3);

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

    public static class Discipline {

        private String name;
        private int level, experience, nextLevel;
        private boolean specialised;

        public enum Disciplines {

            // CRAFTING ---------------------------------------------------------
            CHEF("Chef",
                    new Progression.Discipline("Chef", false),
                    null
            ),                   // cooking
            TAILOR("Tailor",
                    new Discipline("Tailor", false),
                    null
            ),               // clothing (and light, medium armour)
            BLACKSMITH("Blacksmith",
                    new Discipline("Blacksmith", false),
                    null
            ),       // metal weapons, heavy armour
            BOWYER("Bowyer",
                    new Discipline("Bowyer", false),
                    null
            ),               // bows, crossbows
            ALCHEMIST("Alchemist",
                    new Discipline("Alchemist", false),
                    null
            ),         // consumables
            CONJURSMITH("Conjursmith",
                    new Discipline("Conjursmith", false),
                    null
            ),     // wands, staves
            // ------------------------------------------------------------------

            // HARVESTING -------------------------------------------------------
            FARMER("Farmer",
                    new Discipline("Farmer", false),
                    null
            ),               // growing materials
            WORKER("Worker",
                    new Discipline("Worker", false),
                    null
            ),               // harvesting natural materials
            MINER("Miner",
                    new Discipline("Miner", false),
                    null
            ),                 // harvesting ores, specialty materials
            // ------------------------------------------------------------------

            // SPECIALISED DEVELOPMENT --------------------------------for: -----
            TACTICIAN("Tactician",
                    new Discipline("Tactician", true),
                    DUELIST
            ),         // stratagem
            SENTINEL("Sentinel",
                    new Discipline("Sentinel", true),
                    PALADIN
            ),           // peacekeeping
            HISTORIAN("Historian",
                    new Discipline("Historian", true),
                    ANTIQUER
            ),         // legend
            HERALD("Herald",
                    new Discipline("Herald", true),
                    PERFORATOR
            ),               // justice
            // -
            BOTANIST("Botanist",
                    new Discipline("Botanist", true),
                    ARCHER
            ),           // nature
            SHADOW("Shadow",
                    new Discipline("Shadow", true),
                    ASSASSIN
            ),               // stealth
            GLAMOURIST("Glamourist",
                    new Discipline("Glamourist", true),
                    NAGUAL
            ),       // glamour
            PIONEER("Pioneer",
                    new Discipline("Pioneer", true),
                    HUNTER
            ),             // invention
            // -
            THANATOLOGIST("Thanatologist",
                    new Discipline("Thanatologist", true),
                    SHAMAN
            ), // death
            THEOLOGIAN("Theologian",
                    new Discipline("Theologian", true),
                    PRIEST
            ),       // God
            ORACLE("Oracle",
                    new Discipline("Oracle", true),
                    CHRONOL
            ),               // prophecy
            RADIOL("Radiol",
                    new Discipline("Radiol", true),
                    BARD
            ),               // music
            // ------------------------------------------------------------------

            // MISCELLANEOUS -------------------------------------------------------------
            DIVINER("Diviner",
                    new Discipline("Diviner", false),
                    null
            ),             // enchanting
            CARPENTER("Carpenter",
                    new Discipline("Carpenter", false),
                    null
            ),         // furniture
            // ------------------------------------------------------------------

            ;

            private String displayText;
            private Discipline discipline;
            private Progression.Profession professionRequired;

            Disciplines(
                    String displayText,
                    Discipline discipline,
                    Progression.Profession professionRequired
            ) {
                this.displayText = displayText;
                this.discipline = discipline;
                this.professionRequired = professionRequired;
            }

            public String getDisplayText() {
                return displayText;
            }

            @Override
            public String toString() {
                return getDisplayText();
            }

            public Discipline get() {
                return discipline;
            }

            public Progression.Profession getProfessionRequired() {
                return professionRequired;
            }
        }

        private Discipline(String name, boolean specialised) {
            this.specialised = specialised;
            defaulted(name);
            this.nextLevel = specialised ? 50 : 20;
        }

        private void defaulted(String name) {
            this.name = name;
            this.experience = 0;
            this.level = 0;

        }

        public int getCurrentExperience() {
            return experience;
        }

        public int getCurrentLevel() {
            return level;
        }

        public int getExperienceToNextLevel() {
            return nextLevel;
        }

        public String getName() {
            return name;
        }

        public boolean isSpecialisedDiscipline() {
            return specialised;
        }
    }

    //ugly methods
    public void setLevel(Integer level) {
        this.level = level;
    }
}
