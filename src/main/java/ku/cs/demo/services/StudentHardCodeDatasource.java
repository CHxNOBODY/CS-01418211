package ku.cs.demo.services;

import ku.cs.demo.models.StudentList;

public class StudentHardCodeDatasource {
    public StudentList readData() {
        StudentList list = new StudentList();
        list.addNewStudent("6410400001", "First");
        list.addNewStudent("6410400002", "Second");
        list.addNewStudent("6410400003", "Third");
        list.addNewStudent("6410400004", "Fourth");
        list.addNewStudent("6710451178", "Pun");
        return list;
    }
}