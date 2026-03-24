package org.example.todoapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.todoapp.controller.TasksController;

import javax.swing.border.Border;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class MainApp extends Application {
//    public static ObservableList<Task> taskServce;
    public static TaskService taskService = new TaskService();

//    public ObservableList<Task> tasksList = null;
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("To do app");
        stage.setScene(scene);
        stage.show();
    }
}
