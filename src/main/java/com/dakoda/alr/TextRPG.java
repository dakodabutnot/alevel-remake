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
        soutDiv();
        initialize();
        soutDiv();
        Thread gameThread = new Thread(() -> {
            threadLogic(primaryStage);
        });
        System.out.println("#FX | Parsed default state " + initState);
        initStage(primaryStage);
        gameThread.start();
        fcliMaster.initialize(fcliMaster.stateMaster().getState(initState));

    }

    private void threadLogic(Stage primaryStage) {
        soutDiv();
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            close();
        });
    }

    private static void initialize() {
        ContentInitializer.initialize(master);
        StateMaster.initStates();
        fcliMaster.fxMaster().initialize();
        System.out.println("#REG SUCCESS | Woop-dee-doo! " + SuccessLenny.random());
    }

    private static void close() {
        System.exit(0);
    }

    private void initStage(Stage primaryStage) {
        primaryStage.setTitle("ALevel-Remake");
        primaryStage.setResizable(false);
        primaryStage.setScene(fcliMaster.fxMaster().getStyledRootScene());
        System.out.println("#FX | Stage initialised fully");
        primaryStage.show();
        System.out.println("#FX SUCCESS | Hooray! " + SuccessLenny.random());
    }

    public static void debugMessage(String message) {
        System.out.print(debug ? message + "\n" : "");
    }

    public static void soutDiv() {
        System.out.println("---------------------------------");
    }
}
