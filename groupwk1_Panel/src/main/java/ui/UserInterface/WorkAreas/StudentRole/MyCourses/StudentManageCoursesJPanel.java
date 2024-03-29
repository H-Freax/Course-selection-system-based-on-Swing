/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.StudentRole.MyCourses;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseVO;
import Business.Person.Student;
import Business.Semester.Semester;
import Tools.MySQLConnectionUtil;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhangjinming
 */
public class StudentManageCoursesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentManageCoursesJPanel
     */
    private JPanel ViewContainer;

    private CourseDirectory courseDirectory ;

    private String thisterm;

    private List<CourseVO> myCourseVOList = new ArrayList<>();

    private List<CourseVO> historyCourseVOList = new ArrayList<>();

    private Student student;

    private CourseVO selectedCourse;

    private List<Semester> semesters;
    Connection connection;
    public StudentManageCoursesJPanel(Student student) throws SQLException {
        connection =MySQLConnectionUtil.getConnection();
        courseDirectory = new CourseDirectory(connection);//数据传到了courseList
        initComponents();
        this.ViewContainer = ViewContainer;
        this.student = student;

        this.thisterm="Fall 2023";
        semesters = Semester.getAllSemestersFromDatabase(connection);
//        Semester sem=null;
        for(Semester s: semesters){
//            if(s.getSemesterName().equals(thisterm)){
//                sem = s;
//            }
            selectSemComboBox.addItem(s.getSemesterName());
        }



        getEnrolledCourses("",thisterm);
//        getHistoryCourses(null);

        populateTable("",thisterm);
//        historyTable();

        tblCurrentCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblCurrentCourses.getSelectedRow(); // 获取所点选行的索引
                DefaultTableModel model = (DefaultTableModel) tblCurrentCourses.getModel(); //Have the access to the table;

                //时间格式转化为String
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                DateTimeFormatter startformatter = DateTimeFormatter.ofPattern("HH:mm:ss");


                if(row != -1) { // 如果行已被选择

                    Object id = model.getValueAt(row, 0); // 获取所选行的第1列值

                    for (CourseVO courseVO:myCourseVOList){
                        if (courseVO.getId().equals((String)id)){
                            selectedCourse = courseVO;
                            txtCurrentCourseId.setText(courseVO.getId());
                            txtCurrentCourseName.setText(courseVO.getName());
                            txtCurrentCourseTopic.setText(courseVO.getTopics().toString());
                            txtCurrentSemester.setText(courseVO.getSemester());
                            txtCurrentProfessor.setText(courseVO.getProfessor());
                            txtCurrentProfessorRegion.setText(courseVO.getRegion());
                            txtCurrentCourseLocation.setText(courseVO.getLocation());
                            currentCourseIntroductionTextArea.setText(courseVO.getIntroduction());
                            txtCurrentStudentLimited.setText(courseVO.getStudentLimit() + "");
                            try {
                                if((courseVO.getStudentCount()+"").equals(selectedCourse.calculateStudentCount(connection)+"")){
                                    txtCurrentStudentCount.setText(courseVO.getStudentCount() + "");
                                }else{
                                    courseVO.setStudentCount(selectedCourse.calculateStudentCount(connection));
                                    courseVO.updateInDatabase(connection);
                                }

                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            txtCurrentCoursePoint.setText(courseVO.getPoint() + "");
                            txtCurrentCourseStartTime.setText(courseVO.getBeginTime().format(startformatter));
                            txtCurrentCourseEndTime.setText(courseVO.getEndTime().format(startformatter));
                            txtCurrentProfessorLanguage.setText(courseVO.getLanguage());
                        }
                    }
                }
            }
        });

    }

    private List<CourseVO> getHistoryCourses(String keyWords,String semester) {

        try {
            historyCourseVOList = courseDirectory.loadCourseListByStudentIdSemFromDatabase(keyWords,student.getPersonID(), semester);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database is not work");
        }
        return historyCourseVOList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCurrentCourses = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCurrentCourseTopic = new javax.swing.JTextField();
        txtCurrentCourseId = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCurrentCourseName = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCurrentCoursePoint = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCurrentSemester = new javax.swing.JTextField();
        txtCurrentCourseLocation = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtCurrentCourseStartTime = new javax.swing.JTextField();
        lblCourseEndTime2 = new javax.swing.JLabel();
        txtCurrentCourseEndTime = new javax.swing.JTextField();
        lblStudentLimited2 = new javax.swing.JLabel();
        txtCurrentStudentLimited = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtCurrentStudentCount = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        currentCourseIntroductionTextArea = new javax.swing.JTextArea();
        btnDrop = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCurrentProfessor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCurrentProfessorRegion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCurrentProfessorLanguage = new javax.swing.JTextField();
        selectSemComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSearchCourses = new javax.swing.JTextField();
        btnSearchCourses = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        tblCurrentCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Couse Name", "Professor", "Course Status", "Score", "Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblCurrentCourses);

        jLabel28.setText("Course ID:");

        jLabel29.setText("Course Topic:");

        txtCurrentCourseTopic.setEditable(false);

        txtCurrentCourseId.setEditable(false);

        jLabel30.setText("Course Name:");

        txtCurrentCourseName.setEditable(false);

        jLabel31.setText("Course credit:");

        txtCurrentCoursePoint.setEditable(false);

        jLabel32.setText("Semester:");

        txtCurrentSemester.setEditable(false);

        txtCurrentCourseLocation.setEditable(false);

        jLabel33.setText("Course Location:");

        jLabel34.setText("Course Begintime:");

        txtCurrentCourseStartTime.setEditable(false);

        lblCourseEndTime2.setText("Course Endtime:");

        txtCurrentCourseEndTime.setEditable(false);

        lblStudentLimited2.setText("Student Limited:");

        txtCurrentStudentLimited.setEditable(false);

        jLabel35.setText("Student Count:");

        txtCurrentStudentCount.setEditable(false);

        jLabel36.setText("Course Introduction");

        currentCourseIntroductionTextArea.setEditable(false);
        currentCourseIntroductionTextArea.setColumns(20);
        currentCourseIntroductionTextArea.setRows(5);
        jScrollPane9.setViewportView(currentCourseIntroductionTextArea);

        btnDrop.setText("Drop");
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDropActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel11.setText("Professor");

        txtCurrentProfessor.setEditable(false);

        jLabel12.setText("Professor Region");

        txtCurrentProfessorRegion.setEditable(false);

        jLabel13.setText("Professor Language");

        txtCurrentProfessorLanguage.setEditable(false);

        selectSemComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                try {
                    selectSemComboBoxItemStateChanged(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        selectSemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    selectSemComboBoxActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Select Semester:");

        txtSearchCourses.setToolTipText("");
        txtSearchCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCoursesActionPerformed(evt);
            }
        });

        btnSearchCourses.setText("Search");
        btnSearchCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSearchCoursesActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel1.setText("ProfessorName/language/Region/CourseName/CouseTopic");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(selectSemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSearchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnSearchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane9)
                                .addGap(80, 80, 80))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel32))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCurrentCourseId)
                                            .addComponent(txtCurrentCourseTopic)
                                            .addComponent(txtCurrentCourseName))))
                                .addGap(106, 106, 106)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCourseEndTime2)
                                    .addComponent(jLabel34)
                                    .addComponent(lblStudentLimited2)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel33))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(txtCurrentCourseEndTime))
                                        .addComponent(txtCurrentCourseStartTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCurrentProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCurrentProfessorRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtCurrentProfessorLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(434, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectSemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtCurrentCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtCurrentCourseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCurrentCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtCurrentCourseStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourseEndTime2)
                            .addComponent(txtCurrentCourseEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentLimited2)
                            .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCurrentProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCurrentProfessorRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCurrentProfessorLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );

        jScrollPane2.setViewportView(jPanel3);

        jTabbedPane1.addTab("Current Course", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchCoursesActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSearchCoursesActionPerformed
        // TODO add your handling code here:
        populateTable(txtSearchCourses.getText(),selectSemComboBox.getSelectedItem().toString());

        txtCurrentCourseId.setText("");
        txtCurrentCourseName.setText("");
        txtCurrentCourseTopic.setText("");
        txtCurrentSemester.setText("");
        txtCurrentProfessor.setText("");
        txtCurrentProfessorRegion.setText("");
        txtCurrentCourseLocation.setText("");
        currentCourseIntroductionTextArea.setText("");
        txtCurrentStudentLimited.setText("");
        txtCurrentStudentCount.setText("");
        txtCurrentCoursePoint.setText("");
        txtCurrentCourseStartTime.setText("");
        txtCurrentCourseEndTime.setText("");
        txtCurrentProfessorLanguage.setText("");
    }//GEN-LAST:event_btnSearchCoursesActionPerformed

    private void selectSemComboBoxActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_selectSemComboBoxActionPerformed
        // TODO add your handling code here:
        if(selectSemComboBox.getSelectedItem().toString().equals(thisterm)){
            btnDrop.setVisible(true);
        }else {
            btnDrop.setVisible(false);
        }
//        populateTable(thisterm);
    }//GEN-LAST:event_selectSemComboBoxActionPerformed

    private void selectSemComboBoxItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException {//GEN-FIRST:event_selectSemComboBoxItemStateChanged
        // TODO add your handling code here:
        System.out.println("selectSemComboBox.getSelectedItem().toString():"+selectSemComboBox.getSelectedItem().toString());
        populateTable("",selectSemComboBox.getSelectedItem().toString());

        txtCurrentCourseId.setText("");
        txtCurrentCourseName.setText("");
        txtCurrentCourseTopic.setText("");
        txtCurrentSemester.setText("");
        txtCurrentProfessor.setText("");
        txtCurrentProfessorRegion.setText("");
        txtCurrentCourseLocation.setText("");
        currentCourseIntroductionTextArea.setText("");
        txtCurrentStudentLimited.setText("");
        txtCurrentStudentCount.setText("");
        txtCurrentCoursePoint.setText("");
        txtCurrentCourseStartTime.setText("");
        txtCurrentCourseEndTime.setText("");
        txtCurrentProfessorLanguage.setText("");
    }//GEN-LAST:event_selectSemComboBoxItemStateChanged

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnDropActionPerformed
        // TODO add your handling code here:
        dropCourse(selectedCourse,student);
        JOptionPane.showMessageDialog(this, "Successfully dropped!");
        //c重新加载数据
        getEnrolledCourses("",thisterm);
        populateTable("",thisterm);

        txtCurrentCourseId.setText("");
        txtCurrentCourseName.setText("");
        txtCurrentCourseTopic.setText("");
        txtCurrentSemester.setText("");
        txtCurrentProfessor.setText("");
        txtCurrentProfessorRegion.setText("");
        txtCurrentCourseLocation.setText("");
        currentCourseIntroductionTextArea.setText("");
        txtCurrentStudentLimited.setText("");
        txtCurrentStudentCount.setText("");
        txtCurrentCoursePoint.setText("");
        txtCurrentCourseStartTime.setText("");
        txtCurrentCourseEndTime.setText("");
        txtCurrentProfessorLanguage.setText("");
        student.updateStudentupdateInDatabase(Timestamp.valueOf(LocalDateTime.now()),connection);
    }//GEN-LAST:event_btnDropActionPerformed

    private void txtSearchCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCoursesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCoursesActionPerformed

    private void dropCourse(CourseVO selectedCourse, Student student) {
        try {
            courseDirectory.dropCourse(selectedCourse.getId(), student.getPersonID());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database is not work");
        }
    }

    private void populateTable(String keywords,String semester) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblCurrentCourses.getModel(); //Have the access to the table;
        model.setRowCount(0); //初始化
        myCourseVOList = getEnrolledCourses(keywords,semester);
//        Semester sem = Semester.loadFromDatabaseByName(MySQLConnectionUtil.getConnection(),semester);

        for(CourseVO course : myCourseVOList){
            System.out.println("semcoursename:"+course.getName());
            System.out.println("semester:"+semester);
            if(course.getSemester().equals(semester)){
                Object[] row = new Object[6];
                row[0] = course.getId();
                row[1] = course.getName();
                row[2] = course.getProfessor();
                row[3] = course.getStatus();
                System.out.println(course.getScore());
                row[4] = course.getScore();
                row[5] =course.getSemester();

                //设置3R对应

                model.addRow(row);
            }


        }
    }

//    private void historyTable(String semester) {
//        DefaultTableModel model = (DefaultTableModel) tblCoursesHistory.getModel(); //Have the access to the table;
//        model.setRowCount(0); //初始化
//
//        for(CourseVO course : historyCourseVOList){
//
//            Object[] row = new Object[4];
//            row[0] = course.getId();
//            row[1] = course.getName();
//            row[2] = course.getStatus();
//            row[3] = course.getScore();
//
//            //设置3R对应
//
//            model.addRow(row);
//
//        }
//    }

    public List<CourseVO> getEnrolledCourses(String keyWords,String semester){

        try {

            myCourseVOList = courseDirectory.loadCourseListByStudentIdSemFromDatabase(keyWords,student.getPersonID(),semester);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database is not work");
        }
        return myCourseVOList;
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnSearchCourses;
    private javax.swing.JTextArea currentCourseIntroductionTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCourseEndTime2;
    private javax.swing.JLabel lblStudentLimited2;
    private javax.swing.JComboBox<String> selectSemComboBox;
    private javax.swing.JTable tblCurrentCourses;
    private javax.swing.JTextField txtCurrentCourseEndTime;
    private javax.swing.JTextField txtCurrentCourseId;
    private javax.swing.JTextField txtCurrentCourseLocation;
    private javax.swing.JTextField txtCurrentCourseName;
    private javax.swing.JTextField txtCurrentCoursePoint;
    private javax.swing.JTextField txtCurrentCourseStartTime;
    private javax.swing.JTextField txtCurrentCourseTopic;
    private javax.swing.JTextField txtCurrentProfessor;
    private javax.swing.JTextField txtCurrentProfessorLanguage;
    private javax.swing.JTextField txtCurrentProfessorRegion;
    private javax.swing.JTextField txtCurrentSemester;
    private javax.swing.JTextField txtCurrentStudentCount;
    private javax.swing.JTextField txtCurrentStudentLimited;
    private javax.swing.JTextField txtSearchCourses;
    // End of variables declaration//GEN-END:variables


}
