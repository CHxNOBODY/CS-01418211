package ku.cs.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ku.cs.demo.models.Student;
import ku.cs.demo.models.StudentList;
import ku.cs.demo.services.Datasource;
import ku.cs.demo.services.FXComponent;
import ku.cs.demo.services.StudentListFileDatasource;

import java.io.IOException;

public class StudentGridViewController {
    @FXML private ScrollPane studentListScrollPane;
    @FXML private ComboBox<String> filterComboBox;
    @FXML private TextField filterTextField;

    private Datasource<StudentList> datasource;
    private StudentList studentList;

    @FXML
    public void initialize(){
        datasource = new StudentListFileDatasource("data", "student-list.csv");
        studentList = datasource.readData();

        setUpComboBox();
        showGrid(studentList);
    }

    private void setUpComboBox() {
        filterComboBox.getItems().addAll("ID", "Name");
        filterComboBox.getSelectionModel().select(0);
    }

    private void showGrid(StudentList studentList){
        try {
            VBox vBox = new VBox();
            vBox.setSpacing(10);

            for(Student student : studentList.getStudents()){
                FXComponent.addTo(vBox, "student-component", student);
            }

            studentListScrollPane.setContent(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSearchButton() {
        String filterBy = filterComboBox.getValue();
        String filterText = filterTextField.getText();
        if (filterText.isBlank()) {
            showGrid(studentList);
        } else {
            if (filterBy.equals("ID")) {
                StudentList filterList = studentList.filterById(filterText);
                showGrid(filterList);
            } else if (filterBy.equals("Name")) {
                StudentList filterList = studentList.filterByName(filterText);
                showGrid(filterList);
            }
        }
    }
}
