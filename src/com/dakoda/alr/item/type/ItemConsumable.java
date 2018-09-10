package com.dakoda.alr.item.type;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.CONSUMABLE;

public class ItemConsumable extends Item {

    private Type consumableType;
    private float potency;

    public ItemConsumable(String name, Type consumableType, int moneyValue) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(moneyValue);
        setName(name);
    }

    public ItemConsumable(String name, Type consumableType) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(1);
        setName(name);
    }

    public String getDescription() {
        return "This item can be consumed for a specific effect or to replenish a stat.";
    }

    public Type getConsumableType() {
        return consumableType;
    }

    public String getConsumableTypeDisplay() {
        return consumableType.getDisplayText();
    }

    public enum Type {

        HEALTH("Health"),
        ENERGY("Energy"),
        MANA("Mana"),
        EXPERIENCE("Experience");

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
