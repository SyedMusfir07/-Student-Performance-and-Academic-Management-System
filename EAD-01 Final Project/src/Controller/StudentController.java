package Controller;


import Model.Student;
import Model.StudentDAO;

import javax.swing.*;
import java.util.List;

public class StudentController {

    public static void saveStudent(String idText, String name, String email, String grade) {
        try {
            if (idText.isEmpty() || name.isEmpty() || email.isEmpty() || grade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }

            int id = Integer.parseInt(idText);
            Student s = new Student(id, name, email, grade);
            boolean result = StudentDAO.addStudent(s);

            if (result) {
                JOptionPane.showMessageDialog(null, "Student saved.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save student.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID must be a number.");
        }
    }

    public static String getAllStudents() {
        List<Student> students = StudentDAO.getAllStudents();
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append("ID: ").append(s.getId())
              .append(", Name: ").append(s.getName())
              .append(", Email: ").append(s.getEmail())
              .append(", Grade: ").append(s.getGrade())
              .append("\n");
        }
        return sb.toString();
    }
}
