package Model;


public class Student {
    private int id;
    private String name;
    private String email;
    private String grade;

    public Student(int id, String name, String email, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getGrade() { return grade; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGrade(String grade) { this.grade = grade; }
}

