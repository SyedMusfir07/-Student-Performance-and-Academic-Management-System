package View;


import 	Controller.StudentController;

import javax.swing.*;

public class StudentForm extends JFrame {
    private JTextField idField, nameField, emailField, gradeField;
    private JButton saveBtn, viewBtn;
    private JTextArea displayArea;

    public StudentForm() {
        setTitle("Student Entry");
        setSize(400, 450);
        setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 80, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(110, 30, 200, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 80, 25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(110, 70, 200, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 110, 80, 25);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(110, 110, 200, 25);
        add(emailField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(30, 150, 80, 25);
        add(gradeLabel);
        gradeField = new JTextField();
        gradeField.setBounds(110, 150, 200, 25);
        add(gradeField);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(110, 190, 100, 30);
        add(saveBtn);

        viewBtn = new JButton("View All");
        viewBtn.setBounds(220, 190, 100, 30);
        add(viewBtn);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(30, 240, 320, 150);
        add(scrollPane);

        saveBtn.addActionListener(e ->
                StudentController.saveStudent(
                        idField.getText(),
                        nameField.getText(),
                        emailField.getText(),
                        gradeField.getText()
                ));

        viewBtn.addActionListener(e ->
                displayArea.setText(StudentController.getAllStudents()));

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
