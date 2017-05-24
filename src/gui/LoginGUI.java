package gui;
/**
 * Created by jarl on 16/05/2017.
 */


import dao.UserDAO;
import entities.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static gui.HomeGUI.adminButton;


public class LoginGUI extends Application {

    static boolean hasRunBefore = false;

    static Scene loginScene;

    static BorderPane BPBackground = new BorderPane();
    static BorderPane whiteBackground = new BorderPane();
    static BorderPane citybookLogoPane = new BorderPane();

    //Login fields
    public static TextField usernamefield = new TextField();


    public static boolean saveMe = false;
    @Override
    public void start(Stage primaryStage) {

    }
    public static void login(Stage primaryStage){

        try {
            LoginGUI.usernamefield.setText(dao.CheckBoxDAO.getSavedUsername());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            dao.CheckBoxDAO.setSavedUsername();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Hvid background som ligger i midten

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
        PasswordField passwordfield = new PasswordField();


        //TextField usernamefield = new TextField();


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


        //Remember me checkbox
        CheckBox checkBoxRememberMe = new CheckBox("Remember Me");
        checkBoxRememberMe.setId("checkBoxRememberMe");
        checkBoxRememberMe.getStylesheets().addAll("gui/assets/login.css");
        checkBoxRememberMe.setOnAction(event -> {
            saveMe = true;
            try{
                dao.CheckBoxDAO.setSavedUsername();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });




        //We wanna keep these to close - therefor we are creating a horizontal box.
        HBox rememberMePlusLogIn = new HBox();
        rememberMePlusLogIn.setId("rememberMePlusLogIn");
        rememberMePlusLogIn.getStylesheets().addAll("gui/assets/login.css");
        rememberMePlusLogIn.getChildren().addAll(checkBoxRememberMe, btnlogin);



        btnlogin.setOnAction((ActionEvent event1) ->  {
            // Hvis brugeren ikke er admin, bliver adminknappen usynlig


            User foundUser = UserDAO.login(new User(usernamefield.getText(), passwordfield.getText()));
            if(foundUser != null) {
                if (foundUser.getRank() == 1) {
                    adminButton.setVisible(true);
                } else {
                    adminButton.setVisible(false);
                }
            }


            if (foundUser != null) {


                try {
                    dao.CheckBoxDAO.setSavedUsername();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!hasRunBefore) {
                    gui.Tableviews.methods.CompanyMethod.companyTableviewStart();
                    gui.Tableviews.methods.UserMethod.userTableviewStart();
                    //  ActivityMethod.companyTableviewStart();
                    HomeGUI.backgroundTemplate(primaryStage, foundUser);
                    HomeGUI.homepageScreen(primaryStage);
                    hasRunBefore = true;
                } else {
                    primaryStage.setScene(HomeGUI.postLogin);
                }
            } else {
                wrongCreds(usernamefield, passwordfield);
            }
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
        fields.add(rememberMePlusLogIn, 14, 10);
        fields.add(white, 15, 14);


        loginBP.setCenter(loginBox);
        loginBox.setTop(citybookLogoPane);
        loginBox.setCenter(fields);

        loginScene = new Scene(loginBP);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        loginScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }

    public static void wrongCreds(TextField usernamefield, PasswordField passwordfield){
        usernamefield.setPromptText("Wrong username");
        passwordfield.setPromptText("Wrong password");
        usernamefield.clear();
        passwordfield.clear();
    }
}

