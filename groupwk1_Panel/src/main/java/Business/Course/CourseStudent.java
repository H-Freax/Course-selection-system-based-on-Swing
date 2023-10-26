package Business.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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

    public boolean isStudentEnrolledInCourse(String studentId, String courseID) throws SQLException {
        String query = "SELECT COUNT(*) FROM CourseStudent WHERE course_id = ? AND studuent_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseID);
            statement.setString(2, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // 如果行存在，count将大于0
            }
        }

        return false; // 如果查询失败或未找到行，则默认返回false
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
}
