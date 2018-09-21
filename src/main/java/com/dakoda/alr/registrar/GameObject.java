package com.dakoda.alr.registrar;

public interface GameObject {

    String name();

    Type objectType();

    enum Type {
        ITEM, ENTITY, LOCATION, QUEST
    }

}
