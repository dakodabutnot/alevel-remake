package com.dakoda.alr.entity;
import com.dakoda.alr.entity.dna.DNA;
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