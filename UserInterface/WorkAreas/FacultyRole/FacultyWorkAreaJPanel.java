/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * WorkAreaJPanel.java
 *
 * Created on May 17, 2020, 8:35:29 AM
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import UserInterface.WorkAreas.AdminRole.ManagePersonnelWorkResp.ManagePersonsJPanel;
import javax.swing.JPanel;

/**
 *
 * @author kal
 */
public class FacultyWorkAreaJPanel extends javax.swing.JPanel {

    javax.swing.JPanel CardSequencePanel;
    Business business;

    /**
     * Creates new form UnitRiskWorkArea
     */

    public FacultyWorkAreaJPanel(Business b, JPanel clp) {

        business = b;
        this.CardSequencePanel = clp;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageCourses = new javax.swing.JButton();
        btnManageStudents = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSchedule = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        btnManageCourses.setBackground(new java.awt.Color(102, 153, 255));
        btnManageCourses.setFont(getFont());
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
        btnManageStudents.setFont(getFont());
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
        btnMyProfile.setFont(getFont());
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
        btnRanking.setFont(getFont());
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("My Faculty Profie");

        btnSchedule.setBackground(new java.awt.Color(102, 153, 255));
        btnSchedule.setFont(getFont());
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnManageCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnManageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84)
                        .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCoursesIdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCoursesIdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();

        ManagePersonsJPanel aos = new ManagePersonsJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ManageVulns", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_btnManageCoursesIdentifyResourceAssetsActionPerformed

    private void btnManageStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStudentsActionPerformed
        // TODO add your handling code here:

 //       ManageSuppliersJPanel iet = new ManageSuppliersJPanel(business, CardSequencePanel);

//        CardSequencePanel.add("FindResourceAsset", iet);
//        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_btnManageStudentsActionPerformed

    private void btnMyProfileIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileIdentifyEventsActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();
        //    IdentifyEventTypes iet= new IdentifyEventTypes(businessunit, CardSequencePanel);

        //    CardSequencePanel.add("IdentifyEventTypes", iet);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        //((java.awt.CardLayout)CardSequencePanel.getLayout()).show(CardSequencePanel, "IdentifyEventTypes");
}//GEN-LAST:event_btnMyProfileIdentifyEventsActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        // TODO add your handling code here:

        CardSequencePanel.removeAll();
//        ManageIncidents aos = new  ManageIncidents(businessunit, CardSequencePanel);
        // aos.setAgenda(businessunit.getRiskManagementAgenda());
//        CardSequencePanel.add("RiskAgendaObjectives", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
}//GEN-LAST:event_btnRankingActionPerformed

    private void btnScheduleIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleIdentifyEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnScheduleIdentifyEventsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageCourses;
    private javax.swing.JButton btnManageStudents;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
