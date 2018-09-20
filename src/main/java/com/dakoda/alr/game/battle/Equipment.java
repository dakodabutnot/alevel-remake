package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.exception.InvalidEquipSlotArgumentException;
import com.dakoda.alr.game.exception.NullEquipException;
import com.dakoda.alr.game.world.item.Items;
import com.dakoda.alr.game.world.item.attribute.ArmourEquipSlot;

import java.util.EnumMap;

public class Equipment {

    private EnumMap<ArmourEquipSlot, ItemArmour> equippedArmour = new EnumMap<>(ArmourEquipSlot.class);
    private WeaponHands equippedWeapons = new WeaponHands();

    {
        equippedWeapons.left(Items.Weapon.EMPTY.get());
        equippedWeapons.right(Items.Weapon.EMPTY.get());
    }

    public Equipment() {
        for (ArmourEquipSlot slot : ArmourEquipSlot.values()) {
            equippedArmour.put(slot, Items.Armour.EMPTY.get());
        }
    }

    /**
     * Equips a piece of armour to the respective armour slot.
     * If an armour piece already exists here, it will be 'overwritten'.
     * @param armour The armour to be equipped.
     */
    public void equipArmour(ItemArmour armour) {
        if (armour != null) {
            this.equippedArmour.put(armour.getArmourEquipSlot(), armour);
        } else {
            throw new NullEquipException("An attempt was made to equip a null armour.");
        }
    }

    public void equipArmour(ArmourEquipSlot slot, ItemArmour armour) {
        if (armour != null) {
            if (slot != null) {
                this.equippedArmour.put(slot, armour);
            } else {
                throw new InvalidEquipSlotArgumentException("An attempt was made to equip armour into a null slot.");
            }
        } else {
            throw new NullEquipException("An attempt was made to equip a null armour.");
        }
    }

    /**
     * Equips a weapon.
     * If a double-handed weapon is already equipped, and you are trying to equip either a single or double-handed weapon,
     * the double-handed weapon will be unequipped.
     * If a single-handed weapon is already equipped, and you want to equip in the slot it is in, then
     * the original weapon will be unequipped.
     * @param slot The slot that the weapon should be equipped to.
     */
    public void equipWeapon(Integer slot, ItemWeapon weapon) {
        if (slot >= 0 && slot <= 1) {
            if (weapon != null) {
                if (weapon.isDoubleHanded()) {
                    equipWeapon(weapon);
                } else {
                    if (equippedWeapons.slot(slot).isDoubleHanded()) {
                        equippedWeapons.slot(slot, weapon);
                        equippedWeapons.slot(1 - slot, Items.Weapon.EMPTY.get());
                    } else {
                        equippedWeapons.slot(slot, weapon);
                    }
                }
            } else {
                throw new NullEquipException("An attempt was made to equip a 'null' weapon.");
            }
        } else {
            throw new InvalidEquipSlotArgumentException("An attempt was made to equip a weapon in an invalid slot (not 0 or 1).");
        }
    }

    /**
     * Equips a weapon.
     * Finds a free slot and equips a weapon. If there is no free slot, then the left-hand is prioritised.
     * Double-handed weapons will be unequipped in full.
     * @param weapon
     */
    public void equipWeapon(ItemWeapon weapon) {
        if (weapon != null) {
            if (weapon.isDoubleHanded()) {
                this.equippedWeapons.left(weapon);
                this.equippedWeapons.right(weapon);
            } else {
                if (this.equippedWeapons.left() == Items.Weapon.EMPTY.get()) {
                    this.equippedWeapons.left(weapon);
                } else if (this.equippedWeapons.right() == Items.Weapon.EMPTY.get()) {
                    this.equippedWeapons.right(weapon);
                } else {
                    if (this.equippedWeapons.left().isDoubleHanded()) {
                        this.equippedWeapons.left(weapon);
                        this.equippedWeapons.right(Items.Weapon.EMPTY.get());
                    } else {
                        this.equippedWeapons.left(weapon);
                    }
                }
            }
        } else {
            throw new NullEquipException("An attempt was made to equip a 'null' weapon.");
        }
    }

    public EnumMap<ArmourEquipSlot, ItemArmour> getArmour() {
        return equippedArmour;
    }

    public WeaponHands getWeapons() {
        return equippedWeapons;
    }

    public void unequipArmour(ArmourEquipSlot slot) {
        this.equipArmour(slot, Items.Armour.EMPTY.get());
    }

    public void unequipArmour(ItemArmour armour) {
        if (equippedArmour.containsValue(armour)) {
            this.equipArmour(armour.getArmourEquipSlot(), Items.Armour.EMPTY.get());
        } else {
            throw new InvalidEquipSlotArgumentException("An attempt was made to unequip an armour that isn't even equipped.");
        }
    }

    public void unequipWeapon(Integer slot) {
        this.equipWeapon(slot, Items.Weapon.EMPTY.get());
    }
}
