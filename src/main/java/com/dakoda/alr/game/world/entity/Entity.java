package com.dakoda.alr.game.world.entity;

import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.character.Progression.Profession;
import com.dakoda.alr.game.world.character.Progression;
import com.dakoda.alr.game.world.quest.Quest;
import com.dakoda.alr.game.world.quest.Questable;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("UnusedReturnValue")
public interface Entity extends GameObject, Questable {

    String name();

    Making making();

    Type type();

    Progression progression();

    Location location();

    Entity withName(String name);

    Entity withMaking(Making making);

    Entity withProfession(Profession profession);

    Entity atLocation(Location location);

    enum Type {
        NPC, HOSTILE, MERCHANT, PLAYER
    }

    class NPC implements Entity {

        String name;
        Making making;
        private Entity.Type type = Entity.Type.NPC;
        Progression progression;
        ArrayList<Quest> quests = new ArrayList<>();
        Location location;

        public GameObject.Type objectType() {
            return GameObject.Type.ENTITY;
        }

        public String name() {
            return name;
        }

        public Entity.Type type() {
            return type;
        }

        public Making making() {
            return making;
        }

        public Progression progression() {
            return progression;
        }

        public Location location() {
            return location;
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
            location.withNPC(this);
            return this;
        }
    }

    class Hostile implements Entity {

        private String name;
        private Entity.Type type = Entity.Type.HOSTILE;
        private Making making;
        private Progression progression;
        private Location location;
        private Loot loot;

        public GameObject.Type objectType() {
            return GameObject.Type.ENTITY;
        }

        public Loot loot() {
            return loot;
        }

        public Entity.Type type() {
            return type;
        }

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
            return null;
        }

        public Location location() {
            return null;
        }

        public Hostile withName(String name) {
            this.name = name;
            return this;
        }

        public Hostile withLoot(Loot loot) {
            this.loot = loot;
            return this;
        }


        public Hostile withMaking(Making making) {
            this.making = making;
            return this;
        }

        public Hostile withProfession(Profession profession) {
            this.progression = new Progression(profession);
            return this;
        }

        public Hostile atLocation(Location location) {
            return this;
        }
    }

    class Merchant extends NPC {

        private Entity.Type type = Entity.Type.MERCHANT;
        private HashMap<Item, Integer> goods = new HashMap<>();

        public HashMap<Item, Integer> goods() {
            return goods;
        }

        public Merchant withGood(Item item, Integer value) {
            goods.put(item, value);
            return this;
        }

        public Location location() {
            return location;
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
            location.withNPC(this);
            return this;
        }
    }
}