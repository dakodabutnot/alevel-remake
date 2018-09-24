package com.dakoda.alr.content.registrars;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.content.ContentFinder;

public class Registrar_Quest extends Registrar {

    public void init() {
        //register Quests here
        register(0, new Quest()
                .withDescription("A zombie is terrorising the village!")
                .withObjective(new QuestObjective.toKill()
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