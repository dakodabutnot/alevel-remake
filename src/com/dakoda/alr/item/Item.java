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

    public int getMoneyValue() {
        return moneyValue;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Item) && ((Item) obj).getItemType().equals(this.itemType) && (((Item) obj).getName().equals(this.name));
    }
}
