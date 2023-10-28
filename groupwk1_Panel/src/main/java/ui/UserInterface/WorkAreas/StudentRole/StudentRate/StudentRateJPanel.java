/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.StudentRole.StudentRate;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Directory.PersonDirectory;
import Business.Directory.ProfessorDirectory;
import Business.Person.Person;
import Business.Person.Professor;
import Business.Person.Student;
import Business.Rate.Rate;
import Business.Semester.Semester;
import Tools.MySQLConnectionUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zhangjinming
 */
public class StudentRateJPanel extends javax.swing.JPanel {

    private JPanel ViewContainer;
    private Student student;

    Connection conn= MySQLConnectionUtil.getConnection();

    private List<Course> allCourses;
    /**
     * Creates new form StudentRateJPanel
     */
    public StudentRateJPanel(JPanel ViewContainer, Student student) throws SQLException {
        initComponents();
        this.ViewContainer = ViewContainer;
        this.student = student;
        initStudentProfile(student);
        populateTable();
    }
    private void initStudentProfile(Student student) {
        CourseDirectory courseDirectory = new CourseDirectory(MySQLConnectionUtil.getConnection());//数据传到了courseList
        try {
            courseDirectory.loadCoursesFromDatabase(student.getPersonID());
            allCourses = courseDirectory.getAllCourses();
//            for(Course course:allCourses){
//                System.out.println("course.getProfessor()"+course.getProfessor());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
    }

    private void populateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblRate.getModel(); //Have the access to the table;
        model.setRowCount(0); //初始化？？
        Semester semester;
        Rate rate = new Rate();
        PersonDirectory personDirectory = new PersonDirectory();
        personDirectory.loadPersonsFromDatabase(conn);
        ProfessorDirectory pd = new ProfessorDirectory();
        for(Course course : allCourses){
            semester = Semester.loadFromDatabase(conn,course.getSemesterId());

            if(!(course.getScore()+"").equals("0.0")){

                Object[] row = new Object[4];

                row[0] = course.getName();
                row[1] = course.getProfessor();
                System.out.println("course.getProfessor()"+course.getProfessor());

                if(rate.doesRateExist(conn,personDirectory.findPersonByname(course.getProfessor()+"").getPersonID(),student.getPersonID(),course.getId())){
                    row[2] = "✓";
                    rate = Rate.loadFromDatabase(conn,personDirectory.findPersonByname(course.getProfessor()+"").getPersonID(),student.getPersonID(),course.getId());

                    row[3] = rate.getScore();
                }else{
                    row[2]="Need Rate";
                    row[3] ="NO Score Yet";
                }




                //设置3R对应

                model.addRow(row);
            }

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRate = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtScorePart1 = new javax.swing.JTextField();
        txtScorePart2 = new javax.swing.JTextField();
        txtScorePart3 = new javax.swing.JTextField();
        txtScorePart4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Rate");

        tblRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Name", "Professor Name", "Rate", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRate);

        jLabel2.setText("<html>Did the professor provide course materials, like lecture notes, presentations, and reading materials, on time?<br>Rate from 0 to 5 (0 for No, 5 for Yes)</html> ");

        jLabel3.setText("<html>Were appropriate feedback and guidance provided to help students improve their academic performance?<br>Rate from 0 to 5 (0 for No, 5 for Yes)</html> ");

        jLabel4.setText("<html>Did the professor provide grades and feedback promptly to help students understand their performance?<br>Rate from 0 to 5 (0 for No, 5 for Yes)</html> ");

        jLabel5.setText("<html>Did the professor possess relevant academic or industry experience and effectively integrate theory<br> with real-world applications?<br>Rate from 0 to 5 (0 for No, 5 for Yes)</html> ");

        jLabel6.setText("Comment:");

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane2.setViewportView(commentTextArea);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSubmitActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnViewActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txtScorePart1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtScorePart2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtScorePart3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtScorePart4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnView))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtScorePart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScorePart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScorePart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScorePart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSubmitActionPerformed
        // Get the selected row from tblRate
        int selectedRow = tblRate.getSelectedRow();

        if (selectedRow >= 0) {
            // Retrieve the data from the selected row
            String courseName = tblRate.getValueAt(selectedRow, 0).toString();
            String professorName = tblRate.getValueAt(selectedRow, 1).toString();
            String rateStatus = tblRate.getValueAt(selectedRow, 2).toString();



            if (rateStatus.equals("✓")) {
                JOptionPane.showMessageDialog(this, "You already rated.");

            } else {
                // The course needs to be rated. You can retrieve the personId, courseId, and studentId.
                PersonDirectory personDirectory = new PersonDirectory();
                personDirectory.loadPersonsFromDatabase(conn);

                String professorId = personDirectory.findPersonByname(professorName+"").getPersonID();
                String studentId = student.getPersonID();

                CourseDirectory cd= new CourseDirectory();
                cd.loadCoursesFromDatabase(studentId);

                String courseId = cd.findCourseIdByName(courseName).getId();

                // Now you have the professorId, studentId, and courseId for the rating.

                // Get the content from the text fields
                String scorePart1Text = txtScorePart1.getText();
                String scorePart2Text = txtScorePart2.getText();
                String scorePart3Text = txtScorePart3.getText();
                String scorePart4Text = txtScorePart4.getText();
                String commentText = commentTextArea.getText();

                // Perform content validation
                boolean isValid = true;

                // Validate if the entered scores are valid
                if (!isValidScore(scorePart1Text) || !isValidScore(scorePart2Text) ||
                        !isValidScore(scorePart3Text) || !isValidScore(scorePart4Text)) {
                    JOptionPane.showMessageDialog(this, "Please enter valid scores (numbers between 0 and 5).");
                    isValid = false;
                }

                // Validate if the comment is not empty
                if (commentText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please provide comments.");
                    isValid = false;
                }

                if (isValid) {
                    try {
                        Rate rate = new Rate();

                        // Set the properties of the rate object
                        rate.setProfessorId(professorId);
                        rate.setStudentId(studentId);
                        rate.setCourseId(courseId);
                        rate.setScorePart1(txtScorePart1.getText());
                        rate.setScorePart2(txtScorePart2.getText());
                        rate.setScorePart3(txtScorePart3.getText());
                        rate.setScorePart4(txtScorePart4.getText());
                        rate.setComment(commentTextArea.getText());
                        int scorePart1Value = Integer.parseInt(txtScorePart1.getText());
                        int scorePart2Value = Integer.parseInt(txtScorePart2.getText());
                        int scorePart3Value = Integer.parseInt(txtScorePart3.getText());
                        int scorePart4Value = Integer.parseInt(txtScorePart4.getText());

                        // Calculate the total score
                        int totalScore = scorePart1Value + scorePart2Value + scorePart3Value + scorePart4Value;

                        // Normalize the total score to a scale of 0 to 100
                        int maxPossibleTotal = 20; // Assuming max possible total score is 20
                        int normalizedScore = (totalScore * 100) / maxPossibleTotal;

                        // Set the normalized score as the 'score' property
                        rate.setScore(String.valueOf(normalizedScore));

                        // Save the rate to the database
                        rate.saveToDatabase(conn);

                        // You can show a success message or perform any other actions after saving the rate
                        JOptionPane.showMessageDialog(this, "Rating submitted successfully.");
                        txtScorePart1.setText("");
                        txtScorePart2.setText("");
                        txtScorePart3.setText("");
                        txtScorePart4.setText("");
                        commentTextArea.setText("");
                        // Optionally, you can update the table by calling populateTable() to show the updated information.
                        populateTable();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error while submitting the rating. Please try again.");
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a course to rate.");
        }



    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        viewSelectedRating();
    }//GEN-LAST:event_btnViewActionPerformed

    private void viewSelectedRating() throws SQLException {
        // Get the selected row from tblRate
        int selectedRow = tblRate.getSelectedRow();

        if (selectedRow >= 0) {
            // Retrieve the data from the selected row
            String courseName = tblRate.getValueAt(selectedRow, 0).toString();
            String professorName = tblRate.getValueAt(selectedRow, 1).toString();

            // Check if the course needs to be rated
            String rateStatus = tblRate.getValueAt(selectedRow, 2).toString();
            if (rateStatus.equals("✓")) {
                // Course already rated, display the rating information

                // Get the professorId, studentId, and courseId
                PersonDirectory personDirectory = new PersonDirectory();
                personDirectory.loadPersonsFromDatabase(conn);

                String professorId = personDirectory.findPersonByname(professorName + "").getPersonID();
                String studentId = student.getPersonID();
                CourseDirectory cd = new CourseDirectory();
                cd.loadCoursesFromDatabase(studentId);
                String courseId = cd.findCourseIdByName(courseName).getId();

                try {
                    Rate rate = Rate.loadFromDatabase(conn, professorId, studentId, courseId);

                    // Populate the text fields
                    txtScorePart1.setText(rate.getScorePart1());
                    txtScorePart2.setText(rate.getScorePart2());
                    txtScorePart3.setText(rate.getScorePart3());
                    txtScorePart4.setText(rate.getScorePart4());
                    commentTextArea.setText(rate.getComment());

                    // Make the text fields non-editable
                    txtScorePart1.setEditable(false);
                    txtScorePart2.setEditable(false);
                    txtScorePart3.setEditable(false);
                    txtScorePart4.setEditable(false);
                    commentTextArea.setEditable(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error loading the rating.");
                }
            } else {
                // Course not rated, clear the text fields and make them editable
                txtScorePart1.setText("");
                txtScorePart2.setText("");
                txtScorePart3.setText("");
                txtScorePart4.setText("");
                commentTextArea.setText("");

                // Make the text fields editable
                txtScorePart1.setEditable(true);
                txtScorePart2.setEditable(true);
                txtScorePart3.setEditable(true);
                txtScorePart4.setEditable(true);
                commentTextArea.setEditable(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a course to view or rate.");
        }
    }

    // 验证分数是否合法
    private boolean isValidScore(String scoreText) {
        try {
            double score = Double.parseDouble(scoreText);
            return score >= 0 && score <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnView;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRate;
    private javax.swing.JTextField txtScorePart1;
    private javax.swing.JTextField txtScorePart2;
    private javax.swing.JTextField txtScorePart3;
    private javax.swing.JTextField txtScorePart4;
    // End of variables declaration//GEN-END:variables
}