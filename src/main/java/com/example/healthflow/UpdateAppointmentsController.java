//package com.example.healthflow;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.MenuButton;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//public class UpdateAppointmentsController implements Initializable {
//
//    @FXML
//    public TableColumn<?, ?> ClnDate;
//
//    @FXML
//    public TableColumn<?, ?> ClnDur;
//
//    @FXML
//    public TableColumn<?, ?> ClnName;
//
//    @FXML
//    public TableColumn<?, ?> ClnSp;
//
//    @FXML
//    public TableColumn<?, ?> ClnTimeSlot;
//
//    @FXML
//    public TableColumn<?, ?> ClnType;
//
//    @FXML
//    public MenuItem DoctorTab;
//
//    @FXML
//    public MenuItem PatientTab;
//
//    @FXML
//    public MenuItem StaffTab;
//
//    @FXML
//    public AnchorPane ankrAppTable;
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
//    public Button btnClinicalManagement;
//
//    @FXML
//    public Button btnDelete;
//
//    @FXML
//    public Button btnHome;
//
//    @FXML
//    public Button btnUpdate;
//
//    @FXML
//    public Button btnUser;
//
//    @FXML
//    public Button btnUser1;
//
//    @FXML
//    public ImageView imgvSearch;
//
//    @FXML
//    public ImageView imgvUser;
//
//    @FXML
//    public Label lblDashboard;
//
//    @FXML
//    public Label lblUpdateAppointment;
//
//    @FXML
//    public MenuButton mnuBtnRegistration;
//
//    @FXML
//    public TableView<?> tblvAppTable;
//
//    @FXML
//    public TextField txtfSearch;
//
//    @FXML
//    public VBox vbxDashboard;
//
//    @FXML
//    public VBox vbxUser;
//
//@FXML
//    public void handleHomeButtonClick() throws IOException {
//        switchScene("HomePage2.fxml");
//    }
//
//    @FXML
//    public void handleAppointmentButtonClick() throws IOException {
//        switchScene("Appointment.fxml");
//    }
//
//    @FXML
//    public void handleBillingButtonClick() throws IOException {
//        switchScene("BillingandInvoice.fxml");
//    }
//
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
//    @FXML
//    public void handleUserButtonClick() throws IOException {
//        switchScene("LoginPage.fxml"); // Replace "LoginPage.fxml" with the actual FXML file name for your login page
//    }
//
//    @FXML
//    public void handleUpdateButtonClick() throws IOException {
//        switchScene("UpdateAppointments.fxml");
//    }
//
//    public void switchScene(String fxmlFile) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void handleBackButtonClick() throws IOException {
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("HomePage2.fxml")));
//        Parent homePageRoot = loader.load();
//        HomeController homePageController = loader.getController();
//        homePageController.refreshPage();
//        Stage stage = (Stage) ankrMain.getScene().getWindow();
//        Scene homePageScene = new Scene(homePageRoot);
//        stage.setScene(homePageScene);
//        stage.show();
//    }
//    public class Appointment {
//        public String speciality;
//        public String doctorName;
//        public String appointmentType;
//        public String appointmentDuration;
//        public String date;
//        public String timeSlot;
//
//        public Appointment(String speciality, String doctorName, String appointmentType, String appointmentDuration, String date, String timeSlot) {
//            this.speciality = speciality;
//            this.doctorName = doctorName;
//            this.appointmentType = appointmentType;
//            this.appointmentDuration = appointmentDuration;
//            this.date = date;
//            this.timeSlot = timeSlot;
//        }
//
//        // Getters
//        public String getSpeciality() { return speciality; }
//        public String getDoctorName() { return doctorName; }
//        public String getAppointmentType() { return appointmentType; }
//        public String getAppointmentDuration() { return appointmentDuration; }
//        public String getDate() { return date; }
//        public String getTimeSlot() { return timeSlot; }
//    }
//
//        public ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
//
//        @Override
//        public void initialize(URL location, ResourceBundle resources) {
//            // Set up TableView columns
//            ClnSp.setCellValueFactory(new PropertyValueFactory<>("speciality"));
//            ClnName.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
//            ClnType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
//            ClnDur.setCellValueFactory(new PropertyValueFactory<>("appointmentDuration"));
//            ClnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
//            ClnTimeSlot.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
//
//            // Load appointments from the database
//            loadAppointments();
//        }
//
//        public void loadAppointments() {
//            String jdbcUrl = "jdbc:mysql://localhost:3306/healthflow"; // Adjust your database URL
//            String username = "yourUsername"; // Your DB username
//            String password = "yourPassword"; // Your DB password
//
//            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//                 Statement statement = connection.createStatement()) {
//
//                String query = "SELECT speciality, doctorName, appointmentType, appointmentDuration, date, timeSlot FROM appointment";
//                ResultSet resultSet = statement.executeQuery(query);
//
//                while (resultSet.next()) {
//                    String speciality = resultSet.getString("speciality");
//                    String doctorName = resultSet.getString("doctorName");
//                    String appointmentType = resultSet.getString("appointmentType");
//                    String appointmentDuration = resultSet.getString("appointmentDuration");
//                    String date = resultSet.getString("date");
//                    String timeSlot = resultSet.getString("timeSlot");
//
//                    // Create a new Appointment object and add it to the list
//                    Appointment appointment = new Appointment(speciality, doctorName, appointmentType, appointmentDuration, date, timeSlot);
//                    appointmentList.add(appointment);
//                }
//
//                // Set the data in the TableView
//                tblvAppTable.setItems(appointmentList);
//
//            } catch (Exception e) {
//                e.printStackTrace(); // Handle exceptions appropriately in production code
//            }
//        }
//    }
package com.example.healthflow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class UpdateAppointmentsController implements Initializable {

    @FXML
    public TableColumn<Appointment, String> ClnDate;

    @FXML
    public TableColumn<Appointment, String> ClnDur;

    @FXML
    public TableColumn<Appointment, String> ClnName;

    @FXML
    public TableColumn<Appointment, String> ClnSp;

    @FXML
    public TableColumn<Appointment, String> ClnTimeSlot;

    @FXML
    public TableColumn<Appointment, String> ClnType;

    @FXML
    public MenuItem DoctorTab;

    @FXML
    public MenuItem PatientTab;

    @FXML
    public MenuItem StaffTab;

    @FXML
    public AnchorPane ankrDashboard;

    @FXML
    public Button btnAppointment;

    @FXML
    public Button btnBack;

    @FXML
    public Button btnBilling;

    @FXML
    public Button btnClinicalManagement;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnHome;

    @FXML
    public Button btnUpdate1;

    @FXML
    public Button btnUser;

    @FXML
    public ImageView imgvSearch;

    @FXML
    public ImageView imgvUser;

    @FXML
    public Label lblDashboard;

    @FXML
    public Label lblUpdateAppointment;

    @FXML
    public MenuButton mnuBtnRegistration;

    @FXML
    public TableView<Appointment> tblvAppTable;

    @FXML
    public VBox vbxDashboard;

    @FXML
    public VBox vbxUser;

    public ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up TableView columns
        ClnSp.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        ClnName.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        ClnType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        ClnDur.setCellValueFactory(new PropertyValueFactory<>("appointmentDuration"));
        ClnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        ClnTimeSlot.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));

        // Load appointments from the database
        loadAppointments();
    }
    public void handleSort() {
        // Logic for handling sort event
        System.out.println("Table sorted!");
        // Implement any sorting logic here if needed
    }

    public void loadAppointments() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/healthflow"; // Adjust your database URL
        String username = "root"; // Your DB username
        String password = "12345678"; // Your DB password

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT speciality, doctorName, appointmentType, appointmentDuration, date, timeSlot FROM appointment";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String speciality = resultSet.getString("speciality");
                String doctorName = resultSet.getString("doctorName");
                String appointmentType = resultSet.getString("appointmentType");
                String appointmentDuration = resultSet.getString("appointmentDuration");
                String date = resultSet.getString("date");
                String timeSlot = resultSet.getString("timeSlot");

                // Create a new Appointment object and add it to the list
                Appointment appointment = new Appointment(speciality, doctorName, appointmentType, appointmentDuration, date, timeSlot);
                appointmentList.add(appointment);
            }

            // Set the data in the TableView
            tblvAppTable.setItems(appointmentList);

        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately in production code
        }
    }

    // Other methods...

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

//    @FXML
//    public void handleUpdateButtonClick() throws IOException {
//        switchScene("UpdateAppointments.fxml");
//    }

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
        Stage stage = (Stage) ankrDashboard.getScene().getWindow();
        Scene homePageScene = new Scene(homePageRoot);
        stage.setScene(homePageScene);
        stage.show();
    }

    public static class Appointment {
        public String speciality;
        public String doctorName;
        public String appointmentType;
        public String appointmentDuration;
        public String date;
        public String timeSlot;

        public Appointment(String speciality, String doctorName, String appointmentType, String appointmentDuration, String date, String timeSlot) {
            this.speciality = speciality;
            this.doctorName = doctorName;
            this.appointmentType = appointmentType;
            this.appointmentDuration = appointmentDuration;
            this.date = date;
            this.timeSlot = timeSlot;
        }

        // Getters
        public String getSpeciality() { return speciality; }
        public String getDoctorName() { return doctorName; }
        public String getAppointmentType() { return appointmentType; }
        public String getAppointmentDuration() { return appointmentDuration; }
        public String getDate() { return date; }
        public String getTimeSlot() { return timeSlot; }
    }
}
