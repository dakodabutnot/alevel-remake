package com.dakoda.alr.game.character;

public class Discipline {

    private String name;
    private int level, experience, nextLevel;
    private boolean specialised;

    public enum Disciplines {

        // CRAFTING ---------------------------------------------------------
        CHEF("Chef",
                new Discipline("Chef")
                ),                   // cooking
        TAILOR("Tailor",
                new Discipline("Tailor")
                ),               // clothing (and light, medium armour)
        BLACKSMITH("Blacksmith",
                new Discipline("Blacksmith")
                ),       // metal weapons, heavy armour
        BOWYER("Bowyer",
                new Discipline("Bowyer")
                ),               // bows, crossbows
        ALCHEMIST("Alchemist",
                new Discipline("Alchemist")
                ),         // consumables
        CONJURSMITH("Conjursmith",
                new Discipline("Conjursmith")
                ),     // wands, staves
        // ------------------------------------------------------------------

        // HARVESTING -------------------------------------------------------
        FARMER("Farmer",
                new Discipline("Farmer")
                ),               // growing materials
        WORKER("Worker",
                new Discipline("Worker")
                ),               // harvesting natural materials
        MINER("Miner",
                new Discipline("Miner")
                ),                 // harvesting ores, specialty materials
        // ------------------------------------------------------------------

        // SPECIALISED DEVELOPMENT --------------------------------for: -----
        TACTICIAN("Tactician",
                new Discipline("Tactician", true)
                ),         // stratagem                (Duelist)
        SENTINEL("Sentinel",
                new Discipline("Sentinel", true)
                ),           // peacekeeping             (Paladin)
        HISTORIAN("Historian",
                 new Discipline("Historian", true)
                ),         // legend                   (Antiquer)
        HERALD("Herald",
                new Discipline("Herald", true)
                ),               // justice                  (Perforator)
        // -
        BOTANIST("Botanist",
                new Discipline("Botanist", true)
                ),           // nature                   (Archer)
        SHADOW("Shadow",
                new Discipline("Shadow", true)
                ),               // stealth                  (Assassin)
        GLAMOURIST("Glamourist",
                new Discipline("Glamourist", true)
                ),       // glamour                  (Nagual)
        PIONEER("Pioneer",
                new Discipline("Pioneer", true)
                ),             // invention                (Hunter)
        // -
        THANATOLOGIST("Thanatologist",
                new Discipline("Thanatologist", true)
                ), // death                    (Shaman)
        THEOLOGIAN("Theologian",
                new Discipline("Theologian", true)
                ),       // God                      (Priest)
        ORACLE("Oracle",
                new Discipline("Oracle", true)
                ),               // prophecy                 (Chronol)
        RADIOL("Radiol",
                new Discipline("Radiol", true)
                ),               // music                    (Bard)
        // ------------------------------------------------------------------

        // MISC -------------------------------------------------------------
        DIVINER("Diviner",
                new Discipline("Diviner")
                ),             // enchanting
        CARPENTER("Carpenter",
                new Discipline("Carpenter")
                ),         // furniture
        // ------------------------------------------------------------------

        ;

        private String displayText;
        private Discipline discipline;

        Disciplines(
                String displayText,
                Discipline discipline
        ) {
            this.displayText = displayText;
            this.discipline = discipline;
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
    }

    private Discipline(String name) {
        defaulted(name);
        this.nextLevel = 20;
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

    public Discipline(Object loadedDiscipline) {
        // TODO: 10/09/2018
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