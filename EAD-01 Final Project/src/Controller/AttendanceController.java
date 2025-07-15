package Controller;

import Model.Attendance;
import Model.AttendanceDAO;

import javax.swing.*;
import java.sql.Date;

public class AttendanceController {
    public static void saveAttendance(String studentIdText, String status) {
        try {
            if (studentIdText.isEmpty() || status == null) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }

            int studentId = Integer.parseInt(studentIdText);
            Date today = new Date(System.currentTimeMillis());

            Attendance att = new Attendance(0, studentId, today, status);
            boolean result = AttendanceDAO.addAttendance(att);

            if (result) {
                JOptionPane.showMessageDialog(null, "Attendance marked.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to mark attendance.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Student ID must be a number.");
        }
    }
}
