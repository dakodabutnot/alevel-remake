package com.dakoda.alr.item.type;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.TREASURE;

public class ItemTreasure extends Item {

    public ItemTreasure(String name, int moneyValue) {
        setName(name);
        setMoneyValue(moneyValue);
        setItemType(TREASURE);
    }

    public String getDescription() {
        return "This item can be sold at a high price.";
    }
}
