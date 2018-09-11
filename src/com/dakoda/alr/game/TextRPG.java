package com.dakoda.alr.game;
import com.dakoda.alr.entity.player.Inventory;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.item.Item;
import com.dakoda.alr.item.ItemType;
import com.dakoda.alr.item.Items;
import java.util.Map.Entry;

public class TextRPG {

    //stop committing things irrelevant to the branch you're better than this

    public static void main(String[] args) {
        Quest quest = new Quest.QuestBuilder()
                .addItemRequirement(Items.Quest.APPLE.get(), 10)
                .build();

        Inventory inventory = new Inventory();
        inventory.addItem(Items.Consumable.APPLE.get());
        inventory.addItem(Items.Consumable.APPLE.get(), 2);
        inventory.addItem(Items.Consumable.APPLE.get(), -1);
        inventory.addItem(Items.Consumable.APPLE.get(), 3);

        inventory.addItem(Items.Quest.APPLE.get());

        for (Entry<Item, Integer> entry : inventory.getFiltered(ItemType.CONSUMABLE).entrySet()) {
            System.out.println(entry.getKey().getName() + " | " + entry.getKey().getItemType().getDisplayText() + " | " + entry.getValue().toString());
        }
    }
}