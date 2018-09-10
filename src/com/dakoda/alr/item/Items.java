package com.dakoda.alr.item;

import com.dakoda.alr.item.consume.Consumable;
import com.dakoda.alr.item.consume.ConsumableType;
import com.dakoda.alr.item.craft.CraftingMaterial;
import com.dakoda.alr.item.equip.armour.Armour;
import com.dakoda.alr.item.equip.weapon.Weapon;
import com.dakoda.alr.item.misc.junk.ItemJunk;
import com.dakoda.alr.item.misc.quest.ItemQuest;
import com.dakoda.alr.item.misc.treasure.ItemTreasure;

public class Items {

    public enum Armours {

        ;

        private final Armour item;

        Armours(
                Armour item
        ) {
            this.item = item;
        }

        public Armour get() {
            return item;
        }
    }

    public enum Consumables {

        APPLE(new Consumable("Apple", ConsumableType.HEALTH)) {
            boolean embue(String health) {
                return true;
            }
        };

        private final Consumable item;

        Consumables(
                Consumable item
        ) {
            this.item = item;
        }

        public Consumable get() {
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

        private final CraftingMaterial item;

        Materials(
                CraftingMaterial item
        ) {
            this.item = item;
        }

        public CraftingMaterial get() {
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

        private final Weapon item;

        Weapons(
                Weapon item
        ) {
            this.item = item;
        }

        public Weapon get() {
            return item;
        }
    }
}
