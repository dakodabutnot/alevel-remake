package com.dakoda.alr.game.registrar;

public interface GameObject {

    String name();

    Type objectType();

    enum Type {
        ITEM, ENTITY, LOCATION, QUEST
    }

}
