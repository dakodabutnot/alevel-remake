package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import static com.dakoda.alr.world.item.Item.Type.CRAFTING_MATERIAL;

public class ItemMaterial extends Item {

    public ItemMaterial(String name, int moneyValue) {
        setMoneyValue(moneyValue);
        setName(name);
        setItemType(CRAFTING_MATERIAL);
    }

    public ItemMaterial(String name) {
        setMoneyValue(1);
        setName(name);
        setItemType(CRAFTING_MATERIAL);
    }

    public String getDescription() {
        return "This item is used as a requirement to craft another item.";
    }

}
