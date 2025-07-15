package View;

import Controller.AttendanceController;

import javax.swing.*;

public class AttendanceForm extends JFrame {
    private JTextField studentIdField;
    private JComboBox<String> statusBox;
    private JButton saveBtn;

    public AttendanceForm() {
        setTitle("Attendance Form");
        setSize(300, 220);
        setLayout(null);

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(30, 30, 100, 25);
        add(studentIdLabel);
        studentIdField = new JTextField();
        studentIdField.setBounds(130, 30, 120, 25);
        add(studentIdField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(30, 70, 100, 25);
        add(statusLabel);
        statusBox = new JComboBox<>(new String[]{"Present", "Absent"});
        statusBox.setBounds(130, 70, 120, 25);
        add(statusBox);

        saveBtn = new JButton("Mark");
        saveBtn.setBounds(100, 120, 100, 30);
        add(saveBtn);

        saveBtn.addActionListener(e ->
                AttendanceController.saveAttendance(
                        studentIdField.getText(),
                        statusBox.getSelectedItem().toString()
                ));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
