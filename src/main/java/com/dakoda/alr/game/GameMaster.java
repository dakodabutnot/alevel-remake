package com.dakoda.alr.game;

import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.location.Location;

import java.util.ArrayList;

public final class GameMaster {

    //Player
    public Player player = new Player();
    //Quest History
    private ArrayList<Quest> currentQuests = new ArrayList<>();
    private ArrayList<Quest> completedQuests = new ArrayList<>();
    //Location
    private Location currentLocation = null;

    //IMPORTANT
    //Game objects should be registered in this order:
    //  ITEM    -> ENTITY   -> LOCATION -> QUEST
    // or
    //  ITEM    -> ENTITY   -> QUEST    -> LOCATION

    //TEMPORARY PLAYER INIT
    {
        playerInit("Player",
                new Making(),
                Progression.Profession.BARD,
                new Inventory()
                        .withCurrencyValue(10L)
        );
    }

    public void playerInit(
            String name, Making making, Progression.Profession profession, Inventory inventory
    ) {
        System.out.print("#PLAYER | building... -> ");
        player.withName(name)
                .withMaking(making)
                .withProfession(profession)
                .withInitialInventory(inventory);
        System.out.println("DONE!");
    }

    public void addQuestIfAble(Quest quest) {
        if (quest.meetsQuestPrerequisites()) {
            addQuestOverridingAbility(quest);
        }
    }

    private void addQuestOverridingAbility(Quest quest) {
        currentQuests.add(quest);
    }

    public void moveQuestToComplete(Quest quest) {
        currentQuests.remove(quest);
        completedQuests.add(quest);
    }

    public void changeLocation(Location location) {
        this.currentLocation = location;
    }

    public Location currentLocation() {
        return currentLocation;
    }

    public boolean hasCompletedQuest(Quest quest) {
        return completedQuests.contains(quest);
    }

    public ArrayList<Quest> currentQuests() {
        return currentQuests;
    }

    public ArrayList<Quest> completedQuests() {
        return completedQuests;
    }
}
