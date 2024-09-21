package com.example.healthflow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logincontroller {

    @FXML
    private CheckBox CBoxShowPass;

    @FXML
    private Hyperlink HypLinkForgPass;

    @FXML
    private TextField tfuser;  // Username TextField

    @FXML
    private PasswordField tfpass;  // Password PasswordField

    @FXML
    private Button btnlog;  // Login Button

    @FXML
    private Label lblError;  // Error Label for login failure

    // Temporary TextField for showing plain password (hidden by default in FXML)
//    private TextField tfShowPassword = new TextField();
private TextField tfpassVisible = new TextField();
    // Database connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
    private final String DB_USERNAME = "root"; // Replace with your MySQL username
    private final String DB_PASSWORD = "12345678"; // Replace with your MySQL password

    @FXML
    void initialize() {
        // Sync the text between PasswordField and the TextField
        tfpassVisible.setManaged(false);
        tfpassVisible.setVisible(false);

        // Bind the content of both fields to the same value
        tfpassVisible.textProperty().bindBidirectional(tfpass.textProperty());

        // Handle the Show Password checkbox
        CBoxShowPass.setOnAction(event -> togglePasswordVisibility());
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = tfuser.getText();
        String password = tfpass.getText();  // Use `tfpass.getText()` even when password is shown

        if (tfuser.getText().isEmpty() || tfpass.getText().isEmpty()) {
            lblError.setText("Please enter username and password");
            lblError.setVisible(true);
        } else if (isValidCredentials(username, password)) {
            // Credentials are correct, navigate to the home page
            loadHomePage(event);
        } else {
            // Credentials are incorrect, show an error alert
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
            lblError.setVisible(false);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/healthflow/HomePage2.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Home");
            stage.show();

            // Optionally, get the HomeController and pass any necessary data
            com.example.healthflow.HomeController homeController = loader.getController();
            homeController.loadDashboardData();  // Ensure this method exists in HomeController for loading the data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void togglePasswordVisibility() {
        if (CBoxShowPass.isSelected()) {
            tfpassVisible.setText(tfpass.getText()); // Show the password in the text field
            tfpass.setVisible(false); // Hide the password field
            tfpassVisible.setVisible(true); // Show the visible text field
        } else {
            tfpass.setText(tfpassVisible.getText()); // Set the password back into the password field
            tfpassVisible.setVisible(false); // Hide the visible text field
            tfpass.setVisible(true); // Show the password field
        }
    }


    // Handle forgot password hyperlink click
    @FXML
    void handleForgotPassword(ActionEvent event) {
        try {
            // Load the ForgotPassword page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/healthflow/ForgotPassword.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Forgot Password");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load Forgot Password page.");
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

