package com.example.healthflow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ProfileController {

    @FXML
    public MenuItem DoctorTab;
    @FXML
    public MenuItem PatientTab;
    @FXML
    public ComboBox<?> QuestionCmbBox;
    @FXML
    public MenuItem StaffTab;
    @FXML
    public TextArea TxtAreaAns;
    @FXML
    public AnchorPane ankrTitle;
    @FXML
    public AnchorPane ankrTitle11;
    @FXML
    public AnchorPane ankrTitle111;
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
    public Button btnProfile;
    @FXML
    public Button btnReset;  // Reset button for username/password
    @FXML
    public Button btnUser;
    @FXML
    public ImageView imgvUser;
    @FXML
    public Label lblAppointment;
    @FXML
    public Label lblAvailability;
    @FXML
    public Label lblDoctorID;
    @FXML
    public Label lblEmail;
    @FXML
    public Label lblName;
    @FXML
    public Label lblPhoneNo;
    @FXML
    public MenuButton mnuBtnRegistration;
    @FXML
    public TextField txtfDoctorID;
    @FXML
    public TextField txtfEmail;
    @FXML
    public TextField txtfFirstName;
    @FXML
    public TextField txtfLastName;
    @FXML
    public TextField txtfPhoneNo;
    @FXML
    public VBox vbxUser;
    @FXML
    public AnchorPane ankrDashboard;
    @FXML
    public AnchorPane ankrMain;

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
        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
    }

    @FXML
    public void handleResetButtonClick() throws IOException {
        switchScene("Forgotpassword.fxml");
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

    public void handleBackButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
        Parent homePageRoot = loader.load();
        HomeController homePageController = loader.getController();
        homePageController.refreshPage();
        Stage stage = (Stage) ankrMain.getScene().getWindow();
        Scene homePageScene = new Scene(homePageRoot);
        stage.setScene(homePageScene);
        stage.show();
    }
}

//    // Method to fetch user information from the database
//    public void loadUserInfo(String username) {
//
//        String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
//        String DB_USERNAME = "root";
//        String DB_PASSWORD = "12345678";
//        try {
//            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//                 Statement statement = connection.createStatement()) {
//                String query = "SELECT first_name, last_name, phone_no, email FROM user WHERE username = ?";
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setString(1, username);  // Assuming you pass the username of the logged-in user
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()) {
//                    txtfFirstName.setText(resultSet.getString("first_name"));
//                    txtfLastName.setText(resultSet.getString("last_name"));
//                    txtfPhoneNo.setText(resultSet.getString("phone_no"));
//                    txtfEmail.setText(resultSet.getString("email"));
//                }
//
//                preparedStatement.close();
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
