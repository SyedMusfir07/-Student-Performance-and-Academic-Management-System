package report;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import util.DBConnection;

import java.io.FileOutputStream;
import java.sql.*;

public class ReportGenerator {

    public static void generateStudentPDF(int studentId) {
        try {
            Connection con = DBConnection.getConnection();

            // Fetch student info
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id = ?");
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Student not found.");
                return;
            }

            String name = rs.getString("name");
            String email = rs.getString("email");
            String grade = rs.getString("grade");

            // Create PDF
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Student_Report_ID_" + studentId + ".pdf"));
            doc.open();

            doc.add(new Paragraph("Student Report", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            doc.add(new Paragraph("ID: " + studentId));
            doc.add(new Paragraph("Name: " + name));
            doc.add(new Paragraph("Email: " + email));
            doc.add(new Paragraph("Grade: " + grade));
            doc.add(new Paragraph(" "));

            // Marks Table
            doc.add(new Paragraph("Marks", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            PdfPTable marksTable = new PdfPTable(3);
            marksTable.addCell("Subject");
            marksTable.addCell("Marks");
            marksTable.addCell("Grade");

            ps = con.prepareStatement("SELECT subject, marks, grade FROM marks WHERE student_id = ?");
            ps.setInt(1, studentId);
            ResultSet marksRS = ps.executeQuery();

            while (marksRS.next()) {
                marksTable.addCell(marksRS.getString("subject"));
                marksTable.addCell(String.valueOf(marksRS.getInt("marks")));
                marksTable.addCell(marksRS.getString("grade"));
            }
            doc.add(marksTable);
            doc.add(new Paragraph(" "));

            // Attendance Table
            doc.add(new Paragraph("Attendance", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            PdfPTable attTable = new PdfPTable(2);
            attTable.addCell("Date");
            attTable.addCell("Status");

            ps = con.prepareStatement("SELECT date, status FROM attendance WHERE student_id = ?");
            ps.setInt(1, studentId);
            ResultSet attRS = ps.executeQuery();

            while (attRS.next()) {
                attTable.addCell(String.valueOf(attRS.getDate("date")));
                attTable.addCell(attRS.getString("status"));
            }
            doc.add(attTable);

            doc.close();
            System.out.println("✅ PDF created: Student_Report_ID_" + studentId + ".pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


