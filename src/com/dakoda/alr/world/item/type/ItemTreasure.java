package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import static com.dakoda.alr.world.item.Item.Type.TREASURE;

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
