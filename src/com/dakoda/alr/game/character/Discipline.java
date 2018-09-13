package com.dakoda.alr.game.character;
import java.util.Arrays;

public class Discipline {

    private String name;
    private int level, experience, nextLevel;
    private boolean specialised;

    public enum Disciplines {

        // CRAFTING ---------------------------------------------------------
        CHEF("Chef",
                new Discipline("Chef", false),
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
                Profession.Type.DUELIST
                ),         // stratagem
        SENTINEL("Sentinel",
                new Discipline("Sentinel", true),
                Profession.Type.PALADIN
                ),           // peacekeeping
        HISTORIAN("Historian",
                 new Discipline("Historian", true),
                Profession.Type.ANTIQUER
                ),         // legend
        HERALD("Herald",
                new Discipline("Herald", true),
                Profession.Type.PERFORATOR
                ),               // justice
        // -
        BOTANIST("Botanist",
                new Discipline("Botanist", true),
                Profession.Type.ARCHER
                ),           // nature
        SHADOW("Shadow",
                new Discipline("Shadow", true),
                Profession.Type.ASSASSIN
                ),               // stealth
        GLAMOURIST("Glamourist",
                new Discipline("Glamourist", true),
                Profession.Type.NAGUAL
                ),       // glamour
        PIONEER("Pioneer",
                new Discipline("Pioneer", true),
                Profession.Type.HUNTER
                ),             // invention
        // -
        THANATOLOGIST("Thanatologist",
                new Discipline("Thanatologist", true),
                Profession.Type.SHAMAN
                ), // death
        THEOLOGIAN("Theologian",
                new Discipline("Theologian", true),
                Profession.Type.PRIEST
                ),       // God
        ORACLE("Oracle",
                new Discipline("Oracle", true),
                Profession.Type.CHRONOL
                ),               // prophecy
        RADIOL("Radiol",
                new Discipline("Radiol", true),
                Profession.Type.BARD
                ),               // music
        // ------------------------------------------------------------------

        // MISC -------------------------------------------------------------
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
        private Profession.Type professionRequired;

        Disciplines(
                String displayText,
                Discipline discipline,
                Profession.Type professionRequired
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

        public Profession.Type getProfessionRequired() {
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

    public static Discipline.Disciplines getMatchingSpecialisedDiscipline(Profession.Type profession) {
        Disciplines fetch = Arrays.stream(Disciplines.values()).filter(entry -> entry.getProfessionRequired() == profession).findFirst().orElse(null);
        if (fetch != null) return fetch;
        throw new RuntimeException("A profession that you have defined in Profession.Type does not have its own specialised discipline. Make one.");
    }
}