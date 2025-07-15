import View.StudentForm;
import View.MarksForm;
import View.ReportForm;
import View.AttendanceForm;
import View.LoginForm;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(() -> new LoginForm());
    	 
        JFrame frame = new JFrame("EduTrack Pro - Main Menu");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton studentBtn = new JButton("Student Form");
        studentBtn.setBounds(120, 40, 150, 40);
        frame.add(studentBtn);

        JButton marksBtn = new JButton("Marks Form");
        marksBtn.setBounds(120, 100, 150, 40);
        frame.add(marksBtn);

        JButton attendanceBtn = new JButton("Attendance Form");
        attendanceBtn.setBounds(120, 160, 150, 40);
        frame.add(attendanceBtn);

        studentBtn.addActionListener(e -> new StudentForm());
        marksBtn.addActionListener(e -> new MarksForm());
        attendanceBtn.addActionListener(e -> new AttendanceForm());
        
        
        JButton pdfBtn = new JButton("Generate PDF");
        pdfBtn.setBounds(120, 270, 150, 40);
        frame.add(pdfBtn);

        pdfBtn.addActionListener(e -> new ReportForm());
        
        
        
        

    



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
