package org.example.todoapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.todoapp.MainApp;
import org.example.todoapp.Task;

import java.io.IOException;
import java.util.Objects;

public class TasksController {

    @FXML
    private Button addButton;
    @FXML
    private Button deleteTaskButton;

    @FXML
    private CheckBox doneTaskCheck;

    @FXML
    private Label taskTitle;

    @FXML
    private TableView<Task> tasksTableView;
//
//    public ObservableList<Task> tasksList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        var titleColumn = new TableColumn<Task, String>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));

//        var descriptionColumn = new TableColumn<Task, String>("Description");
//        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));

        var priorityColumn = new TableColumn<Task, String>("Priority");
        priorityColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("priority"));

        var dateColumn = new TableColumn<Task, String>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("dateInString"));

        var doneColumn = new TableColumn<Task, CheckBox>("Done");
        doneColumn.setCellValueFactory(new PropertyValueFactory<Task, CheckBox>("done"));

        tasksTableView.setItems(MainApp.taskService.getTasksList());


        tasksTableView.getColumns().add(titleColumn);
//        tasksTableView.getColumns().add(descriptionColumn);
        tasksTableView.getColumns().add(dateColumn);
        tasksTableView.getColumns().add(priorityColumn);
        tasksTableView.getColumns().add(doneColumn);
    };

    public void onAddButtonClick(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("add_task_view.fxml"));

        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApp.class.getResource("add_task_view.fxml")));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void onDeleteTaskButtonClick(ActionEvent Event) {
        Task selectedTask = tasksTableView.getSelectionModel().getSelectedItem();

        MainApp.taskService.removeTask(selectedTask);
    }

    public void onShowDetailsButtonClick(ActionEvent event) throws IOException {
        Task selectedTask = tasksTableView.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("task_details_view.fxml"));
        Parent root = loader.load();

        TaskDetailsController taskDetailsController = loader.getController();
        taskDetailsController.displayDetails(selectedTask);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
