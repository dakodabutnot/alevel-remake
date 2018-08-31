package com.dakoda.alr.item.equip;
import com.dakoda.alr.game.Profession;
import com.dakoda.alr.item.Item;

import java.util.ArrayList;

import static com.dakoda.alr.item.ItemType.WEAPON;

public class Weapon extends Item {

    private boolean isDoubleHanded;
    private boolean isRanged;
    private WeaponType weaponType;
    private EquipMaterial equipMaterial;

    public Weapon(String name, WeaponType weaponType, EquipMaterial equipMaterial, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name, weaponType, equipMaterial);
    }

    public Weapon(String name, WeaponType weaponType, EquipMaterial equipMaterial) {
        setMoneyValue(1);
        defaulted(name, weaponType, equipMaterial);
    }

    private void defaulted(String name, WeaponType weaponType, EquipMaterial equipMaterial) {
        setItemType(WEAPON);
        setName(name);
        this.weaponType = weaponType;
        this.isDoubleHanded = weaponType.isDoubleHanded();
        this.isRanged = weaponType.isRanged();
        this.equipMaterial = equipMaterial;
    }

    protected String getDescription() {
        return "This item is used in combat to deal damage, and can only be equipped by certain professions.";
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public boolean isDoubleHanded() {
        return isDoubleHanded;
    }

    public boolean isRanged() {
        return isRanged;
    }

    public EquipMaterial getEquipMaterial() {
        return equipMaterial;
    }

    public ArrayList<Profession> getApplicableProfessions() {
        return weaponType.getApplicableProfessions();
    }
}
