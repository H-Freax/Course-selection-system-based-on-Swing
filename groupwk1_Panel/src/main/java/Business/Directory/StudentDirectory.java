/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Person.Student;
import Tools.MySQLConnectionUtil;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDirectory {
    private List<Student> studentList;

    public StudentDirectory() {
        studentList = new ArrayList<>();

        //给studentList赋值

        try {
            loadStudentsFromDatabase(MySQLConnectionUtil.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
    }



    // 添加学生到目录
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // 从目录中移除学生
    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public Student findStudentbyUsername(String username) {
        for (Student student : studentList) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }
    // 通过学生ID查找学生
    public Student findStudent(String personID) {
        for (Student student : studentList) {
            if (student.getPersonID().equals(personID)) {
                return student;
            }
        }
        return null;
    }

    // 从数据库加载所有学生信息
    public void loadStudentsFromDatabase(Connection connection) throws SQLException {
        List<Student> studentsFromDB = Student.loadAllFromDatabase(connection);
        studentList.addAll(studentsFromDB);
    }

    // 从目录中保存所有学生信息到数据库
    public void saveStudentsToDatabase(Connection connection) throws SQLException {
        for (Student student : studentList) {
            student.saveToDatabase(connection);
        }
    }

    // 从目录中更新所有学生信息到数据库
    public void updateStudentsInDatabase(Connection connection) throws SQLException {
        for (Student student : studentList) {
            student.updateStudentInDatabase(connection);
        }
    }
}
