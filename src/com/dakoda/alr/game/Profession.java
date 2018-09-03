package com.dakoda.alr.game;

public enum Profession {

    DUELIST("Duelist"), // equivalent of a Warrior
    PALADIN("Paladin"), // self-explanatory
    ANTIQUAN("Antiquan"), // similar to Revenant from Guild Wars 2
                          // channels a legend or an emotion to the extreme
    PERFORATOR("Perforator"), // similar to Lancer in other MMOs

    ARCHER("Archer"), // self-explanatory
    ASSASSIN("Assassin"), //self-explanatory
    NAGUAL("Nagual"), // shape-shifter
    HUNTER("Hunter"), // similar to Archer, but specialises guns and tools
                      // think Van Helsing

    SHAMAN("Shaman"), // equivalent of a Mage/Wizard/Witch (with some abilities of Necromancer)
    PRIEST("Priest"), // healer
    CHRONOL("Chronol"), // specialises in time-bending abilities
                        // abilities that take time to do,
                        // reverting conditions, etc.
    BARD("Bard"); // self-explanatory

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