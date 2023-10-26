package Business.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    private String personName;
    private String personID;
    private String role;

    public Person(String personName, String personID, String role) {
        this.personName = personName;
        this.personID = personID;
        this.role = role;
    }

    Person() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void saveToDatabase(Connection connection) throws SQLException {
        // 将 Person 对象保存到数据库
        String insertPersonQuery = "INSERT INTO Person (PersonName, PersonID, role) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertPersonQuery)) {
            statement.setString(1, personName);
            statement.setString(2, personID);
            statement.setString(3, role);
            statement.executeUpdate();
        }
    }

    public void updateInDatabase(Connection connection) throws SQLException {
        // 更新数据库中的 Person 对象信息
        String updatePersonQuery = "UPDATE Person SET PersonName = ?, role = ? WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(updatePersonQuery)) {
            statement.setString(1, personName);
            statement.setString(2, role);
            statement.setString(3, personID);
            statement.executeUpdate();
        }
    }

    public static boolean isPersonExists(Connection connection, String personID, String personName, String role) throws SQLException {
        // 查询数据库以检查是否存在具有指定属性的 Person 对象
        String checkPersonQuery = "SELECT COUNT(*) FROM Person WHERE PersonID = ? AND PersonName = ? AND role = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkPersonQuery)) {
            statement.setString(1, personID);
            statement.setString(2, personName);
            statement.setString(3, role);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // 如果记录数大于0，则表示存在
            }
        }
        return false; // 如果没有匹配的记录，则表示不存在
    }

    public static Person loadFromDatabase(Connection connection, String personID) throws SQLException {
        // 从数据库加载 Person 对象信息
        String selectPersonQuery = "SELECT * FROM Person WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectPersonQuery)) {
            statement.setString(1, personID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String personName = resultSet.getString("PersonName");
                String role = resultSet.getString("role");
                return new Person(personName, personID, role);
            }
        }
        return null;
    }

    public static void deleteFromDatabase(Connection connection, String personID) throws SQLException {
        // 从数据库删除指定 Person 对象
        String deletePersonQuery = "DELETE FROM Person WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(deletePersonQuery)) {
            statement.setString(1, personID);
            statement.executeUpdate();
        }
    }
}
