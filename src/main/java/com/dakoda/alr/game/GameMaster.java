package com.dakoda.alr.game;

import com.dakoda.alr.content.ContentMaster;
import com.dakoda.alr.content.ContentRegistrar;
import com.dakoda.alr.game.world.location.LocationMaster;
import com.dakoda.alr.game.world.quest.QuestMaster;

/**
 * -> Singleton class. <-
 *
 * Only one instance of the class can exist in the program, and is
 * instantiated statically.
 * Other instances cannot be instantiated because the constructor
 * is private.
 *
 * The instance can be fetched with '.instance()'.
 *
 * The same is done for ContentMaster, QuestMaster, LocationMaster and Player.
 * They are all singletons because I only want one of them to ever exist
 * in the code.
 */
public final class GameMaster {

    private static GameMaster INSTANCE = new GameMaster();

    public ContentMaster content = ContentMaster.instance();
    public QuestMaster quest = QuestMaster.instance();
    public LocationMaster location = LocationMaster.instance();

    //Player
    public Player player;


    public void setPlayer(Player player) {
        this.player = player;
    }

    private GameMaster() {

    }

    public static GameMaster instance() {
        return INSTANCE;
    }

    public void addContent(ContentRegistrar registrar) {
        registrar.init();
    }

}

