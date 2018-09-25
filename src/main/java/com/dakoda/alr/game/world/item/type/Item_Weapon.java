package com.dakoda.alr.game.world.item.type;

import com.dakoda.alr.game.mechanic.Currency;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.item.Item;
import com.dakoda.alr.game.GameObject;
import com.dakoda.alr.game.mechanic.Prerequisite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.dakoda.alr.game.world.entity.Progression.Profession.*;

public class Item_Weapon implements Item {

    private String name;
    private Item.Type type = Item.Type.WEAPON;
    private Integer currencyValue = 0;
    private Prerequisite prerequisite = null;
    private Type weaponType;

    public GameObject.Type objectType() {
        return GameObject.Type.ITEM;
    }

    public Item_Weapon withName(String name) {
        this.name = name;
        return this;
    }

    public Item_Weapon asWeaponType(Type weaponType) {
        this.weaponType = weaponType;
        return this;
    }

    public Item_Weapon withCurrencyValue(Integer currencyValue) {
        this.currencyValue = currencyValue;
        return this;
    }

    public Item_Weapon withUsagePrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public boolean doubleHanded() {
        return weaponType.isDoubleHanded();
    }

    public boolean ranged() {
        return weaponType.isRanged();
    }

    public ArrayList<Progression.Profession> applicableProfessions() {
        return weaponType.getApplicableProfessions();
    }

    public boolean meetsPrerequisite() {
        return prerequisite().requirement();
    }

    public String name() {
        return name;
    }

    public Item.Type type() {
        return type;
    }

    public String description() {
        return "This item is used in combat to deal damage, and can only be equipped by certain professions.";
    }

    public String sellDescription() {
        return "This item sells for " + Currency.convertToUnits(currencyValue);
    }

    public Integer currencyValue() {
        return currencyValue;
    }

    public Prerequisite prerequisite() {
        return prerequisite;
    }

    public enum Type {

        EMPTY("", false, false, null),
        // MELEE ----------------------------------------------------------
        SWORD("Sword",
                false,
                false,
                new ArrayList<>(Arrays.asList(DUELIST, PALADIN, ANTIQUER, ASSASSIN, PERFORATOR, NAGUAL, ARCHER, BARD))
        ),
        GREATSWORD("Greatsword",
                true,
                false,
                new ArrayList<>(Arrays.asList(DUELIST, PALADIN, ANTIQUER))
        ),
        DAGGER("Dagger",
                false,
                false,
                new ArrayList<>(Arrays.asList(ASSASSIN, NAGUAL, ARCHER, HUNTER, DUELIST, PERFORATOR))
        ),
        AXE("Axe",
                false,
                false,
                new ArrayList<>(Arrays.asList(DUELIST, PALADIN, CHRONOL, HUNTER))
        ),
        GREATAXE("Greataxe",
                true,
                false,
                new ArrayList<>(Arrays.asList(ANTIQUER, DUELIST, PALADIN))
        ),
        MACE("Mace",
                false,
                false,
                new ArrayList<>(Arrays.asList(HUNTER, PERFORATOR, NAGUAL))
        ),
        PIKE("Pike",
                true,
                false,
                new ArrayList<>(Arrays.asList(PERFORATOR, ANTIQUER, BARD))
        ),

        // RANGED ----------------------------------------------------------
        LONGBOW("Longbow",
                true,
                true,
                new ArrayList<>(Arrays.asList(ARCHER, ASSASSIN, NAGUAL, HUNTER))
        ),
        CROSSBOW("Crossbow",
                false,
                true,
                new ArrayList<>(Arrays.asList(ARCHER, HUNTER, NAGUAL))
        ),
        WAND("Wand",
                false,
                true,
                new ArrayList<>(Arrays.asList(ARCHER, PRIEST, CHRONOL, SHAMAN))
        ),
        STAFF("Staff",
                true,
                true,
                new ArrayList<>(Arrays.asList(ARCHER, PRIEST, CHRONOL, SHAMAN, ASSASSIN, PERFORATOR))
        ),
        TOME("Tome",
                true,
                true,
                new ArrayList<>(Arrays.asList(PRIEST, SHAMAN, CHRONOL, NAGUAL, ANTIQUER, PALADIN))
        ),
        INSTRUMENT("Instrument",
                true,
                true,
                new ArrayList<>(Collections.singletonList(BARD))
        ),
        HALLOW("Hallow",
                false,
                true,
                new ArrayList<>(Arrays.asList(BARD, PRIEST, SHAMAN, CHRONOL, NAGUAL, ASSASSIN))
        ),

        ;

        private String displayText;
        private boolean isDoubleHanded;
        private boolean isRanged;
        private ArrayList<Progression.Profession> usedBy;

        Type(
                String displayText,
                boolean isDoubleHanded,
                boolean isRanged,
                ArrayList<Progression.Profession> usedBy
        ) {
            this.displayText = displayText;
            this.isDoubleHanded = isDoubleHanded;
            this.isRanged = isRanged;
            this.usedBy = usedBy;
        }

        public String getDisplayText() {
            return displayText;
        }

        public boolean isDoubleHanded() {
            return isDoubleHanded;
        }

        public boolean isRanged() {
            return isRanged;
        }

        public ArrayList<Progression.Profession> getApplicableProfessions() {
            return usedBy;
        }
    }

    public enum Material {

        NONE, IRON, WOOD
    }
}
