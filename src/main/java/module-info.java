module org.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires jdk.compiler;
//    requires org.example.todoapp;
//    requires mysql.connector.j;


    opens org.example.todoapp to javafx.fxml;
    exports org.example.todoapp;
    exports org.example.todoapp.controller;
    opens org.example.todoapp.controller to javafx.fxml;
}