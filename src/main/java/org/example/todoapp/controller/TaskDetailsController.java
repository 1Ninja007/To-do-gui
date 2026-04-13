package org.example.todoapp.controller;

//import com.mysql.cj.protocol.a.UtilDateValueEncoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.todoapp.MainApp;
import org.example.todoapp.Task;

import java.io.IOException;
import java.util.Objects;

public class TaskDetailsController {
    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label priorityLabel;

    @FXML
    private Button returnButtonaddButton;

    @FXML
    private Label titleLabel;

    @FXML
    private AnchorPane tloAnchorPane;

    @FXML
    void initialize() {
        dateLabel.setMaxWidth(100.0);
        descriptionLabel.setMaxWidth(100.0);
        priorityLabel.setMaxWidth(100.0);
        titleLabel.setMaxWidth(100.0);
        AnchorPane.setLeftAnchor(dateLabel, 200.0);
        AnchorPane.setRightAnchor(dateLabel, 200.0);
        AnchorPane.setLeftAnchor(descriptionLabel, 200.0);
        AnchorPane.setRightAnchor(descriptionLabel, 200.0);
        AnchorPane.setLeftAnchor(priorityLabel, 200.0);
        AnchorPane.setRightAnchor(priorityLabel, 200.0);
        AnchorPane.setLeftAnchor(titleLabel, 200.0);
        AnchorPane.setRightAnchor(titleLabel, 200.0);
        dateLabel.setAlignment(Pos.CENTER);
//        descriptionLabel.setAlignment(Pos.CENTER);
        priorityLabel.setAlignment(Pos.CENTER);
        titleLabel.setAlignment(Pos.CENTER);
    }

    @FXML
    void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApp.class.getResource("tasks_view.fxml")));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 450);
        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void displayDetails(Task t){
        titleLabel.setText(t.getTitle());
        descriptionLabel.setText(t.getDescription());
        dateLabel.setText(t.getDateInString());
        priorityLabel.setText(t.getPriority());
    }
}
