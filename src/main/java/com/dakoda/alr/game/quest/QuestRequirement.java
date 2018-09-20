package com.dakoda.alr.game.quest;

import com.dakoda.alr.game.world.entity.Entity.Hostile;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.security.InvalidParameterException;
import java.util.HashMap;

public interface QuestRequirement {

    String description();

    HashMap criteria();

    Boolean checkFinished();

    QuestRequirement withDescription(String desc);

    QuestRequirement withCriteria(Questable object, Integer needs) throws InvalidParameterException;

    static QuestRequirement ofType(Type type) {
        switch (type) {
            case GET:
                return new QuestRequirement_toGet();
            case GO:
                return new QuestRequirement_toGo();
            case KILL:
                return new QuestRequirement_toKill();
            default:
                return null;
        }
    }

    enum Type {
        GET, GO, KILL;
    }

    class QuestRequirement_toGet implements QuestRequirement {

        String description = "";
        HashMap<Item, Integer> criteria = new HashMap<>();

        public QuestRequirement_toGet withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestRequirement_toGet withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

    class QuestRequirement_toGo implements QuestRequirement {

        String description = "";
        HashMap<Location, Boolean> criteria = new HashMap<>();

        public String description() {
            return description;
        }

        public HashMap<Location, Boolean> criteria() {
            return criteria;
        }

        public QuestRequirement_toGo withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestRequirement_toGo withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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
    }

    class QuestRequirement_toKill implements QuestRequirement {

        String description = "";
        HashMap<Hostile, Integer> criteria = new HashMap<>();

        public QuestRequirement_toKill withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestRequirement_toKill withCriteria(Questable object, Integer needs) throws InvalidParameterException {
            if (!(object instanceof Hostile)) {
                throw new InvalidParameterException("Tried to parse a non-'Hostile' object to a quest requirement that consumes 'Hostile'.");
            } else {
                this.criteria.put((Hostile) object, needs);
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

        public HashMap<Hostile, Integer> criteria() {
            return criteria;
        }
    }
}
