package com.dakoda.alr.client.fakecli.states.play.inventory;

import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.game.world.item.Inventory;
import com.dakoda.alr.game.world.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InventoryPrinter {

    private PageTrack pageTracker;
    private double pageLimit = 10;
    private ArrayList<Tab> tabs;

    enum TopBorder {
        CONSUMABLE(new FCLIText(    "┣━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓", true)),
        WEAPON(new FCLIText(        "┏━━━━━━━━━━━━━┻━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┓", true)),
        ARMOUR(new FCLIText(        "┏━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━━━━┓", true)),
        MISCELLANEOUS(new FCLIText( "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┫", true)),

        ;

        private final FCLIText text;

        TopBorder(FCLIText text) { 
            this.text = text;
        }
    }

    private final FCLIText topBorder = new FCLIText("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓", true);
    private final FCLIText separator = new FCLIText("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫", true);
    private final FCLIText separatorEmpty = new FCLIText("┣━━━━━━━━━━━There are no items here! :(━━━━━━━━━━┫", true);
    private final FCLIText botBorder = new FCLIText("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛", true);
    private final FCLIText itemEntry = new FCLIText("┃                                                ┃", true);

    public InventoryPrinter(Inventory inventory) {
        tabs = new ArrayList<>();
        tabs.add(generateTab("Consumable", inventory.getFiltered(Item.Type.CONSUMABLE)));
        tabs.add(generateTab("Weapon", inventory.getFiltered(Item.Type.WEAPON)));
        tabs.add(generateTab("Armour", inventory.getFiltered(Item.Type.ARMOUR)));
        tabs.add(generateTab("Miscellaneous", inventory.getFiltered(Item.Type.GENERIC)));
        this.pageTracker = new PageTrack();
        pageTracker.serveTab(tabs.get(0));
        pageTracker.setCurrentPage(1);
    }

    public Tab generateTab(String name, HashMap<Item, Integer> filteredInventory) {
        Tab tab = new Tab(name);
        double count = filteredInventory.entrySet().size();
        double pages = Math.ceil(count / pageLimit);
        boolean iteratedOnce = false;
        for (int i = 0; i < pages; i += 1) {
            iteratedOnce = true;
            FCLITextBundle page = new FCLITextBundle();
            page.insertSuffixingText(Arrays.stream(TopBorder.values())
                    .filter(border -> border.name().equalsIgnoreCase(name))
                    .findFirst().get().text);
            for (Map.Entry<Item, Integer> entry : filteredInventory.entrySet()) {
                page.insertSuffixingText(getItemEntryFCLIText(entry.getKey().name(), entry.getValue()));
                page.insertSuffixingText(separator);
            }
            page.insertSuffixingText(botBorder);
            tab.addPage(page);
        }
        if (!iteratedOnce) {
            tab.addPage(new FCLITextBundle(
                    topBorder,
                    separatorEmpty,
                    botBorder
            ));
        }
        return tab;
    }

    public ArrayList<Tab> getTabs() {
        return tabs;
    }

    public double getPageLimit() {
        return pageLimit;
    }

    class Tab {

        private String name;
        private TopBorder topBorder;
        private ArrayList<FCLITextBundle> pages = new ArrayList<>();

        public Tab(String name) {
            this.name = name;
            topBorder = Arrays.stream(TopBorder.values()).filter(border -> border.name().equalsIgnoreCase(name)).findFirst().get();
        }

        public void addPage(FCLITextBundle textBundle) {
            pages.add(textBundle);
        }

        public ArrayList<FCLITextBundle> getPages() {
            return pages;
        }

        public String getName() {
            return name;
        }
    }

    class PageTrack {

        private int currentPage;
        private Tab currentTab;

        public void setCurrentPage(int i) {
            currentPage = i;
        }

        public void serveTab(Tab currentTab) {
            this.currentTab = currentTab;
        }

        public int getCurrentPage() {
            return currentPage;
        }
    }

    public static void printItemEntry(FCLIText text) {
        GameState.print(text.get());
    }

    public FCLIText getItemEntryFCLIText(String itemName, Integer itemAmount) {
        FCLIText text = new FCLIText(itemEntry.get());
        return new FCLIText(
                text.get().substring(0, 2) +
                        itemName +
                        text.get().substring(2 + itemName.length(), itemEntry.getLength() - (3 + String.valueOf(itemAmount).length())) +
                        itemAmount +
                        text.get().substring(itemEntry.getLength() - 3, itemEntry.getLength())
        );
    }
}
