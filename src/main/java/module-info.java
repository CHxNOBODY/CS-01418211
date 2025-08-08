module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.desktop;


    opens ku.cs.demo to javafx.fxml;
    exports ku.cs.demo;
    exports ku.cs.demo.controllers;
    opens ku.cs.demo.controllers to javafx.fxml;
    exports ku.cs;
    opens ku.cs to javafx.fxml;

    exports ku.cs.demo.models;
    opens ku.cs.demo.models to javafx.base;

    exports ku.cs.demo.controllers.components;
    opens ku.cs.demo.controllers.components to javafx.fxml;
}