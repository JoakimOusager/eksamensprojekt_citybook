package gui;

import application.LogicController;
import application.Company;
import application.ContactPerson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

import static gui.ShowMoreCompany.showMoreButtonClicked;

//////////////////////////////////////////////////// Daniel og Jarl //////////////////////////////////////

public class CompanyTableView {

    public static HBox hboxCompany                         = new HBox();

        public static TableView<Company> tvCompany         = new TableView<>();
        public static TextField cvrNumber, name, address, email, zipCode, phoneNumber, contactPersonName, contactPersonEmail,
        contactPersonPhone;

        public static Button showMoreInformationAboutCompanyButton;

        // Returnerer alle virksomheder.
        public static ObservableList<Company> getCompany() {
            ObservableList<Company> company = FXCollections.observableArrayList(LogicController.getCompanies());
            return company;
        }


        // Dette er vores metode til at tilføje en virksomhed.
        public static void addCompany() {
            // Vi laver et nyt Company objekt.
            Company company                                 = new Company();

            // Vi laver et ContactPerson objekt der indeholder de værdier som er i vores TextFields.
            ContactPerson contactPerson                     = new ContactPerson(contactPersonName.getText(),
                                                contactPersonEmail.getText(), contactPersonPhone.getText());

            // Vi smider vores ContactPerson objekt ind i Company objektet.
            company.setContactPerson(contactPerson);

            // Vi henter data fra TextFields og sætter deres værdier ind i vores objekt vha. Getters & Setters
            company.setName(name.getText());
            company.setCvrNumber(cvrNumber.getText());
            company.setAddress(address.getText());
            company.setEmail(email.getText());
            company.setZipCode(zipCode.getText());
            company.setPhoneNumber(phoneNumber.getText());
            company.setCreatedBy(HomeGUI.loggedInUser);

            // Vi tilføjer alt data fra  TableView til vores objekt
            tvCompany.getItems().add(company);

            // Herefter bruger vi Clear() metoden til at nulstille vores TextFields.
            contactPersonName.clear();
            contactPersonEmail.clear();
            contactPersonPhone.clear();
            cvrNumber.clear();
            name.clear();
            address.clear();
            email.clear();
            zipCode.clear();
            phoneNumber.clear();
            tvCompany.refresh();

            // Vi overfører objektet til LogicControllers addCompany() metode.
            LogicController.addCompany(company);
        }

            // Dette er vores metode til at slette en virksomhed.
        public static void deleteCompany() {
            // Vi laver en ObservableList der indeholder et Company objekt
            // der kommer til at indeholde hvilken virksomhed der er valgt.
            ObservableList<Company> companySelected, allCompanies;
            allCompanies = tvCompany.getItems();

            // getSelectionModel henter den værdi der er i det valgte row.
            // getSelectedItems returnere den valgte row med den værdi hentet fra getSelectionModel.
            // Dette bliver lagt ind i companySelected.
            companySelected = tvCompany.getSelectionModel().getSelectedItems();

            // Vi har et for-loop der finder den valgte bruger i vores objekt
            // for derefter at kalde på vores deleteCompany() metode i LogicController.
            for (Company com : companySelected) {
                LogicController.deleteCompany(com);
            }
            // Fjerner den valgte virksomhed.
            companySelected.forEach(allCompanies::remove);

        }

        /*
            Knappen 'Virksomheder' generer dette TableView.
        */
        public static void companyTableviewStart() {

            // Vi opretter de kolonner som bliver vist i vores TableView for brugere.
            // Kolonne for virksomhedsnavn
            TableColumn<Company, String> nameCompanyCol    = new TableColumn<>("Navn");
            nameCompanyCol.setMinWidth(160);
            nameCompanyCol.setCellValueFactory(new PropertyValueFactory<>("name"));

            // Kolonne for Virksomhedens telefon nummer
            TableColumn<Company, String> phoneCompanyCol   = new TableColumn<>("Telefon");
            phoneCompanyCol.setMinWidth(100);
            phoneCompanyCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

            // Kolonne for virksomhedens Email
            TableColumn<Company, String> emailCol          = new TableColumn<>("Email");
            emailCol.setMinWidth(160);
            emailCol.setCellValueFactory(                    new PropertyValueFactory<>("email"));

            // Kolonne for omsætning på virksomheden
            TableColumn<Company, String> companyRevenueCol = new TableColumn<>("Omsætning");
            companyRevenueCol.setMinWidth(120);
            companyRevenueCol.setCellValueFactory(         new PropertyValueFactory<>("revenue"));


//////////////////////////////////////// Jarl og Joakim //////////////////////////////////////////////////

            // GridPane for the whole adding and deleting employee area
            GridPane gp3                                   = new GridPane();

            // VBoxes for TextFields
            VBox addCompanyBox                             = new VBox();
            addCompanyBox.setSpacing(10);
            addCompanyBox.setPadding(                        new Insets(1, 10, 100, 10));
            gp3.add(addCompanyBox, 0, 0);

            VBox addContactPersonBox                       = new VBox();
            addContactPersonBox.setSpacing(10);
            addContactPersonBox.setPadding(                  new Insets(1, 10, 100, 10));
            gp3.add(addContactPersonBox,1,0);


            VBox addCompanyBox2                            = new VBox();
            addCompanyBox2.setSpacing(10);

            // Buttons for adding and deleting Companies
            Button addCompanyBtn                           = new Button("Tilføj firma");
            addCompanyBtn.setId("addEmployeeButton");

//////////////////////////////////////// Jarl //////////////////////////////////////////////////


             //  Denne setOnAction kalder på addCompany() metoden samt
             //  henter den nye data som er blevet smidt i databasen fra addCompany() metoden
             //  så TableView bliver opdateret. Derudover bliver der vist en bekræftelse på dette.

            addCompanyBtn.setOnAction(successBox ->{
                addCompany();
                tvCompany.setItems(FXCollections.observableArrayList(LogicController.getCompanies()));
                Alert alert                                = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Citybook");
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Firmaet er nu blevet oprettet.");

                Optional<ButtonType> result                = alert.showAndWait();
                if (result.get() == ButtonType.OK){

                }
            });


            Button deleteCompanyBtn                        = new Button("Slet firma");
            deleteCompanyBtn.setId("deleteEmployeeButton");

             //  Primært det samme som ovenover, her bliver deleteCompany() dog kaldt hvis
             //  brugeren vælger at trykke 'Ok' i vores AlertBox.
            deleteCompanyBtn.setOnAction(alertBox ->{
                Alert alert                                = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Citybook");
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Er du sikker på at du vil slette dette firma?");

                Optional<ButtonType> result                = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    deleteCompany();
                }
            });

//////////////////////////////////////// Jarl  & Joakim //////////////////////////////////////////////////
             //  Når man trykker på ShowMoreInformationAboutCompanyButton
             //  overfører den hvilken virksomhed man har valgt til metoden
             //  showMoreButtonClicked() fra ShowMoreCompany klassen

            showMoreInformationAboutCompanyButton          = new Button("Vis mere");
            showMoreInformationAboutCompanyButton.setId("showMoreInformationAboutCompanyButton");
            showMoreInformationAboutCompanyButton.setOnAction(e-> {
                ObservableList<Company> selectedCompany    = tvCompany.getSelectionModel().getSelectedItems();
                showMoreButtonClicked(selectedCompany.get(0));
            });

            Label companyLbl                               = new Label("Virksomhed");
            Label contactPersonLbl                         = new Label("Kontaktperson");


            cvrNumber                                      = new TextField();
            cvrNumber.setPromptText("CVR-nummer");
            cvrNumber.setMaxWidth(100);

            name                                           = new TextField();
            name.setPromptText("Navn");
            name.setMaxWidth(100);

            address                                        = new TextField();
            address.setPromptText("Adresse");
            address.setMaxWidth(100);

            email                                          = new TextField();
            email.setPromptText("Email");
            email.setMaxWidth(100);

            zipCode                                        = new TextField();
            zipCode.setPromptText("Post nummer");
            zipCode.setMaxWidth(100);

            phoneNumber                                    = new TextField();
            phoneNumber.setPromptText("Telefon nummer");
            phoneNumber.setMaxWidth(100);

            contactPersonName                              = new TextField();
            contactPersonName.setPromptText("Navn");
            contactPersonName.setMaxWidth(100);

            contactPersonEmail                             = new TextField();
            contactPersonEmail.setPromptText("Email");
            contactPersonEmail.setMaxWidth(100);

            contactPersonPhone                             = new TextField();
            contactPersonPhone.setPromptText("Tlf. nummer");
            contactPersonPhone.setMaxWidth(100);

            addCompanyBox.getChildren().addAll(companyLbl, cvrNumber, name, address, email, zipCode, phoneNumber,
                    addCompanyBtn, deleteCompanyBtn, showMoreInformationAboutCompanyButton);
            Label white                                    = new Label();
            white.setId("whiteCompany");
            white.getStylesheets().addAll("gui/assets/login.css");

            addCompanyBox2.getChildren().addAll(white);

            addContactPersonBox.getChildren().addAll(contactPersonLbl, contactPersonName, contactPersonEmail, contactPersonPhone);

            tvCompany.setItems(getCompany());
            tvCompany.setId("tvCompany");
            tvCompany.getStylesheets().addAll("gui/assets/login.css");

            tvCompany.getColumns().addAll(nameCompanyCol, phoneCompanyCol, emailCol, companyRevenueCol);
            hboxCompany.setId("hboxAktivitet");
            hboxCompany.getStylesheets().addAll("gui/assets/login.css");
            hboxCompany.getChildren().addAll(addCompanyBox2,tvCompany, gp3);

        }
    }

