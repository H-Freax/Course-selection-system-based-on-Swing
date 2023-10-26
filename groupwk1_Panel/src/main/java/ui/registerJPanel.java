/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import Business.Directory.EmployeeDirectory;
import Business.Directory.ProfessorDirectory;
import Business.Directory.StudentDirectory;
import Business.Person.Employee;
import Business.Person.Person;
import Business.Person.Professor;
import Business.Person.Student;
import Tools.MySQLConnectionUtil;
import Tools.PasswordUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author zhangjinming
 */
public class registerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form registerJPanel
     */
    private JPanel ViewContainer;
    private JPanel controlPanel;
    private  Person p;
    public registerJPanel(JPanel ViewContainer, JPanel controlPanel, Person p) {
        initComponents();
        this.ViewContainer = ViewContainer;
        this.controlPanel = controlPanel;
        this.p = p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltitle = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        txtloginusername = new javax.swing.JTextField();
        txtloginpwd = new javax.swing.JPasswordField();
        lblpwd = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        backtologin = new javax.swing.JButton();

        lbltitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Register");

        lblusername.setText("User Name:");

        txtloginusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginusernameActionPerformed(evt);
            }
        });

        lblpwd.setText("Password:");

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    registerActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        backtologin.setText("Back");
        backtologin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtologinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backtologin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(240, 240, 240))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblusername)
                                .addGap(18, 18, 18)
                                .addComponent(txtloginusername, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblpwd)
                                .addGap(18, 18, 18)
                                .addComponent(txtloginpwd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(148, 148, 148))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbltitle)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblusername))
                    .addComponent(txtloginusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblpwd))
                    .addComponent(txtloginpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(register)
                .addGap(29, 29, 29)
                .addComponent(backtologin)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtloginusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginusernameActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_registerActionPerformed
        String un = txtloginusername.getText();
        String pwd = Arrays.toString(txtloginpwd.getPassword());
        String role = p.getRole();
        boolean b =true;
        if (role=="Employee"){
            EmployeeDirectory ed = new EmployeeDirectory();
            if(ed.findEmployeeByUsername(un)!=null){
                b=false;
            }
        }else if(role=="Professor"){
            ProfessorDirectory pd = new ProfessorDirectory();
            if(pd.getProfessorByusername(un)!=null){
                b=false;
            }
        }else if(role=="Student"){
            StudentDirectory sd = new StudentDirectory();
            if(sd.findStudentbyUsername(un)!=null){
                b=false;
            }
        }
        if(b){//Todo
            if(role=="Employee"){
                Employee e = new Employee(p.getPersonName(),p.getPersonID(),un, PasswordUtils.hashPassword(pwd),true,role);
                e.saveToDatabase(MySQLConnectionUtil.getConnection());
            }else if(role=="Professor"){
                Professor pro = new Professor(p.getPersonName(),p.getPersonID(),un,PasswordUtils.hashPassword(pwd),true,role);
                pro.saveToDatabase(MySQLConnectionUtil.getConnection());
            }else if(role=="Student"){
                Student stu = new Student(p.getPersonName(),p.getPersonID(),un,PasswordUtils.hashPassword(pwd),true,0);
                stu.saveToDatabase(MySQLConnectionUtil.getConnection());
            }

            JOptionPane.showMessageDialog(this,"Register Success! Please Log in!");

            LoginJPanel panel = new LoginJPanel(ViewContainer,controlPanel);
            ViewContainer.add("validationJPanel",panel);
            CardLayout layout = (CardLayout)ViewContainer.getLayout();
            layout.next(ViewContainer);
        }else{
            JOptionPane.showMessageDialog(this,"Please use a new username! This username is exist!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_registerActionPerformed

    private void backtologinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtologinActionPerformed
        // TODO add your handling code here:

        CardLayout layout = (CardLayout)ViewContainer.getLayout();
        layout.previous(ViewContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_backtologinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtologin;
    private javax.swing.JLabel lblpwd;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lblusername;
    private javax.swing.JButton register;
    private javax.swing.JPasswordField txtloginpwd;
    private javax.swing.JTextField txtloginusername;
    // End of variables declaration//GEN-END:variables
}
