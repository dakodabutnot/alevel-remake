package com.dakoda.alr.item;
import com.dakoda.alr.game.Quest;
import static com.dakoda.alr.item.ItemType.QUEST;

public class ItemQuest extends Item {

    private Quest quest;

    public ItemQuest(Quest quest) {
        this.quest = quest;
        setItemType(QUEST);
    }

    public Quest getRelatedQuest() {
        return quest;
    }

    protected String getDescription() {
        return "This item is required for a quest.";
    }
}
