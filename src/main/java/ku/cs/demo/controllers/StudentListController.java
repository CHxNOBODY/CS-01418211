package ku.cs.demo.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.demo.models.Student;
import ku.cs.demo.models.StudentList;
import ku.cs.demo.services.StudentHardCodeDatasource;

public class StudentListController {
    @FXML private ListView<Student> studentListView;
    @FXML private Label idLabel;
    @FXML private Label nameLabel;
    @FXML private Label scoreLabel;

    @FXML private Label errorLabel;
    @FXML private TextField giveScoreTextField;

    private StudentList studentList;
    private Student selectedStudent;

    @FXML
    public void initialize() {
        clearStudentInfo();
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        studentList = datasource.readData();
        showList(studentList);
        studentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                if (newValue == null) {
                    clearStudentInfo();
                    selectedStudent = null;
                } else {
                    showStudentInfo(newValue);
                    selectedStudent = newValue;
                }
            }
        });
    }

    private void showList(StudentList studentList) {
        studentListView.getItems().clear();
        studentListView.getItems().addAll(studentList.getStudents());
    }

    private void showStudentInfo(Student student) {
        idLabel.setText(student.getId());
        nameLabel.setText(student.getName());
        scoreLabel.setText(String.format("%.2f", student.getScore()));
    }

    @FXML
    public void onGiveScoreButtonClick(){
        if (selectedStudent != null) {
            String scoreText = giveScoreTextField.getText();
            String errorMassage = "";

            try {
                double score = Double.parseDouble(scoreText);
                selectedStudent.addScore(score);
                showStudentInfo(selectedStudent);
            } catch (NumberFormatException e) {
                errorMassage = "Please enter a number";
            } finally {
                if (errorMassage.equals("")) {
                    errorLabel.setText("");
                    giveScoreTextField.clear();
                } else {
                    errorLabel.setText(errorMassage);
                }
            }
        } else {
            errorLabel.setText("Please select a student");
        }
    }

    private void clearStudentInfo() {
        idLabel.setText("");
        nameLabel.setText("");
        scoreLabel.setText("");
    }
}