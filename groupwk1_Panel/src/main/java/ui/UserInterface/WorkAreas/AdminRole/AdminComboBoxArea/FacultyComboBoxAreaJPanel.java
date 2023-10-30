package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Directory.ProfessorDirectory;
import Business.Person.Professor;
import Tools.MySQLConnectionUtil;
import Tools.PasswordUtils;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 15469
 */
public class FacultyComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ComboBoxAreaJPanel
     */
    private ArrayList<Professor>professorlist;
    private ProfessorDirectory professorDirectory;
    private Connection connection;
    public FacultyComboBoxAreaJPanel() throws SQLException {
        initComponents();
        connection = MySQLConnectionUtil.getConnection();
        professorDirectory = new ProfessorDirectory();
        professorDirectory.loadAllProfessorsFromDatabase(connection);
        professorlist=(ArrayList<Professor>)professorDirectory.getProfessors();
        populateTable();
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblProfessor.getModel();
        model.setRowCount(0);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblProfessor.setRowSorter(sorter);
        for(Professor vs : professorlist){
            
                Object[] row = new Object[5];
                row[0] = vs.getPersonID();
                row[1] = vs.getUsername();
                row[2] = vs.isEnabled();
                row[3] = vs.getRate();
                row[4] = vs.getRegion();
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
        tblProfessor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTopic = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtisEnabled = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtRaing = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtpwd = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtLan = new javax.swing.JTextField();
        lblCourseEndTime2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lblCourseEndTime3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtHis = new javax.swing.JTextArea();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Professor");

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "isEnabled", "Rating", "Region"
            }
        ));
        jScrollPane2.setViewportView(tblProfessor);

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

        jButton3.setText("Disable");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtSearch.setText("Search ID");

        txtTopic.setColumns(20);
        txtTopic.setRows(5);
        jScrollPane3.setViewportView(txtTopic);

        jLabel28.setText("ID");

        jLabel29.setText("Name");

        jLabel30.setText("isEnabled");

        jLabel31.setText("Rating");

        jLabel32.setText("Region");

        jLabel33.setText("Password");

        jLabel34.setText("Language");

        lblCourseEndTime2.setText("Topics");

        jLabel35.setText("UserName");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblCourseEndTime3.setText("History Password");

        txtHis.setColumns(20);
        txtHis.setRows(5);
        jScrollPane4.setViewportView(txtHis);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel32))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtisEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(106, 106, 106)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel34)
                                .addComponent(jLabel33)
                                .addComponent(jLabel31)
                                .addComponent(jLabel35))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRaing, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                            .addGap(101, 101, 101))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblCourseEndTime3)
                                    .addGap(35, 35, 35)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblCourseEndTime2)
                                    .addGap(35, 35, 35)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(141, 141, 141)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton4)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(txtisEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(txtLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRaing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))))
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                        .addComponent(lblCourseEndTime2)
                        .addGap(78, 78, 78)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCourseEndTime3)
                        .addGap(66, 66, 66)))
                .addGap(315, 315, 315))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //Search func
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String search=txtSearch.getText();
        if("".equals(search)){
            JOptionPane.showMessageDialog(this, "Please enter!");
        }else{
            for(Professor vs : professorlist){
                if(vs.getPersonID().equals(search)){
                    txtid.setText(vs.getPersonID());
                    txtname.setText(vs.getUsername());
                    txtisEnabled.setText(String.valueOf(vs.isEnabled()));
                    txtRegion.setText(vs.getRegion());
                    txtpwd.setText(vs.getNowPassword());
                    txtLan.setText(vs.getLanguage());
                    txtRaing.setText(String.valueOf(vs.getRate()));
                    String s1 = String.join(",", vs.getTopics());
                    txtTopic.setText(s1);
                    txtuser.setText(vs.getPersonName());
                    String s2 = String.join(",", vs.getPasswordHistory());
                    txtHis.setText(s2);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();
        for(Professor vs : professorlist){
            if(vs.getPersonID().equals(id)){
                JOptionPane.showMessageDialog(this, "Already Exist ID");
                return;
            }}
        String name = txtname.getText();
        String isEnabled = txtisEnabled.getText();
        String region = txtRegion.getText();
        String pwd = txtpwd.getText();
        String language = txtLan.getText();
        String rate = txtRaing.getText();
        String user = txtuser.getText();
        String topic = txtTopic.getText();
        String his = txtHis.getText();
        if(!"".equals(id)&&!"".equals(name)&&!"".equals(isEnabled)&&!"".equals(region)&!"".equals(pwd)&&!"".equals(language)&&!"".equals(rate)&&!"".equals(user)&&!"".equals(topic)){
            boolean isRight=false;
            Set<String> stringSet = new HashSet<>(Arrays.asList(topic.split(",")));
            Set<String> stringSet1 = new HashSet<>(Arrays.asList(his.split(",")));
            Set<String> stringSet2 = new HashSet<>();
            for(String s : stringSet1){
                s=PasswordUtils.hashPassword(s);
                stringSet2.add(s);
            }
            if("true".equals(isEnabled)){
                isRight=true;
            }else if("false".equals(isEnabled)){
                isRight=false;
            }else{
                JOptionPane.showMessageDialog(this, "Please input true/false in isEnabled!");
                return;
            }
            Professor p = new Professor(name, id,  user, pwd,isRight , "professor");
            professorlist.add(p);
            p.setLanguage(language);
            p.setRegion(region);
            p.setTopics(stringSet);
            p.setPasswordHistory(stringSet2);
            try {
                
                p.saveToDatabase(connection);
                PasswordUtils.replacePasswordListForPersonId(connection,stringSet2,p.getPersonID());
            } catch (SQLException ex) {
                Logger.getLogger(FacultyComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            populateTable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProfessor.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) tblProfessor.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                            
                Professor vs = professorDirectory.getProfessorById(selectedID);
                if(vs!=null){
                    txtid.setText(vs.getPersonID());
                    txtname.setText(vs.getUsername());
                    txtisEnabled.setText(String.valueOf(vs.isEnabled()));
                    txtRegion.setText(vs.getRegion());
                    txtpwd.setText(vs.getNowPassword());
                    txtLan.setText(vs.getLanguage());
                    txtRaing.setText(String.valueOf(vs.getRate()));
                    String s1 = String.join(",", vs.getTopics());
                    txtTopic.setText(s1);
                    txtuser.setText(vs.getPersonName());
                    String s2 = String.join(",", vs.getPasswordHistory());
                    txtHis.setText(s2);
                    return;
                }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    //
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProfessor.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to Disable.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) tblProfessor.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                for(Professor vs : professorlist){
                    if(vs.getPersonID().equals(selectedID)){
                    //
                    vs.setEnabled(false);
                        try {
                            vs.updateProfessorInDatabase(connection);
                        } catch (SQLException ex) {
                            Logger.getLogger(FacultyComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    populateTable();
                    JOptionPane.showMessageDialog(this, "Disabled!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();

        Set<String> stringSet2 = new HashSet<>();
        String name = txtname.getText();
        String isEnabled = txtisEnabled.getText();
        String region = txtRegion.getText();
        String pwd = txtpwd.getText();
        String language = txtLan.getText();
        String rate = txtRaing.getText();
        String user = txtuser.getText();
        String topic = txtTopic.getText();
        String his = txtHis.getText();
        int selectedRowIndex = tblProfessor.getSelectedRow();
        Set<String> stringSet= new HashSet<String>();
        Set<String> stringSet1= new HashSet<String>();
        boolean isRight=false;
        if(id!=""&&name!=""&&isEnabled!=""&&region!=""&pwd!=""&&language!=""&&rate!=""&&user!=""&&topic!=""){
            isRight=false;
            stringSet = new HashSet<>(Arrays.asList(topic.split(",")));
            stringSet1=new HashSet<>(Arrays.asList(his.split(",")));

            for(String s : stringSet1){
                s=PasswordUtils.hashPassword(s);
                stringSet2.add(s);
            }
            if("true".equals(isEnabled)){
                isRight=true;
            }else if("false".equals(isEnabled)){
                isRight=false;
            }else{
                JOptionPane.showMessageDialog(this, "Please input true/false in isEnabled!");
                return;
            }
        }
        DefaultTableModel model1 = (DefaultTableModel) tblProfessor.getModel();
        String selectedID1 = (String) model1.getValueAt(selectedRowIndex, 0);
        for(Professor vs : professorlist){
            if(vs.getPersonID().equals(id)&&!selectedID1.equals(id)){
                JOptionPane.showMessageDialog(this, "Already Exist ID");
                return;
            }}
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) tblProfessor.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Professor c = professorDirectory.getProfessorById(selectedID);
                if(c!=null){
                    c.setUsername(user);
                    c.setEnabled(isRight);
                    c.setLanguage(language);
                    c.setNowPassword(pwd);
                    c.setPersonID(id);
                    c.setRate(Double.parseDouble(rate));
                    c.setTopics(stringSet);
                    c.setPasswordHistory(stringSet2);

                    try {
                        c.updateProfessorInDatabase1( connection, name, "professor", id, language, user, Double.parseDouble(rate), region, isRight, pwd, id);
                        PasswordUtils.replacePasswordListForPersonId(connection,stringSet2,id);
                    } catch (SQLException ex) {
                        Logger.getLogger(FacultyComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    populateTable();
                    JOptionPane.showMessageDialog(this, "Updated!");
                    return;
                }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }


    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCourseEndTime2;
    private javax.swing.JLabel lblCourseEndTime3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTextArea txtHis;
    private javax.swing.JTextField txtLan;
    private javax.swing.JTextField txtRaing;
    private javax.swing.JTextField txtRegion;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextArea txtTopic;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtisEnabled;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpwd;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
