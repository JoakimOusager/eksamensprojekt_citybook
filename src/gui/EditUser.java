package gui;

import application.LogicController;
import application.User;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static gui.UserTableView.tvUser;

import java.util.Optional;

public class EditUser {

	//////////////////////////////////////////////////// Jarl ////////////////////////////////////////////////

	static Stage editUser                       = new Stage();

	public static void editUserWindow(User user) {
		GridPane editUserGridPane               = new GridPane();
		editUserGridPane.setHgap(10);
		editUserGridPane.setVgap(10);
		editUserGridPane.setPadding(              new Insets(25, 50, 25,50));

		editUserGridPane.add(                     new Label("Brugere"),1,0);
		editUserGridPane.add(                     new Label("Brugernavn"),0,1);
		TextField usernameTF                    = new TextField(user.getUsername());
		usernameTF.setDisable(true);
		usernameTF.setPromptText("Brugernavn");
		usernameTF.setMaxWidth(150);
		editUserGridPane.add(usernameTF, 1, 1);

		editUserGridPane.add(                    new Label("Email"),0,2);
		TextField userEmail                    = new TextField(user.getEmail());
		userEmail.setPromptText("Navn");
		userEmail.setMaxWidth(150);
		editUserGridPane.add(userEmail, 1, 2);

		editUserGridPane.add(                     new Label("Kodeord"),0,3);
		TextField userPassword                  = new TextField(user.getPassword());
		userPassword.setPromptText("Kodeord");
		userPassword.setMaxWidth(150);
		editUserGridPane.add(userPassword, 1, 3);


		editUserGridPane.add(                     new Label("Rang"),0,4);
		TextField userRank                      = new TextField("" + user.getRank());
		userRank.setPromptText("Adresse");
		userRank.setMaxWidth(150);
		editUserGridPane.add(userRank, 1, 4);

		Button editUserBtn = new Button("Gem ændringer");
		editUserBtn.setId("saveEdits");
		editUserGridPane.add(editUserBtn,1,5);


        /*
            Dette er vores lambda til at opdatere alle fields når man trykker på 'Gem ændringer'.
            I princippet henter vi alle værdier fra vores TextFields og opretter et nyt User objekt og smider det ind i databasen.
        */
		editUserBtn.setOnAction(event -> {

			User newUser                         = new User(usernameTF.getText(), userPassword.getText(), userEmail.getText(), Integer.parseInt(userRank.getText()));
			LogicController.updateUser(newUser);

            /*
             Til at opdatere TableView når man trykker på 'Gem ændringer' med de angivede værdier.
            */
			tvUser.setItems(FXCollections.observableArrayList(LogicController.getUsers()));
			editUser.close();

			Alert alert                          = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Citybook");
			alert.setHeaderText("Bekræftelse");
			alert.setContentText("Brugeren er nu blevet ændret.");

            /*
                Vinduet venter ikke på at brugeren trykker på noget
                før at vores lambda bliver kørt. Vi bruger kun AlertBox
                her for at vise at brugeren er blevet ændret.
            */
			Optional<ButtonType> result              = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
			}

		});

		// Tilføjer CSS samt opretter en ny scene.
		editUserGridPane.getStylesheets().addAll("gui/assets/login.css");
		Scene showMoreScene               = new Scene(editUserGridPane);
		editUser.centerOnScreen();
		editUser.setScene(showMoreScene);
		editUser.show();

	}

	/*
		Denne metode viser vores pop-up vindue når man trykker på 'Vis mere'
	*/
	public static void showMoreUserButtonClicked(User user)  {
		try {
			editUserWindow(user);
			editUser.setX(200);
			editUser.setY(200);
			editUser.setResizable(false);
		} catch (NullPointerException e) {
			// Viser en Fejl meddelelse hvis man ikke har en bruger valgt i TableView
			Alert alert       = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Citybook");
			alert.setHeaderText("ADVARSEL");
			alert.setContentText("Du skal vælge en bruger");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			}
		}
	}
}
