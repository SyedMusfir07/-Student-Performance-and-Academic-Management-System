package View;

import Model.User;

import javax.swing.*;
import java.awt.*;

public class MainMenuForm extends JFrame {
    private JPanel contentPanel;

    public MainMenuForm(User user) {
        setTitle("EduTrack Pro - Main Menu");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton studentBtn = new JButton("Student Form");
        JButton marksBtn = new JButton("Marks Form");
        JButton attendanceBtn = new JButton("Attendance Form");
        JButton reportBtn = new JButton("Generate Report");
        JButton logoutBtn = new JButton("Logout");

        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());
        contentPanel.add(new JLabel("Welcome to EduTrack Pro!", SwingConstants.CENTER), "HOME");

        // Show buttons based on role
        if (user.getRole().equals("Admin")) {
            buttonPanel.add(studentBtn);
        } else if (user.getRole().equals("Teacher")) {
            buttonPanel.add(studentBtn);
            buttonPanel.add(marksBtn);
            buttonPanel.add(attendanceBtn);
            buttonPanel.add(reportBtn);
        } else if (user.getRole().equals("Student")) {
            buttonPanel.add(reportBtn);
        }
        buttonPanel.add(logoutBtn);

        add(buttonPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        
        studentBtn.addActionListener(e -> new StudentForm().setVisible(true));
        marksBtn.addActionListener(e -> new MarksForm().setVisible(true));
        attendanceBtn.addActionListener(e -> new AttendanceForm().setVisible(true));
        reportBtn.addActionListener(e -> new ReportForm().setVisible(true));


        
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        setVisible(true);
    }

    private void showContent(String message) {
        contentPanel.removeAll();
        contentPanel.add(new JLabel(message, SwingConstants.CENTER));
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
