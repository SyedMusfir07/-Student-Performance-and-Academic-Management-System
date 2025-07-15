package View;


import Controller.MarkController;

import javax.swing.*;

public class MarksForm extends JFrame {
    private JTextField studentIdField, subjectField, marksField, gradeField;
    private JButton saveBtn;

    public MarksForm() {
        setTitle("Enter Student Marks");
        setSize(350, 300);
        setLayout(null);

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(30, 30, 100, 25);
        add(studentIdLabel);
        studentIdField = new JTextField();
        studentIdField.setBounds(130, 30, 160, 25);
        add(studentIdField);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(30, 70, 100, 25);
        add(subjectLabel);
        subjectField = new JTextField();
        subjectField.setBounds(130, 70, 160, 25);
        add(subjectField);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(30, 110, 100, 25);
        add(marksLabel);
        marksField = new JTextField();
        marksField.setBounds(130, 110, 160, 25);
        add(marksField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(30, 150, 100, 25);
        add(gradeLabel);
        gradeField = new JTextField();
        gradeField.setBounds(130, 150, 160, 25);
        add(gradeField);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(110, 200, 100, 30);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            MarkController.saveMark(
                    studentIdField.getText(),
                    subjectField.getText(),
                    marksField.getText(),
                    gradeField.getText()
            );
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
