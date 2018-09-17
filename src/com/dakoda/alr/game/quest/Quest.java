package com.dakoda.alr.game.quest;
import com.dakoda.alr.game.exception.PointlessQuestException;
import com.dakoda.alr.game.world.entity.Hostile;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.item.type.ItemQuest;
import com.dakoda.alr.game.world.location.Location;
import java.util.HashMap;

public final class Quest {

    private HashMap<Hostile, Integer> toKill = null;
    private HashMap<ItemQuest, Integer> toGet = null;
    private Location toGo = null;

    private boolean hasKilled, hasGone, hasGot, questDone = false;
    private String description;

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

    public String getDescription() {
        return description;
    }

    private void validateQuest() {
        if (toKill == null) hasKilled = true;
        if (toGo == null) hasGone = true;
        if (toGet == null) hasGot = true;
        if (checkCanFinish()) {
            throw new PointlessQuestException("You tried to make a quest that does nothing.");
        }
    }

    public HashMap<Hostile, Integer> getToKill() {
        return toKill;
    }

    public Location getToGo() {
        return toGo;
    }

    public HashMap<ItemQuest, Integer> getToGet() {
        return toGet;
    }

    public HashMap<Hostile, Integer> queryToKill() {
        return getToKill();
    }

    public void tallyKill(Hostile hostile) {
        if (toKill.containsKey(hostile)) {
            toKill.replace(hostile, toKill.get(hostile) - 1);
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
        hasKilled = !hasHostilesLeftToKill;
        checkCanFinish();
    }

    public static class QuestBuilder {

        private HashMap<Hostile, Integer> toKill;
        private Location toGo;
        private HashMap<ItemQuest, Integer> toGet;
        private String description;

        private void initToKill() {
            toKill = new HashMap<>();
        }

        private void initToGet() {
            toGet = new HashMap<>();
        }

        public QuestBuilder addKillRequirement(Hostile entityToKill, Integer numberToKill) {
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

        public QuestBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Quest build() {
            Quest quest = new Quest();
            quest.toKill = this.toKill;
            quest.toGo = this.toGo;
            quest.toGet = this.toGet;
            quest.description = this.description;
            quest.validateQuest();
            return quest;
        }
    }
}