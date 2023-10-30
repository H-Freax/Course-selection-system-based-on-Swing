/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.StudentRole.Schedule;

import Business.Person.Student;
import ui.UserInterface.WorkAreas.FacultyRole.Schedule.*;
import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseVO;
import Business.Person.Person;
import Business.Person.PersonSchedule;
import Business.Person.Professor;
import Business.Semester.Semester;
import Tools.IcsGenerator;
import Tools.MySQLConnectionUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zhangjinming
 */
public class StudentScheduleJPanel extends JPanel {

    private JPanel ViewContainer;
    private Student student;
    private String thisterm;
    private CourseDirectory courseDirectory=new CourseDirectory();

    private List<Semester> semesters;

    private Semester sem;
    Connection connection=MySQLConnectionUtil.getConnection();
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * Creates new form FacultyScheduleJPanel
     */
    public StudentScheduleJPanel(JPanel ViewContainer, Student student) throws SQLException {

        initComponents();
        this.ViewContainer= ViewContainer;
        this.student= student;
        this.thisterm="Fall 2023";
        semesters = Semester.getAllSemestersFromDatabase(connection);
//        Semester sem=null;
        for(Semester s: semesters){
            if(s.getSemesterName().equals(thisterm)){
                sem=s;
                labelSemesterTime.setText("Semester Time: "+s.getSemesterStart().format(formatter) +"-" +s.getSemesterEnd().format(formatter));
            }
            cbSemester.addItem(s.getSemesterName());
        }



        populateTable(thisterm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        btnCalendar = new javax.swing.JButton();
        cbSemester = new javax.swing.JComboBox<>();
        labelSemesterTime = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setText("My Schedule");

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Name", " Location", "Course Time", "Semster"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(scheduleTable);
        if (scheduleTable.getColumnModel().getColumnCount() > 0) {
            scheduleTable.getColumnModel().getColumn(1).setPreferredWidth(2);
        }

        btnCalendar.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCalendar.setText("Add To Calendar");
        btnCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarActionPerformed(evt);
            }
        });

        cbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSemesterItemStateChanged(evt);
            }
        });

        labelSemesterTime.setText("Semester Time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSemesterTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCalendar)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSemesterTime))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnCalendar)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSemesterItemStateChanged
        // TODO add your handling code here:
        thisterm = cbSemester.getSelectedItem().toString();
        for(Semester s: semesters){
            if(s.getSemesterName().equals(thisterm)){
                sem=s;
                labelSemesterTime.setText("Semester Time: "+s.getSemesterStart().format(formatter) +"-" +s.getSemesterEnd().format(formatter));

            }
        }
        populateTable(thisterm);
    }//GEN-LAST:event_cbSemesterItemStateChanged

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = scheduleTable.getSelectedRows();

        if (selectedRows.length == 0) {
            // 如果没有选中行，显示错误提示
            JOptionPane.showMessageDialog(this, "Please select at least one course to add to the calendar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                for (int selectedRow : selectedRows) {
                    // 获取选中行的数据
                    String courseName = (String) scheduleTable.getValueAt(selectedRow, 0);
                    String location = (String) scheduleTable.getValueAt(selectedRow, 1);
                    String courseTime = (String) scheduleTable.getValueAt(selectedRow, 2);

                    // 这里获取选中的日期等信息，你需要根据表格的列索引来获取相应数据
                    String[] parts = courseTime.split(" "); // 以空格分割字符串

                    String weekday = parts[0]; // 提取星期几
                    String timeRange = parts[1]; // 提取时间范围

                    String[] timeParts = timeRange.split("-"); // 以破折号分割时间范围

                    String startTime = timeParts[0]; // 提取开始时间
                    String endTime = timeParts[1]; // 提取结束时间
                    // 生成 ICS 文件
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date startDate = dateFormat.parse(sem.getSemesterStart().format(formatter)); // 将字符串日期转换为 Date
                    Date endDate = dateFormat.parse(sem.getSemesterEnd().format(formatter)); // 将字符串日期转换为 Date
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date startTimeDate = timeFormat.parse(startTime); // 将字符串时间转换为 Date
                    Date endTimeDate = timeFormat.parse(endTime); // 将字符串时间转换为 Date

                    IcsGenerator.generateICS(courseName, location, startDate, endDate, weekday, startTimeDate, endTimeDate, LocalDateTime.now()+"courseschedule.ics");
//                    IcsGenerator.generateICS(courseName, location, sem.getSemesterStart(), sem.getSemesterEnd(), weekday, startTime, endTime, LocalDateTime.now()+"courseschedule.ics");

                    // 如果需要在每次生成 ICS 文件后清除选中行，可以添加以下代码
                    // scheduleTable.getSelectionModel().clearSelection();
                }

                // 显示成功提示
                JOptionPane.showMessageDialog(this, "ICS files generated successfully and saved to the specified location.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                // 显示错误提示
                JOptionPane.showMessageDialog(this, "Error generating ICS files.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCalendarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendar;
    private javax.swing.JComboBox<String> cbSemester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSemesterTime;
    private javax.swing.JTable scheduleTable;
    // End of variables declaration//GEN-END:variables

    private void populateTable(String semster){
        DefaultTableModel model = (DefaultTableModel)scheduleTable.getModel();
        model.setRowCount(0);

        try {

            List<CourseVO> courseVOList = courseDirectory.loadCourseListByStudentIdSemFromDatabase(null, student.getPersonID(),semster);

            for(CourseVO course : courseVOList){
                Object[] row = new Object[4];
                row[0] = course.getName();
                row[1] = course.getLocation();
                DateTimeFormatter startformatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                String scheduletime =  course.getWeekday()+" "+course.getBeginTime().format(startformatter)+"-"+course.getEndTime().format(startformatter);

                row[2] = scheduletime;
                row[3] = course.getSemester();
                model.addRow(row);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
    }

}
