package com.dakoda.alr.item;
import com.dakoda.alr.game.character.Discipline;
import com.dakoda.alr.item.attr.ArmourSlot;
import com.dakoda.alr.item.attr.WeaponType;
import com.dakoda.alr.item.type.*;
import static com.dakoda.alr.item.attr.WeaponType.*;
import com.dakoda.alr.item.attr.EquipMaterial;
import com.dakoda.alr.item.attr.WeaponMaterial;


public class Items {

    public enum Armour {

        IRON_HELMET(new ItemArmour("Iron Helmet", ArmourSlot.HEAD, EquipMaterial.IRON, 200));

        ;

        private final ItemArmour item;

        Armour(
                ItemArmour item
        ) {
            this.item = item;
        }

        public ItemArmour get() {
            return item;
        }
    }

    public enum Consumable {

        APPLE(new ItemConsumable("Apple", ItemConsumable.Type.HEALTH)) {
            boolean embue(String health) {
                return true;
            }
        };

        private final ItemConsumable item;

        Consumable(
                ItemConsumable item
        ) {
            this.item = item;
        }

        public ItemConsumable get() {
            return item;
        }

        abstract boolean embue(String health);
    }

    public enum Junk {

        TRASH(new ItemJunk("Trash"));

        ;

        private final ItemJunk item;

        Junk(
                ItemJunk item
        ) {
            this.item = item;
        }

        public ItemJunk get() {
            return item;
        }
    }

    public enum Material {

        WOOD(new ItemMaterial("Wood", 1))

        ;

        private final ItemMaterial item;

        Material(
                ItemMaterial item
        ) {
            this.item = item;
        }

        public ItemMaterial get() {
            return item;
        }

    }

    public enum Quest {

        APPLE(new ItemQuest("Apple"));

        private final ItemQuest item;

        Quest(
                ItemQuest item
        ) {
            this.item = item;
        }

        public ItemQuest get() {
            return item;
        }
    }

    public enum Treasure {

        HAND_OF_MIDAS(new ItemTreasure("Hand of Midas", 1_000_000))

        ;

        private final ItemTreasure item;

        Treasure(
                ItemTreasure item
        ) {
            this.item = item;
        }

        public ItemTreasure get() {
            return item;
        }
    }

    public enum Weapon {

        IRON_SWORD(new ItemWeapon("Iron Sword", SWORD, WeaponMaterial.WOOD, 10)),
        BOW(new ItemWeapon("Bow", WeaponType.LONGBOW, WeaponMaterial.WOOD, 20))

        ;

        private final ItemWeapon item;

        Weapon(
                ItemWeapon item
        ) {
            this.item = item;
        }

        public ItemWeapon get() {
            return item;
        }
    }
}
