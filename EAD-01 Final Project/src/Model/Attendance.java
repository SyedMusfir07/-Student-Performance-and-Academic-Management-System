package Model;

import java.sql.Date;

public class Attendance {
    private int id;
    private int studentId;
    private Date date;
    private String status;

    public Attendance(int id, int studentId, Date date, String status) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setDate(Date date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
}
