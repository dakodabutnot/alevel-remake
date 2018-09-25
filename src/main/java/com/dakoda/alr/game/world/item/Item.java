package com.dakoda.alr.game.world.item;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;
import com.dakoda.alr.game.world.quest.Questable;

/**
 * This class is supposedly using...
 * -> Template pattern. <-
 *
 * The class is giving a template of methods that all
 * inheriting classes must use. Since this is an interface and that's
 * what they're for, I'm questioning why this needs
 * to have a name. Maybe it was just that one site?
 */
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