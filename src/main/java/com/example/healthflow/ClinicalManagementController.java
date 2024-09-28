
package com.example.healthflow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import javafx.event.ActionEvent;

public class ClinicalManagementController {

    @FXML
    public TableColumn<?, ?> ClnAge;

    @FXML
    public TableColumn<?, ?> ClnBG;

    @FXML
    public TableColumn<?, ?> ClnFirstName;

    @FXML
    public TableColumn<?, ?> ClnGender;

    @FXML
    public TableColumn<?, ?> ClnLastName;

    @FXML
    public TableColumn<?, ?> ClnPatientId;

    @FXML
    public TableColumn<?, ?> ClnPhNo;

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
    public TableView<Patient> tblvTable;

    @FXML
    public TextField txtfSearch;

    @FXML
    public VBox vbxDashboard;

    @FXML
    public VBox vbxUser;

    @FXML
    void handleAppointmentButtonClick(ActionEvent event) {

    }

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
    public void handleUserButtonClick() throws IOException {
        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
    }

    // Method to switch scenes
//    public void switchScene(String fxmlFile) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
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

    public class Patient {
        public final String patientID;
        public final String firstName;
        public final String lastName;
        public final String bloodGroup;
        public final String phoneNo;
        public final String age;
        public final String gender;

        public Patient(String patientID, String firstName, String lastName, String bloodGroup, String phoneNo, String age, String gender) {
            this.patientID = patientID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.bloodGroup = bloodGroup;
            this.phoneNo = phoneNo;
            this.age = age;
            this.gender = gender;
        }

        public String getPatientID() {
            return patientID;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public String getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }
    }

    // ObservableList to hold patient data
    public ObservableList<Patient> patientList = FXCollections.observableArrayList();

//    // Initialize method to load data when the controller is initialized
//    @FXML
//    public void initialize() {
//        // Set up the columns with the model's properties
//        ClnPatientId.setCellValueFactory(new PropertyValueFactory<>("patientID"));
//        ClnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//        ClnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        ClnBG.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
//        ClnPhNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
//        ClnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
//        ClnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//
//        // Load patient data from the database
//        loadPatientData();
//    }
//
//    // Existing method to load patient data
//    public ObservableList<Patient> patients;
//
//    public void loadPatientData() {
//        patients = FXCollections.observableArrayList();
//
//        String query = "SELECT first_name, last_name, Blood_Group, phone_no, Age, Gender FROM patient";
//
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthflow", "root", "12345678");
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String bloodGroup = rs.getString("Blood_Group");
//                String phoneNo = rs.getString("phone_no");
//                int age = rs.getInt("Age");
//                String gender = rs.getString("Gender");
//
//                patients.add(new Patient(firstName, lastName, bloodGroup, phoneNo, age, gender));
//            }
//
//            tblvTable.setItems(patients);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Optionally show an error message
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Database Error");
//            alert.setHeaderText(null);
//            alert.setContentText("Failed to load patient data: " + e.getMessage());
//            alert.showAndWait();
//        }
//    }







    // ObservableList to hold patient data
    public ObservableList<Patient> patients;

    @FXML
    public void initialize() {
        // Set up the columns with the model's properties
        ClnPatientId.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        ClnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ClnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ClnBG.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        ClnPhNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        ClnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ClnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        // Load patient data from the database
        loadPatientData();
    }

    public void loadPatientData() {
        patients = FXCollections.observableArrayList();

        String query = "SELECT patient_id, first_name, last_name, Blood_Group, phone_no, Age, Gender FROM patient";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthflow", "root", "12345678");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String patientID = rs.getString("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String bloodGroup = rs.getString("Blood_Group");
                String phoneNo = rs.getString("phone_no");
                int age = rs.getInt("Age");
                String gender = rs.getString("Gender");

                patients.add(new Patient(patientID, firstName, lastName, bloodGroup, phoneNo, String.valueOf(age), gender));
            }

            tblvTable.setItems(patients);

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load patient data: " + e.getMessage());
            alert.showAndWait();
        }
    }

    // Search functionality remains the same...





    // Search functionality
    @FXML
    public void handleSearchKeyReleased() {
        String searchText = txtfSearch.getText().toLowerCase();
        ObservableList<Patient> filteredList = FXCollections.observableArrayList();

        for (Patient patient : patients) {
            if (patient.getFirstName().toLowerCase().contains(searchText) ||
                    patient.getLastName().toLowerCase().contains(searchText) ||
                    patient.getBloodGroup().toLowerCase().contains(searchText) ||
                    patient.getPhoneNo().toLowerCase().contains(searchText) ||
                    String.valueOf(patient.getAge()).contains(searchText) ||
                    patient.getGender().toLowerCase().contains(searchText)) {
                filteredList.add(patient);
            }
        }

        tblvTable.setItems(filteredList);
    }
}

