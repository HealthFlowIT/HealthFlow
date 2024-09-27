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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class PatientRegistrationController {

    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem StaffTab;

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
    public Label lblAddress1;

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
    public DatePicker txtfDOB;

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

    @FXML
    public void handleUserButtonClick() throws IOException {
        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
    }

    // Method to switch scenes
    public void switchScene(String fxmlFile) throws IOException {
        System.out.println("Switching to scene: " + fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//     Your existing @FXML variables

    // Method to save patient details to the database
    @FXML
    public void handleSaveButtonClick() {
        String patientID = txtfPatientID.getText();
        String firstName = txtfFirstName.getText();
        String lastName = txtfLastName.getText();
        String address = txtfAddressLine1.getText();
        String city = txtfCity.getText();
        String pinCode = txtfPIN.getText();
        String bedNumber = txtfBedno1.getText();
        String bloodGroup = txtfBloodGroup.getText();
        String age = txtfAge.getText();
        String dob = (txtfDOB.getValue() != null) ? txtfDOB.getValue().toString() : null;  // Null safety for DatePicker
        String gender = txtfGender.getText();
        String phone = txtfPhoneNo.getText();
        String email = txtfEmail.getText();
        String street = txtfStreet.getText();

        // Check for null values before proceeding
        if (patientID == null || firstName == null || lastName == null || dob == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields (ID, Name, DOB).");
            alert.showAndWait();
            return;
        }

        // SQL query for patient table
        String queryPatient = "INSERT INTO patient (patient_id, first_name, last_name, Address, city, pincode, Blood_Group, Age, DOB, Gender, phone_no, email_id,street) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        // SQL query for bed table
        String queryBed = "INSERT INTO bed (bed_no, patient_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthflow", "root", "12345678");
             PreparedStatement pstmtPatient = conn.prepareStatement(queryPatient);
             PreparedStatement pstmtBed = conn.prepareStatement(queryBed)) {

            // Set parameters for patient table
            pstmtPatient.setString(1, patientID);
            pstmtPatient.setString(2, firstName);
            pstmtPatient.setString(3, lastName);
            pstmtPatient.setString(4, address);
            pstmtPatient.setString(5, city);
            pstmtPatient.setString(6, pinCode);
            pstmtPatient.setString(7, bloodGroup);
            pstmtPatient.setString(8, age);
            pstmtPatient.setString(9, dob);
            pstmtPatient.setString(10, gender);
            pstmtPatient.setString(11, phone);
            pstmtPatient.setString(12, email);
            pstmtPatient.setString(13, street);

            // Set parameters for bed table
            pstmtBed.setString(1, bedNumber);
            pstmtBed.setString(2, patientID);

            // Execute the queries
            pstmtPatient.executeUpdate();
            pstmtBed.executeUpdate();

            // Notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Patient details saved successfully!");
            alert.showAndWait();

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save patient details: " + e.getMessage());
            alert.showAndWait();
        }
    }
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
    public void handleClearButtonClick() {
        txtfPatientID.clear();
        txtfFirstName.clear();
        txtfLastName.clear();
        txtfAddressLine1.clear();
        txtfCity.clear();
        txtfPIN.clear();
        txtfBedno1.clear();
        txtfBloodGroup.clear();
        txtfAge.clear();
        txtfDOB.setValue(null); // Clear DatePicker
        txtfGender.clear();
        txtfPhoneNo.clear();
        txtfEmail.clear();
        txtfStreet.clear();
    }

}





