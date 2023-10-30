package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Directory.PersonDirectory;
import Business.Person.Person;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class PersonComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonComboBoxAreaJPanel
     */
    private PersonDirectory personDirectory;
    private ArrayList<Person> personlist;
    Connection connection;
    public PersonComboBoxAreaJPanel() throws SQLException {
        initComponents();
        personDirectory=new PersonDirectory();
        connection= MySQLConnectionUtil.getConnection();
        personDirectory.loadPersonsFromDatabase(connection);
        personlist=personDirectory.listPersons();
        populateTable();
    }

    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)personTbl.getModel();
        model.setRowCount(0);
        for(Person vs : personlist){
                Object[] row = new Object[3];
                row[0] = vs.getPersonID();
                row[1] = vs.getPersonName();
                row[2] = vs.getRole();
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
        personTbl = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Person");

        personTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Role"
            }
        ));
        jScrollPane2.setViewportView(personTbl);

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

        jLabel1.setText("Name");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel6.setText("Role");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname)
                            .addComponent(txtid))
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(77, Short.MAX_VALUE))
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
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(435, Short.MAX_VALUE))
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
        if("".equals(search)){
            JOptionPane.showMessageDialog(this, "Please enter!");
        }else{
            Person e = personDirectory.findPersonById(search);
            if(e!=null){
                txtname.setText(e.getPersonName());
                txtid.setText(e.getPersonID());
                txtRole.setText(e.getRole());
                return;
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = personTbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) personTbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            Person e = personDirectory.findPersonById(selectedID);
            if(e!=null){
                txtname.setText(e.getPersonName());
                txtid.setText(e.getPersonID());
                txtRole.setText(e.getRole());
            }
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        if(personDirectory.findPersonById(id)!=null){
            JOptionPane.showMessageDialog(this, "ID already existed!");
            return;
        }
        String personName=txtname.getText();
        String personID=txtid.getText();
        String role=txtRole.getText();
        if("".equals(personName)||"".equals(personID)||"".equals(role)){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
        Person e = new Person( personName,  personID,  role);
        personlist.add(e);
        try {
            e.saveToDatabase(connection);
        } catch (SQLException ex) {
            Logger.getLogger(PersonComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        populateTable();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();

        String personName=txtname.getText();
        String personID=txtid.getText();
        String role=txtRole.getText();
        if("".equals(personName)||"".equals(personID)||"".equals(role)){
            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }

        int selectedRowIndex = personTbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) personTbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            Person d = personDirectory.findPersonById(selectedID);
            if(d!=null){
                    for(Person vs : personlist){
                        if(vs.getPersonID().equals(id)&&!selectedID.equals(id)){
                            JOptionPane.showMessageDialog(this, "Already Exist ID");
                                return;
                            }
                   }
                    d.setPersonID(personID);
                    d.setPersonName(personName);
                    d.setRole(role);
                try {
                    d.updateInDatabase1(connection,personID,personName,role,id);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                    populateTable();
                    JOptionPane.showMessageDialog(this, "Updated!");
                    return;
            }
            JOptionPane.showMessageDialog(this, "Not Existed!");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = personTbl.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            return;
        }else{
            DefaultTableModel model = (DefaultTableModel) personTbl.getModel();
            String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
            for(Person vs : personlist){
                if(vs.getPersonID().equals(selectedID)){
                    //
                    personlist.remove(vs);
                    try {
                        vs.deleteFromDatabase(connection,vs.getPersonID());
                    } catch (SQLException ex) {
                        Logger.getLogger(PersonComboBoxAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable personTbl;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
