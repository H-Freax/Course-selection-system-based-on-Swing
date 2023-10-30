package ui.UserInterface.WorkAreas.AdminRole.AdminComboBoxArea;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import java.util.List;
import Tools.MySQLConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author 15469
 */
public class CourseComboBoxAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CourseComboBoxAreaJPanel
     */

    private CourseDirectory courseDirectory;
    private List<Course> courselist;

    public CourseComboBoxAreaJPanel() throws SQLException {
        initComponents();
        Connection connection = MySQLConnectionUtil.getConnection();
        courseDirectory=new CourseDirectory(connection);
        courseDirectory.loadCoursesFromDatabase();
        courselist=courseDirectory.getAllCourses();
        populateTable();
    }

    
    
    
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)courseTable.getModel();
        model.setRowCount(0);
        for(Course vs : courselist){
                Object[] row = new Object[5];
                row[0] = vs.getId();
                row[1] = vs.getName();
                row[2] = vs.getSemesterId();
                row[3] = vs.getProfessor();
                row[4] = vs.getPoint();
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
        courseTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTopic = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        txtCurrentCourseId = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCurrentCourseName = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCurrentCoursePoint = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCurrentSemester = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtCurrentCourseLocation = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtCurrentCourseStartTime = new javax.swing.JTextField();
        lblCourseEndTime2 = new javax.swing.JLabel();
        txtCurrentCourseEndTime = new javax.swing.JTextField();
        lblStudentLimited2 = new javax.swing.JLabel();
        txtCurrentStudentLimited = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtCurrentStudentCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEnrolled = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Introduction = new javax.swing.JLabel();
        txtIntro = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtPro = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCurrentCourseWeekday = new javax.swing.JTextField();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Course");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Course Name", "Semester", "Professor", "Course Status"
            }
        ));
        jScrollPane2.setViewportView(courseTable);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setText("Search");

        txtTopic.setColumns(20);
        txtTopic.setRows(5);
        jScrollPane3.setViewportView(txtTopic);

        jLabel28.setText("Course ID:");

        jLabel30.setText("Course Name:");

        jLabel31.setText("Course Credit:");

        jLabel32.setText("Semester:");

        jLabel33.setText("Course Location:");

        jLabel34.setText("Course Begintime:");

        lblCourseEndTime2.setText("Course Endtime:");

        lblStudentLimited2.setText("Student Limited:");

        jLabel35.setText("Student Count:");

        jLabel1.setText("Topic");

        txtEnrolled.setColumns(20);
        txtEnrolled.setRows(5);
        jScrollPane4.setViewportView(txtEnrolled);

        jLabel2.setText("Enrolled Student");

        Introduction.setText("Introduction:");

        jLabel36.setText("Status:");

        jLabel37.setText("Professor: ");

        txtPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Course Weekday:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(67, 67, 67)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addGap(8, 8, 8))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(Introduction, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCurrentCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCurrentCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIntro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCourseEndTime2)
                                    .addComponent(lblStudentLimited2)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel33))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel34)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtCurrentCourseEndTime))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtPro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCurrentCourseStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCurrentCourseWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(485, 485, 485)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnView)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtCurrentCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrentCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIntro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Introduction))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCurrentCourseWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCurrentCourseStartTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourseEndTime2)
                            .addComponent(txtCurrentCourseEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentLimited2)
                            .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txtPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)))
                .addContainerGap(221, Short.MAX_VALUE))
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search=txtSearch.getText();
        Course c = courseDirectory.getCourseById(search);
        if(c==null){
            JOptionPane.showMessageDialog(this, "Not existed!");
            return;
        }else{

            txtCurrentCourseId.setText(c.getId());
            txtCurrentCourseName.setText(c.getName());
            txtIntro.setText(c.getIntroduction());
            txtCurrentCoursePoint.setText(String.valueOf(c.getPoint()));
            txtCurrentSemester.setText(c.getSemesterId());
            txtStatus.setText(c.getStatus());
            txtCurrentCourseLocation.setText(c.getLocation());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
             String formattedDateTime = c.getBeginTime().format(formatter);
             String formattedDateTime1 = c.getBeginTime().format(formatter);
            txtCurrentCourseStartTime.setText(formattedDateTime);
            txtCurrentCourseEndTime.setText(formattedDateTime1);
            txtCurrentStudentLimited.setText(String.valueOf(c.getStudentLimit()));
            txtCurrentStudentCount.setText(String.valueOf(c.getStudentCount()));
            txtPro.setText(c.getProfessor());
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String id=txtCurrentCourseId.getText();
        if(courseDirectory.getCourseById(id)!=null){
            JOptionPane.showMessageDialog(this, "ID already existed!");
            return;
        }
        String name=txtCurrentCourseName.getText();
        String introduction=txtIntro.getText();
        int point=Integer.parseInt(txtCurrentCoursePoint.getText());
        String semesterId=txtCurrentSemester.getText();
        String status=txtStatus.getText();
        String professor=txtPro.getText();
        String location=txtCurrentCourseLocation.getText();
        int studentLimit=Integer.parseInt(txtCurrentStudentLimited.getText());
        int studentCount=Integer.parseInt(txtCurrentStudentCount.getText());
        String dateString = txtCurrentCourseStartTime.getText();
        String dateString1 = txtCurrentCourseEndTime.getText();
        String weekday = txtCurrentCourseWeekday.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime beginTime = LocalDateTime.parse(dateString, formatter);
        LocalDateTime endTime = LocalDateTime.parse(dateString1, formatter);
        List<String> stringSet = new ArrayList<>(Arrays.asList(txtTopic.getText().split(",")));
        List<String> stringSet2 = new ArrayList<>(Arrays.asList(txtEnrolled.getText().split(",")));
        List<String> topics=stringSet; // Store course topics
        List<String> enrolledStudents=stringSet2; // Store enrolled student IDs
        if(id!=""&&name!=""&&semesterId!=""&&status!=""&&professor!=""&&location!=""&&studentLimit!=0&&studentCount!=0){
            Course c = new Course( id,name,introduction, point,  semesterId,  status,professor,  location,  studentLimit,  studentCount, weekday ,beginTime,  endTime,0);
            c.setTopics(topics);
            c.setEnrolledStudents(enrolledStudents);
            courselist.add(c);
            populateTable();
            JOptionPane.showMessageDialog(this, "Added!");
            return;
        }
        JOptionPane.showMessageDialog(this, "Please Input!");


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
       int selectedRowIndex = courseTable.getSelectedRow();

        String id=txtCurrentCourseId.getText();
        String name=txtCurrentCourseName.getText();
        String introduction=txtIntro.getText();
        int point=Integer.parseInt(txtCurrentCoursePoint.getText());
        String semesterId=txtCurrentSemester.getText();
        String status=txtStatus.getText();
        String professor=txtPro.getText();
        String location=txtCurrentCourseLocation.getText();
        int studentLimit=Integer.parseInt(txtCurrentStudentLimited.getText());
        int studentCount=Integer.parseInt(txtCurrentStudentCount.getText());
        String dateString = txtCurrentCourseStartTime.getText();
        String dateString1 = txtCurrentCourseEndTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime beginTime = LocalDateTime.parse(dateString, formatter);
        LocalDateTime endTime = LocalDateTime.parse(dateString1, formatter);
        List<String> stringSet = new ArrayList<>(Arrays.asList(txtTopic.getText().split(",")));
        List<String> stringSet2 = new ArrayList<>(Arrays.asList(txtEnrolled.getText().split(",")));
        List<String> topics=stringSet; // Store course topics
        List<String> enrolledStudents=stringSet2; // Store enrolled student IDs

        DefaultTableModel model1 = (DefaultTableModel) courseTable.getModel();
        String selectedID1 = (String) model1.getValueAt(selectedRowIndex, 0);
        for(Course vs : courselist){
            if(vs.getId().equals(id)&&!selectedID1.equals(id)){
                JOptionPane.showMessageDialog(this, "Already Exist ID");
                return;
            }}
        if("".equals(id)||"".equals(name)||"".equals(semesterId)||"".equals(status)||"".equals(professor)||"".equals(location)||studentLimit==0||studentCount==0){
            System.out.println(id);
            System.out.println(name);
            System.out.println(semesterId);
            System.out.println(status);
            System.out.println(professor);
            System.out.println(location);
            System.out.println(studentLimit);
            System.out.println(studentCount);

            JOptionPane.showMessageDialog(this, "Please Input!");
            return;
        }
    if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);

                Course d = courseDirectory.getCourseById(selectedID);
                if(d!=null){
                    d.setId(id);
                    d.setName(name);
                    d.setIntroduction(introduction);
                    d.setPoint(point);
                    d.setProfessor(professor);
                    d.setSemesterId(semesterId);
                    d.setTopics(topics);
                    d.setStudentLimit(studentLimit);
                    d.setStudentCount(studentCount);
                    d.setEnrolledStudents(enrolledStudents);
                    d.setBeginTime(beginTime);
                    d.setEndTime(endTime);
                    JOptionPane.showMessageDialog(this, "Updated!");
                    populateTable();
                    return;
                }

            JOptionPane.showMessageDialog(this, "Not Existed!");
        }



    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
       int selectedRowIndex = courseTable.getSelectedRow();
       if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }else{
                DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
                String selectedID = (String) model.getValueAt(selectedRowIndex, 0);
                Course c = null;
                for(Course d : courselist){
                    if(d.getId().equals(selectedID)){
                        c=d;
                    }
                }
                if(c!=null){
                    txtCurrentCourseId.setText(c.getId());
                    txtCurrentCourseName.setText(c.getName());
                    txtIntro.setText(c.getIntroduction());
                    txtCurrentCoursePoint.setText(String.valueOf(c.getPoint()));
                    txtCurrentSemester.setText(c.getSemesterId());
                    txtStatus.setText(c.getStatus());
                    txtCurrentCourseLocation.setText(c.getLocation());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = c.getBeginTime().format(formatter);
                    String formattedDateTime1 = c.getBeginTime().format(formatter);
                    txtCurrentCourseStartTime.setText(formattedDateTime);
                    txtCurrentCourseEndTime.setText(formattedDateTime1);
                    txtCurrentStudentLimited.setText(String.valueOf(c.getStudentLimit()));
                    txtCurrentStudentCount.setText(String.valueOf(c.getStudentCount()));
                    txtPro.setText(c.getProfessor());
                    return;
                }
                JOptionPane.showMessageDialog(this, "Not Existed!");
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Introduction;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCourseEndTime2;
    private javax.swing.JLabel lblStudentLimited2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCurrentCourseEndTime;
    private javax.swing.JTextField txtCurrentCourseId;
    private javax.swing.JTextField txtCurrentCourseLocation;
    private javax.swing.JTextField txtCurrentCourseName;
    private javax.swing.JTextField txtCurrentCoursePoint;
    private javax.swing.JTextField txtCurrentCourseStartTime;
    private javax.swing.JTextField txtCurrentCourseWeekday;
    private javax.swing.JTextField txtCurrentSemester;
    private javax.swing.JTextField txtCurrentStudentCount;
    private javax.swing.JTextField txtCurrentStudentLimited;
    private javax.swing.JTextArea txtEnrolled;
    private javax.swing.JTextField txtIntro;
    private javax.swing.JTextField txtPro;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextArea txtTopic;
    // End of variables declaration//GEN-END:variables
}
