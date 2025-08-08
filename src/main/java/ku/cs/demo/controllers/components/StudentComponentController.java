package ku.cs.demo.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.demo.models.Student;
import ku.cs.demo.services.FXComponent;
import ku.cs.demo.services.FXRouter;

import java.io.IOException;

public class StudentComponentController implements FXComponent.ComponentController {
    @FXML private Label idLabel;
    @FXML private Label nameLabel;
    @FXML private Label scoreLabel;
    @FXML private Label gradeLabel;

    private Student student;

    @Override
    public void receiveData(Object data) {
        student = (Student) data; // narrowing casting
        displayStudent();
    }

    private void displayStudent() {
        if(student != null) {
            idLabel.setText(student.getId());
            nameLabel.setText(student.getName());
            scoreLabel.setText(String.format("%.2f", student.getScore()));
            gradeLabel.setText(student.getGrade());
        } else {
            clearDisplay();
        }
    }

    private void clearDisplay() {
        idLabel.setText("");
        nameLabel.setText("");
        scoreLabel.setText("");
        gradeLabel.setText("");
    }

    @FXML
    public void handleAddScoreButton() {
        try {
            FXRouter.goTo("student-score", student.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
