package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Directory.StudentDirectory;
import Business.Person.Student;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 15469
 */




public class StudentComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentComboBoxAreaJPanel
     */
    StudentDirectory studentdirectory;
    Connection connection;
    private List<Student> studentList;

        String personName;
        String personID;
        String username;
        String nowPassword;
        boolean enabled;
        double gpa;
        //coursestudent c_id s_id score
        //
    public StudentComboBoxAreaJPanel() throws SQLException {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stuTable = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpwd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEnabled = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GPA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Student");

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
        jScrollPane2.setViewportView(stuTable);

        txtSearch.setText("Search ID");

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("ID");

        jLabel3.setText("UserName");

        jLabel4.setText("Password");

        jLabel5.setText("isEnabled");

        jLabel6.setText("GPA");

        jLabel7.setText("History Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(txtHis, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEnabled)
                                    .addComponent(GPA)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(jButton3))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHis, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                String search=txtSearch.getText();
        if("".equals(search)){
            JOptionPane.showMessageDialog(this, "Please enter!");
        }else{
            Student s =studentdirectory.findStudent(search);
            if(s==null){
                JOptionPane.showMessageDialog(this, "Not Existed!");
            }else{
                txtname.setText(s.getPersonName());
                txtid.setText(s.getPersonID());
                txtuser.setText(s.getUsername());
                txtpwd.setText(s.getNowPassword());
                String isRight = (s.isEnabled()==true)? "true":"false";
                txtEnabled.setText(isRight);
                GPA.setText(String.valueOf(s.getGpa()));
                String s2 = String.join(",", s.getPasswordHistory());
                txtHis.setText(s2);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        personName=txtname.getText();
        personID=txtid.getText();
        if(studentdirectory.findStudent(personID)!=null){
            JOptionPane.showMessageDialog(this, "ID already existed!");
            return;
        }
        username=txtuser.getText();
        nowPassword=txtpwd.getText();
        enabled=(txtEnabled.getText()=="true")? true:false;
        gpa=(Double.parseDouble(GPA.getText()));
        if(personName!=""&&personID!=""&&username!=""&&nowPassword!=""){
            Student stu1 = new Student( personName,  personID,  username,  nowPassword,  enabled,  gpa);
            Set<String> stringSet1 = new HashSet<>(Arrays.asList(txtHis.getText().split(",")));
            stu1.setPasswordHistory(stringSet1);
            studentList.add(stu1);
            JOptionPane.showMessageDialog(this, "Added!");
            return;
        }
        JOptionPane.showMessageDialog(this, "Please input!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Student s = studentdirectory.findStudent(selectedID);
                if(s!=null){
                    txtname.setText(s.getPersonName());
                    txtid.setText(s.getPersonID());
                    txtuser.setText(s.getUsername());
                    txtpwd.setText(s.getNowPassword());
                    String isRight = (s.isEnabled()==true)? "true":"false";
                    txtEnabled.setText(isRight);
                    GPA.setText(String.valueOf(s.getGpa()));
                    String s2 = String.join(",", s.getPasswordHistory());
                    txtHis.setText(s2);
                }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        personName=txtname.getText();
        personID=txtid.getText();
        if(studentdirectory.findStudent(personID)!=null){
            JOptionPane.showMessageDialog(this, "ID already existed!");
            return;
        }
        username=txtuser.getText();
        nowPassword=txtpwd.getText();
        enabled=(txtEnabled.getText()=="true")? true:false;
        gpa=(Double.parseDouble(GPA.getText()));
        if(personName==""||personID==""||username==""||nowPassword==""){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
        
        Set<String> stringSet1 = new HashSet<>(Arrays.asList(txtHis.getText().split(",")));
       int selectedRowIndex = stuTable.getSelectedRow();
       if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Student stu = studentdirectory.findStudent(selectedID);
                if(stu!=null){
                    for(Student vs : studentList){
                        if(vs.getPersonID().equals(personID)&&!selectedID.equals(personID)){
                            JOptionPane.showMessageDialog(this, "Already Exist ID");
                                return;
                            }
                   }
                    stu.setPasswordHistory(stringSet1);
                    stu.setEnabled(enabled);
                    stu.setGpa(gpa);
                    stu.setNowPassword(nowPassword);
                    stu.setPersonID(personID);
                    stu.setPersonName(personName);
                    stu.setUsername(username);
                    JOptionPane.showMessageDialog(this, "Updated!");
                    populateTable();
                    return;
                }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = stuTable.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) stuTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Student st = studentdirectory.findStudent(selectedID);
                if(st!=null){
                    st.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Deleted!");
                    return;
                }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GPA;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable stuTable;
    private javax.swing.JTextField txtEnabled;
    private javax.swing.JTextField txtHis;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpwd;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
