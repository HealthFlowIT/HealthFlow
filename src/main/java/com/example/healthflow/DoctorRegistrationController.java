//package com.example.healthflow;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.scene.paint.Paint;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Objects;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DoctorRegistrationController {
//
//    @FXML
//    public MenuItem PatientTab;
//
//    @FXML
//    public MenuItem StaffTab;
//
//    @FXML
//    public AnchorPane ankrContact;
//
//    @FXML
//    public AnchorPane ankrCredentials;
//
//    @FXML
//    public AnchorPane ankrDashboard;
//
//    @FXML
//    public AnchorPane ankrDashboard2;
//
//    @FXML
//    public AnchorPane ankrMain;
//
//    @FXML
//    public AnchorPane ankrOthers;
//
//    @FXML
//    public AnchorPane ankrPersonalDetails;
//
//    @FXML
//    public AnchorPane ankrTitle;
//
//    @FXML
//    public Button btnAppointment;
//
//    @FXML
//    public Button btnBack;
//
//    @FXML
//    public Button btnBilling;
//
//    @FXML
//    public Button btnClearAll;
//
//    @FXML
//    public Button btnClinicalManagement;
//
//    @FXML
//    public Button btnHome;
//
//    @FXML
//    public Button btnSave;
//
//    @FXML
//    public Button btnUser;
//
//    @FXML
//    public ComboBox<String> cmbxSpeciality;
//
//
//    @FXML
//    public DatePicker dtpkrDate;
//
//    @FXML
//    public ImageView imgvUser;
//
//    @FXML
//    public Label lblContact;
//
//    @FXML
//    public Label lblCredentials;
//
//    @FXML
//    public Label lblDOB;
//
//    @FXML
//    public Label lblDashboard;
//
//    @FXML
//    public Label lblDoctorID;
//
//    @FXML
//    public Label lblDoctorRegistration;
//
//    @FXML
//    public Label lblEmail;
//
//    @FXML
//    public Label lblGender;
//
//    @FXML
//    public Label lblName;
//
//    @FXML
//    public Label lblOthers;
//
//    @FXML
//    public Label lblPassword;
//
//    @FXML
//    public Label lblPersonalDetails;
//
//    @FXML
//    public Label lblPhoneNo;
//
//    @FXML
//    public Label lblRegNo;
//
//    @FXML
//    public Label lblSpeciality;
//
//    @FXML
//    public Label lblUsername;
//
//    @FXML
//    public MenuButton mnuBtnRegistration;
//
//    @FXML
//    public TextField txtfConfirmPassword;
//
//    @FXML
//    public TextField txtfDoctorID;
//
//    @FXML
//    public TextField txtfEmail;
//
//    @FXML
//    public TextField txtfFirstName;
//
//    @FXML
//    public TextField txtfGender;
//
//    @FXML
//    public TextField txtfLastName;
//
//    @FXML
//    public TextField txtfPhoneNo;
//
//    @FXML
//    public TextField txtfRegNo;
//
//    @FXML
//    public TextField txtfSetPassword;
//
//    @FXML
//    public TextField txtfUsername;
//
//    @FXML
//    public VBox vbxDashboard;
//
//    @FXML
//    public VBox vbxUser;
//
//    @FXML
//    public TextField txtfSecurityAnswer;
//
//    // Handler for Home button
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
//    @FXML
//    public void handleUserButtonClick() throws IOException {
//        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
//    }
//
//@FXML
//    // Method to switch scenes
//    public void switchScene(String fxmlFile) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//@FXML
//    public void handleBackButtonClick() throws IOException {
//        // Load the homepage scene from FXML (assuming "HomePage2.fxml" is the homepage)
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
//        Parent homePageRoot = loader.load();
//
//        // Get the controller for the homepage
//        HomeController homePageController = loader.getController();
//
//        // Call the refreshPage method to refresh the homepage data (this step is optional because the initialize method will do this)
//        homePageController.refreshPage();
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
//
//
//
//    @FXML
//    public ComboBox<String> mnubtnChooseSpeciality;
//    @FXML
//    public Label lblPasswordError;
//
//
//    // Database credentials (replace with your actual credentials)
//    public final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//    public final String DB_USER = "root";
//    public final String DB_PASS = "12345678";
//
////        @FXML
////        public void initialize() {
////            // Initialize ComboBox with specialities
////            mnubtnChooseSpeciality.getItems().addAll("Cardiology", "Neurology", "Orthopedics", "Pediatrics");
////        }
//
////    // Save button handler
//    @FXML
//    public void handleSave(ActionEvent event) {
//        // Get values from form fields
//        String firstName = txtfFirstName.getText();
//        String lastName = txtfLastName.getText();
//        String gender = txtfGender.getText();
//        String doctorID = txtfDoctorID.getText();
//        String phoneNo = txtfPhoneNo.getText();
//        String email = txtfEmail.getText();
//        String regNo = txtfRegNo.getText();
//        String speciality = mnubtnChooseSpeciality.getValue();
//        LocalDate dob = dtpkrDate.getValue();
//        String username = txtfUsername.getText();
//        String password = txtfSetPassword.getText();
//        String confirmPassword = txtfConfirmPassword.getText();
//        String securityAnswer = txtfSecurityAnswer.getText();
//
//        // Validate password
//        if (!isPasswordValid(password)) {
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Password must be 8 characters long, contain upper and lower case letters, and a special character.");
//            return;
//        }
//
//        // Ensure password and confirm password match
//        if (!password.equals(confirmPassword)) {
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Passwords do not match.");
//            return;
//        }
//
//        // Insert data into database
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            // Insert into doctor table
//            String doctorQuery = "INSERT INTO doctor (DoctorId, Firstname, Lastname, Gender, DOB, PhoneNo, Email, Regno, Speciality) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery);
//            doctorStmt.setString(1, doctorID);
//            doctorStmt.setString(2, firstName);
//            doctorStmt.setString(3, lastName);
//            doctorStmt.setString(4, gender);
//            doctorStmt.setDate(5, java.sql.Date.valueOf(dob));
//            doctorStmt.setString(6, phoneNo);
//            doctorStmt.setString(7, email);
//            doctorStmt.setString(8, regNo);
//            doctorStmt.setString(9, speciality);
//            doctorStmt.executeUpdate();
//
//            // Insert into user table
//            String userQuery = "INSERT INTO user (username, password, security_answer) VALUES (?, ?, ?)";
//            PreparedStatement userStmt = conn.prepareStatement(userQuery);
//            userStmt.setString(1, username);
//            userStmt.setString(2, password);
//            userStmt.setString(3, securityAnswer);
//            userStmt.executeUpdate();
//
//            // Success message
//            lblPasswordError.setTextFill(Color.GREEN);
//            lblPasswordError.setText("Data saved successfully!");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Error saving data to database.");
//        }
//    }
//@FXML
//    // Password validation method
//    public boolean isPasswordValid(String password) {
//        if (password.length() < 8) {
//            return false;
//        }
//        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).+$";
//        Pattern compiledPattern = Pattern.compile(pattern);
//        Matcher matcher = compiledPattern.matcher(password);
//        return matcher.find();
//    }
//
//    // Clear all button handler
//    @FXML
//    public void handleClearAll(ActionEvent event) {
//        txtfFirstName.clear();
//        txtfLastName.clear();
//        txtfGender.clear();
//        txtfDoctorID.clear();
//        txtfPhoneNo.clear();
//        txtfEmail.clear();
//        txtfRegNo.clear();
//        txtfUsername.clear();
//        txtfSetPassword.clear();
//        txtfConfirmPassword.clear();
//        txtfSecurityAnswer.clear();
//        mnubtnChooseSpeciality.getSelectionModel().clearSelection();
//        dtpkrDate.setValue(null);
//        lblPasswordError.setText("");
//    }
//}
//
//
//
//





////working code
//package com.example.healthflow;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Objects;
//
//public class DoctorRegistrationController {
//
//    @FXML
//    public MenuItem PatientTab;
//    @FXML
//    public MenuItem StaffTab;
//    @FXML
//    public AnchorPane ankrContact;
//    @FXML
//    public AnchorPane ankrCredentials;
//    @FXML
//    public AnchorPane ankrDashboard;
//    @FXML
//    public AnchorPane ankrDashboard2;
//    @FXML
//    public AnchorPane ankrMain;
//    @FXML
//    public AnchorPane ankrOthers;
//    @FXML
//    public AnchorPane ankrPersonalDetails;
//    @FXML
//    public AnchorPane ankrTitle;
//    @FXML
//    public Button btnAppointment;
//    @FXML
//    public Button btnBack;
//    @FXML
//    public Button btnBilling;
//    @FXML
//    public Button btnClearAll;
//    @FXML
//    public Button btnClinicalManagement;
//    @FXML
//    public Button btnHome;
//    @FXML
//    public Button btnSave;
//    @FXML
//    public Button btnUser;
//    @FXML
//    public ComboBox<String> cmbxSpeciality;
//    @FXML
//    public DatePicker dtpkrDate;
//    @FXML
//    public ImageView imgvUser;
//    @FXML
//    public Label lblPasswordError;
//    @FXML
//    public TextField txtfConfirmPassword;
//    @FXML
//    public TextField txtfDoctorID;
//    @FXML
//    public TextField txtfEmail;
//    @FXML
//    public TextField txtfFirstName;
//    @FXML
//    public TextField txtfLastName;
//    @FXML
//    public TextField txtfPhoneNo;
//    @FXML
//    public TextField txtfRegNo;
//    @FXML
//    public VBox vbxDashboard;
//    @FXML
//    public ComboBox<String> mnubtnChooseSpeciality;
//    @FXML
//    public MenuButton mnubtnChooseGender;
//
//
//
//    // Database credentials
//    public final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//    public final String DB_USER = "root";
//    public final String DB_PASS = "12345678";
//
//    // Initialize method to set the Doctor ID
//    @FXML
//    public void initialize() {
//        setAutoIncrementDoctorId();
//    }
//
//    // Method to set auto-increment Doctor ID
//    public void setAutoIncrementDoctorId() {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            // Query to get the next available Doctor ID
//            String query = "SELECT COALESCE(MAX(DoctorId), 0) + 1 AS NextDoctorId FROM doctor";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int nextDoctorId = rs.getInt("NextDoctorId");
//                txtfDoctorID.setText(String.valueOf(nextDoctorId)); // Set the Doctor ID text field
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Error fetching Doctor ID.");
//        }
//    }
//
//    // Handler for Home button
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
//    @FXML
//    public void handleUserButtonClick() throws IOException {
//        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
//    }
//
//    // Method to switch scenes
//    @FXML
//    public void switchScene(String fxmlFile) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    public void handleBackButtonClick() throws IOException {
//        // Load the homepage scene from FXML (assuming "HomePage2.fxml" is the homepage)
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
//        Parent homePageRoot = loader.load();
//
//        // Get the controller for the homepage
//        HomeController homePageController = loader.getController();
//
//        // Call the refreshPage method to refresh the homepage data
//        homePageController.refreshPage();
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
//
//    // Handler for Set Credentials button
//    @FXML
//    public void handleSetCredentialsButtonClick() throws IOException {
//        // Switch to SetCredentials page
//        switchScene("SetCredentials.fxml");
//    }


//working code 1
//    @FXML
//    public void handleSave(ActionEvent event) {
//        // Get values from form fields
//        String firstName = txtfFirstName.getText();
//        String lastName = txtfLastName.getText();
//        String doctorID = txtfDoctorID.getText();
//        String phoneNo = txtfPhoneNo.getText();
//        String email = txtfEmail.getText();
//        String regNo = txtfRegNo.getText();
//        String speciality = mnubtnChooseSpeciality.getValue();
//        String gender = mnubtnChooseGender.getText(); // Changed to get text instead of value
//        LocalDate dob = dtpkrDate.getValue();
//
//        // Insert data into database
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            // Insert into doctor table
//            String doctorQuery = "INSERT INTO doctor (DoctorId, Firstname, Lastname, Gender, DOB, PhoneNo, Email, Regno, Speciality) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery);
//            doctorStmt.setString(1, doctorID);
//            doctorStmt.setString(2, firstName);
//            doctorStmt.setString(3, lastName);
//            doctorStmt.setString(4, gender);
//            doctorStmt.setDate(5, java.sql.Date.valueOf(dob));
//            doctorStmt.setString(6, phoneNo);
//            doctorStmt.setString(7, email);
//            doctorStmt.setString(8, regNo);
//            doctorStmt.setString(9, speciality);
//            doctorStmt.executeUpdate();
//
//            // Success message
//            lblPasswordError.setTextFill(Color.GREEN);
//            lblPasswordError.setText("Doctor details saved successfully!");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Error saving data to database.");
//        }
//    }

//working code 2
//    @FXML
//    public void handleSave(ActionEvent event) {
//        // Get values from form fields
//        String firstName = txtfFirstName.getText();
//        String lastName = txtfLastName.getText();
//        String doctorID = txtfDoctorID.getText();
//        String phoneNo = txtfPhoneNo.getText();
//        String email = txtfEmail.getText();
//        String regNo = txtfRegNo.getText();
//        String speciality = mnubtnChooseSpeciality.getValue();
//
//        String gender = mnubtnChooseGender.getText();  // Get the selected gender (Male/Female/Other)
//
//        LocalDate dob = dtpkrDate.getValue();
//
//        // Insert data into database
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            String doctorQuery = "INSERT INTO doctor (DoctorId, Firstname, Lastname, Gender, DOB, PhoneNo, Email, Regno, Speciality) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery);
//            doctorStmt.setString(1, doctorID);
//            doctorStmt.setString(2, firstName);
//            doctorStmt.setString(3, lastName);
//            doctorStmt.setString(4, gender);
//            doctorStmt.setDate(5, java.sql.Date.valueOf(dob));
//            doctorStmt.setString(6, phoneNo);
//            doctorStmt.setString(7, email);
//            doctorStmt.setString(8, regNo);
//            doctorStmt.setString(9, speciality);
//            doctorStmt.executeUpdate();
//
//            if (lblPasswordError != null) {
//                lblPasswordError.setTextFill(Color.GREEN);
//                lblPasswordError.setText("Doctor details saved successfully!");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            if (lblPasswordError != null) {
//                lblPasswordError.setTextFill(Color.RED);
//                lblPasswordError.setText("Error saving data to database.");
//            }
//        }
//    }
//
//    @FXML
//    public void handleClearAll(ActionEvent event) {
//        // Clear text fields
//        txtfFirstName.clear();
//        txtfLastName.clear();
//        txtfDoctorID.clear();
//        txtfPhoneNo.clear();
//        txtfEmail.clear();
//        txtfRegNo.clear();
//
//        // Clear date picker
//        dtpkrDate.setValue(null);
//
//        // Clear combo boxes
//        mnubtnChooseSpeciality.getSelectionModel().clearSelection();
//        mnubtnChooseGender.getItems().clear(); // Clear MenuButton items
//
//        // Optionally, reset any labels or messages
//        lblPasswordError.setText("");
//
//        // Reset Doctor ID
//        setAutoIncrementDoctorId(); // Reset Doctor ID to the next
//    }
//
//    @FXML
//    public void handleGenderSelect(ActionEvent event) {
//        MenuItem selectedItem = (MenuItem) event.getSource(); // Get the selected MenuItem
//        mnubtnChooseGender.setText(selectedItem.getText());    // Set MenuButton text to selected gender
//    }
//
//}
//working code
//package com.example.healthflow;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.Objects;
//
//public class DoctorRegistrationController {
//
//    @FXML
//    public AnchorPane ankrMain;
//    @FXML
//    public TextField txtfFirstName;
//    @FXML
//    public TextField txtfLastName;
//    @FXML
//    public TextField txtfDoctorID;
//    @FXML
//    public TextField txtfPhoneNo;
//    @FXML
//    public TextField txtfEmail;
//    @FXML
//    public TextField txtfRegNo;
//    @FXML
//    public ComboBox<String> mnubtnChooseSpeciality;
//    @FXML
//    public MenuButton mnubtnChooseGender;
//    @FXML
//    public DatePicker dtpkrDate;
//    @FXML
//    public Label lblPasswordError;
//
//    // Database credentials
//    public final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//    public final String DB_USER = "root";
//    public final String DB_PASS = "12345678";
//
//    // Handler for Home button
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
//    @FXML
//    public void handleUserButtonClick() throws IOException {
//        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
//    }
//
//    @FXML
//    public void handleProfileButtonClick() throws IOException {
//        switchScene("Profile.fxml");
//    }
//
//    // Method to switch scenes
//    public void switchScene(String fxmlFile) throws IOException {
//        System.out.println("Switching to scene: " + fxmlFile);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
////        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrMain.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    public void initialize() {
//        setAutoIncrementDoctorId();
//    }
//
//    public void setAutoIncrementDoctorId() {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            String query = "SELECT COALESCE(MAX(DoctorId), 0) + 1 AS NextDoctorId FROM doctor";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int nextDoctorId = rs.getInt("NextDoctorId");
//                txtfDoctorID.setText(String.valueOf(nextDoctorId));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            lblPasswordError.setTextFill(Color.RED);
//            lblPasswordError.setText("Error fetching Doctor ID.");
//        }
//    }
//
//    // Handler for Set Credentials button
//    @FXML
//    public void handleSetCredentialsButtonClick() throws IOException {
//        // Create a Doctor object and populate it with form data
//        Doctor doctor = new Doctor();
//        doctor.setDoctorID(Integer.parseInt(txtfDoctorID.getText()));
//        doctor.setFirstName(txtfFirstName.getText());
//        doctor.setLastName(txtfLastName.getText());
//        doctor.setGender(mnubtnChooseGender.getText());
//        doctor.setDob(dtpkrDate.getValue());
//        doctor.setPhoneNo(txtfPhoneNo.getText());
//        doctor.setEmail(txtfEmail.getText());
//        doctor.setRegNo(txtfRegNo.getText());
//        doctor.setSpeciality(mnubtnChooseSpeciality.getValue());
//
//        // Load SetCredentials.fxml and pass the doctor object
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("SetCredentials2.fxml"));
//        Parent root = loader.load();
//
//        // Pass the doctor object to the SetCredentialsController
//        SetCredentialsController2 credentialsController = loader.getController();
//        credentialsController.setDoctorDetails(doctor);
//
//        Stage stage = (Stage) ankrMain.getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public class Doctor {
//        public int doctorID;
//        public String firstName;
//        public String lastName;
//        public String gender;
//        public LocalDate dob;
//        public String phoneNo;
//        public String email;
//        public String regNo;
//        public String speciality;
//
//        // Getters and Setters
//        public int getDoctorID() {
//            return doctorID;
//        }
//
//        public void setDoctorID(int doctorID) {
//            this.doctorID = doctorID;
//        }
//
//        public String getFirstName() {
//            return firstName;
//        }
//
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        public String getGender() {
//            return gender;
//        }
//
//        public void setGender(String gender) {
//            this.gender = gender;
//        }
//
//        public LocalDate getDob() {
//            return dob;
//        }
//
//        public void setDob(LocalDate dob) {
//            this.dob = dob;
//        }
//
//        public String getPhoneNo() {
//            return phoneNo;
//        }
//
//        public void setPhoneNo(String phoneNo) {
//            this.phoneNo = phoneNo;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getRegNo() {
//            return regNo;
//        }
//
//        public void setRegNo(String regNo) {
//            this.regNo = regNo;
//        }
//
//        public String getSpeciality() {
//            return speciality;
//        }
//
//        public void setSpeciality(String speciality) {
//            this.speciality = speciality;
//        }
//    }
//    @FXML
//    public void handleGenderSelect(ActionEvent event) {
//        // Get the source of the event, which is the MenuItem that was clicked
//        MenuItem selectedMenuItem = (MenuItem) event.getSource();
//        String selectedGender = selectedMenuItem.getText();
//
//        // Update the text of the MenuButton to show the selected gender
//        mnubtnChooseGender.setText(selectedGender);
//
//        // Optional: Do something with the selected gender (e.g., store it in a variable, print it)
//        System.out.println("Selected Gender: " + selectedGender);
//    }
//
//    @FXML
//    public void handleBackButtonClick() throws IOException {
//        // Load the homepage scene from FXML (assuming "HomePage2.fxml" is the homepage)
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
//        Parent homePageRoot = loader.load();
//
//        // Get the controller for the homepage
//        HomeController homePageController = loader.getController();
//
//        // Call the refreshPage method to refresh the homepage data (this step is optional because the initialize method will do this)
//        homePageController.refreshPage();
//
//        // Get the current stage
//        Stage stage = (Stage) ankrMain.getScene().getWindow();
//
//        // Create a new scene with the homepage root node from the FXML file
//        Scene homePageScene = new Scene(homePageRoot);
//        // Set the homepage scene to the stage
//        stage.setScene(homePageScene);
//        stage.show();
//    }
//    @FXML
//    public void clearAll() {
//        // Clear text fields
//        txtfFirstName.clear();
//        txtfLastName.clear();
//        txtfDoctorID.clear();
//        txtfPhoneNo.clear();
//        txtfEmail.clear();
//        txtfRegNo.clear();
//
//        // Reset the ComboBox (Speciality)
//        mnubtnChooseSpeciality.setValue(null);
//
//        // Reset the MenuButton (Gender)
//        mnubtnChooseGender.setText("Select Gender"); // Set it to the default label or placeholder
//
//        // Reset DatePicker (Date of Birth)
//        dtpkrDate.setValue(null);
//
//        // Optionally, clear any error labels
//        lblPasswordError.setText("");
//    }
//}
package com.example.healthflow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class DoctorRegistrationController {

    @FXML
    public AnchorPane ankrMain;
    @FXML
    public TextField txtfFirstName;
    @FXML
    public TextField txtfLastName;
    @FXML
    public TextField txtfDoctorID;
    @FXML
    public TextField txtfPhoneNo;
    @FXML
    public TextField txtfEmail;
    @FXML
    public TextField txtfRegNo;
    @FXML
    public ComboBox<String> mnubtnChooseSpeciality;
    @FXML
    public MenuButton mnubtnChooseGender;
    @FXML
    public DatePicker dtpkrDate;
    @FXML
    public Label lblPasswordError;

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

    @FXML
    public void handleProfileButtonClick() throws IOException {
        switchScene("Profile.fxml");
    }

    // Method to switch scenes
    public void switchScene(String fxmlFile) throws IOException {
        System.out.println("Switching to scene: " + fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrMain.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        setAutoIncrementDoctorId();
    }

    public void setAutoIncrementDoctorId() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT COALESCE(MAX(DoctorId), 0) + 1 AS NextDoctorId FROM doctor";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int nextDoctorId = rs.getInt("NextDoctorId");
                txtfDoctorID.setText(String.valueOf(nextDoctorId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            lblPasswordError.setTextFill(Color.RED);
            lblPasswordError.setText("Error fetching Doctor ID.");
        }
    }

    // Handler for Set Credentials button
    @FXML
    public void handleSetCredentialsButtonClick() throws IOException {
        // Validate inputs
        if (!isInputValid()) {
            return; // Don't proceed if validation fails
        }

        // Create a Doctor object and populate it with form data
        Doctor doctor = new Doctor();
        doctor.setDoctorID(Integer.parseInt(txtfDoctorID.getText()));
        doctor.setFirstName(txtfFirstName.getText());
        doctor.setLastName(txtfLastName.getText());
        doctor.setGender(mnubtnChooseGender.getText());
        doctor.setDob(dtpkrDate.getValue());
        doctor.setPhoneNo(txtfPhoneNo.getText());
        doctor.setEmail(txtfEmail.getText());
        doctor.setRegNo(txtfRegNo.getText());
        doctor.setSpeciality(mnubtnChooseSpeciality.getValue());

        // Load SetCredentials.fxml and pass the doctor object
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SetCredentials2.fxml"));
        Parent root = loader.load();

        // Pass the doctor object to the SetCredentialsController
        SetCredentialsController2 credentialsController = loader.getController();
        credentialsController.setDoctorDetails(doctor);

        Stage stage = (Stage) ankrMain.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean isInputValid() {
        // Check phone number length
        String phoneNo = txtfPhoneNo.getText();
        if (phoneNo.length() != 10 || !phoneNo.matches("\\d+")) {
            showAlert("Phone Number Error", "Phone number must be exactly 10 digits.");
            return false;
        }

        // Check email format
        String email = txtfEmail.getText();
        if (!email.contains("@")) {
            showAlert("Email Error", "Email must contain '@'.");
            return false;
        }

        // Check registration number format
        String regNo = txtfRegNo.getText();
        if (!regNo.matches("\\d+")) {
            showAlert("Registration Number Error", "Registration number must be an integer.");
            return false;
        }

        return true; // All checks passed
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public class Doctor {
        public int doctorID;
        public String firstName;
        public String lastName;
        public String gender;
        public LocalDate dob;
        public String phoneNo;
        public String email;
        public String regNo;
        public String speciality;

        // Getters and Setters
        public int getDoctorID() {
            return doctorID;
        }

        public void setDoctorID(int doctorID) {
            this.doctorID = doctorID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }
    }

    @FXML
    public void handleGenderSelect(ActionEvent event) {
        // Get the source of the event, which is the MenuItem that was clicked
        MenuItem selectedMenuItem = (MenuItem) event.getSource();
        String selectedGender = selectedMenuItem.getText();

        // Update the text of the MenuButton to show the selected gender
        mnubtnChooseGender.setText(selectedGender);

        // Optional: Do something with the selected gender (e.g., store it in a variable, print it)
        System.out.println("Selected Gender: " + selectedGender);
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

        // Create a new scene with the homepage root node from the FXML
        Scene homeScene = new Scene(homePageRoot);

        // Set the scene to the current stage and show it
        stage.setScene(homeScene);
        stage.show();
    }
    @FXML
    public void clearAll() {
        // Clear text fields
        txtfFirstName.clear();
        txtfLastName.clear();
        txtfDoctorID.clear();
        txtfPhoneNo.clear();
        txtfEmail.clear();
        txtfRegNo.clear();

        // Reset the ComboBox (Speciality)
        mnubtnChooseSpeciality.setValue(null);

        // Reset the MenuButton (Gender)
        mnubtnChooseGender.setText("Select Gender"); // Set it to the default label or placeholder

        // Reset DatePicker (Date of Birth)
        dtpkrDate.setValue(null);

        // Optionally, clear any error labels
        lblPasswordError.setText("");
    }
}
