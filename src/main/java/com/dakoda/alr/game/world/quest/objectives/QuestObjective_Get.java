package com.dakoda.alr.game.world.quest.objectives;

import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.quest.Questable;

import java.security.InvalidParameterException;
import java.util.HashMap;

import static com.dakoda.alr.game.world.quest.objectives.QuestObjective.Type.GET;

public class QuestObjective_Get implements QuestObjective {

    private String description = "";
    private HashMap<Item, Integer> criteria = new HashMap<>();
    private Type type = GET;

    public QuestObjective_Get withDescription(String desc) {
        this.description = desc;
        return this;
    }

    public Type type() {
        return this.type;
    }

    public QuestObjective_Get withCriteria(Questable object, Integer needs) throws InvalidParameterException {
        if (!(object instanceof Item)) {
            throw new InvalidParameterException("Tried to parse a non-'Item' object to a quest requirement that consumes 'Item'.");
        } else {
            this.criteria.put((Item) object, needs);
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

    public String description() {
        return description;
    }

    public HashMap<Item, Integer> criteria() {
        return criteria;
    }
}
