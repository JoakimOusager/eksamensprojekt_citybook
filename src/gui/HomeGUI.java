package gui;/**
 * Created by jarl on 16/05/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeGUI extends Application {

    static VBox leftside = new VBox();

    static Scene postLogin = new Scene(LoginGUI.BPBackground);

    //Buttons
    static Button aktiviteter = new Button("Aktiviteter");
    static Button mål = new Button("Mål");
    static Button virksomheder = new Button("Virksomheder");
    static Button admin = new Button("Admin");
    static Button logout = new Button("Log out");
    static Button homepage = new Button("Hjem");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    //Metode lavet for at kunne reset borderfarver på knapperne
    public static void buttonReset(){

        //Knap lavet til startsiden
        homepage.getStylesheets().addAll("gui/assets/login.css");
        homepage.setId("buttonReset");

        //Knap lavet til aktivitets siden
        aktiviteter.getStylesheets().addAll("gui/assets/login.css");
        aktiviteter.setId("buttonReset");

        //Knap lavet til "mål" siden
        mål.getStylesheets().addAll("gui/assets/login.css");
        mål.setId("buttonReset");

        //Knap lavet til virksomheds siden
        virksomheder.getStylesheets().addAll("gui/assets/login.css");
        virksomheder.setId("buttonReset");

        //Knap lavet specifikt til admins
        admin.getStylesheets().addAll("gui/assets/login.css");
        admin.setId("buttonReset");


    }
}
