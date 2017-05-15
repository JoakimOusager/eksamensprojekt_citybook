package gui;/**
 * Created by Daniel on 11-05-2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GUI.login(primaryStage);
    }
}
