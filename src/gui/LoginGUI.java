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
    static BorderPane loginBP = new BorderPane();
    static BorderPane citybookLogoPane = new BorderPane();
    static HBox bottom = new HBox();
    static Label white = new Label();
    public static BorderPane BPBackground = new BorderPane();
    static BorderPane whiteBackground = new BorderPane();
    static BorderPane loginBox = new BorderPane();

    static Scene loginScene = new Scene(loginBP);

    //Login fields
    public static PasswordField passwordfield = new PasswordField();
    public static TextField usernamefield = new TextField();
    public static String username;
    public static String password;


    public static void login(Stage primaryStage){

        BPBackground.getStylesheets().addAll("gui/assets/login.css");
        BPBackground.setId("loginBPBackground");

        //Det første pane som alt bliver tilføjet til
        loginBP.getStylesheets().addAll("gui/assets/login.css");
        loginBP.setId("loginBPBackground");

        //Borderpane til implementering af Citybook logo
        citybookLogoPane.getStylesheets().addAll("gui/assets/login.css");
        citybookLogoPane.setId("citybookLogoPane");

        //Loginboxen som ligger i midten

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


        primaryStage.initStyle(StageStyle.TRANSPARENT);
        loginScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(loginScene);
        primaryStage.show();


    }
}
