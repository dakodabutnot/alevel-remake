package com.dakoda.alr.item.equip.weapon;
import com.dakoda.alr.game.profession.Profession;
import java.util.ArrayList;
import java.util.Arrays;

public enum WeaponType {

    SWORD("Sword",
            false,
            false,
            new ArrayList<>(Arrays.asList())
    ),
    GREATSWORD("Greatsword",
            true,
            false,
            new ArrayList<>(Arrays.asList())
    ),
    LONGBOW("Longbow",
            true,
            true,
            new ArrayList<>(Arrays.asList())
    ),
    WAND("Wand",
            false,
            true,
            new ArrayList<>(Arrays.asList())
    );

    private String displayText;
    private boolean isDoubleHanded;
    private boolean isRanged;
    private ArrayList<Profession> usedBy;

    WeaponType(
            String displayText,
            boolean isDoubleHanded,
            boolean isRanged,
            ArrayList<Profession> usedBy
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

    public ArrayList<Profession> getApplicableProfessions() {
        return usedBy;
    }
}
