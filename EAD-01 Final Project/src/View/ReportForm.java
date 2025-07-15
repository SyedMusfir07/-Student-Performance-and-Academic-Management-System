package View;

import Controller.ReportController;

import javax.swing.*;

public class ReportForm extends JFrame {
    private JTextField studentIdField;
    private JButton generateBtn;

    public ReportForm() {
        setTitle("Generate Student PDF Report");
        setSize(300, 160);
        setLayout(null);

        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(30, 30, 80, 25);
        add(idLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(120, 30, 130, 25);
        add(studentIdField);

        generateBtn = new JButton("Generate PDF");
        generateBtn.setBounds(80, 70, 130, 30);
        add(generateBtn);

        generateBtn.addActionListener(e -> {
            String idText = studentIdField.getText();
            ReportController.generatePDF(idText);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
