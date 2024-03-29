package Business.Course;
import Tools.MySQLConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseTopic {
    private List<String> topics;
    private Connection connection;

    public CourseTopic() {
        topics = new ArrayList<>();
        this.connection = MySQLConnectionUtil.getConnection();
    }

    public void addTopicToCourse(String topic, Course course) throws SQLException {
        // 添加到内存
        topics.add(topic);

        // 添加到数据库
        saveTopicToDatabase(topic, course.getId());
    }

    public void removeTopicFromCourse(String topic, Course course) throws SQLException {
        // 从内存中删除
        topics.remove(topic);

        // 从数据库中删除
        deleteTopicFromDatabase(topic, course.getId());
    }

    public List<String> getTopicsOfCourse(Course course) {
        return topics;
    }

    public void loadTopicsFromDatabase(Course course) throws SQLException {
        String query = "SELECT * FROM CourseTopic WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String topic = resultSet.getString("topic");
                topics.add(topic);
            }
        }
    }

    private void saveTopicToDatabase(String topic, String courseId) throws SQLException {
        String query = "INSERT INTO CourseTopic (course_id, topic) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
    }

    private void deleteTopicFromDatabase(String topic, String courseId) throws SQLException {
        String query = "DELETE FROM CourseTopic WHERE course_id = ? AND topic = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
    }

    public void updateTopicToCourse(String topic, Course updateCourse) throws SQLException {
        String query = "UPDATE CourseTopic SET  topic = ? WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, topic);
            statement.setString(2, updateCourse.getId());

            statement.executeUpdate();
        }
    }
}
