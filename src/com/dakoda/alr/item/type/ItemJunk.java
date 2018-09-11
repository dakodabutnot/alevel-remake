package com.dakoda.alr.item.type;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.JUNK;

public class ItemJunk extends Item {

    public ItemJunk(String name, int moneyValue) {
        setMoneyValue(moneyValue);
        setItemType(JUNK);
        setName(name);
    }

    public ItemJunk(String name) {
        setMoneyValue(1);
        setName(name);
    }

    public String getDescription() {
        return "This item can only be sold.";
    }
}
