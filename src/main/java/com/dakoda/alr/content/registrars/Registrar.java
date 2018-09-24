package com.dakoda.alr.content.registrars;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.world.item.type.ItemArmour;
import com.dakoda.alr.game.world.item.type.ItemWeapon;

public abstract class Registrar {

    public abstract void init();

    void register(Integer id, GameObject object) {
        TextRPG.content.register(id, object);
    }

    class Registrar_Default extends Registrar {

        public void init() {
            //default registrations
            register(0, new ItemWeapon()
                    .withName("DEFAULT_WEP")
                    .asWeaponType(ItemWeapon.Type.EMPTY)
            );
            register(1, new ItemArmour()
                    .withName("DEFAULT_ARM")
                    .equippableOn(ItemArmour.Slot.ANY)
                    .withMaterial(ItemArmour.Material.NONE)
            );
        }
    }
}