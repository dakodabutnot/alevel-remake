package com.dakoda.alr.game.world.item.attribute;

public class ArmourMaterial {

    private String displayText;
    private ArmourWeight armourWeight;

    public static final ArmourMaterial NONE = new ArmourMaterial("", ArmourWeight.NONE);

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

        IRON(new ArmourMaterial("Iron", ArmourWeight.HEAVY)),
        STEEL(new ArmourMaterial("Steel", ArmourWeight.HEAVY)),
        DARKSTEEL(new ArmourMaterial("Darksteel", ArmourWeight.HEAVY)),
        TENACIUM(new ArmourMaterial("Tenacium", ArmourWeight.HEAVY)),
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

        HIDE(new ArmourMaterial("Hide", ArmourWeight.MEDIUM)),
        THIN_LEATHER(new ArmourMaterial("Thin Leather", ArmourWeight.MEDIUM)),
        RUGGED_LEATHER(new ArmourMaterial("Rugged Leather", ArmourWeight.MEDIUM)),
        HARDENED_LEATHER(new ArmourMaterial("Hardened Leather", ArmourWeight.MEDIUM)),
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

        COTTON(new ArmourMaterial("Cotton", ArmourWeight.LIGHT)),
        LINEN(new ArmourMaterial("Linen", ArmourWeight.LIGHT)),
        SILK(new ArmourMaterial("Silk", ArmourWeight.LIGHT)),
        GOSSAMER(new ArmourMaterial("Gossamer", ArmourWeight.LIGHT)),
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
