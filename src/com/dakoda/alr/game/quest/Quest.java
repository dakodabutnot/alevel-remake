package com.dakoda.alr.game.quest;
import com.dakoda.alr.entity.hostile.EntityHostile;
import com.dakoda.alr.game.quest.exception.PointlessQuestException;
import com.dakoda.alr.item.Item;
import com.dakoda.alr.item.misc.quest.ItemQuest;
import com.dakoda.alr.loc.Location;
import java.util.HashMap;

public class Quest {

    private HashMap<EntityHostile, Integer> toKill = null;
    private boolean hasKilled = false;
    private Location toGo = null;
    private boolean hasGone = false;
    private HashMap<ItemQuest, Integer> toGet = null;
    private boolean hasGot = false;
    private boolean questDone = false;

    public boolean checkCanFinish() {
        if (hasKilled && hasGone && hasGot) {
            return finishQuest();
        } else {
            return false;
        }
    }

    private boolean finishQuest() {
        questDone = true;
        return true;
    }

    public boolean isQuestDone() {
        return questDone;
    }

    private void construct() {
        if (toKill == null) hasKilled = true;
        if (toGo == null) hasGone = true;
        if (toGet == null) hasGot = true;
        if (checkCanFinish()) {
            throw new PointlessQuestException("You tried to make a quest that does nothing.");
        }
    }

    public HashMap<EntityHostile, Integer> getToKill() {
        return toKill;
    }

    public Location getToGo() {
        return toGo;
    }

    public HashMap<ItemQuest, Integer> getToGet() {
        return toGet;
    }

    public HashMap<EntityHostile, Integer> queryToKill() {
        return getToKill();
    }

    public void tallyKill(EntityHostile entityHostile) {
        if (toKill.containsKey(entityHostile)) {
            toKill.replace(entityHostile, toKill.get(entityHostile) - 1);
        }
    }

    public void tallyItem(ItemQuest itemQuest) {
        if (toGet.containsKey(itemQuest)) {
            toGet.replace(itemQuest, toGet.get(itemQuest) - 1);
        }
    }

    public void validateLocation(Location location) {
        if (location.equals(toGo)) {
            hasGone = true;
        }
        checkCanFinish();
    }

    public void validateItems() {
        boolean hasItemsLeftToGet = false;
        for (Integer value : toGet.values()) {
            if (value > 0) {
                hasItemsLeftToGet = true;
            }
        }
        hasGot = !hasItemsLeftToGet;
        checkCanFinish();
    }

    public void validateKills() {
        boolean hasHostilesLeftToKill = false;
        for (Integer value : toKill.values()) {
            if (value > 0) {
                hasHostilesLeftToKill = true;
            }
        }
        hasGot = !hasHostilesLeftToKill;
        checkCanFinish();
    }

    public static class QuestBuilder {

        private HashMap<EntityHostile, Integer> toKill;
        private Location toGo;
        private HashMap<ItemQuest, Integer> toGet;

        public QuestBuilder() {

        }

        private void initToKill() {
            toKill = new HashMap<>();
        }

        private void initToGet() {
            toGet = new HashMap<>();
        }

        public QuestBuilder addKillRequirement(EntityHostile entityToKill, Integer numberToKill) {
            if (toKill == null) { initToKill(); }
            this.toKill.put(entityToKill, numberToKill);
            return this;
        }

        public QuestBuilder addItemRequirement(Item itemToGet, Integer numberToGet) {
            if (toGet == null) { initToGet(); }
            this.toGet.put((ItemQuest) itemToGet, numberToGet);
            return this;
        }

        public QuestBuilder setLocationRequirement(Location locationRequirement) {
            this.toGo = locationRequirement;
            return this;
        }

        public Quest build() {
            Quest quest = new Quest();
            quest.toKill = this.toKill;
            quest.toGo = this.toGo;
            quest.toGet = this.toGet;
            quest.construct();
            return quest;
        }
    }
}