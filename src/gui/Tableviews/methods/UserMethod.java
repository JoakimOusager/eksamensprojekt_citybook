package gui.Tableviews.methods;

import gui.Tableviews.objects.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * Created by Daniel on 17-05-2017.
 */
public class UserMethod {

    public static HBox hboxUser = new HBox();


    public static TableView<User> tvUser = new TableView<>();
    public static TextField username, password ,email, startDate, userRank;

    // Get all the Users
    public static ObservableList<User> getUser() {
        ObservableList<User> user = FXCollections.observableArrayList();
        user.add(new User("37144266", "Daniel", "Englandsvej", "2300", 1));
        user.add(new User("Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));
        user.add(new User("Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));
        user.add(new User("Jarl", "Eriksen", "Blå", "Sanne Eriksen", 1));
        return user;
    }

    // Add children method
    public static void addChildrenButtonClicked() {
        User user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setEmail(email.getText());
        user.setStartDate(startDate.getText());
        user.setUserRank(Integer.parseInt(userRank.getText()));
        tvUser.getItems().add(user);
        username.clear();
        password.clear();
        email.clear();
        startDate.clear();
        userRank.clear();
    }
    // Delete company method
    public static void deleteChildrenButtonClicked() {
        ObservableList<User> userSelected, allUsers;
        allUsers = tvUser.getItems();
        userSelected = tvUser.getSelectionModel().getSelectedItems();

        userSelected.forEach(allUsers::remove);
    }
    // The button 'Indregistrede børn' has been pressed in the menu.
    public static void childrenPressed() {

        TableColumn<User, String> usernameCol = new TableColumn<>("Username");
        usernameCol.setMinWidth(120);
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> passwordCol = new TableColumn<>("Password");
        passwordCol.setMinWidth(120);
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(120);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<User, String> startDateCol = new TableColumn<>("Start date");
        startDateCol.setMinWidth(120);
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<User, String> userRankCol = new TableColumn<>("User rank");
        userRankCol.setMinWidth(120);
        userRankCol.setCellValueFactory(new PropertyValueFactory<>("userRank"));


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

        // Buttons for adding and deleting Companies
        Button addUserBtn = new Button("Tilføj firma");
        addUserBtn.setId("addEmployeeButton");
        addUserBtn.setOnAction(e2 -> addChildrenButtonClicked());

        Button deleteUserBtn = new Button("Slet firma");
        deleteUserBtn.setId("deleteEmployeeButton");
        deleteUserBtn.setOnAction(e2 -> deleteChildrenButtonClicked());

        // TextFields for adding a child
        username = new TextField();
        username.setPromptText("Username");
        username.setMaxWidth(100);

        password = new TextField();
        password.setPromptText("Password");
        password.setMaxWidth(100);

        email = new TextField();
        email.setPromptText("Email");
        email.setMaxWidth(100);

        startDate = new TextField();
        startDate.setPromptText("Start dato");
        startDate.setMaxWidth(100);

        userRank = new TextField();
        userRank.setPromptText("User rank");
        userRank.setMaxWidth(100);


        tvUser.setEditable(true);


        // adding the TextFields to VBox 1 and VBox 2
        addUserBox.getChildren().addAll(username, password, email, startDate, userRank,
                addUserBtn, deleteUserBtn);
        Label white = new Label();
        white.setId("whiteCompany");
        white.getStylesheets().addAll("gui/assets/login.css");

        addUserbox2.getChildren().addAll(white);

        // Setting the values stores in the getEmployees method to the tableview.
        tvUser.setItems(getUser());
        tvUser.setId("tvUser");
        tvUser.getStylesheets().addAll("gui/assets/login.css");

        tvUser.getColumns().addAll(usernameCol, passwordCol, emailCol, startDateCol, userRankCol);
        hboxUser.setId("hboxUser");
        hboxUser.getStylesheets().addAll("gui/assets/login.css");
        hboxUser.getChildren().addAll(addUserbox2, tvUser, gp3);

    }

}

