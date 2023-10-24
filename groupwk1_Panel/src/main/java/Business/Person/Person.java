/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author freax
 */



public class Person {
    private String personName;
    private String personID;
    private String role;

    public Person(String personName, String personID, String role) {
        this.personName = personName;
        this.personID = personID;
        this.role = role;
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
    public static Person loadFromDatabase(Connection connection, String NUID) throws SQLException {
        String query = "SELECT * FROM Person WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, NUID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String personName = resultSet.getString("PersonName");
                String role = resultSet.getString("role");
                Person person = new Person(personName, NUID, role);
                return person;
            }
        }
        return null;
    }

    public void saveToDatabase(Connection connection) throws SQLException {
        String query = "INSERT INTO Person (PersonName, PersonID, role) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, personName);
            statement.setString(2, personID);
            statement.setString(3, role);
            statement.executeUpdate();
        }
    }


    public void updateInDatabase(Connection connection) throws SQLException {
        String query = "UPDATE Person SET PersonName = ?, role = ? WHERE PersonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, personName);
            statement.setString(2, role);
            statement.setString(3, personID);
            statement.executeUpdate();
        }
    }

}
