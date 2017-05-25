package gui.Tableviews.methods;

import entities.Activity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
/**
 * Created by Daniel on 17-05-2017.
 */

/*
public class ActivityMethod {

    public static HBox hboxAktivitet = new HBox();


    public static TableView<Activity> tvAktivitet = new TableView<>();
    public static TextField comment, company, contact, time;

    // Get all the Users
    public static ObservableList<Activity> getAktivitet() {
        ObservableList<Activity> aktivitet = FXCollections.observableArrayList();
        aktivitet.add(new Activity("Daniel", "Englandsvej", "2300", "2109"));
        aktivitet.add(new Activity("Jarl", "Eriksen", "Blå", "Sanne Eriksen"));
        aktivitet.add(new Activity"Jarl", "Eriksen", "Blå", "Sanne Eriksen"));
        aktivitet.add(new Activity("Jarl", "Eriksen", "Blå", "Sanne Eriksen"));



        return aktivitet;
    }

    // Add company method
    public static void addCompany() {
        Activity aktivitet = new Activity();
        aktivitet.setComments(comment.getText());
        aktivitet.setCompany(company.getText());
        aktivitet.setTime(time.getText());
        tvAktivitet.getItems().add(aktivitet);
        comment.clear();
        company.clear();
        contact.clear();
        time.clear();
    }
    // Delete company method
    public static void delete() {
        ObservableList<Activity> aktivitetSelected,allAktivitet;
        allAktivitet = tvAktivitet.getItems();
        aktivitetSelected = tvAktivitet.getSelectionModel().getSelectedItems();

        aktivitetSelected.forEach(allAktivitet::remove);
    }
    // The button 'Indregistrede børn' has been pressed in the menu.
    public static void companyTableviewStart() {

        TableColumn<Activity, String> commentCol = new TableColumn<>("Kommentar");
        commentCol.setMinWidth(180);
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));

        TableColumn<Activity, String> virksomhedCol = new TableColumn<>("Virksomhed");
        virksomhedCol.setMinWidth(180);
        virksomhedCol.setCellValueFactory(new PropertyValueFactory<>("company"));

        TableColumn<Aktivitet, String> contactCol = new TableColumn<>("Kontakt");
        contactCol.setMinWidth(180);
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<Activity, String> dateCol = new TableColumn<>("Dato");
        dateCol.setMinWidth(180);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("time"));


        // GridPane for the whole adding and deleting employee area
        GridPane gp3 = new GridPane();

        // VBoxes for TextFields
        VBox addAktivitetBox = new VBox();
        addAktivitetBox.setSpacing(10);
        addAktivitetBox.setPadding(new Insets(1, 10, 100, 10));
        gp3.add(addAktivitetBox, 0, 0);


        VBox addAktivitetBox2 = new VBox();
        addAktivitetBox2.setSpacing(10);
        //gp3.add(addAktivitetBox2, 1, 0);

        // Buttons for adding and deleting Companies
        Button addAktivitetBtn = new Button("Tilføj Aktivitet");
        addAktivitetBtn.setId("addEmployeeButton");
        addAktivitetBtn.setOnAction(e2 -> addCompany());

        Button deleteAktivitetBtn = new Button("Slet aktivitet");
        deleteAktivitetBtn.setId("deleteEmployeeButton");
        deleteAktivitetBtn.setOnAction(e2 -> delete());

        // TextFields for adding a child
        comment = new TextField();
        comment.setPromptText("Kommentar");
        comment.setMaxWidth(100);

        company = new TextField();
        company.setPromptText("Virksomhed");
        company.setMaxWidth(100);

        contact = new TextField();
        contact.setPromptText("Kontakt");
        contact.setMaxWidth(100);

        time = new TextField();
        time.setPromptText("Dato");
        time.setMaxWidth(100);

          tvAktivitet.setEditable(true);


        // adding the TextFields to VBox 1 and VBox 2
        addAktivitetBox.getChildren().addAll(comment, company, contact, time, addAktivitetBtn, deleteAktivitetBtn);
        Label white = new Label();
        white.setId("whiteCompany");
        white.getStylesheets().addAll("gui/assets/login.css");

        addAktivitetBox2.getChildren().addAll(white);

        // Setting the values stores in the getEmployees method to the tableview.
        tvAktivitet.setItems(getAktivitet());
        tvAktivitet.setId("tvAktivitet");
        tvAktivitet.getStylesheets().addAll("gui/assets/login.css");

        tvAktivitet.getColumns().addAll(commentCol, virksomhedCol, contactCol, dateCol);
        hboxAktivitet.setId("hboxAktivitet");
        hboxAktivitet.getStylesheets().addAll("gui/assets/login.css");
        hboxAktivitet.getChildren().addAll(addAktivitetBox2, tvAktivitet, gp3);

    }

}

*/


