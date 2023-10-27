package ui.UserInterface.WorkAreas.AdminRole;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Business.Person.Employee;
import Tools.MySQLConnectionUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.LoginJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.CourseComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.CourseScheduleComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.EmployeeComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.FacultyComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.HistoryPwdJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.PersonComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.PersonScheduleComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.RateComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.SemesterComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea.StudentComboBoxAreaJPanel;
import ui.UserInterface.WorkAreas.General.GeneralJPanel;

/**
 *
 * @author 15469
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */

//    public AdminWorkAreaJPanel() {
//        initComponents();
//
//    }
    private Employee employee;
    private JPanel controlPanel;
    private JPanel ViewContainer;
    String selectedText="";
    public AdminWorkAreaJPanel(JPanel ViewContainer, JPanel controlPanel, Employee employee) {
        initComponents();
        this.controlPanel = controlPanel;
        this.employee=  employee;
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

        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnGo = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        jButton8.setBackground(new java.awt.Color(102, 153, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Manage Students");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton8.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton8.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(102, 153, 255));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Manage Faculty");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton10.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton10.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My  Profie");

        btnLogout.setText("Log out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 153, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Assessment of Faculty");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setMaximumSize(new java.awt.Dimension(145, 40));
        jButton7.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton7.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7IdentifyEventsActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(102, 153, 255));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Assessment of Students");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setMaximumSize(new java.awt.Dimension(145, 40));
        jButton9.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton9.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9IdentifyEventsActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Faculty", "Student", "Course", "Rate","Person","Employee","HistoryPwd","Semester","Course Schedule","Person Schedule"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnGoActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnCreate.setBackground(new java.awt.Color(102, 153, 255));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create Profile");
        btnCreate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreate.setMaximumSize(new java.awt.Dimension(145, 40));
        btnCreate.setMinimumSize(new java.awt.Dimension(20, 20));
        btnCreate.setPreferredSize(new java.awt.Dimension(240, 25));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateIdentifyEventsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnLogout)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGo)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo))
                .addGap(43, 43, 43)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnLogout)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //manage student profile

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

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

    private void jButton7IdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7IdentifyEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7IdentifyEventsActionPerformed

    private void jButton9IdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9IdentifyEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9IdentifyEventsActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnGoActionPerformed
        // TODO add your handling code here:
        if("Faculty".equals(selectedText)){
            FacultyComboBoxAreaJPanel cPanel = new FacultyComboBoxAreaJPanel();
            ViewContainer.add("FacultyComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Student".equals(selectedText)){
            StudentComboBoxAreaJPanel cPanel = new StudentComboBoxAreaJPanel();
            ViewContainer.add("StudentComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Course".equals(selectedText)){
            CourseComboBoxAreaJPanel cPanel = new CourseComboBoxAreaJPanel();
            ViewContainer.add("CourseComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Rate".equals(selectedText)){
            RateComboBoxAreaJPanel cPanel = new RateComboBoxAreaJPanel();
            ViewContainer.add("RateComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Person".equals(selectedText)){
            PersonComboBoxAreaJPanel cPanel = new PersonComboBoxAreaJPanel();
            ViewContainer.add("PersonComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Employee".equals(selectedText)){
            EmployeeComboBoxAreaJPanel cPanel = new EmployeeComboBoxAreaJPanel();
            ViewContainer.add("EmployeeComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Semester".equals(selectedText)){
            SemesterComboBoxAreaJPanel cPanel = new SemesterComboBoxAreaJPanel();
            ViewContainer.add("EmployeeComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Course Schedule".equals(selectedText)){
            CourseScheduleComboBoxAreaJPanel cPanel = new CourseScheduleComboBoxAreaJPanel();
            ViewContainer.add("CourseScheduleComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("Person Schedule".equals(selectedText)){
            PersonScheduleComboBoxAreaJPanel cPanel = new PersonScheduleComboBoxAreaJPanel();
            ViewContainer.add("PersonScheduleComboBoxAreaJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else if("HistoryPwd".equals(selectedText)){
            HistoryPwdJPanel cPanel = new HistoryPwdJPanel();
            ViewContainer.add("HistoryPwdJPanel", cPanel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else{
            JOptionPane.showMessageDialog(this,"Please select a row!");
        }
    }//GEN-LAST:event_btnGoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selectedText = jComboBox1.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCreateIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateIdentifyEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateIdentifyEventsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
