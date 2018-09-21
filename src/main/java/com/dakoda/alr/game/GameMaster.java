package com.dakoda.alr.game;
import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.player.Player;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.registrar.*;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dakoda.alr.game.registrar.Registrar.*;

public final class GameMaster {

    //Player
    public Player player = new Player();
    //Registrars
    private ArrayList<Registrar> contentRegistrars = new ArrayList<>();
    //Quest History
    private ArrayList<Quest> currentQuests = new ArrayList<>();
    private ArrayList<Quest> completedQuests = new ArrayList<>();

    {
        Registrar[] reg = {
                new RegistrarItem().init(),
                new RegistrarEntity().init(),
                new RegistrarLocation().init(),
                new RegistrarQuest().init(),
        }; contentRegistrars.addAll(Arrays.asList(reg));
    }

    public void moveQuestToComplete(Quest quest) {
        currentQuests.remove(quest);
        completedQuests.add(quest);
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
