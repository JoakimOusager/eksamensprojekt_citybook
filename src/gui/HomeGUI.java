package gui;/**
 * Created by jarl on 16/05/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

public class HomeGUI extends Application {

    // De skulle bruges ofte, så de er static
    static VBox menuVBox = new VBox();
    static HBox bottom = new HBox();
    static Scene postLogin = new Scene(LoginGUI.BPBackground);

    //Buttons
    static Button activitiesButton = new Button("Aktiviteter");
    static Button goalsButton = new Button("Mål");
    static Button companiesButton = new Button("Virksomheder");
    static Button adminButton = new Button("Admin");
    static Button logoutButton = new Button("Log out");
    static Button homepageButton = new Button("Hjem");


    @Override
    public void start(Stage primaryStage) {


    }

    //Metode lavet for at kunne reset borderfarver på knapperne
    public static void buttonReset(){

        //Knap lavet til startsiden
        homepageButton.getStylesheets().addAll("gui/assets/login.css");
        homepageButton.setId("buttonReset");

        //Knap lavet til aktivitets siden
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");
        activitiesButton.setId("buttonReset");

        //Knap lavet til "goalsButton" siden
        goalsButton.getStylesheets().addAll("gui/assets/login.css");
        goalsButton.setId("buttonReset");

        //Knap lavet til virksomheds siden
        companiesButton.getStylesheets().addAll("gui/assets/login.css");
        companiesButton.setId("buttonReset");

        //Knap lavet specifikt til admins
        adminButton.getStylesheets().addAll("gui/assets/login.css");
        adminButton.setId("buttonReset");


    }

    public static void backgroundTemplate(Stage primaryStage){

        //Skyline bagrund
        LoginGUI.BPBackground.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.BPBackground.setId("loginBPBackground");

        //Hvid background som ligger i midten
        LoginGUI.whiteBackground.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.whiteBackground.setId("whiteBackground");

        //Citybook logo - new stylesheet
        LoginGUI.citybookLogoPane.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.citybookLogoPane.setId("citybookLogoPane");

        //VBox til alle knapperne der ligger i venstre side
        menuVBox.setSpacing(14.5);
        menuVBox.getStylesheets().addAll("gui/assets/login.css");
        menuVBox.setId("menuVBox");

        //Knap lavet til startsiden
        homepageButton.getStylesheets().addAll("gui/assets/login.css");
        homepageButton.setId("buttonsleftside");
        homepageButton.setOnAction((ActionEvent event1) -> {
            buttonReset();
            homepageScreen(primaryStage);
        });

        //Knap lavet til aktivitets siden
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");
        activitiesButton.setId("buttonsleftside");
        activitiesButton.setOnAction((ActionEvent event1) -> {
            buttonReset();
            aktivitetScreen(primaryStage);
        });

        //Knap lavet til "goalsButton" siden
        goalsButton.getStylesheets().addAll("gui/assets/login.css");
        goalsButton.setId("buttonsleftside");
        goalsButton.setOnAction((ActionEvent event2) -> {
            buttonReset();
            målScreen(primaryStage);
        });

        //Knap lavet til virksomheds siden
        companiesButton.getStylesheets().addAll("gui/assets/login.css");
        companiesButton.setId("buttonsleftside");
        companiesButton.setOnAction((ActionEvent event3) -> {
            buttonReset();
            virksomhedsScreen(primaryStage);
        });

        //Knap lavet specifikt til admins
        adminButton.getStylesheets().addAll("gui/assets/login.css");
        adminButton.setId("buttonsleftside");
        adminButton.setOnAction((ActionEvent event4) -> {
            buttonReset();
            adminScreen(primaryStage);
        });

        //knap lavet til at logge ud
        logoutButton.getStylesheets().addAll("gui/assets/login.css");
        logoutButton.setId("logoutButton");
        logoutButton.setOnAction((ActionEvent event5) -> {
           // LoginGUI.BPBackground
            primaryStage.setScene(LoginGUI.loginScene);
            primaryStage.centerOnScreen();

        /*    primaryStage.setScene(loginScene);
            primaryStage.centerOnScreen();

            loginBox.setTop(citybookLogoPane);

            passwordfield.clear();
            usernamefield.clear();
            passwordfield.setPromptText("Username");
            usernamefield.setPromptText("Password"); */
        });


        menuVBox.getChildren().addAll(homepageButton, activitiesButton, goalsButton, companiesButton, adminButton, logoutButton);

        //Brugt til at skabe plads i bunden, og skubbe den hvide bund op så den passer med knapperne
        VBox white = new VBox();
        white.getStylesheets().addAll("gui/assets/login.css");
        white.setId("white");


        bottom.setSpacing(10);
        bottom.getStylesheets().addAll("gui/assets/login.css");
        bottom.setId("bottom");
        bottom.getChildren().addAll(white);


        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);


        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //postlogin screen
    public static void homepageScreen(Stage primaryStage){

        homepageButton.setId("mActive");
        homepageButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI. whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Aktivitetsscreen
    public static void aktivitetScreen(Stage primaryStage){

        activitiesButton.setId("mActive");
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Målscreen
    public static void målScreen(Stage primaryStage){


        goalsButton.setId("mActive");
        goalsButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //virksomheds screen
    public static void virksomhedsScreen(Stage primaryStage){

        companiesButton.setId("mActive");
        companiesButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Adminscreen
    public static void adminScreen(Stage primaryStage){

        adminButton.setId("mActive");
        adminButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

}
