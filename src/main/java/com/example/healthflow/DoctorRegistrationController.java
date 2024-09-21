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

public class DoctorRegistrationController {

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem StaffTab;

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
    public ComboBox<?> cmbxSpeciality;

    @FXML
    public DatePicker dtpkrDate;

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
    public Label lblDoctorID;

    @FXML
    public Label lblDoctorRegistration;

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
    public Label lblRegNo;

    @FXML
    public Label lblSpeciality;

    @FXML
    public Label lblUsername;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TextField txtfConfirmPassword;

    @FXML
    public TextField txtfDoctorID;

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
    public TextField txtfRegNo;

    @FXML
    public TextField txtfSetPassword;

    @FXML
    public TextField txtfUsername;

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

    // Method to switch scenes
    public void switchScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
//    // Database connection details
//    public static final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//    public static final String DB_USERNAME = "root";
//    public static final String DB_PASSWORD = "12345678";
//
//    @FXML
//    public void handleSaveButtonClick() {
//        String firstName = txtfFirstName.getText();
//        String lastName = txtfLastName.getText();
//        String gender = txtfGender.getText();
//        String dob = txtfDOB.getText();
//        String doctorID = txtfDoctorID.getText();
//        String phoneNo = txtfPhoneNo.getText();
//        String email = txtfEmail.getText();
//        String regNo = txtfRegNo.getText();
//        String username = txtfUsername.getText();
//        String password = txtfSetPassword.getText();
//        String confirmPassword = txtfConfirmPassword.getText();
//
//        // Validate password
//        if (!validatePassword(password)) {
//            showError("Password must be at least 8 characters long, contain uppercase and lowercase letters, and not be a common keyword.");
//            return;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            showError("Passwords do not match.");
//            return;
//        }
//
//        // Insert into appointment table
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            String insertAppointmentSQL = "INSERT INTO doctor (Firstname, Lastname, Gender, DOB, DoctorId, PhoneNo, Email, Regno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//            try (PreparedStatement pstmt = connection.prepareStatement(insertAppointmentSQL)) {
//                pstmt.setString(1, firstName);
//                pstmt.setString(2, lastName);
//                pstmt.setString(3, gender);
//                pstmt.setString(4, dob);
//                pstmt.setString(5, doctorID);
//                pstmt.setString(6, phoneNo);
//                pstmt.setString(7, email);
//                pstmt.setString(8, regNo);
//                pstmt.executeUpdate();
//            }
//
//            // Insert into user table
//            String insertUserSQL = "INSERT INTO user (username, password) VALUES (?, ?)";
//            try (PreparedStatement pstmt = connection.prepareStatement(insertUserSQL)) {
//                pstmt.setString(1, username);
//                pstmt.setString(2, password);
//                pstmt.executeUpdate();
//            }
//
//            showAlert("Registration Successful!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            showError("An error occurred while saving data.");
//        }
//    }
//
//    public boolean validatePassword(String password) {
//        if (password.length() < 8) return false;
//
//        boolean hasUppercase = !password.equals(password.toLowerCase());
//        boolean hasLowercase = !password.equals(password.toUpperCase());
//        boolean hasCommonKeyword = password.equalsIgnoreCase("password") || password.equalsIgnoreCase("12345678");
//
//        return hasUppercase && hasLowercase && !hasCommonKeyword;
//    }
//
//    public void showError(String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Error");
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    public void showAlert(String message) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information");
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//    @FXML
//    public void handleClearButtonClick() {
//        // Clear all text fields
//        txtfFirstName.clear();
//        txtfLastName.clear();
//        txtfGender.clear();
//        txtfDOB.clear();
//        txtfDoctorID.clear();
//        txtfPhoneNo.clear();
//        txtfEmail.clear();
//        txtfRegNo.clear();
//        txtfUsername.clear();
//        txtfSetPassword.clear();
//        txtfConfirmPassword.clear();
//    }
//}

    @FXML
    public void initialize() {
        btnSave.setOnAction(e -> saveDoctorData());
        btnClearAll.setOnAction(e -> clearAllFields());
    }

    public void saveDoctorData() {
        String firstName = txtfFirstName.getText();
        String lastName = txtfLastName.getText();
        String gender = txtfGender.getText();
        String dob = dtpkrDate.getValue() != null ? dtpkrDate.getValue().toString() : "";
        String doctorID = txtfDoctorID.getText();
        String phoneNo = txtfPhoneNo.getText();
        String email = txtfEmail.getText();
        String regNo = txtfRegNo.getText();
        String username = txtfUsername.getText();
        String password = txtfSetPassword.getText();
        String confirmPassword = txtfConfirmPassword.getText();
        String speciality = (String) cmbxSpeciality.getValue();  // Getting selected speciality

        // Validate password
        if (!isValidPassword(password)) {
            showErrorAlert("Invalid Password", "Password must be at least 8 characters long, " +
                    "contain both upper and lower case letters, and include a special character.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showErrorAlert("Password Mismatch", "Passwords do not match. Please try again.");
            return;
        }

        if (speciality == null || speciality.isEmpty()) {
            showErrorAlert("Speciality Missing", "Please select a speciality.");
            return;
        }

        // Database connection and insert logic
        String doctorQuery = "INSERT INTO doctor (Firstname, Lastname, Gender, DOB, DoctorId, PhoneNo, Email, RegNo,Speciality) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        String userQuery = "INSERT INTO user (username, password) VALUES (?, ?)";
//        String appointmentQuery = "INSERT INTO appointment (Doctorid, Speciality) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthflow", "root", "12345678");
             PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery);
             PreparedStatement userStmt = conn.prepareStatement(userQuery);) {

            // Insert into doctor table
            doctorStmt.setString(1, firstName);
            doctorStmt.setString(2, lastName);
            doctorStmt.setString(3, gender);
            doctorStmt.setString(4, dob);
            doctorStmt.setString(5, doctorID);
            doctorStmt.setString(6, phoneNo);
            doctorStmt.setString(7, email);
            doctorStmt.setString(8, regNo);
            doctorStmt.setString(9, speciality);
            doctorStmt.executeUpdate();

            // Insert into user table
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            userStmt.executeUpdate();

            // Insert into appointment table (Doctor ID and Speciality)
//            appointmentStmt.setString(1, doctorID);  // Assuming doctorID is used as a foreign key in the appointment table
//            appointmentStmt.setString(2, speciality);
//            appointmentStmt.executeUpdate();

            showConfirmationAlert("Success", "Doctor registration was successful!");

        } catch (SQLException e) {
            e.printStackTrace();
            showErrorAlert("Database Error", "An error occurred while saving data. Please try again.");
        }
    }

    public boolean isValidPassword(String password) {
        // Check for at least 8 characters, uppercase, lowercase, and special character
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\W.*");
    }

    public void clearAllFields() {
        txtfFirstName.clear();
        txtfLastName.clear();
        txtfGender.clear();
        dtpkrDate.setValue(null);
        txtfDoctorID.clear();
        txtfPhoneNo.clear();
        txtfEmail.clear();
        txtfRegNo.clear();
        txtfUsername.clear();
        txtfSetPassword.clear();
        txtfConfirmPassword.clear();
        cmbxSpeciality.setValue(null);  // Clearing the speciality ComboBox
    }

    public void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showConfirmationAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

