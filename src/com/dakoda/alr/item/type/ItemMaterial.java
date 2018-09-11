package com.dakoda.alr.item.type;
import com.dakoda.alr.item.Item;
import static com.dakoda.alr.item.Item.Type.CRAFTING_MATERIAL;

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
