package com.dakoda.alr.game.world.item.type;
import com.dakoda.alr.game.world.item.Item;

public class ItemConsumable extends Item {

    private Type consumableType;

    public ItemConsumable(String name, Type consumableType, int moneyValue) {
        setItemType(Item.Type.CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(moneyValue);
        setName(name);
    }

    public ItemConsumable(String name, Type consumableType) {
        setItemType(Item.Type.CONSUMABLE);
        this.consumableType = consumableType;
        setMoneyValue(1);
        setName(name);
    }

    public String getDescription() {
        return "This item can be consumed for a specific effect or to replenish a stat.";
    }

    public Type getConsumableType() {
        return consumableType;
    }

    public String getConsumableTypeDisplay() {
        return consumableType.getDisplayText();
    }

    public enum Type {

        HEALTH("Health"),
        ENERGY("Energy"),
        MANA("Mana"),
        EXPERIENCE("Experience");

        private String displayText;

        Type(
                String displayText
        ) {
            this.displayText = displayText;
        }

        public String getDisplayText() {
            return displayText;
        }
    }
}
