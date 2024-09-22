package com.example.healthflow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class BillingAndInvoiceController {

    @FXML
    public DatePicker DpDD;

    @FXML
    public DatePicker DpInv;

    @FXML
    public TableColumn<?, ?> TcAmt;

    @FXML
    public TableColumn<?, ?> TcP;

    @FXML
    public TableColumn<?, ?> TcSr;

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public AnchorPane ankrDashboard2;

    @FXML
    public AnchorPane ankrMain;

    @FXML
    public AnchorPane ankrPersonalDetails;

    @FXML
    public AnchorPane ankrTitle;

    @FXML
    public Button btnAppointment;

    @FXML
    public Button btnBack;

    @FXML
    public Button btnBilling;

    @FXML
    public Button btnClearAll;

    @FXML
    public Button btnClinicalManagement;

    @FXML
    public Button btnHome;

    @FXML
    public Button btnPaid;

    @FXML
    public Button btnSave;

    @FXML
    public Button btnUser;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblClinicalManagement;

    @FXML
    public Label lblDOB;

    @FXML
    public Label lblDOB1;

    @FXML
    public Label lblDOB11;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblDoctorID;

    @FXML
    public Label lblDoctorID1;

    @FXML
    public Label lblGender;

    @FXML
    public Label lblGender1;

    @FXML
    public Label lblName;

    @FXML
    public Label lblPersonalDetails;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TextField txtfAD;

    @FXML
    public TextField txtfDD;

    @FXML
    public TextField txtfDOB;

    @FXML
    public TextField txtfFirstName;

    @FXML
    public TextField txtfGender;

    @FXML
    public TextField txtfGender1;

    @FXML
    public TextField txtfLastName;

    @FXML
    public VBox vbxDashboard;

    @FXML
    public VBox vbxUser;

        // Handler for Home button
        @FXML
       public void handleHomeButtonClick() throws IOException {
            switchScene("HomePage2.fxml");
        }

        // Handler for Appointment button
        @FXML
        public void handleAppointmentButtonClick() throws IOException {
            switchScene("Appointment.fxml");
        }

        // Handler for Billing button
//        @FXML
//        public void handleBillingButtonClick() throws IOException {
//            switchScene("BillingandInvoice.fxml");
//        }

        // Handler for Registration MenuItem selection
        @FXML
        public void handlePatientTabClick() throws IOException {
            switchScene("PatientRegistration.fxml");
        }

        @FXML
        public void handleDoctorTabClick() throws IOException {
            switchScene("DoctorRegistration.fxml");
        }

        @FXML
        public void handleStaffTabClick() throws IOException {
            switchScene("StaffRegistration.fxml");
        }

        @FXML
        public void handleClinicalManagementTabClick() throws IOException {
            switchScene("ClinicalManagement.fxml");

        }
//    @FXML
//    public void handleBackButtonClick() throws IOException {
//        // Load the homepage scene from FXML (assuming "HomePage2.fxml" is the homepage)
//        Parent homePageRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
//
//        // Get the current stage
//        Stage stage = (Stage) ankrMain.getScene().getWindow();
//
//        // Create a new scene with the homepage root node from the FXML file
//        Scene homePageScene = new Scene(homePageRoot);
//
//        // Set the homepage scene to the stage
//        stage.setScene(homePageScene);
//        stage.show();
//    }
@FXML
public void handleBackButtonClick() throws IOException {
    // Load the homepage scene from FXML (assuming "HomePage2.fxml" is the homepage)
    FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
    Parent homePageRoot = loader.load();

    // Get the controller for the homepage
    HomeController homePageController = loader.getController();

    // Call the refreshPage method to refresh the homepage data (this step is optional because the initialize method will do this)
    homePageController.refreshPage();

    // Get the current stage
    Stage stage = (Stage) ankrMain.getScene().getWindow();

    // Create a new scene with the homepage root node from the FXML file
    Scene homePageScene = new Scene(homePageRoot);

    // Set the homepage scene to the stage
    stage.setScene(homePageScene);
    stage.show();
}

    // Method to switch scenes
        public void switchScene(String fxmlFile) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ankrDashboard.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }



