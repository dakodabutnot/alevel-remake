package com.dakoda.alr.game;

import com.dakoda.alr.game.player.Player;
import com.dakoda.alr.game.world.character.Progression;
import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.quest.Quest;
import com.dakoda.alr.game.registrar.*;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.registrar.Registrar;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dakoda.alr.registrar.Registrar.*;

public final class GameMaster {

    //Player
    public Player player = new Player();
    //Registrars
    private static ArrayList<Registrar> contentRegistrars = new ArrayList<>();
    //Quest History
    private ArrayList<Quest> currentQuests = new ArrayList<>();
    private ArrayList<Quest> completedQuests = new ArrayList<>();
    //Location
    private Location currentLocation = null;

    static {
        System.out.println("////");
        Registrar[] reg = {
                new RegistrarItem().init(),
                new RegistrarEntity().init(),
                new RegistrarLocation().init(),
                new RegistrarQuest().init(),
        };
        contentRegistrars.addAll(Arrays.asList(reg));
        System.out.println("////");
        System.out.println("#WORLD | Registered all world content. -> we did it!");
    }

    {
        playerInit("Dakota",
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

    public Registrar registrar(Content registrar) {
        switch (registrar) {
            case ITEM:
                return contentRegistrars.get(0);
            case ENTITY:
                return contentRegistrars.get(1);
            case LOCATION:
                return contentRegistrars.get(2);
            case QUEST:
                return contentRegistrars.get(3);
            default:
                return null;
        }
    }

    public enum Content {
        ITEM, ENTITY, LOCATION, QUEST
    }
}
