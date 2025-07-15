package Model;

import util.DBConnection;
import java.sql.*;

public class AttendanceDAO {
    public static boolean addAttendance(Attendance att) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, att.getStudentId());
            ps.setDate(2, att.getDate());
            ps.setString(3, att.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
