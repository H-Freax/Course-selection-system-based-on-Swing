/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Tools.MySQLConnectionUtil;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 15469
 */
public class PersonSchedule {
    private Connection connection;
    private List<PersonInfo> personInfoList;
    
    public PersonSchedule() throws SQLException {
        connection = MySQLConnectionUtil.getConnection();
        personInfoList = new ArrayList<>();
        loadPersonInfoFromDatabase();
    }
    
        

    
    public static class PersonInfo {
        private String courseId;
        private String semeId;
        private String starttime;
        private String endtime;
        private String pId;

        public PersonInfo(String courseId, String semeId, String starttime, String endtime, String pId) {
            this.courseId = courseId;
            this.semeId = semeId;
            this.starttime = starttime;
            this.endtime = endtime;
            this.pId = pId;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getSemeId() {
            return semeId;
        }

        public void setSemeId(String semeId) {
            this.semeId = semeId;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        } 
    }
    
    
    public PersonInfo getPersonScheduleById(String pId) {
        for (PersonInfo p : personInfoList) {
            if (p.getpId().equals(pId)) {
                return p;
            }
        }
        return null; // 如果未找到，返回null
    }

    // 获取所有PersonInfo对象
    public List<PersonInfo> getAllPersonSchedule() {
        return personInfoList;
    }

    // 保存PersonInfo对象到数据库
    private void savePersonInfoToDatabase(PersonInfo personInfo) throws SQLException {
        String query = "INSERT INTO PersonSchedule (course_id, semesterid, starttime, endtime, personid) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, personInfo.getCourseId());
            statement.setString(2, personInfo.getSemeId());
            statement.setString(3, personInfo.getStarttime());
            statement.setString(4, personInfo.getEndtime());
            statement.setString(5, personInfo.getpId());
            statement.executeUpdate();
        }
    }

    // 从数据库中删除PersonInfo对象
    private void deletePersonInfoFromDatabase(String pId) throws SQLException {
        String query = "DELETE FROM PersonSchedule WHERE personid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pId);
            statement.executeUpdate();
        }
    }

    // 从数据库中读取PersonInfo对象并加载到内存中
    public void loadPersonInfoFromDatabase() throws SQLException {
        String query = "SELECT * FROM PersonSchedule";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String courseId = resultSet.getString("course_id");
                String semeId = resultSet.getString("semesterid");
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");
                String pId = resultSet.getString("personid");

                PersonInfo personInfo = new PersonInfo(courseId, semeId, starttime, endtime, pId);
                personInfoList.add(personInfo);
            }
        }
    }
    
    
}
