package Business.Rate;
import Tools.MySQLConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rate {
    private String professorId;
    private String studentId;
    private String courseId;
    private String scorePart1;
    private String scorePart2;
    private String scorePart3;
    private String scorePart4;
    private String comment;
    private String score;

    public Rate(String professorId, String studentId, String courseId, String scorePart1, String scorePart2,
                String scorePart3, String scorePart4, String comment, String score) throws SQLException {
        this.professorId = professorId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.scorePart1 = scorePart1;
        this.scorePart2 = scorePart2;
        this.scorePart3 = scorePart3;
        this.scorePart4 = scorePart4;
        this.comment = comment;
        this.score = score;
        
    }

    public String getProfessorId() {
        return professorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getScorePart1() {
        return scorePart1;
    }

    public String getScorePart2() {
        return scorePart2;
    }

    public String getScorePart3() {
        return scorePart3;
    }

    public String getScorePart4() {
        return scorePart4;
    }

    public String getComment() {
        return comment;
    }

    public String getScore() {
        return score;
    }

    
    public static List<Rate> loadAllRatesFromDatabase(Connection connection) throws SQLException {
        List<Rate> rates = new ArrayList<>();
        String query = "SELECT * FROM Rate";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String professorId = resultSet.getString("professor_id");
                String studentId = resultSet.getString("student_id");
                String courseId = resultSet.getString("course_id");
                String scorePart1 = resultSet.getString("scorepart1");
                String scorePart2 = resultSet.getString("scorepart2");
                String scorePart3 = resultSet.getString("scorepart3");
                String scorePart4 = resultSet.getString("scorepart4");
                String comment = resultSet.getString("comment");
                String score = resultSet.getString("score");
                Rate rate = new Rate(professorId, studentId, courseId, scorePart1, scorePart2, scorePart3, scorePart4, comment, score);
                rates.add(rate);
            }
        }
        return rates;
    }
    
    
    public void saveToDatabase(Connection connection) throws SQLException {
        String query = "INSERT INTO Rate (professor_id, student_id, course_id, scorepart1, scorepart2, scorepart3, scorepart4, comment, score) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, professorId);
            statement.setString(2, studentId);
            statement.setString(3, courseId);
            statement.setString(4, scorePart1);
            statement.setString(5, scorePart2);
            statement.setString(6, scorePart3);
            statement.setString(7, scorePart4);
            statement.setString(8, comment);
            statement.setString(9, score);
            statement.executeUpdate();
        }
    }

    public static List<Rate> getAllRatesFromDatabase() throws SQLException {
        List<Rate> rates = new ArrayList<>();
        Connection connection = MySQLConnectionUtil.getConnection();
        rates = loadAllRatesFromDatabase(connection);
        String query = "SELECT * FROM Rate";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String professorId = resultSet.getString("professor_id");
                String studentId = resultSet.getString("student_id");
                String courseId = resultSet.getString("course_id");
                String scorePart1 = resultSet.getString("scorepart1");
                String scorePart2 = resultSet.getString("scorepart2");
                String scorePart3 = resultSet.getString("scorepart3");
                String scorePart4 = resultSet.getString("scorepart4");
                String comment = resultSet.getString("comment");
                String score = resultSet.getString("score");
                Rate rate = new Rate(professorId, studentId, courseId, scorePart1, scorePart2, scorePart3, scorePart4, comment, score);
                rates.add(rate);
            }
        }
        return rates;
    }
    
    
    
    
    public static Rate loadFromDatabase(Connection connection, String professorId, String studentId, String courseId) throws SQLException {
        String query = "SELECT * FROM Rate WHERE professor_id = ? AND student_id = ? AND course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, professorId);
            statement.setString(2, studentId);
            statement.setString(3, courseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String scorePart1 = resultSet.getString("scorepart1");
                String scorePart2 = resultSet.getString("scorepart2");
                String scorePart3 = resultSet.getString("scorepart3");
                String scorePart4 = resultSet.getString("scorepart4");
                String comment = resultSet.getString("comment");
                String score = resultSet.getString("score");
                return new Rate(professorId, studentId, courseId, scorePart1, scorePart2, scorePart3, scorePart4, comment, score);
            }
        }
        return null;
    }
}
