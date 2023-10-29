/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.UserInterface.WorkAreas.FacultyRole.Schedule;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseVO;
import Business.Person.Person;
import Business.Person.PersonSchedule;
import Business.Person.Professor;
import Tools.MySQLConnectionUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zhangjinming
 */
public class FacultyScheduleJPanel extends JPanel {

    private JPanel ViewContainer;
    private Professor professor;

    private CourseDirectory courseDirectory;

    /**
     * Creates new form FacultyScheduleJPanel
     */
    public FacultyScheduleJPanel(JPanel ViewContainer, Professor professor) {

        initComponents();
        this.ViewContainer= ViewContainer;
        this.professor = professor;
        courseDirectory = new CourseDirectory();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        scheduleTable = new JTable();
        btnCalendar = new JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setText("My Schedule");

        scheduleTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Name", "Course Location", "Course Time"
            }
        ));
        jScrollPane1.setViewportView(scheduleTable);

        btnCalendar.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCalendar.setText("Add To Calendar");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalendar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(575, 575, 575))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnCalendar)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCalendar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable scheduleTable;
    // End of variables declaration//GEN-END:variables

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel)scheduleTable.getModel();
        model.setRowCount(0);

        try {

            List<CourseVO> courseVOList = courseDirectory.loadCourseListFromDatabase(null, professor.getPersonID());

            for(CourseVO course : courseVOList){
                Object[] row = new Object[3];
                row[0] = course.getName();
                row[1] = course.getLocation();
                row[2] = course.getBeginTime();
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
    }

}
