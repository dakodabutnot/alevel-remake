package com.dakoda.alr.game.world.item.type;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.item.attribute.ArmourWeight;
import com.dakoda.alr.game.world.item.attribute.ArmourEquipSlot;
import com.dakoda.alr.game.world.item.attribute.ArmourMaterial;
import static com.dakoda.alr.game.world.item.Item.Type.ARMOUR;

public class ItemArmour extends Item {

    private ArmourWeight armourWeight;
    private ArmourEquipSlot armourEquipSlot;
    private ArmourMaterial armourMaterial;

    public ItemArmour(String name, ArmourEquipSlot armourEquipSlot, ArmourMaterial armourMaterial) {
        setMoneyValue(1);
        defaulted(name, armourEquipSlot, armourMaterial);
    }

    public ItemArmour(String name, ArmourEquipSlot armourEquipSlot, ArmourMaterial armourMaterial, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name, armourEquipSlot, armourMaterial);
    }

    private void defaulted(String name, ArmourEquipSlot armourEquipSlot, ArmourMaterial armourMaterial) {
        setName(name);
        setItemType(ARMOUR);
        this.armourEquipSlot = armourEquipSlot;
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

    public ArmourEquipSlot getArmourEquipSlot() {
        return armourEquipSlot;
    }
}