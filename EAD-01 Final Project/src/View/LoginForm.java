package View;

import Controller.LoginController;
import Model.User;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login - EduTrack Pro");
        setSize(350, 200);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 160, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 90, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            User user = LoginController.authenticate(username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(this, "Welcome, " + user.getUsername() + " (" + user.getRole() + ")");
                dispose();
                new MainMenuForm(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

