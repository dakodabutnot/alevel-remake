package com.dakoda.alr.content.registrars.base;

import com.dakoda.alr.content.ContentRegistrar;

public class ContentRecipe_Default extends ContentRegistrar {

    private Integer ID = 0;

    protected Integer ID() {
        return ID++;
    }

    public void init() {

    }


}
