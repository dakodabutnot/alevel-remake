package com.dakoda.alr.game;
import com.dakoda.alr.game.player.Player;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.registrar.*;
import com.dakoda.alr.game.world.location.Location;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dakoda.alr.game.registrar.Registrar.*;

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
        Registrar[] reg = {
                new RegistrarItem().init(),
                new RegistrarEntity().init(),
                new RegistrarLocation().init(),
                new RegistrarQuest().init(),
        }; contentRegistrars.addAll(Arrays.asList(reg));
        System.out.println("#COMPLETED_REG | Registered all content.");
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
