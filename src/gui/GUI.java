package gui;/**
 * Created by Jarl on 05/05/2017.
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

public class GUI extends Application {

    //Gjort static for at kunne genbruge dem uden parameter overførelse
    static BorderPane loginBP = new BorderPane();
    static BorderPane citybook = new BorderPane();
    static VBox leftside = new VBox();
    static HBox bottom = new HBox();
    static Label white = new Label();
    static BorderPane BPBackground = new BorderPane();
    static BorderPane whiteBackground = new BorderPane();
    static Scene s2 = new Scene(BPBackground);

    //Buttons
    static Button aktiviteter = new Button("Aktiviteter");
    static Button mål = new Button("Mål");
    static Button virksomheder = new Button("Virkesomheder");
    static Button admin = new Button("Admin");
    static Button logout = new Button("Log out");
    static Button homepage = new Button("Hjem");

    @Override
    public void start(Stage primaryStage) {
        login(primaryStage);
    }

        public static void login(Stage primaryStage){

            //Det første pane som alt bliver tilføjet til
            loginBP.getStylesheets().addAll("gui/assets/login.css");
            loginBP.setId("loginBPBackground");

            //Borderpane til implementering af Citybook logo
            citybook.getStylesheets().addAll("gui/assets/login.css");
            citybook.setId("citybook");


            //Loginboxen som ligger i midten
            BorderPane loginBox = new BorderPane();
            loginBox.getStylesheets().addAll("gui/assets/login.css");
            loginBox.setId("loginBox");


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

            //Borderpane brugt til at implementere billede af et user icon
            BorderPane key = new BorderPane();
            key.getStylesheets().addAll("gui/assets/login.css");
            key.setId("manicon");

            //Login knap
            Button btnlogin = new Button("Login");
            btnlogin.setId("btnlogin");

            btnlogin.setOnAction((ActionEvent event1) -> {
                backgroundTemplate(primaryStage);
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
            loginBox.setTop(citybook);
            loginBox.setCenter(fields);


            Scene s1 = new Scene(loginBP);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            s1.setFill(Color.TRANSPARENT);
            primaryStage.setScene(s1);
            primaryStage.show();


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

            //knap lavet til at logge ud
            logout.getStylesheets().addAll("gui/assets/login.css");
            logout.setId("logout");

        }


        //Template som er fundament for hele vores program
    public static void backgroundTemplate(Stage primaryStage){

        //Skyline bagrund
        BPBackground.getStylesheets().addAll("gui/assets/login.css");
        BPBackground.setId("loginBPBackground");

        //Hvid background som ligger i midten
        whiteBackground.getStylesheets().addAll("gui/assets/login.css");
        whiteBackground.setId("whiteBackground");

        //VBox til alle knapperne der ligger i venstre side
        leftside.setSpacing(10);
        leftside.getStylesheets().addAll("gui/assets/login.css");
        leftside.setId("leftside");

        //Knap lavet til startsiden
        homepage.getStylesheets().addAll("gui/assets/login.css");
        homepage.setId("buttonsleftside");
        homepage.setOnAction((ActionEvent event1) -> {
            buttonReset();
            homepageScreen(primaryStage);
        });

        //Knap lavet til aktivitets siden
        aktiviteter.getStylesheets().addAll("gui/assets/login.css");
        aktiviteter.setId("buttonsleftside");
        aktiviteter.setOnAction((ActionEvent event1) -> {
            buttonReset();
            aktivitetScreen(primaryStage);
        });

        //Knap lavet til "mål" siden
        mål.getStylesheets().addAll("gui/assets/login.css");
        mål.setId("buttonsleftside");
        mål.setOnAction((ActionEvent event2) -> {
            buttonReset();
            målScreen(primaryStage);
        });

        //Knap lavet til virksomheds siden
        virksomheder.getStylesheets().addAll("gui/assets/login.css");
        virksomheder.setId("buttonsleftside");
        virksomheder.setOnAction((ActionEvent event3) -> {
            buttonReset();
            virksomhedsScreen(primaryStage);
        });

        //Knap lavet specifikt til admins
        admin.getStylesheets().addAll("gui/assets/login.css");
        admin.setId("buttonsleftside");
        admin.setOnAction((ActionEvent event4) -> {
            buttonReset();
            adminScreen(primaryStage);
        });

        //knap lavet til at logge ud
        logout.getStylesheets().addAll("gui/assets/login.css");
        logout.setId("logout");
        logout.setOnAction((ActionEvent event5) -> {
            login(primaryStage);
        });


        leftside.getChildren().addAll(homepage,aktiviteter, mål, virksomheder, admin, logout);


        white.getStylesheets().addAll("gui/assets/login.css");
        white.setId("white");


        bottom.setSpacing(10);
        bottom.getStylesheets().addAll("gui/assets/login.css");
        bottom.setId("bottom");
        bottom.getChildren().addAll(white);


        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        //Scene s2 = new Scene(BPBackground);
        primaryStage.setScene(s2);
        primaryStage.show();
    }

    public static void homepageScreen(Stage primaryStage){

        homepage.setId("mActive");
        homepage.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(s2);
        primaryStage.show();

    }

    public static void aktivitetScreen(Stage primaryStage){

        aktiviteter.setId("mActive");
        aktiviteter.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(s2);
        primaryStage.show();

    }

    public static void målScreen(Stage primaryStage){


        mål.setId("mActive");
        mål.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(s2);
        primaryStage.show();
    }

    public static void virksomhedsScreen(Stage primaryStage){

        virksomheder.setId("mActive");
        virksomheder.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(s2);
        primaryStage.show();

    }

    public static void adminScreen(Stage primaryStage){

        admin.setId("mActive");
        admin.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybook);
        whiteBackground.setLeft(leftside);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(s2);
        primaryStage.show();

    }


}
