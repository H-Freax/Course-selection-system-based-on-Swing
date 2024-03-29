/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.AdminRole.Management;

import Business.Course.CourseStudent;
import Business.Directory.StudentDirectory;
import Business.Person.Student;
import Tools.MySQLConnectionUtil;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ui.UserInterface.WorkAreas.StudentRole.GraduationStatus.StudentGraduationStatusJPanel;
import ui.UserInterface.WorkAreas.StudentRole.ManageProfile.StudentManageProfileJPanel;
import ui.UserInterface.WorkAreas.StudentRole.MyCourses.StudentManageCoursesJPanel;
import ui.UserInterface.WorkAreas.StudentRole.Registration.StudentRegisterJPanel;
import ui.UserInterface.WorkAreas.StudentRole.Schedule.StudentScheduleJPanel;
import ui.UserInterface.WorkAreas.StudentRole.StudentRate.StudentRateJPanel;
import ui.UserInterface.WorkAreas.StudentRole.Transcript.StudentTranscriptJPanel;

/**
 *
 * @author 15469
 */
public class StudentManagementJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentManagementJPanel
     */
     StudentDirectory studentdirectory;
    Connection connection;
    private List<Student> studentList;
    private JPanel ViewContainer;
    public StudentManagementJPanel(JPanel ViewContainer) {
        initComponents();
        this.ViewContainer= ViewContainer;
        studentdirectory = new StudentDirectory();
        studentList=studentdirectory.getStudentList();
        populateTable();
    }

    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel)stuTable.getModel();
        model.setRowCount(0);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        stuTable.setRowSorter(sorter);
        for(Student vs : studentList){
            System.out.print(vs.getUsername());
                Object[] row = new Object[4];
                row[0] = vs.getPersonID();
                row[1] = vs.getPersonName();
                row[2] = vs.isEnabled();
                row[3] = vs.getGpa();
                model.addRow(row);
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
        stuTable = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnMyCourse = new javax.swing.JButton();
        btnRate = new javax.swing.JButton();
        btnRegisrtation = new javax.swing.JButton();
        btnManageProfile = new javax.swing.JButton();
        btnGraduationStatus = new javax.swing.JButton();
        btnTranscript = new javax.swing.JButton();
        btnRate1 = new javax.swing.JButton();

        stuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "isEnabled", "GPA"
            }
        ));
        jScrollPane1.setViewportView(stuTable);

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Student Management");

        btnMyCourse.setBackground(new java.awt.Color(102, 153, 255));
        btnMyCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnMyCourse.setText("My Courses");
        btnMyCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMyCourse.setMaximumSize(new java.awt.Dimension(145, 40));
        btnMyCourse.setMinimumSize(new java.awt.Dimension(20, 20));
        btnMyCourse.setPreferredSize(new java.awt.Dimension(240, 25));
        btnMyCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyCourseIdentifyEventsActionPerformed(evt);
            }
        });

        btnRate.setBackground(new java.awt.Color(102, 153, 255));
        btnRate.setForeground(new java.awt.Color(255, 255, 255));
        btnRate.setText("Rate");
        btnRate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRate.setMaximumSize(new java.awt.Dimension(200, 40));
        btnRate.setMinimumSize(new java.awt.Dimension(20, 20));
        btnRate.setPreferredSize(new java.awt.Dimension(240, 25));
        btnRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRateActionPerformed(evt);
            }
        });

        btnRegisrtation.setBackground(new java.awt.Color(102, 153, 255));
        btnRegisrtation.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisrtation.setText("Registration");
        btnRegisrtation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegisrtation.setMaximumSize(new java.awt.Dimension(200, 40));
        btnRegisrtation.setMinimumSize(new java.awt.Dimension(20, 23));
        btnRegisrtation.setPreferredSize(new java.awt.Dimension(240, 30));
        btnRegisrtation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisrtationIdentifyResourceAssetsActionPerformed(evt);
            }
        });

        btnManageProfile.setBackground(new java.awt.Color(102, 153, 255));
        btnManageProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnManageProfile.setText("Manage Profile");
        btnManageProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageProfile.setMaximumSize(new java.awt.Dimension(200, 40));
        btnManageProfile.setMinimumSize(new java.awt.Dimension(20, 20));
        btnManageProfile.setPreferredSize(new java.awt.Dimension(240, 25));
        btnManageProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProfileActionPerformed(evt);
            }
        });

        btnGraduationStatus.setBackground(new java.awt.Color(102, 153, 255));
        btnGraduationStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnGraduationStatus.setText("Graduation Status");
        btnGraduationStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGraduationStatus.setMaximumSize(new java.awt.Dimension(145, 40));
        btnGraduationStatus.setMinimumSize(new java.awt.Dimension(20, 20));
        btnGraduationStatus.setPreferredSize(new java.awt.Dimension(240, 25));
        btnGraduationStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraduationStatusIdentifyEventsActionPerformed(evt);
            }
        });

        btnTranscript.setBackground(new java.awt.Color(102, 153, 255));
        btnTranscript.setForeground(new java.awt.Color(255, 255, 255));
        btnTranscript.setText("Transcript");
        btnTranscript.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTranscript.setMaximumSize(new java.awt.Dimension(200, 40));
        btnTranscript.setMinimumSize(new java.awt.Dimension(20, 20));
        btnTranscript.setPreferredSize(new java.awt.Dimension(240, 25));
        btnTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranscriptActionPerformed(evt);
            }
        });

        btnRate1.setBackground(new java.awt.Color(102, 153, 255));
        btnRate1.setForeground(new java.awt.Color(255, 255, 255));
        btnRate1.setText("Schedule");
        btnRate1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRate1.setMaximumSize(new java.awt.Dimension(200, 40));
        btnRate1.setMinimumSize(new java.awt.Dimension(20, 20));
        btnRate1.setPreferredSize(new java.awt.Dimension(240, 25));
        btnRate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMyCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGraduationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegisrtation, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMyCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGraduationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegisrtation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(btnRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyCourseIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyCourseIdentifyEventsActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentManageCoursesJPanel mscPanel = null;
        try {
            mscPanel = new StudentManageCoursesJPanel(student);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        ViewContainer.add("StudentManageCoursesJPanel", mscPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnMyCourseIdentifyEventsActionPerformed

    private void btnRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRateActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentRateJPanel srPanel=null;
         try {
             srPanel = new StudentRateJPanel(ViewContainer,student);
         } catch (SQLException ex) {
             Logger.getLogger(StudentManagementJPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
        ViewContainer.add("StudentRateJPanel", srPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnRateActionPerformed

    private void btnRegisrtationIdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisrtationIdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentRegisterJPanel srPanel = new StudentRegisterJPanel(student);
        ViewContainer.add("StudentManageCoursesJPanel", srPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
        //        CardSequencePanel.removeAll();
        //
        //        ManagePersonsJPanel aos = new ManagePersonsJPanel(business, CardSequencePanel);
        //
        //        CardSequencePanel.add("ManageVulns", aos);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnRegisrtationIdentifyResourceAssetsActionPerformed

    private void btnManageProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProfileActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentManageProfileJPanel smpPanel = null;
        try {
            smpPanel = new StudentManageProfileJPanel(ViewContainer,student);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        ViewContainer.add("StudentManageProfileJPanel", smpPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);

        //       ManageSuppliersJPanel iet = new ManageSuppliersJPanel(business, CardSequencePanel);

        //        CardSequencePanel.add("FindResourceAsset", iet);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnManageProfileActionPerformed

    private void btnGraduationStatusIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraduationStatusIdentifyEventsActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentGraduationStatusJPanel sgsPanel = new StudentGraduationStatusJPanel(ViewContainer,student);
        ViewContainer.add("StudentManageProfileJPanel", sgsPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
        //        CardSequencePanel.removeAll();
        //        //    IdentifyEventTypes iet= new IdentifyEventTypes(businessunit, CardSequencePanel);
        //
        //        //    CardSequencePanel.add("IdentifyEventTypes", iet);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        //        //((java.awt.CardLayout)CardSequencePanel.getLayout()).show(CardSequencePanel, "IdentifyEventTypes");
    }//GEN-LAST:event_btnGraduationStatusIdentifyEventsActionPerformed

    private void btnTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranscriptActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentTranscriptJPanel stPanel = null;
        try {
            stPanel = new StudentTranscriptJPanel(ViewContainer,student);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        ViewContainer.add("StudentManageProfileJPanel", stPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnTranscriptActionPerformed

    private void btnRate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRate1ActionPerformed
        // TODO add your handling code here:
        Student student = null;
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                student = studentdirectory.findStudent(selectedID);              
        }
        StudentScheduleJPanel smpPanel = null;
        try {
            smpPanel = new StudentScheduleJPanel(ViewContainer,student);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        ViewContainer.add("StudentManageProfileJPanel", smpPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnRate1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraduationStatus;
    private javax.swing.JButton btnManageProfile;
    private javax.swing.JButton btnMyCourse;
    private javax.swing.JButton btnRate;
    private javax.swing.JButton btnRate1;
    private javax.swing.JButton btnRegisrtation;
    private javax.swing.JButton btnTranscript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable stuTable;
    // End of variables declaration//GEN-END:variables
}
