package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import com.dakoda.alr.world.item.attr.ArmourWeight;
import com.dakoda.alr.world.item.attr.ArmourSlot;
import com.dakoda.alr.world.item.attr.ArmourMaterial;
import static com.dakoda.alr.world.item.Item.Type.ARMOUR;

public class ItemArmour extends Item {

    private ArmourWeight armourWeight;
    private ArmourSlot armourSlot;
    private ArmourMaterial armourMaterial;

    public ItemArmour(String name, ArmourSlot armourSlot, ArmourMaterial armourMaterial) {
        setMoneyValue(1);
        defaulted(name, armourSlot, armourMaterial);
    }

    public ItemArmour(String name, ArmourSlot armourSlot, ArmourMaterial armourMaterial, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name, armourSlot, armourMaterial);
    }

    private void defaulted(String name, ArmourSlot armourSlot, ArmourMaterial armourMaterial) {
        setName(name);
        setItemType(ARMOUR);
        this.armourSlot = armourSlot;
        this.armourWeight = armourMaterial.getArmourWeight();
        this.armourMaterial = armourMaterial;
    }

    public String getDescription() {
        return "This item is used in combat to protect the wearer, and can only be equipped by certain professions.";
    }

    public ArmourWeight getArmourWeight() {
        return armourWeight;
    }

    public ArmourMaterial getArmourMaterial() {
        return armourMaterial;
    }

    public ArmourSlot getArmourSlot() {
        return armourSlot;
    }
}