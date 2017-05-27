package gui;/**
 * Created by jarl on 26/05/2017.
 */

import application.Company;
import application.ContactPerson;
import application.LogicController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

import static gui.CompanyTableView.tvCompany;

//////////////////////////////////////////Joakim og Jarl/////////////////////////////////////

public class ShowMoreCompany extends Application {

    static Stage showMoreStage            = new Stage();
    static TextField contactPerson, createdBy, revenue;
    static TextArea comments;

    @Override
    public void start(Stage primaryStage) {

    }

    public static void showMoreCompanyWindow(Company company) {
        GridPane showMoreGridPane         = new GridPane();
        showMoreGridPane.setHgap(10);
        showMoreGridPane.setVgap(10);
        showMoreGridPane.setPadding(        new Insets(25, 50, 25,50));

        showMoreGridPane.add(               new Label("Virksomheder"),1,0);
        showMoreGridPane.add(               new Label("CVR-nummer"),0,1);
        TextField cvrNumber               = new TextField(company.getCvrNumber());
        cvrNumber.setDisable(true);
        cvrNumber.setPromptText("CVR-nummer");
        cvrNumber.setMaxWidth(150);
        showMoreGridPane.add(cvrNumber, 1, 1);

        showMoreGridPane.add(               new Label("Navn"),0,2);
        TextField name                    = new TextField(company.getName());
        name.setPromptText("Navn");
        name.setMaxWidth(150);
        showMoreGridPane.add(name, 1, 2);

        showMoreGridPane.add(               new Label("Adresse"),0,3);
        TextField address                 = new TextField(company.getAddress());
        address.setPromptText("Adresse");
        address.setMaxWidth(150);
        showMoreGridPane.add(address, 1, 3);

        showMoreGridPane.add(               new Label("Email"),0,4);
        TextField email                   = new TextField(company.getEmail());
        email.setPromptText("Email");
        email.setMaxWidth(150);
        showMoreGridPane.add(email, 1, 4);

        showMoreGridPane.add(               new Label("Post nr."),0,5);
        TextField zipCode                 = new TextField(company.getZipCode());
        zipCode.setPromptText("Postnummer");
        zipCode.setMaxWidth(150);
        showMoreGridPane.add(zipCode, 1, 5);

        showMoreGridPane.add(             new Label("Tlf. nummer"),0,6);
        TextField phoneNumber           = new TextField(company.getPhoneNumber());
        phoneNumber.setPromptText("Telefon nummer");
        phoneNumber.setMaxWidth(150);
        showMoreGridPane.add(phoneNumber, 1, 6);

        showMoreGridPane.add(               new Label("Omsætning"),0,7);
        revenue                           = new TextField("" + company.getRevenue());
        revenue.setPromptText("Omsætning");
        revenue.setMaxWidth(150);
        showMoreGridPane.add(revenue, 1, 7);

        showMoreGridPane.add(               new Label("Oprettet af"),0,8);
        createdBy                         = new TextField(company.getCreatedBy().getUsername());
        createdBy.setDisable(true);
        createdBy.setPromptText("Oprettet af");
        createdBy.setMaxWidth(150);
        showMoreGridPane.add(createdBy, 1, 8);

        showMoreGridPane.add(               new Label("Kommentar"),1,9);
        comments                          = new TextArea(company.getComments());
        comments.setPromptText("Kommentar");
        comments.setMaxWidth(250);
        showMoreGridPane.add(comments, 1, 10);

        showMoreGridPane.add(               new Label("Kontaktperson"),3,0);

        showMoreGridPane.add(               new Label("Navn"),2,1);
        TextField contactPersonName       = new TextField(company.getContactPerson().getName());
        contactPersonName.setPromptText("Navn");
        contactPersonName.setMaxWidth(150);
        showMoreGridPane.add(contactPersonName, 3, 1);

        showMoreGridPane.add(               new Label("Email"),2,2);
        TextField contactPersonEmail      = new TextField(company.getContactPerson().getEmail());
        contactPersonEmail.setPromptText("Email");
        contactPersonEmail.setMaxWidth(150);
        showMoreGridPane.add(contactPersonEmail, 3, 2);

        showMoreGridPane.add(               new Label("Tlf. Nummer"),2,3);
        TextField contactPersonPhone      = new TextField(company.getContactPerson().getPhone());
        contactPersonPhone.setPromptText("Tlf. Nummer");
        contactPersonPhone.setMaxWidth(150);
        showMoreGridPane.add(contactPersonPhone, 3, 3);


        Button updateShowMoreCompaniesBtn = new Button("Gem ændringer");
        updateShowMoreCompaniesBtn.setId("saveEdits");
        showMoreGridPane.add(updateShowMoreCompaniesBtn,1,12);

        /*
            Dette er vores lambda til at opdatere alle fields når man trykker på 'Gem ændringer'.
            I princippet henter vi alle værdier fra vores TextFields og opretter et nyt Company objekt og ContactPerson
            objekt og smider det ind i databasen.
        */
        updateShowMoreCompaniesBtn.setOnAction(event -> {

            ContactPerson contactPerson   = new ContactPerson(contactPersonName.getText(), contactPersonEmail.getText(), contactPersonPhone.getText());
            Company newCompany            = new Company(cvrNumber.getText(), name.getText(), address.getText(), zipCode.getText(), email.getText(), phoneNumber.getText(), Double.parseDouble(revenue.getText()), comments.getText(), contactPerson);
            LogicController.updateCompanies(newCompany);

            /*
             Til at opdatere TableView når man trykker på 'Gem ændringer' med de angivede værdier.
            */
            tvCompany.setItems(FXCollections.observableArrayList(LogicController.getCompanies()));
            showMoreStage.close();

            Alert alert                              = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Citybook");
            alert.setHeaderText("Bekræftelse");
            alert.setContentText("Virksomheden er nu blevet ændret.");

            /*
                Vinduet venter ikke på at brugeren trykker på noget
                før at vores lambda bliver kørt. Vi bruger kun AlertBox
                her for at vise at virksomheden er blevet ændret.
            */
            Optional<ButtonType> result              = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
            }

        });

        // Tilføjer CSS samt opretter en ny scene.
        showMoreGridPane.getStylesheets().addAll("gui/assets/login.css");
        Scene showMoreScene               = new Scene(showMoreGridPane);
        showMoreStage.centerOnScreen();
        showMoreStage.setScene(showMoreScene);
        showMoreStage.show();

    }

    /*
        Denne metode viser vores pop-up vindue når man trykker på 'Vis mere'
    */
    public static void showMoreButtonClicked(Company company)  {
                try {
                    showMoreCompanyWindow(company);
                    showMoreStage.setX(200);
                    showMoreStage.setY(200);
                    showMoreStage.setResizable(false);
                } catch (NullPointerException e) {
                        // Viser en Fejl meddelelse hvis man ikke har en virksomhed i TableView
                        Alert alert       = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Citybook");
                        alert.setHeaderText("ADVARSEL");
                        alert.setContentText("Du skal vælge et firma");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                        }
        }
    }
}
