package com.dakoda.alr.game.world.item.type;
import com.dakoda.alr.game.world.item.Item;

public class ItemQuest extends Item {

    public ItemQuest(String name) {
        setName(name);
        setItemType(Type.QUEST);
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
