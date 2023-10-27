package ui.UserInterface.WorkAreas.StudentRole;

import java.awt.CardLayout;
import java.sql.SQLException;
import javax.swing.JPanel;

import Business.Person.Student;
import ui.LoginJPanel;
import ui.UserInterface.WorkAreas.General.GeneralJPanel;
import ui.UserInterface.WorkAreas.StudentRole.GraduationStatus.StudentGraduationStatusJPanel;
import ui.UserInterface.WorkAreas.StudentRole.ManageProfile.StudentManageProfileJPanel;
import ui.UserInterface.WorkAreas.StudentRole.MyCourses.StudentManageCoursesJPanel;
import ui.UserInterface.WorkAreas.StudentRole.Registration.StudentRegisterJPanel;
import ui.UserInterface.WorkAreas.StudentRole.Transcript.StudentTranscriptJPanel;

/**
 *
 * @author zhangjinming
 */
public class StudentWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel controlPanel;
    private JPanel ViewContainer;

    private Student student;
    /**
     * Creates new form StudentWorkAreaJPanel
     */
    public StudentWorkAreaJPanel() {
        initComponents();
    }

    public StudentWorkAreaJPanel(JPanel ViewContainer,JPanel controlPanel, Student student) {
        initComponents();
        this.student = student;
        this.controlPanel = controlPanel;
        this.ViewContainer=ViewContainer;

    }

    public Student getStudent() {
        return student;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMyCourse = new javax.swing.JButton();
        btnRegisrtation = new javax.swing.JButton();
        btnManageProfile = new javax.swing.JButton();
        btnGraduationStatus = new javax.swing.JButton();
        btnTranscript = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("My Student Profie");

        btnMyCourse.setBackground(new java.awt.Color(102, 153, 255));
        btnMyCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnMyCourse.setText("My Courses");
        btnMyCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMyCourse.setMaximumSize(new java.awt.Dimension(145, 40));
        btnMyCourse.setMinimumSize(new java.awt.Dimension(20, 20));
        btnMyCourse.setPreferredSize(new java.awt.Dimension(240, 25));
        btnMyCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnMyCourseIdentifyEventsActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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
                try {
                    btnManageProfileActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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
                try {
                    btnTranscriptActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnLogout.setText("Log out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGraduationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisrtation, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMyCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnLogout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnMyCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRegisrtation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnGraduationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyCourseIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnMyCourseIdentifyEventsActionPerformed
        // TODO add your handling code here:
        StudentManageCoursesJPanel mscPanel = new StudentManageCoursesJPanel(student);
        ViewContainer.add("StudentManageCoursesJPanel", mscPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnMyCourseIdentifyEventsActionPerformed

    private void btnRegisrtationIdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisrtationIdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
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

    private void btnManageProfileActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnManageProfileActionPerformed
        // TODO add your handling code here:
        StudentManageProfileJPanel smpPanel = new StudentManageProfileJPanel(ViewContainer,student);
        ViewContainer.add("StudentManageProfileJPanel", smpPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);

        //       ManageSuppliersJPanel iet = new ManageSuppliersJPanel(business, CardSequencePanel);

        //        CardSequencePanel.add("FindResourceAsset", iet);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnManageProfileActionPerformed

    private void btnGraduationStatusIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraduationStatusIdentifyEventsActionPerformed
        // TODO add your handling code here:
        StudentGraduationStatusJPanel sgsPanel = new StudentGraduationStatusJPanel();
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

    private void btnTranscriptActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnTranscriptActionPerformed
        // TODO add your handling code here:
        StudentTranscriptJPanel stPanel = new StudentTranscriptJPanel(ViewContainer,student);
        ViewContainer.add("StudentManageProfileJPanel", stPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);

    }//GEN-LAST:event_btnTranscriptActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

        LoginJPanel panel = new LoginJPanel(ViewContainer,controlPanel);
        ViewContainer.add("LoginJPanel",panel);
        GeneralJPanel panel3 = new GeneralJPanel();
        CardLayout layout1 = (CardLayout)controlPanel.getLayout();
        controlPanel.add(panel3);
        layout1.next(controlPanel);

        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);        // TODO add your handling code here:
        btnLogout.setVisible(false);

    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraduationStatus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageProfile;
    private javax.swing.JButton btnMyCourse;
    private javax.swing.JButton btnRegisrtation;
    private javax.swing.JButton btnTranscript;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
