package gui;

import application.LogicController;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

import static gui.EditUser.showMoreUserButtonClicked;

//////////////////////////////////////////////Joakim og Jarl/////////////////////////////////////////////

public class UserTableView {

    public static HBox hboxUser                     = new HBox();


    public static TableView<User> tvUser            = new TableView<>();
    public static TextField username ,email, startDate, userRank;
    public static PasswordField password;
    public static Button showMoreUserBtn;

    /*
        Returnerer alle brugere.
    */
    public static ObservableList<User> getUser() {
        ObservableList<User> user = FXCollections.observableArrayList(LogicController.getUsers());
        return user;
    }

    /*
        Dette er vores metode til at tilføje en bruger.
    */
    public static void addUser() {
        // Vi laver et User objekt.
        User user                                   = new User();

        // Vi henter det tekst der er blevet skrevet ind i vores TextFields.
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setEmail(email.getText());
        user.setRank(Integer.parseInt(userRank.getText()));

        // Vi tilføjer alt teksten til vores TableView
        tvUser.getItems().add(user);

        // Herefter bruger vi Clear() metoden til at nulstille vores TextFields.
        username.clear();
        password.clear();
        email.clear();
        userRank.clear();

        // Vi overfører objektet til LogicControllers addUser() metode.
        LogicController.addUser(user);
    }

    /*
        Dette er vores metode til at slette en bruger.
    */
    public static void deleteUser() {
        // Vi laver en ObservableList der indeholder et User objekt
        // der kommer til at indeholde hvilken bruger der er valgt.
        ObservableList<User> userSelected, allUsers;
        allUsers = tvUser.getItems();

      /* getSelectionModel henter den værdi der er i det valgte row.
         getSelectedItems returnere den valgte row med den værdi hentet fra getSelectionModel.
         Dette bliver lagt ind i userSelected.
      */
        userSelected = tvUser.getSelectionModel().getSelectedItems();

        /*
            Vi har et for-loop der finder den valgte bruger i vores objekt
            for derefter at kalde på vores deleteUser() metode i LogicController.
        */
        for (User user : userSelected) {
            LogicController.deleteUser(user);
        }
        // Fjerner den valgte bruger.
        userSelected.forEach(allUsers::remove);
    }

    /*
        Knappen 'Brugere' generer dette TableView.
    */
    public static void userTableviewStart() {

        /*
            Vi opretter de kolonner som bliver vist i vores TableView for brugere.
        */

        // Kolonne for brugernavn
        TableColumn<User, String> usernameCol        = new TableColumn<>("Username");
        usernameCol.setMinWidth(150);
        usernameCol.setCellValueFactory(               new PropertyValueFactory<>("username"));

        // Kolonne for Email
        TableColumn<User, String> emailCol           = new TableColumn<>("Email");
        emailCol.setMinWidth(185);
        emailCol.setCellValueFactory(                  new PropertyValueFactory<>("email"));

        // Kolonne for Start dato // Timestamp
        TableColumn<User, String> startDateCol       = new TableColumn<>("Start time");
        startDateCol.setMinWidth(185);
        startDateCol.setCellValueFactory(              new PropertyValueFactory<>("startDate"));

        // Bruger rang, 1 for admin, 0 for normal bruger.
        TableColumn<User, Number> userRankCol        = new TableColumn<>("User rank");
        userRankCol.setMinWidth(5);
        userRankCol.setCellValueFactory(               new PropertyValueFactory<>("rank"));

        // GridPane der indeholder vores TextFields og knapper.
        GridPane gp3                                 = new GridPane();

        // VBoxes for vores TextFields
        VBox addUserBox                              = new VBox();
        addUserBox.setSpacing(10);
        addUserBox.setPadding(                         new Insets(1, 10, 100, 10));
        gp3.add(addUserBox, 0, 0);


        VBox addUserbox2                             = new VBox();
        addUserbox2.setSpacing(10);

        // Knappen Tilføj Bruger under fanen "Brugere"
        Button addUserBtn                            = new Button("Tilføj Bruger");
        addUserBtn.setId("addEmployeeButton");

        /*
            Alertbox der meddeler admin at brugeren er blevet oprettet
         */

        addUserBtn.setOnAction(successBox ->{
            /*
                 Vi kalder på metoden addUser() uanset hvad brugeren trykker
                 inde i vores AlertBox vindue.
            */
            addUser();

            /*
                Vi henter data fra databasen igen, for at få tidspunktet direkte frem i TableView fremfor
                at skulle lukke programmet igen for at få det vist. Dette er dog ikke en særlig optimal måde
                at gøre det på, da LogicController skal kontakte databasen igen for at få alt data frem igen.
            */
            tvUser.setItems(FXCollections.observableArrayList(LogicController.getUsers()));

            // Vi opretter et ny 'AlertBox' vindue
            Alert alert                              = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Citybook");
            alert.setHeaderText("Bekræftelse");
            alert.setContentText("Brugeren er nu blevet oprettet.");

            /*
                Vinduet venter ikke på at brugeren trykker på noget
                før at vores lambda bliver kørt. Vi bruger kun AlertBox
                her for at vise at brugeren er blevet oprettet.
            */
            Optional<ButtonType> result              = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
            }
        });
        // Knappen Slet Bruger under fanen "Brugere"
        Button deleteUserBtn                         = new Button("Slet Bruger");
        deleteUserBtn.setId("deleteEmployeeButton");

        /*
           Alertbox til at sikre os at admin gerne vil slette en bruger.
        */
        deleteUserBtn.setOnAction(alertBox ->{
                // Vi opretter et ny 'AlertBox' vindue
                Alert alert                          = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Citybook");
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Er du sikker på at du vil slette denne bruger?");

                /*
                    Vinduet venter på, at der bliver smidt noget ind i result,
                    den værdi som er i result afgører hvad der bliver udført.
                    Hvis brugeren trykker på 'Ok' bliver if-statement kørt,
                    ellers lukker vinduet bare og ingenting sker.
                */
                Optional<ButtonType> result          = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    deleteUser();
                }
        });

        // Jarl
        showMoreUserBtn = new Button("Redigér");
        showMoreUserBtn.setId("showMoreInformationAboutCompanyButton");
        showMoreUserBtn.setOnAction(e-> {
            ObservableList<User> selectedUser    = tvUser.getSelectionModel().getSelectedItems();
            showMoreUserButtonClicked(selectedUser.get(0));
        });

        // Vores TextFields til brugere view.
        username                                     = new TextField();
        username.setPromptText("Brugernavn");
        username.setMaxWidth(100);

        password                                     = new PasswordField();
        password.setPromptText("Kodeord");
        password.setMaxWidth(100);

        email                                        = new TextField();
        email.setPromptText("Email");
        email.setMaxWidth(100);

        userRank                                     = new TextField();
        userRank.setPromptText("Rang");
        userRank.setMaxWidth(100);

        // Tilføjer TextFields til VBox addUserBox og addUserBox2
        addUserBox.getChildren().addAll(username, password, email, userRank,
                addUserBtn, deleteUserBtn, showMoreUserBtn);
        Label white                                  = new Label();
        white.setId("whiteCompany");
        white.getStylesheets().addAll("gui/assets/login.css");

        addUserbox2.getChildren().addAll(white);

        // Vi sætter data i vores TableView til hvad metoden getUser() henter.
        tvUser.setItems(getUser());
        tvUser.setId("tvUser");
        tvUser.getStylesheets().addAll("gui/assets/login.css");

        tvUser.getColumns().addAll(usernameCol, emailCol, startDateCol, userRankCol);
        hboxUser.setId("hboxAktivitet");
        hboxUser.getStylesheets().addAll("gui/assets/login.css");
        hboxUser.getChildren().addAll(addUserbox2, tvUser, gp3);

    }
}

