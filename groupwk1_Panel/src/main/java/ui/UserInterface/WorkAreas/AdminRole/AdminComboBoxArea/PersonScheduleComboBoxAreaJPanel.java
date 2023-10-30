/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Course.CourseSchedule;
import Business.Person.PersonSchedule;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 15469
 */
public class PersonScheduleComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonScheduleComboBoxAreaJPanel
     */
    private PersonSchedule personSchedule;
    private List<PersonSchedule.PersonInfo> personInfoList;
    
    public PersonScheduleComboBoxAreaJPanel() throws SQLException {
        initComponents();
        personSchedule=new PersonSchedule();
        personInfoList=personSchedule.getAllPersonSchedule();
        populateTable();
    }
    
    
        private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)cSchtbl.getModel();
        model.setRowCount(0);
        for(PersonSchedule.PersonInfo vs : personInfoList){
                Object[] row = new Object[5];
                row[0] = vs.getCourseId();
                row[1] = vs.getSemeId();
                row[2] = vs.getStarttime();
                row[3] = vs.getEndtime();
                row[4] = vs.getpId();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cSchtbl = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtE = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtpId = new javax.swing.JTextField();

        cSchtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Semester ID", "Start Time", "End Time", "Person ID"
            }
        ));
        jScrollPane2.setViewportView(cSchtbl);

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Person Schedule");

        jLabel1.setText("Course ID");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel2.setText("Start Time");

        jLabel3.setText("Semester ID");

        jLabel4.setText("End Time");

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Person ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtsId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtpId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtE, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtS)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = cSchtbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) cSchtbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            String semId = (String) model.getValueAt(selectedRowIndex, 1);
            String start = (String) model.getValueAt(selectedRowIndex, 2);
            String end = (String) model.getValueAt(selectedRowIndex, 3);
            String pId = (String) model.getValueAt(selectedRowIndex, 4);
            for(PersonSchedule.PersonInfo c : personInfoList){
                if(c.getCourseId().equals(selectedID)&&c.getEndtime().equals(end)&&c.getSemeId().equals(semId)&&c.getStarttime().equals(start)&&c.getpId().equals(pId)){
                    txtid.setText(c.getCourseId());
                    txtsId.setText(c.getSemeId());
                    txtS.setText(c.getStarttime());
                    txtE.setText(c.getEndtime());
                    txtpId.setText(c.getpId());
                    populateTable();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        String cId=txtid.getText();
        String week=txtsId.getText();
        String start=txtS.getText();
        String end=txtE.getText();
        String pId=txtpId.getText();
        
        for(PersonSchedule.PersonInfo c : personInfoList){
                if(c.getCourseId().equals(id)&&c.getEndtime().equals(end)&&c.getSemeId().equals(week)&&c.getStarttime().equals(start)&&c.getpId().equals(pId)){
                JOptionPane.showMessageDialog(this,  "Already Existed");
                return;
            }
        }
        
        
        if(cId==""||week==""||start==""||end==""||pId==""){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
        PersonSchedule.PersonInfo c = new PersonSchedule.PersonInfo(cId, week, start, end,pId);
        personInfoList.add(c);
        try {
            personSchedule.savePersonInfoToDatabase(c);
        } catch (SQLException ex) {
            Logger.getLogger(PersonScheduleComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateTable();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String cId=txtid.getText();
        String sem=txtsId.getText();
        String start=txtS.getText();
        String end=txtE.getText();
        String pId=txtpId.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将字符串转换为LocalDate对象
        LocalDateTime localDate = LocalDateTime.parse(start, formatter);
        LocalDateTime localDate1 = LocalDateTime.parse(end, formatter);
        if("".equals(cId)||"".equals(sem)||"".equals(start)||"".equals(end)||pId==""){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }

        int selectedRowIndex = cSchtbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) cSchtbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            String semId = (String) model.getValueAt(selectedRowIndex, 1);
            String starttime = (String) model.getValueAt(selectedRowIndex, 2);
            String endtime = (String) model.getValueAt(selectedRowIndex, 3);
            String p1 = (String) model.getValueAt(selectedRowIndex, 4);
            PersonSchedule.PersonInfo c = null;
            for(PersonSchedule.PersonInfo e : personInfoList){
                if(e.getCourseId().equals(selectedID)&&e.getEndtime().equals(endtime)&&e.getSemeId().equals(semId)&&e.getStarttime().equals(starttime)&&e.getpId().equals(p1)){
                    c=e;
                    break;
                }
            }
            if(c!=null){
                for(PersonSchedule.PersonInfo e : personInfoList){
                    if(e.getCourseId().equals(cId)&&e.getEndtime().equals(end)&&e.getSemeId().equals(sem)&&e.getStarttime().equals(start)&&e.getpId().equals(pId)){
                        JOptionPane.showMessageDialog(this, "Already existed!");
                        return;
                    }
                }
                PersonSchedule.PersonInfo f = new PersonSchedule.PersonInfo(cId,sem,start,end,pId);
                try {
                    personSchedule.updatePersonInfoInDatabase(f, c);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonScheduleComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                c.setCourseId(cId);
                c.setSemeId(sem);
                c.setStarttime(start);
                c.setEndtime(end);
                c.setpId(pId);
                populateTable();
                JOptionPane.showMessageDialog(this, "Updated!");
                return;
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = cSchtbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to Deleted.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) cSchtbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            for(PersonSchedule.PersonInfo e : personInfoList){
                if(e.getCourseId().equals(selectedID)){
                    //
                    personInfoList.remove(e);
                    try {
                        personSchedule.deletePersonInfoFromDatabase(e);
                    } catch (SQLException ex) {
                        Logger.getLogger(PersonScheduleComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    populateTable();
                    JOptionPane.showMessageDialog(this, "Deleted!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JTable cSchtbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextField txtS;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpId;
    private javax.swing.JTextField txtsId;
    // End of variables declaration//GEN-END:variables
}
