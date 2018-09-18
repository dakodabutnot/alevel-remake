package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.world.item.type.ItemWeapon;

public class WeaponHands {

    private ItemWeapon left;
    private ItemWeapon right;

    public ItemWeapon left() {
        return left;
    }

    public ItemWeapon right() {
        return right;
    }

    public void left(ItemWeapon left) {
        this.left = left;
    }

    public void right(ItemWeapon right) {
        this.right = right;
    }

    public ItemWeapon slot(int slot) {
        if (slot == 0) {
            return left();
        } else {
            return right();
        }
    }

    public void slot(int slot, ItemWeapon weapon) {
        if (slot == 0) {
            left(weapon);
        } else {
            right(weapon);
        }
    }
}
