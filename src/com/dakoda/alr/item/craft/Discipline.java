package com.dakoda.alr.item.craft;

public enum Discipline {

    // CRAFTING ---------------------------------------------------------
    CHEF("Chef"),                   // cooking
    TAILOR("Tailor"),               // clothing (and light, medium armour)
    BLACKSMITH("Blacksmith"),       // metal weapons, heavy armour
    BOWYER("Bowyer"),               // bows, crossbows
    ALCHEMIST("Alchemist"),         // consumables
    CONJURSMITH("Conjursmith"),     // wands, staves
    // ------------------------------------------------------------------

    // HARVESTING -------------------------------------------------------
    FARMER("Farmer"),               // growing materials
    WORKER("Worker"),               // harvesting natural materials
    MINER("Miner"),                 // harvesting ores, specialty materials
    // ------------------------------------------------------------------

    // SPECIALISED DEVELOPMENT --------------------------------for: -----
    TACTICIAN("Tactician"),         // stratagem                (Duelist)
    SENTINEL("Sentinel"),           // peacekeeping             (Paladin)
    HISTORIAN("Historian"),         // legend                   (Antiquer)
    HERALD("Herald"),               // justice                  (Perforator)
    // -
    BOTANIST("Botanist"),           // nature                   (Archer)
    SHADOW("Shadow"),               // stealth                  (Assassin)
    ANALYST("Analyst"),             // genes                    (Nagual)
    PIONEER("Pioneer"),             // invention                (Hunter)
    // -
    THANATOLOGIST("Thanatologist"), // death                    (Shaman)
    THEOLOGIAN("Theologian"),       // God                      (Priest)
    ORACLE("Oracle"),               // prophecy                 (Chronol)
    RADIOL("Radiol"),               // music                    (Bard)
    // ------------------------------------------------------------------

    // MISC -------------------------------------------------------------
    DIVINER("Diviner"),             // enchanting
    CARPENTER("Carpenter"),         // furniture
    // ------------------------------------------------------------------

    ;

    private String displayText;

    Discipline(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
