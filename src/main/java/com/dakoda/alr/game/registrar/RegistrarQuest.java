package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.achievement.Moments;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.quest.QuestRequirement;
import com.dakoda.alr.game.world.entity.entities.hostile.HostileZombie;

import java.util.HashMap;

import static com.dakoda.alr.game.quest.QuestRequirement.Type.GET;
import static com.dakoda.alr.game.quest.QuestRequirement.Type.KILL;

public class RegistrarQuest implements Registrar {

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

    public HashMap<Integer, GameObject> getRegistered() {
        return null;
    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Quest) gameObject);
    }
}
