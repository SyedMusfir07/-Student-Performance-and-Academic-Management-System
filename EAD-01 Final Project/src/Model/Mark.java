package Model;

public class Mark {
    private int id;
    private int studentId;
    private String subject;
    private int marks;
    private String grade;

    public Mark(int id, int studentId, String subject, int marks, String grade) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setId(int id) { this.id = id; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setMarks(int marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }
}
