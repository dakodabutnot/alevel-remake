package com.dakoda.alr.game.world.location;
import com.dakoda.alr.game.quest.Questable;
import com.dakoda.alr.game.registrar.GameObject;
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

    static Location ofType(Type type) {
        switch (type) {
            case FIELD:
                return new Location_Field();
            case SETTLEMENT:
                return new Location_Settlement();
            case ESTATE:
                return new Location_Estate();
            case CAMP:
                return new Location_Camp();
            default:
                return null;
        }
    }

    enum Type {
        FIELD, SETTLEMENT, ESTATE, CAMP
    }

    class Location_Field implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = true;
        private Integer level = 1;
        private Type type = FIELD;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public Location_Field withName(String name) {
            this.name = name;
            return this;
        }

        public Location_Field withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Location_Field withHostileEncounter(Hostile hostile) {
            if (hostiles == null) hostiles = new HashSet<>();
            this.hostiles.add(hostile);
            return this;
        }

        public Location_Field withNPC(NPC npc) {
            return this;
        }

        public Location_Field linkedTo(Location location) {
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

        public Type type() {
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
                Location_Field locObj = (Location_Field) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Location_Settlement implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = false;
        private Integer level = -1;
        private Type type = SETTLEMENT;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public Location_Settlement withName(String name) {
            this.name = name;
            return this;
        }

        public Location_Settlement withLevel(Integer level) {
            return this;
        }

        public Location_Settlement withHostileEncounter(Hostile hostile) {
            return this;
        }

        public Location_Settlement withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Location_Settlement linkedTo(Location location) {
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

        public Type type() {
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
                Location_Settlement locObj = (Location_Settlement) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Location_Estate implements Location {

        private String name = "";
        private Boolean restable = false;
        private Boolean encounterable = false;
        private Integer level = -1;
        private Type type = ESTATE;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public Location_Estate withName(String name) {
            this.name = name;
            return this;
        }

        public Location_Estate withLevel(Integer level) {
            return this;
        }

        public Location_Estate withHostileEncounter(Hostile hostile) {
            return this;
        }

        public Location_Estate asInn() {
            restable = true;
            return this;
        }

        public Location_Estate withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Location_Estate linkedTo(Location location) {
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

        public Type type() {
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
                Location_Estate locObj = (Location_Estate) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Location_Camp implements Location {

        private String name = "";
        private Boolean restable = true;
        private Boolean encounterable = true;
        private Integer level = -1;
        private Type type = ESTATE;
        private HashSet<Hostile> hostiles = null;
        private HashSet<NPC> NPCs = null;
        private HashSet<Location> linkedLocations = null;

        public Location_Camp withName(String name) {
            this.name = name;
            return this;
        }

        public Location_Camp withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Location_Camp withHostileEncounter(Hostile hostile) {
            if (hostiles == null) hostiles = new HashSet<>();
            this.hostiles.add(hostile);
            return this;
        }

        public Location_Camp withNPC(NPC npc) {
            if (NPCs == null) NPCs = new HashSet<>();
            this.NPCs.add(npc);
            npc.atLocation(this);
            return this;
        }

        public Location_Camp linkedTo(Location location) {
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

        public Type type() {
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
                Location_Estate locObj = (Location_Estate) obj;
                return locObj.name().equals(name())
                        && locObj.type().equals(type());
            } catch (Exception e) {
                return false;
            }
        }
    }
}
