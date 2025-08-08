package ku.cs.demo.models;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addNewStudent(String id, String name) {
        id = id.trim();
        name = name.trim();
        if(!id.equals("") && !name.equals("")){
            Student exist = findStudentById(id);
            if(exist == null){
                students.add(new Student(id, name));
            }
        }
    }

    public void addNewStudent(String id, String name, double score) {
        id = id.trim();
        name = name.trim();
        if(!id.equals("") && !name.equals("")){
            Student exist = findStudentById(id);
            if(exist == null){
                students.add(new Student(id, name, score));
            }
        }
    }

    public Student findStudentById(String id){
        for(Student student : students){
            if(student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if(exist != null){
            exist.addScore(score);
        }
    }


    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grading();
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public StudentList filterById(String id) {
        StudentList filterList = new StudentList();
        for(Student student : students){
            if (student.isIdContains(id)) {
                filterList.students.add(student);
            }
        }

        return filterList;
    }

    public StudentList filterByName(String name) {
        StudentList filterList = new StudentList();
        for (Student student : students) {
            if (student.isNameContains(name)) {
                filterList.students.add(student);
            }
        }

        return filterList;
    }
}