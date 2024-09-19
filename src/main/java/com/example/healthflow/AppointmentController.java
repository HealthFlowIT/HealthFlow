package com.example.healthflow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppointmentController {

    @FXML
    public AnchorPane ankrDashboard;
    
    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem StaffTab;

    @FXML
    public AnchorPane ankrDashboard2;

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
    public Label lblDashboard;

    @FXML
    public Label lblDoctorID;

    @FXML
    public Label lblDoctorID1;

    @FXML
    public Label lblDoctorID11;

    @FXML
    public Label lblDoctorID111;

    @FXML
    public Label lblDoctorID112;

    @FXML
    public Label lblDoctorID1121;

    @FXML
    public Label lblDoctorID12;

    @FXML
    public Label lblDoctorID121;

    @FXML
    public Label lblDoctorID13;

    @FXML
    public Label lblDoctorID2;

    @FXML
    public Label lblDoctorID3;

    @FXML
    public Label lblPersonalDetails;

    @FXML
    public Label lblPersonalDetails1;

    @FXML
    public Label lblPersonalDetails11;

    @FXML
    public Label lblPersonalDetails2;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public MenuButton mnubtnChooseSpeciality;

    @FXML
    public MenuButton mnubtnChooseSpeciality1;

    @FXML
    public MenuButton mnubtnChooseSpeciality11;

    @FXML
    public MenuButton mnubtnChooseSpeciality2;

    @FXML
    public MenuButton mnubtnChooseSpeciality21;

    @FXML
    public TextField txtfDOB;

    @FXML
    public TextField txtfDOB1;

    @FXML
    public TextField txtfDOB11;

    @FXML
    public TextField txtfDOB2;

    @FXML
    public TextField txtfDOB3;

    @FXML
    public VBox vbxDashboard;

    @FXML
    public VBox vbxUser;

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
        switchScene("BillingandInvoice.fxml");
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
    public void switchScene(String fxmlFile) throws IOException {
        System.out.println("Switching to scene: " + fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}