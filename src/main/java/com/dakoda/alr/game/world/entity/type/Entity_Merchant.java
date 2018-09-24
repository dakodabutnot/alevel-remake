package com.dakoda.alr.game.world.entity.type;

import com.dakoda.alr.game.world.entity.Making;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.util.HashMap;

public class Entity_Merchant extends Entity_NPC {

    private Type type = Type.MERCHANT;
    private HashMap<Item, Integer> goods = new HashMap<>();

    public HashMap<Item, Integer> goods() {
        return goods;
    }

    public Entity_Merchant withGood(Item item, Integer value) {
        goods.put(item, value);
        return this;
    }

    public Location location() {
        return location;
    }

    @Override
    public Entity_Merchant withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Entity_Merchant withMaking(Making making) {
        this.making = making;
        return this;
    }

    @Override
    public Entity_Merchant withProfession(Progression.Profession profession) {
        this.progression = new Progression(profession);
        return this;
    }

    @Override
    public Entity_Merchant atLocation(Location location) {
        this.location = location;
        location.withNPC(this);
        return this;
    }
}
