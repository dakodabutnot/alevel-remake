package com.dakoda.alr.game.world.item;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.quest.Questable;
import com.dakoda.alr.game.registrar.GameObject;

public interface Item extends Questable, GameObject {

    String name();

    Type type();

    String description();

    String sellDescription();

    Integer currencyValue();

    Item withName(String name);

    Item withCurrencyValue(Integer currencyValue);

    static Item ofType(Type type) {
        if (type == Type.GENERIC) {
            return new Item_Generic();
        } else if (type == Type.ARMOUR) {
            return new Item_Armour();
        } else if (type == Type.WEAPON) {
            return new Item_Weapon();
        } else if (type == Type.CONSUMABLE) {
            return new Item_Consumable();
        } else {
            return null;
        }
    }

    enum Type {

        GENERIC, ARMOUR, WEAPON, CONSUMABLE;
    }

    class Item_Armour implements Item {

        String name;
        Type type = Type.ARMOUR;
        Integer currencyValue = 0;

        public Item_Armour withName(String name) {
            this.name = name;
            return this;
        }
        public Item_Armour withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public String name() {
            return null;
        }

        public Type type() {
            return null;
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
    }

    class Item_Weapon implements Item {

        String name;
        Type type = Type.WEAPON;
        String description = "";
        Integer currencyValue = 0;

        public Item_Weapon withName(String name) {
            this.name = name;
            return this;
        }

        public Item_Weapon withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public String name() {
            return null;
        }

        public Type type() {
            return null;
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
    }

    class Item_Consumable implements Item {

        String name;
        Type type = Type.WEAPON;
        Integer currencyValue = 0;

        public Item_Consumable withName(String name) {
            this.name = name;
            return this;
        }

        public Item_Consumable withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public String name() {
            return null;
        }

        public Type type() {
            return null;
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
    }

    class Item_Generic implements Item {

        String name;
        Type type = Type.WEAPON;
        Integer currencyValue = 0;

        public Item_Generic withName(String name) {
            this.name = name;
            return this;
        }

        public Item_Generic withCurrencyValue(Integer currencyValue) {
            this.currencyValue = currencyValue;
            return this;
        }

        public String name() {
            return null;
        }

        public Type type() {
            return null;
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
    }
}
