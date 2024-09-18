package com.example.healthflow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientRegistrationController {

    @FXML
    private AnchorPane ankrAddress;

    @FXML
    private AnchorPane ankrContact;

    @FXML
    private AnchorPane ankrDashboard;

    @FXML
    private AnchorPane ankrDashboard2;

    @FXML
    private AnchorPane ankrMain;

    @FXML
    private AnchorPane ankrPersonalDetails;

    @FXML
    private AnchorPane ankrTitle;

    @FXML
    private Button btnAppointment;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBilling;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnClinicalManagement;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUser;

    @FXML
    private ImageView imgvUser;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblBed1;

    @FXML
    private Label lblBloodGroup;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblDashboard;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPIN;

    @FXML
    private Label lblPatientID;

    @FXML
    private Label lblPersonalDetails;

    @FXML
    private Label lblPhoneNo;

    @FXML
    private Label lblStreet;

    @FXML
    private MenuButton mnuBtnRegistration;

    @FXML
    private TextField txtfAddressLine1;

    @FXML
    private TextField txtfAge;

    @FXML
    private TextField txtfBedno1;

    @FXML
    private TextField txtfBloodGroup;

    @FXML
    private TextField txtfCity;

    @FXML
    private TextField txtfDOB;

    @FXML
    private TextField txtfEmail;

    @FXML
    private TextField txtfFirstName;

    @FXML
    private TextField txtfGender;

    @FXML
    private TextField txtfLastName;

    @FXML
    private TextField txtfPIN;

    @FXML
    private TextField txtfPatientID;

    @FXML
    private TextField txtfPhoneNo;

    @FXML
    private TextField txtfStreet;

    @FXML
    private VBox vbxDashboard;

    @FXML
    private VBox vbxUser;

    // Handler for Home button
    @FXML
    private void handleHomeButtonClick() throws IOException {
        switchScene("HomePage2.fxml");
    }

    // Handler for Appointment button
    @FXML
    private void handleAppointmentButtonClick() throws IOException {
        switchScene("AppointmentPage.fxml");
    }

    // Handler for Billing button
    @FXML
    private void handleBillingButtonClick() throws IOException {
        switchScene("BillingPage.fxml");
    }

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

    // Method to switch scenes
    private void switchScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}


