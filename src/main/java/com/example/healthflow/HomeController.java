package com.example.healthflow;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeController {

    @FXML
    private Label acp;  // Active patients label

    @FXML
    private Label treat;  // Treatments label

    @FXML
    private Label Oper;  // Operations label

    @FXML
    private PieChart piec;  // PieChart

    @FXML
    private StackedBarChart<?, ?> barg;  // BarGraph

    // Database connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
    private final String DB_USERNAME = "root"; // Replace with your MySQL username
    private final String DB_PASSWORD = "12345678"; // Replace with your MySQL password

    // Method to load data into dashboard
    public void loadDashboardData() {
        loadActivePatients();
        loadTreatments();
        loadOperations();
        loadPieChart();
        loadBarGraph();
    }
    //make changes over here for calculation of data
    // Example method for loading active patients count
    private void loadActivePatients() {
        String query = "SELECT COUNT(*) AS activePatients FROM patients WHERE status='active'";  // Adjust table and column names
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                acp.setText(resultSet.getString("activePatients"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTreatments() {
        // Add logic for loading treatments data
    }

    private void loadOperations() {
        // Add logic for loading operations data
    }

    private void loadPieChart() {
        // Add logic for populating PieChart with data
    }

    private void loadBarGraph() {
        // Add logic for populating BarGraph with data
    }
}
