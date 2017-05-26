package gui;/**
 * Created by jarl on 26/05/2017.
 */

import backend.LogicController;
import entities.Company;
import entities.ContactPerson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.spec.ECField;
import java.util.Optional;

import static gui.Tableviews.methods.CompanyMethod.*;

public class ShowMoreInformationCompany extends Application {

    static Stage showMoreInformationStage = new Stage();
    static TextField contactPerson, createdBy, revenue;
    static TextArea comments;

    @Override
    public void start(Stage primaryStage) {

    }

    public static void showMoreInformationCompanyWindow(Company company) {
        GridPane showMoreGridPane = new GridPane();
        showMoreGridPane.setHgap(10);
        showMoreGridPane.setVgap(10);
        showMoreGridPane.setPadding(new Insets(25, 50, 25,50));

        showMoreGridPane.add(new Label("Virksomheder"),1,0);
        showMoreGridPane.add(new Label("CVR-nummer"),0,1);
        TextField cvrNumber = new TextField(company.getCvrNumber());
        cvrNumber.setDisable(true);
        cvrNumber.setPromptText("CVR-nummer");
        cvrNumber.setMaxWidth(150);
        showMoreGridPane.add(cvrNumber, 1, 1);

        showMoreGridPane.add(new Label("Navn"),0,2);
        TextField name = new TextField(company.getName());
        name.setPromptText("Navn");
        name.setMaxWidth(150);
        showMoreGridPane.add(name, 1, 2);

        showMoreGridPane.add(new Label("Adresse"),0,3);
        TextField address = new TextField(company.getAddress());
        address.setPromptText("Adresse");
        address.setMaxWidth(150);
        showMoreGridPane.add(address, 1, 3);

        showMoreGridPane.add(new Label("Email"),0,4);
        TextField email = new TextField(company.getEmail());
        email.setPromptText("Email");
        email.setMaxWidth(150);
        showMoreGridPane.add(email, 1, 4);

        showMoreGridPane.add(new Label("Post nr."),0,5);
        TextField zipCode = new TextField(company.getZipCode());
        zipCode.setPromptText("Postnummer");
        zipCode.setMaxWidth(150);
        showMoreGridPane.add(zipCode, 1, 5);

        showMoreGridPane.add(new Label("Tlf. nummer"),0,6);
        TextField phoneNumber = new TextField(company.getPhoneNumber());
        phoneNumber.setPromptText("Telefon nummer");
        phoneNumber.setMaxWidth(150);
        showMoreGridPane.add(phoneNumber, 1, 6);

        showMoreGridPane.add(new Label("Omsætning"),0,7);
        revenue = new TextField("" + company.getRevenue());
        revenue.setPromptText("Omsætning");
        revenue.setMaxWidth(150);
        showMoreGridPane.add(revenue, 1, 7);

        showMoreGridPane.add(new Label("Oprettet af"),0,8);
        createdBy = new TextField(company.getCreatedBy().getUsername());
        createdBy.setDisable(true);
        createdBy.setPromptText("Oprettet af");
        createdBy.setMaxWidth(150);
        showMoreGridPane.add(createdBy, 1, 8);

        showMoreGridPane.add(new Label("Kommentar"),1,9);
        comments = new TextArea(company.getComments());
        comments.setPromptText("Kommentar");
        comments.setMaxWidth(250);
        showMoreGridPane.add(comments, 1, 10);

        showMoreGridPane.add(new Label("Kontaktperson"),3,0);

        showMoreGridPane.add(new Label("Navn"),2,1);
        TextField contactPersonName = new TextField(company.getContactPerson().getName());
        contactPersonName.setPromptText("Navn");
        contactPersonName.setMaxWidth(150);
        showMoreGridPane.add(contactPersonName, 3, 1);

        showMoreGridPane.add(new Label("Email"),2,2);
        TextField contactPersonEmail = new TextField(company.getContactPerson().getEmail());
        contactPersonEmail.setPromptText("Email");
        contactPersonEmail.setMaxWidth(150);
        showMoreGridPane.add(contactPersonEmail, 3, 2);

        showMoreGridPane.add(new Label("Tlf. Nummer"),2,3);
        TextField contactPersonPhone = new TextField(company.getContactPerson().getPhone());
        contactPersonPhone.setPromptText("Tlf. Nummer");
        contactPersonPhone.setMaxWidth(150);
        showMoreGridPane.add(contactPersonPhone, 3, 3);


        Button updateShowMoreInformationCompaniesWindows = new Button("Gem ændringer");
        updateShowMoreInformationCompaniesWindows.setId("saveEdits");
        showMoreGridPane.add(updateShowMoreInformationCompaniesWindows,1,12);
        updateShowMoreInformationCompaniesWindows.setOnAction(event -> {

            ContactPerson contactPerson = new ContactPerson(contactPersonName.getText(), contactPersonEmail.getText(), contactPersonPhone.getText());
            Company newCompany = new Company(cvrNumber.getText(), name.getText(), address.getText(), zipCode.getText(), email.getText(), phoneNumber.getText(), Double.parseDouble(revenue.getText()), comments.getText(), contactPerson);
            LogicController.updateCompanies(newCompany);
            tvCompany.setItems(FXCollections.observableArrayList(LogicController.getCompanies()));

        });

        showMoreGridPane.getStylesheets().addAll("gui/assets/login.css");
        Scene showMoreInformationScene = new Scene(showMoreGridPane);
        showMoreInformationStage.centerOnScreen();
        showMoreInformationStage.setScene(showMoreInformationScene);
        showMoreInformationStage.show();

    }

    public static void showMoreButtonClicked(Company company)  {
                try {
                    showMoreInformationCompanyWindow(company);
                    showMoreInformationStage.setX(200);
                    showMoreInformationStage.setY(200);
                    showMoreInformationStage.setResizable(false);
                } catch (NullPointerException e) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Citybook");
                        alert.setHeaderText("ADVARSEL");
                        alert.setContentText("Du skal vælge et firma");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                        }
        }
    }
}