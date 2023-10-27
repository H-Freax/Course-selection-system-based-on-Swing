package Tools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordUtils {

    // 根据username、nowpassword和role进行登录验证
    public static boolean verifyLogin(Connection connection, String username, String nowpassword, String role) throws SQLException {
        String hashedPassword = hashPassword(nowpassword);
        System.out.println("username"+username);
        System.out.println("hashedPassword"+hashedPassword);

        String query = "SELECT nowpassword,enabled FROM " + role + " WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedHashedPassword = resultSet.getString("nowpassword");
                String isenable = resultSet.getString("enabled");
                System.out.println("storedHashedPassword"+storedHashedPassword);
                return hashedPassword.equals(storedHashedPassword)&&isenable.equals("1");
            }
            return false; // 用户名不存在
        }
    }

    // 对nowpassword进行哈希加密
    public static String hashPassword(String password) {
        try {
//            System.out.println("password:"+password);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

//            System.out.println("hashpwd:"+sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 更新密码并将旧密码添加到Historypwd表
    public static boolean updatePassword(Connection connection, String username, String nowpassword, String role) throws SQLException {
        String hashedPassword = hashPassword(nowpassword);

        // 首先检查新密码是否在密码历史中
        if (isPasswordInHistory(connection, username, hashedPassword)) {
            return false; // 密码已在历史中，修改失败
        }

        // 获取对应身份表中的personid
        String personId = getPersonIdByUsernameAndRole(connection, username, role);

        if (personId != null) {
            // 更新密码表中的nowpassword
            String updateQuery = "UPDATE " + role + " SET nowpassword = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, hashedPassword);
                statement.setString(2, personId);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    // 密码更新成功，将旧密码添加到Historypwd表
                    addToPasswordHistory(connection, personId, hashedPassword);
                    return true;
                }
            }
        }
        return false; // 未找到匹配的用户名或personid
    }

    // 检查密码是否在Historypwd表中
    public static boolean isPasswordInHistory(Connection connection, String personId, String hashedPassword) throws SQLException {
        String query = "SELECT password FROM Historypwd WHERE personid = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, personId);
            statement.setString(2, hashedPassword);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // 如果存在于历史密码中，返回 true
        }
    }

    // 将新的nowpassword添加到Historypwd表中
    public static void addToPasswordHistory(Connection connection, String personId, String hashedPassword) throws SQLException {
        String insertQuery = "INSERT INTO Historypwd (personid, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, personId);
            statement.setString(2, hashedPassword);
            statement.executeUpdate();
        }
    }

    // 获取对应身份表中的personid
    private static String getPersonIdByUsernameAndRole(Connection connection, String username, String role) throws SQLException {
        String query = "SELECT id FROM " + role + " WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("id");
            }
            return null; // 未找到匹配的用户名
        }
    }


}
