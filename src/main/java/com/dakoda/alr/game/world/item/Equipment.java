package com.dakoda.alr.game.world.item;
import com.dakoda.alr.game.Content;
import com.dakoda.alr.game.exception.InvalidEquipSlotArgumentException;
import com.dakoda.alr.game.exception.NullEquipException;
import com.dakoda.alr.game.world.item.Item;

import java.util.EnumMap;

public class Equipment {

    private final Item.Weapon EMPTY_WEP = (Item.Weapon) Content.findItemByID(0);
    private final Item.Armour EMPTY_ARM = (Item.Armour) Content.findItemByID(1);
    private EnumMap<Item.Armour.Slot, Item.Armour> equippedArmour = new EnumMap<>(Item.Armour.Slot.class);
    private EquippedWeapons equippedWeapons = new EquippedWeapons();

    {
        equippedWeapons.left(EMPTY_WEP);
        equippedWeapons.right(EMPTY_WEP);
    }

    public Equipment() {
        for (Item.Armour.Slot slot : Item.Armour.Slot.values()) {
            equippedArmour.put(slot, EMPTY_ARM);
        }
    }

    /**
     * Equips a piece of armour to the respective armour slot.
     * If an armour piece already exists here, it will be 'overwritten'.
     * @param armour The armour to be equipped.
     */
    public void equipArmour(Item.Armour armour) {
        if (armour != null) {
            this.equippedArmour.put(armour.slot(), armour);
        } else {
            throw new NullEquipException("An attempt was made to equip a null armour.");
        }
    }

    public void equipArmour(Item.Armour.Slot slot, Item.Armour armour) {
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
    public void equipWeapon(Integer slot, Item.Weapon weapon) {
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
     * @param weapon
     */
    public void equipWeapon(Item.Weapon weapon) {
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

    public EnumMap<Item.Armour.Slot, Item.Armour> getArmour() {
        return equippedArmour;
    }

    public EquippedWeapons getWeapons() {
        return equippedWeapons;
    }

    public void unequipArmour(Item.Armour.Slot slot) {
        this.equipArmour(slot, EMPTY_ARM);
    }

    public void unequipArmour(Item.Armour armour) {
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

        private Item.Weapon left;
        private Item.Weapon right;

        public Item.Weapon left() {
            return left;
        }

        public Item.Weapon right() {
            return right;
        }

        public void left(Item.Weapon left) {
            this.left = left;
        }

        public void right(Item.Weapon right) {
            this.right = right;
        }

        public Item.Weapon slot(int slot) {
            if (slot == 0) {
                return left();
            } else {
                return right();
            }
        }

        public void slot(int slot, Item.Weapon weapon) {
            if (slot == 0) {
                left(weapon);
            } else {
                right(weapon);
            }
        }
    }
}
