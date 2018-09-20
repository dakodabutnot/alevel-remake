package com.dakoda.alr.game.registrar;

import com.dakoda.alr.game.GameContent;
import com.dakoda.alr.game.world.item.Item;

public class RegistrarItem implements Registrar {

    public void init() {

    }

    public void register(Integer id, GameObject gameObject) {
        GameContent.register(id, (Item) gameObject);
    }
}
