package com.dakoda.alr.client.fakecli.states.charactercreate;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.components.FCLIOptionList;
import com.dakoda.alr.client.fakecli.components.FCLIText;
import com.dakoda.alr.client.fakecli.states.GameState;
import com.dakoda.alr.client.fakecli.states.TextJumbos;
import com.dakoda.alr.game.Player;
import com.dakoda.alr.game.PlayerInitializer;
import com.dakoda.alr.game.world.entity.Progression;
import com.dakoda.alr.game.world.item.Inventory;

import java.util.Arrays;

import static com.dakoda.alr.client.fakecli.states.GameState.print;
import static com.dakoda.alr.game.PlayerInitializer.modify;
import static com.dakoda.alr.game.PlayerInitializer.player;

public class GameState_CreateChar_Profession implements GameState {

    private boolean active = false;
    private String currentInput = "";
    private static final String name = "CREATE_CHARACTER_PROFESSION";

    public void preloop() {
    }

    public String name() {
        return name;
    }

    public void reset() {
        currentInput = "";
    }

    public void set() {
        this.active = true;
        reset();
    }

    public boolean active() {
        return active;
    }

    public void printInfo() {
        print(TextJumbos.CREATE_PROFESSION.value());
    }

    public void printOptions() {
        print(CreationDescriptions.PROFESSION.value());
        print(new FCLIOptionList(
                new FCLIOptionList(
                        new FCLIText("duelist", "#eda334"),
                        new FCLIText("paladin", "#59eff7"),
                        new FCLIText("antiquer", "#e85019"),
                        new FCLIText("perforator", "#e52727")
                ),
                new FCLIOptionList(
                        new FCLIText("archer", "#83f779"),
                        new FCLIText("assassin", "#c069e5"),
                        new FCLIText("nagual", "#e569d6"),
                        new FCLIText("hunter", "#9875ef")
                ),
                new FCLIOptionList(
                        new FCLIText("shaman", "#fff19b"),
                        new FCLIText("priest", "#fff838"),
                        new FCLIText("chronol", "#00a5ff"),
                        new FCLIText("bard", "#ff005d")
                )
        ).getFinalTextBundles());
    }

    public void parseInput(String s) {
        this.currentInput = s;
        triggerInputValidation();
    }

    public void triggerInputValidation() {
        Progression.Profession p = Arrays.stream(Progression.Profession.values())
                .filter(profession -> profession.name().equalsIgnoreCase(currentInput)).findFirst().orElse(null);
        if (p != null) {
            PlayerInitializer.newInventory();
            player().setProgression(p);
            deactivateAndPush(GameState.findState("PLAY_MAIN"));
        }
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void deactivate() {
        this.active = false;
        post();
    }

    public void deactivateAndPush(GameState state) {
        this.active = false;
        FCLIMaster.instance().stateMaster().pushState(state);
        post();
    }

    public void activate() {
        this.active = true;
    }

    public void deactivateAndPushMultiple(GameState ... states) {
        this.active = false;
        for (GameState state : states) {
            FCLIMaster.instance().stateMaster().pushState(state);
        }
        post();
    }

    public void post() {
        PlayerInitializer.finalise();
    }
}
