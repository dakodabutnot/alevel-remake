package com.dakoda.alr.game.world.item.attribute;
import static com.dakoda.alr.game.world.item.attribute.ArmourWeight.*;

public class ArmourMaterial {

    private String displayText;
    private ArmourWeight armourWeight;

    private ArmourMaterial(String displayText, ArmourWeight armourWeight) {
        this.displayText = displayText;
        this.armourWeight = armourWeight;
    }

    public String getDisplayText() {
        return displayText;
    }

    public ArmourWeight getArmourWeight() {
        return armourWeight;
    }

    public enum Heavy {

        IRON(new ArmourMaterial("Iron", HEAVY)),
        STEEL(new ArmourMaterial("Steel", HEAVY)),
        DARKSTEEL(new ArmourMaterial("Darksteel", HEAVY)),
        TENACIUM(new ArmourMaterial("Tenacium", HEAVY)),
        ;

        private ArmourMaterial material;

        Heavy(
                ArmourMaterial material
        ) {
            this.material = material;
        }

        public ArmourMaterial getMaterial() {
            return material;
        }
    }

    public enum Medium {

        HIDE(new ArmourMaterial("Hide", MEDIUM)),
        THIN_LEATHER(new ArmourMaterial("Thin Leather", MEDIUM)),
        RUGGED_LEATHER(new ArmourMaterial("Rugged Leather", MEDIUM)),
        HARDENED_LEATHER(new ArmourMaterial("Hardened Leather", MEDIUM)),
        ;

        private ArmourMaterial material;

        Medium(
                ArmourMaterial material
        ) {
            this.material = material;
        }

        public ArmourMaterial getMaterial() {
            return material;
        }
    }

    public enum Light {

        COTTON(new ArmourMaterial("Cotton", LIGHT)),
        LINEN(new ArmourMaterial("Linen", LIGHT)),
        SILK(new ArmourMaterial("Silk", LIGHT)),
        GOSSAMER(new ArmourMaterial("Gossamer", LIGHT)),
        ;

        private ArmourMaterial material;

        Light(
                ArmourMaterial material
        ) {
            this.material = material;
        }

        public ArmourMaterial getMaterial() {
            return material;
        }
    }
}
