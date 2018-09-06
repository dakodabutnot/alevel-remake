package com.dakoda.alr.item.all;
import com.dakoda.alr.item.consume.Consumable;

public enum ItemsConsumable {

    ;

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
