package Business.ProfessorTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorTopic {
    private String professorID;
    private String topic;

    public ProfessorTopic(String professorID, String topic) {
        this.professorID = professorID;
        this.topic = topic;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // 保存 ProfessorTopic 对象到数据库
    public void saveToDatabase(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO ProfessorTopic (professor_id, topic) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, professorID);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
    }

    // 从数据库加载所有与特定教授相关的话题
    public static List<ProfessorTopic> loadAllByProfessorID(Connection connection, String professorID) throws SQLException {
        List<ProfessorTopic> topics = new ArrayList<>();
        String selectQuery = "SELECT * FROM ProfessorTopic WHERE professor_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, professorID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String topic = resultSet.getString("topic");
                ProfessorTopic professorTopic = new ProfessorTopic(professorID, topic);
                topics.add(professorTopic);
            }
        }
        return topics;
    }

    // 从数据库删除特定教授的话题
    public void removeFromDatabase(Connection connection) throws SQLException {
        String deleteQuery = "DELETE FROM ProfessorTopic WHERE professor_id = ? AND topic = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setString(1, professorID);
            statement.setString(2, topic);
            statement.executeUpdate();
        }
    }
}
