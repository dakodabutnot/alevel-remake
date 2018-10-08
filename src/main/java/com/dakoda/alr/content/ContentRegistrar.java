package com.dakoda.alr.content;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.item.type.Item_Armour;
import com.dakoda.alr.game.world.item.type.Item_Weapon;

public abstract class ContentRegistrar {

    public abstract void init();

    protected void register(Integer id, GameObject object) {
        TextRPG.master.content.register(id, object);
    }

    protected abstract Integer ID();

    public static class Content_Default extends ContentRegistrar {

        private Integer ID;

        public void init() {
            //default registrations
            register(-1, new Item_Weapon()
                    .withName("DEFAULT_WEP")
                    .asWeaponType(Item_Weapon.Type.EMPTY)
            );
            register(-2, new Item_Armour()
                    .withName("DEFAULT_ARM")
                    .equippableOn(Item_Armour.Slot.ANY)
                    .withMaterial(Item_Armour.Material.NONE)
            );
        }

        protected Integer ID() {
            return ID++;
        }
    }
}