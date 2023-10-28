/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

/**
 *
 * @author freax
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnectionUtil {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/groupwork1?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "200312zjmZJM!";

    private static Connection connection = null;

    public static Connection getConnection() {

        if(connection == null){
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                System.out.println("Database connection established.");
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error: Unable to connect to the database.");
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error: Unable to close the database connection.");
                e.printStackTrace();
            }
        }
    }
}
