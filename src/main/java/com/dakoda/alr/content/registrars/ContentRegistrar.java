package com.dakoda.alr.content.registrars;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.item.type.Item_Armour;
import com.dakoda.alr.game.world.item.type.Item_Weapon;

public abstract class ContentRegistrar {

    public abstract void init();

    protected void register(Integer id, GameObject object) {
        TextRPG.master.content.register(id, object);
    }

    class Content_Default extends ContentRegistrar {

        public void init() {
            //default registrations
            register(0, new Item_Weapon()
                    .withName("DEFAULT_WEP")
                    .asWeaponType(Item_Weapon.Type.EMPTY)
            );
            register(1, new Item_Armour()
                    .withName("DEFAULT_ARM")
                    .equippableOn(Item_Armour.Slot.ANY)
                    .withMaterial(Item_Armour.Material.NONE)
            );
        }
    }
}