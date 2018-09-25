package com.dakoda.alr.game.world.item;

import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.game.world.item.type.Item_Armour;
import com.dakoda.alr.game.world.item.type.Item_Weapon;
import com.dakoda.alr.game.exception.InvalidEquipSlotArgumentException;
import com.dakoda.alr.game.exception.NullEquipException;

import java.util.EnumMap;

public class Equipment {

    private final Item_Weapon EMPTY_WEP = (Item_Weapon) ContentFinder.findItemByID(0);
    private final Item_Armour EMPTY_ARM = (Item_Armour) ContentFinder.findItemByID(1);
    private EnumMap<Item_Armour.Slot, Item_Armour> equippedArmour = new EnumMap<>(Item_Armour.Slot.class);
    private EquippedWeapons equippedWeapons = new EquippedWeapons();

    {
        equippedWeapons.left(EMPTY_WEP);
        equippedWeapons.right(EMPTY_WEP);
    }

    public Equipment() {
        for (Item_Armour.Slot slot : Item_Armour.Slot.values()) {
            equippedArmour.put(slot, EMPTY_ARM);
        }
    }

    /**
     * Equips a piece of armour to the respective armour slot.
     * If an armour piece already exists here, it will be 'overwritten'.
     *
     * @param armour The armour to be equipped.
     */
    public void equipArmour(Item_Armour armour) {
        if (armour != null) {
            this.equippedArmour.put(armour.slot(), armour);
        } else {
            throw new NullEquipException("An attempt was made to equip a null armour.");
        }
    }

    public void equipArmour(Item_Armour.Slot slot, Item_Armour armour) {
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
     *
     * @param slot The slot that the weapon should be equipped to.
     */
    public void equipWeapon(Integer slot, Item_Weapon weapon) {
        if (slot >= 0 && slot <= 1) {
            if (weapon != null) {
                if (weapon.doubleHanded()) {
                    equipWeapon(weapon);
                } else {
                    if (equippedWeapons.slot(slot).doubleHanded()) {
                        equippedWeapons.slot(slot, weapon);
                        equippedWeapons.slot(1 - slot, EMPTY_WEP);
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
     *
     * @param weapon
     */
    public void equipWeapon(Item_Weapon weapon) {
        if (weapon != null) {
            if (weapon.doubleHanded()) {
                this.equippedWeapons.left(weapon);
                this.equippedWeapons.right(weapon);
            } else {
                if (this.equippedWeapons.left() == EMPTY_WEP) {
                    this.equippedWeapons.left(weapon);
                } else if (this.equippedWeapons.right() == EMPTY_WEP) {
                    this.equippedWeapons.right(weapon);
                } else {
                    if (this.equippedWeapons.left().doubleHanded()) {
                        this.equippedWeapons.left(weapon);
                        this.equippedWeapons.right(EMPTY_WEP);
                    } else {
                        this.equippedWeapons.left(weapon);
                    }
                }
            }
        } else {
            throw new NullEquipException("An attempt was made to equip a 'null' weapon.");
        }
    }

    public EnumMap<Item_Armour.Slot, Item_Armour> getArmour() {
        return equippedArmour;
    }

    public EquippedWeapons getWeapons() {
        return equippedWeapons;
    }

    public void unequipArmour(Item_Armour.Slot slot) {
        this.equipArmour(slot, EMPTY_ARM);
    }

    public void unequipArmour(Item_Armour armour) {
        if (equippedArmour.containsValue(armour)) {
            this.equipArmour(armour.slot(), EMPTY_ARM);
        } else {
            throw new InvalidEquipSlotArgumentException("An attempt was made to unequip an armour that isn't even equipped.");
        }
    }

    public void unequipWeapon(Integer slot) {
        this.equipWeapon(slot, EMPTY_WEP);
    }

    class EquippedWeapons {

        private Item_Weapon left;
        private Item_Weapon right;

        public Item_Weapon left() {
            return left;
        }

        public Item_Weapon right() {
            return right;
        }

        public void left(Item_Weapon left) {
            this.left = left;
        }

        public void right(Item_Weapon right) {
            this.right = right;
        }

        public Item_Weapon slot(int slot) {
            if (slot == 0) {
                return left();
            } else {
                return right();
            }
        }

        public void slot(int slot, Item_Weapon weapon) {
            if (slot == 0) {
                left(weapon);
            } else {
                right(weapon);
            }
        }
    }
}
