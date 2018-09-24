package com.dakoda.alr.game.world.quest.objectives;

import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.Questable;

import java.security.InvalidParameterException;
import java.util.HashMap;

import static com.dakoda.alr.game.world.quest.objectives.QuestObjective.Type.GO;

public class QuestObjective_Go implements QuestObjective {

    private String description = "";
    private HashMap<Location, Boolean> criteria = new HashMap<>();
    private Type type = GO;

    public String description() {
        return description;
    }

    public HashMap<Location, Boolean> criteria() {
        return criteria;
    }

    public QuestObjective_Go withDescription(String desc) {
        this.description = desc;
        return this;
    }

    public QuestObjective_Go withCriteria(Questable object, Integer needs) throws InvalidParameterException {
        if (!(object instanceof Location)) {
            throw new InvalidParameterException("Tried to parse a non-'Location' object to a quest requirement that consumes 'Location'.");
        } else {
            this.criteria.put((Location) object, Boolean.FALSE);
        }
        return this;
    }

    public Boolean checkFinished() {
        Boolean done = Boolean.FALSE;
        for (Boolean value : criteria.values()) {
            done = value;
        }
        return done;
    }

    public Type type() {
        return type;
    }
}
