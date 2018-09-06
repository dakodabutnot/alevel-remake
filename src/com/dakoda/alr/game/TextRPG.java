package com.dakoda.alr.game;
import com.dakoda.alr.game.quest.Quest;

public class TextRPG {

    public static void main(String[] args) {
        Quest quest = new Quest.QuestBuilder()
                .addItemRequirement(null, 1)
                .build();
    }
}