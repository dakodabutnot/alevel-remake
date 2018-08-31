package com.dakoda.alr.item.equip;
import com.dakoda.alr.item.Item;
import static com.dakoda.alr.item.ItemType.ARMOUR;

public class Armour extends Item {

    private ArmourLevel armourLevel;
    private ArmourSlot armourSlot;
    private EquipMaterial equipMaterial;

    public Armour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial) {
        setMoneyValue(1);
        defaulted(name, armourSlot, equipMaterial);
    }

    public Armour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial, int moneyValue) {
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

    protected String getDescription() {
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
