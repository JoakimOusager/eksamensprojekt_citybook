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

/**
 * Created by Daniel on 17-05-2017.
 */
public class CompanyTableView {

    public static HBox hboxCompany                         = new HBox();

        public static TableView<Company> tvCompany         = new TableView<>();
        public static TextField cvrNumber, name, address, email, zipCode, phoneNumber, contactPersonName, contactPersonEmail,
        contactPersonPhone;

        public static Button showMoreInformationAboutCompanyButton;

        // Get all the children
        public static ObservableList<Company> getCompany() {

            ObservableList<Company> company = FXCollections.observableArrayList(LogicController.getCompanies());

            System.out.println(company);
            return company;
        }

        /*
               Dette er vores metode til at tilføje en virksomhed.
        */
        public static void addCompany() {
            // Vi laver et Company objekt.
            Company company                                 = new Company();

            // Vi laver et ContactPerson objekt der indeholder de værdier som er i vores TextFields.
            ContactPerson contactPerson                     = new ContactPerson(contactPersonName.getText(), contactPersonEmail.getText(), contactPersonPhone.getText());

            // Vi smider vores ContactPerson objekt ind i Company objektet.
            company.setContactPerson(contactPerson);
            company.setName(name.getText());
            company.setCvrNumber(cvrNumber.getText());
            company.setAddress(address.getText());
            company.setEmail(email.getText());
            company.setZipCode(zipCode.getText());
            company.setPhoneNumber(phoneNumber.getText());
            company.setCreatedBy(HomeGUI.loggedInUser);

            tvCompany.getItems().add(company);
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

            LogicController.addCompany(company);
        }
        /*
            Dette er vores metode til at slette en virksomhed.
        */
        public static void deleteCompany() {
            ObservableList<Company> companySelected, allCompanies;
            allCompanies = tvCompany.getItems();
            companySelected = tvCompany.getSelectionModel().getSelectedItems();
            for (Company com : companySelected) {
                LogicController.deleteCompany(com);
            }

            companySelected.forEach(allCompanies::remove);

        }

        /*
            Knappen 'Virksomheder' generer dette TableView.
        */
        public static void companyTableviewStart() {

            TableColumn<Company, String> nameCompanyCol    = new TableColumn<>("Navn");
            nameCompanyCol.setMinWidth(120);
            nameCompanyCol.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Company, String> phoneCompanyCol   = new TableColumn<>("Telefon");
            phoneCompanyCol.setMinWidth(120);
            phoneCompanyCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

            TableColumn<Company, String> emailCol          = new TableColumn<>("Email");
            emailCol.setMinWidth(120);
            emailCol.setCellValueFactory(                    new PropertyValueFactory<>("email"));

            TableColumn<Company, String> companyRevenueCol = new TableColumn<>("Omsætning");
            companyRevenueCol.setMinWidth(120);
            companyRevenueCol.setCellValueFactory(         new PropertyValueFactory<>("revenue"));

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

            showMoreInformationAboutCompanyButton          = new Button("Vis mere");
            showMoreInformationAboutCompanyButton.setId("showMoreInformationAboutCompanyButton");
            showMoreInformationAboutCompanyButton.setOnAction(e-> {
                ObservableList<Company> selectedCompany    = tvCompany.getSelectionModel().getSelectedItems();
                showMoreButtonClicked(selectedCompany.get(0));
            });

            Label companyLbl                               = new Label("Virksomhed");
            Label contactPersonLbl                         = new Label("Kontaktperson");
            // TextFields for adding a child
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

            // adding the TextFields to VBox 1 and VBox 2
            addCompanyBox.getChildren().addAll(companyLbl, cvrNumber, name, address, email, zipCode, phoneNumber,
                    addCompanyBtn, deleteCompanyBtn, showMoreInformationAboutCompanyButton);
            Label white                                    = new Label();
            white.setId("whiteCompany");
            white.getStylesheets().addAll("gui/assets/login.css");

            addCompanyBox2.getChildren().addAll(white);

            addContactPersonBox.getChildren().addAll(contactPersonLbl, contactPersonName, contactPersonEmail, contactPersonPhone);

            // Setting the values stores in the getEmployees method to the tableview.
            tvCompany.setItems(getCompany());
            tvCompany.setId("tvAktivitet");
            tvCompany.getStylesheets().addAll("gui/assets/login.css");

            tvCompany.getColumns().addAll(nameCompanyCol, phoneCompanyCol, emailCol, companyRevenueCol);
            hboxCompany.setId("hboxAktivitet");
            hboxCompany.getStylesheets().addAll("gui/assets/login.css");
            hboxCompany.getChildren().addAll(addCompanyBox2,tvCompany, gp3);

        }

    }

