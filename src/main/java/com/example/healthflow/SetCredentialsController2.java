package com.example.healthflow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetCredentialsController2 {
    @FXML
    public AnchorPane ankrMain;
    @FXML
    public TextField txtfUsername;
    @FXML
    public PasswordField txtfSetPassword;
    @FXML
    public PasswordField txtfConfirmPassword;
    @FXML
    public TextField txtfSecurityAnswer;
    @FXML
    public Label lblError;

    @FXML
    public ComboBox<?> cmbSecurityQuestion;

    public DoctorRegistrationController.Doctor doctor;

    // Database credentials
    public final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
    public final String DB_USER = "root";
    public final String DB_PASS = "12345678";


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
        Stage stage = (Stage) ankrMain.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void setDoctorDetails(DoctorRegistrationController.Doctor doctor) {
        this.doctor = doctor;
    }

    @FXML
    public void handleSaveCredentials() {
        String username = txtfUsername.getText();
        String password = txtfSetPassword.getText();
        String confirmPassword = txtfConfirmPassword.getText();
        String securityAnswer = txtfSecurityAnswer.getText();

        if (!password.equals(confirmPassword)) {
            lblError.setTextFill(Color.RED);
            lblError.setText("Passwords do not match!");
            return;
        }

        // Insert doctor and credentials into the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false); // Start transaction

            // Insert doctor details into doctor table
            String doctorQuery = "INSERT INTO doctor (DoctorId, first_name, last_name, Gender, DOB, phone_no, email, Regno, Speciality) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery);
            doctorStmt.setInt(1, doctor.getDoctorID());
            doctorStmt.setString(2, doctor.getFirstName());
            doctorStmt.setString(3, doctor.getLastName());
            doctorStmt.setString(4, doctor.getGender());
            doctorStmt.setDate(5, java.sql.Date.valueOf(doctor.getDob()));
            doctorStmt.setString(6, doctor.getPhoneNo());
            doctorStmt.setString(7, doctor.getEmail());
            doctorStmt.setString(8, doctor.getRegNo());
            doctorStmt.setString(9, doctor.getSpeciality());
            doctorStmt.executeUpdate();

            // Insert credentials into user table with user_id as doctor_id
            String credentialsQuery = "INSERT INTO user (id, username, password, security_answer) VALUES (?, ?, ?, ?)";
            PreparedStatement credentialsStmt = conn.prepareStatement(credentialsQuery);
            credentialsStmt.setInt(1, doctor.getDoctorID());  // user_id is the same as doctor_id
            credentialsStmt.setString(2, username);
            credentialsStmt.setString(3, password);
            credentialsStmt.setString(4, securityAnswer);
            credentialsStmt.executeUpdate();

            conn.commit(); // Commit transaction

            lblError.setTextFill(Color.GREEN);
            lblError.setText("Doctor and credentials saved successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            lblError.setTextFill(Color.RED);
            lblError.setText("Error saving data.");
        }
    }
    @FXML
    public void handleBackButtonClick() throws IOException {
        // Load the staff registration scene from FXML (assuming "StaffRegistration.fxml" is the staff registration page)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorRegistration.fxml"));
        Parent staffRegistrationRoot = loader.load();

        // Get the current stage
        Stage stage = (Stage) ankrMain.getScene().getWindow();

        // Create a new scene with the staff registration root node from the FXML file
        Scene staffRegistrationScene = new Scene(staffRegistrationRoot);

        // Set the staff registration scene to the stage
        stage.setScene(staffRegistrationScene);
        stage.show();
    }
    @FXML
    public void clearAll() {
        // Clearing text fields
        txtfUsername.clear();
        txtfSetPassword.clear();
        txtfConfirmPassword.clear();
        txtfSecurityAnswer.clear();

        // Resetting ComboBox to default state
        cmbSecurityQuestion.getSelectionModel().clearSelection();
    }
}
