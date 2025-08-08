package ku.cs.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ku.cs.demo.services.FXComponent;
import ku.cs.demo.services.FXRouter;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        configRouters();
        registerComponents();

        FXRouter.bind(this, stage, "01418211 Software Construction");
        FXRouter.goTo("student-grid-view");
    }

    private void configRouters() {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("student-profile", viewPath + "student.fxml");
        FXRouter.when("student-list", viewPath + "student-list.fxml");
        FXRouter.when("students-table",  viewPath + "students-table.fxml");
        FXRouter.when("student-score", viewPath + "student-score.fxml");
        FXRouter.when("student-grid-view", viewPath + "student-grid-view.fxml");
    }

    private void registerComponents() {
        String componentPath = "ku/cs/components/";
        FXComponent.register("student-component", componentPath + "student-component.fxml");
    }

    public static void main(String[] args) {

        launch();
    }
}