package com.dakoda.alr.control;
import com.dakoda.alr.game.player.Inventory;

import static com.dakoda.alr.world.item.Item.Type.*;
import com.dakoda.alr.world.item.Items;
public class TextRPG {

    //stop committing things irrelevant to the branch you're better than this

    public static void main(String[] args) {
//        Quest quest = new Quest.QuestBuilder()
//                .addItemRequirement(Items.Quest.APPLE.get(), 10)
//                .build();

        Inventory inventory = builtInventory();

//        inventory.getAllItems().forEach((key, value) -> System.out.println(key.getName() + " | " + key.getItemType().getDisplayText() + " | " + value.toString()));

        inventory.getFiltered(WEAPON)
                .forEach((key, value) -> System.out.println(key.getName() + " | " + key.getItemType().getDisplayText() + " | " + value.toString()));
    }

    static Inventory builtInventory() {
        Inventory inventory = new Inventory();

        inventory.addItem(Items.Consumable.APPLE.get(), 4);
        inventory.addItem(Items.Consumable.APPLE.get(), 1);
        inventory.addItem(Items.Quest.APPLE.get());
        inventory.addItem(Items.Armour.IRON_HELMET.get());
        inventory.addItem(Items.Weapon.BOW.get());
        inventory.addItem(Items.Weapon.IRON_SWORD.get());
        inventory.addItem(Items.Treasure.HAND_OF_MIDAS.get());
        inventory.addItem(Items.Junk.TRASH.get(), 10);
        inventory.addItem(Items.Material.WOOD.get(), 40);

        return inventory;
    }
}