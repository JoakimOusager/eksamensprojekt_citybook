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

////////////////////////////////////////////// Joakim og Jarl /////////////////////////////////////////////

public class UserTableView {

    public static HBox hboxUser                     = new HBox();


    public static TableView<User> tvUser            = new TableView<>();
    public static TextField username ,email, startDate, userRank;
    public static PasswordField password;
    public static Button showMoreUserBtn;


    //  Returnerer alle brugere.
    public static ObservableList<User> getUser() {
        ObservableList<User> user = FXCollections.observableArrayList(LogicController.getUsers());
        return user;
    }

     // Dette er vores metode til at tilføje en bruger.

    public static void addUser() {
            // Vi laver et User objekt.

            User user = new User();


            // Vi henter data fra TextFields og sætter deres værdier ind i vores objekt vha. Getters & Setters
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setEmail(email.getText());
            user.setRank(Integer.parseInt(userRank.getText()));

            // Vi tilføjer alt data fra TableView til vores objekt
            tvUser.getItems().add(user);

            // Herefter bruger vi Clear() metoden til at nulstille vores TextFields.
            username.clear();
            password.clear();
            email.clear();
            userRank.clear();

            // Vi overfører objektet til LogicControllers addUser() metode.
            LogicController.addUser(user);
            tvUser.setItems(FXCollections.observableArrayList(LogicController.getUsers()));
    }

     //   Dette er vores metode til at slette en bruger. Vi laver en ObservableList
     //   der indeholder det User objekt som bliver valgt med userSelected.
     //   Herefter bliver den valgte bruger slettet.

    public static void deleteUser() {
        ObservableList<User> userSelected, allUsers;
        allUsers = tvUser.getItems();
        userSelected = tvUser.getSelectionModel().getSelectedItems();

        for (User user : userSelected) {
            LogicController.deleteUser(user);
        }
        // Fjerner den valgte bruger.
        userSelected.forEach(allUsers::remove);
    }


    //   Knappen 'Brugere' generer dette TableView.
    public static void userTableviewStart() {

        // Vi opretter de kolonner som bliver vist i vores TableView for brugere.

        // Kolonne for brugernavn
        TableColumn<User, String> usernameCol        = new TableColumn<>("Username");
        usernameCol.setMinWidth(150);
        usernameCol.setCellValueFactory(               new PropertyValueFactory<>("username"));

        // Kolonne for Email
        TableColumn<User, String> emailCol           = new TableColumn<>("Email");
        emailCol.setMinWidth(250);
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

        //////////////////////////// Jarl ////////////////////////////
        // Vores 'Tilføj bruger' knap der kalder på addUser() metoden.
        addUserBtn.setOnAction(successBox -> addUser());

        // Knappen Slet Bruger under fanen "Brugere"
        Button deleteUserBtn                         = new Button("Slet Bruger");
        deleteUserBtn.setId("deleteEmployeeButton");

        //   Vores 'Slet bruger' knap, hvor vi har sat en alertbox på
        //   der spørger om brugeren er sikker på denne handling.
        //   Hvis brugeren trykker 'Ok' så bliver deleteUser() metoden kaldt
        //   ellers sker der ingenting.
        deleteUserBtn.setOnAction(alertBox ->{
                Alert alert                          = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Citybook");
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Er du sikker på at du vil slette denne bruger?");
                Optional<ButtonType> result          = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    deleteUser();
                }
        });

        //////////////////////////////////////// Jarl  & Joakim //////////////////////////////////////////////////
        //   Når man trykker på ShowMoreUserBtn
        //   overfører den hvilken virksomhed man har valgt til metoden
        //   showMoreUserButtonClicked() fra EditUser klassen
        showMoreUserBtn                              = new Button("Redigér");
        showMoreUserBtn.setId("showMoreInformationAboutCompanyButton");
        showMoreUserBtn.setOnAction(e-> {
            ObservableList<User> selectedUser        = tvUser.getSelectionModel().getSelectedItems();
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

