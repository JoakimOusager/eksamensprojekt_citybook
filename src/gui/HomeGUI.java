package gui;/**
 * Created by jarl on 16/05/2017.
 */

//import gui.Tableviews.methods.ActivityMethod;

import backend.Datepicker;
import backend.LogicController;
import entities.Comment;
import entities.Company;
import entities.ScheduleDays;
import entities.User;
import gui.Tableviews.methods.CompanyMethod;
import gui.Tableviews.methods.UserMethod;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeGUI extends Application implements ActionListener {

    /*
        VBox, HBox, Scene, Rektangel og vores StackPane skulle bruges ofte, derfor er de static.
    */
    static VBox menuVBox = new VBox();
    static HBox bottomHBox = new HBox();
    static Scene postLogin = new Scene(LoginGUI.BPBackground);

    /*
        Knapper til vores side menu.
    */
    static Button calendarButton = new Button("Kalender");
    static Button goalsButton = new Button("Mål");
    static Button companiesButton = new Button("Virksomheder");
    static Button userButton = new Button("Brugere");
    static Button logoutButton = new Button("Log out");
    static Button homepageButton = new Button("Hjem");
    static Button scheduleButton = new Button("Vagtplan");
    static Button scheduleOverviewButton = new Button("Vagtplanoverblik");

    public static User loggedInUser;

    /*
        Alle labels for vagtplan er blevet gjort static, for at deres tekst ikke bliver fjernet ved scene skift.
    */

    static Label datoFredag2 = new Label();
    static Label datoTorsdag2 = new Label();
    static Label datoOnsdag2 = new Label();
    static Label datoTirsdag2 = new Label();
    static Label datoMandag2 = new Label();
    static Label datoFredag = new Label();
    static Label datoTorsdag = new Label();
    static Label datoOnsdag = new Label();
    static Label datoTirsdag = new Label();
    static Label datoMandag = new Label();

    static TextField timerMandag = new TextField();
    static TextField timerTirsdag = new TextField();
    static TextField timerOnsdag = new TextField();
    static TextField timerTorsdag = new TextField();
    static TextField timerFredag = new TextField();

    static TextField totalTimer = new TextField();


    // Long tidsvariabler
    static long diffMinutesStart;
    static long diffMinutesEnd;

    @Override
    public void start(Stage primaryStage) {


    }

    /*
        Denne metode nulstiller border color på knapperne i side menuen.
    */
    public static void buttonReset(){

        //Knap lavet til startsiden
        homepageButton.getStylesheets().addAll("gui/assets/login.css");
        homepageButton.setId("buttonsleftside");

        //Knap lavet til aktivitetssiden
        calendarButton.getStylesheets().addAll("gui/assets/login.css");
        calendarButton.setId("buttonsleftside");

        //Knap lavet til "goalsButton" siden
        goalsButton.getStylesheets().addAll("gui/assets/login.css");
        goalsButton.setId("buttonsleftside");

        //Knap lavet til virksomhedssiden
        companiesButton.getStylesheets().addAll("gui/assets/login.css");
        companiesButton.setId("buttonsleftside");

        //Knap lavet til vagtplanen
        scheduleButton.getStylesheets().addAll("gui/assets/login.css");
        scheduleButton.setId("buttonsleftside");

        //Knap lavet til vagtplansoversigt
        scheduleOverviewButton.getStylesheets().addAll("gui/assets/login.css");
        scheduleOverviewButton.setId("buttonsleftside");

        //Knap lavet specifikt til admins
        userButton.getStylesheets().addAll("gui/assets/login.css");
        userButton.setId("buttonsleftside");

    }

    /* //////////////////////////////////////////////////////////////////////////////////////////
                                             HOVEDSCENE
       ////////////////////////////////////////////////////////////////////////////////////////// */

    /*
        Denne metode sætter hele Scenen op med menu samt indhold.
    */
    public static void backgroundTemplate(Stage primaryStage, User foundUser){

        loggedInUser = foundUser;

        //Skyline bagrund
        LoginGUI.BPBackground.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.BPBackground.setId("loginBPBackground");

        //Hvid background som ligger i midten
        LoginGUI.whiteBackground.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.whiteBackground.setId("whiteBackground");

        //Citybook logo - new stylesheet
        LoginGUI.citybookLogoPane.getStylesheets().addAll("gui/assets/login.css");
        LoginGUI.citybookLogoPane.setId("citybookLogoPane");

        /* //////////////////////////////////////////////////////////////////////////////////////////
                                             SIDE MENU
       ////////////////////////////////////////////////////////////////////////////////////////// */

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
        calendarButton.getStylesheets().addAll("gui/assets/login.css");
        calendarButton.setId("buttonsleftside");
        calendarButton.setOnMouseEntered((MouseEvent e) -> {
            calendarButton.setUnderline(true);
        });
        calendarButton.setOnMouseExited((MouseEvent e) -> {
            calendarButton.setUnderline(false);
        });
        /*
            Vi kalder på metoden CalendarView når knappen "Aktiviteter" bliver trykket på.
            Knappen bliver også nulstillet, så vores CSS bliver nulstillet.
        */
        calendarButton.setOnAction((ActionEvent event1) -> {
            buttonReset();

            CalendarView(primaryStage);

        });

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
            goalsScreen(primaryStage);
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
            companiesScreen(primaryStage);

            LoginGUI.whiteBackground.setCenter(CompanyMethod.hboxCompany);
        });

        //Knap lavet specifikt til vagtplan
        scheduleButton.getStylesheets().addAll("gui/assets/login.css");
        scheduleButton.setId("buttonsleftside");
        scheduleButton.setOnMouseEntered((MouseEvent e) -> {
            scheduleButton.setUnderline(true);
        });
        scheduleButton.setOnMouseExited((MouseEvent e) -> {
            scheduleButton.setUnderline(false);
        });
        scheduleButton.setOnAction((ActionEvent event3) -> {
            buttonReset();
            scheduleScreen(primaryStage);

        });

        //Knap lavet specifikt til vagtplansoverblik
        scheduleOverviewButton.getStylesheets().addAll("gui/assets/login.css");
        scheduleOverviewButton.setId("buttonsleftside");
        scheduleOverviewButton.setOnMouseEntered((MouseEvent e) -> {
            scheduleOverviewButton.setUnderline(true);
        });
        scheduleOverviewButton.setOnMouseExited((MouseEvent e) -> {
            scheduleOverviewButton.setUnderline(false);
        });
        scheduleOverviewButton.setOnAction((ActionEvent event3) -> {
            buttonReset();
            scheduleOverviewScreen(primaryStage);


        });

        //Knap lavet specifikt til admins
        userButton.getStylesheets().addAll("gui/assets/login.css");
        userButton.setId("buttonsleftside");
        userButton.setOnMouseEntered((MouseEvent e) -> {
            userButton.setUnderline(true);
        });
        userButton.setOnMouseExited((MouseEvent e) -> {
            userButton.setUnderline(false);
        });
        userButton.setOnAction((ActionEvent event4) -> {
            buttonReset();
            usersScreen(primaryStage);
            LoginGUI.whiteBackground.setCenter(UserMethod.hboxUser);

        });

        //knap lavet til at logge ud
        logoutButton.getStylesheets().addAll("gui/assets/login.css");
        logoutButton.setId("logoutButton");
        logoutButton.setOnAction((ActionEvent event5) -> {
            // LoginGUI.BPBackground
            primaryStage.setScene(LoginGUI.loginScene);
            primaryStage.centerOnScreen();

        });
        menuVBox.setId("menuVBox");
        menuVBox.getChildren().addAll(homepageButton, calendarButton, goalsButton, companiesButton,
                scheduleButton, scheduleOverviewButton, userButton, logoutButton);
        menuVBox.setPadding(new Insets(10, 25, 10, 10));

        /* //////////////////////////////////////////////////////////////////////////////////////////
                                           SLUT SIDE MENU
       ////////////////////////////////////////////////////////////////////////////////////////// */

        //Brugt til at skabe plads i bunden, og skubbe den hvide bund op så den passer med knapperne
        VBox white = new VBox();
        white.getStylesheets().addAll("gui/assets/login.css");
        white.setId("white");


        bottomHBox.setSpacing(10);
        bottomHBox.getStylesheets().addAll("gui/assets/login.css");
        bottomHBox.setId("bottomHBox");
        bottomHBox.getChildren().addAll(white);


        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);


        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    /* //////////////////////////////////////////////////////////////////////////////////////////
                                          SLUT HOVEDSCENE
      ////////////////////////////////////////////////////////////////////////////////////////// */


    /*
        Scenen til knappen 'Hjem'
    */
    public static void homepageScreen(Stage primaryStage) {
        // For at få det nuværende klokkeslæt, så brugeren kan se hvad tid personen loggede ind.
        String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
        String timeStamp = new SimpleDateFormat("HH.mm").format(Calendar.getInstance().getTime());

        // Viser hvilken bruger man er logged ind som samt bliver tilhørende CSS tilføjet.
        Label welcome = new Label("Velkommen tilbage "+ loggedInUser.getUsername() +  "\nKl: "+ timeStamp + "\nDato: " + dateStamp);
        welcome.setId("welcomeLabel");
        welcome.getStylesheets().addAll("gui/assets/login.css");
        buttonReset();
        homepageButton.setId("mActive");
        homepageButton.getStylesheets().addAll("gui/assets/login.css");

        // Alle de forskellige elementer bliver tilføjet til den 'nye' primaryStage.
        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI. whiteBackground.setBottom(bottomHBox);
        LoginGUI.whiteBackground.setCenter(welcome);

        primaryStage.setScene(postLogin);
        primaryStage.show();

    }


    /*
        Denne metoder bliver tilføjet i knappen 'Aktiviteter'
        Metode til at få Google Calendar integreret i vores program.
        Vi har valgt Google Calendar fremfor selv at lave en kalender da,
        da det gør det muligt for sælgere at kunne se deres møder på mobilen og andetsteds.
    */

     public static void CalendarView(Stage primaryStage) {
        calendarButton.setId("mActive");
        calendarButton.getStylesheets().addAll("gui/assets/login.css");

        /*
            Vi opretter et WebView objekt, som indeholder en indbygget browser som er WebEngine.
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
        LoginGUI. whiteBackground.setLeft(menuVBox);

        LoginGUI.whiteBackground.setCenter(calendar);
        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //Målscreen
    public static void goalsScreen(Stage primaryStage){

        //total omsætning
        BorderPane bpRevenueTotal = new BorderPane();
        bpRevenueTotal.setId("bpGoalsScreen");
        Label labelRevenueTotalMessage = new Label("Totalomsætning:");
        labelRevenueTotalMessage.setId("labelMessage");
        labelRevenueTotalMessage.setAlignment(Pos.TOP_LEFT);
        ArrayList<Company> totalRevenueList = new ArrayList(LogicController.getTotalRevenue());
        double totalRevenue = totalRevenueList.get(0).getRevenue();
        String totalRevenueString = String.valueOf(totalRevenue);

        Label labelRevenueTotalCount = new Label(totalRevenueString + " kr");
        labelRevenueTotalCount.setId("labelCount");
        //her skal der kaldes til en metode, der finder den totale omsætning frem.
        bpRevenueTotal.setTop(labelRevenueTotalMessage);
        bpRevenueTotal.setAlignment(labelRevenueTotalMessage, Pos.TOP_CENTER);
        bpRevenueTotal.setCenter(labelRevenueTotalCount);

        //højest omsætning på en måned
        BorderPane bpHighestRevenueMonth = new BorderPane();
        bpHighestRevenueMonth.setId("bpGoalsScreen");
        Label labelHighestRevenueMonthMessage = new Label("Medarbejder med flest timer:");
        labelHighestRevenueMonthMessage.setId("labelMessage");

        // Vi opretter en ArrayList med den værdi der bliver hentet fra LogicControllers getTopHours() metode.
        ArrayList<ScheduleDays> topHoursList = new ArrayList(LogicController.getTopHours());
        double topHoursDouble = topHoursList.get(0).getTotalHours();
        String topHoursString = String.valueOf(topHoursDouble);

        Label labelHighestRevenueMonthCount = new Label(topHoursString + " timer");
        labelHighestRevenueMonthCount.setId("labelCount");

        // her skal der kaldes til en metode, der finder den bedste måned målt på omsætning frem
        bpHighestRevenueMonth.setTop(labelHighestRevenueMonthMessage);
        bpHighestRevenueMonth.setAlignment(labelHighestRevenueMonthMessage, Pos.TOP_CENTER);
        bpHighestRevenueMonth.setCenter(labelHighestRevenueMonthCount);

        //dagens mål
        BorderPane bpTodaysGoal = new BorderPane();
        ArrayList<Comment> comment = new ArrayList<Comment>(LogicController.getComment());
        String commentString = comment.get(0).getComment();
        bpTodaysGoal.setId("bpGoalsScreen");
        Label labelTodaysGoalMessage = new Label("Dagens kommentar:");
        labelTodaysGoalMessage.setId("labelMessage");
        Label labelTodaysGoalNumber = new Label(commentString);
        labelTodaysGoalNumber.setId("labelCount");
        //her skal der kaldes til en metode, der finder top fem frem.
        bpTodaysGoal.setTop(labelTodaysGoalMessage);
        bpTodaysGoal.setAlignment(labelTodaysGoalMessage, Pos.TOP_CENTER);
        bpTodaysGoal.setCenter(labelTodaysGoalNumber);


        //årets resultat for sælgeren
        BorderPane bpRevenueThisYear = new BorderPane();
        bpRevenueThisYear.setId("bpGoalsScreen");
        ArrayList<ScheduleDays> maxHoursList = new ArrayList(LogicController.getMaxHours());
        double maxHoursDouble = maxHoursList.get(0).getTotalHours();
        String maxHoursString = String.valueOf(maxHoursDouble);

        Label labelRevenueThisYearMessage = new Label("Total arbejdstimer:");
        labelRevenueThisYearMessage.setId("labelMessage");
        Label labelRevenueThisYearCount = new Label(maxHoursString + " timer");
        labelRevenueThisYearCount.setId("labelCount");
        //her skal der kaldes til en metode, der regner årets resultatet ud for sælgeren
        bpRevenueThisYear.setTop(labelRevenueThisYearMessage);
        bpRevenueThisYear.setAlignment(labelRevenueThisYearMessage, Pos.TOP_CENTER);
        bpRevenueThisYear.setCenter(labelRevenueThisYearCount);

        //nu skal de forskellige views samles
        GridPane gridPaneGoals = new GridPane();
        gridPaneGoals.setId("gridPaneGoals");
        gridPaneGoals.setPadding(new Insets(0, 30, 10, 30));
        gridPaneGoals.add(bpRevenueTotal, 0, 0);
        gridPaneGoals.add(bpTodaysGoal, 0, 1);
        gridPaneGoals.add(bpHighestRevenueMonth, 1, 0);
        gridPaneGoals.add(bpRevenueThisYear, 1, 1);

        goalsButton.setId("mActive");
        goalsButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);
        LoginGUI.whiteBackground.setCenter(gridPaneGoals);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //virksomheds screen
    public static void companiesScreen(Stage primaryStage){

        companiesButton.setId("mActive");
        companiesButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);


        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    public static void scheduleScreen(Stage primaryStage){

        scheduleButton.setId("mActive");
        scheduleButton.getStylesheets().addAll("gui/assets/login.css");



        //Bagrund for vagtplanen
        GridPane gpvagtplan = new GridPane();
        gpvagtplan.setHgap(15);
        gpvagtplan.setVgap(15);

        Label white = new Label();
        white.setId("emptyLabel");
        white.getStylesheets().addAll("gui/assets/login.css");

        Label monday = new Label("Mandag");
        monday.setId("dage");

        monday.getStylesheets().addAll("gui/assets/login.css");
        Label thuesday = new Label("Tirsdag");
        thuesday.setId("dage");
        thuesday.getStylesheets().addAll("gui/assets/login.css");
        Label wednesday = new Label("Onsdag");
        wednesday.setId("dage");
        wednesday.getStylesheets().addAll("gui/assets/login.css");
        Label thursday = new Label("Torsdag");
        thursday.setId("dage");
        thursday.getStylesheets().addAll("gui/assets/login.css");
        Label friday = new Label("Fredag");
        friday.setId("dage");
        friday.getStylesheets().addAll("gui/assets/login.css");

        Label checkIn = new Label("Ankomst");
        checkIn.setId("dage");
        checkIn.getStylesheets().addAll("gui/assets/login.css");
        Label checkOut = new Label("Afgang");
        checkOut.setId("dage");
        checkOut.getStylesheets().addAll("gui/assets/login.css");
        Label timer = new Label("Timer");
        timer.setId("dage");
        timer.getStylesheets().addAll("gui/assets/login.css");
        Label totalHoursWorkedLabel = new Label("Total Timer");
        totalHoursWorkedLabel.setId("dage");
        totalHoursWorkedLabel.getStylesheets().addAll("gui/assets/login.css");

        datoMandag.setId("datoTextfield");
        datoMandag.getStylesheets().addAll("gui/assets/login.css");

        datoTirsdag.setId("datoTextfield");
        datoTirsdag.getStylesheets().addAll("gui/assets/login.css");

        datoOnsdag.setId("datoTextfield");
        datoOnsdag.getStylesheets().addAll("gui/assets/login.css");

        datoTorsdag.setId("datoTextfield");
        datoTorsdag.getStylesheets().addAll("gui/assets/login.css");

        datoFredag.setId("datoTextfield");
        datoFredag.getStylesheets().addAll("gui/assets/login.css");


        datoMandag2.setId("datoTextfield");
        datoMandag2.getStylesheets().addAll("gui/assets/login.css");

        datoTirsdag2.setId("datoTextfield");
        datoTirsdag2.getStylesheets().addAll("gui/assets/login.css");

        datoOnsdag2.setId("datoTextfield");
        datoOnsdag2.getStylesheets().addAll("gui/assets/login.css");

        datoTorsdag2.setId("datoTextfield");
        datoTorsdag2.getStylesheets().addAll("gui/assets/login.css");


        datoFredag2.setId("datoTextfield");
        datoFredag2.getStylesheets().addAll("gui/assets/login.css");


        timerMandag.setId("datoTextfield");
        timerMandag.getStylesheets().addAll("gui/assets/login.css");

        timerMandag.setId("datoTextfield");
        timerMandag.getStylesheets().addAll("gui/assets/login.css");
        timerMandag.textProperty().addListener((observable, oldValue, newValue) -> {
            timerMandag.setText(timerMandag.getText());
        });


        timerTirsdag.setId("datoTextfield");
        timerTirsdag.getStylesheets().addAll("gui/assets/login.css");
        timerTirsdag.textProperty().addListener((observable, oldValue, newValue) -> {
            timerTirsdag.setText(timerTirsdag.getText());
        });

        timerOnsdag.setId("datoTextfield");
        timerOnsdag.getStylesheets().addAll("gui/assets/login.css");
        timerOnsdag.textProperty().addListener((observable, oldValue, newValue) -> {
            timerOnsdag.setText(timerOnsdag.getText());
        });


        timerTorsdag.setId("datoTextfield");
        timerTorsdag.getStylesheets().addAll("gui/assets/login.css");
        timerTorsdag.textProperty().addListener((observable, oldValue, newValue) -> {
            timerTorsdag.setText(timerTorsdag.getText());
        });


        timerFredag.setId("datoTextfield");
        timerFredag.getStylesheets().addAll("gui/assets/login.css");
        timerFredag.textProperty().addListener((observable, oldValue, newValue) -> {
            timerFredag.setText(timerFredag.getText());
        });


        totalTimer.setId("datoTextfield");
        totalTimer.getStylesheets().addAll("gui/assets/login.css");



        Button updateHours = new Button("Update");


        Button startTimer = new Button("Start");
        startTimer.setId("gemTimer");
        startTimer.getStylesheets().addAll("gui/assets/login.css");


        startTimer.setOnAction(event -> {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            diffMinutesStart = Datepicker.startDateStamp();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Calendar cal = Calendar.getInstance();

            //Variabler til brug af totalTid fra databasen
            ArrayList<ScheduleDays> arraylistSchedule =
                    new ArrayList<ScheduleDays>(LogicController.getSchedule(loggedInUser));
            double mondayDB = arraylistSchedule.get(0).getMonday();
            double tuesdayDB = arraylistSchedule.get(0).getTuesday();
            double wednesdayDB = arraylistSchedule.get(0).getWednesday();
            double thursdayDB = arraylistSchedule.get(0).getThursday();
            double fridayDB = arraylistSchedule.get(0).getFriday();
            double totalHoursDB = arraylistSchedule.get(0).getTotalHours();

            LogicController.scheduleLogicStart(day, dateFormat, cal, mondayDB,
                    tuesdayDB, wednesdayDB, thursdayDB, fridayDB, datoMandag, datoTirsdag,
                    datoOnsdag, datoTorsdag, datoFredag, timerMandag, timerTirsdag, timerOnsdag,
                    timerTorsdag, timerFredag);

            /*switch (day){
                case 2:
                dateMondayStart.setText(dateFormat.format(cal.getTime()));

                    mondayDB = 0.0;
                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                    hoursMonday.setText(String.valueOf(mondayDB));
                    hoursThuesday.setText(String.valueOf(tuesdayDB));
                    hoursWednesday.setText(String.valueOf(wednesdayDB));
                    hoursThursday.setText(String.valueOf(thursdayDB));
                    hoursFriday.setText(String.valueOf(fridayDB));


                break;
                case 3:
                dateThuesdayStart.setText(dateFormat.format(cal.getTime()));

                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    hoursMonday.setText(String.valueOf(mondayDB));
                    hoursThuesday.setText(String.valueOf(tuesdayDB));
                    hoursWednesday.setText(String.valueOf(wednesdayDB));
                    hoursThursday.setText(String.valueOf(thursdayDB));
                    hoursFriday.setText(String.valueOf(fridayDB));


                break;
                case 4:
                dateWednesdayStart.setText(dateFormat.format(cal.getTime()));

                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    hoursMonday.setText(String.valueOf(mondayDB));
                    hoursThuesday.setText(String.valueOf(tuesdayDB));
                    hoursWednesday.setText(String.valueOf(wednesdayDB));
                    hoursThursday.setText(String.valueOf(thursdayDB));
                    hoursFriday.setText(String.valueOf(fridayDB));


                break;
                case 5:
                dateThursdayStart.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    hoursMonday.setText(String.valueOf(mondayDB));
                    hoursThuesday.setText(String.valueOf(tuesdayDB));
                    hoursWednesday.setText(String.valueOf(wednesdayDB));
                    hoursThursday.setText(String.valueOf(thursdayDB));
                    hoursFriday.setText(String.valueOf(fridayDB));

                break;
                case 6:
                    fridayDB = 0.0;
                     dateFridayStart.setText(dateFormat.format(cal.getTime()));
                    hoursMonday.setText(String.valueOf(mondayDB));
                    hoursThuesday.setText(String.valueOf(tuesdayDB));
                    hoursWednesday.setText(String.valueOf(wednesdayDB));
                    hoursThursday.setText(String.valueOf(thursdayDB));
                    hoursFriday.setText(String.valueOf(fridayDB));
                break;
            }*/
        });

        ArrayList<ScheduleDays> arraylistSchedule = new ArrayList<>(LogicController.getSchedule(loggedInUser));

        Button stopTimer = new Button("Stop");
        stopTimer.setId("gemTimer");
        stopTimer.getStylesheets().addAll("gui/assets/login.css");
        stopTimer.setOnAction(event -> {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Calendar cal = Calendar.getInstance();

            //Variabler til brug af totalTid fra databasen
            double mondayDB = arraylistSchedule.get(0).getMonday();
            double tuesdayDB = arraylistSchedule.get(0).getTuesday();
            double wednesdayDB = arraylistSchedule.get(0).getWednesday();
            double thursdayDB = arraylistSchedule.get(0).getThursday();
            double fridayDB = arraylistSchedule.get(0).getFriday();
            double totalHoursDB = arraylistSchedule.get(0).getTotalHours();

            LogicController.scheduleLogicEnd(day, dateFormat, cal, mondayDB,
                    tuesdayDB, wednesdayDB, thursdayDB, fridayDB, totalHoursDB,
                    datoMandag2, datoTirsdag2, datoOnsdag2, datoTorsdag2, datoFredag2,
                    diffMinutesEnd, diffMinutesStart, totalTimer,
                    timerMandag, timerTirsdag, timerOnsdag, timerTorsdag, timerFredag);


            /*switch (day){
                case 2:
                    mondayDB = 0.0;
                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

               diffMinutesEnd = backend.Datepicker.endDateStamp();
                dateMondayStop.setText(dateFormat.format(cal.getTime()));
                    mondayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer2 = String.valueOf(mondayDB);
                    hoursMonday.setText(timer2);
                break;
                case 3:

                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                dateThuesdayStop.setText(dateFormat.format(cal.getTime()));
                    tuesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer4 = String.valueOf(tuesdayDB);
                    hoursThuesday.setText(timer4);
                break;
                case 4:

                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                dateWednesdayStop.setText(dateFormat.format(cal.getTime()));
                wednesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer6 = String.valueOf(wednesdayDB);
                hoursWednesday.setText(timer6);
                break;
                case 5:
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                dateThursdayStop.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer8 = String.valueOf(thursdayDB);
                    hoursThursday.setText(timer8);
                break;
                case 6:

                    fridayDB = 0.0;
                diffMinutesEnd = backend.Datepicker.endDateStamp();
                dateFridayStop.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer10 = String.valueOf(thursdayDB);
                    hoursFriday.setText(timer10);
            }

            totalHoursDB = Datepicker.ugentligeTimer(mondayDB, tuesdayDB, wednesdayDB, thursdayDB, fridayDB);
            String totalTimerString = String.valueOf(totalHoursDB);
    
            totalTimer.setText(totalTimerString);*/


        });
        updateHours.setOnAction(event -> {
            double totalTimerDouble =
                     Double.parseDouble(timerMandag.getText())
                    + Double.parseDouble(timerTirsdag.getText())
                    + Double.parseDouble(timerOnsdag.getText())
                    + Double.parseDouble(timerTorsdag.getText())
                    + Double.parseDouble(timerFredag.getText());
            ScheduleDays timerUpdate = new ScheduleDays((Double.parseDouble(timerMandag.getText())),
                    (Double.parseDouble(timerTirsdag.getText())),
                    (Double.parseDouble(timerOnsdag.getText())),
                    (Double.parseDouble(timerTorsdag.getText())),
                    (Double.parseDouble(timerFredag.getText())),
                    (totalTimerDouble));
            LogicController.updateSchedule(timerUpdate, loggedInUser);
            totalTimer.setText(String.valueOf(totalTimerDouble));
            /*totalTimer.textProperty().addListener((observable, oldValue, newValue) -> {
                totalTimer.setText(String.valueOf(totalTimerDouble));
            });*/
        });



        //Label af dagenen
        gpvagtplan.add(white,1,1);
        gpvagtplan.add(monday,2,1);
        gpvagtplan.add(thuesday,3,1);
        gpvagtplan.add(wednesday,4,1);
        gpvagtplan.add(thursday,5,1);
        gpvagtplan.add(friday,6,1);

        //Label af dato, timer og knap til at gemme
        gpvagtplan.add(checkIn,1,2);
        gpvagtplan.add(checkOut,1,3);
        gpvagtplan.add(timer,1,4);
        gpvagtplan.add(totalHoursWorkedLabel,1,5);
        gpvagtplan.add(startTimer,1,6);
        gpvagtplan.add(stopTimer,1,7);
        gpvagtplan.add(updateHours,1,8);

        //Labels til alle dagene
        gpvagtplan.add(datoMandag,2,2);
        gpvagtplan.add(datoTirsdag,3,2);
        gpvagtplan.add(datoOnsdag,4,2);
        gpvagtplan.add(datoTorsdag,5,2);
        gpvagtplan.add(datoFredag,6,2);

        gpvagtplan.add(datoMandag2,2,3);
        gpvagtplan.add(datoTirsdag2,3,3);
        gpvagtplan.add(datoOnsdag2,4,3);
        gpvagtplan.add(datoTorsdag2,5,3);
        gpvagtplan.add(datoFredag2,6,3);

        gpvagtplan.add(timerMandag,2,4);
        gpvagtplan.add(timerTirsdag,3,4);
        gpvagtplan.add(timerOnsdag,4,4);
        gpvagtplan.add(timerTorsdag,5,4);
        gpvagtplan.add(timerFredag,6,4);
        gpvagtplan.add(totalHoursWorkedLabel,6,5);

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);
        LoginGUI.whiteBackground.setCenter(gpvagtplan);



        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    public static void scheduleOverviewScreen(Stage primaryStage){



        backend.LogicController.getComment();


        ArrayList<ScheduleDays> maxHoursList = new ArrayList<>(LogicController.getUsernameHours());
        ArrayList<ScheduleDays> maxHoursList1 = new ArrayList<>(LogicController.getHoursUsername());
        ArrayList<Double> comboBoxArray1 = new ArrayList<>();
        ArrayList<String> comboBoxArray2 = new ArrayList<>();


        ComboBox person1 = new ComboBox();
        person1.setId("combobox");
        person1.getStylesheets().addAll("gui/assets/login.css");
        person1.setPromptText("Vælger bruger 1");

        ComboBox person2 = new ComboBox();
        person2.setId("combobox");
        person2.getStylesheets().addAll("gui/assets/login.css");
        person2.setPromptText("Vælger bruger 2");


        Label personLabel1 = new Label("\"Antal timer person 1\"");
        personLabel1.setId("personlabelCombobox");
        personLabel1.getStylesheets().addAll("gui/assets/login.css");
        Label personLabel2 = new Label("\"Antal timer person 2\"");
        personLabel2.setId("personlabelCombobox");
        personLabel2.getStylesheets().addAll("gui/assets/login.css");


        for(int i = 0; i < maxHoursList.size();i++) {
            comboBoxArray1.add(maxHoursList1.get(i).getTotalHours());
            comboBoxArray2.add(maxHoursList.get(i).getUsername());
            person1.getItems().add(comboBoxArray2.get(i));
            person2.getItems().add(comboBoxArray2.get(i));
        }
        person1.setOnAction(event -> {
            backend.LogicController.comboboxLogic(comboBoxArray2, comboBoxArray1,
                    person1, personLabel1);
        });

        person2.setOnAction(event -> {
            backend.LogicController.comboboxLogic(comboBoxArray2, comboBoxArray1,
                    person2, personLabel2);

        });


        BorderPane totalHoursPerson1 = new BorderPane();
        totalHoursPerson1.setId("bpGoalsScreen");
        Label labelTotalHoursMessage = new Label("Total antal timer:");
        labelTotalHoursMessage.setId("labelMessage");
        //her skal der kaldes til en metode, der regner årets resultatet ud for sælgeren
        totalHoursPerson1.setTop(labelTotalHoursMessage);
        totalHoursPerson1.setAlignment(labelTotalHoursMessage, Pos.TOP_CENTER);
        totalHoursPerson1.setCenter(person1);
        totalHoursPerson1.setBottom(personLabel1);
        totalHoursPerson1.setAlignment(personLabel1, Pos.BOTTOM_CENTER);

        BorderPane totalHoursPerson2 = new BorderPane();
        totalHoursPerson2.setId("bpGoalsScreen");
        Label labelTotalHoursMessage2 = new Label("Total antal timer for:");
        labelTotalHoursMessage2.setId("labelMessage");
        Label labelTotalHours2 = new Label("1000000");
        //her skal der kaldes til en metode, der regner årets resultatet ud for sælgeren
        totalHoursPerson2.setTop(labelTotalHoursMessage2);
        totalHoursPerson2.setAlignment(labelTotalHoursMessage2, Pos.TOP_CENTER);
        totalHoursPerson2.setCenter(person2);
        totalHoursPerson2.setBottom(personLabel2);
        totalHoursPerson2.setAlignment(personLabel2, Pos.BOTTOM_CENTER);


        BorderPane commentBP = new BorderPane();
        totalHoursPerson1.setId("bpGoalsScreen");
        Label labelKommentar = new Label("Skriv en kommentar");
        labelKommentar.setId("labelMessage");
        TextField kommentar = new TextField();
        kommentar.setId("kommentarTextfield");
        kommentar.setPromptText("Skriv din kommentar");
        //her skal der kaldes til en metode, der regner årets resultatet ud for sælgeren
        commentBP.setTop(labelKommentar);
        commentBP.setAlignment(labelKommentar, Pos.TOP_CENTER);
        commentBP.setCenter(kommentar);




        Button commitKommentar = new Button("Commit");
        commitKommentar.setId("btncommit");
        commitKommentar.getStylesheets().addAll("gui/assets/login.css");
        commitKommentar.setOnAction(event -> {
            backend.LogicController.addComment(new Comment(kommentar.getText()));
        });



        //nu skal de forskellige views samles
        GridPane gridPaneGoals = new GridPane();
        gridPaneGoals.setId("gridPaneGoals");
        gridPaneGoals.setPadding(new Insets(0, 30, 10, 30));
        gridPaneGoals.add(totalHoursPerson1, 0, 0);
        gridPaneGoals.add(commentBP, 0, 1);
        gridPaneGoals.add(totalHoursPerson2, 1, 0);
        gridPaneGoals.add(commitKommentar, 1, 1);


        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);

        LoginGUI.whiteBackground.setCenter(gridPaneGoals);


        primaryStage.setScene(postLogin);
        primaryStage.show();

    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }

    //Adminscreen
    public static void usersScreen(Stage primaryStage){

        userButton.setId("mActive");
        userButton.getStylesheets().addAll("gui/assets/login.css");

        boolean alreadyExecuted = false;

        if(alreadyExecuted = false) {
            gui.Tableviews.methods.UserMethod.userTableviewStart();
            LoginGUI.whiteBackground.setCenter(UserMethod.hboxUser);
            alreadyExecuted = true;
        }

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottomHBox);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }
}