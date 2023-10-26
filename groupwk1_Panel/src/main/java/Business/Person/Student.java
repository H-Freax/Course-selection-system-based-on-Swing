/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Tools.PasswordUtils;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {

    private String username;
    private String nowPassword;
    private boolean enabled;
    private double gpa;
    private List<String> courseList; // 用于存储学生的课程信息
    private Set<String> passwordHistory;

    public Student(){

    }
    public Student(String personName, String personID, String username, String nowPassword, boolean enabled, double gpa) {
        super(personName, personID, "Student");
        this.nowPassword = PasswordUtils.hashPassword(nowPassword);
        this.username = username;
        this.enabled = enabled;
        this.gpa = gpa;
        this.courseList = new ArrayList<>();
        this.passwordHistory = new HashSet<>();
    }

    public Set<String> getPasswordHistory() {
        return passwordHistory;
    }

    public void setPasswordHistory(Set<String> passwordHistory) {
        this.passwordHistory = passwordHistory;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNowPassword() {
        return nowPassword;
    }

    public void setNowPassword(String nowPassword) {
        this.nowPassword = PasswordUtils.hashPassword(nowPassword);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public boolean updatePassword(Connection connection, String newPassword) throws SQLException {
        String newPwdHash = PasswordUtils.hashPassword(newPassword);
        if (!getPasswordHistory(connection).contains(newPwdHash)) {
            savePasswordToHistory(connection, getPersonID(), getNowPassword());
            setNowPassword(newPassword);
            return true;
        } else {
            return false;
        }
    }

    public void addCourse(String courseID) {
        courseList.add(courseID);
    }

    public void removeCourse(String courseID) {
        courseList.remove(courseID);
    }
    public boolean checkLogin(Connection connection,String inputUsername, String inputPassword, String role) throws SQLException {
        return PasswordUtils.verifyLogin(connection,inputUsername,inputPassword,role);
    }
    public void saveToDatabase(Connection connection) throws SQLException {
        super.saveToDatabase(connection);

        String insertStudentQuery = "INSERT INTO Student (id, username, nowpassword, enabled, gpa, lastactive, lastupdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertStudentQuery)) {
            statement.setString(1, getPersonID());
            statement.setString(2, username);
            statement.setString(3, nowPassword);
            statement.setString(4, enabled ? "1" : "0");
            statement.setDouble(5, gpa);
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            statement.executeUpdate();
        }

        for (String courseID : courseList) {
            addStudentToCourse(connection, courseID, getPersonID());
        }
    }

    public void updateStudentInDatabase(Connection connection) throws SQLException {
        super.updateInDatabase(connection);

        String updateStudentQuery = "UPDATE Student SET username = ?, nowpassword = ?, enabled = ?, gpa = ?, lastactive = ?, lastupdate = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateStudentQuery)) {
            statement.setString(1, username);
            statement.setString(2, nowPassword);
            statement.setString(3, enabled ? "1" : "0");
            statement.setDouble(4, gpa);
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(7, getPersonID());
            statement.executeUpdate();
        }

        for (String courseID : courseList) {
            addStudentToCourse(connection, courseID, getPersonID());
        }
    }

    public static Student loadFromDatabase(Connection connection, String personID) throws SQLException {
        Person person = Person.loadFromDatabase(connection, personID);
        if (person == null) {
            return null;
        }

        String selectStudentQuery = "SELECT * FROM Student WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectStudentQuery)) {
            statement.setString(1, personID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("nowpassword");
                boolean enabled = resultSet.getString("enabled").equals("1");
                double gpa = resultSet.getDouble("gpa");

                Student student = new Student(person.getPersonName(), personID, username, password, enabled, gpa);
                student.loadCourses(connection);
                return student;
            }
        }
        return null;
    }

    public void loadCourses(Connection connection) throws SQLException {
        String selectCoursesQuery = "SELECT course_id FROM CourseStudent WHERE studuent_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectCoursesQuery)) {
            statement.setString(1, getPersonID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String courseID = resultSet.getString("course_id");
                courseList.add(courseID);
            }
        }
    }

    public static List<Student> loadAllFromDatabase(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        String selectStudentsQuery = "SELECT * FROM Student ";
        try (PreparedStatement statement = connection.prepareStatement(selectStudentsQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String personID = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("nowpassword");
                boolean enabled = resultSet.getString("enabled").equals("1");
                double gpa = resultSet.getDouble("gpa");
                Person p = Person.loadFromDatabase(connection, personID);
                Student student = new Student(p.getPersonName(), personID, username, password, enabled, gpa);
                student.loadCourses(connection);
                students.add(student);
            }
        }
        return students;
    }

    public static void deleteFromDatabase(Connection connection, String personID) throws SQLException {
        String deleteStudentQuery = "DELETE FROM Student WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteStudentQuery)) {
            statement.setString(1, personID);
            statement.executeUpdate();
        }

        deleteFromCourseStudent(connection, personID);
        Person.deleteFromDatabase(connection, personID);
    }

    private List<String> getPasswordHistory(Connection connection) throws SQLException {
        List<String> passwordHistory = new ArrayList<>();
        String selectPasswordHistoryQuery = "SELECT password FROM Historypwd WHERE personid = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectPasswordHistoryQuery)) {
            statement.setString(1, getPersonID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                passwordHistory.add(password);
            }
        }
        return passwordHistory;
    }

    private void savePasswordToHistory(Connection connection, String personID, String password) throws SQLException {
        String insertPasswordHistoryQuery = "INSERT INTO Historypwd (personid, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertPasswordHistoryQuery)) {
            statement.setString(1, personID);
            statement.setString(2, password);
            statement.executeUpdate();
        }
    }

    private static void addStudentToCourse(Connection connection, String courseID, String studentID) throws SQLException {
        String insertCourseStudentQuery = "INSERT INTO CourseStudent (course_id, student_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertCourseStudentQuery)) {
            statement.setString(1, courseID);
            statement.setString(2, studentID);
            statement.executeUpdate();
        }
    }

    private static void deleteFromCourseStudent(Connection connection, String studentID) throws SQLException {
        String deleteCourseStudentQuery = "DELETE FROM CourseStudent WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteCourseStudentQuery)) {
            statement.setString(1, studentID);
            statement.executeUpdate();
        }
    }
}
