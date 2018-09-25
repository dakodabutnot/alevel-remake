package com.dakoda.alr.content;

import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.exception.DuplicateContentIDException;
import com.dakoda.alr.game.exception.InvalidIDRequestException;
import com.dakoda.alr.game.exception.InvalidRegistrationRequestException;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.world.location.Location;
import com.dakoda.alr.game.world.quest.Quest;
import com.dakoda.alr.game.world.recipe.Recipe;

import java.util.HashMap;

public class ContentMaster {

    private HashMap<Integer, Item> itemMap = new HashMap<>();
    private HashMap<Integer, Entity> entityMap = new HashMap<>();
    private HashMap<Integer, Location> locationMap = new HashMap<>();
    private HashMap<Integer, Quest> questMap = new HashMap<>();
    private HashMap<Integer, Recipe> recipeMap = new HashMap<>();

    public void register(Integer id, Object object) {
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
                                    + "\t-> {OBJECT: " + ((Location) object).name() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + locationMap.get(id).name() + ", ID: " + id + "}"
                    );
                } else {
                    locationMap.put(id, (Location) object);
                }
            } else if (object instanceof Quest) {
                if (questMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (QUESTS) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + object.toString() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + questMap.get(id).toString() + ", ID: " + id + "}"
                    );
                } else {
                    questMap.put(id, (Quest) object);
                }
            } else if (object instanceof Recipe) {
                if (questMap.containsKey(id)) {
                    throw new DuplicateContentIDException(
                            "Two pieces of content (RECIPES) were registered with the same ID \n"
                                    + "\t-> {OBJECT: " + object.toString() + ", ID: " + id + "} -> " +
                                    "{OBJECT: " + recipeMap.get(id).toString() + ", ID: " + id + "}"
                    );
                } else {
                    recipeMap.put(id, (Recipe) object);
                }
            } else {
                throw new InvalidRegistrationRequestException("A GameObject that somehow isn't registerable tried to be registered.");
            }
            System.out.println("#REG " + ((GameObject) object).objectType() + " | Registered " + ((GameObject) object).name() + " ID " + id);
        } else {
            throw new InvalidRegistrationRequestException("An object that isn't a GameObject tried to register.");
        }
    }

    public Item findItemByID(Integer id) {
        if (!itemMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return itemMap.get(id);
        }
    }

    public Entity findEntityByID(Integer id) {
        if (!entityMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return entityMap.get(id);
        }
    }

    public Location findLocationByID(Integer id) {
        if (!locationMap.containsKey(id)) {
            throw new InvalidIDRequestException(
                    "Request was made for a piece of content that doesn't exist at that ID \n"
                            + "-> ID: " + id
            );
        } else {
            return locationMap.get(id);
        }
    }

    public Quest findQuestByID(Integer id) {
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
