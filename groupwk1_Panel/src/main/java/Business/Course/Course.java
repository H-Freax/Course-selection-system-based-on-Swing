package Business.Course;

import Business.Person.Student;

import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Business.Person.Professor;

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
    private String region;
    private int studentLimit;
    private int studentCount;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private List<String> topics; // Store course topics
    private List<String> enrolledStudents; // Store enrolled student IDs

    private double score;

    public Course() {
    }

    public Course(String id, String name, String introduction, int point, String semesterId, String status,
                  String professor, String location, int studentLimit, int studentCount, LocalDateTime beginTime, LocalDateTime endTime,
                  double score) {
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
        this.score = score;
    }

    public Course(String id, String name,String region) {
        this.id = id;
        this.name = name;
        this.region = region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
        String query = "INSERT INTO Course (id, name, introduction, point, semesterid, statue, location, studentlimited, studentcount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, introduction);
            statement.setInt(4, point);
            statement.setString(5, semesterId);
            statement.setString(6, status);
            statement.setString(7, location);
            statement.setInt(8, studentLimit);
            statement.setInt(9, studentCount);
//            statement.setTimestamp(11, Timestamp.valueOf(beginTime));
//            statement.setTimestamp(12, Timestamp.valueOf(endTime));
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
                resultSet.getTimestamp("endtime").toLocalDateTime(),
                resultSet.getDouble("score")
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
//        enrolledStudents.remove(studentId);
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

    //update Student-Edition
    //Student Enroll
    public void updateStudentCountInCourse(Connection connection, int count) throws SQLException {
        String query = "UPDATE Course SET studentcount = studentcount + ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, count);
            statement.setString(2, id);
            //去数据库执行
            statement.executeUpdate();
        }
    }

    public boolean isEnrolledStudentInCourseById(Connection connection, Student student) throws SQLException {
        String query = "select cs.studuent_id from Course c left join CourseStudent cs " +
                "on c.id = cs.course_id " +
                "where cs.course_id =? and cs.studuent_id =? ";
        String studentId = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, student.getPersonID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                studentId = resultSet.getString("studuent_id");
            }
        }
        return studentId != null;
    }

    public static Course resultSetToCourse2(ResultSet resultSet) throws SQLException {
        return new Course(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("region")
        );
    }
//    Starttime
//    EndTime暂定
    public void updateCourseToDatabase(Connection connection) throws SQLException {
        String query = "UPDATE Course SET name = ?, introduction = ?, point = ?, semesterid = ?, statue = ?, " +
                "location = ?, studentlimited = ?, studentcount = ? WHERE id = ?";
//        String query = "UPDATE Course SET name = ?, introduction = ?, point = ?, semesterid = ?, statue = ?, " +
//                "location = ?, studentlimited = ?, studentcount = ?, begintime = ?, endtime = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, introduction);
            statement.setInt(3, point);
            statement.setString(4, semesterId);
            statement.setString(5, status);
            statement.setString(6, location);
            statement.setInt(7, studentLimit);
            statement.setInt(8, studentCount);
//            statement.setTimestamp(11, Timestamp.valueOf(beginTime));
//            statement.setTimestamp(12, Timestamp.valueOf(endTime));
            statement.setString(9, id);
            statement.executeUpdate();
        }
    }

    public List<Course> getCourseListByProfessor(Connection connection, Professor professor){
        List<Course> courseList = new ArrayList<>();

        String query = "SELECT c.*, p.region  from professor p right join courseprofessor cp on p.id = cp.professor_id " +
                "  left join course c on cp.course_id = c.id " +
                "  where p.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, professor.getPersonID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Course course = resultSetToCourse2(resultSet);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }
        return courseList;
    }

}
