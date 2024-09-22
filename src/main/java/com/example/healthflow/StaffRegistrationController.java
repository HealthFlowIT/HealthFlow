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

public class  StaffRegistrationController {

@FXML
public AnchorPane ankrContact;

@FXML
public AnchorPane ankrCredentials;

@FXML
public DatePicker dtpkrDate;

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



        @FXML
        public TextField txtfSecurityAnswer;
//
//
//        @FXML
//        public MenuButton mnubtnChooseQualification;  // Keep the existing values from FXML

        @FXML
        public void initialize() {
            // Add handlers to the MenuItems in the MenuButton
            for (MenuItem item : mnubtnChooseQualification.getItems()) {
                item.setOnAction(event -> mnubtnChooseQualification.setText(item.getText()));
            }
        }

        @FXML
        public void handleSaveButtonClick() {
            String firstName = txtfFirstName.getText();
            String lastName = txtfLastName.getText();
            String dob = (dtpkrDate.getValue() != null) ? dtpkrDate.getValue().toString() : "";
            String staffID = txtfStaffID.getText();
            String phoneNo = txtfPhoneNo.getText();
            String email = txtfEmail.getText();
            String qualification = mnubtnChooseQualification.getText();  // Get the selected text
            String department = txtfDepartment.getText();
            String username = txtfUsername.getText();
            String setPassword = txtfSetPassword.getText();
            String confirmPassword = txtfConfirmPassword.getText();
            String securityAnswer = txtfSecurityAnswer.getText();

            // Validate input and proceed with saving
            if (areFieldsValid(firstName, lastName, dob, staffID, phoneNo, email, qualification, department, username, setPassword, confirmPassword, securityAnswer)) {
                if (setPassword.equals(confirmPassword)) {
                    try {
                        SaveToDatabase(firstName, lastName, dob, staffID, phoneNo, email, qualification, department, username, setPassword, securityAnswer);
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Staff data saved successfully!");
                        handleClearButtonClick();
                    } catch (SQLException e) {
                        showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to save data: " + e.getMessage());
                    }
                } else {
                    showAlert(Alert.AlertType.ERROR, "Validation Error", "Passwords do not match!");
                }
            }
        }

        // Update switchScene method to use loader once
    @FXML
        public void switchScene(String fxmlFile) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();  // Load once
            Scene scene = new Scene(root);
            Stage stage = (Stage) ankrDashboard.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        // Same clear and validation methods

        // Method to check if fields are valid
    @FXML
        public boolean areFieldsValid(String firstName, String lastName, String dob, String staffID, String phoneNo,
                                      String email, String qualification, String department, String username, String setPassword,
                                      String confirmPassword, String securityAnswer) {
            if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || staffID.isEmpty() || phoneNo.isEmpty() || email.isEmpty()
                    || qualification.equals("Choose option") || department.isEmpty() || username.isEmpty() || setPassword.isEmpty()
                    || confirmPassword.isEmpty() || securityAnswer.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields must be filled.");
                return false;
            }
            return true;
        }

    // Save data to the staff and user tables in the database
    @FXML
        public void SaveToDatabase(String firstName, String lastName, String dob, String staffID, String phoneNo,
                                    String email, String qualification, String department, String username,
                                    String password, String securityAnswer) throws SQLException {
            // Database connection setup
            String url = "jdbc:mysql://localhost:3306/healthflow";
            String user = "root";  // Replace with your MySQL username
            String dbPassword = "12345678";  // Replace with your MySQL password

            Connection conn = DriverManager.getConnection(url, user, dbPassword);

            // Insert into staff table
            String staffInsertQuery = "INSERT INTO staff (staff_id, first_name, last_name, dob, phone_no, email, qualification, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement staffStmt = conn.prepareStatement(staffInsertQuery);
            staffStmt.setString(1, staffID);
            staffStmt.setString(2, firstName);
            staffStmt.setString(3, lastName);
            staffStmt.setString(4, dob);
            staffStmt.setString(5, phoneNo);
            staffStmt.setString(6, email);
            staffStmt.setString(7, qualification);
            staffStmt.setString(8, department);
            staffStmt.executeUpdate();

            // Insert into user table
            String userInsertQuery = "INSERT INTO user (username, password, security_answer) VALUES (?, ?, ?)";
            PreparedStatement userStmt = conn.prepareStatement(userInsertQuery);
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            userStmt.setString(3, securityAnswer);
            userStmt.executeUpdate();

            conn.close();
        }

        // Show alert dialog
    @FXML
        public void showAlert(Alert.AlertType alertType, String title, String content) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        }

        // Clear all input fields
        @FXML
        public void handleClearAllButtonClick() {
            handleClearButtonClick();
        }
@FXML
        public void handleClearButtonClick() {
            txtfFirstName.clear();
            txtfLastName.clear();
            dtpkrDate.setValue(null);
            txtfStaffID.clear();
            txtfPhoneNo.clear();
            txtfEmail.clear();
//            mnubtnChooseQualification.setValue(null);
            txtfDepartment.clear();
            txtfUsername.clear();
            txtfSetPassword.clear();
            txtfConfirmPassword.clear();
            txtfSecurityAnswer.clear();
            mnubtnChooseQualification.setText("Choose option");
        }
    }




