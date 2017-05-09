package gui;/**
 * Created by Jarl on 05/05/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {
    //public static BorderPane bpLogin = new BorderPane();


    @Override
    public void start(Stage primaryStage) {


        BorderPane login1 = new BorderPane();
        login1.getStylesheets().addAll("gui/LogIn.css");
        login1.setId("login1Background");


        GridPane loginBox = new GridPane();
        loginBox.setVgap(5);
        loginBox.setHgap(5);
        loginBox.getStylesheets().addAll("gui/LogIn.css");
        loginBox.setId("loginBox");

        Label head = new Label("Citybook");
        head.setId("head");
        head.getStylesheets().addAll("gui/LogIn.css");

        Label username = new Label("Username");
        username.setId("labelCreds");
        Label password= new Label("Password");
        password.setId("labelCreds");

        TextField usernamefield = new TextField();
        usernamefield.setPromptText("Username");
        usernamefield.setId("creds");
        PasswordField passwordfield = new PasswordField();
        passwordfield.setPromptText("Password");
        passwordfield.setId("creds");

        BorderPane lock = new BorderPane();
        lock.getStylesheets().addAll("gui/LogIn.css");
        lock.setId("lock");

        BorderPane key = new BorderPane();
        key.getStylesheets().addAll("gui/LogIn.css");
        key.setId("key");

        Button btnlogin = new Button("login");
        btnlogin.setId("btnlogin");

        VBox pic = new VBox();
        pic.getChildren().addAll(lock,passwordfield);


        loginBox.add(key,7,20);
        loginBox.add(lock,7,21);
        loginBox.add(username,2,20);
        loginBox.add(password,2,21);
        loginBox.add(usernamefield,10,20);
        loginBox.add(passwordfield,10,21);
        loginBox.add(btnlogin,10,23);

        login1.setCenter(loginBox);
;


        Scene s1 = new Scene(login1);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        s1.setFill(Color.TRANSPARENT);
        primaryStage.setScene(s1);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
