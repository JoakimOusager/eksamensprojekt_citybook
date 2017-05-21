package gui;/**
 * Created by jarl on 16/05/2017.
 */

import gui.Tableviews.methods.AktivitetMethod;
import gui.Tableviews.methods.CompanyMethod;
import gui.Tableviews.methods.UserMethod;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

public class HomeGUI extends Application {

    // De skulle bruges ofte, så de er static
    static VBox menuVBox = new VBox();
    static HBox bottom = new HBox();
    static Scene postLogin = new Scene(LoginGUI.BPBackground);
    static Rectangle rectangleEncapsulateMenuButtons = new Rectangle();
    static StackPane combineMenu = new StackPane();

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
        homepageButton.setId("buttonsleftside");

        //Knap lavet til aktivitets siden
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");
        activitiesButton.setId("buttonsleftside");

        //Knap lavet til "goalsButton" siden
        goalsButton.getStylesheets().addAll("gui/assets/login.css");
        goalsButton.setId("buttonsleftside");

        //Knap lavet til virksomheds siden
        companiesButton.getStylesheets().addAll("gui/assets/login.css");
        companiesButton.setId("buttonsleftside");

        //Knap lavet specifikt til admins
        adminButton.getStylesheets().addAll("gui/assets/login.css");
        adminButton.setId("buttonsleftside");

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
        homepageButton.setOnMouseEntered((MouseEvent e) -> {
            homepageButton.setUnderline(true);
        });
        homepageButton.setOnMouseExited((MouseEvent e) -> {
            homepageButton.setUnderline(false);
        });
        homepageButton.setOnAction((ActionEvent event1) -> {
            //buttonReset();
            homepageScreen(primaryStage);
        });

        //Knap lavet til aktivitets siden
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");
        activitiesButton.setId("buttonsleftside");
        activitiesButton.setOnMouseEntered((MouseEvent e) -> {
            activitiesButton.setUnderline(true);
        });
        activitiesButton.setOnMouseExited((MouseEvent e) -> {
            activitiesButton.setUnderline(false);
        });
        /*activitiesButton.setOnAction((ActionEvent event1) -> {
            buttonReset();
            CalendarView();
        });*/
        activitiesButton.setOnAction(event10 -> CalendarView(primaryStage));

        //Knap lavet til "goalsButton" siden
        goalsButton.getStylesheets().addAll("gui/assets/login.css");
        goalsButton.setId("buttonsleftside");
        goalsButton.setOnMouseEntered((MouseEvent e) -> {
            goalsButton.setUnderline(true);
        });
        goalsButton.setOnMouseExited((MouseEvent e) -> {
            goalsButton.setUnderline(false);
        });
        goalsButton.setOnAction((ActionEvent event2) -> {
            buttonReset();
            målScreen(primaryStage);
        });

        //Knap lavet til virksomheds siden
        companiesButton.getStylesheets().addAll("gui/assets/login.css");
        companiesButton.setId("buttonsleftside");
        companiesButton.setOnMouseEntered((MouseEvent e) -> {
            companiesButton.setUnderline(true);
        });
        companiesButton.setOnMouseExited((MouseEvent e) -> {
            companiesButton.setUnderline(false);
        });
        companiesButton.setOnAction((ActionEvent event3) -> {
            buttonReset();
            virksomhedsScreen(primaryStage);

            LoginGUI.whiteBackground.setCenter(CompanyMethod.hboxCompany);
        });

        //Knap lavet specifikt til admins
        adminButton.getStylesheets().addAll("gui/assets/login.css");
        adminButton.setId("buttonsleftside");
        adminButton.setOnMouseEntered((MouseEvent e) -> {
            adminButton.setUnderline(true);
        });
        adminButton.setOnMouseExited((MouseEvent e) -> {
            adminButton.setUnderline(false);
        });
        adminButton.setOnAction((ActionEvent event4) -> {
            buttonReset();
            adminScreen(primaryStage);
            LoginGUI.whiteBackground.setCenter(UserMethod.hboxUser);

            boolean alreadyExecuted = false;

            if(alreadyExecuted = false) {

                alreadyExecuted = true;
            }
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

        //Setting up the rectangle
        rectangleEncapsulateMenuButtons.setX(0);
        rectangleEncapsulateMenuButtons.setY(0);
        rectangleEncapsulateMenuButtons.setWidth(150);
        rectangleEncapsulateMenuButtons.setHeight(245);
        rectangleEncapsulateMenuButtons.setOpacity(0.2);
        rectangleEncapsulateMenuButtons.setArcHeight(30);
        rectangleEncapsulateMenuButtons.setArcWidth(30);

        menuVBox.getChildren().addAll(homepageButton, activitiesButton, goalsButton, companiesButton, adminButton, logoutButton);
        menuVBox.setPadding(new Insets(10, 10, 10, 10));
        combineMenu.getChildren().addAll(rectangleEncapsulateMenuButtons, menuVBox);

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
        LoginGUI.whiteBackground.setLeft(combineMenu);
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
        LoginGUI.whiteBackground.setLeft(combineMenu);
        LoginGUI. whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Aktivitetsscreen
   /* public static void aktivitetScreen(Stage primaryStage){

        activitiesButton.setId("mActive");
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(combineMenu);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    } */

    //Målscreen
    public static void målScreen(Stage primaryStage){


        goalsButton.setId("mActive");
        goalsButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(combineMenu);
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
        LoginGUI. whiteBackground.setLeft(combineMenu);
        LoginGUI.whiteBackground.setBottom(bottom);

        LoginGUI.whiteBackground.setCenter(CompanyMethod.hboxCompany);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Adminscreen
    public static void adminScreen(Stage primaryStage){

        adminButton.setId("mActive");
        adminButton.getStylesheets().addAll("gui/assets/login.css");

        boolean alreadyExecuted = false;

        if(alreadyExecuted = false) {
            gui.Tableviews.methods.UserMethod.childrenPressed();
            LoginGUI.whiteBackground.setCenter(UserMethod.hboxUser);
            alreadyExecuted = true;
        }

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(combineMenu);
        LoginGUI.whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    /*
        Metode til at få Google Calendar integreret i vores program.
        Vi har valgt Google Calendar fremfor selv at lave en kalender da,
        da det gør det muligt for sælgere at kunne se deres møder på mobilen og andetsteds.
    */

    public static void CalendarView(Stage primaryStage) {
        activitiesButton.setId("mActive");
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");

        /*
            Vi opretter et WebView objekt, som indeholder en indebygget browser som er WebEngine.
            På denne måde er det muligt at render HTML direkte i JavaFX.
        */

        WebView calendar = new WebView();
        WebEngine webEngine = calendar.getEngine();
        webEngine.load("https://calendar.google.com/calendar/embed?src=0iu5ro8h5f9sv38l0ip2ima0sg%40group.calendar.google.com&ctz=Europe/Copenhagen");

        /*
            Herefter bliver diverse Panes tilføjet til scenen sammen med vores WebView.
        */

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(combineMenu);
        LoginGUI.whiteBackground.setBottom(bottom);

        LoginGUI.whiteBackground.setCenter(calendar);
        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

}