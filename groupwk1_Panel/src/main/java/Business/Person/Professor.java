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
import java.util.HashSet;
import java.util.Set;
import Tools.PasswordUtils;

public class Professor extends Person {
    private String username;
    private String nowPassword;
    private boolean enabled;
    private String pwdHash;
    private double rate;
    private String language;
    private String region;
    private Set<String> topics;
    private Set<String> passwordHistory;
    
    public Professor(String personName, String personID, String username, String nowPassword, boolean enabled, String role) {
        super(personName, personID, role);
        this.nowPassword = Tools.PasswordUtils.hashPassword(nowPassword);
        this.username = username;
        this.enabled = enabled;
        this.pwdHash = Tools.PasswordUtils.hashPassword(nowPassword);
        this.rate = 0.0; // 默认分数为0
        this.language = "";
        this.region = "";
        this.topics = new HashSet<>();
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
        this.nowPassword = Tools.PasswordUtils.hashPassword(nowPassword);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<String> getTopics() {
        return topics;
    }

    public void setTopics(Set<String> topics) {
        this.topics = topics;
    }

    // 用于登录检查，检查用户名、密码和角色是否匹配
    public boolean checkLogin(Connection connection, String inputUsername, String inputPassword, String role) throws SQLException {
        return PasswordUtils.verifyLogin(connection, inputUsername, inputPassword, role);
    }

    public void saveToDatabase(Connection connection) throws SQLException {
        super.saveToDatabase(connection);

        String insertProfessorQuery = "INSERT INTO Professor (id, username, nowpassword, language, enabled, rate, region, lastactive, lastupdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertProfessorQuery)) {
            statement.setString(1, getPersonID());
            statement.setString(2, username);
            statement.setString(3, pwdHash);
            statement.setString(4, language);
            statement.setString(5, enabled ? "1" : "0");
            statement.setDouble(6, rate);
            statement.setString(7, region);
            statement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
            statement.executeUpdate();
        }

        // 保存教授的研究领域信息
        saveProfessorTopicsToDatabase(connection, getPersonID(), topics);

        // 保存密码历史
        savePasswordHistoryToDatabase(connection, getPersonID(), pwdHash);
    }

    public void updateProfessorInDatabase(Connection connection) throws SQLException {
        super.updateInDatabase(connection);

        String updateProfessorQuery = "UPDATE Professor SET username = ?, nowpassword = ?, language = ?, enabled = ?, rate = ?, region = ?, lastactive = ?, lastupdate = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateProfessorQuery)) {
            statement.setString(1, username);
            statement.setString(2, pwdHash);
            statement.setString(3, language);
            statement.setString(4, enabled ? "1" : "0");
            statement.setDouble(5, rate);
            statement.setString(6, region);
            statement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(9, getPersonID());
            statement.executeUpdate();
        }

        // 保存教授的研究领域信息
        saveProfessorTopicsToDatabase(connection, getPersonID(), topics);

        // 保存密码历史
        savePasswordHistoryToDatabase(connection, getPersonID(), pwdHash);
    }

    public static Professor loadFromDatabase(Connection connection, String personID) throws SQLException {
        Person person = Person.loadFromDatabase(connection, personID);
        if (person == null) {
            return null;
        }

        String selectProfessorQuery = "SELECT * FROM Professor WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectProfessorQuery)) {
            statement.setString(1, personID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("nowpassword");
                boolean enabled = resultSet.getString("enabled").equals("1");
                double rate = resultSet.getDouble("rate");
                String language = resultSet.getString("language");
                String region = resultSet.getString("region");
                Person p = Person.loadFromDatabase(connection, personID);
                Professor professor = new Professor(p.getPersonName(), personID, username, "", enabled, person.getRole());
                professor.setNowPassword(""); // 不直接保存明文密码
                professor.setPwdHash(passwordHash);
                professor.setRate(rate);
                professor.setLanguage(language);
                professor.setRegion(region);

                // 加载教授的研究领域信息
                professor.setTopics(loadProfessorTopicsFromDatabase(connection, personID));

                return professor;
            }
        }
        return null;
    }

    private void saveProfessorTopicsToDatabase(Connection connection, String personID, Set<String> topics) throws SQLException {
        // 首先删除原有的研究领域信息
        String deleteTopicsQuery = "DELETE FROM ProfessorTopic WHERE professor_id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteTopicsQuery)) {
            deleteStatement.setString(1, personID);
            deleteStatement.executeUpdate();
        }

        // 然后插入新的研究领域信息
        String insertTopicsQuery = "INSERT INTO ProfessorTopic (professor_id, topic) VALUES (?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertTopicsQuery)) {
            for (String topic : topics) {
                insertStatement.setString(1, personID);
                insertStatement.setString(2, topic);
                insertStatement.executeUpdate();
            }
        }
    }

    private static Set<String> loadProfessorTopicsFromDatabase(Connection connection, String personID) throws SQLException {
        Set<String> topics = new HashSet<>();
        String selectTopicsQuery = "SELECT topic FROM ProfessorTopic WHERE professor_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectTopicsQuery)) {
            statement.setString(1, personID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String topic = resultSet.getString("topic");
                topics.add(topic);
            }
        }
        return topics;
    }

    private void savePasswordHistoryToDatabase(Connection connection,String personid,String password) throws SQLException {
        Tools.PasswordUtils.addToPasswordHistory(connection, personid, password);
    }

}
