package com.dakoda.alr.game.profession;

public enum Profession {

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

    Profession(
            String displayText
    ) {

        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}