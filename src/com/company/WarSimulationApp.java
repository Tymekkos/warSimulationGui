package com.company;

import com.company.engine.WorldEngine;
import com.company.visualisation.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarSimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("anime loli paradise");
        Window window = new Window();
        Scene mainScene = new Scene(window.mainLayout);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        //new WorldEngine();
        launch(args);


    }
}
