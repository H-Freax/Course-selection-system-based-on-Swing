package ui.UserInterface.WorkAreas.StudentRole.Transcript;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Person.Student;
import Business.Semester.Semester;
import Tools.MySQLConnectionUtil;

import java.awt.CardLayout;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author zhangjinming
 */
public class StudentTranscriptJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentTranscriptJPanel
     */
    private JPanel ViewContainer;
    private Student student;
    Connection conn= MySQLConnectionUtil.getConnection();

    private List<Course> allCourses;

    public StudentTranscriptJPanel(JPanel ViewContainer, Student student) throws SQLException {
        initComponents();
        this.ViewContainer = ViewContainer;

        this.ViewContainer = ViewContainer;
        this.student = student;
        initStudentProfile(student);
        populateTable();
        txtStudentGpa.setText(String.valueOf(student.getGpa()));
    }

    private void initStudentProfile(Student student) {
        CourseDirectory courseDirectory = new CourseDirectory(MySQLConnectionUtil.getConnection());//数据传到了courseList
        try {
            courseDirectory.loadCoursesFromDatabase(student.getPersonID());
            allCourses = courseDirectory.getAllCourses();
            for(Course course:allCourses){
                System.out.println("course.getProfessor()"+course.getProfessor());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrascript = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStudentGpa = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();

        tblTrascript.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Semester", "Course", "Professor", "Score"
            }
        ));
        tblTrascript.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblTrascript);
        tblTrascript.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jTextField1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Transcript");

        jLabel6.setText("GPA:");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(txtStudentGpa, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrint)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                                .addComponent(jTextField1)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStudentGpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            // Call a method to generate and save the PDF here
            generateAndSavePDF();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while printing: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void populateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblTrascript.getModel(); //Have the access to the table;
        model.setRowCount(0); //初始化？？
        Semester semester;
        for(Course course : allCourses){
            semester = Semester.loadFromDatabase(conn,course.getSemesterId());
            Object[] row = new Object[4];

            row[0] = semester.getSemesterName();
            row[1] = course.getName();
            row[2] = course.getProfessor();
            if((course.getScore()+"").equals("0.0")){
                row[3]="N/A";
            }else{
                row[3] = course.getScore();
            }

            //设置3R对应

            model.addRow(row);

        }
    }
    private void generateAndSavePDF() throws Exception {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("transcript.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(4); // 4 列用于学期、课程、教授和分数

            // 添加列标题
            table.addCell("Semester");
            table.addCell("Course");
            table.addCell("Professor");
            table.addCell("Score");

            DefaultTableModel model = (DefaultTableModel) tblTrascript.getModel();

            // Add data from the table to the PDF
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < 4; col++) {
                    String cellValue = model.getValueAt(row, col).toString();
                    System.out.println("Adding cell value: " + cellValue); // 添加调试语句
                    table.addCell(cellValue);
                }
            }

            document.add(table);
        } finally {
            document.close();
            System.out.println("PDF document closed."); // 添加调试语句
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblTrascript;
    private javax.swing.JTextField txtStudentGpa;
    // End of variables declaration//GEN-END:variables
}
