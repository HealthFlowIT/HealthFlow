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
import java.util.Objects;

public class PatientRegistrationController {

    @FXML
    public AnchorPane ankrAddress;

    @FXML
    public AnchorPane ankrContact;

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
    public Button btnUser;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblAddress;

    @FXML
    public Label lblAge;

    @FXML
    public Label lblBed1;

    @FXML
    public Label lblBloodGroup;

    @FXML
    public Label lblCity;

    @FXML
    public Label lblContact;

    @FXML
    public Label lblDOB;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblEmail;

    @FXML
    public Label lblGender;

    @FXML
    public Label lblName;

    @FXML
    public Label lblPIN;

    @FXML
    public Label lblPatientID;

    @FXML
    public Label lblPersonalDetails;

    @FXML
    public Label lblPhoneNo;

    @FXML
    public Label lblStreet;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TextField txtfAddressLine1;

    @FXML
    public TextField txtfAge;

    @FXML
    public TextField txtfBedno1;

    @FXML
    public TextField txtfBloodGroup;

    @FXML
    public TextField txtfCity;

    @FXML
    public TextField txtfDOB;

    @FXML
    public TextField txtfEmail;

    @FXML
    public TextField txtfFirstName;

    @FXML
    public TextField txtfGender;

    @FXML
    public TextField txtfLastName;

    @FXML
    public TextField txtfPIN;

    @FXML
    public TextField txtfPatientID;

    @FXML
    public TextField txtfPhoneNo;

    @FXML
    public TextField txtfStreet;

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
        switchScene("AppointmentPage.fxml");
    }

    // Handler for Billing button
    @FXML
    public void handleBillingButtonClick() throws IOException {
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}


