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

public class Employee extends Person {

    private String username;
    private String nowPassword;
    private boolean enabled;
    private String pwdHash;
    private Set<String> passwordHistory; // 用于存储密码历史

    public Employee(){

    }
    public Employee(String personName, String personID, String username, String nowPassword, boolean enabled, String role) {
        super(personName, personID, role);
        this.nowPassword =nowPassword;
        this.username = username;
        this.enabled = enabled;
        this.pwdHash = Tools.PasswordUtils.hashPassword(nowPassword);
        this.passwordHistory = new HashSet<>();
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

    public Set<String> getPasswordHistory() {
        return passwordHistory;
    }

    public void setPasswordHistory(Set<String> passwordHistory) {
        this.passwordHistory = passwordHistory;
    }

    public boolean updatePassword(String newPassword) {
        String newPwdHash = Tools.PasswordUtils.hashPassword(newPassword);
        if (!passwordHistory.contains(newPwdHash)) {

            passwordHistory.add(pwdHash); // 将旧密码哈希添加到历史记录
            pwdHash = newPwdHash; // 更新密码为新哈希值
            return true;
        }else {
            return false;
        }
    }

    // 用于登录检查，检查用户名、密码和角色是否匹配
    public boolean checkLogin(Connection connection,String inputUsername, String inputPassword, String role) throws SQLException {
        return PasswordUtils.verifyLogin(connection,inputUsername,inputPassword,role);
    }


    public void saveToDatabase(Connection connection) throws SQLException {
        super.saveToDatabase(connection);

        String insertEmployeeQuery = "INSERT INTO Employee (id, username, nowpassword, enabled, lastactive, lastupdate) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertEmployeeQuery)) {
            statement.setString(1, getPersonID());
            statement.setString(2, username);
            statement.setString(3, pwdHash);
            statement.setString(4, enabled ? "1" : "0");
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后活动时间
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后更新时间
            statement.executeUpdate();
        }

        savePasswordHistoryToDatabase(connection,getPersonID(),pwdHash); // 保存密码历史
    }

    
    public void updateEmployeeInDatabase1(Connection connection,String personName,String role,String personID,String username,Boolean enabled,String nowPassword,String id) throws SQLException {
        super.updateInDatabase(connection); // 更新基本人员信息
        String updatePersonQuery = "UPDATE Person SET PersonName = ?, role = ? WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(updatePersonQuery)) {
            statement.setString(1, personName);
            statement.setString(2, role);
            statement.setString(3, id);
            statement.executeUpdate();
        }
        String updateEmployeeQuery = "UPDATE Employee SET id=?, username = ?, nowpassword = ?, enabled = ?, lastactive = ?, lastupdate = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateEmployeeQuery)) {
            statement.setString(1, personID);
            statement.setString(2, username);
            statement.setString(3, nowPassword);
            statement.setString(4, enabled ? "1" : "0");
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后活动时间
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后更新时间
            statement.setString(7, id);
            statement.executeUpdate();
        }

        savePasswordHistoryToDatabase(connection,getPersonID(),pwdHash); // 保存最新密码历史
    }
    
    
    
    
    public void updateEmployeeInDatabase(Connection connection) throws SQLException {
        super.updateInDatabase(connection); // 更新基本人员信息

        String updateEmployeeQuery = "UPDATE Employee SET username = ?, nowpassword = ?, enabled = ?, lastactive = ?, lastupdate = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateEmployeeQuery)) {
            statement.setString(1, username);
            statement.setString(2, pwdHash);
            statement.setString(3, enabled ? "1" : "0");
            statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后活动时间
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // 设置当前时间为最后更新时间
            statement.setString(6, getPersonID());
            statement.executeUpdate();
        }

        savePasswordHistoryToDatabase(connection,getPersonID(),pwdHash); // 保存最新密码历史
    }
    

    public static Employee loadFromDatabase(Connection connection, String personID) throws SQLException {
        Person person = Person.loadFromDatabase(connection, personID);
        if (person == null) {
            return null;
        }

        String selectEmployeeQuery = "SELECT * FROM Employee WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectEmployeeQuery)) {
            statement.setString(1, personID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("nowpassword");
                boolean enabled = resultSet.getString("enabled").equals("1");
                Person p = Person.loadFromDatabase(connection, personID);
                Employee employee = new Employee(p.getPersonName(), personID, username, "", enabled, person.getRole());
                employee.setNowPassword(""); // 不直接保存明文密码
                employee.setPwdHash(passwordHash);


                String selectPasswordHistoryQuery = "SELECT password FROM Historypwd WHERE personid = ?";
                try (PreparedStatement pwdHistoryStatement = connection.prepareStatement(selectPasswordHistoryQuery)) {
                    pwdHistoryStatement.setString(1, personID);
                    ResultSet pwdHistoryResultSet = pwdHistoryStatement.executeQuery();
                    while (pwdHistoryResultSet.next()) {
                        String password = pwdHistoryResultSet.getString("password");
                        employee.passwordHistory.add(password);
                    }
                }

                return employee;
            }
        }
        return null;
    }

    private void savePasswordHistoryToDatabase(Connection connection,String personid,String password) throws SQLException {
        Tools.PasswordUtils.addToPasswordHistory(connection, personid, password);
    }

    public Set<String> retrievePasswordHistoryFromDatabase(Connection connection) throws SQLException {
        Set<String> passwordHistory = new HashSet<>();
        String query = "SELECT password FROM Historypwd WHERE personid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, getPersonID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                passwordHistory.add(password);
            }
        }
        return passwordHistory;
    }

}
