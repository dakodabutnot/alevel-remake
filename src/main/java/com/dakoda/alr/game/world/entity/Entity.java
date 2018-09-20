package com.dakoda.alr.game.world.entity;

import com.dakoda.alr.game.character.Inventory;
import com.dakoda.alr.game.character.Profession;
import com.dakoda.alr.game.character.Progression;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

public interface Entity extends GameObject {

    String name();

    Making making();

    Progression progression();

    Entity withName(String name);

    Entity withMaking(Making making);

    Entity withProfession(Profession profession);

    Entity atLocation(Location location);

    static Entity ofType(Type type) {
        switch (type) {
            case NPC:
                return new NPC();
            case HOSTILE:
                return new Hostile();
            case MERCHANT:
                return new Merchant();
            default:
                return null;
        }
    }

    enum Type {
        NPC, HOSTILE, MERCHANT;
    }

    class NPC implements Entity {

        String name;
        Making making;
        Progression progression;
        ArrayList<Quest> quests = new ArrayList<>();
        Location location;

        public String name() {
            return name;
        }

        public Making making() {
            return making;
        }

        public Progression progression() {
            return progression;
        }

        public void registerQuest(Quest quest) {
            quests.add(quest);
        }

        public NPC withName(String name) {
            this.name = name;
            return this;
        }

        public NPC withMaking(Making making) {
            this.making = making;
            return this;
        }

        public NPC withProfession(Profession profession) {
            this.progression = new Progression(profession);
            return this;
        }

        public NPC atLocation(Location location) {
            this.location = location;
            // TODO: 20/09/2018 -> location.addEntity
            return this;
        }
    }

    class Hostile implements Entity {

        private String name;
        private Making making;
        private Progression progression;
        private Inventory inventory;
        Location location;

        public String name() {
            return name;
        }

        public Making making() {
            return making;
        }

        public Progression progression() {
            return progression;
        }

        public Inventory inventory() {
            return inventory;
        }

        public Hostile withName(String name) {
            this.name = name;
            return this;
        }

        public Hostile withMaking(Making making) {
            this.making = making;
            return this;
        }
        
        public Hostile withWeapon(Item.Weapon weapon) {
            // TODO: 20/09/2018 do Equipment, add to Inventory
            return this;
        }

        public Hostile withProfession(Profession profession) {
            this.progression = new Progression(profession);
            return this;
        }

        public Hostile withInventory(Inventory inventory) {
            this.inventory = inventory;
            return this;
        }

        public Hostile atLocation(Location location) {
            this.location = location;
            // TODO: 20/09/2018 -> location.addEntity
            return null;
        }
    }

    class Merchant extends NPC {

        private HashMap<Item, Integer> goods = new HashMap<>();

        public HashMap<Item, Integer> goods() {
            return goods;
        }

        public Merchant withGood(Item item, Integer value) {
            goods.put(item, value);
            return this;
        }

        @Override
        public Merchant withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Merchant withMaking(Making making) {
            this.making = making;
            return this;
        }

        @Override
        public Merchant withProfession(Profession profession) {
            this.progression = new Progression(profession);
            return this;
        }

        @Override
        public Merchant atLocation(Location location) {
            this.location = location;
            return this;
        }
    }
}