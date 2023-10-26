/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Coursevo.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseStudent {
    private Map<String, Double> studentGrades;
    private Connection connection;

    public CourseStudent(Connection connection) {
        studentGrades = new HashMap<>();
        this.connection = connection;
    }

    public void enrollStudentInCourse(String studentId, Course course) throws SQLException {
        // 添加到内存
        studentGrades.put(studentId, 0.0); // 初始化成绩为0.0

        // 添加到数据库
        saveStudentEnrollmentInDatabase(studentId, course.getId());
    }

    public void unenrollStudentFromCourse(String studentId, Course course) throws SQLException {
        // 从内存中删除
        studentGrades.remove(studentId);

        // 从数据库中删除
        deleteStudentEnrollmentFromDatabase(studentId, course.getId());
    }

    public double getStudentGradeInCourse(String studentId, Course course) {
        return studentGrades.getOrDefault(studentId, 0.0);
    }

    public void loadStudentEnrollmentsFromDatabase(Course course) throws SQLException {
        String query = "SELECT * FROM CourseStudent WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                double grade = resultSet.getDouble("score");
                studentGrades.put(studentId, grade);
            }
        }
    }

    private void saveStudentEnrollmentInDatabase(String studentId, String courseId) throws SQLException {
        String query = "INSERT INTO CourseStudent (course_id, student_id, score) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            statement.setString(2, studentId);
            statement.setDouble(3, 0.0); // 初始化成绩为0.0
            statement.executeUpdate();
        }
    }

    private void deleteStudentEnrollmentFromDatabase(String studentId, String courseId) throws SQLException {
        String query = "DELETE FROM CourseStudent WHERE course_id = ? AND student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            statement.setString(2, studentId);
            statement.executeUpdate();
        }
    }
    
     public List<CourseData> getAllCoursesDataForStudent(String studentId) throws SQLException {
        List<CourseData> courseDataList = new ArrayList<>();
        String query = "SELECT * FROM CourseStudent WHERE student_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String courseId = resultSet.getString("course_id");
                double grade = resultSet.getDouble("score");
                CourseData courseData = new CourseData(courseId, grade);
                courseDataList.add(courseData);
            }
        }
        
        return courseDataList;
    }

    // 内部类，用于封装课程数据
    public class CourseData {
        private String courseId;
        private double grade;

        public CourseData(String courseId, double grade) {
            this.courseId = courseId;
            this.grade = grade;
        }

        public String getCourseId() {
            return courseId;
        }

        public double getGrade() {
            return grade;
        }
    }
    
    public List<StudentData> getAllStudentsDataForCourse(Course course) throws SQLException {
        List<StudentData> studentDataList = new ArrayList<>();
        String query = "SELECT * FROM CourseStudent WHERE course_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                double grade = resultSet.getDouble("score");
                StudentData studentData = new StudentData(studentId, grade);
                studentDataList.add(studentData);
            }
        }
        
        return studentDataList;
    }

    // 内部类，用于封装学生数据
    public class StudentData {
        private String studentId;
        private double grade;

        public StudentData(String studentId, double grade) {
            this.studentId = studentId;
            this.grade = grade;
        }

        public String getStudentId() {
            return studentId;
        }

        public double getGrade() {
            return grade;
        }
    }
    
}
