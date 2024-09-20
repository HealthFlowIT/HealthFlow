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
import java.util.Objects;

public class  StaffRegistrationController {

@FXML
public AnchorPane ankrContact;

@FXML
public AnchorPane ankrCredentials;

@FXML
public AnchorPane ankrDashboard;

@FXML
public AnchorPane ankrDashboard2;

@FXML
public AnchorPane ankrMain;

@FXML
public AnchorPane ankrOthers;

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
public Label lblContact;

@FXML
public Label lblCredentials;

@FXML
public Label lblDOB;

@FXML
public Label lblDashboard;

@FXML
public Label lblDepartment;

@FXML
public Label lblEmail;

@FXML
public Label lblGender;

@FXML
public Label lblName;

@FXML
public Label lblOthers;

@FXML
public Label lblPassword;

@FXML
public Label lblPersonalDetails;

@FXML
public Label lblPhoneNo;

@FXML
public Label lblQualification;

@FXML
public Label lblStaffID;

@FXML
public Label lblStaffRegistration;

@FXML
public Label lblUsername;

@FXML
public MenuButton mnuBtnRegistration;

@FXML
public MenuButton mnubtnChooseQualification;

@FXML
public TextField txtfConfirmPassword;

@FXML
public TextField txtfDOB;

@FXML
public TextField txtfDepartment;

@FXML
public TextField txtfEmail;

@FXML
public TextField txtfFirstName;

@FXML
public TextField txtfGender;

@FXML
public TextField txtfLastName;

@FXML
public TextField txtfPhoneNo;

@FXML
public TextField txtfSetPassword;

@FXML
public TextField txtfStaffID;

@FXML
public TextField txtfUsername;

@FXML
public VBox vbxDashboard;

@FXML
public VBox vbxUser;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem StaffTab;
    // Handler for Home button
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

//    @FXML
//    public void handleHomeButtonClick() throws IOException {
//        switchScene("HomePage2.fxml");
//    }
//
//    // Handler for Appointment button
//    @FXML
//    public void handleAppointmentButtonClick() throws IOException {
//        switchScene("Appointment.fxml");
//    }
//
//    // Handler for Billing button
//    @FXML
//    public void handleBillingButtonClick() throws IOException {
//        switchScene("BillingandInvoice.fxml");
//    }
//
//    // Handler for Registration MenuItem selection
//    @FXML
//    public void handlePatientTabClick() throws IOException {
//        switchScene("PatientRegistration.fxml");
//    }
//
//    @FXML
//    public void handleDoctorTabClick() throws IOException {
//        switchScene("DoctorRegistration.fxml");
//    }
//
//    @FXML
//    public void handleStaffTabClick() throws IOException {
//        switchScene("StaffRegistration.fxml");
//    }
//
//    @FXML
//    public void handleClinicalManagementTabClick() throws IOException {
//        switchScene("ClinicalManagement.fxml");
//    }
//
//    // Method to switch scenes
//    public void switchScene(String fxmlFile) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//}


