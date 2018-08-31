package com.dakoda.alr.item.equip;
import com.dakoda.alr.item.Item;
import static com.dakoda.alr.item.ItemType.ARMOUR;

public class Armour extends Item {

    private ArmourLevel armourLevel;
    private ArmourSlot armourSlot;
    private EquipMaterial equipMaterial;

    public Armour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial) {
        setItemType(ARMOUR);
        setName(name);
        setMoneyValue(1);
        defaulted(armourSlot, equipMaterial);
    }

    public Armour(String name, ArmourSlot armourSlot, EquipMaterial equipMaterial, int moneyValue) {
        setItemType(ARMOUR);
        setName(name);
        setMoneyValue(moneyValue);
        defaulted(armourSlot, equipMaterial);
    }

    private void defaulted(ArmourSlot armourSlot, EquipMaterial equipMaterial) {
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
