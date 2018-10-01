package com.dakoda.alr;

import com.dakoda.alr.client.fakecli.component.CLIDisplay;
import com.dakoda.alr.client.fakecli.component.CLITextEntry;
import com.dakoda.alr.client.fakecli.state.GameState;
import com.dakoda.alr.client.fakecli.state.StateInitializer;
import com.dakoda.alr.client.fakecli.state.StateMaster;
import com.dakoda.alr.content.ContentInitializer;
import com.dakoda.alr.game.GameMaster;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.dakoda.alr.client.fakecli.state.GameState.initialState;

public class TextRPG extends Application {

    boolean active = true;

    public static GameMaster master = GameMaster.instance();
    public static StateMaster stateMaster = new StateMaster();
    public static CLIDisplay display = new CLIDisplay();
    public static CLITextEntry input = new CLITextEntry();

    public static GameState askingForInput = null;
    public static String entry = "";

    public void start(Stage primaryStage) throws Exception {

        initialize();
        initialState("CHARACTER_CREATE_ROOT");

        Thread gameLoop = new Thread(() -> {
            while(active) {
                try {
                    stateMaster.nextState();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (stateMaster.isStackEmpty()) {
                    close();
                }
            }
        });
        gameLoop.start();

        CLIDisplay.init(display);
        display.setLineLimit(32);
        CLITextEntry.init(input);
        primaryStage.setTitle("ALevel-Remake");
        primaryStage.setResizable(false);

        BorderPane root = new BorderPane();
        root.setCenter(display);
        root.setBottom(input);
        Scene scene = new Scene(root, 900, 450);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("css/cli.css")).toExternalForm());
        primaryStage.show();

        input.refresh();
    }

    private static void initialize() {
        StateInitializer.initialize();
        ContentInitializer.initialize(master);
    }

    private static void close() {
        GameState.close();
        System.exit(0);
    }

    public static void clearWait() {
        askingForInput = null;
        entry = "";
    }
}
