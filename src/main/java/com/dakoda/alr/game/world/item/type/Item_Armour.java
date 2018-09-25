package com.dakoda.alr.game.world.item.type;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;

import static com.dakoda.alr.game.world.item.type.Item_Armour.Weight.*;

public class Item_Armour implements Item {

    private String name;
    private Item.Type type = Item.Type.ARMOUR;
    private Integer currencyValue = 0;
    private Prerequisite prerequisite = null;
    private Item_Armour.Slot slot;
    private Item_Armour.Material material;

    public GameObject.Type objectType() {
        return GameObject.Type.ITEM;
    }

    public Item_Armour equippableOn(Item_Armour.Slot slot) {
        this.slot = slot;
        return this;
    }

    public Item_Armour withMaterial(Item_Armour.Material material) {
        this.material = material;
        return this;
    }

    public Item_Armour withName(String name) {
        this.name = name;
        return this;
    }

    public Item_Armour withCurrencyValue(Integer currencyValue) {
        this.currencyValue = currencyValue;
        return this;
    }

    public Item_Armour withUsagePrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public boolean meetsPrerequisite() {
        return prerequisite().requirement();
    }

    public Prerequisite prerequisite() {
        return prerequisite;
    }

    public Item_Armour.Slot slot() {
        return this.slot;
    }

    public Item_Armour.Material material() {
        return this.material;
    }

    public Item_Armour.Weight weight() {
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
        private Item_Armour.Weight weight;

        public static final Item_Armour.Material NONE = new Item_Armour.Material("", Item_Armour.Weight.NONE);

        private Material(String displayText, Item_Armour.Weight weight) {
            this.displayText = displayText;
            this.weight = weight;
        }

        public String getDisplayText() {
            return displayText;
        }

        public Item_Armour.Weight getWeight() {
            return weight;
        }

        enum Heavy {

            IRON(new Item_Armour.Material("Iron", HEAVY)),
            STEEL(new Item_Armour.Material("Steel", HEAVY)),
            DARKSTEEL(new Item_Armour.Material("Darksteel", HEAVY)),
            TENACIUM(new Item_Armour.Material("Tenacium", HEAVY)),
            ;

            private Item_Armour.Material material;

            Heavy(
                    Item_Armour.Material material
            ) {
                this.material = material;
            }

            public Item_Armour.Material getMaterial() {
                return material;
            }
        }

        public enum Medium {

            HIDE(new Item_Armour.Material("Hide", MEDIUM)),
            THIN_LEATHER(new Item_Armour.Material("Thin Leather", MEDIUM)),
            RUGGED_LEATHER(new Item_Armour.Material("Rugged Leather", MEDIUM)),
            HARDENED_LEATHER(new Item_Armour.Material("Hardened Leather", MEDIUM)),
            ;

            private Item_Armour.Material material;

            Medium(
                    Item_Armour.Material material
            ) {
                this.material = material;
            }

            public Item_Armour.Material getMaterial() {
                return material;
            }
        }

        public enum Light {

            COTTON(new Item_Armour.Material("Cotton", LIGHT)),
            LINEN(new Item_Armour.Material("Linen", LIGHT)),
            SILK(new Item_Armour.Material("Silk", LIGHT)),
            GOSSAMER(new Item_Armour.Material("Gossamer", LIGHT)),
            ;

            private Item_Armour.Material material;

            Light(
                    Item_Armour.Material material
            ) {
                this.material = material;
            }

            public Item_Armour.Material getMaterial() {
                return material;
            }
        }
    }

    public enum Weight {
        NONE, LIGHT, MEDIUM, HEAVY
    }
}
