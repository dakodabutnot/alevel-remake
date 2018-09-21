package com.dakoda.alr.game.world.location;

import com.dakoda.alr.game.Content;
import com.dakoda.alr.game.world.quest.Questable;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.Entity.Hostile;
import com.dakoda.alr.game.world.entity.Entity.NPC;

import java.util.HashSet;

import static com.dakoda.alr.game.world.location.Location.Type.ESTATE;
import static com.dakoda.alr.game.world.location.Location.Type.FIELD;
import static com.dakoda.alr.game.world.location.Location.Type.SETTLEMENT;

@SuppressWarnings("UnusedReturnValue")
public interface Location extends Questable, GameObject {

    Location withName(String name);

    Location withLevel(Integer level);

    Location withHostileEncounter(Hostile hostile);

    Location withNPC(NPC npc);

    Location linkedTo(Location location);

    String name();

    Boolean restable();

    Boolean encounterable();

    Integer level();

    Type type();

    HashSet<Hostile> hostiles();

    HashSet<NPC> NPCs();

    HashSet<Location> linkedLocations();

    enum Type {
        FIELD, SETTLEMENT, ESTATE, CAMP
    }

    class Field implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = true;
        private Integer level = 1;
        private Location.Type type = FIELD;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public GameObject.Type objectType() {
            return GameObject.Type.LOCATION;
        }

        public Field withName(String name) {
            this.name = name;
            return this;
        }

        public Field withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Field withHostileEncounter(Hostile hostile) {
            if (hostiles == null) hostiles = new HashSet<>();
            this.hostiles.add(hostile);
            return this;
        }

        public Field withHostileEncounter(String hostileName) {
            if (hostiles == null) hostiles = new HashSet<>();
            if (Content.findEntityByName(hostileName).type().equals(Entity.Type.HOSTILE)) {
                this.hostiles.add((Hostile) Content.findEntityByName(hostileName));
            }
            return this;
        }

        public Field withNPC(NPC npc) {
            return this;
        }

        public Field linkedTo(Location location) {
            if (linkedLocations == null) linkedLocations = new HashSet<>();
            this.linkedLocations.add(location);
            location.linkedTo(this);
            return this;
        }

        public String name() {
            return name;
        }

        public Boolean restable() {
            return restable;
        }

        public Boolean encounterable() {
            return encounterable;
        }

        public Integer level() {
            return level;
        }

        public Location.Type type() {
            return type;
        }

        public HashSet<Hostile> hostiles() {
            return hostiles;
        }

        public HashSet<NPC> NPCs() {
            return NPCs;
        }

        public HashSet<Location> linkedLocations() {
            return linkedLocations;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Field locObj = (Field) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Settlement implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = false;
        private Integer level = -1;
        private Location.Type type = SETTLEMENT;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public GameObject.Type objectType() {
            return GameObject.Type.LOCATION;
        }

        public Settlement withName(String name) {
            this.name = name;
            return this;
        }

        public Settlement withLevel(Integer level) {
            return this;
        }

        public Settlement withHostileEncounter(Hostile hostile) {
            return this;
        }

        public Settlement withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Settlement linkedTo(Location location) {
            if (linkedLocations == null) linkedLocations = new HashSet<>();
            this.linkedLocations.add(location);
            location.linkedTo(this);
            return this;
        }

        public String name() {
            return name;
        }

        public Boolean restable() {
            return restable;
        }

        public Boolean encounterable() {
            return encounterable;
        }

        public Integer level() {
            return level;
        }

        public Location.Type type() {
            return type;
        }

        public HashSet<Hostile> hostiles() {
            return hostiles;
        }

        public HashSet<NPC> NPCs() {
            return NPCs;
        }

        public HashSet<Location> linkedLocations() {
            return linkedLocations;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Settlement locObj = (Settlement) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Estate implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = false;
        private Integer level = -1;
        private Location.Type type = ESTATE;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public GameObject.Type objectType() {
            return GameObject.Type.LOCATION;
        }

        public Estate withName(String name) {
            this.name = name;
            return this;
        }

        public Estate withLevel(Integer level) {
            return this;
        }

        public Estate withHostileEncounter(Hostile hostile) {
            return this;
        }

        public Estate asInn() {
            restable = true;
            return this;
        }

        public Estate withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Estate linkedTo(Location location) {
            if (linkedLocations == null) linkedLocations = new HashSet<>();
            this.linkedLocations.add(location);
            location.linkedTo(this);
            return this;
        }

        public String name() {
            return name;
        }

        public Boolean restable() {
            return restable;
        }

        public Boolean encounterable() {
            return encounterable;
        }

        public Integer level() {
            return level;
        }

        public Location.Type type() {
            return type;
        }

        public HashSet<Hostile> hostiles() {
            return hostiles;
        }

        public HashSet<NPC> NPCs() {
            return NPCs;
        }

        public HashSet<Location> linkedLocations() {
            return linkedLocations;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Estate locObj = (Estate) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Camp implements Location {

        private String name = "";
        private Boolean restable = true;
        private Boolean encounterable = true;
        private Integer level = -1;
        private Location.Type type = ESTATE;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public GameObject.Type objectType() {
            return GameObject.Type.LOCATION;
        }

        public Camp withName(String name) {
            this.name = name;
            return this;
        }

        public Camp withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Camp withHostileEncounter(Hostile hostile) {
            if (hostiles == null) hostiles = new HashSet<>();
            this.hostiles.add(hostile);
            return this;
        }

        public Camp withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Camp linkedTo(Location location) {
            if (linkedLocations == null) linkedLocations = new HashSet<>();
            this.linkedLocations.add(location);
            location.linkedTo(this);
            return this;
        }

        public String name() {
            return name;
        }

        public Boolean restable() {
            return restable;
        }

        public Boolean encounterable() {
            return encounterable;
        }

        public Integer level() {
            return level;
        }

        public Location.Type type() {
            return type;
        }

        public HashSet<Hostile> hostiles() {
            return hostiles;
        }

        public HashSet<NPC> NPCs() {
            return NPCs;
        }

        public HashSet<Location> linkedLocations() {
            return linkedLocations;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Estate locObj = (Estate) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }
}
