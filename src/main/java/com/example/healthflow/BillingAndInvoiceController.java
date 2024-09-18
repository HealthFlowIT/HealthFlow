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

import java.io.IOException;

public class BillingAndInvoiceController {

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
    public Button btnSave;

    @FXML
    public Button btnSave1;

    @FXML
    public Button btnUser;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblClinicalManagement;

    @FXML
    public Label lblDOB;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblDoctorID;

    @FXML
    public Label lblDoctorID1;

    @FXML
    public Label lblGender;

    @FXML
    private Label lblGender1;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPersonalDetails;

    @FXML
    private MenuButton mnuBtnRegistration;

    @FXML
    private TextField txtfDOB;

    @FXML
    private TextField txtfFirstName;

    @FXML
    private TextField txtfGender;

    @FXML
    private TextField txtfGender1;

    @FXML
    private TextField txtfLastName;

    @FXML
    private VBox vbxDashboard;

    @FXML
    private VBox vbxUser;

        // Handler for Home button
        @FXML
       public void handleHomeButtonClick() throws IOException {
            switchScene("HomePage2.fxml");
        }

        // Handler for Appointment button
        @FXML
        public void handleAppointmentButtonClick() throws IOException {
            switchScene("AppointmentPage.fxml");
        }

        // Handler for Billing button
        @FXML
        private void handleBillingButtonClick() throws IOException {
            switchScene("BillingPage.fxml");
        }

        // Handler for Registration MenuItem selection
        @FXML
        private void handlePatientTabClick() throws IOException {
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

        // Method to switch scenes
        private void switchScene(String fxmlFile) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ankrDashboard.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }


