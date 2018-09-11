package com.dakoda.alr.game;
import com.dakoda.alr.item.Items;

public class TextRPG {

    //stop committing things irrelevant to the branch you're better than this

    public static void main(String[] args) {
        com.dakoda.alr.game.quest.Quest quest = new com.dakoda.alr.game.quest.Quest.QuestBuilder()
                .addItemRequirement(Items.Quest.APPLE.get(), 10)
                .build();
    }
}