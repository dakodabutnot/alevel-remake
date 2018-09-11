package com.dakoda.alr.item;

public abstract class Item {

    private String name;
    private ItemType itemType;
    private int moneyValue;

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemTypeDisplay() {
        return getItemType().getDisplayText();
    }

    public abstract String getDescription();

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(int moneyValue) {
        this.moneyValue = moneyValue;
    }
}
