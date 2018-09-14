package com.dakoda.alr.world.item;
import com.dakoda.alr.game.structure.Currency;

public abstract class Item {

    private String name;
    private Item.Type itemType;
    private int moneyValue;

    public String getName() {
        return name;
    }

    public Item.Type getItemType() {
        return itemType;
    }

    public String getItemTypeDisplay() {
        return getItemType().getDisplayText();
    }

    public abstract String getDescription();

    /**
     * Used to get a string representing the sell-ability of the item by calling a method of Currency. This method is
     * overridden for specific children of Item.
     * @return String informing what the item is sold for.
     */
    public String getSellDescription() {
        return "This item can be sold for " + Currency.convertToUnits(moneyValue);
    }

    public int getMoneyValue() {
        return moneyValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoneyValue(int moneyValue) {
        this.moneyValue = moneyValue;
    }

    public void setItemType(Item.Type itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Item) && ((Item) obj).getItemType().equals(this.itemType) && (((Item) obj).getName().equals(this.name));
    }

    /**
     * Lists the different types of items there are.
     * For filtering/categorising purposes.
     */
    public enum Type {

        JUNK("Junk"),
        CRAFTING_MATERIAL("Material"),
        CONSUMABLE("Consumable"),
        WEAPON("Weapon"),
        ARMOUR("Armour"),
        TREASURE("Treasure"),
        QUEST("Quest-specific item");

        private String displayText;

        Type(
                String displayText
        ) {
            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }
    }
}
