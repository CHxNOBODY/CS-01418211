package ku.cs.demo.models;

public class Student {
    private String id;
    private String name;
    private double score;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
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

    public void addScore(double score) {
        this.score += score;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
