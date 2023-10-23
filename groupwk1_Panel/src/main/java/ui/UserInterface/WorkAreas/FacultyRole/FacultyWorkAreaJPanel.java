/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.FacultyRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.PersonList;
import ui.LoginJPanel;
import static ui.MainJFrame.readDataFromFile;
import ui.UserInterface.WorkAreas.FacultyRole.ManageCourses.FacultyManageCoursesJPanel;
import ui.UserInterface.WorkAreas.FacultyRole.ManageStudents.FacultyManageStudentsJPanel;
import ui.UserInterface.WorkAreas.FacultyRole.MyProfile.FacultyProfileJPanel;
import ui.UserInterface.WorkAreas.FacultyRole.Ranking.FacultyRankingJPanel;
import ui.UserInterface.WorkAreas.FacultyRole.Schedule.FacultyScheduleJPanel;
import ui.UserInterface.WorkAreas.General.GeneralJPanel;

/**
 *
 * @author zhangjinming
 */
public class FacultyWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel controlPanel;
    private PersonList personList; 
    private JPanel ViewContainer;

    /**
     * Creates new form FacultyWorkAreaJPanel
     */
    public FacultyWorkAreaJPanel(JPanel ViewContainer,JPanel controlPanel, PersonList personList) {
        initComponents();
        this.ViewContainer = ViewContainer;
        this.controlPanel = controlPanel;
        this.personList=  personList;
        this.ViewContainer=ViewContainer;
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
        btnSchedule = new javax.swing.JButton();
        btnManageCourses = new javax.swing.JButton();
        btnManageStudents = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("My Faculty Profie");

        btnSchedule.setBackground(new java.awt.Color(102, 153, 255));
        btnSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnSchedule.setText("Schedule");
        btnSchedule.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSchedule.setMaximumSize(new java.awt.Dimension(145, 40));
        btnSchedule.setMinimumSize(new java.awt.Dimension(20, 20));
        btnSchedule.setPreferredSize(new java.awt.Dimension(240, 25));
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleIdentifyEventsActionPerformed(evt);
            }
        });

        btnManageCourses.setBackground(new java.awt.Color(102, 153, 255));
        btnManageCourses.setForeground(new java.awt.Color(255, 255, 255));
        btnManageCourses.setText(" Manage Courses");
        btnManageCourses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageCourses.setMaximumSize(new java.awt.Dimension(200, 40));
        btnManageCourses.setMinimumSize(new java.awt.Dimension(20, 23));
        btnManageCourses.setPreferredSize(new java.awt.Dimension(240, 30));
        btnManageCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCoursesIdentifyResourceAssetsActionPerformed(evt);
            }
        });

        btnManageStudents.setBackground(new java.awt.Color(102, 153, 255));
        btnManageStudents.setForeground(new java.awt.Color(255, 255, 255));
        btnManageStudents.setText("Manage Student");
        btnManageStudents.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageStudents.setMaximumSize(new java.awt.Dimension(200, 40));
        btnManageStudents.setMinimumSize(new java.awt.Dimension(20, 20));
        btnManageStudents.setPreferredSize(new java.awt.Dimension(240, 25));
        btnManageStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStudentsActionPerformed(evt);
            }
        });

        btnMyProfile.setBackground(new java.awt.Color(102, 153, 255));
        btnMyProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnMyProfile.setText("My Profile");
        btnMyProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMyProfile.setMaximumSize(new java.awt.Dimension(145, 40));
        btnMyProfile.setMinimumSize(new java.awt.Dimension(20, 20));
        btnMyProfile.setPreferredSize(new java.awt.Dimension(240, 25));
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileIdentifyEventsActionPerformed(evt);
            }
        });

        btnRanking.setBackground(new java.awt.Color(102, 153, 255));
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setText("Ranking");
        btnRanking.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRanking.setMaximumSize(new java.awt.Dimension(200, 40));
        btnRanking.setMinimumSize(new java.awt.Dimension(20, 20));
        btnRanking.setPreferredSize(new java.awt.Dimension(240, 25));
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
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
                    .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnLogout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnManageCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnManageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleIdentifyEventsActionPerformed
        // TODO add your handling code here:
        FacultyScheduleJPanel fsPanel = new FacultyScheduleJPanel();
        ViewContainer.add("FacultyScheduleJPanel",fsPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
    }//GEN-LAST:event_btnScheduleIdentifyEventsActionPerformed

    private void btnManageCoursesIdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCoursesIdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
        FacultyManageCoursesJPanel fmcPanel = new FacultyManageCoursesJPanel();
        ViewContainer.add("FacultyManageCoursesJPanel",fmcPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
        //        CardSequencePanel.removeAll();
        //
        //        ManagePersonsJPanel aos = new ManagePersonsJPanel(business, CardSequencePanel);
        //
        //        CardSequencePanel.add("ManageVulns", aos);
//                ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnManageCoursesIdentifyResourceAssetsActionPerformed

    private void btnManageStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStudentsActionPerformed
        // TODO add your handling code here:
        FacultyManageStudentsJPanel fmsPanel = new FacultyManageStudentsJPanel();
        ViewContainer.add("FacultyManageStudentsJPanel", fmsPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
        //       ManageSuppliersJPanel iet = new ManageSuppliersJPanel(business, CardSequencePanel);

        //        CardSequencePanel.add("FindResourceAsset", iet);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnManageStudentsActionPerformed

    private void btnMyProfileIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileIdentifyEventsActionPerformed
        // TODO add your handling code here:
        FacultyProfileJPanel ppPanel = new FacultyProfileJPanel();
        ViewContainer.add("FacultyProfileJPanel", ppPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);
        //        CardSequencePanel.removeAll();
        //        //    IdentifyEventTypes iet= new IdentifyEventTypes(businessunit, CardSequencePanel);
        //
        //        //    CardSequencePanel.add("IdentifyEventTypes", iet);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        //        //((java.awt.CardLayout)CardSequencePanel.getLayout()).show(CardSequencePanel, "IdentifyEventTypes");
    }//GEN-LAST:event_btnMyProfileIdentifyEventsActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        // TODO add your handling code here:
        FacultyRankingJPanel prPanel = new FacultyRankingJPanel();
        ViewContainer.add("FacultyRankingJPanel", prPanel);
        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.next(ViewContainer);

        //        CardSequencePanel.removeAll();
        //        //        ManageIncidents aos = new  ManageIncidents(businessunit, CardSequencePanel);
        //        // aos.setAgenda(businessunit.getRiskManagementAgenda());
        //        //        CardSequencePanel.add("RiskAgendaObjectives", aos);
        //        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.personList = readDataFromFile("personlist.txt");
        LoginJPanel panel = new LoginJPanel(ViewContainer,personList,controlPanel);
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
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCourses;
    private javax.swing.JButton btnManageStudents;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
