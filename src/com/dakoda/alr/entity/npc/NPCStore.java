package com.dakoda.alr.entity.npc;

import com.dakoda.alr.entity.npc.affinity.Aligned;
import com.dakoda.alr.entity.npc.affinity.Opinionated;

public class NPCStore implements EntityNPC, Aligned, Opinionated {

    @Override
    public String queryAlignment() {
        return null;
    }
}
