package com.dakoda.alr.game.world.quest;

import com.dakoda.alr.game.world.entity.Entity.Hostile;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.security.InvalidParameterException;
import java.util.HashMap;

import static com.dakoda.alr.game.world.quest.QuestObjective.Type.*;

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

    class toGet implements QuestObjective {

        String description = "";
        HashMap<Item, Integer> criteria = new HashMap<>();
        QuestObjective.Type type = GET;

        public toGet withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public Type type() {
            return this.type;
        }

        public toGet withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

    class toGo implements QuestObjective {

        String description = "";
        HashMap<Location, Boolean> criteria = new HashMap<>();
        QuestObjective.Type type = GO;

        public String description() {
            return description;
        }

        public HashMap<Location, Boolean> criteria() {
            return criteria;
        }

        public toGo withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public toGo withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

    class toKill implements QuestObjective {

        String description = "";
        HashMap<Hostile, Integer> criteria = new HashMap<>();
        QuestObjective.Type type = KILL;

        public toKill withDescription(String desc) {
            this.description = desc;
            return this;
        }

        public toKill withCriteria(Questable object, Integer needs) throws InvalidParameterException {
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

        public Type type() {
            return type;
        }

        public String description() {
            return description;
        }

        public HashMap<Hostile, Integer> criteria() {
            return criteria;
        }
    }
}
