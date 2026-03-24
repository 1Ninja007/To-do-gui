package org.example.todoapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.example.todoapp.MainApp;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainViewController {
    @FXML
    private AnchorPane background;

    @FXML
    private Button showTasksButton;

    @FXML
    private TableView<?> testTableView;

    @FXML
    private AnchorPane titleBackground;

    @FXML
    private Label titleLabel;

    @FXML
    void initialize() {

    }

    public void onShowTasksButtonClick(javafx.event.ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("tasks_view.fxml"));

        Parent root = FXMLLoader.load(MainApp.class.getResource("tasks_view.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
