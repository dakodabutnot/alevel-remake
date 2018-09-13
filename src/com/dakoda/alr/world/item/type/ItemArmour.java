package com.dakoda.alr.world.item.type;
import com.dakoda.alr.world.item.Item;
import com.dakoda.alr.world.item.attr.ArmourLevel;
import com.dakoda.alr.world.item.attr.ArmourSlot;
import com.dakoda.alr.world.item.attr.EquipMaterial;
import static com.dakoda.alr.world.item.Item.Type.ARMOUR;

public class ItemArmour extends Item {

    private ArmourLevel armourLevel;
    private ArmourSlot armourSlot;
    private EquipMaterial equipMaterial;

    public ItemArmour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial) {
        setMoneyValue(1);
        defaulted(name, armourSlot, equipMaterial);
    }

    public ItemArmour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name, armourSlot, equipMaterial);
    }

    private void defaulted(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial) {
        setName(name);
        setItemType(ARMOUR);
        this.armourSlot = armourSlot;
        this.armourLevel = equipMaterial.getArmourLevel();
        this.equipMaterial = equipMaterial;
    }

    public String getDescription() {
        return "This item is used in combat to protect the wearer, and can only be equipped by certain professions.";
    }

    public ArmourLevel getArmourLevel() {
        return armourLevel;
    }

    public EquipMaterial getEquipMaterial() {
        return equipMaterial;
    }

    public ArmourSlot getArmourSlot() {
        return armourSlot;
    }
}