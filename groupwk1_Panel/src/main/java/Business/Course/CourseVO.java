package Business.Course;

import Tools.MySQLConnectionUtil;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 15469
 */

public class CourseVO {
    private String id;
    private String name;
    private String introduction;
    private int point;
    private String semesterId;

    private String semester;
    private String status;
    private String professor;
    private String region;
    private String language;
    private String location;
    private int studentLimit;
    private int studentCount;
    private String weekday;
    private LocalDateTime beginTime;

    private LocalDateTime endTime;
    private List<String> topics; // Store course topics
    private List<String> enrolledStudents; // Store enrolled student IDs


    private Double score;

    public CourseVO() {
    }
    public CourseVO(String id, String name, String introduction, int point, String semesterId, String status,
                    String professor, String location, int studentLimit, int studentCount, String weekday,LocalDateTime beginTime, LocalDateTime endTime,
                    String region, String language, String topics, String semester) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.point = point;
        this.semesterId = semesterId;
        this.semester = semester;
        this.status = status;
        this.professor = professor;
        this.location = location;
        this.studentLimit = studentLimit;
        this.studentCount = studentCount;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.topics = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.region = region;
        this.language = language;
        if(topics != null){
            this.topics = Arrays.asList(topics.split(","));
        }
    }
    public CourseVO(String id, String name, String introduction, int point, String semesterId, String status,
                    String professor, String location, int studentLimit, int studentCount,String weekday, LocalDateTime beginTime, LocalDateTime endTime,
                    Double score, String region, String language, String topics, String semester) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.point = point;
        this.semesterId = semesterId;
        this.semester = semester;
        this.status = status;
        this.professor = professor;
        this.location = location;
        this.studentLimit = studentLimit;
        this.studentCount = studentCount;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.topics = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.score = score;
        this.region = region;
        this.language = language;
        if(topics != null){
            this.topics = Arrays.asList(topics.split(","));
        }

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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setScore(Double score) {
        this.score = score;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
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
        String query = "INSERT INTO Course (id, name, introduction, point, semesterid, statue, location, studentlimited, studentcount, begintime, endtime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            statement.setTimestamp(10, Timestamp.valueOf(beginTime));
            statement.setTimestamp(11, Timestamp.valueOf(endTime));
            statement.executeUpdate();
        }
    }

    public void updateInDatabase(Connection connection) throws SQLException {
        String query = "UPDATE Course SET name = ?, introduction = ?, point = ?, semesterid = ?, statue = ?,  " +
                "location = ?, studentlimited = ?, studentcount = ?, begintime = ?, endtime = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, introduction);
            statement.setInt(4, point);
            statement.setString(5, semesterId);
            statement.setString(6, status);
//            statement.setString(7, professor);
            statement.setString(7, location);
            statement.setInt(8, studentLimit);
            statement.setInt(9, studentCount);
            statement.setTimestamp(10, Timestamp.valueOf(beginTime));
            statement.setTimestamp(11, Timestamp.valueOf(endTime));
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

    public static CourseVO getCourseFromDatabase(Connection connection, String courseId) throws SQLException {
        String query = "SELECT * FROM Course WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToCourseVO(resultSet);
            }
            return null;
        }
    }



    public static CourseVO resultSetToCourseVO(ResultSet resultSet) throws SQLException {
        double a;
        try{
            a= resultSet.getDouble("score");
        } catch (Exception e){
            a=0d;
        }
        return new CourseVO(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("introduction"),
                resultSet.getInt("point"),
                null,
                resultSet.getString("statue"),
                resultSet.getString("professor"),
                resultSet.getString("location"),
                resultSet.getInt("studentlimited"),
                resultSet.getInt("studentcount"),
                resultSet.getString("weekday"),
                resultSet.getTimestamp("begintime").toLocalDateTime(),
                resultSet.getTimestamp("endtime").toLocalDateTime(),
                a,
                resultSet.getString("region"),
                resultSet.getString("language"),
                resultSet.getString("topics"),
                resultSet.getString("semstername")
        );
    }
    public static CourseVO resultSetToProfessorCourseVO(ResultSet resultSet) throws SQLException {

        return new CourseVO(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("introduction"),
                resultSet.getInt("point"),
                null,
                resultSet.getString("statue"),
                resultSet.getString("professor"),
                resultSet.getString("location"),
                resultSet.getInt("studentlimited"),
                resultSet.getInt("studentcount"),
                resultSet.getString("weekday"),
                resultSet.getTimestamp("begintime").toLocalDateTime(),
                resultSet.getTimestamp("endtime").toLocalDateTime(),
                resultSet.getString("region"),
                resultSet.getString("language"),
                resultSet.getString("topics"),
                resultSet.getString("semstername")
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

    public String calculateGPA(String studentId, List<String> semesters) throws SQLException {
        CourseDirectory courseDirectory=new CourseDirectory(MySQLConnectionUtil.getConnection());
        List<CourseVO> courses = courseDirectory.loadCourseListByStudentIdListSemFromDatabase("",studentId,semesters);

        double totalScoreTimesPoint = 0.0;
        double totalPoints = 0.0;

        for (CourseVO course : courses) {
            totalPoints += course.getPoint();
            totalScoreTimesPoint += scoreToGPA(course.getScore()) * course.getPoint();
        }

        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(totalScoreTimesPoint / totalPoints);
    }

    private double scoreToGPA(double score) {
        if (score >= 90) return 4.0;
        if (score >= 80) return 3.0;
        if (score >= 70) return 2.0;
        if (score >= 60) return 1.0;
        return 0.0;
    }


}
