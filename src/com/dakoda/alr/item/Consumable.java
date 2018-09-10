package com.dakoda.alr.item;
import static com.dakoda.alr.item.ItemType.CONSUMABLE;

public class Consumable extends Item {

    private ConsumableType consumableType;
    private float potency;

    public Consumable(ConsumableType consumableType) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(1);
        setName(getConsumableTypeDisplay() + " potion");
    }

    public Consumable(ConsumableType consumableType, int moneyValue) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(moneyValue);
        setName(getConsumableTypeDisplay() + " potion");
    }

    public Consumable(String name, ConsumableType consumableType, int moneyValue) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(moneyValue);
        setName(name);
    }

    public Consumable(String name, ConsumableType consumableType) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        this.potency = potency;
        setMoneyValue(1);
        setName(name);
    }

    public String getDescription() {
        return "This item can be consumed for a specific effect or to replenish a stat.";
    }

    public ConsumableType getConsumableType() {
        return consumableType;
    }

    public String getConsumableTypeDisplay() {
        return consumableType.getDisplayText();
    }
}
