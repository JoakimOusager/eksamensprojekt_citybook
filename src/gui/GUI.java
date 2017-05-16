/*package gui;/**
 * Created by Jarl on 05/05/2017.
 */

/*import javafx.application.Application;
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
    static BorderPane citybookLogoPane = new BorderPane();

    static VBox menuVBox = new VBox();
    static HBox bottom = new HBox();
    static Label white = new Label();
    public static BorderPane BPBackground = new BorderPane();
    static BorderPane whiteBackground = new BorderPane();
    static BorderPane loginBox = new BorderPane();

    //De 2 forskellige scener
    static Scene postLogin = new Scene(BPBackground);
    public static Scene loginScene = new Scene(loginBP);

    //Buttons
    static Button activitiesButton = new Button("Aktiviteter");
    static Button goalsButton = new Button("Mål");
    static Button companiesButton = new Button("Virksomheder");
    static Button adminButton = new Button("Admin");
    static Button logoutButton = new Button("Log out");
    static Button homepageButton = new Button("Hjem");

    //Login fields
    public static PasswordField passwordfield = new PasswordField();
    public static TextField usernamefield = new TextField();
    public static String username;
    public static String password;

    @Override
    public void start(Stage primaryStage) {
        LoginGUI.login(primaryStage);
    }

        public static void login(Stage primaryStage){

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

        //Metode brugt til at reset Username og password field
        public static void wrongCreds(){
            usernamefield.setPromptText("Wrong username");
            passwordfield.setPromptText("Wrong password");
            usernamefield.clear();
            passwordfield.clear();
        }

        //Brugt til at hente den data man skriver ind i fieldsene
        public static void loginCreds(){
            username = usernamefield.getText();
            password = passwordfield.getText();
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


        //Template som er fundament for hele vores program
    public static void backgroundTemplate(Stage primaryStage){

        //Skyline bagrund
        BPBackground.getStylesheets().addAll("gui/assets/login.css");
        BPBackground.setId("loginBPBackground");

        //Hvid background som ligger i midten
        whiteBackground.getStylesheets().addAll("gui/assets/login.css");
        whiteBackground.setId("whiteBackground");

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

            primaryStage.setScene(loginScene);
            primaryStage.centerOnScreen();

            loginBox.setTop(citybookLogoPane);

            passwordfield.clear();
            usernamefield.clear();
            passwordfield.setPromptText("Username");
            usernamefield.setPromptText("Password");
        });


        menuVBox.getChildren().addAll(homepageButton,activitiesButton, goalsButton, companiesButton, adminButton, logoutButton);

        //Brugt til at skabe plads i bunden, og skubbe den hvide bund op så den passer med knapperne
        white.getStylesheets().addAll("gui/assets/login.css");
        white.setId("white");
        bottom.setSpacing(10);
        bottom.getStylesheets().addAll("gui/assets/login.css");
        bottom.setId("bottom");
        bottom.getChildren().addAll(white);


        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);


        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //postlogin screen
    public static void homepageScreen(Stage primaryStage){

        homepageButton.setId("mActive");
        homepageButton.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Aktivitetsscreen
    public static void aktivitetScreen(Stage primaryStage){

        activitiesButton.setId("mActive");
        activitiesButton.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Målscreen
    public static void målScreen(Stage primaryStage){


        goalsButton.setId("mActive");
        goalsButton.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //virksomheds screen
    public static void virksomhedsScreen(Stage primaryStage){

        companiesButton.setId("mActive");
        companiesButton.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Adminscreen
    public static void adminScreen(Stage primaryStage){

        adminButton.setId("mActive");
        adminButton.getStylesheets().addAll("gui/assets/login.css");

        BPBackground.setCenter(whiteBackground);
        whiteBackground.setTop(citybookLogoPane);
        whiteBackground.setLeft(menuVBox);
        whiteBackground.setBottom(bottom);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }


}
*/

