package com.dakoda.alr.game.registrar;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import static com.dakoda.alr.TextRPG.master;
import static com.dakoda.alr.game.world.item.Item.Type.*;
import static com.dakoda.alr.game.world.location.Location.Type.SETTLEMENT;

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

            //Merchants

            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }

        public Entity findContentByName(String name) {
            return GameContent.findEntityByName(name);
        }

        public Entity findContentByID(Integer id) {
            return GameContent.findEntityByID(id);
        }
    }

    class RegistrarItem implements Registrar {

        public RegistrarItem init() {
            //register Items here
            register(0, ((Item.Consumable) Item.ofType(CONSUMABLE))
                    .withName("Ambrosia")
                    .withCurrencyValue(1_000)
                    .withUsagePrerequisite(
                            () -> TextRPG.master.player.reqIsLevel(5)
                    )
                    .withRestorationStat(Item.Consumable.Stat.HEALTH)
                    .withRestorationValue(500)
            );
            register(1, ((Item.Generic) Item.ofType(GENERIC))
                    .withName("Zombie Brain")
                    .withCurrencyValue(1)
            );
            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }

        public Item findContentByName(String name) {
            return GameContent.findItemByName(name);
        }

        public Item findContentByID(Integer id) {
            return GameContent.findItemByID(id);
        }
    }

    class RegistrarLocation implements Registrar {

        public RegistrarLocation init() {
            //register Locations here
            register(0,
                    Location.ofType(SETTLEMENT)
                    .withName("Xinces")
            );
            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }

        public Location findContentByName(String name) {
            return GameContent.findLocationByName(name);
        }

        public Location findContentByID(Integer id) {
            return GameContent.findLocationByID(id);
        }
    }

    class RegistrarQuest implements Registrar {

        public RegistrarQuest init() {
            //register Quests here

            return this;
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }

        public Quest findContentByID(Integer id) {
            return GameContent.findQuestByID(id);
        }

        public Quest findContentByName(String name) {
            return GameContent.findQuestByID(0);
        }
    }

}
