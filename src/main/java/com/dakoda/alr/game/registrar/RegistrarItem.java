package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.world.item.Item;

import java.util.HashMap;

public class RegistrarItem implements Registrar {

    public void init() {

    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Item) gameObject);
    }
}
