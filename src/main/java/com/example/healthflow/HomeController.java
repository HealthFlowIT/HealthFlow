//package com.example.healthflow;
//import javafx.fxml.FXML;
//import javafx.geometry.Side;
//import javafx.scene.chart.PieChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.*;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//
//import java.io.IOException;
//import java.util.Locale;
//import java.util.Objects;
//
//
//public class HomeController {
////public class DashboardController {
//
//@FXML
//public Label lblNoOfTotalPatients;
//
//    @FXML
//    public Label lblTotalDoctors;
//
//    @FXML
//    public Label lblTotalPatient;
//
//    @FXML
//    public Label lblTotalStaff;
//
//    @FXML
//    public Label lblTotalnoDoctors;
//
//    @FXML
//    public Label lblTotalnoStaff;
//
//
//    @FXML
//    public AnchorPane ankrDashboard;
//
//    @FXML
//    public Button btnHome;
//
//    @FXML
//    public Button btnAppointment;
//
//    @FXML
//    public Button btnBilling;
//
//    @FXML
//    public MenuButton mnuBtnRegistration;
//
//    @FXML
//    public MenuItem PatientTab;
//
//    @FXML
//    public MenuItem DoctorTab;
//
//    @FXML
//    public MenuItem StaffTab;
//
//    @FXML
//    public Button btnClinicalManagement;
//
//    @FXML
//    public VBox vbxUser;
//
//    @FXML
//    public Button btnUser;
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
//    // Method to switch scenes
//    public void switchScene(String fxmlFile) throws IOException {
//        System.out.println("Switching to scene: " + fxmlFile);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
////public class HomeController {
//
//    @FXML
//    public Label lblNoOfTotalPatients;  // Matches FXML ID for total patients
//    @FXML
//    public Label lblActivePatients;
//    @FXML
//    public Label lblNoOfActivePatients;// Added FXML ID for active patients
//    @FXML
//    public Label lblOperations;
//    @FXML
//    public Label lblNoOfOperations;// Added FXML ID for operations
//
//    @FXML
//    public PieChart pieChart;               // FXML ID for PieChart
//    @FXML
//    public XYChart<String, Number> barGraph;  // FXML ID for StackedBarChart
//
//    public void loadDashboardData() {
//        String DB_USERNAME = "root";
//        String DB_PASSWORD = "12345678";
//        // Database connection details
//        String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//             Statement statement = connection.createStatement()) {
//            // Query to get total number of patients
//            String queryTotalPatients = "SELECT COUNT(*) AS totalPatients FROM patient";
//            ResultSet resultSet = statement.executeQuery(queryTotalPatients);
//
//            if (resultSet.next()) {
//                int totalPatients = resultSet.getInt("totalPatients");
//                lblNoOfTotalPatients.setText(String.valueOf(totalPatients));  // Update label with data
//            }
//
//// Query to get active patients
//            String queryActivePatients = "SELECT COUNT(*) AS activePatients FROM patient WHERE Activity = 'Active'";
//            resultSet = statement.executeQuery(queryActivePatients);
//
//            if (resultSet.next()) {
//                int activePatients = resultSet.getInt("activePatients");
//                lblNoOfActivePatients.setText(String.valueOf(activePatients));  // Update label with data
//            }
//
//// Query to get total operations, excluding rows with 'none' in the Operation column and checking for 'active' in activity column
//            String queryTotalOperations = "SELECT COUNT(*) AS totalOperations FROM patient WHERE Operation != 'none' AND activity LIKE '%active%'";
//            resultSet = statement.executeQuery(queryTotalOperations);
//
//            if (resultSet.next()) {
//                int totalOperations = resultSet.getInt("totalOperations");
//                lblNoOfOperations.setText(String.valueOf(totalOperations));  // Update label with data
//            }
//            // Example PieChart and StackedBarChart update
//            pieChart.getData().clear();
//            resultSet = statement.executeQuery("SELECT Activity, COUNT(*) AS count FROM patient GROUP BY activity");
//            while (resultSet.next()) {
//                pieChart.getData().add(new PieChart.Data(resultSet.getString("activity"), resultSet.getInt("count")));
//            }
//
//            barGraph.getData().clear();
//            XYChart.Series<String, Number> series = new XYChart.Series<>();
//            resultSet = statement.executeQuery("SELECT Operation, COUNT(*) AS count FROM patient GROUP BY Operation");
//            while (resultSet.next()) {
//                series.getData().add(new XYChart.Data<>(resultSet.getString("Operation"), resultSet.getInt("count")));
//            }
//            barGraph.getData().add(series);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    public Label LblNoOfTotalPatients; // Example label where data is shown
//    public Label LblNoOfActivePatients;
//    public Label LblNoOfOperations;
//
    // Method to refresh/reload data
//    public void refreshPage() {
//        String DB_USERNAME = "root";
//        String DB_PASSWORD = "12345678";
//        // Database connection details
//        String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//             Statement statement = connection.createStatement()) {
//            // Query to get total number of patients
//            String queryTotalPatients = "SELECT COUNT(*) AS totalPatients FROM patient";
//            ResultSet resultSet = statement.executeQuery(queryTotalPatients);
//
//            if (resultSet.next()) {
//                int totalPatients = resultSet.getInt("totalPatients");
//                lblNoOfTotalPatients.setText(String.valueOf(totalPatients));  // Update label with data
//            }
//
//// Query to get active patients
//            String queryActivePatients = "SELECT COUNT(*) AS activePatients FROM patient WHERE Activity = 'Active'";
//            resultSet = statement.executeQuery(queryActivePatients);
//
//            if (resultSet.next()) {
//                int activePatients = resultSet.getInt("activePatients");
//                lblNoOfActivePatients.setText(String.valueOf(activePatients));  // Update label with data
//            }
//
//// Query to get total operations, excluding rows with 'none' in the Operation column and checking for 'active' in activity column
//            String queryTotalOperations = "SELECT COUNT(*) AS totalOperations FROM patient WHERE Operation != 'none' AND activity LIKE '%active%'";
//            resultSet = statement.executeQuery(queryTotalOperations);
//
//            if (resultSet.next()) {
//                int totalOperations = resultSet.getInt("totalOperations");
//                lblNoOfOperations.setText(String.valueOf(totalOperations));  // Update label with data
//            }
////             Example PieChart and StackedBarChart update
//            pieChart.getData().clear();
//            resultSet = statement.executeQuery("SELECT Activity, COUNT(*) AS count FROM patient GROUP BY activity");
//            while (resultSet.next()) {
//                pieChart.getData().add(new PieChart.Data(resultSet.getString("activity"), resultSet.getInt("count")));
//            }
//
//            barGraph.getData().clear();
//            XYChart.Series<String, Number> series = new XYChart.Series<>();
//            resultSet = statement.executeQuery("SELECT Operation, COUNT(*) AS count FROM patient GROUP BY Operation");
//            while (resultSet.next()) {
//                series.getData().add(new XYChart.Data<>(resultSet.getString("Operation"), resultSet.getInt("count")));
//            }
//            barGraph.getData().add(series);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    // Logic to reload or refresh data (e.g., fetching data from a database)
//    // Update the UI components with new data, like updating labels, tables, etc.
//    @FXML
//    public void initialize() {
//        // Automatically refresh data when the page is loaded
//        refreshPage();
//    }
//}



package com.example.healthflow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeController {

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public Button btnHome, btnAppointment, btnBilling, btnClinicalManagement, btnUser;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public MenuItem PatientTab, DoctorTab, StaffTab;

    @FXML
    public VBox vbxUser;

    @FXML
    public Label lblNoOfTotalPatients, lblTotalStaff, lblTotalnoDoctors, lblTotalnoStaff;

    @FXML
    public PieChart pieChart;

    @FXML
    public XYChart<String, Number> barGraph;

    private int userId; // Assuming you will set this from LoginController or elsewhere

    // Scene switching methods
    @FXML
    public void handleHomeButtonClick() throws IOException {
        switchScene("HomePage2.fxml");
    }

    @FXML
    public void handleAppointmentButtonClick() throws IOException {
        switchScene("Appointment.fxml");
    }

    @FXML
    public void handleBillingButtonClick() throws IOException {
        switchScene("BillingandInvoice.fxml");
    }

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
        switchScene("LoginPage.fxml");
    }

    @FXML
    public void handleProfileButtonClick() throws IOException {
        switchScene("Profile.fxml");
    }

    // Utility method to switch scenes
    public void switchScene(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Load dashboard data
    public void loadDashboardData(int userId) {
        String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "12345678";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            // Query to get total patients
            int totalPatients = getTotalPatients(statement);
            lblNoOfTotalPatients.setText(String.valueOf(totalPatients));

            int totalDoctors = getTotalDoctors(statement);
            lblTotalnoDoctors.setText(String.valueOf(totalDoctors));

            int totalStaffs = getTotalStaffs(statement);
            lblTotalnoStaff.setText(String.valueOf(totalStaffs));

            // Update the PieChart and BarChart
            updatePieChart(statement, totalPatients);
            updateBarChart(statement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBarChart(Statement statement) {
        // Implement logic to update bar chart here
    }

    // Helper methods to get data from the database
    public int getTotalPatients(Statement statement) throws Exception {
        String queryTotalPatients = "SELECT COUNT(*) AS totalPatients FROM patient";
        try (ResultSet resultSet = statement.executeQuery(queryTotalPatients)) {
            if (resultSet.next()) {
                return resultSet.getInt("totalPatients");
            }
        }
        return 0;
    }

    public int getTotalDoctors(Statement statement) throws Exception {
        String queryTotalDoctors = "SELECT COUNT(*) AS totalDoctors FROM doctor";
        try (ResultSet resultSet = statement.executeQuery(queryTotalDoctors)) {
            if (resultSet.next()) {
                return resultSet.getInt("totalDoctors");
            }
        }
        return 0;
    }

    public int getTotalStaffs(Statement statement) throws Exception {
        String queryTotalStaffs = "SELECT COUNT(*) AS totalStaff FROM staff";
        try (ResultSet resultSet = statement.executeQuery(queryTotalStaffs)) {
            if (resultSet.next()) {
                return resultSet.getInt("totalStaff");
            }
        }
        return 0;
    }

    // Helper methods to update charts
    public void updatePieChart(Statement statement, int totalPatients) throws Exception {
        pieChart.getData().clear();
        String ageGroupQuery = "SELECT ageGroup, COUNT(*) AS count FROM patient GROUP BY ageGroup";
        try (ResultSet resultSet = statement.executeQuery(ageGroupQuery)) {
            while (resultSet.next()) {
                String ageGroup = resultSet.getString("ageGroup");
                int count = resultSet.getInt("count");
                double percentage = (count / (double) totalPatients) * 100;
                pieChart.getData().add(new PieChart.Data(ageGroup + " (" + String.format("%.1f", percentage) + "%)", count));
            }
        }

        // Update the BarChart with Blood Group data
        barGraph.getData().clear();
        String bloodGroupQuery = "SELECT Blood_Group, COUNT(*) AS count FROM patient GROUP BY Blood_Group";
        XYChart.Series<String, Number> seriesBloodGroup = new XYChart.Series<>();
        seriesBloodGroup.setName("Blood Group Distribution");

        try (ResultSet resultSet = statement.executeQuery(bloodGroupQuery)) {
            while (resultSet.next()) {
                String bloodGroup = resultSet.getString("Blood_Group");
                int count = resultSet.getInt("count");
                seriesBloodGroup.getData().add(new XYChart.Data<>(bloodGroup, count));
            }
        }

        barGraph.getData().add(seriesBloodGroup);
    }

    @FXML
    public void refreshPage() {
        loadDashboardData(userId); // Ensure userId is set properly before calling this
    }

    @FXML
    public void initialize() {
        refreshPage(); // Call this during initialization
    }

    // Method to set userId from LoginController
    public void setUserId(int userId) {
        this.userId = userId;
    }
}












