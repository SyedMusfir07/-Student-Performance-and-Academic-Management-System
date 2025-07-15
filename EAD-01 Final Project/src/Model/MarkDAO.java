package Model;

import util.DBConnection;
import java.sql.*;

public class MarkDAO {
    public static boolean addMark(Mark m) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO marks(student_id, subject, marks, grade) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getStudentId());
            ps.setString(2, m.getSubject());
            ps.setInt(3, m.getMarks());
            ps.setString(4, m.getGrade());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
