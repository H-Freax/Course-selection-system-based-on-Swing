/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.Person.Employee;
import Business.Person.Professor;
import Business.Person.Student;
import Tools.MySQLConnectionUtil;
import model.PersonList;
import model.Person;
import model.User;
import ui.UserInterface.WorkAreas.AdminRole.AdminWorkAreaJPanel;
import ui.UserInterface.WorkAreas.FacultyRole.FacultyWorkAreaJPanel;
import ui.UserInterface.WorkAreas.StudentRole.StudentWorkAreaJPanel;

/**
 *
 * @author freax
 */


public class LoginJPanel extends javax.swing.JPanel {
    int i=0;
    private JPanel ViewContainer;
    private PersonList personList;
    private JPanel controlPanel;

    Connection connection = MySQLConnectionUtil.getConnection();
    public LoginJPanel(JPanel ViewContainer, PersonList personList, JPanel controlPanel) {
        initComponents();
        this.ViewContainer = ViewContainer;
        this.personList = personList;
        this.controlPanel = controlPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        loginbtn = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        txtloginusername = new javax.swing.JTextField();
        lblusername = new javax.swing.JLabel();
        lblpwd = new javax.swing.JLabel();
        txtloginpwd = new javax.swing.JPasswordField();
        btnAdmin = new javax.swing.JRadioButton();
        btnProfessor = new javax.swing.JRadioButton();
        btnStudent = new javax.swing.JRadioButton();

        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loginbtnActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        lbltitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Login in");

        txtloginusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginusernameActionPerformed(evt);
            }
        });

        lblusername.setText("User Name:");

        lblpwd.setText("Password:");

        buttonGroup1.add(btnAdmin);
        btnAdmin.setText("Admin");


        buttonGroup1.add(btnProfessor);
        btnProfessor.setText("Faculty");


        buttonGroup1.add(btnStudent);
        btnStudent.setText("Student");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblusername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblpwd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginbtn)
                    .addComponent(txtloginusername, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtloginpwd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(btnAdmin)
                .addGap(18, 18, 18)
                .addComponent(btnProfessor)
                .addGap(18, 18, 18)
                .addComponent(btnStudent)
                .addGap(0, 136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbltitle)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloginusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusername))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpwd)
                    .addComponent(txtloginpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdmin)
                    .addComponent(btnProfessor)
                    .addComponent(btnStudent))
                .addGap(37, 37, 37)
                .addComponent(loginbtn)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        String username = txtloginusername.getText();
        String password = Arrays.toString(txtloginpwd.getPassword());
        connection =  MySQLConnectionUtil.getConnection();
        // 调用 Employee、Professor、Student 中的身份验证方法
        boolean loginSuccess = false;
        if (btnAdmin.isSelected()) {

            System.out.println("admin");
            loginSuccess = Tools.PasswordUtils.verifyLogin(connection, username, password, "Employee");

        } else if (btnProfessor.isSelected()) {
            System.out.println("professor");
            loginSuccess = Tools.PasswordUtils.verifyLogin(connection, username, password, "Professor");

        } else if (btnStudent.isSelected()) {
            System.out.println("student");
            loginSuccess = Tools.PasswordUtils.verifyLogin(connection, username, password, "Student");

        }

        if (loginSuccess) {
            // 根据用户身份切换到不同的界面
            if (btnAdmin.isSelected()) {
                JOptionPane.showMessageDialog(this, "Succuss!");

                AdminWorkAreaJPanel admincontrolpanel = new AdminWorkAreaJPanel(ViewContainer, controlPanel);
                controlPanel.add(admincontrolpanel);
                CardLayout layout1 = (CardLayout)controlPanel.getLayout();
                layout1.next(controlPanel);


                JPanel panel = new JPanel();
                ViewContainer.add("Block",panel);
                CardLayout layout = (CardLayout)ViewContainer.getLayout();
                layout.next(ViewContainer);
                // 显示 Employee 界面
            } else if (btnProfessor.isSelected()) {
                // 显示 Professor 界面
                JOptionPane.showMessageDialog(this, "Succuss!");

                FacultyWorkAreaJPanel panel1 = new FacultyWorkAreaJPanel( ViewContainer, controlPanel,  personList);
                controlPanel.add(panel1);
                CardLayout layout1 = (CardLayout)controlPanel.getLayout();
                layout1.next(controlPanel);

                JPanel panel = new JPanel();
                ViewContainer.add("Block",panel);
                CardLayout layout = (CardLayout)ViewContainer.getLayout();
                layout.next(ViewContainer);
            } else if (btnStudent.isSelected()) {
                // 显示 Student 界面
                JOptionPane.showMessageDialog(this, "Succuss!");

                StudentWorkAreaJPanel panel1 = new StudentWorkAreaJPanel(ViewContainer, controlPanel,  personList);
                controlPanel.add(panel1);
                CardLayout layout1 = (CardLayout)controlPanel.getLayout();
                layout1.next(controlPanel);


                JPanel panel = new JPanel();
                ViewContainer.add("Block",panel);
                CardLayout layout = (CardLayout)ViewContainer.getLayout();
                layout.next(ViewContainer);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Login failed. Please check your credentials.");
        }


    }
    private void txtloginusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginusernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAdmin;
    private javax.swing.JRadioButton btnProfessor;
    private javax.swing.JRadioButton btnStudent;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblpwd;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lblusername;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField txtloginpwd;
    private javax.swing.JTextField txtloginusername;
    // End of variables declaration//GEN-END:variables
}
