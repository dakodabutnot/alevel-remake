package com.dakoda.alr.item.craft;

public enum Discipline {

    CHEF("Chef"),
    BLACKSMITH("Blacksmith");

    private String displayText;

    Discipline(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
