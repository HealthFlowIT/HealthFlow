package com.example.healthflow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logincontroller {

    @FXML       //yani toh component access hot ahe
    private TextFieldd tfuser;  // Username TextField

    @FXML
    private PasswordField tfpass;  // Password PasswordField

    @FXML
    private Button btnlog;  // Login Button

    // Database connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
    private final String DB_USERNAME = "root"; // Replace with your MySQL username
    private final String DB_PASSWORD = "12345678"; // Replace with your MySQL password

    @FXML
    void handleLogin(ActionEvent event) {
        String username = tfuser.getText();
        String password = tfpass.getText();

        if (isValidCredentials(username, password)) {
            // Credentials are correct, navigate to the home page
            loadHomePage(event);
        } else {
            // Credentials are incorrect, show an error alert
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    // Method to check if the provided username and password are correct by querying the database
    private boolean isValidCredentials(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM user WHERE username = ? AND password = ?"; // Ensure the table and columns match your DB

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // If the result set has a row, that means the credentials are correct
                isValid = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while connecting to the database.");
        }

        return isValid;
    }

    // Method to load the home page
    private void loadHomePage(ActionEvent event) {
        try {
            // Load the home page instead of landing page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/healthflow/Home.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Home Dashboard");
            stage.show();

            // Optionally, get the HomeController and pass any necessary data
            HomeController homeController = loader.getController();
            homeController.loadDashboardData();  // Ensure this method exists in HomeController for loading the data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to show alerts
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
