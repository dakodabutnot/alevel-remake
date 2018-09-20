package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.world.location.Location;

import java.util.HashMap;

public class RegistrarLocation implements Registrar {

    public void init() {
        //register Locations here

    }

    public HashMap<Integer, GameObject> getRegistered() {
        return null;
    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Location) gameObject);
    }
}
