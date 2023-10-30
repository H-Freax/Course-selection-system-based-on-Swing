package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Semester.Semester;
import Tools.MySQLConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
public class SemesterComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SemesterComboBoxAreaJPanel
     */
    private List<Semester> semList;
    private Connection connection;
    public SemesterComboBoxAreaJPanel() throws SQLException {
        initComponents();
        connection = MySQLConnectionUtil.getConnection();
        semList=Semester.getAllSemestersFromDatabase(connection);
        populateTable();
    }

    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)semTbl.getModel();
        model.setRowCount(0);
        for(Semester vs : semList){
                Object[] row = new Object[4];
                row[0] = vs.getId();
                row[1] = vs.getSemesterName();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = vs.getSemesterStart().format(formatter);
                String formattedDateTime1 = vs.getSemesterEnd().format(formatter);
                row[2] = formattedDateTime;
                row[3] = formattedDateTime1;
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
        semTbl = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtStart = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Semester");

        semTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Start Time", "End Time"
            }
        ));
        jScrollPane2.setViewportView(semTbl);

        txtSearch.setText("Search ID");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

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

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("ID");

        jLabel6.setText("End Time");

        jLabel7.setText("Start Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtname)
                                .addGap(134, 134, 134))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addGap(137, 137, 137)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(297, 297, 297))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(305, 305, 305))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(451, Short.MAX_VALUE))
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search=txtSearch.getText();
        Semester d = null;
        if("".equals(search)){
            JOptionPane.showMessageDialog(this, "Please enter!");
        }else{
            for(Semester e : semList){
                if(e.getId().equals(search)){
                    d = e;
                }
            }
            if(d!=null){
                txtid.setText(d.getId());
                txtname.setText(d.getSemesterName());
                
                txtStart.setText(String.valueOf(d.getSemesterStart()));
                txtEnd.setText(String.valueOf(d.getSemesterEnd()));
                return;
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = semTbl.getSelectedRow();
        Semester d = null;
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) semTbl.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                for(Semester e : semList){
                if(e.getId().equals(selectedID)){
                    d = e;
                    }
                }
                if(d!=null){
                    txtid.setText(d.getId());
                    txtname.setText(d.getSemesterName());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = d.getSemesterStart().format(formatter);
                    String formattedDateTime1 = d.getSemesterEnd().format(formatter);
                    txtStart.setText(formattedDateTime);
                    txtEnd.setText(formattedDateTime1);
                    return;
                }
        }

    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        for(Semester e : semList){
                if(e.getId().equals(id)){
                    JOptionPane.showMessageDialog(this, "ID Already Existed");
                    return;
                    }
                }
        String semesterName=txtname.getText();
        String startTime = txtStart.getText();
        String endTime = txtEnd.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将字符串转换为LocalDate对象
        LocalDateTime localDate = LocalDateTime.parse(startTime, formatter);
        LocalDateTime localDate1 = LocalDateTime.parse(endTime, formatter);
        if("".equals(semesterName)||"".equals(id)||"".equals(startTime)||"".equals(endTime)){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
        Semester e = new Semester( id,  semesterName,  localDate,  localDate1);
        semList.add(e);
        try {
            e.saveToDatabase(connection);
        } catch (SQLException ex) {
            Logger.getLogger(SemesterComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateTable();

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        String semesterName=txtname.getText();
        String startTime = txtStart.getText();
        String endTime = txtEnd.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将字符串转换为LocalDate对象
        LocalDateTime localDate = LocalDateTime.parse(startTime, formatter);
        LocalDateTime localDate1 = LocalDateTime.parse(endTime, formatter);
        if("".equals(semesterName)||"".equals(id)||"".equals(startTime)||"".equals(endTime)){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
       
       int selectedRowIndex = semTbl.getSelectedRow();
       if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) semTbl.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Semester c = null;
                for(Semester e : semList){
                    if(e.getId().equals(selectedID)){
                        c = e;
                    }
                    if(e.getId().equals(id)&&!selectedID.equals(id)){
                        JOptionPane.showMessageDialog(this, "ID Already Existed");
                        return;
                    }
                }
                if(c!=null){
                    c.setId(id);
                    c.setSemesterName(semesterName);
                    c.setSemesterStart(localDate);
                    c.setSemesterEnd(localDate1);
                    populateTable();
                    try {
                        c.updateInDatabase(connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(SemesterComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Updated!");
                    return;
                }
            JOptionPane.showMessageDialog(this, "Not Existed!");

        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = semTbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to Deleted.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) semTbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            for(Semester vs : semList){
                if(vs.getId().equals(selectedID)){
                    //
                    semList.remove(vs);
                    populateTable();
                    JOptionPane.showMessageDialog(this, "Deleted!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable semTbl;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStart;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
