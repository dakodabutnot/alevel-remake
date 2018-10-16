package com.dakoda.alr;

import com.dakoda.alr.client.fakecli.FCLIMaster;
import com.dakoda.alr.client.fakecli.StateMaster;
import com.dakoda.alr.content.ContentInitializer;
import com.dakoda.alr.game.GameMaster;
import javafx.application.Application;
import javafx.stage.Stage;

public class TextRPG extends Application {

    private static final boolean debug = true;
    private static final String initState = "SPLASH";
    public static GameMaster master = GameMaster.instance();
    private static FCLIMaster fcliMaster = FCLIMaster.instance();

    public void start(Stage primaryStage) throws Exception {
        initialize();
        Thread gameThread = new Thread(() -> {
            threadLogic(primaryStage);
        });
        debugMessage("#FX | Parsed default state " + initState);
        initStage(primaryStage);
        gameThread.start();
        fcliMaster.initialize(fcliMaster.stateMaster().getState(initState));

    }

    private void threadLogic(Stage primaryStage) {
        debugDiv();
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            close();
        });
    }

    private static void initialize() {
        debugDiv();
        ContentInitializer.initialize(master);
        StateMaster.initStates();
        fcliMaster.fxMaster().initialize();
        debugMessage("#REG SUCCESS | Woop-dee-doo! " + SuccessLenny.random());
        debugDiv();
    }

    private static void close() {
        System.exit(0);
    }

    private void initStage(Stage primaryStage) {
        primaryStage.setTitle("ALevel-Remake");
        primaryStage.setResizable(false);
        primaryStage.setScene(fcliMaster.fxMaster().getStyledRootScene());
        debugMessage("#FX | Stage initialised fully");
        primaryStage.show();
        debugMessage("#FX SUCCESS | Hooray! " + SuccessLenny.random());
    }

    public static void debugMessage(String message) {
        System.out.print(debug ? message + "\n" : "");
    }

    public static void debugDiv() {
        debugMessage("---------------------------------");
    }
}
