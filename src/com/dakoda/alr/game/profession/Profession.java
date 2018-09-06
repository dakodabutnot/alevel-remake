package com.dakoda.alr.game.profession;

public enum Profession {

    DUELIST("Duelist"), // equivalent of a Warrior
    PALADIN("Paladin"), // self-explanatory
    ANTIQUER("Antiquer"), // similar to Revenant from Guild Wars 2
                          // channels a legend or an emotion to the extreme
    PERFORATOR("Perforator"), // similar to Lancer in other MMOs

    ARCHER("Archer"), // self-explanatory
    ASSASSIN("Assassin"), //self-explanatory
    NAGUAL("Nagual"), // shape-shifter
    HUNTER("Hunter"), // similar to Archer, but specialises guns and tools
                      // think Van Helsing

    SHAMAN("Shaman"), // equivalent of a Mage/Wizard/Witch (with some abilities of Necromancer)
    PRIEST("Priest"), // healer
    CHRONOL("Chronol"), // turns back time, to the good old days
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