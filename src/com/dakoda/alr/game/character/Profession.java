package com.dakoda.alr.game.character;

public class Profession {

    private String name;
    private int level, experience, nextLevel;

    public Profession(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.nextLevel = 10;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLevel() {
        return level;
    }

    public int getCurrentExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return nextLevel;
    }

    public enum Type {

        // HEAVY ------------------------------------------------------------
        DUELIST("Duelist"),                             // combatant (Warrior)

        PALADIN("Paladin"),                             // protector of evil (Guardian from Guild Wars 2)

        ANTIQUER("Antiquer"),                           // channels a legend to gain power (Revenant from Guild Wars 2)

        PERFORATOR("Perforator"),                       // delivers justice (Lancer)
        // ------------------------------------------------------------------
        // MEDIUM -----------------------------------------------------------
        ARCHER("Archer"),                               // bows. pets. nature.

        ASSASSIN("Assassin"),                           // hides in the shadows, using stealth attacks and daggers.

        NAGUAL("Nagual"),                               // uses glamours to change appearance,
        // and create weapons from imagination.

        HUNTER("Hunter"),                               // similar to Archer, but specialises guns and tools
        // think Van Helsing
        // ------------------------------------------------------------------
        // LIGHT ------------------------------------------------------------
        SHAMAN("Shaman"),                               // pure magic

        PRIEST("Priest"),                               // power of God

        CHRONOL("Chronol"),                             // turns back time, to the good old days

        BARD("Bard");                                   // power of Music
        // ------------------------------------------------------------------

        private String displayText;

        Type(
                String displayText
        ) {

            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }
    }
}