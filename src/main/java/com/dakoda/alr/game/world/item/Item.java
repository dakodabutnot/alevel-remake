package com.dakoda.alr.game.world.item;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.registrar.Prerequisite;
import com.dakoda.alr.game.world.character.Progression.Profession;
import com.dakoda.alr.game.world.quest.Questable;
import com.dakoda.alr.registrar.GameObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.dakoda.alr.game.world.character.Progression.Profession.*;
import static com.dakoda.alr.game.world.item.Item.Armour.Weight.*;

public interface Item extends Questable, GameObject {

    String name();

    Type type();

    String description();

    String sellDescription();

    Integer currencyValue();

    Prerequisite prerequisite();

    Item withName(String name);

    Item withCurrencyValue(Integer currencyValue);

    Item withUsagePrerequisite(Prerequisite prerequisite);

    boolean meetsPrerequisite();

    enum Type {
        GENERIC, ARMOUR, WEAPON, CONSUMABLE
    }

    class Armour implements Item {

        String name;
        Item.Type type = Item.Type.ARMOUR;
        Integer currencyValue = 0;
        Prerequisite prerequisite = null;
        Slot slot;
        Material material;

        public GameObject.Type objectType() {
            return GameObject.Type.ITEM;
        }

        public Armour equippableOn(Slot slot) {
            this.slot = slot;
            return this;
        }

        public Armour withMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Armour withName(String name) {
            this.name = name;
            return this;
        }

        public Armour withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public Armour withUsagePrerequisite(Prerequisite prerequisite) {
            this.prerequisite = prerequisite;
            return this;
        }

        public boolean meetsPrerequisite() {
            return prerequisite().requirement();
        }

        public Prerequisite prerequisite() {
            return prerequisite;
        }

        public Slot slot() {
            return this.slot;
        }

        public Material material() {
            return this.material;
        }

        public Weight weight() {
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
            private Weight weight;

            public static final Material NONE = new Material("", Weight.NONE);

            private Material(String displayText, Weight weight) {
                this.displayText = displayText;
                this.weight = weight;
            }

            public String getDisplayText() {
                return displayText;
            }

            public Weight getWeight() {
                return weight;
            }

            enum Heavy {

                IRON(new Material("Iron", HEAVY)),
                STEEL(new Material("Steel", HEAVY)),
                DARKSTEEL(new Material("Darksteel", HEAVY)),
                TENACIUM(new Material("Tenacium", HEAVY)),
                ;

                private Material material;

                Heavy(
                        Material material
                ) {
                    this.material = material;
                }

                public Material getMaterial() {
                    return material;
                }
            }

            public enum Medium {

                HIDE(new Material("Hide", MEDIUM)),
                THIN_LEATHER(new Material("Thin Leather", MEDIUM)),
                RUGGED_LEATHER(new Material("Rugged Leather", MEDIUM)),
                HARDENED_LEATHER(new Material("Hardened Leather", MEDIUM)),
                ;

                private Material material;

                Medium(
                        Material material
                ) {
                    this.material = material;
                }

                public Material getMaterial() {
                    return material;
                }
            }

            public enum Light {

                COTTON(new Material("Cotton", LIGHT)),
                LINEN(new Material("Linen", LIGHT)),
                SILK(new Material("Silk", LIGHT)),
                GOSSAMER(new Material("Gossamer", LIGHT)),
                ;

                private Material material;

                Light(
                        Material material
                ) {
                    this.material = material;
                }

                public Material getMaterial() {
                    return material;
                }
            }
        }

        public enum Weight {
            NONE, LIGHT, MEDIUM, HEAVY
        }
    }

    class Weapon implements Item {

        String name;
        Item.Type type = Item.Type.WEAPON;
        Integer currencyValue = 0;
        Prerequisite prerequisite = null;
        Weapon.Type weaponType;

        public GameObject.Type objectType() {
            return GameObject.Type.ITEM;
        }

        public Weapon withName(String name) {
            this.name = name;
            return this;
        }

        public Weapon asWeaponType(Weapon.Type weaponType) {
            this.weaponType = weaponType;
            return this;
        }

        public Weapon withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public Weapon withUsagePrerequisite(Prerequisite prerequisite) {
            this.prerequisite = prerequisite;
            return this;
        }

        public boolean doubleHanded() {
            return weaponType.isDoubleHanded();
        }

        public boolean ranged() {
            return weaponType.isRanged();
        }

        public ArrayList<Profession> applicableProfessions() {
            return weaponType.getApplicableProfessions();
        }

        public boolean meetsPrerequisite() {
            return prerequisite().requirement();
        }

        public String name() {
            return name;
        }

        public Item.Type type() {
            return type;
        }

        public String description() {
            return "This item is used in combat to deal damage, and can only be equipped by certain professions.";
        }

        public String sellDescription() {
            return "This item sells for " + Currency.convertToUnits(currencyValue);
        }

        public Integer currencyValue() {
            return currencyValue;
        }

        public Prerequisite prerequisite() {
            return prerequisite;
        }

        public enum Type {

            EMPTY("", false, false, null),
            // MELEE ----------------------------------------------------------
            SWORD("Sword",
                    false,
                    false,
                    new ArrayList<>(Arrays.asList(DUELIST, PALADIN, ANTIQUER, ASSASSIN, PERFORATOR, NAGUAL, ARCHER, BARD))
            ),
            GREATSWORD("Greatsword",
                    true,
                    false,
                    new ArrayList<>(Arrays.asList(DUELIST, PALADIN, ANTIQUER))
            ),
            DAGGER("Dagger",
                    false,
                    false,
                    new ArrayList<>(Arrays.asList(ASSASSIN, NAGUAL, ARCHER, HUNTER, DUELIST, PERFORATOR))
            ),
            AXE("Axe",
                    false,
                    false,
                    new ArrayList<>(Arrays.asList(DUELIST, PALADIN, CHRONOL, HUNTER))
            ),
            GREATAXE("Greataxe",
                    true,
                    false,
                    new ArrayList<>(Arrays.asList(ANTIQUER, DUELIST, PALADIN))
            ),
            MACE("Mace",
                    false,
                    false,
                    new ArrayList<>(Arrays.asList(HUNTER, PERFORATOR, NAGUAL))
            ),
            PIKE("Pike",
                    true,
                    false,
                    new ArrayList<>(Arrays.asList(PERFORATOR, ANTIQUER, BARD))
            ),

            // RANGED ----------------------------------------------------------
            LONGBOW("Longbow",
                    true,
                    true,
                    new ArrayList<>(Arrays.asList(ARCHER, ASSASSIN, NAGUAL, HUNTER))
            ),
            CROSSBOW("Crossbow",
                    false,
                    true,
                    new ArrayList<>(Arrays.asList(ARCHER, HUNTER, NAGUAL))
            ),
            WAND("Wand",
                    false,
                    true,
                    new ArrayList<>(Arrays.asList(ARCHER, PRIEST, CHRONOL, SHAMAN))
            ),
            STAFF("Staff",
                    true,
                    true,
                    new ArrayList<>(Arrays.asList(ARCHER, PRIEST, CHRONOL, SHAMAN, ASSASSIN, PERFORATOR))
            ),
            TOME("Tome",
                    true,
                    true,
                    new ArrayList<>(Arrays.asList(PRIEST, SHAMAN, CHRONOL, NAGUAL, ANTIQUER, PALADIN))
            ),
            INSTRUMENT("Instrument",
                    true,
                    true,
                    new ArrayList<>(Collections.singletonList(BARD))
            ),
            HALLOW("Hallow",
                    false,
                    true,
                    new ArrayList<>(Arrays.asList(BARD, PRIEST, SHAMAN, CHRONOL, NAGUAL, ASSASSIN))
            ),

            ;

            private String displayText;
            private boolean isDoubleHanded;
            private boolean isRanged;
            private ArrayList<Profession> usedBy;

            Type(
                    String displayText,
                    boolean isDoubleHanded,
                    boolean isRanged,
                    ArrayList<Profession> usedBy
            ) {
                this.displayText = displayText;
                this.isDoubleHanded = isDoubleHanded;
                this.isRanged = isRanged;
                this.usedBy = usedBy;
            }

            public String getDisplayText() {
                return displayText;
            }

            public boolean isDoubleHanded() {
                return isDoubleHanded;
            }

            public boolean isRanged() {
                return isRanged;
            }

            public ArrayList<Profession> getApplicableProfessions() {
                return usedBy;
            }
        }

        public enum Material {

            NONE, IRON, WOOD
        }
    }

    class Consumable implements Item {

        String name;
        Item.Type type = Item.Type.CONSUMABLE;
        Integer currencyValue = 0;
        Consumable.Stat restorationStat;
        Integer restorationValue;
        Prerequisite prerequisite = null;

        public GameObject.Type objectType() {
            return GameObject.Type.ITEM;
        }

        public Consumable withName(String name) {
            this.name = name;
            return this;
        }

        public Consumable withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public Consumable withUsagePrerequisite(Prerequisite prerequisite) {
            this.prerequisite = prerequisite;
            return this;
        }

        public boolean meetsPrerequisite() {
            return prerequisite().requirement();
        }

        public Consumable withRestorationStat(Consumable.Stat restorationStat) {
            this.restorationStat = restorationStat;
            return this;
        }

        public Consumable withRestorationValue(Integer restorationValue) {
            this.restorationValue = restorationValue;
            return this;
        }

        public String name() {
            return name;
        }

        public Item.Type type() {
            return type;
        }

        public String description() {
            return "This item can be consumed for a specific effect or to replenish a stat.";
        }

        public String sellDescription() {
            return "This item sells for " + Currency.convertToUnits(currencyValue);
        }

        public Integer currencyValue() {
            return currencyValue;
        }

        public Prerequisite prerequisite() {
            return prerequisite;
        }

        public enum Stat {
            HEALTH, ENERGY, MANA;
        }
    }

    class Generic implements Item {

        String name;
        Item.Type type = Item.Type.GENERIC;
        Integer currencyValue = 0;

        public GameObject.Type objectType() {
            return GameObject.Type.ITEM;
        }

        public Generic withName(String name) {
            this.name = name;
            return this;
        }

        public Generic withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public Generic withUsagePrerequisite(Prerequisite prerequisite) {
            return null;
        }

        public boolean meetsPrerequisite() {
            return false;
        }

        public String name() {
            return name;
        }

        public Item.Type type() {
            return type;
        }

        public String description() {
            return "This item can only be sold.";
        }

        public String sellDescription() {
            return "This item sells for " + Currency.convertToUnits(currencyValue);
        }

        public Integer currencyValue() {
            return currencyValue;
        }

        public Prerequisite prerequisite() {
            return null;
        }
    }
}