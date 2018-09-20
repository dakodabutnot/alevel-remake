package com.dakoda.alr;

import static com.dakoda.alr.game.Content.*;

import com.dakoda.alr.game.mechanic.Moments;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.quest.QuestRequirement;
import com.dakoda.alr.game.world.entity.entities.hostile.HostileZombie;
import com.dakoda.alr.game.world.entity.entities.npc.NPC;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.item.type.ItemQuest;

import static com.dakoda.alr.game.quest.QuestRequirement.Type.*;

public class TextRPG {

    private static Item zombie_brain = new ItemQuest("Zombie Brain");
    private static NPC npc = new NPC() {};

    public static void main(String[] args) {
        register(0, new Quest()
                .withDescription("A zombie has been terrorising the village!")
                .withRequirement(QuestRequirement
                        .ofType(KILL)
                        .withDescription("We need that zombie killed!")
                        .withCriteria(new HostileZombie(), 1)
                )
                .withRequirement(QuestRequirement
                        .ofType(GET)
                        .withDescription("Could you fetch the zombie's brain for me too? After you've killed it, of course.")
                        .withCriteria(zombie_brain, 1)
                )
                .requiresMoment(Moments.PLAYER_LEVEL_5)
                .completesMoment(Moments.COMPLETED_ZOMBIE_QUEST)
                .givenByNPC(npc)
        );
    }
}