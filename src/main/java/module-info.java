module com.example.projectcode {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectcode to javafx.fxml;
    exports com.example.projectcode;
    exports com.example.projectcode.CONTROLLER;
    opens com.example.projectcode.CONTROLLER to javafx.fxml;
    exports com.example.projectcode.FACTORY;
    opens com.example.projectcode.FACTORY to javafx.fxml;
}