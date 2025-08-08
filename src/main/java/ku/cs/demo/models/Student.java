package ku.cs.demo.models;

public class Student {
    private String id;
    private String name;
    private double score;
    private String grade;

    public Student(String id, String name) {
        this(id, name, 0);
    }


    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.grade = grading();
    }

    public void changeName(String name) {
        if (!name.trim().equals("")) {
            this.name = name.trim();
        }

        // trim = strip() in python
    }



    public void addScore(double score) {
        if (score > 0) {
            this.score += score;
        }
    }

    // TODO: design grading system for Student
    public String grade()
    {
        return "F";
    }

    public boolean isId(String id) {
        return this.id.equals(id);  // object/reference type เปรียบเทียบเท่ากันด้วย method .equals() ex. String
                                    // interface Comparable, Comparator

        // return this.id == id;    // primitive type เปรียบเทียบเท่ากัน ด้วย operator ==
                                    // null เปรียบเทียบด้วย ==
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", score: " + score +
                '}';
    }

    public String grading() {
        if (score >= 80) {
            grade = "A";
        } else if (score >= 70) {
            grade = "B";
        } else if (score >= 60) {
            grade = "C";
        } else if (score >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public boolean isIdContains(String id) {
        return this.id.contains(id);
    }

    public boolean isNameContains(String name) {
        return this.name.toLowerCase().contains(name.toLowerCase());
    }
}