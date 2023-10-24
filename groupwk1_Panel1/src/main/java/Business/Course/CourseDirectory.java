/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDirectory {
    private List<Course> courses;
    private Connection connection;

    public CourseDirectory(Connection connection) {
        courses = new ArrayList<>();
        this.connection = connection;
    }

    public void addCourse(Course course) throws SQLException {
        // 添加到内存
        courses.add(course);

        // 添加到数据库
        course.saveToDatabase(connection);
    }

    public void removeCourse(Course course) throws SQLException {
        // 从内存中删除
        courses.remove(course);

        // 从数据库中删除
        course.deleteFromDatabase(connection);
    }

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void loadCoursesFromDatabase() throws SQLException {
        String query = "SELECT * FROM Course";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.resultSetToCourse(resultSet);
                courses.add(course);
            }
        }
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}

