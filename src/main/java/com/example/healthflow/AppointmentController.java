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

import java.io.IOException;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class AppointmentController {

    @FXML
    public MenuItem DoctorTab, PatientTab, StaffTab;
    @FXML
    public AnchorPane ankrAvailability, ankrChooseDoctor, ankrDashboard, ankrDashboard2, ankrDetails, ankrMain, ankrOthers, ankrTitle;
    @FXML
    public Button btnAppointment, btnBack, btnBilling, btnBook, btnClearAll, btnClinicalManagement, btnHome, btnUser;
    @FXML
    public ComboBox<String> cmbxAppointmentDuration, cmbxAppointmentType, cmbxDoctorName, cmbxSpeciality;
    @FXML
    public ImageView imgvUser;
    @FXML
    public Label lblAppointment, lblAppointmentDuration, lblAppointmentDuration1, lblAppointmentType, lblAvailability, lblBedNo, lblChooseDoctor, lblDashboard, lblDate, lblDetails, lblID, lblName, lblOthers, lblPatientID, lblSpeciality, lblTimeSlot;
    @FXML
    public MenuButton mnuBtnRegistration;
    @FXML
    public TextField txtfBedNo, txtfDoctorID, txtfPatientID;
    @FXML
    public VBox vbxDashboard, vbxUser;
    @FXML
    public ComboBox<String> cmbxTimeSlot;
    @FXML
    public DatePicker dtpkrAppointmentDate;

    // Connection details (ensure they are set correctly)
    public static final String DB_URL = "jdbc:mysql://localhost:3306/healthflow";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "12345678";

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

    @FXML
    public void initialize() {
        // Initialize Appointment Duration and Type ComboBoxes
//        cmbxAppointmentDuration.getItems().addAll("30 ", "1 ", "1.5 ", "2 ");
        cmbxAppointmentType.getItems().addAll("New Consultation", "Follow-Up", "Routine Check-Up");

        // Initialize Time Slot ComboBox with predefined times
        cmbxTimeSlot.getItems().addAll("09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM");

        // Specialty change event to load corresponding doctors
        cmbxSpeciality.setOnAction(event -> handleSpecialityChange());
        cmbxDoctorName.setOnAction(event -> handleDoctorNameChange());
    }

    @FXML
    public void handleSpecialityChange() {
        String selectedSpeciality = cmbxSpeciality.getValue();
        if (selectedSpeciality != null) {
            String query = "SELECT DoctorId, Firstname FROM doctor WHERE Speciality = ?";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, selectedSpeciality);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Clear the previous data
                cmbxDoctorName.getItems().clear();
                txtfDoctorID.clear();

                // Load doctors for the selected specialty
                while (resultSet.next()) {
                    String doctorName = resultSet.getString("Firstname");
                    cmbxDoctorName.getItems().add(doctorName);
                }

                if (cmbxDoctorName.getItems().isEmpty()) {
                    System.out.println("No doctors found for the selected specialty.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error retrieving doctors: " + e.getMessage());
            }
        }
    }

    @FXML
    public void handleDoctorNameChange() {
        String selectedDoctorName = cmbxDoctorName.getValue();

        if (selectedDoctorName != null) {
            String query = "SELECT DoctorId FROM doctor WHERE Firstname = ?";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, selectedDoctorName);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String doctorID = resultSet.getString("DoctorId");
                    txtfDoctorID.setText(doctorID);
                } else {
                    txtfDoctorID.clear();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error retrieving doctor ID: " + e.getMessage());
            }
        }
    }

    public void handleBookAppointment() {
        // Get user input from the form
        String patientId = txtfPatientID.getText().trim();
        String doctorId = txtfDoctorID.getText();
        String doctorName = cmbxDoctorName.getValue();
        String speciality = cmbxSpeciality.getValue();
        String appointmentType = cmbxAppointmentType.getValue();
        String appointmentDuration = cmbxAppointmentDuration.getValue();
        String timeSlotInput = cmbxTimeSlot.getValue();
        String appointmentDate = dtpkrAppointmentDate.getValue() != null ? dtpkrAppointmentDate.getValue().toString() : "";

        // Check for empty fields
        if (patientId.isEmpty() || doctorId.isEmpty() || doctorName == null || speciality == null ||
                appointmentType == null || appointmentDuration == null ||
                timeSlotInput == null || appointmentDate.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        // Parse and format the time slot
        String formattedTimeSlot = "";
        boolean isValidTimeFormat = false;

        String regex12Hour = "^([1-9]|1[0-2]):[0-5][0-9] [APap][mM]$";
        String regex24Hour = "^(2[0-3]|[01]?[0-9]):[0-5][0-9]$";

        try {
            if (timeSlotInput.matches(regex12Hour)) {
                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("h:mm a"));
                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                isValidTimeFormat = true;
            } else if (timeSlotInput.matches(regex24Hour)) {
                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("HH:mm"));
                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                isValidTimeFormat = true;
            } else {
                System.out.println("Invalid time format. Please enter time in 'h:mm a' or 'HH:mm' format.");
                return;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing time: " + e.getMessage());
            return;
        }

        // SQL query to insert appointment details into the database
        String query = "INSERT INTO appointment (patient_id, doctor_id, doctor_name, speciality, appointment_type, appointment_duration, time_slot, appointment_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameters for the query
            preparedStatement.setString(1, patientId);
            preparedStatement.setString(2, doctorId);
            preparedStatement.setString(3, doctorName);
            preparedStatement.setString(4, speciality);
            preparedStatement.setString(5, appointmentType);
            preparedStatement.setString(6, appointmentDuration);
            preparedStatement.setString(7, formattedTimeSlot);
            preparedStatement.setString(8, appointmentDate);

            // Execute the query
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Appointment booked successfully.");
            } else {
                System.out.println("Failed to book the appointment.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error booking appointment: " + e.getMessage());
        }
    }

    public void handleClearAll() {
        txtfPatientID.clear();
        txtfDoctorID.clear();
        cmbxDoctorName.getSelectionModel().clearSelection();
        cmbxSpeciality.getSelectionModel().clearSelection();
        cmbxAppointmentType.getSelectionModel().clearSelection();
        cmbxAppointmentDuration.getSelectionModel().clearSelection();
        cmbxTimeSlot.getSelectionModel().clearSelection();
        dtpkrAppointmentDate.setValue(null);
    }
}

//    public void handleBookAppointment() {
//        // Get user input from the form
//        String patientId = txtfPatientID.getText().trim();
//        String doctorId = txtfDoctorID.getText();
//        String doctorName = cmbxDoctorName.getValue();
//        String speciality = cmbxSpeciality.getValue();
//        String appointmentType = cmbxAppointmentType.getValue();
//        String appointmentDuration = cmbxAppointmentDuration.getValue();
//        String timeSlotInput = cmbxTimeSlot.getValue();
//        String appointmentDate = dtpkrAppointmentDate.getValue() != null ? dtpkrAppointmentDate.getValue().toString() : "";
//
//        // Check for empty fields
//        if (patientId.isEmpty() || doctorId.isEmpty() || doctorName == null || speciality == null ||
//                appointmentType == null || appointmentDuration == null ||
//                timeSlotInput == null || appointmentDate.isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, "Missing Fields", "Please fill in all fields.");
//            return;
//        }
//
//        // Parse and format the time slot
//        String formattedTimeSlot = "";
//        boolean isValidTimeFormat = false;
//
//        String regex12Hour = "^([1-9]|1[0-2]):[0-5][0-9] [APap][mM]$";
//        String regex24Hour = "^(2[0-3]|[01]?[0-9]):[0-5][0-9]$";
//
//        try {
//            if (timeSlotInput.matches(regex12Hour)) {
//                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("h:mm a"));
//                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//                isValidTimeFormat = true;
//            } else if (timeSlotInput.matches(regex24Hour)) {
//                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("HH:mm"));
//                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//                isValidTimeFormat = true;
//            } else {
//                showAlert(Alert.AlertType.ERROR, "Invalid Time Format", "Please enter time in 'h:mm a' or 'HH:mm' format.");
//                return;
//            }
//        } catch (DateTimeParseException e) {
//            showAlert(Alert.AlertType.ERROR, "Time Parse Error", "Error parsing time: " + e.getMessage());
//            return;
//        }
//
//        // SQL query to insert appointment details into the database
//        String query = "INSERT INTO appointment (patient_id, doctor_id, doctor_name, speciality, appointment_type, appointment_duration, time_slot, appointment_date) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            // Set the parameters for the query
//            preparedStatement.setString(1, patientId);
//            preparedStatement.setString(2, doctorId);
//            preparedStatement.setString(3, doctorName);
//            preparedStatement.setString(4, speciality);
//            preparedStatement.setString(5, appointmentType);
//            preparedStatement.setString(6, appointmentDuration);
//            preparedStatement.setString(7, formattedTimeSlot);
//            preparedStatement.setString(8, appointmentDate);
//
//            // Execute the query
//            int result = preparedStatement.executeUpdate();
//
//            if (result > 0) {
//                showAlert(Alert.AlertType.INFORMATION, "Success", "Appointment booked successfully.");
//            } else {
//                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to book the appointment.");
//            }
//        } catch (SQLException e) {
//            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error booking appointment: " + e.getMessage());
//        }
//    }

//    @FXML
//    public TextField txtfAppoinmentNumber; // Ensure you have this field in your FXML
//
//    public void handleBookAppointment() {
//        // Get user input from the form
//        String patientId = txtfPatientID.getText().trim();
//        String doctorId = txtfDoctorID.getText();
//        String doctorName = cmbxDoctorName.getValue();
//        String speciality = cmbxSpeciality.getValue();
//        String appointmentType = cmbxAppointmentType.getValue();
//        String appointmentDuration = cmbxAppointmentDuration.getValue();
//        String timeSlotInput = cmbxTimeSlot.getValue();
//        String appointmentDate = dtpkrAppointmentDate.getValue() != null ? dtpkrAppointmentDate.getValue().toString() : "";
//
//        // Check for empty fields
//        if (patientId.isEmpty() || doctorId.isEmpty() || doctorName == null || speciality == null ||
//                appointmentType == null || appointmentDuration == null ||
//                timeSlotInput == null || appointmentDate.isEmpty()) {
//            System.out.println("Please fill in all fields.");
//            return;
//        }
//
//        // Parse and format the time slot
//        String formattedTimeSlot = "";
//        boolean isValidTimeFormat = false;
//
//        String regex12Hour = "^([1-9]|1[0-2]):[0-5][0-9] [APap][mM]$";
//        String regex24Hour = "^(2[0-3]|[01]?[0-9]):[0-5][0-9]$";
//
//        try {
//            if (timeSlotInput.matches(regex12Hour)) {
//                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("h:mm a"));
//                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//                isValidTimeFormat = true;
//            } else if (timeSlotInput.matches(regex24Hour)) {
//                LocalTime time = LocalTime.parse(timeSlotInput, DateTimeFormatter.ofPattern("HH:mm"));
//                formattedTimeSlot = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//                isValidTimeFormat = true;
//            } else {
//                System.out.println("Invalid time format. Please enter time in 'h:mm a' or 'HH:mm' format.");
//                return;
//            }
//        } catch (DateTimeParseException e) {
//            System.out.println("Error parsing time: " + e.getMessage());
//            return;
//        }
//
//        // SQL query to insert appointment details into the database
//        String query = "INSERT INTO appointment (patient_id, doctor_id, doctor_name, speciality, appointment_type, appointment_duration, time_slot, appointment_date) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//
//            // Set the parameters for the query
//            preparedStatement.setString(1, patientId);
//            preparedStatement.setString(2, doctorId);
//            preparedStatement.setString(3, doctorName);
//            preparedStatement.setString(4, speciality);
//            preparedStatement.setString(5, appointmentType);
//            preparedStatement.setString(6, appointmentDuration);
//            preparedStatement.setString(7, formattedTimeSlot);
//            preparedStatement.setString(8, appointmentDate);
//
//            // Execute the query
//            int result = preparedStatement.executeUpdate();
//
//            if (result > 0) {
//                System.out.println("Appointment booked successfully.");
//
//                // Get the generated appointment number
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    int appointmentNo = generatedKeys.getInt(1);
//                    txtfAppoinmentNumber.setText(String.valueOf(appointmentNo)); // Display the appointment number
//                }
//            } else {
//                System.out.println("Failed to book the appointment.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error booking appointment: " + e.getMessage());
//        }
//    }
//
//
//    public void handleClearAll() {
//        txtfPatientID.clear();
//        txtfDoctorID.clear();
//        cmbxDoctorName.getSelectionModel().clearSelection();
//        cmbxSpeciality.getSelectionModel().clearSelection();
//        cmbxAppointmentType.getSelectionModel().clearSelection();
//        cmbxAppointmentDuration.getSelectionModel().clearSelection();
//        cmbxTimeSlot.getSelectionModel().clearSelection();
//        dtpkrAppointmentDate.setValue(null);
//
//        showAlert(Alert.AlertType.INFORMATION, "Form Cleared", "All fields have been cleared.");
//
//
//        // After successfully booking the appointment, retrieve the new appointment number
//        String newAppointmentNo = getNextAppointmentNumber(); // Implement logic to fetch the new appointment number
//        txtfAppoinmentNumber.setText(newAppointmentNo); // Display the new appointment number
//    }
//
//
//
//    public String getNextAppointmentNumber() {
//        String query = "SELECT MAX(appointment_id) FROM appointment"; // assuming appointment_id is an auto-increment column
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//
//            if (resultSet.next()) {
//                int lastAppointmentNo = resultSet.getInt(1);
//                return String.valueOf(lastAppointmentNo + 1); // Increment by 1 for the next appointment number
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error retrieving appointment number: " + e.getMessage());
//        }
//        return "1"; // default to 1 if no appointment exists
//    }
//    // Method to display Alert dialogs
//    private void showAlert(Alert.AlertType alertType, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}


