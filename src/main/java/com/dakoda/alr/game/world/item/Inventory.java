package com.dakoda.alr.game.world.item;

import com.dakoda.alr.game.exception.InvalidCurrencyChangeException;
import com.dakoda.alr.game.exception.InvalidInventoryMutationException;
import com.dakoda.alr.game.exception.NullInventoryMutationException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Inventory {

    private HashMap<Item, Integer> items = new HashMap<>();
    private Long currency;
    private Equipment equipment;

    public Equipment equipment() {
        return equipment;
    }

    public Inventory withEquipment(Equipment equipment) {
        this.equipment = equipment;
        return this;
    }

    public Inventory withItem(Item item) {
        addItem(item);
        return this;
    }

    public Inventory withItem(Item item, Integer amount) {
        addItem(item, amount);
        return this;
    }

    public Inventory withCurrencyValue(Long value) {
        this.currency = value;
        return this;
    }

    /**
     * Increases the inventory's currency value by the given value.
     * A negative value parsed here will validate as if it was positive,
     * however a warning will be printed in the console indicating so.
     *
     * @param add The amount to be added.
     */
    public void addCurrency(Long add) {
        if (checkValidCurrencyChange(Math.abs(add))) {
            currency += Math.abs(add);
        }
        if (add < 0)
            throw new InvalidCurrencyChangeException("!!WARNING: An attempt was made to add a negative amount of currency to the player. The absolute value of the number was evaluated instead.");
    }

    /**
     * Decreases the inventory's currency value by the given value.
     * A negative value parsed here will validate as if it was positive,
     * however a warning will be printed in the console indicating so.
     *
     * @param sub The amount to be subtracted.
     */
    public void subCurrency(Long sub) {
        if (checkValidCurrencyChange(-(Math.abs(sub)))) {
            currency -= Math.abs(sub);
        }
        if (sub < 0)
            throw new InvalidCurrencyChangeException("!!WARNING: An attempt was made to subtract a negative amount of currency from the player. The absolute value of the number was evaluated instead.");
    }

    /**
     * Checks to see if a currency value change can be made, taking into consideration
     * the current value of currency.
     * <p>
     * A change cannot be made if the change were to cause the currency value to fall below zero,
     * and a change cannot be made if the change were to cause the currency value to rise above the maximum
     * stored value of a Long.
     *
     * @param change The change to be made.
     * @return Boolean determining whether or not the change can be made.
     */
    public boolean checkValidCurrencyChange(Long change) {
        return currency + change > 0 && currency + change < Long.MAX_VALUE;
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    /**
     * Adds an item to the inventory, or multiple depending on the value of amount.
     * <p>
     * A negative amount here will throw an exception.
     * An amount of zero here will throw an exception.
     * <p>
     * If the item already exists in the Inventory, the items will stack onto that.
     *
     * @param item   The item to be added.
     * @param amount The amount of the item to be added.
     */
    public void addItem(Item item, int amount) {
        if (amount < 0) {
            throw new InvalidInventoryMutationException("You're trying to add a NEGATIVE amount of items to an inventory. Try 'removeItem' instead.");
        } else if (amount < 1) {
            throw new InvalidInventoryMutationException("You're trying to add ZERO of an item to an inventory.");
        } else {
            if (items.containsKey(item)) {
                items.put(item, items.get(item) + amount);
            } else {
                items.put(item, amount);
            }
        }
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item The item to be removed.
     */
    public void removeItem(Item item) {
        removeItem(item, 1);
    }

    /**
     * Removes all of one item from the inventory.
     *
     * @param item The item to have all instances of it in the inventory removed.
     */
    public void removeAllOfItem(Item item) {
        removeItem(item, items.get(item));
    }

    /**
     * Removes an item from the inventory.
     * <p>
     * A negative amount here will throw an exception.
     * An amount of zero here will throw an exception.
     * <p>
     * If the item doesn't exist, an exception will be thrown.
     *
     * @param item   The item to be removed.
     * @param amount
     */
    public void removeItem(Item item, int amount) {
        if (amount < 0) {
            throw new InvalidInventoryMutationException("You're trying to remove a NEGATIVE amount of items from an inventory. Try 'addItem' instead.");
        } else if (amount < 1) {
            throw new InvalidInventoryMutationException("You're trying to remove ZERO of an item from an inventory.");
        } else {
            if (items.containsKey(item)) {
                items.put(item, items.get(item) + amount);
            } else {
                throw new NullInventoryMutationException("You just tried to remove an item from an inventory that doesn't contain that item.");
            }
        }
        removeRedundantEntries();
    }

    /**
     * Removes all items from the inventory that have an amount that is either negative or zero.
     * Logs the amount of redundant entries removed to the console.
     */
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

    /**
     * Filters items in the inventory by Item.Type
     * <p>
     * Uses a stream to filter items that match the given Item.Type and collects them
     * in a new HashMap.
     *
     * @param itemType The Item.Type we are filtering for.
     * @return HashMap of filtered items.
     */
    public HashMap<Item, Integer> getFiltered(Item.Type itemType) {
        return (HashMap<Item, Integer>)
                (getAllItems().entrySet().stream()
                        .filter(entry -> entry.getKey().type().equals(itemType))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public boolean hasItem(Item item) {
        removeRedundantEntries();
        return items.containsKey(item);
    }
}