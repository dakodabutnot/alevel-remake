package com.dakoda.alr.entity.npc.affinity;
import java.util.EnumMap;

public class Alignment {

    private EnumMap<Faction, Float> alignments = new EnumMap<>(Faction.class);

    public Alignment() {
//        must initialize all values to a float
    }
}
