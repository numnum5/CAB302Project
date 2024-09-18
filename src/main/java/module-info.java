module com.example.cab302project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires org.xerial.sqlitejdbc;
    requires org.junit.jupiter.api;

    opens com.example.cab302project to javafx.fxml;
    exports com.example.cab302project;
    exports com.example.cab302project.controller;
    opens com.example.cab302project.controller to javafx.fxml;
}