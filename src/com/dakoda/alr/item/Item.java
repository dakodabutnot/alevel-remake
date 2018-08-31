package com.dakoda.alr.item;

public abstract class Item {

    private String name;
    private ItemType itemType;
    private int moneyValue;

    protected String getName() {
        return name;
    }

    protected ItemType getItemType() {
        return itemType;
    }

    protected String getItemTypeDisplay(boolean b) {
        return getItemType().getDisplayText();
    }

    protected abstract String getDescription();

    protected void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getMoneyValue() {
        return moneyValue;
    }

    protected void setMoneyValue(int moneyValue) {
        this.moneyValue = moneyValue;
    }
}
