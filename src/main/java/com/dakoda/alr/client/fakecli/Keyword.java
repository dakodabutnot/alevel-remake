package com.dakoda.alr.client.fakecli;

public enum Keyword {

    MAP("#ffff70"),
    INVENTORY("#a0ffff"),
    QUESTS("#a0ff00"),
    CHARACTER("#ffa0ab")

    ;

    private final String hex;

    Keyword(
            String hex
    ) {
        this.hex = hex;
    }

    public String hex() {
        return hex;
    }

    public enum Items {
        CONSUMABLE("#eaff2d"),
        WEAPON("#ff5230"),
        ARMOUR("#3dff7a"),
        MISC("#ff59e3"),

        ;

        private String hex;

        Items(
                String hex
        ) {
            this.hex = hex;
        }

        public String hex() {
            return hex;
        }
    }
}
