package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.achievement.Moments;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.quest.QuestRequirement;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.entities.hostile.HostileZombie;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import static com.dakoda.alr.game.quest.QuestRequirement.Type.GET;
import static com.dakoda.alr.game.quest.QuestRequirement.Type.KILL;

public interface Registrar {

    void register(Integer id, GameObject gameObject);

    void init();

    class RegistrarEntity implements Registrar {

        public void init() {
            //register Entities here
            //NPCs

            //Hostiles
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, (Entity) gameObject);
        }
    }

    class RegistrarItem implements Registrar {

        public void init() {
            //register Items here

        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, (Item) gameObject);
        }
    }

    class RegistrarLocation implements Registrar {

        public void init() {
            //register Locations here

        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, (Location) gameObject);
        }
    }

    class RegistrarQuest implements Registrar {

        public void init() {
            //register Quests here
            register(0, new Quest()
                    .withDescription("A zombie has been terrorising the village!")
                    .withRequirement(QuestRequirement
                            .ofType(KILL)
                            .withDescription("We need that zombie killed!")
                            .withCriteria(new HostileZombie(), 1)
                    )
                    .withRequirement(QuestRequirement
                            .ofType(GET)
                            .withDescription("Could you fetch the zombie's brain for me too? After you've killed it, of course.")
                    )
                    .requiresMoment(Moments.PLAYER_LEVEL_5)
                    .completesMoment(Moments.COMPLETED_ZOMBIE_QUEST)
                    .withExperienceReward(10)
                    .withCurrencyReward(5)
            );
        }

        public void register(Integer id, GameObject gameObject) {
            GameContent.register(id, (Quest) gameObject);
        }
    }

}