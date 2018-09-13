package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import static com.dakoda.alr.world.item.Item.Type.QUEST;

public class ItemQuest extends Item {

    public ItemQuest(String name) {
        setName(name);
        setItemType(QUEST);
        setMoneyValue(-1);
    }

    public String getDescription() {
        return "This item is required for a quest.";
    }

    @Override
    public String getSellDescription() {
        return "This item cannot be sold.";
    }
}
