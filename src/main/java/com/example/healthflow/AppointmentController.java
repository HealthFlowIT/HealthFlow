package com.example.healthflow;

import javafx.event.ActionEvent;
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

public class AppointmentController {

    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem StaffTab;

    @FXML
    public AnchorPane ankrAvailability;

    @FXML
    public AnchorPane ankrChooseDoctor;

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public AnchorPane ankrDashboard2;

    @FXML
    public AnchorPane ankrDetails;

    @FXML
    public AnchorPane ankrMain;

    @FXML
    public AnchorPane ankrOthers;

    @FXML
    public AnchorPane ankrTitle;

    @FXML
    public Button btnAppointment;

    @FXML
    public Button btnBack;

    @FXML
    public Button btnBilling;

    @FXML
    public Button btnBook;

    @FXML
    public Button btnClearAll;

    @FXML
    public Button btnClinicalManagement;

    @FXML
    public Button btnHome;

    @FXML
    public Button btnUser;

    @FXML
    public ComboBox<?> cmbxAppointmentDuration;

    @FXML
    public ComboBox<?> cmbxAppointmentType;

    @FXML
    public ComboBox<?> cmbxDoctorName;

    @FXML
    public ComboBox<?> cmbxSpeciality;

    @FXML
    public DatePicker dtpkrDate;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblAppointment;

    @FXML
    public Label lblAppointmentDuration;

    @FXML
    public Label lblAppointmentDuration1;

    @FXML
    public Label lblAppointmentType;

    @FXML
    public Label lblAvailability;

    @FXML
    public Label lblBedNo;

    @FXML
    public Label lblChooseDoctor;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblDate;

    @FXML
    public Label lblDetails;

    @FXML
    public Label lblID;

    @FXML
    public Label lblName;

    @FXML
    public Label lblOthers;

    @FXML
    public Label lblPatientID;

    @FXML
    public Label lblSpeciality;

    @FXML
    public Label lblTimeSlot;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TextField txtfBedNo;

    @FXML
    public TextField txtfID;

    @FXML
    public TextField txtfID1;

    @FXML
    public TextField txtfPatientID;

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
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}


//        @FXML
//        public TextField txtfDoctorID, txtfPatientID;
//    //txtfStaffID;
////
////        @FXML
////        public Button btnSave, btnClearAll;
//
//        // JDBC connection details
//        public final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//        public final String USER = "root";
//        public final String PASS = "12345678"; // Replace with your MySQL password
//
//        // Method to handle Save Button click
//        @FXML
//        void handleSaveButtonClick(ActionEvent event) {
//            String doctorID = txtfDoctorID.getText();
//            String patientID = txtfPatientID.getText();
////            String staffID = txtfStaffID.getText();
//            String dob = txtfDOB.getText();
//
//            // SQL Query to insert data
//            String sql = "INSERT INTO appointment (doctor_id, patient_id )VALUES (?, ?)";
////staff_id, dob)
//            // Try inserting the data into the database
//            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//                // Set the parameters for the query
//                pstmt.setString(1, doctorID);
//                pstmt.setString(2, patientID);
////                pstmt.setString(3, staffID);
////                pstmt.setString(4, dob);
//
//                // Execute the insertion
//                pstmt.executeUpdate();
//                System.out.println("Data inserted successfully!");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Method to handle Clear All button click
//        @FXML
//        void handleClearAllButtonClick(ActionEvent event) {
//            // Clear all text fields
//            txtfDoctorID.clear();
//            txtfPatientID.clear();
////            txtfStaffID.clear();
////            txtfDOB.clear();
//        }
//    }