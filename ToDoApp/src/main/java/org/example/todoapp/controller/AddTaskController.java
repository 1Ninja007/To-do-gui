package org.example.todoapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.todoapp.MainApp;
import org.example.todoapp.Task;
import org.example.todoapp.TaskService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {
    public DatePicker datePicker;

    @FXML
    private Button addButton;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ChoiceBox<String> priorityChoiceBox;

    private String[] priority = {"LOW", "MEDIUM", "HIGH"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        priorityChoiceBox.getItems().addAll(priority);
    }

    @FXML
    private TextField titleTextField;

    @FXML
    void initialize() {

    }

    public LocalDate getDate() {
        LocalDate date = datePicker.getValue();

//        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return date;
    }

    public void onAddTaskButtonClick(ActionEvent event) throws IOException {

//        TasksController.addTask(new Task(titleTextField.getText(), descriptionTextArea.getText(), getDate(), priorityChoiceBox.getValue()));

//        Parent root = FXMLLoader.load(MainApp.class.getResource("tasks_view.fxml"));

        if (titleTextField.getText() == null || titleTextField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Title warning");
            alert.setHeaderText(null);
            alert.setContentText("Title is required");

            alert.showAndWait();
            return;
        }

        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("tasks_view.fxml"));
        Parent root = loader.load();

//        MainViewController mainViewController = loader.getController();

        MainApp.taskService.addTask(new Task(titleTextField.getText(), descriptionTextArea.getText(), getDate(), priorityChoiceBox.getValue()));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
