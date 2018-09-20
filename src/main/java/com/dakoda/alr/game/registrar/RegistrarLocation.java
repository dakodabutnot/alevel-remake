package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.world.location.Location;

public class RegistrarLocation implements Registrar {

    public void init() {
        //register Locations here

    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Location) gameObject);
    }
}
