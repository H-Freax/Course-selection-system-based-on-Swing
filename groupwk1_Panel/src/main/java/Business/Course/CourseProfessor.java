import Tools.MySQLConnectionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseProfessor {
    private String courseId;
    private String pId;
    private Connection connection;

    // 构造函数，用于初始化数据库连接
    public CourseProfessor() {
        // 连接数据库
        connection = MySQLConnectionUtil.getConnection();
    }

    // 查找指定courseId和pId的数据
    public void findData(String courseId, String pId) {
        try {
            String query = "SELECT * FROM courseprofessor WHERE course_id = ? AND professor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, pId);

            ResultSet resultSet = preparedStatement.executeQuery();

            // 处理查询结果
            while (resultSet.next()) {
                // 获取查询结果的数据并进行处理
                String courseIdResult = resultSet.getString("course_id");
                String professorIdResult = resultSet.getString("professor_id");
                // 处理查询到的数据
                System.out.println("Course ID: " + courseIdResult + ", Professor ID: " + professorIdResult);
            }

            // 关闭资源
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库操作异常
        }
    }

    // 修改指定courseId和pId的数据
    public void updateData(String courseId, String pId, String newCourseId, String newPId) {
        try {
            String query = "UPDATE courseprofessor SET course_id = ?, professor_id = ? WHERE course_id = ? AND professor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCourseId);
            preparedStatement.setString(2, newPId);
            preparedStatement.setString(3, courseId);
            preparedStatement.setString(4, pId);

            int rowsAffected = preparedStatement.executeUpdate();
            // 处理修改结果
            System.out.println(rowsAffected + " 行数据已修改");

            // 关闭资源
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库操作异常
        }
    }

    // 关闭数据库连接
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库关闭异常
        }
    }

}
