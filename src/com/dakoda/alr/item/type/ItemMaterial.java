package com.dakoda.alr.item.type;
import com.dakoda.alr.game.character.Discipline;
import com.dakoda.alr.item.Item;
import static com.dakoda.alr.item.Item.Type.CRAFTING_MATERIAL;

public class ItemMaterial extends Item {

    private Discipline discipline;

    public ItemMaterial(String name, Discipline discipline, int moneyValue) {
        this.discipline = discipline;
        setMoneyValue(moneyValue);
        setName(name);
        setItemType(CRAFTING_MATERIAL);
    }

    public ItemMaterial(String name, Discipline discipline) {
        this.discipline = discipline;
        setMoneyValue(1);
        setName(name);
        setItemType(CRAFTING_MATERIAL);
    }

    public String getDescription() {
        return "This item is used as a requirement to craft another item.";
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
