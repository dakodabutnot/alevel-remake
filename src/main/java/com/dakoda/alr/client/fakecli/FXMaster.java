package com.dakoda.alr.client.fakecli;

import com.dakoda.alr.client.fakecli.components.FCLIDisplay;
import com.dakoda.alr.client.fakecli.components.FCLITextEntry;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.Objects;

import static com.dakoda.alr.TextRPG.debugMessage;

public class FXMaster {

    private static FXMaster INSTANCE = new FXMaster();
    private FCLIDisplay fcliDisplay = new FCLIDisplay();
    private FCLITextEntry fcliTextEntry = new FCLITextEntry();
    private final String stylesheetURL = "css/cli.css";

    public FCLIDisplay fcliDisplay() {
        return fcliDisplay;
    }

    public void initialize() {
        FCLITextEntry.init(fcliTextEntry, fcliDisplay);
        fcliDisplay.init();
        fcliDisplay.setPrefRowCount(128);
        fcliTextEntry.refresh();
    }

    private FXMaster() {

    }

    public static FXMaster instance() {
        return INSTANCE;
    }

    private BorderPane getRootPane() {
        BorderPane root = new BorderPane();
        root.setCenter(fcliDisplay);
        root.setBottom(fcliTextEntry);
        debugMessage("#FX | Setup root pane -> ");
        return root;
    }

    public Scene getStyledRootScene() {
        Scene scene = new Scene(getRootPane(), 900, 450);
        debugMessage("hooked root pane");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource(stylesheetURL)).toExternalForm());
        debugMessage("#FX | Applied stylesheet ('" + stylesheetURL + "')");
        return scene;
    }

    public Scene getRootScene() {
        return new Scene(getRootPane(), 900, 450);
    }

    public FCLIDisplay display() {
        return fcliDisplay;
    }

    public FCLITextEntry fcliTextEntry() {
        return fcliTextEntry;
    }
}
