package Controller;

import Model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    public static User authenticate(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return new User(username, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
