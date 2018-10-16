package com.dakoda.alr.client.fakecli.states.play.inventory;

import com.dakoda.alr.client.fakecli.Keyword;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.game.world.item.Item;

public enum InventoryTabs {

    CONSUMABLE(new FCLITextBundle(
            new FCLIText("┏━━━━━━━━━━━━━┓", true),
            new FCLIText("┃ "),
            new FCLIText("CONSUMABLES", Keyword.Items.CONSUMABLE.hex()),
            new FCLIText(" ┃ WEAPONS   ARMOUR   MISCELLANEOUS  ", true)), Item.Type.CONSUMABLE),
    WEAPON(new FCLITextBundle(
            new FCLIText("              ┏━━━━━━━━━┓", true),
            new FCLIText("  CONSUMABLES ┃ "),
            new FCLIText("WEAPONS", Keyword.Items.WEAPON.hex()),
            new FCLIText(" ┃ ARMOUR   MISCELLANEOUS  ", true)), Item.Type.WEAPON),
    ARMOUR(new FCLITextBundle(
            new FCLIText("                        ┏━━━━━━━━┓", true),
            new FCLIText("  CONSUMABLES   WEAPONS ┃ "),
            new FCLIText("ARMOUR", Keyword.Items.ARMOUR.hex()),
            new FCLIText(" ┃ MISCELLANEOUS  ", true)), Item.Type.ARMOUR),
    MISCELLANEOUS(new FCLITextBundle(
            new FCLIText("                                 ┏━━━━━━━━━━━━━━━┓", true),
            new FCLIText("  CONSUMABLES   WEAPONS   ARMOUR ┃ "),
            new FCLIText("MISCELLANEOUS", Keyword.Items.MISC.hex()),
            new FCLIText(" ┃", true)), Item.Type.GENERIC),

    ;

    private final FCLITextBundle text;
    private final Item.Type itemType;

    InventoryTabs(
            FCLITextBundle text,
            Item.Type itemType
    ) {
        this.text = text;
        this.itemType = itemType;
    }

    public FCLITextBundle value() {
        return text;
    }

    public Item.Type getItemType() {
        return itemType;
    }
}
