package gui.Tableviews.methods;

import backend.LogicController;
import entities.Company;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;


/**
 * Created by Daniel on 17-05-2017.
 */
public class UserMethod {

    public static HBox hboxUser = new HBox();


    public static TableView<User> tvUser = new TableView<>();
    public static TextField username, password ,email, startDate, userRank;

    // Get all the Users
    public static ObservableList<User> getUser() {
        ObservableList<User> user = FXCollections.observableArrayList(LogicController.getUsers());
      /*  user.add(new User(1,"37144266", "Daniel", "Englandsvej", "2300", 1));
        user.add(new User(2, "Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));
        user.add(new User(3, "Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));
        user.add(new User(4, "Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));*/
        return user;
    }

    // Add children method
    public static void addUser() {
        User user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setEmail(email.getText());
        user.setRank(Integer.parseInt(userRank.getText()));
        tvUser.getItems().add(user);
        username.clear();
        password.clear();
        email.clear();
        userRank.clear();

        LogicController.addUser(user);
    }
    // Delete company method
    public static void deleteUser() {
        ObservableList<User> userSelected, allUsers;
        allUsers = tvUser.getItems();
        userSelected = tvUser.getSelectionModel().getSelectedItems();
        for (User user : userSelected) {
            System.out.println("skrrt");
            LogicController.deleteUser(user);
        }

        userSelected.forEach(allUsers::remove);
    }

    // The button 'Indregistrede børn' has been pressed in the menu.
    public static void userTableviewStart() {

       /* TableColumn<User, String> IDCol = new TableColumn<>("ID");
        IDCol.setMinWidth(120);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID")); */

        TableColumn<User, String> usernameCol = new TableColumn<>("Username");
        usernameCol.setMinWidth(120);
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(120);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<User, String> startDateCol = new TableColumn<>("Start time");
        startDateCol.setMinWidth(135);
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<User, String> totalRevenueCol = new TableColumn<>("Start time");
        startDateCol.setMinWidth(135);
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<User, String> userRankCol = new TableColumn<>("User rank");
        userRankCol.setMinWidth(120);
        userRankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));


        // GridPane for the whole adding and deleting employee area
        GridPane gp3 = new GridPane();

        // VBoxes for TextFields
        VBox addUserBox = new VBox();
        addUserBox.setSpacing(10);
        addUserBox.setPadding(new Insets(1, 10, 100, 10));
        gp3.add(addUserBox, 0, 0);


        VBox addUserbox2 = new VBox();
        addUserbox2.setSpacing(10);
        //gp3.add(addUserbox2, 1, 0);

        // Knappen Tilføj Bruger under fanen "Brugere"
        Button addUserBtn = new Button("Tilføj Bruger");
        addUserBtn.setId("addEmployeeButton");

        /*
            Alertbox der meddeler admin at brugeren er blevet oprettet
         */
        addUserBtn.setOnAction(successBox ->{
            addUser();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Citybook");
            alert.setHeaderText("Bekræftelse");
            alert.setContentText("Brugeren er nu blevet oprettet.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

            }
        });
        // Knappen Slet Bruger under fanen "Brugere"
        Button deleteUserBtn = new Button("Slet Bruger");
        deleteUserBtn.setId("deleteEmployeeButton");

        /*
           Alertbox til at sikre os at admin gerne vil slette en bruger.
         */
        deleteUserBtn.setOnAction(alertBox ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Citybook");
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Er du sikker på at du vil slette denne bruger?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    deleteUser();
                }
        });

        // TextFields for adding a child
       /* ID = new TextField();
        ID.setPromptText("ID");
        ID.setMaxWidth(100); */

        username = new TextField();
        username.setPromptText("Username");
        username.setMaxWidth(100);

        password = new TextField();
        password.setPromptText("Password");
        password.setMaxWidth(100);

        email = new TextField();
        email.setPromptText("Email");
        email.setMaxWidth(100);

        userRank = new TextField();
        userRank.setPromptText("User rank");
        userRank.setMaxWidth(100);


        tvUser.setEditable(true);


        // adding the TextFields to VBox 1 and VBox 2
        addUserBox.getChildren().addAll(username, password, email, userRank,
                addUserBtn, deleteUserBtn);
        Label white = new Label();
        white.setId("whiteCompany");
        white.getStylesheets().addAll("gui/assets/login.css");

        addUserbox2.getChildren().addAll(white);

        // Setting the values stores in the getEmployees method to the tableview.
        tvUser.setItems(getUser());
        tvUser.setId("tvAktivitet");
        tvUser.getStylesheets().addAll("gui/assets/login.css");

        tvUser.getColumns().addAll(usernameCol, emailCol, startDateCol, userRankCol);
        hboxUser.setId("hboxAktivitet");
        hboxUser.getStylesheets().addAll("gui/assets/login.css");
        hboxUser.getChildren().addAll(addUserbox2, tvUser, gp3);

    }

}

