package com.dakoda.alr.game;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.item.all.ItemsQuest;

public class TextRPG {

    public static void main(String[] args) {
        Quest quest = new Quest.QuestBuilder()
                .addItemRequirement(ItemsQuest.APPLE.get(), 10)
                .build();
    }
}