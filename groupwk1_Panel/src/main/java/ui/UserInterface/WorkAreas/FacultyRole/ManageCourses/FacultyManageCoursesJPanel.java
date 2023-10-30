package ui.UserInterface.WorkAreas.FacultyRole.ManageCourses;

import Business.Course.*;
import Business.Person.Person;
import Business.Person.Professor;
import Business.Person.Student;
import Business.Rate.AverageScore;
import Business.Rate.Rate;
import Business.Semester.Semester;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhangjinming
 */
public class FacultyManageCoursesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FacultyManageCoursesJPanel
     */
    private JPanel ViewContainer;
    private Professor professor;
    private String thisterm;
    List<CourseStudent.StudentData> coursestudentlist;

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    List<Student> studentList;
    private CourseDirectory courseDirectory ;
    Connection conn = MySQLConnectionUtil.getConnection();
    private List<Semester> semesters;
    Connection connection;
    Course addCourse;

    JProgressBar jp;
    Rate rate;
    AverageScore averageScore;
    List<CourseVO>  professsorCourseList;
    CourseVO selectedCourse;
    public FacultyManageCoursesJPanel(JPanel ViewContainer, Professor professor){
        connection = MySQLConnectionUtil.getConnection();
        courseDirectory = new CourseDirectory(connection);//数据传到了courseList
        initComponents();
        this.ViewContainer = ViewContainer;
        this.professor = professor;


        jp= this.jProgressBar2;

        jp.setMinimum(0);
        jp.setMaximum(100);
        jp.setValue(0);
        this.thisterm="Fall 2023";
        try {
            semesters = Semester.getAllSemestersFromDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        Semester sem=null;
        for(Semester s: semesters){
            if(s.getSemesterName().equals(thisterm)){
                sem = s;
                semstertime.setText("Semester Time: "+s.getSemesterStart().format(formatter) +"~" +s.getSemesterEnd().format(formatter));
            }
            selectSemComboBox.addItem(s.getSemesterName());
        }



//        getEnrolledCourses("",thisterm);
////        getHistoryCourses(null);
//
        populateTable("",thisterm);
////        historyTable();

        tblCurrentCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblCurrentCourses.getSelectedRow(); // 获取所点选行的索引
                DefaultTableModel model = (DefaultTableModel) tblCurrentCourses.getModel(); //Have the access to the table;

                //时间格式转化为String
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                DateTimeFormatter fullformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                if(row != -1) { // 如果行已被选择

                    Object id = model.getValueAt(row, 0); // 获取所选行的第1列值

                    for (CourseVO courseVO:professsorCourseList){
                        if (courseVO.getId().equals((String)id)){
                            selectedCourse = courseVO;
                            txtCurrentCourseId.setText(courseVO.getId());
                            txtCurrentCourseName.setText(courseVO.getName());
                            txtCurrentCourseTopic.setText(courseVO.getTopics().toString());
                            txtCurrentSemester.setText(courseVO.getSemester());
                            txtCurrentCoursePoint.setText(courseVO.getPoint() + "");

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
                            txtCurrentCourseTime.setText(courseVO.getBeginTime().format(formatter)+"-"+courseVO.getEndTime().format(formatter));
                            txtCourseWeekday.setText(courseVO.getWeekday());
                            txtProfessor1.setText(courseVO.getProfessor());
                            try {
                                averageScore = Rate.calculateAverageScoreForProfessor(conn,professor.getPersonID(),courseVO.getId());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            jp.setValue((int) averageScore.getAvgScore());
                            try {
                                populateStudentTable(true,courseVO.getId(),thisterm);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }
            }
        });
    }

    private void populateStudentTable(Boolean show,String courseid, String semester) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblStudent1.getModel(); //Have the access to the table;
        model.setRowCount(0); //初始化
        if(show){
            CourseStudent courseStudent = new CourseStudent(conn);
            coursestudentlist = courseStudent.getAllStudentsDataForCourse(selectedCourse.getId());

            for(CourseStudent.StudentData studentData : coursestudentlist){

                Object[] row = new Object[3];
                row[0] = Person.loadFromDatabase(conn,studentData.getStudentId()).getPersonName();
                row[1] = studentData.getStudentId();
                row[2] = studentData.getGrade();

                //设置3R对应

                model.addRow(row);

            }
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

        mainTabbedPane = new javax.swing.JTabbedPane();
        manageCoursePanel = new javax.swing.JPanel();
        manageCourseDetailTabbedPane = new javax.swing.JTabbedPane();
        currentCourseScrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCurrentCourses = new javax.swing.JTable();
        txtSearchCurrentCourse = new javax.swing.JTextField();
        btnSearchCurrentCourse = new javax.swing.JButton();
        txtCurrentCourseId = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCurrentCourseTopic = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCurrentCourseName = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCurrentCoursePoint = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCurrentSemester = new javax.swing.JTextField();
        txtCurrentCourseLocation = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtCurrentCourseTime = new javax.swing.JTextField();
        lblCourseEndTime2 = new javax.swing.JLabel();
        txtCourseWeekday = new javax.swing.JTextField();
        lblStudentLimited2 = new javax.swing.JLabel();
        txtCurrentStudentLimited = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtCurrentStudentCount = new javax.swing.JTextField();
        btnSaveCurrentCourse = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        currentCourseIntroductionTextArea = new javax.swing.JTextArea();
        selectSemComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel40 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent1 = new javax.swing.JTable();
        txtProfessor1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        semstertime = new javax.swing.JLabel();
        createCoursePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCreateCourseId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCreateCourseTopic = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCreateCourseName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCreateCoursePoint = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCreateSemester = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCreateCourseLocation = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCreateTime = new javax.swing.JTextField();
        lblCourseEndTime1 = new javax.swing.JLabel();
        txtCreateWeekday = new javax.swing.JTextField();
        lblStudentLimited1 = new javax.swing.JLabel();
        txtCreateStudentLimited = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCreateStudentCount = new javax.swing.JTextField();
        txtCreateProfessor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        createCourseIntroductionTextArea = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        mainTabbedPane.setBackground(new java.awt.Color(204, 204, 255));
        mainTabbedPane.setToolTipText("");
        mainTabbedPane.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N

        manageCourseDetailTabbedPane.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N

        tblCurrentCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Couse Name", "Course Topic", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblCurrentCourses);

        txtSearchCurrentCourse.setText("Course Name/Course Topic");

        btnSearchCurrentCourse.setText("Search");
        btnSearchCurrentCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnSearchCurrentCourseMouseClicked(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnSearchCurrentCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCurrentCourseActionPerformed(evt);
            }
        });

        jLabel28.setText("Course ID:");

        jLabel29.setText("Course Topic:");

        jLabel30.setText("Course Name:");

        jLabel31.setText("Course point:");

        jLabel32.setText("Semester:");

        jLabel33.setText("Course Location:");

        jLabel34.setText("Course Time:");

        lblCourseEndTime2.setText("Course Weekday:");

        lblStudentLimited2.setText("Student Limited:");

        jLabel35.setText("Student Count:");

        btnSaveCurrentCourse.setText("Save");
        btnSaveCurrentCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCurrentCourseActionPerformed(evt);
            }
        });

        jLabel36.setText("Course Introduction:");

        currentCourseIntroductionTextArea.setColumns(20);
        currentCourseIntroductionTextArea.setRows(5);
        jScrollPane9.setViewportView(currentCourseIntroductionTextArea);

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
                selectSemComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Select Semester:");

        jProgressBar2.setValue(60);

        jLabel40.setText("Student List:");

        jLabel38.setText("Professor Rating in this class:");

        tblStudent1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Name", "Student NUID", "Student Score"
            }
        ));
        jScrollPane2.setViewportView(tblStudent1);

        txtProfessor1.setEditable(false);

        jLabel39.setText("Professor:");

        semstertime.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtProfessor1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtCurrentCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel30)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txtCurrentCourseName))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel29)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txtCurrentCourseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel31)
                                                                .addComponent(jLabel32))
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addGap(17, 17, 17)
                                                                    .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCourseEndTime2)
                                                    .addComponent(lblStudentLimited2)
                                                    .addComponent(jLabel35)
                                                    .addComponent(jLabel33)
                                                    .addComponent(jLabel34))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addGap(29, 29, 29)
                                                            .addComponent(txtCourseWeekday))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addGap(30, 30, 30)
                                                            .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addGap(29, 29, 29)
                                                            .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(27, 27, 27)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtCurrentCourseTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(txtSearchCurrentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSearchCurrentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSaveCurrentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectSemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(semstertime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semstertime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchCurrentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCurrentCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtCurrentCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtCurrentCourseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCurrentCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtCurrentCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtCurrentSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrentCourseLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCurrentCourseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourseWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCourseEndTime2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrentStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStudentLimited2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(txtCurrentStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnSaveCurrentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtProfessor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        currentCourseScrollPane.setViewportView(jPanel1);

        manageCourseDetailTabbedPane.addTab("Current Course", currentCourseScrollPane);

        jLabel7.setText("Course ID:");

        jLabel11.setText("Course Topic:");

        jLabel12.setText("Course Name:");

        jLabel21.setText("Course point:");

        jLabel22.setText("Semester:");

        jLabel24.setText("Course Location:");

        jLabel25.setText("Course Time:");

        lblCourseEndTime1.setText("Course Weekday:");

        lblStudentLimited1.setText("Student Limited:");

        jLabel26.setText("Student Count:");

        jLabel16.setText("Professor");

        jLabel27.setText("Course Introduction");

        createCourseIntroductionTextArea.setColumns(20);
        createCourseIntroductionTextArea.setRows(5);
        jScrollPane7.setViewportView(createCourseIntroductionTextArea);

        btnCreate.setText("Create");

        btnView.setText("View");

        javax.swing.GroupLayout createCoursePanelLayout = new javax.swing.GroupLayout(createCoursePanel);
        createCoursePanel.setLayout(createCoursePanelLayout);
        createCoursePanelLayout.setHorizontalGroup(
            createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createCoursePanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createCoursePanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCreateCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCreateCourseName))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCreateCourseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22))
                            .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(createCoursePanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCreateSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(createCoursePanelLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(txtCreateCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(106, 106, 106)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseEndTime1)
                    .addComponent(jLabel25)
                    .addComponent(lblStudentLimited1)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24))
                .addGap(3, 3, 3)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCreateCourseLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(txtCreateWeekday))
                        .addComponent(txtCreateTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txtCreateStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(txtCreateStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(createCoursePanelLayout.createSequentialGroup()
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createCoursePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addGap(63, 63, 63)
                        .addComponent(btnView))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCreateProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createCoursePanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel27)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createCoursePanelLayout.setVerticalGroup(
            createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createCoursePanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createCoursePanelLayout.createSequentialGroup()
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCreateCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtCreateCourseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCreateCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtCreateCoursePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCreateSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createCoursePanelLayout.createSequentialGroup()
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCreateCourseLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtCreateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourseEndTime1)
                            .addComponent(txtCreateWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentLimited1)
                            .addComponent(txtCreateStudentLimited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtCreateStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCreateProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(createCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnView))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageCourseDetailTabbedPane.addTab("Create Course", createCoursePanel);

        javax.swing.GroupLayout manageCoursePanelLayout = new javax.swing.GroupLayout(manageCoursePanel);
        manageCoursePanel.setLayout(manageCoursePanelLayout);
        manageCoursePanelLayout.setHorizontalGroup(
            manageCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageCoursePanelLayout.createSequentialGroup()
                .addComponent(manageCourseDetailTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        manageCoursePanelLayout.setVerticalGroup(
            manageCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageCourseDetailTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Manage Courses", manageCoursePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        try{

            Map<String, String> semesterMap = semesters.stream()
                    .collect(Collectors.toMap(Semester::getSemesterName, Semester::getId));


            addCourse = new Course();
            addCourse.setName(txtCreateCourseName.getText());
            addCourse.setLocation(txtCreateCourseLocation.getText());
            addCourse.setId(txtCreateCourseId.getText());
            addCourse.setWeekday(txtCreateWeekday.getText());
            String[] timeParts = txtCreateTime.getText().split("-"); // 以破折号分割时间范围

            String startTime = timeParts[0]; // 提取开始时间
            String endTime = timeParts[1]; // 提取结束时间

            String semText = semstertime.getText();


            String dateRange = semText.replace("Semester Time: ", "");


            String[] dateParts = dateRange.split("~");


            String startDateStr = dateParts[0].trim().split(" ")[0];  // 拆分并获取日期部分
            String endDateStr = dateParts[1].trim().split(" ")[0];    // 拆分并获取日期部分


            String startcombinedDateTime = startDateStr + "T" + startTime;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime startlocalDateTime = LocalDateTime.parse(startcombinedDateTime, formatter);

            String endcombinedDateTime = endDateStr + "T" + endTime;

            LocalDateTime endlocalDateTime = LocalDateTime.parse(endcombinedDateTime, formatter);

            addCourse.setBeginTime(startlocalDateTime);
            addCourse.setEndTime(endlocalDateTime);
            addCourse.setPoint(Integer.parseInt(txtCreateCoursePoint.getText()));
            addCourse.setStudentLimit(Integer.parseInt(txtCreateStudentLimited.getText()));
            addCourse.setStudentCount(Integer.parseInt(txtCreateStudentCount.getText()));
            addCourse.setSemesterId(semesterMap.get(selectSemComboBox.getSelectedItem().toString()));
            addCourse.setStatus("Open");
            addCourse.setIntroduction(createCourseIntroductionTextArea.getText());
            addCourse.saveToDatabase(connection);

            CourseTopic courseTopic = new CourseTopic();
            courseTopic.addTopicToCourse(txtCreateCourseTopic.getText(), addCourse);

            CourseSchedule courseSchedule= new CourseSchedule(connection);
            courseSchedule.loadCourseInfoFromDatabase();
            CourseSchedule.CourseInfo courseInfo1 = new CourseSchedule.CourseInfo(txtCreateCourseId.getText(),txtCreateWeekday.getText(),startlocalDateTime.toString(),endlocalDateTime.toString());
            courseSchedule.insertCourseInfoIntoDatabase(courseInfo1);


            courseDirectory.addCourseProfessor(connection, addCourse.getId(), professor.getPersonID());

            JOptionPane.showMessageDialog(this, "Successfully Created!");
            txtCreateCourseName.setText("");
            txtCreateCourseLocation.setText("");
            txtCreateCourseId.setText("");
            txtCreateCoursePoint.setText("");
            txtCreateStudentLimited.setText("");
            createCourseIntroductionTextArea.setText("");
            txtCreateCourseTopic.setText("");
            txtCreateStudentCount.setText("");
            professor.updateProfessorupdateInDatabase(Timestamp.valueOf(LocalDateTime.now()),conn);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }

        populateTable("",thisterm);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSaveCurrentCourseActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btnSaveCurrentCourseActionPerformed
        // TODO add your handling code here:
        try{

            Map<String, String> semesterMap = semesters.stream()
                    .collect(Collectors.toMap(Semester::getSemesterName, Semester::getId));


            Course updateCourse = new Course();
            updateCourse.setName(txtCurrentCourseName.getText());
            updateCourse.setLocation(txtCurrentCourseLocation.getText());
            updateCourse.setId(txtCurrentCourseId.getText());
//            addCourse.setBeginTime(LocalDateTime.parse(txtCreateCourseStartTime.getText()));
//            addCourse.setEndTime(LocalDateTime.parse(txtCreateCourseEndTime.getText()));
//            updateCourse.setWeekday(txtCourseWeekday.getText());
            String[] timeParts = txtCurrentCourseTime.getText().split("-"); // 以破折号分割时间范围

            String startTime = timeParts[0]; // 提取开始时间
            String endTime = timeParts[1]; // 提取结束时间

            String semText = semstertime.getText();


            String dateRange = semText.replace("Semester Time: ", "");


            String[] dateParts = dateRange.split("~");


            String startDateStr = dateParts[0].trim().split(" ")[0];  // 拆分并获取日期部分
            String endDateStr = dateParts[1].trim().split(" ")[0];    // 拆分并获取日期部分

            System.out.println("startDateStr:::"+startDateStr);

            String startcombinedDateTime = startDateStr + "T" + startTime;

            System.out.println("startcombinedDateTime:::"+startcombinedDateTime);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime startlocalDateTime = LocalDateTime.parse(startcombinedDateTime, formatter);

            String endcombinedDateTime = endDateStr + "T" + endTime;

            LocalDateTime endlocalDateTime = LocalDateTime.parse(endcombinedDateTime, formatter);

            updateCourse.setBeginTime(startlocalDateTime);
            updateCourse.setEndTime(endlocalDateTime);
            updateCourse.setPoint(Integer.parseInt(txtCurrentCoursePoint.getText()));
            updateCourse.setStudentLimit(Integer.parseInt(txtCurrentStudentLimited.getText()));
            updateCourse.setStudentCount(Integer.parseInt(txtCurrentStudentCount.getText()));
            updateCourse.setSemesterId(semesterMap.get(txtCurrentSemester.getText()));
            updateCourse.setStatus("Open");
            updateCourse.setIntroduction(currentCourseIntroductionTextArea.getText());

            updateCourse.updateCourseToDatabase(connection);

            CourseTopic courseTopic = new CourseTopic();

            courseTopic.updateTopicToCourse(txtCurrentCourseTopic.getText(), updateCourse);
            CourseSchedule courseSchedule= new CourseSchedule(connection);
            courseSchedule.loadCourseInfoFromDatabase();
            CourseSchedule.CourseInfo courseInfo = courseSchedule.getCourseInfoByid(txtCurrentCourseId.getText());
            CourseSchedule.CourseInfo courseInfo1 = new CourseSchedule.CourseInfo(txtCurrentCourseId.getText(),txtCourseWeekday.getText(),startlocalDateTime.toString(),endlocalDateTime.toString());
            courseSchedule.updateCourseInfoInDatabase(courseInfo1,courseInfo);

//            courseDirectory.addCourseProfessor(connection, updateCourse.getId(), professor.getPersonID());

            JOptionPane.showMessageDialog(this, "Successfully Saved!");
//            txtCreateCourseName.setText("");
//            txtCreateCourseLocation.setText("");
//            txtCreateCourseId.setText("");
//            txtCreateCoursePoint.setText("");
//            txtCreateStudentLimited.setText("");
//            createCourseIntroductionTextArea.setText("");
//            txtCreateCourseTopic.setText("");
//            txtCreateStudentCount.setText("");
            professor.updateProfessorupdateInDatabase(Timestamp.valueOf(LocalDateTime.now()),conn);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        populateTable("",thisterm);
    }//GEN-LAST:event_btnSaveCurrentCourseActionPerformed

    private void btnSearchCourseActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSearchCourseActionPerformed

    }//GEN-LAST:event_btnSearchCourseActionPerformed

    private void btnSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchStudentActionPerformed

    private void selectSemComboBoxItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException {//GEN-FIRST:event_selectSemComboBoxItemStateChanged
        // TODO add your handling code here:
        System.out.println("selectSemComboBox.getSelectedItem().toString():"+selectSemComboBox.getSelectedItem().toString());
        populateTable("",selectSemComboBox.getSelectedItem().toString());
        jp.setValue(0);
//
        txtCurrentCourseId.setText("");
        txtCurrentCourseName.setText("");
        txtCurrentCourseTopic.setText("");
        txtCurrentSemester.setText("");
        txtProfessor1.setText("");
//        txtCurrentProfessorRegion.setText("");
        txtCurrentCourseLocation.setText("");
        currentCourseIntroductionTextArea.setText("");
        txtCurrentStudentLimited.setText("");
        txtCurrentStudentCount.setText("");
        txtCurrentCoursePoint.setText("");
        txtCurrentCourseTime.setText("");
        txtCourseWeekday.setText("");
        populateStudentTable(false,null,null);
//        txtCurrentProfessorLanguage.setText("");
    }//GEN-LAST:event_selectSemComboBoxItemStateChanged

    private void selectSemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSemComboBoxActionPerformed
        // TODO add your handling code here:
//        populateTable(thisterm);
    }//GEN-LAST:event_selectSemComboBoxActionPerformed

    private void btnSearchCurrentCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCurrentCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchCurrentCourseActionPerformed

    private void btnSearchCurrentCourseMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_btnSearchCurrentCourseMouseClicked
 // TODO add your handling code here:
        populateTable(txtSearchCurrentCourse.getText(),selectSemComboBox.getSelectedItem().toString());

        jp.setValue(0);
//
        txtCurrentCourseId.setText("");
        txtCurrentCourseName.setText("");
        txtCurrentCourseTopic.setText("");
        txtCurrentSemester.setText("");
        txtProfessor1.setText("");
//        txtCurrentProfessorRegion.setText("");
        txtCurrentCourseLocation.setText("");
        currentCourseIntroductionTextArea.setText("");
        txtCurrentStudentLimited.setText("");
        txtCurrentStudentCount.setText("");
        txtCurrentCoursePoint.setText("");
        txtCurrentCourseTime.setText("");
        txtCourseWeekday.setText("");
        populateStudentTable(false,null,null);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchCurrentCourseMouseClicked


    private void populateTable(String keywords,String semester) {
        DefaultTableModel model = (DefaultTableModel) tblCurrentCourses.getModel(); //Have the access to the table;
        model.setRowCount(0); //初始化
        professsorCourseList = getCreateCourses(keywords,semester);

        for(CourseVO course : professsorCourseList){

            Object[] row = new Object[4];
            row[0] = course.getId();
            row[1] = course.getName();
            row[2] = course.getTopics();
            DateTimeFormatter startformatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            String scheduletime =  course.getWeekday()+" "+course.getBeginTime().format(startformatter)+"-"+course.getEndTime().format(startformatter);

            row[3] = scheduletime;

            //设置3R对应

            model.addRow(row);

        }
    }

    public List<CourseVO> getCreateCourses(String keyWords,String semester){
        List<CourseVO>  professsorCourseList = new ArrayList<>();
        try {
             professsorCourseList = courseDirectory.loadCourseListByProfessorIdFromDatabase(keyWords,professor.getPersonID(),semester);
            return professsorCourseList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database is not work");
        }
        return professsorCourseList;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnSaveCurrentCourse;
    private javax.swing.JButton btnSearchCurrentCourse;
    private javax.swing.JButton btnView;
    private javax.swing.JTextArea createCourseIntroductionTextArea;
    private javax.swing.JPanel createCoursePanel;
    private javax.swing.JTextArea currentCourseIntroductionTextArea;
    private javax.swing.JScrollPane currentCourseScrollPane;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblCourseEndTime1;
    private javax.swing.JLabel lblCourseEndTime2;
    private javax.swing.JLabel lblStudentLimited1;
    private javax.swing.JLabel lblStudentLimited2;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JTabbedPane manageCourseDetailTabbedPane;
    private javax.swing.JPanel manageCoursePanel;
    private javax.swing.JComboBox<String> selectSemComboBox;
    private javax.swing.JLabel semstertime;
    private javax.swing.JTable tblCurrentCourses;
    private javax.swing.JTable tblStudent1;
    private javax.swing.JTextField txtCourseWeekday;
    private javax.swing.JTextField txtCreateCourseId;
    private javax.swing.JTextField txtCreateCourseLocation;
    private javax.swing.JTextField txtCreateCourseName;
    private javax.swing.JTextField txtCreateCoursePoint;
    private javax.swing.JTextField txtCreateCourseTopic;
    private javax.swing.JTextField txtCreateProfessor;
    private javax.swing.JTextField txtCreateSemester;
    private javax.swing.JTextField txtCreateStudentCount;
    private javax.swing.JTextField txtCreateStudentLimited;
    private javax.swing.JTextField txtCreateTime;
    private javax.swing.JTextField txtCreateWeekday;
    private javax.swing.JTextField txtCurrentCourseId;
    private javax.swing.JTextField txtCurrentCourseLocation;
    private javax.swing.JTextField txtCurrentCourseName;
    private javax.swing.JTextField txtCurrentCoursePoint;
    private javax.swing.JTextField txtCurrentCourseTime;
    private javax.swing.JTextField txtCurrentCourseTopic;
    private javax.swing.JTextField txtCurrentSemester;
    private javax.swing.JTextField txtCurrentStudentCount;
    private javax.swing.JTextField txtCurrentStudentLimited;
    private javax.swing.JTextField txtProfessor1;
    private javax.swing.JTextField txtSearchCurrentCourse;
    // End of variables declaration//GEN-END:variables
}
