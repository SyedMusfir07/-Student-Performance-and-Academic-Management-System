package Controller;

import report.ReportGenerator;

import javax.swing.*;

public class ReportController {
    public static void generatePDF(String studentIdText) {
        try {
            if (studentIdText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Student ID.");
                return;
            }

            int studentId = Integer.parseInt(studentIdText);
            ReportGenerator.generateStudentPDF(studentId);
            JOptionPane.showMessageDialog(null, "PDF created successfully!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Student ID must be a number.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error generating PDF.");
        }
    }
}
