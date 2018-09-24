package com.dakoda.alr.game.world.item;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;
import com.dakoda.alr.game.world.quest.Questable;

public interface Item extends Questable, GameObject {

    String name();

    Type type();

    String description();

    String sellDescription();

    Integer currencyValue();

    Prerequisite prerequisite();

    Item withName(String name);

    Item withCurrencyValue(Integer currencyValue);

    Item withUsagePrerequisite(Prerequisite prerequisite);

    boolean meetsPrerequisite();

    enum Type {
        GENERIC, ARMOUR, WEAPON, CONSUMABLE
    }
}