package ku.cs.demo.controllers;

// ku.cs.demo.controllers.StudentController

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.demo.models.Student;
import ku.cs.demo.services.FXRouter;

import java.io.IOException;

public class StudentController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    public void initialize(){
        Student student = new Student("6710451178", "Pun");
        student.addScore(100.45);

        showStudent(student);
    }

    private void showStudent(Student student){
        nameLabel.setText(student.getName());
        idLabel.setText(student.getId());
        scoreLabel.setText(String.format("%.2f", student.getScore()));
    }

    @FXML
    protected void onBackButtonClick(){
        System.out.println("Back button clicked");
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
