package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import static com.dakoda.alr.world.item.Item.Type.JUNK;

public class ItemJunk extends Item {

    public ItemJunk(String name, int moneyValue) {
        setMoneyValue(moneyValue);
        setItemType(JUNK);
        setName(name);
    }

    public ItemJunk(String name) {
        setMoneyValue(1);
        setItemType(JUNK);
        setName(name);
    }

    public String getDescription() {
        return "This item can only be sold.";
    }
}
