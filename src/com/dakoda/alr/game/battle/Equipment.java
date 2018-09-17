package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.world.item.attribute.ArmourEquipSlot;
import com.dakoda.alr.game.world.item.type.ItemArmour;
import com.dakoda.alr.game.world.item.type.ItemWeapon;
import java.util.EnumMap;

public class Equipment {

    private EnumMap<ArmourEquipSlot, ItemArmour> equippedArmour = new EnumMap<>(ArmourEquipSlot.class);
    private ItemWeapon[] equippedWeapons = new ItemWeapon[2];

    public Equipment() {
        for (ArmourEquipSlot slot : ArmourEquipSlot.values()) {
            equippedArmour.put(slot, null);
        }
    }

    /**
     * Equips a piece of armour to the respective armour slot.
     * If an armour piece already exists here, it will be 'overwritten'.
     * @param slot The slot that the armour should be equipped to.
     * @param armour The armour to be equipped.
     */
    public void equip(ArmourEquipSlot slot, ItemArmour armour) {
        this.equippedArmour.put(slot, armour);
    }

    /**
     * Equips a weapon
     * If an armour piece already exists here, it will be 'overwritten'.
     * @param slot The slot that the armour should be equipped to.
     */
    public void equip(Integer slot, ItemWeapon weapon) {
        if (weapon != null) {
            if (weapon.isDoubleHanded()) {
                this.equippedWeapons[0] = weapon;
                this.equippedWeapons[1] = weapon;
            } else {
                this.equippedWeapons[slot] = weapon;
            }
        } else {
            System.out.println("WARNING: An attempt was made to equip a 'null' weapon.");
        }
    }

    public void equip(ItemWeapon weapon) {
        if (weapon != null) {
            if (weapon.isDoubleHanded()) {
                this.equippedWeapons[0] = weapon;
                this.equippedWeapons[1] = weapon;
            } else {
                if (this.equippedWeapons[0] == null) {
                    this.equippedWeapons[0] = weapon;
                } else if (this.equippedWeapons[1] == null) {
                    this.equippedWeapons[1] = weapon;
                } else {
                    this.equippedWeapons[0] = weapon;
                }
            }
        } else {
            System.out.println("WARNING: An attempt was made to equip a 'null' weapon.");
        }
    }

    public EnumMap<ArmourEquipSlot, ItemArmour> getArmour() {
        return equippedArmour;
    }

    public ItemWeapon[] getWeapons() {
        return equippedWeapons;
    }

    public void unequip(ArmourEquipSlot slot) {
        this.equip(slot, null);
    }

    public void unequip(Integer slot) {
        this.equip(slot, null);
    }
}
