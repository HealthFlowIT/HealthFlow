package com.example.healthflow;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;


public class HomeController {
//public class DashboardController {

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public Button btnHome;

    @FXML
    public Button btnAppointment;

    @FXML
    public Button btnBilling;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem StaffTab;

    @FXML
    public Button btnClinicalManagement;

    @FXML
    public VBox vbxUser;

    @FXML
    public Button btnUser;

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
        System.out.println("Switching to scene: " + fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//public class HomeController {

    @FXML
    public Label lblNoOfTotalPatients;  // Matches FXML ID for total patients
    @FXML
    public Label lblActivePatients;
    @FXML
    public Label lblNoOfActivePatients;// Added FXML ID for active patients
    @FXML
    public Label lblOperations;
    @FXML
    public Label lblNoOfOperations;// Added FXML ID for operations

    @FXML
    public PieChart pieChart;               // FXML ID for PieChart
    @FXML
    public XYChart<String, Number> barGraph;  // FXML ID for StackedBarChart

    public void loadDashboardData() {
        String DB_USERNAME = "root";
        String DB_PASSWORD = "12345678";
        // Database connection details
        String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Query to get total number of patients
            String queryTotalPatients = "SELECT COUNT(*) AS totalPatients FROM patient";
            ResultSet resultSet = statement.executeQuery(queryTotalPatients);

            if (resultSet.next()) {
                int totalPatients = resultSet.getInt("totalPatients");
                lblNoOfTotalPatients.setText(String.valueOf(totalPatients));  // Update label with data
            }

// Query to get active patients
            String queryActivePatients = "SELECT COUNT(*) AS activePatients FROM patient WHERE Activity = 'Active'";
            resultSet = statement.executeQuery(queryActivePatients);

            if (resultSet.next()) {
                int activePatients = resultSet.getInt("activePatients");
                lblNoOfActivePatients.setText(String.valueOf(activePatients));  // Update label with data
            }

// Query to get total operations, excluding rows with 'none' in the Operation column and checking for 'active' in activity column
            String queryTotalOperations = "SELECT COUNT(*) AS totalOperations FROM patient WHERE Operation != 'none' AND activity LIKE '%active%'";
            resultSet = statement.executeQuery(queryTotalOperations);

            if (resultSet.next()) {
                int totalOperations = resultSet.getInt("totalOperations");
                lblNoOfOperations.setText(String.valueOf(totalOperations));  // Update label with data
            }
            // Example PieChart and StackedBarChart update
            pieChart.getData().clear();
            resultSet = statement.executeQuery("SELECT Activity, COUNT(*) AS count FROM patient GROUP BY activity");
            while (resultSet.next()) {
                pieChart.getData().add(new PieChart.Data(resultSet.getString("activity"), resultSet.getInt("count")));
            }
            barGraph.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            resultSet = statement.executeQuery("SELECT Operation, COUNT(*) AS count FROM patient GROUP BY Operation");
            while (resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString("Operation"), resultSet.getInt("count")));
            }
            barGraph.getData().add(series);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

