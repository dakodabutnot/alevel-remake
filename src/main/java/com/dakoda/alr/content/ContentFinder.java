package com.dakoda.alr.content;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.type.Entity_Hostile;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.Quest;

public interface ContentFinder {

    static Item findItemByID(Integer id) {
        return TextRPG.master.content.findItemByID(id);
    }

    static Entity findEntityByID(Integer id) {
        return TextRPG.master.content.findEntityByID(id);
    }

    static Entity_Hostile findHostileByID(Integer id) {
        return (Entity_Hostile) TextRPG.master.content.findEntityByID(id);
    }

    static Location findLocationByID(Integer id) {
        return TextRPG.master.content.findLocationByID(id);
    }

    static Quest findQuestByID(Integer id) {
        return TextRPG.master.content.findQuestByID(id);
    }

    static Integer findIDByItem(Item item) {
        return TextRPG.master.content.findIDByItem(item);
    }

    static Integer findIDByEntity(Entity entity) {
        return TextRPG.master.content.findIDByEntity(entity);
    }

    static Integer findIDByLocation(Location location) {
        return TextRPG.master.content.findIDByLocation(location);
    }

    static Integer findIDByQuest(Quest quest) {
        return TextRPG.master.content.findIDByQuest(quest);
    }

}
