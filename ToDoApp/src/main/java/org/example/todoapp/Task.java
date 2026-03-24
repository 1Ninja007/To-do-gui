package org.example.todoapp;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private String description;
    private LocalDate date;
    private String dateInString;
    private String priority;
    private CheckBox done;

    public Task(String title, String description, LocalDate date, String priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        if(this.date != null) {
            this.dateInString = this.date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        this.priority = priority;
        this.done = new CheckBox();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateInString() {
        return dateInString;
    }

    public void setDateInString(String dateInString) {
        this.dateInString = dateInString;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public CheckBox getDone() {
        return done;
    }

    public void setDone(CheckBox done) {
        this.done = done;
    }
}