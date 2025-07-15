package Controller;

import Model.Mark;
import Model.MarkDAO;

import javax.swing.*;

public class MarkController {

    public static void saveMark(String studentIdText, String subject, String marksText, String grade) {
        try {
            if (studentIdText.isEmpty() || subject.isEmpty() || marksText.isEmpty() || grade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }

            int studentId = Integer.parseInt(studentIdText);
            int marks = Integer.parseInt(marksText);

            Mark m = new Mark(0, studentId, subject, marks, grade);
            boolean result = MarkDAO.addMark(m);

            if (result) {
                JOptionPane.showMessageDialog(null, "Mark saved successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save mark.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Student ID and Marks must be numbers.");
        }
    }
}
