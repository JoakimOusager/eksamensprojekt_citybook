package gui;
/**
 * Created by jarl on 16/05/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginGUI {

    static BorderPane BPBackground = new BorderPane();
    //Login fields
    public static PasswordField passwordfield = new PasswordField();
    public static TextField usernamefield = new TextField();


    public static void login(Stage primaryStage){

        //Hvid background som ligger i midten
        BorderPane whiteBackground = new BorderPane();
        whiteBackground.getStylesheets().addAll("gui/assets/login.css");
        whiteBackground.setId("whiteBackground");


        //Det første pane som alt bliver tilføjet til
        BorderPane loginBP = new BorderPane();
        loginBP.getStylesheets().addAll("gui/assets/login.css");
        loginBP.setId("loginBPBackground");

        BPBackground.getStylesheets().addAll("gui/assets/login.css");
        BPBackground.setId("loginBPBackground");


        //Borderpane til implementering af Citybook logo
        BorderPane citybookLogoPane = new BorderPane();
        citybookLogoPane.getStylesheets().addAll("gui/assets/login.css");
        citybookLogoPane.setId("citybookLogoPane");

        //Loginboxen som ligger i midten
        BorderPane loginBox = new BorderPane();
        loginBox.getStylesheets().addAll("gui/assets/login.css");
        loginBox.setId("loginBox");

        //Textfields til login
        usernamefield.setPromptText("Username");
        usernamefield.setId("creds");
        passwordfield.setPromptText("Password");
        passwordfield.setId("creds");

        //Borderpane brugt til at implementere billede af lås
        BorderPane lock = new BorderPane();
        lock.getStylesheets().addAll("gui/assets/login.css");
        lock.setId("lock");

        //Borderpane brugt til at implementere billede af et user icon
        BorderPane key = new BorderPane();
        key.getStylesheets().addAll("gui/assets/login.css");
        key.setId("manicon");

        //Login knap
        Button btnlogin = new Button("Login");
        btnlogin.setId("btnlogin");

        btnlogin.setOnAction((ActionEvent event1) -> {

            // if (boolean canLogin = GUIController.login() == true)
            //       HomeGUI.start(stage, user); (giver user med som parameter, så man fx. logger ind som admin, hvis man har rettigheder til det)

            //GUIController.loginCreds(primaryStage);
            //backgroundTemplate(primaryStage);
        });


        //Et tomt label brugt til at skabe ekstra plads i bunden
        Label white = new Label();

        //Gridpane hvor alle fields bliver smidt ind
        GridPane fields = new GridPane();
        fields.setVgap(1);
        fields.setHgap(5);
        fields.setId("fields");


        fields.add(key, 10, 1);
        fields.add(lock, 10, 2);
        fields.add(usernamefield, 14, 1);
        fields.add(passwordfield, 14, 2);
        fields.add(btnlogin, 14, 10);
        fields.add(white, 15, 14);


        loginBP.setCenter(loginBox);
        loginBox.setTop(citybookLogoPane);
        loginBox.setCenter(fields);

        Scene loginScene = new Scene(loginBP);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        loginScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(loginScene);
        primaryStage.show();


    }
}