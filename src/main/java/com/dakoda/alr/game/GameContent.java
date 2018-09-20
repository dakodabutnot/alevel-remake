package com.dakoda.alr.game;

import com.dakoda.alr.game.exception.DuplicateContentIDException;
import com.dakoda.alr.game.exception.InvalidIDRequestException;
import com.dakoda.alr.game.exception.InvalidRegistrationRequestException;
import com.dakoda.alr.game.exception.NullItemRequestException;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GameContent {

    private static HashMap<Integer, Item> itemMap = new HashMap<>();
    private static HashMap<Integer, Entity> entityMap = new HashMap<>();
    private static HashMap<Integer, Location> locationMap = new HashMap<>();
    private static HashMap<Integer, Quest> questMap = new HashMap<>();

    public static void register(Integer id, Object object) {
        if ((object instanceof GameObject)) {
            if (object instanceof Item) {
                if (itemMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (ITEMS) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + ((Item) object).name() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + itemMap.get(id).name() + ", ID: " + id + "}"
                    );
                } else {
                    itemMap.put(id, (Item) object);
                }
            } else if (object instanceof Entity) {
                if (entityMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (ENTITIES) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + ((Entity) object).name() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + entityMap.get(id).name() + ", ID: " + id + "}"
                    );
                } else {
                    entityMap.put(id, (Entity) object);
                }
            } else if (object instanceof Location) {
                if (locationMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (LOCATIONS) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + ((Location) object).getName() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + locationMap.get(id).getName() + ", ID: " + id + "}"
                    );
                } else {
                    locationMap.put(id, (Location) object);
                }
            } else if (object instanceof Quest) {
                if (questMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (QUESTS) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + ((Quest) object).getDescription() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + questMap.get(id).getDescription() + ", ID: " + id + "}"
                    );
                } else {
                    questMap.put(id, (Quest) object);
                }
            } else {
                throw new InvalidRegistrationRequestException("A GameObject that somehow isn't registerable tried to be registered.");
            }
            System.out.println("#REG | Registered object " + object + " with an ID of " + id);
        } else {
            throw new InvalidRegistrationRequestException("An object that isn't a GameObject tried to register.");
        }
    }

    public static Item findItemByID(Integer id) {
        if (!itemMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                    + "-> ID: " + id
            );
        } else {
            return itemMap.get(id);
        }
    }

    public static Item findItemByName(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return itemMap.values()
                    .stream()
                    .filter(item -> item.name().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Item fibn(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return itemMap.values()
                    .stream()
                    .filter(item -> item.name().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Entity findEntityByID(Integer id) {
        if (!entityMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return entityMap.get(id);
        }
    }

    public static Entity findEntityByName(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return entityMap.values()
                    .stream()
                    .filter(entity -> entity.name().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Entity febn(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return entityMap.values()
                    .stream()
                    .filter(entity -> entity.name().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Location findLocationByID(Integer id) {
        if (!locationMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return locationMap.get(id);
        }
    }

    public static Location findLocationByName(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return locationMap.values()
                    .stream()
                    .filter(location -> location.getName().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Location flbn(String name) {
        if (name == null) {
            throw new NullItemRequestException("Request was made for a null piece of content.");
        } else {
            return locationMap.values()
                    .stream()
                    .filter(location -> location.getName().equalsIgnoreCase(name))
                    .findFirst().get();
        }
    }

    public static Quest findQuestByID(Integer id) {
        if (!questMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return questMap.get(id);
        }
    }
}
