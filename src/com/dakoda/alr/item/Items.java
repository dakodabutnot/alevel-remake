package com.dakoda.alr.item;
import com.dakoda.alr.item.type.ItemArmour;
import com.dakoda.alr.item.type.ItemWeapon;
import com.dakoda.alr.item.type.*;

public class Items {

    public enum Armour {

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
