package com.dakoda.alr.entity.player;
import com.dakoda.alr.item.Item;
import com.dakoda.alr.item.Item.Type;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private HashMap<Item, Integer> items = new HashMap<>();

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int amount) {
        if (amount < 0) {
            throw new RuntimeException("You're trying to add a NEGATIVE amount of items to an inventory. Try 'removeItem' instead.");
        } else if (amount < 1){
            throw new RuntimeException("You're trying to add ZERO of an item to an inventory.");
        } else {
            if (items.containsKey(item)) {
                items.put(item, items.get(item) + amount);
            } else {
                items.put(item, amount);
            }
        }
    }

    public void removeItem(Item item) {
        removeItem(item, 1);
    }

    public void removeAllOfItem(Item item) {
        removeItem(item, items.get(item));
    }

    public void removeItem(Item item, int amount) {
        if (amount < 0) {
            throw new RuntimeException("You're trying to remove a NEGATIVE amount of items from an inventory. Try 'addItem' instead.");
        } else if (amount < 1){
            throw new RuntimeException("You're trying to remove ZERO of an item from an inventory.");
        } else {
            if (items.containsKey(item)) {
                items.put(item, items.get(item) + amount);
            } else {
                throw new RuntimeException("You just tried to remove an item from an inventory that doesn't contain that item.");
            }
        }
        removeRedundantEntries();
    }

    public void removeRedundantEntries() {
        int removed = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            if (entry.getValue() <= 0) {
                items.remove(entry.getKey());
                removed++;
            }
        }
        if (removed > 0) {
            System.out.println("Removed " + removed + " redundant inventory entries.");
        }
    }

    public HashMap<Item, Integer> getAllItems() {
        return items;
    }

    public HashMap<Item, Integer> getFiltered(Item.Type itemType) {
        HashMap<Item, Integer> hashMap = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : getAllItems().entrySet()) {
            if (entry.getKey().getItemType().equals(itemType)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
