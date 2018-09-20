package com.dakoda.alr.game.registrar;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.GameMaster;
import com.dakoda.alr.game.achievement.Moments;
import com.dakoda.alr.game.character.Profession;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.quest.QuestRequirement;
import com.dakoda.alr.game.quest.QuestRequirementSpecial;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Item;

import static com.dakoda.alr.TextRPG.*;
import static com.dakoda.alr.game.GameContent.*;
import static com.dakoda.alr.game.quest.QuestRequirement.Type.*;
import static com.dakoda.alr.game.world.entity.Entity.Type.*;
import static com.dakoda.alr.game.world.entity.Making.*;
import static com.dakoda.alr.game.world.item.Item.*;
import static com.dakoda.alr.game.world.item.Item.Consumable.*;
import static com.dakoda.alr.game.world.item.Item.Type.*;

@SuppressWarnings("ConstantConditions")
public interface Registrar {

    void register(Integer id, GameObject gameObject);

    void init();

    class RegistrarEntity implements Registrar {

        public void init() {
            //register Entities here
            //NPCs

            //Hostiles

            //Merchants
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }
    }


    class RegistrarItem implements Registrar {

        public void init() {
            //register Items here

        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }
    }

    class RegistrarLocation implements Registrar {

        public void init() {
            //register Locations here

        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }
    }

    class RegistrarQuest implements Registrar {

        public void init() {
            //register Quests here

        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, gameObject);
        }
    }

}
