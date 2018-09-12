package com.dakoda.alr.game.character;

public class Profession {

    private Type type;
    private int level, experience, nextLevel;

    public Profession(Type type) {
        this.type = type;
        this.level = 1;
        this.experience = 0;
        this.nextLevel = 10;
    }

    public Type get() {
        return type;
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
        DUELIST("Duelist"),                             // combatant

        PALADIN("Paladin"),                             // protector of evil

        ANTIQUER("Antiquer"),                           // channels a legend to gain power

        PERFORATOR("Perforator"),                       // delivers justice
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