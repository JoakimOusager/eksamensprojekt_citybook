package gui.Tableviews.methods;

import gui.Tableviews.objects.Aktivitet;
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
public class AktivitetMethod {

    public static HBox hboxAktivitet = new HBox();


    public static TableView<Aktivitet> tvAktivitet = new TableView<>();
    public static TextField comment,virksomhed, contact, date;

    // Get all the Users
    public static ObservableList<Aktivitet> getAktivitet() {
        ObservableList<Aktivitet> aktivitet = FXCollections.observableArrayList();
        aktivitet.add(new Aktivitet("Daniel", "Englandsvej", "2300", "2109"));
        aktivitet.add(new Aktivitet("Jarl", "Eriksen", "Blå", "Sanne Eriksen"));
        aktivitet.add(new Aktivitet("Jarl", "Eriksen", "Blå", "Sanne Eriksen"));
        aktivitet.add(new Aktivitet("Jarl", "Eriksen", "Blå", "Sanne Eriksen"));
        return aktivitet;
    }

    // Add children method
    public static void addChildrenButtonClicked() {
        Aktivitet aktivitet = new Aktivitet();
        aktivitet.setComment(comment.getText());
        aktivitet.setVirksomhed(virksomhed.getText());
        aktivitet.setContact(contact.getText());
        aktivitet.setDate(date.getText());
        tvAktivitet.getItems().add(aktivitet);
        comment.clear();
        virksomhed.clear();
        contact.clear();
        date.clear();
    }
    // Delete company method
    public static void deleteChildrenButtonClicked() {
        ObservableList<Aktivitet> aktivitetSelected,allAktivitet;
        allAktivitet = tvAktivitet.getItems();
        aktivitetSelected = tvAktivitet.getSelectionModel().getSelectedItems();

        aktivitetSelected.forEach(allAktivitet::remove);
    }
    // The button 'Indregistrede børn' has been pressed in the menu.
    public static void childrenPressed() {

        TableColumn<Aktivitet, String> commentCol = new TableColumn<>("Kommentar");
        commentCol.setMinWidth(180);
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));

        TableColumn<Aktivitet, String> virksomhedCol = new TableColumn<>("Virksomhed");
        virksomhedCol.setMinWidth(180);
        virksomhedCol.setCellValueFactory(new PropertyValueFactory<>("virksomhed"));

        TableColumn<Aktivitet, String> contactCol = new TableColumn<>("Kontakt");
        contactCol.setMinWidth(180);
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<Aktivitet, String> dateCol = new TableColumn<>("Dato");
        dateCol.setMinWidth(180);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));


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
        addAktivitetBtn.setOnAction(e2 -> addChildrenButtonClicked());

        Button deleteAktivitetBtn = new Button("Slet aktivitet");
        deleteAktivitetBtn.setId("deleteEmployeeButton");
        deleteAktivitetBtn.setOnAction(e2 -> deleteChildrenButtonClicked());

        // TextFields for adding a child
        comment = new TextField();
        comment.setPromptText("Kommentar");
        comment.setMaxWidth(100);

        virksomhed = new TextField();
        virksomhed.setPromptText("Virksomhed");
        virksomhed.setMaxWidth(100);

        contact = new TextField();
        contact.setPromptText("Kontakt");
        contact.setMaxWidth(100);

        date = new TextField();
        date.setPromptText("Dato");
        date.setMaxWidth(100);

          tvAktivitet.setEditable(true);


        // adding the TextFields to VBox 1 and VBox 2
        addAktivitetBox.getChildren().addAll(comment, virksomhed, contact, date, addAktivitetBtn, deleteAktivitetBtn);
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


