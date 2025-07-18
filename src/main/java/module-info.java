module ku.cs.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.demo to javafx.fxml;
    exports ku.cs.demo;
    exports ku.cs.demo.controllers;
    opens ku.cs.demo.controllers to javafx.fxml;
}