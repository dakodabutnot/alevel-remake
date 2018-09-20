package com.dakoda.alr.game.quest;

import com.dakoda.alr.game.world.entity.Entity.Hostile;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.security.InvalidParameterException;
import java.util.HashMap;

public interface QuestObjective {

    String description();

    HashMap criteria();

    Boolean checkFinished();

    QuestObjective withDescription(String desc);

    QuestObjective withCriteria(Questable object, Integer needs) throws InvalidParameterException;

    static QuestObjective ofType(Type type) {
        switch (type) {
            case GET:
                return new QuestObjective_toGet();
            case GO:
                return new QuestObjective_toGo();
            case KILL:
                return new QuestObjective_toKill();
            default:
                return null;
        }
    }

    enum Type {
        GET, GO, KILL;
    }

    class QuestObjective_toGet implements QuestObjective {

        String description = "";
        HashMap<Item, Integer> criteria = new HashMap<>();

        public QuestObjective_toGet withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestObjective_toGet withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

    class QuestObjective_toGo implements QuestObjective {

        String description = "";
        HashMap<Location, Boolean> criteria = new HashMap<>();

        public String description() {
            return description;
        }

        public HashMap<Location, Boolean> criteria() {
            return criteria;
        }

        public QuestObjective_toGo withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestObjective_toGo withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

    class QuestObjective_toKill implements QuestObjective {

        String description = "";
        HashMap<Hostile, Integer> criteria = new HashMap<>();

        public QuestObjective_toKill withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public QuestObjective_toKill withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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
