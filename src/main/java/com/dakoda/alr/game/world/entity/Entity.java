package com.dakoda.alr.game.world.entity;
import com.dakoda.alr.game.character.Attributes;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.entity.appearance.DNA;
import com.dakoda.alr.game.character.Profession;

import java.util.ArrayList;

public abstract class Entity implements GameObject {

    private String name;
    private Attributes attributes;
    private DNA dna;
    private Profession profession;

    private ArrayList<Quest> quests;

    public Attributes getAttributes() {
        return attributes;
    }

    public DNA getDNA() {
        return dna;
    }

    public Profession getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }
}