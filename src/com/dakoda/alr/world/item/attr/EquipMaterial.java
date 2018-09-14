package com.dakoda.alr.world.item.attr;

import static com.dakoda.alr.world.item.attr.ArmourLevel.*;

public class EquipMaterial {

    public enum Heavy {

        IRON("Iron"),
        STEEL("Steel"),
        DARKSTEEL("Darksteel"),
        TENACIUM("Tenacium"),
        ;

        private String displayText;
        private ArmourLevel armourLevel;

        Heavy(
                String displayText
        ) {
            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }

        public ArmourLevel getArmourLevel() {
            return HEAVY;
        }
    }

    public enum Medium {

        HIDE("Hide"),
        THIN_LEATHER("Thin leather"),
        RUGGED_LEATHER("Rugged leather"),
        HARDENED_LEATHER("Hardened leather"),
        ;

        private String displayText;
        private ArmourLevel armourLevel;

        Medium(
                String displayText
        ) {
            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }

        public ArmourLevel getArmourLevel() {
            return MEDIUM;
        }
    }

    public enum Light {

        COTTON("Cotton"),
        LINEN("Linen"),
        SILK("Silk"),
        GOSSAMER("Gossamer"),
        ;

        private String displayText;
        private ArmourLevel armourLevel;

        Light(
                String displayText
        ) {
            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }

        public ArmourLevel getArmourLevel() {
            return MEDIUM;
        }
    }
}
