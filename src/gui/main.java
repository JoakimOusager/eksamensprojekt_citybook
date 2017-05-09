package gui;/**
 * Created by Jarl on 05/05/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Det første pane som alt bliver tilføjet til
        BorderPane loginBP = new BorderPane();
        loginBP.getStylesheets().addAll("gui/assets/login.css");
        loginBP.setId("loginBPBackground");

        //Borderpane til implementering af Citybook logo
        BorderPane citybook = new BorderPane();
        citybook.getStylesheets().addAll("gui/assets/login.css");
        citybook.setId("citybook");

        //Label til Citybook header
        Label head = new Label("Citybook");
        head.getStylesheets().addAll("gui/assets/login.css");
        head.setId("head");

        //Loginboxen som ligger i midten
        BorderPane loginBox = new BorderPane();
        loginBox.getStylesheets().addAll("gui/assets/login.css");
        loginBox.setId("loginBox");


        Label username = new Label("Username");
        username.setId("labelCreds");
        Label password= new Label("Password");
        password.setId("labelCreds");

        //Textfields til login
        TextField usernamefield = new TextField();
        usernamefield.setPromptText("Username");
        usernamefield.setId("creds");
        PasswordField passwordfield = new PasswordField();
        passwordfield.setPromptText("Password");
        passwordfield.setId("creds");

        //Borderpane brugt til at implementere billede af lås
        BorderPane lock = new BorderPane();
        lock.getStylesheets().addAll("gui/assets/login.css");
        lock.setId("lock");

        //Borderpane brugt til at implementere billede af nøgle
        BorderPane key = new BorderPane();
        key.getStylesheets().addAll("gui/assets/login.css");
        key.setId("key");

        Button btnlogin = new Button("Login");
        btnlogin.setId("btnlogin");

        CheckBox rememberMe = new CheckBox();
        rememberMe.setId("rememberMe");
        rememberMe.getStylesheets().addAll("gui/assets/login.css");



        Label white = new Label();


        GridPane fields = new GridPane();
        fields.setVgap(1);
        fields.setHgap(5);
        fields.setId("fields");



        //fields.add(citybook,4,10);
        //fields.add(head,7,10);
        //fields.add(rememberMe,15,10);
        fields.add(key,10,1);
        fields.add(lock,10,2);
        //fields.add(username,2,1);
        //fields.add(password,2,2);
        fields.add(usernamefield,14,1);
        fields.add(passwordfield,14,2);
        fields.add(btnlogin,14,10);
        fields.add(white,15,14);


        loginBP.setCenter(loginBox);
        loginBox.setTop(citybook);
        loginBox.setCenter(fields);
        //loginBP.setCenter(citybook);



        Scene s1 = new Scene(loginBP);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        s1.setFill(Color.TRANSPARENT);
        primaryStage.setScene(s1);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
