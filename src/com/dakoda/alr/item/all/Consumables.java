package com.dakoda.alr.item.all;
import com.dakoda.alr.item.consume.Consumable;
import com.dakoda.alr.item.consume.ConsumableType;

public enum Consumables {

    APPLE(new Consumable("Apple", ConsumableType.HEALTH, 0.1f)) {
        boolean embue(String health) {
            return true;
        }
    };

    private final Consumable item;

    Consumables(
            Consumable item
    ) {
        this.item = item;
    }

    public Consumable get() {
        return item;
    }

    abstract boolean embue(String health);
}
