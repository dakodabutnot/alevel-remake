package com.dakoda.alr.game.world.entity;
import com.dakoda.alr.game.character.Attributes;
import com.dakoda.alr.game.world.entity.appearance.DNA;
import com.dakoda.alr.game.character.Profession;

public abstract class Entity {

    private String name;
    private Attributes attributes;
    private DNA dna;
    private Profession profession;

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