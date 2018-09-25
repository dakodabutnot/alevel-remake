package com.dakoda.alr.game.world.quest;

import java.util.ArrayList;

public class QuestMaster {

    private ArrayList<Quest> currentQuests = new ArrayList<>();
    private ArrayList<Quest> completedQuests = new ArrayList<>();

    public boolean hasCompletedQuest(Quest quest) {
        return completedQuests.contains(quest);
    }

    public ArrayList<Quest> currentQuests() {
        return currentQuests;
    }

    public ArrayList<Quest> completedQuests() {
        return completedQuests;
    }

    public void addQuestIfAble(Quest quest) {
        if (quest.meetsQuestPrerequisites()) {
            addQuestOverride(quest);
        }
    }

    private void addQuestOverride(Quest quest) {
        currentQuests.add(quest);
    }

    public void moveQuestToComplete(Quest quest) {
        currentQuests.remove(quest);
        completedQuests.add(quest);
    }
}