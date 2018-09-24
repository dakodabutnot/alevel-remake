package com.dakoda.alr.game;

public interface GameObject {

    String name();

    Type objectType();

    enum Type {
        ITEM, ENTITY, LOCATION, QUEST, RECIPE
    }

}
