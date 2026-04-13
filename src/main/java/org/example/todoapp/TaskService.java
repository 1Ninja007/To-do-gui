package org.example.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskService {
    private final ObservableList<Task> tasksList = FXCollections.observableArrayList();

    public void addTask(Task t){
        this.tasksList.add(t);
    }

    public void removeTask(Task t){
        this.tasksList.remove(t);
    }

    public ObservableList<Task> getTasksList() {
        return tasksList;
    }
}
