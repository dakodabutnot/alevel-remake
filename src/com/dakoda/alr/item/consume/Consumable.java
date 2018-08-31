package com.dakoda.alr.item.consume;
import com.dakoda.alr.item.Item;
import static com.dakoda.alr.item.ItemType.CONSUMABLE;

public class Consumable extends Item {

    private ConsumableType consumableType;
    private float affect;

    public Consumable(ConsumableType consumableType) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(1);
        setName(getConsumableTypeDisplay() + " potion");
    }

    public Consumable(ConsumableType consumableType, int moneyValue) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(moneyValue);
        setName(getConsumableTypeDisplay() + " potion");
    }

    public Consumable(String name, ConsumableType consumableType, int moneyValue) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(moneyValue);
        setName(name);
    }

    public Consumable(String name, ConsumableType consumableType) {
        setItemType(CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(1);
        setName(name);
    }

    protected String getDescription() {
        return "This item can be consumed for a specific effect or to replenish a stat.";
    }

    public ConsumableType getConsumableType() {
        return consumableType;
    }

    public String getConsumableTypeDisplay() {
        return consumableType.getDisplayText();
    }
}
