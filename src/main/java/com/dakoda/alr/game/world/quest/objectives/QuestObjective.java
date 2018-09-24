package com.dakoda.alr.game.world.quest.objectives;

import com.dakoda.alr.game.world.quest.Questable;

import java.security.InvalidParameterException;
import java.util.HashMap;

public interface QuestObjective {

    String description();

    HashMap criteria();

    Boolean checkFinished();

    Type type();

    QuestObjective withDescription(String desc);

    QuestObjective withCriteria(Questable object, Integer needs) throws InvalidParameterException;

    enum Type {
        GET, GO, KILL;
    }

}
