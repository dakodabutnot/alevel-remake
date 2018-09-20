package com.dakoda.alr.game;
import com.dakoda.alr.game.player.Player;
import com.dakoda.alr.game.registrar.*;

public class GameMaster {

    //Player
    public Player player = new Player();
    //Registrars
    private Registrar itemRegistrar = new RegistrarItem();
    private Registrar entityRegistrar = new RegistrarEntity();
    private Registrar locationRegistrar = new RegistrarLocation();
    private Registrar questRegistrar = new RegistrarQuest();

    public void init() {
        itemRegistrar.init();
        entityRegistrar.init();
        locationRegistrar.init();
        questRegistrar.init();
    }
}
