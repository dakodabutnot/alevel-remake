package com.dakoda.alr.game;
import com.dakoda.alr.game.player.Player;
import com.dakoda.alr.game.registrar.*;

import java.util.ArrayList;

import static com.dakoda.alr.game.registrar.Registrar.*;

public class GameMaster {

    //Player
    public Player player = new Player();
    //Registrars
    private ArrayList<Registrar> contentRegistrars = new ArrayList<>();
    {
        contentRegistrars.add(new RegistrarItem());
        contentRegistrars.add(new RegistrarEntity());
        contentRegistrars.add(new RegistrarLocation());
        contentRegistrars.add(new RegistrarQuest());
    }

    public void init() {
        for (Registrar registrar : contentRegistrars) {
            registrar.init();
        }
    }
}
