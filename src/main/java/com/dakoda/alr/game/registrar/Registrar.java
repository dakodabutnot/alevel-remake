package com.dakoda.alr.game.registrar;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.Content;
import com.dakoda.alr.game.battle.Loot;
import com.dakoda.alr.game.world.quest.Quest;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.QuestObjective;

import static com.dakoda.alr.game.Content.findItemByName;

@SuppressWarnings("ConstantConditions")
public interface Registrar {

    void register(Integer id, GameObject gameObject);

    Registrar init();

    public GameObject findContentByID(Integer id);

    public GameObject findContentByName(String name);

    class RegistrarEntity implements Registrar {

        public RegistrarEntity init() {
            //register Entities here
            //NPCs

            //Hostiles
            register(0, new Entity
                    .Hostile()
                    .withName("Zombie")
                    .withLoot(new Loot()
                            .withDrop(findItemByName("Zombie Brain"), 1))
            );
            //Merchants

            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            Content.register(id, gameObject);
        }

        public Entity findContentByName(String name) {
            return Content.findEntityByName(name);
        }

        public Entity findContentByID(Integer id) {
            return Content.findEntityByID(id);
        }
    }

    class RegistrarItem implements Registrar {

        public RegistrarItem init() {
            // IMPORTANT --
            register(0, new Item.Weapon()
                    .withName("DEFAULT_WEP")
                    .asWeaponType(Item.Weapon.Type.EMPTY)
            );
            register(1, new Item.Armour()
                    .withName("DEFAULT_ARM")
                    .equippableOn(Item.Armour.Slot.ANY)
                    .withMaterial(Item.Armour.Material.NONE)
            );
            // -------------------------------------------
            //register Items here
            register(2, new Item.Generic()
                    .withName("Zombie Brain")
                    .withCurrencyValue(1)
            );
            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            Content.register(id, gameObject);
        }

        public Item findContentByName(String name) {
            return findItemByName(name);
        }

        public Item findContentByID(Integer id) {
            return Content.findItemByID(id);
        }
    }

    class RegistrarLocation implements Registrar {

        public RegistrarLocation init() {
            //register Locations here
            register(0, new Location.Settlement()
                    .withName("Xinces")
            );
            register(1, new Location.Field()
                    .withName("Candour Fields")
                    .withHostileEncounter(findHostileByName("Zombie"))
                    .withLevel(1)
            );
            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            Content.register(id, gameObject);
        }

        public Location findContentByName(String name) {
            return Content.findLocationByName(name);
        }

        public Location findContentByID(Integer id) {
            return Content.findLocationByID(id);
        }

        public Entity.Hostile findHostileByName(String name) {
            try {
                return (Entity.Hostile) Content.findEntityByName(name);
            } catch (Exception e) {
                return null;
            }
        }
    }

    class RegistrarQuest implements Registrar {

        public RegistrarQuest init() {
            //register Quests here
            register(0, new Quest()
                    .withDescription("A zombie is terrorising the village!")
                    .withObjective(new QuestObjective.toKill()
                            .withDescription("Kill the zombie.")
                            .withCriteria(findHostileByName("Zombie"), 1))
                    .withObjective(new QuestObjective.toGet()
                            .withDescription("Fetch the zombie's brain as proof.")
                            .withCriteria(findItemByName("zombie brain"), 1)
                    )
                    .withCurrencyReward(5)
                    .withExperienceReward(10)
                    .requiresThat(
                            () -> TextRPG.master.player.reqIsLevel(2)
                    )
            );
            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            Content.register(id, gameObject);
        }

        public Quest findContentByID(Integer id) {
            return Content.findQuestByID(id);
        }

        public Quest findContentByName(String name) {
            return Content.findQuestByID(0);
        }

        public Entity.Hostile findHostileByName(String name) {
            try {
                return (Entity.Hostile) Content.findEntityByName(name);
            } catch (Exception e) {
                return null;
            }
        }
    }

}
