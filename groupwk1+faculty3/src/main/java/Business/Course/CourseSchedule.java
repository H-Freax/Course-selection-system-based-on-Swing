/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    private List<Course> courseSchedule;
    private Connection connection;

    public CourseSchedule(Connection connection) {
        courseSchedule = new ArrayList<>();
        this.connection = connection;
    }

    public void addCourseToSchedule(Course course) throws SQLException {
        // 添加到内存
        courseSchedule.add(course);

        // 添加到数据库
        saveCourseToScheduleInDatabase(course);
    }

    public void removeCourseFromSchedule(Course course) throws SQLException {
        // 从内存中删除
        courseSchedule.remove(course);

        // 从数据库中删除
        deleteCourseFromScheduleInDatabase(course);
    }

    public Course getCourseFromScheduleById(String courseId) {
        for (Course course : courseSchedule) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void loadCourseScheduleFromDatabase() throws SQLException {
        String query = "SELECT * FROM CourseSchedule";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.getCourseFromDatabase(connection, resultSet.getString("courseId"));
                courseSchedule.add(course);
            }
        }
    }

    public List<Course> getAllCoursesInSchedule() {
        return courseSchedule;
    }

    private void saveCourseToScheduleInDatabase(Course course) throws SQLException {
        String query = "INSERT INTO CourseSchedule (courseId) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }

    private void deleteCourseFromScheduleInDatabase(Course course) throws SQLException {
        String query = "DELETE FROM CourseSchedule WHERE courseId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }
}
