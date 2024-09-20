package com.example.healthflow;

//import javafx.event.ActionEvent;
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

import javafx.scene.control.TableView;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.cell.PropertyValueFactory;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


public class ClinicalManagementController {

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public AnchorPane ankrDashboard2;

    @FXML
    public AnchorPane ankrMain;

    @FXML
    public AnchorPane ankrTable;

    @FXML
    public AnchorPane ankrTitle;

    @FXML
    public Button btnAppointment;

    @FXML
    public Button btnBack;

    @FXML
    public Button btnBilling;

    @FXML
    public Button btnClinicalManagement;

    @FXML
    public Button btnHome;

    @FXML
    public Button btnUser;

    @FXML
    public ImageView imgvSearch;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblClinicalManagement;

    @FXML
    public Label lblDashboard;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TableView<?> tblvTable;

    @FXML
    public TextField txtfSearch;

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

//    @FXML
//    public void handleClinicalManagementTabClick() throws IOException {
//        switchScene("ClinicalManagement.fxml");
//    }

    // Method to switch scenes
    private void switchScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
//    public class Patient {
//        private int id;
//        private String name;
//        private int age;
//        private String gender;
//        private String diagnosis;
//
//        // Constructor
//        public Patient(int id, String name, int age, String gender, String diagnosis) {
//            this.id = id;
//            this.name = name;
//            this.age = age;
//            this.gender = gender;
//            this.diagnosis = diagnosis;
//        }
//
//        // Getters and setters
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
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
//        public String getDiagnosis() {
//            return diagnosis;
//        }
//
//        public void setDiagnosis(String diagnosis) {
//            this.diagnosis = diagnosis;
//        }
//    }
//
//
////        @FXML
////        private TableView<Patient> tblvTable;
////
////        @FXML
////        private TableColumn<Patient, Integer> colId;
////
////        @FXML
////        private TableColumn<Patient, String> colName;
////
////        @FXML
////        private TableColumn<Patient, Integer> colAge;
////
////        @FXML
////        private TableColumn<Patient, String> colGender;
////
////        @FXML
////        private TableColumn<Patient, String> colDiagnosis;
//
//        // Initialize method to be called after the scene is loaded
//        @FXML
//        public void initialize() {
//            // Link table columns to Patient properties
//            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//            colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
//            colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//            colDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
//
//            // Load data from the database
//            loadPatientData();
//        }
//
//        private void loadPatientData() {
//            ObservableList<Patient> patients = FXCollections.observableArrayList();
//
//            String url = "jdbc:mysql://localhost:3306/healthflow";
//            String user = "yourUsername";
//            String password = "yourPassword";
//
//            String query = "SELECT id, name, Gender,Operation FROM patient";
//
//            try (Connection conn = DriverManager.getConnection(url, user, password);
//                 PreparedStatement stmt = conn.prepareStatement(query);
//                 ResultSet rs = stmt.executeQuery()) {
//
//                while (rs.next()) {
//                    // Create a new Patient object and add it to the list
//                    patients.add(new Patient(
//                            rs.getInt("id"),
//                            rs.getString("name"),
//                            rs.getInt("age"),
//                            rs.getString("gender"),
//                            rs.getString("diagnosis")
//                    ));
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            // Populate the TableView with the patient data
//            tblvTable.setItems(patients);
//        }
//    }
//}
