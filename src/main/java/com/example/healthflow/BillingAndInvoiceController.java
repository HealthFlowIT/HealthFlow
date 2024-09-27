//package com.example.healthflow;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.awt.event.ActionEvent;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Objects;
//import java.util.Stack;
//
//public class BillingAndInvoiceController {
//
//    @FXML
//    public DatePicker DpDD;
//
//    @FXML
//    public DatePicker DpInv;
//
//    @FXML
//    public TableColumn<?, ?> TcAmt;
//
//    @FXML
//    public TableColumn<?, ?> TcP;
//
//    @FXML
//    public TableColumn<?, ?> TcSr;
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
//    public Button btnAddParticulars;
//
//    @FXML
//    public Button btnSave;
//
//    @FXML
//    public Button btnUser;
//
//    @FXML
//    public ImageView imgvUser;
//
//    @FXML
//    public Label lblClinicalManagement;
//
//    @FXML
//    public Label lblDOB;
//
//    @FXML
//    public Label lblDOB1;
//
//    @FXML
//    public Label lblDOB11;
//
//    @FXML
//    public Label lblDashboard;
//
//    @FXML
//    public Label lblDoctorID;
//
//    @FXML
//    public Label lblDoctorID1;
//
//    @FXML
//    public Label lblGender;
//
//    @FXML
//    public Label lblGender1;
//
//    @FXML
//    public Label lblName;
//
//    @FXML
//    public Label lblPersonalDetails;
//
//    @FXML
//    public MenuButton mnuBtnRegistration;
//
//    @FXML
//    public TextField txtfAD;
//
//    @FXML
//    public TextField txtfDD;
//
//    @FXML
//    public TextField txtfDOB;
//
//    @FXML
//    public TextField txtfFirstName;
//
//    @FXML
//    public TextField txtfGender;
//
//    @FXML
//    public TextField txtfGender1;
//
//    @FXML
//    public TextField txtfLastName;
//
//    @FXML
//    public VBox vbxDashboard;
//
//    @FXML
//    public VBox vbxUser;
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
////     Handler for Billing button
//        @FXML
//        public void handleBillingButtonClick() throws IOException {
//            switchScene("BillingandInvoice.fxml");
//        }
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
//
//    }
//    @FXML
//    public void handleUserButtonClick() throws IOException {
//        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
//    }
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
//
//        // Set the homepage scene to the stage
//        stage.setScene(homePageScene);
//        stage.show();
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
//
//    // FXML Components
//    @FXML public TextField  txtfPatientID, txtfInvoiceNo, txtfDoctorID;
//    @FXML public DatePicker dpAdmitDate, dpDischargeDate, dpInvoiceDate, dpDueDate;
//    @FXML public TableView<Particular> particularsTableView;
//    @FXML public TableColumn<Particular, Integer> tcSerialNo;
//    @FXML public TableColumn<Particular, String> tcParticulars;
//    @FXML public TableColumn<Particular, Double> tcAmount;
//
//    @FXML public TextField txtfParticular, txtfAmount;
//
//    // ObservableList to hold particulars
//    public final ObservableList<Particular> particularsList = FXCollections.observableArrayList();
//
//    // Initialize method
//    @FXML
//    public void initialize() {
//        // Configure TableView columns
//        tcSerialNo.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
//        tcParticulars.setCellValueFactory(new PropertyValueFactory<>("description"));
//        tcAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
//
//        // Bind the list to the TableView
//        particularsTableView.setItems(particularsList);
//    }
//
//    // Method to add particulars to the table
//    @FXML
//    public void handleAddParticular() {
//        int serialNo = particularsList.size() + 1;
//        String description = txtfParticular.getText();
//        double amount = Double.parseDouble(txtfAmount.getText());
//
//        // Add new particular to the list
//        particularsList.add(new Particular(serialNo, description, amount));
//
//        // Clear input fields
//        txtfParticular.clear();
//        txtfAmount.clear();
//    }
//
//    // Method to save all data to the database
//    @FXML
//    public void handleSave() {
//        // Get data from input fields
//        String firstName = txtfFirstName.getText();
//        String lastName = txtfLastName.getText();
//        int patientID = Integer.parseInt(txtfPatientID.getText());
//        int invoiceNo = Integer.parseInt(txtfInvoiceNo.getText());
//        int doctorID = Integer.parseInt(txtfDoctorID.getText());
//
//        LocalDate admitDate = dpAdmitDate.getValue();
//        LocalDate dischargeDate = dpDischargeDate.getValue();
//        LocalDate invoiceDate = dpInvoiceDate.getValue();
//        LocalDate dueDate = dpDueDate.getValue();
//
//        // Save data to the database
//        saveDataToDatabase(patientID, invoiceNo, doctorID, firstName, lastName, admitDate, dischargeDate, invoiceDate, dueDate, particularsList);
//    }
//
//    // Database connection details (replace with your credentials)
//    public static final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//    public static final String USER = "root";
//    public static final String PASSWORD = "password";
//
//    // Method to save data into the database
//    public void saveDataToDatabase(int patientID, int invoiceNo, int doctorID, String firstName, String lastName,
//                                    LocalDate admitDate, LocalDate dischargeDate, LocalDate invoiceDate, LocalDate dueDate,
//                                    ObservableList<Particular> particularsList) {
//        String sql = "INSERT INTO bill (patient_id, invoice_no, doctor_id, first_name, last_name, admit_date, discharge_date, invoice_date, due_date, serial_no, particulars, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            for (Particular particular : particularsList) {
//                pstmt.setInt(1, patientID);
//                pstmt.setInt(2, invoiceNo);
//                pstmt.setInt(3, doctorID);
//                pstmt.setString(4, firstName);
//                pstmt.setString(5, lastName);
//                pstmt.setDate(6, java.sql.Date.valueOf(admitDate));
//                pstmt.setDate(7, java.sql.Date.valueOf(dischargeDate));
//                pstmt.setDate(8, java.sql.Date.valueOf(invoiceDate));
//                pstmt.setDate(9, java.sql.Date.valueOf(dueDate));
//                pstmt.setInt(10, particular.getSerialNo());
//                pstmt.setString(11, particular.getDescription());
//                pstmt.setDouble(12, particular.getAmount());
//
//                pstmt.addBatch();  // Add batch for multiple inserts
//            }
//
//            pstmt.executeBatch();  // Execute the batch
//            System.out.println("Data saved successfully!");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public class Particular {
//        public final int serialNo;
//        public final String description;
//        public final double amount;
//
//        public Particular(int serialNo, String description, double amount) {
//            this.serialNo = serialNo;
//            this.description = description;
//            this.amount = amount;
//        }
//
//        public int getSerialNo() {
//            return serialNo;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public double getAmount() {
//            return amount;
//        }
//    }
//    @FXML
//    public void handleClearAll() {
//        // Clear all text fields
//        txtfFirstName.clear();
//        txtfLastName.clear();
//        txtfPatientID.clear();
//        txtfInvoiceNo.clear();
//        txtfDoctorID.clear();
//        txtfParticular.clear();
//        txtfAmount.clear();
//
//        // Reset date pickers
//        dpAdmitDate.setValue(null);
//        dpDischargeDate.setValue(null);
//        dpInvoiceDate.setValue(null);
//        dpDueDate.setValue(null);
//
//        // Clear particulars list and table
//        particularsList.clear();
//
//        // Optionally, reset any labels or other controls if necessary
//        // lblDashboard.setText(""); // If you have any labels that need clearing
//    }
//
//
//}
//
//
//
//
//
////package com.example.healthflow;
////
////import javafx.event.ActionEvent;
////import javafx.fxml.FXML;
////import javafx.fxml.FXMLLoader;
////import javafx.scene.Parent;
////import javafx.scene.Scene;
////import javafx.scene.control.*;
////import javafx.scene.image.ImageView;
////import javafx.scene.layout.AnchorPane;
////import javafx.scene.layout.VBox;
////import javafx.stage.Stage;
////
////import java.io.IOException;
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.Objects;
////
////public class BillingAndInvoiceController {
////
////    @FXML
////    public MenuItem DoctorTab;
////
////    @FXML
////    public DatePicker DpAD; // Admission Date
////
////    @FXML
////    public DatePicker DpDD; // Discharge Date
////
////    @FXML
////    public DatePicker DpDisD; // Due Date
////
////    @FXML
////    public DatePicker DpInv; // Invoice Date
////
////    @FXML
////    public MenuItem PatientTab;
////
////    @FXML
////    public MenuItem StaffTab;
////
////    @FXML
////    public TableColumn<?, ?> TcAmt; // Amount Column
////
////    @FXML
////    public TableColumn<?, ?> TcP; // Patient Column
////
////    @FXML
////    public TableColumn<?, ?> TcSr; // Sr Number Column
////
////    @FXML
////    public AnchorPane ankrDashboard;
////
////    @FXML
////    public AnchorPane ankrDashboard2;
////
////    @FXML
////    public AnchorPane ankrMain;
////
////    @FXML
////    public AnchorPane ankrPersonalDetails;
////
////    @FXML
////    public AnchorPane ankrTitle;
////
////    @FXML
////    public Button btnAppointment;
////
////    @FXML
////    public Button btnBack;
////
////    @FXML
////    public Button btnBilling;
////
////    @FXML
////    public Button btnClearAll;
////
////    @FXML
////    public Button btnClinicalManagement;
////
////    @FXML
////    public Button btnHome;
////
////    @FXML
////    public Button btnPaid;
////
////    @FXML
////    public Button btnSave;
////
////    @FXML
////    public Button btnUser;
////
////    @FXML
////    public Button btnUser1;
////
////    @FXML
////    public ImageView imgvUser;
////
////    @FXML
////    public Label lblClinicalManagement;
////
////    @FXML
////    public MenuButton mnuBtnRegistration;
////
////    @FXML
////    public TextField txtfDoctorId;
////
////    @FXML
////    public TextField txtfFirstName;
////
////    @FXML
////    public TextField txtfPatientID;
////
////    @FXML
////    public TextField txtfinvoiceno;
////
////    @FXML
////    public TextField txtfLastName;
////
////    @FXML
////    public VBox vbxUser;
////
////    // JDBC URL, username, and password for MySQL database
////    public static final String DB_URL = "jdbc:mysql://localhost:3306/healthflow"; // Change according to your database setup
////    public static final String USER = "root"; // Your database username
////    public static final String PASS = "12345678"; // Your database password
////
////    // Save button click - save the data entered
////
////    @FXML
////    void handleSaveButton(ActionEvent event) {
////        // Debugging statements
////        System.out.println("txtfPatientID: " + txtfPatientID.getText());
////        System.out.println("txtfFirstName: " + txtfFirstName.getText());
////        System.out.println("txtfLastName: " + txtfLastName.getText());
////        System.out.println("txtfinvoiceno: " + txtfinvoiceno.getText());
////
////        String firstName = txtfFirstName.getText();
////        String lastName = txtfLastName.getText();
////        String doctorId = txtfDoctorId.getText();
////
////        // Get the dates from the DatePickers
////        String admitDate = (DpAD.getValue() != null) ? DpAD.getValue().toString() : null;
////        String dischargeDate = (DpDD.getValue() != null) ? DpDD.getValue().toString() : null;
////        String invoiceDate = (DpInv.getValue() != null) ? DpInv.getValue().toString() : null;
////        String dueDate = (DpDisD.getValue() != null) ? DpDisD.getValue().toString() : null; // Correctly retrieving due date
////
////        // Assuming you have logic to retrieve these values
////        int patientId = Integer.parseInt(txtfPatientID.getText()); // Use actual patient ID input
////        double totalAmount = 100.00; // Replace with your logic to calculate total amount
////        int invoiceNo = Integer.parseInt(txtfinvoiceno.getText()); // Get the invoice number from the TextField
////
////        // Insert the patient billing data into the database
////        String sql = "INSERT INTO bill (first_name, last_name, due_date, admit_date, discharge_date, invoice_date, patient_id, DoctorId, total_amount, invoice_no) " +
////                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
////
////        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
////             PreparedStatement pstmt = conn.prepareStatement(sql)) {
////
////            // Set the parameters for the prepared statement
////            pstmt.setString(1, firstName);
////            pstmt.setString(2, lastName);
////            pstmt.setString(3, dueDate); // Ensure dueDate is set correctly
////            pstmt.setString(4, admitDate);
////            pstmt.setString(5, dischargeDate);
////            pstmt.setString(6, invoiceDate);
////            pstmt.setInt(7, patientId);
////            pstmt.setInt(8, Integer.parseInt(doctorId)); // Ensure doctorId is an integer
////            pstmt.setDouble(9, totalAmount);
////            pstmt.setInt(10, invoiceNo); // Use the manually entered invoice number
////
////            // Execute the query
////            int rowsAffected = pstmt.executeUpdate();
////
////            if (rowsAffected > 0) {
////                System.out.println("Patient billing data saved successfully.");
////            } else {
////                System.out.println("Failed to save patient billing data.");
////            }
////
////        } catch (SQLException e) {
////            e.printStackTrace(); // Print detailed SQL error for debugging
////        } catch (NumberFormatException e) {
////            System.err.println("Invalid input for invoice number: " + e.getMessage());
////        }
////    }
////
////    public int getNextInvoiceNo() {
////        int invoiceNo = 1; // Start with 1 or any other base number
////        String query = "SELECT MAX(invoice_no) AS max_invoice_no FROM bill";
////
////        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
////             PreparedStatement pstmt = conn.prepareStatement(query);
////             ResultSet rs = pstmt.executeQuery()) {
////            if (rs.next()) {
////                invoiceNo = rs.getInt("max_invoice_no") + 1; // Increment the max invoice number
////            }
////
////            // Check for existing invoice numbers to avoid duplicates
////            String checkQuery = "SELECT COUNT(*) FROM bill WHERE invoice_no = ?";
////            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
////                while (true) {
////                    checkStmt.setInt(1, invoiceNo);
////                    ResultSet checkRs = checkStmt.executeQuery();
////                    if (checkRs.next() && checkRs.getInt(1) > 0) {
////                        invoiceNo++; // If it exists, increment the invoice number
////                    } else {
////                        break; // Exit the loop if it's unique
////                    }
////                }
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return invoiceNo; // Return the unique invoice number
////    }
////
////
////    @FXML
////    public void handleAppointmentButtonClick() throws IOException {
////        switchScene("Appointment.fxml");
////    }
////
////    public void handleBackButtonClick() throws IOException {
////        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
////        Parent homePageRoot = loader.load();
////        HomeController homePageController = loader.getController();
////        homePageController.refreshPage();
////        Stage stage = (Stage) ankrMain.getScene().getWindow();
////        Scene homePageScene = new Scene(homePageRoot);
////        stage.setScene(homePageScene);
////        stage.show();
////    }
////
////    // Clear all button - clear all input fields
////    @FXML
////    void handleClearAllActions(ActionEvent event) {
////        txtfFirstName.clear();
////        txtfLastName.clear();
////        txtfPatientID.clear();
////        txtfinvoiceno.clear();
////        txtfDoctorId.clear();
////        DpAD.setValue(null);
////        DpDD.setValue(null);
////        DpDisD.setValue(null);
////        DpInv.setValue(null);
////        System.out.println("Cleared all fields");
////    }
////
////    // Handle Clinical Management tab click
////    @FXML
////    public void handleDoctorTabClick() throws IOException {
////        switchScene("DoctorRegistration.fxml");
////    }
////
////    @FXML
////    public void handleClinicalManagementTabClick() throws IOException {
////        switchScene("ClinicalManagement.fxml");
////    }
////
////    // Handle Home button click - navigate to home page
////    @FXML
////    public void handleHomeButtonClick() throws IOException {
////        switchScene("HomePage2.fxml");
////    }
////
////    // Handle Logout button click - log the user out
////    @FXML
////    public void handleUserButtonClick() throws IOException {
////        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
////    }
////
////    // Handle Paid button click - mark invoice as paid
////    @FXML
////    void handlePaidButton(ActionEvent event) {
////        // Logic to mark the selected invoice as paid
////        System.out.println("Invoice marked as paid");
////    }
////
////    // Handle Patient tab click
////    @FXML
////    void handlePatientTabClick(ActionEvent event) {
////        // Logic to display patient-related information
////        System.out.println("Switching to Patient Tab");
////    }
////
////    // Handle Staff tab click
////    @FXML
////    void handleStaffTabClick(ActionEvent event) {
////        // Logic to display staff-related information
////        System.out.println("Switching to Staff Tab");
////    }
////}
//
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

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class BillingAndInvoiceController {

    @FXML
    public DatePicker DpDD;

    @FXML
    public DatePicker DpInv;

    @FXML
    public TableColumn<?, ?> TcAmt;

    @FXML
    public TableColumn<?, ?> TcP;

    @FXML
    public TableColumn<?, ?> TcSr;

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
    public Button btnPaid;

    @FXML
    public Button btnSave;

    @FXML
    public Button btnUser;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblClinicalManagement;

    @FXML
    public Label lblDOB;

    @FXML
    public Label lblDOB1;

    @FXML
    public Label lblDOB11;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblDoctorID;

    @FXML
    public Label lblDoctorID1;

    @FXML
    public Label lblGender;

    @FXML
    public Label lblGender1;

    @FXML
    public Label lblName;

    @FXML
    public Label lblPersonalDetails;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TextField txtfAD;

    @FXML
    public TextField txtfDD;

    @FXML
    public TextField txtfDOB;

    @FXML
    public TextField txtfFirstName;

    @FXML
    public TextField txtfGender;

    @FXML
    public TextField txtfGender1;

    @FXML
    public TextField txtfLastName;

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

    //     Handler for Billing button
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

    // Method to switch scenes
    public void switchScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}




