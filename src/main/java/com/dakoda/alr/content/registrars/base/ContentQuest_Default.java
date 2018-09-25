package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.content.ContentFinder;
import com.dakoda.alr.content.ContentRegistrar;
import com.dakoda.alr.game.world.quest.Quest;
import com.dakoda.alr.game.world.quest.objectives.QuestObjective_Kill;

public class ContentQuest_Default extends ContentRegistrar {

    private Integer ID = 0;

    protected Integer ID() {
        return ID++;
    }

    public void init() {
        //register Quests here
        register(0, new Quest()
                .withDescription("A zombie is terrorising the village!")
                .withObjective(new QuestObjective_Kill()
                        .withDescription("Kill the zombie.")
                        .withCriteria(ContentFinder.findEntityByID(0), 1))
                .withExperienceReward(10)
                .withCurrencyReward(20)
                .requiresThat(
                        () -> TextRPG.master.player.reqIsLevel(5)
                )
        );
    }
}