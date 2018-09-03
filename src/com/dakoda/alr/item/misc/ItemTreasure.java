package com.dakoda.alr.item.misc;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.TREASURE;

public class ItemTreasure extends Item {

    public ItemTreasure(String name, int moneyValue) {
        setName(name);
        setMoneyValue(moneyValue);
        setItemType(TREASURE);
    }

    protected String getDescription() {
        return "This item can be sold at a high price.";
    }
}
