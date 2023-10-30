/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 15469
 */
public class CourseProfessor {
    private Map<String, String> map;
    private Connection connection;
    
    public CourseProfessor(Connection connection) {
        map = new HashMap<>();
        this.connection = connection;
        loadCourseProfessors();
    }
    
        public void loadCourseProfessors() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_id, professor_id FROM courseprofessor");
            
            while (resultSet.next()) {
                String courseId = resultSet.getString("course_id");
                String professorId = resultSet.getString("professor_id");
                map.put(courseId, professorId);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 向数据库中插入数据
    public void insertCourseProfessor(String courseId, String professorId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courseprofessor (course_id, professor_id) VALUES (?, ?)");
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, professorId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 从map中获取教授的ID
    public String getProfessorId(String courseId) {
        return map.get(courseId);
    }
}
