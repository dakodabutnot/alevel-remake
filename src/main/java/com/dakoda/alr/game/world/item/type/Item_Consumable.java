package com.dakoda.alr.game.world.item.type;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;


public class Item_Consumable implements Item {

    private String name;
    private Type type = Type.CONSUMABLE;
    private Integer currencyValue = 0;
    private Stat restorationStat;
    private Integer restorationValue;
    private Prerequisite prerequisite = null;

    public GameObject.Type objectType() {
        return GameObject.Type.ITEM;
    }

    public Item_Consumable withName(String name) {
        this.name = name;
        return this;
    }

    public Item_Consumable withCurrencyValue(Integer currencyValue) {
        this.currencyValue = currencyValue;
        return this;
    }

    public Item_Consumable withUsagePrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public boolean meetsPrerequisite() {
        return prerequisite().requirement();
    }

    public Item_Consumable withRestorationStat(Stat restorationStat) {
        this.restorationStat = restorationStat;
        return this;
    }

    public Item_Consumable withRestorationValue(Integer restorationValue) {
        this.restorationValue = restorationValue;
        return this;
    }

    public String name() {
        return name;
    }

    public Type type() {
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

