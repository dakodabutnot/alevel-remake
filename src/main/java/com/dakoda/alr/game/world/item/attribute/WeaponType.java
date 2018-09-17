package com.dakoda.alr.game.world.item.attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.dakoda.alr.game.character.Profession;
import static com.dakoda.alr.game.character.Profession.Type.*;

public enum WeaponType {

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
    private ArrayList<Profession.Type> usedBy;

    WeaponType(
            String displayText,
            boolean isDoubleHanded,
            boolean isRanged,
            ArrayList<Profession.Type> usedBy
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

    public ArrayList<Profession.Type> getApplicableProfessions() {
        return usedBy;
    }
}
