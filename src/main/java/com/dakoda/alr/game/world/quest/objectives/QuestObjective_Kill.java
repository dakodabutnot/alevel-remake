package com.dakoda.alr.game.world.quest.objectives;

import com.dakoda.alr.game.world.entity.type.Entity_Hostile;
import com.dakoda.alr.game.world.quest.Questable;

import java.security.InvalidParameterException;
import java.util.HashMap;

import static com.dakoda.alr.game.world.quest.objectives.QuestObjective.Type.KILL;

public class QuestObjective_Kill implements QuestObjective {

    private String description = "";
    private HashMap<Entity_Hostile, Integer> criteria = new HashMap<>();
    private Type type = KILL;

    public QuestObjective_Kill withDescription(String desc) {
        this.description = desc;
        return this;
    }

    public QuestObjective_Kill withCriteria(Questable object, Integer needs) throws InvalidParameterException {
        if (!(object instanceof Entity_Hostile)) {
            throw new InvalidParameterException("Tried to parse a non-'Hostile' object to a quest requirement that consumes 'Hostile'.");
        } else {
            this.criteria.put((Entity_Hostile) object, needs);
        }
        return this;
    }

    public Boolean checkFinished() {
        Integer sum = 0;
        for (Integer value : criteria.values()) {
            sum += value;
        }
        return sum == 0;
    }

    public Type type() {
        return type;
    }

    public String description() {
        return description;
    }

    public HashMap<Entity_Hostile, Integer> criteria() {
        return criteria;
    }
}

