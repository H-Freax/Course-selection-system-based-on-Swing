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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 15469
 */

public class Course {
    private String id;
    private String name;
    private String introduction;
    private int point;
    private String semesterId;
    private String status;
    private String professor;
    private String location;
    private int studentLimit;
    private int studentCount;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private List<String> topics; // Store course topics
    private List<String> enrolledStudents; // Store enrolled student IDs

    public Course() {
    }

    public Course(String id, String name, String introduction, int point, String semesterId, String status,
                  String professor, String location, int studentLimit, int studentCount, LocalDateTime beginTime, LocalDateTime endTime) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.point = point;
        this.semesterId = semesterId;
        this.status = status;
        this.professor = professor;
        this.location = location;
        this.studentLimit = studentLimit;
        this.studentCount = studentCount;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.topics = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter and Setter methods for class properties

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStudentLimit() {
        return studentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        this.studentLimit = studentLimit;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    // Methods to add and remove topics
    public void addTopic(String topic) {
        topics.add(topic);
    }

    public void removeTopic(String topic) {
        topics.remove(topic);
    }

    // Methods to add and remove enrolled students
    public void addEnrolledStudent(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void removeEnrolledStudent(String studentId) {
        enrolledStudents.remove(studentId);
    }

    // Additional methods for database interaction
    // ... (methods to save, update, delete course in the database, and retrieve course details)


    public void saveToDatabase(Connection connection) throws SQLException {
        String query = "INSERT INTO Course (id, name, introduction, point, semesterid, statue, professor, location, studentlimited, studentcount, begintime, endtime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, introduction);
            statement.setInt(4, point);
            statement.setString(5, semesterId);
            statement.setString(6, status);
            statement.setString(7, professor);
            statement.setString(8, location);
            statement.setInt(9, studentLimit);
            statement.setInt(10, studentCount);
            statement.setTimestamp(11, Timestamp.valueOf(beginTime));
            statement.setTimestamp(12, Timestamp.valueOf(endTime));
            statement.executeUpdate();
        }
    }

    public void updateInDatabase(Connection connection) throws SQLException {
        String query = "UPDATE Course SET name = ?, introduction = ?, point = ?, semesterid = ?, statue = ?, professor = ?, " +
                "location = ?, studentlimited = ?, studentcount = ?, begintime = ?, endtime = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, introduction);
            statement.setInt(4, point);
            statement.setString(5, semesterId);
            statement.setString(6, status);
            statement.setString(7, professor);
            statement.setString(8, location);
            statement.setInt(9, studentLimit);
            statement.setInt(10, studentCount);
            statement.setTimestamp(11, Timestamp.valueOf(beginTime));
            statement.setTimestamp(12, Timestamp.valueOf(endTime));
            statement.executeUpdate();
        }
    }

    public void deleteFromDatabase(Connection connection) throws SQLException {
        String query = "DELETE FROM Course WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }

    public static Course getCourseFromDatabase(Connection connection, String courseId) throws SQLException {
        String query = "SELECT * FROM Course WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToCourse(resultSet);
            }
            return null;
        }
    }
    public static Course resultSetToCourse(ResultSet resultSet) throws SQLException {
        return new Course(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("introduction"),
                resultSet.getInt("point"),
                resultSet.getString("semesterid"),
                resultSet.getString("statue"),
                resultSet.getString("professor"),
                resultSet.getString("location"),
                resultSet.getInt("studentlimited"),
                resultSet.getInt("studentcount"),
                resultSet.getTimestamp("begintime").toLocalDateTime(),
                resultSet.getTimestamp("endtime").toLocalDateTime()
        );
    }
    public void addTopic(Connection connection, String topic) throws SQLException {
        String query = "INSERT INTO CourseTopic (course_id, topic) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
        topics.add(topic);
    }

    public void removeTopic(Connection connection, String topic) throws SQLException {
        String query = "DELETE FROM CourseTopic WHERE course_id = ? AND topic = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
        topics.remove(topic);
    }

    public void addEnrolledStudent(Connection connection, String studentId) throws SQLException {
        String query = "INSERT INTO CourseStudent (course_id, studuent_id, score) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, studentId);
            statement.setDouble(3, 0.0); // Initialize with a default score
            statement.executeUpdate();
        }
        enrolledStudents.add(studentId);
    }

    public void removeEnrolledStudent(Connection connection, String studentId) throws SQLException {
        String query = "DELETE FROM CourseStudent WHERE course_id = ? AND studuent_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, studentId);
            statement.executeUpdate();
        }
        enrolledStudents.remove(studentId);
    }

    public int calculateStudentCount(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS studentCount FROM CourseStudent WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                studentCount = resultSet.getInt("studentCount");
            }
        }
        return studentCount;
    }

    public double calculateAverageScore(Connection connection) throws SQLException {
        String query = "SELECT AVG(score) AS averageScore FROM CourseStudent WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("averageScore");
            }
            return 0.0;
        }
    }

}
