package com.dakoda.alr.item.equip;
import com.dakoda.alr.game.Profession;
import java.util.ArrayList;
import java.util.Arrays;

public enum WeaponType {

    SWORD("Sword",
            false,
            false,
            new ArrayList<>(Arrays.asList(Profession.WARRIOR))
    ),
    GREATSWORD("Greatsword",
            true,
            false,
            new ArrayList<>(Arrays.asList(Profession.WARRIOR))
    ),
    LONGBOW("Longbow",
            true,
            true,
            new ArrayList<>(Arrays.asList(Profession.RANGER))
    ),
    WAND("Wand",
            false,
            true,
            new ArrayList<>(Arrays.asList(Profession.MAGE))
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
