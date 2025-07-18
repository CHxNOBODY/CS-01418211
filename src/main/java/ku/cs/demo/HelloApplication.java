package ku.cs.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ku.cs.demo.services.FXRouter;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        configRouters();
        FXRouter.bind(this, stage, "01418211 Software Construction");
        FXRouter.goTo("student-list");
    }

    private void configRouters() {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("student-profile", viewPath + "student.fxml");
        FXRouter.when("student-list", viewPath + "student-list.fxml");
    }

    public static void main(String[] args) {

        launch();
    }
}