package com.dakoda.alr.game.world.item.type;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;

public class Item_Generic implements Item {

    private String name;
    private Type type = Type.GENERIC;
    private Integer currencyValue = 0;

    public GameObject.Type objectType() {
        return GameObject.Type.ITEM;
    }

    public Item_Generic withName(String name) {
        this.name = name;
        return this;
    }

    public Item_Generic withCurrencyValue(Integer currencyValue) {
        this.currencyValue = currencyValue;
        return this;
    }

    public Item_Generic withUsagePrerequisite(Prerequisite prerequisite) {
        return null;
    }

    public boolean meetsPrerequisite() {
        return false;
    }

    public String name() {
        return name;
    }

    public Type type() {
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