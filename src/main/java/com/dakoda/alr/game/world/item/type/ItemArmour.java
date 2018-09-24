package com.dakoda.alr.game.world.item.type;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;

import static com.dakoda.alr.game.world.item.type.ItemArmour.Weight.*;

public class ItemArmour implements Item {

    private String name;
    private Item.Type type = Item.Type.ARMOUR;
    private Integer currencyValue = 0;
    private Prerequisite prerequisite = null;
    private ItemArmour.Slot slot;
    private ItemArmour.Material material;

    public GameObject.Type objectType() {
        return GameObject.Type.ITEM;
    }

    public ItemArmour equippableOn(ItemArmour.Slot slot) {
        this.slot = slot;
        return this;
    }

    public ItemArmour withMaterial(ItemArmour.Material material) {
        this.material = material;
        return this;
    }

    public ItemArmour withName(String name) {
        this.name = name;
        return this;
    }

    public ItemArmour withCurrencyValue(Integer currencyValue) {
        this.currencyValue = currencyValue;
        return this;
    }

    public ItemArmour withUsagePrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public boolean meetsPrerequisite() {
        return prerequisite().requirement();
    }

    public Prerequisite prerequisite() {
        return prerequisite;
    }

    public ItemArmour.Slot slot() {
        return this.slot;
    }

    public ItemArmour.Material material() {
        return this.material;
    }

    public ItemArmour.Weight weight() {
        return this.material().weight;
    }

    public String name() {
        return name;
    }

    public Item.Type type() {
        return type;
    }

    public String description() {
        return "This item is used in combat to protect the wearer, and can only be equipped by certain professions.";
    }

    public String sellDescription() {
        return "This item sells for " + Currency.convertToUnits(currencyValue);
    }

    public Integer currencyValue() {
        return currencyValue;
    }

    public enum Slot {
        ANY, HEAD, SHOULDER, BACK, BODY, LEGS, FEET, HANDS, TRINKET, RING, NECKLACE
    }

    public static class Material {

        private String displayText;
        private ItemArmour.Weight weight;

        public static final ItemArmour.Material NONE = new ItemArmour.Material("", ItemArmour.Weight.NONE);

        private Material(String displayText, ItemArmour.Weight weight) {
            this.displayText = displayText;
            this.weight = weight;
        }

        public String getDisplayText() {
            return displayText;
        }

        public ItemArmour.Weight getWeight() {
            return weight;
        }

        enum Heavy {

            IRON(new ItemArmour.Material("Iron", HEAVY)),
            STEEL(new ItemArmour.Material("Steel", HEAVY)),
            DARKSTEEL(new ItemArmour.Material("Darksteel", HEAVY)),
            TENACIUM(new ItemArmour.Material("Tenacium", HEAVY)),
            ;

            private ItemArmour.Material material;

            Heavy(
                    ItemArmour.Material material
            ) {
                this.material = material;
            }

            public ItemArmour.Material getMaterial() {
                return material;
            }
        }

        public enum Medium {

            HIDE(new ItemArmour.Material("Hide", MEDIUM)),
            THIN_LEATHER(new ItemArmour.Material("Thin Leather", MEDIUM)),
            RUGGED_LEATHER(new ItemArmour.Material("Rugged Leather", MEDIUM)),
            HARDENED_LEATHER(new ItemArmour.Material("Hardened Leather", MEDIUM)),
            ;

            private ItemArmour.Material material;

            Medium(
                    ItemArmour.Material material
            ) {
                this.material = material;
            }

            public ItemArmour.Material getMaterial() {
                return material;
            }
        }

        public enum Light {

            COTTON(new ItemArmour.Material("Cotton", LIGHT)),
            LINEN(new ItemArmour.Material("Linen", LIGHT)),
            SILK(new ItemArmour.Material("Silk", LIGHT)),
            GOSSAMER(new ItemArmour.Material("Gossamer", LIGHT)),
            ;

            private ItemArmour.Material material;

            Light(
                    ItemArmour.Material material
            ) {
                this.material = material;
            }

            public ItemArmour.Material getMaterial() {
                return material;
            }
        }
    }

    public enum Weight {
        NONE, LIGHT, MEDIUM, HEAVY
    }
}
