package com.dakoda.alr.client.fakecli.states.play.inventory;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.game.world.item.type.Item_Generic;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.dakoda.alr.TextRPG.master;
import static com.dakoda.alr.client.fakecli.states.GameState.findState;
import static com.dakoda.alr.client.fakecli.states.GameState.print;

public class GameState_Play_Inventory implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private String name = "PLAY_INVENTORY";
    public static Tab currentTab;
    private InventoryPrinter inventoryPrinter;

    public enum Tab {
        CONSUMABLE,
        WEAPON,
        ARMOUR,
        MISCELLANEOUS,

        ;
    }

    public void preloop() {

    }

    public String name() {
        return name;
    }

    public void reset() {
        currentInput = "";
        this.inventoryPrinter = new InventoryPrinter(master.player.inventory());
    }

    public void set() {
        this.active = true;
        currentTab = Tab.MISCELLANEOUS;
        master.player.inventory().addItem(new Item_Generic().withName("Generic item").withCurrencyValue(3), 1);
        reset();
    }

    public boolean active() {
        return active;
    }

    public void printInfo() {
        print(Arrays.stream(InventoryTabs.values()).filter(tab -> tab.name().equalsIgnoreCase(currentTab.name())).findFirst().orElse(null).value());
        for (FCLITextBundle page : inventoryPrinter.getTabs().stream()
                        .filter(tab -> tab.getName().equalsIgnoreCase(currentTab.name()))
                        .findFirst().get().getPages()) {
            page.getTexts().forEach(InventoryPrinter::printItemEntry);
        }
    }

    public void printOptions() {

    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        switch (currentInput) {
            case "c":
            case "cons":
            case "consumable":
            case "consumables":
                changeTab(Tab.CONSUMABLE);
                reset();
                break;
            case "w":
            case "wep":
            case "weapon":
            case "weapons":
                changeTab(Tab.WEAPON);
                reset();
                break;
            case "a":
            case "arm":
            case "armour":
            case "armor":
            case "armours":
            case "armors":
                changeTab(Tab.ARMOUR);
                reset();
                break;
            case "g":
            case "gen":
            case "generic":
            case "m":
            case "misc":
            case "miscellaneous":
            case "miscalaneous":
            case "miscalleaneous":
                changeTab(Tab.MISCELLANEOUS);
                reset();
                break;
            default:
                reset();
                break;
        }
    }

    private void changeTab(Tab tab) {
        this.currentTab = tab;
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void deactivate() {
        this.active = false;
    }

    public void deactivateAndPush(GameState state) {
        this.active = false;
        FCLIMaster.instance().stateMaster().pushState(state);
    }

    public void deactivateAndPush(GameState ... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }

    public void retainAndPush(GameState state) {
        deactivateAndPush(
                findState(this.name),
                state
        );
    }

    public void retainAndPush(GameState ... states) {
        deactivateAndPush(findState(this.name));
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
    }

    public void activate() {
        this.active = true;
    }
}
