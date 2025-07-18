package ku.cs.demo.models;

import java.util.ArrayList;
// java don't need to import package java.lang
public class StudentList {
    private ArrayList<Student> students;

    public StudentList(){
        students = new ArrayList<Student>(); // ด้านใน <> ไม่จำเป็นต้องมี type ก็ได้
    }

    public void addNewStudent(String id, String name){
        id = id.trim();
        name = name.trim();
        if (!name.equals("") && !id.equals("")) {
            Student exist = findStudentById(id);
            if (exist == null) { // อันนี้คือหาไม่เจอ
                students.add(new Student(id, name));
            }
        }
    }

    public Student findStudentById(String id) {
        // for singular in plural
        // for item in list
        for (Student student : students) {
            if (student.isId(id)){  // if (student.getId().equal(id) )
                return student;
            }
        }
        return null;
    }

    public void giveScoreToId(String id, double score){
        Student exist = findStudentById(id);
        if (exist != null) { // อันนี้คือหาเจอ
            exist.addScore(score);  //  if(score > 0) exist.getScore(exit.getScore() + score)
        }
    }

    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();   // return exist.getScore() >= 90 ? "A": exist.getScore() >= 87 ? "B+":
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
