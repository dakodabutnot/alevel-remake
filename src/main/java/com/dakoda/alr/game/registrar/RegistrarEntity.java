package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.world.entity.Entity;

public class RegistrarEntity implements Registrar {

    public void init() {
        //register Entities here
        //NPCs

        //Hostiles
    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Entity) gameObject);
    }
}
