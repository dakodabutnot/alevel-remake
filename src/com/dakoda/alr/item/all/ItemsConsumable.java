package com.dakoda.alr.item.all;
import com.dakoda.alr.item.consume.Consumable;
import com.dakoda.alr.item.consume.ConsumableType;

public enum ItemsConsumable {

    APPLE(new Consumable("Apple", ConsumableType.HEALTH, 0.1f));

    private final Consumable item;

    ItemsConsumable(
            Consumable item
    ) {
        this.item = item;
    }

    public Consumable get() {
        return item;
    }
}
