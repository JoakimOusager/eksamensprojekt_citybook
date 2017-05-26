package gui;/**
 * Created by jarl on 16/05/2017.
 */

//import gui.Tableviews.methods.ActivityMethod;

import backend.Datepicker;
import backend.LogicController;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeGUI extends Application {

    // De skulle bruges ofte, så de er static
    static VBox menuVBox = new VBox();
    static HBox bottom = new HBox();
    static Scene postLogin = new Scene(LoginGUI.BPBackground);

    //Buttons
    static Button activitiesButton = new Button("Aktiviteter");
    static Button goalsButton = new Button("Mål");
    static Button companiesButton = new Button("Virksomheder");
    static Button userButton = new Button("Brugere");
    static Button logoutButton = new Button("Log out");
    static Button homepageButton = new Button("Hjem");
    static Button vagtplanButton = new Button("Vagtplan");
    static Button vagtplansOverblikbtn = new Button("Vagtplanoverblik");

    static User loggedInUser;

    //labels for vagtplan er gjort static for at labelens text ikke bliver reset ved scene skift
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

    static Label timerMandag = new Label();
    static Label timerTirsdag = new Label();
    static Label timerOnsdag = new Label();
    static Label timerTorsdag = new Label();
    static Label timerFredag = new Label();

    static Label totalTimer = new Label();

    //Long tids variabler
    static long diffMinutesStart;
    static long diffMinutesEnd;



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
        userButton.getStylesheets().addAll("gui/assets/login.css");
        userButton.setId("buttonsleftside");

    }

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
        /*
            Vi kalder på metoden CalendarView når knappen "Aktiviteter" bliver trykket på.
            Knappen bliver også nulstillet, så vores CSS bliver nulstillet.
        */
        activitiesButton.setOnAction((ActionEvent event1) -> {
            buttonReset();

            CalendarView(primaryStage);

   /*         aktivitetScreen(primaryStage);
            LoginGUI.whiteBackground.setCenter(ActivityMethod.hboxAktivitet); */

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

        //Knap lavet specifikt til vagtplan
        vagtplanButton.getStylesheets().addAll("gui/assets/login.css");
        vagtplanButton.setId("buttonsleftside");
        vagtplanButton.setOnMouseEntered((MouseEvent e) -> {
            vagtplanButton.setUnderline(true);
        });
        vagtplanButton.setOnMouseExited((MouseEvent e) -> {
            vagtplanButton.setUnderline(false);
        });
        vagtplanButton.setOnAction((ActionEvent event3) -> {
            buttonReset();
            vagtplanScreen(primaryStage);

        });

        //Knap lavet specifikt til vagtplansoverblik
        vagtplansOverblikbtn.getStylesheets().addAll("gui/assets/login.css");
        vagtplansOverblikbtn.setId("buttonsleftside");
        vagtplansOverblikbtn.setOnMouseEntered((MouseEvent e) -> {
            vagtplansOverblikbtn.setUnderline(true);
        });
        vagtplansOverblikbtn.setOnMouseExited((MouseEvent e) -> {
            vagtplansOverblikbtn.setUnderline(false);
        });
        vagtplansOverblikbtn.setOnAction((ActionEvent event3) -> {
            buttonReset();
            virksomhedsScreen(primaryStage);

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

        });
        menuVBox.setId("menuVBox");
        menuVBox.getChildren().addAll(homepageButton, activitiesButton, goalsButton, companiesButton,
                vagtplanButton, vagtplansOverblikbtn, userButton, logoutButton);
        menuVBox.setPadding(new Insets(10, 10, 10, 10));

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
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(Calendar.getInstance().getTime());
        Label welcome = new Label("Du er logget ind "+ timeStamp+"\nVelkommen tilbage "+ loggedInUser.getUsername());
        welcome.setId("welcomeLabel");
        welcome.getStylesheets().addAll("gui/assets/login.css");

        homepageButton.setId("mActive");
        homepageButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI.whiteBackground.setLeft(menuVBox);
        LoginGUI. whiteBackground.setBottom(bottom);
        LoginGUI.whiteBackground.setCenter(welcome);

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

        ArrayList<ScheduleDays> topHoursList = new ArrayList(LogicController.getTopHours());
        double topHoursDouble = topHoursList.get(0).getTotalHours();
        String topHoursString = String.valueOf(topHoursDouble);

        Label labelHighestRevenueMonthCount = new Label(topHoursString + " timer");
        labelHighestRevenueMonthCount.setId("labelCount");
        //her skal der kaldes til en metode, der finder den bedste måned målt på omsætning frem
        bpHighestRevenueMonth.setTop(labelHighestRevenueMonthMessage);
        bpHighestRevenueMonth.setAlignment(labelHighestRevenueMonthMessage, Pos.TOP_CENTER);
        bpHighestRevenueMonth.setCenter(labelHighestRevenueMonthCount);

        //dagens mål
        BorderPane bpTodaysGoal = new BorderPane();
        bpTodaysGoal.setId("bpGoalsScreen");
        Label labelTodaysGoalMessage = new Label("Dagens mål:");
        labelTodaysGoalMessage.setId("labelMessage");
        Label labelTodaysGoalNumber = new Label("24000 kr");
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
        LoginGUI.whiteBackground.setBottom(bottom);
        LoginGUI.whiteBackground.setCenter(gridPaneGoals);

        primaryStage.setScene(postLogin);
        primaryStage.show();
    }

    //virksomheds screen
    public static void virksomhedsScreen(Stage primaryStage){

        vagtplanButton.setId("mActive");
        vagtplanButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);


        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    public static void vagtplanScreen(Stage primaryStage){

        companiesButton.setId("mActive");
        companiesButton.getStylesheets().addAll("gui/assets/login.css");



        //Bagrund for vagtplanen
        GridPane gpvagtplan = new GridPane();
        gpvagtplan.setHgap(15);
        gpvagtplan.setVgap(15);

        Label white = new Label();
        white.setId("emptyLabel");
        white.getStylesheets().addAll("gui/assets/login.css");

        Label mandag = new Label("Mandag");
        mandag.setId("dage");

        mandag.getStylesheets().addAll("gui/assets/login.css");
        Label tirsdag = new Label("Tirsdag");
        tirsdag.setId("dage");
        tirsdag.getStylesheets().addAll("gui/assets/login.css");
        Label onsdag = new Label("Onsdag");
        onsdag.setId("dage");
        onsdag.getStylesheets().addAll("gui/assets/login.css");
        Label torsdag = new Label("Torsdag");
        torsdag.setId("dage");
        torsdag.getStylesheets().addAll("gui/assets/login.css");
        Label fredag = new Label("Fredag");
        fredag.setId("dage");
        fredag.getStylesheets().addAll("gui/assets/login.css");

        Label ankomst = new Label("Ankomst");
        ankomst.setId("dage");
        ankomst.getStylesheets().addAll("gui/assets/login.css");
        Label afgang = new Label("Afgang");
        afgang.setId("dage");
        afgang.getStylesheets().addAll("gui/assets/login.css");
        Label timer = new Label("Timer");
        timer.setId("dage");
        timer.getStylesheets().addAll("gui/assets/login.css");
        Label totalTimerLabel = new Label("Total Timer");
        totalTimerLabel.setId("dage");
        totalTimerLabel.getStylesheets().addAll("gui/assets/login.css");



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

        timerTirsdag.setId("datoTextfield");
        timerTirsdag.getStylesheets().addAll("gui/assets/login.css");

        timerOnsdag.setId("datoTextfield");
        timerOnsdag.getStylesheets().addAll("gui/assets/login.css");

        timerTorsdag.setId("datoTextfield");
        timerTorsdag.getStylesheets().addAll("gui/assets/login.css");

        timerFredag.setId("datoTextfield");
        timerFredag.getStylesheets().addAll("gui/assets/login.css");

        totalTimer.setId("datoTextfield");
        totalTimer.getStylesheets().addAll("gui/assets/login.css");


        Button startTimer = new Button("Start");
        startTimer.setId("gemTimer");
        startTimer.getStylesheets().addAll("gui/assets/login.css");


        startTimer.setOnAction(event -> {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            diffMinutesStart = backend.Datepicker.startDateStamp();
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

            switch (day){
                case 2:
                datoMandag.setText(dateFormat.format(cal.getTime()));

                    mondayDB = 0.0;
                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                    timerMandag.setText(String.valueOf(mondayDB));
                    timerTirsdag.setText(String.valueOf(tuesdayDB));
                    timerOnsdag.setText(String.valueOf(wednesdayDB));
                    timerTorsdag.setText(String.valueOf(thursdayDB));
                    timerFredag.setText(String.valueOf(fridayDB));


                break;
                case 3:
                datoTirsdag.setText(dateFormat.format(cal.getTime()));

                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    timerMandag.setText(String.valueOf(mondayDB));
                    timerTirsdag.setText(String.valueOf(tuesdayDB));
                    timerOnsdag.setText(String.valueOf(wednesdayDB));
                    timerTorsdag.setText(String.valueOf(thursdayDB));
                    timerFredag.setText(String.valueOf(fridayDB));


                break;
                case 4:
                datoOnsdag.setText(dateFormat.format(cal.getTime()));

                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    timerMandag.setText(String.valueOf(mondayDB));
                    timerTirsdag.setText(String.valueOf(tuesdayDB));
                    timerOnsdag.setText(String.valueOf(wednesdayDB));
                    timerTorsdag.setText(String.valueOf(thursdayDB));
                    timerFredag.setText(String.valueOf(fridayDB));


                break;
                case 5:
                datoTorsdag.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = 0.0;
                    fridayDB = 0.0;
                    timerMandag.setText(String.valueOf(mondayDB));
                    timerTirsdag.setText(String.valueOf(tuesdayDB));
                    timerOnsdag.setText(String.valueOf(wednesdayDB));
                    timerTorsdag.setText(String.valueOf(thursdayDB));
                    timerFredag.setText(String.valueOf(fridayDB));

                break;
                case 6:
                    fridayDB = 0.0;
                     datoFredag.setText(dateFormat.format(cal.getTime()));
                    timerMandag.setText(String.valueOf(mondayDB));
                    timerTirsdag.setText(String.valueOf(tuesdayDB));
                    timerOnsdag.setText(String.valueOf(wednesdayDB));
                    timerTorsdag.setText(String.valueOf(thursdayDB));
                    timerFredag.setText(String.valueOf(fridayDB));
                break;
            }
        });

        Button stopTimer = new Button("Stop");
        stopTimer.setId("gemTimer");
        stopTimer.getStylesheets().addAll("gui/assets/login.css");
        stopTimer.setOnAction(event -> {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
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

            switch (day){
                case 2:
                    mondayDB = 0.0;
                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

               diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoMandag2.setText(dateFormat.format(cal.getTime()));
                    mondayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer2 = String.valueOf(mondayDB);
                    timerMandag.setText(timer2);
                break;
                case 3:

                    tuesdayDB = 0.0;
                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                datoTirsdag2.setText(dateFormat.format(cal.getTime()));
                    tuesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer4 = String.valueOf(tuesdayDB);
                    timerTirsdag.setText(timer4);
                break;
                case 4:

                    wednesdayDB = 0.0;
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoOnsdag2.setText(dateFormat.format(cal.getTime()));
                wednesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer6 = String.valueOf(wednesdayDB);
                timerOnsdag.setText(timer6);
                break;
                case 5:
                    thursdayDB = 0.0;
                    fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoTorsdag2.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer8 = String.valueOf(thursdayDB);
                    timerTorsdag.setText(timer8);
                break;
                case 6:

                    fridayDB = 0.0;
                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoFredag2.setText(dateFormat.format(cal.getTime()));
                    thursdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                    String timer10 = String.valueOf(thursdayDB);
                    timerFredag.setText(timer10);
            }

            totalHoursDB = Datepicker.ugentligeTimer(mondayDB, tuesdayDB, wednesdayDB, thursdayDB, fridayDB);
            System.out.println(mondayDB);
            System.out.println(tuesdayDB);
            System.out.println(wednesdayDB);
            System.out.println(thursdayDB);
            System.out.println(fridayDB);
            String totalTimerString = String.valueOf(totalHoursDB);
            totalTimer.setText(totalTimerString);


        });


        //Label af dagenen
        gpvagtplan.add(white,1,1);
        gpvagtplan.add(mandag,2,1);
        gpvagtplan.add(tirsdag,3,1);
        gpvagtplan.add(onsdag,4,1);
        gpvagtplan.add(torsdag,5,1);
        gpvagtplan.add(fredag,6,1);

        //Label af dato, timer og knap til at gemme
        gpvagtplan.add(ankomst,1,2);
        gpvagtplan.add(afgang,1,3);
        gpvagtplan.add(timer,1,4);
        gpvagtplan.add(totalTimerLabel,1,5);
        gpvagtplan.add(startTimer,1,6);
        gpvagtplan.add(stopTimer,1,7);

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
        gpvagtplan.add(totalTimer,6,5);

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);
        LoginGUI.whiteBackground.setCenter(gpvagtplan);



        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //virksomhedsoverbliks screen
    public static void virksomhedsOverblikScreen(Stage primaryStage){

        vagtplanButton.setId("mActive");
        vagtplanButton.getStylesheets().addAll("gui/assets/login.css");

        LoginGUI.BPBackground.setCenter(LoginGUI.whiteBackground);
        LoginGUI.whiteBackground.setTop(LoginGUI.citybookLogoPane);
        LoginGUI. whiteBackground.setLeft(menuVBox);
        LoginGUI.whiteBackground.setBottom(bottom);


        primaryStage.setScene(postLogin);
        primaryStage.show();

    }

    //Adminscreen
    public static void adminScreen(Stage primaryStage){

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

}