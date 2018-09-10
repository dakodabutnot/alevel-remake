package com.dakoda.alr.item;

import com.dakoda.alr.item.type.ItemArmour;
import com.dakoda.alr.item.type.ItemWeapon;
import com.dakoda.alr.item.type.*;

public class Items {

    public enum Armours {

        ;

        private final ItemArmour item;

        Armours(
                ItemArmour item
        ) {
            this.item = item;
        }

        public ItemArmour get() {
            return item;
        }
    }

    public enum Consumables {

        APPLE(new ItemConsumable("Apple", ItemConsumable.Type.HEALTH)) {
            boolean embue(String health) {
                return true;
            }
        };

        private final ItemConsumable item;

        Consumables(
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

    public enum Materials {

        ;

        private final ItemMaterial item;

        Materials(
                ItemMaterial item
        ) {
            this.item = item;
        }

        public ItemMaterial get() {
            return item;
        }

    }

    public enum QuestItems {

        APPLE(new ItemQuest("Apple"));

        private final ItemQuest item;

        QuestItems(
                ItemQuest item
        ) {
            this.item = item;
        }

        public ItemQuest get() {
            return item;
        }
    }

    public enum Treasures {

        ;

        private final ItemTreasure item;

        Treasures(
                ItemTreasure item
        ) {
            this.item = item;
        }

        public ItemTreasure get() {
            return item;
        }
    }

    public enum Weapons {

        ;

        private final ItemWeapon item;

        Weapons(
                ItemWeapon item
        ) {
            this.item = item;
        }

        public ItemWeapon get() {
            return item;
        }
    }
}
