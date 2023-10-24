/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Semester;

import java.sql.*;
import java.time.LocalDateTime;

public class Semester {
    private String id;
    private String semesterName;
    private LocalDateTime semesterStart;
    private LocalDateTime semesterEnd;

    public Semester(String id, String semesterName, LocalDateTime semesterStart, LocalDateTime semesterEnd) {
        this.id = id;
        this.semesterName = semesterName;
        this.semesterStart = semesterStart;
        this.semesterEnd = semesterEnd;
    }

    public String getId() {
        return id;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public LocalDateTime getSemesterStart() {
        return semesterStart;
    }

    public LocalDateTime getSemesterEnd() {
        return semesterEnd;
    }

    public static Semester loadFromDatabase(Connection connection, String id) throws SQLException {
        String query = "SELECT * FROM Semester WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String semesterName = resultSet.getString("semstername");
                LocalDateTime semesterStart = resultSet.getTimestamp("semesterstart").toLocalDateTime();
                LocalDateTime semesterEnd = resultSet.getTimestamp("semesterend").toLocalDateTime();
                return new Semester(id, semesterName, semesterStart, semesterEnd);
            }
        }
        return null;
    }

    public void setSemesterDates(int year, String season) {
        if (season.equalsIgnoreCase("Spring")) {
            semesterName = "Spring " + year;
            semesterStart = LocalDateTime.of(year, 1, 1, 0, 0);
            semesterEnd = LocalDateTime.of(year, 5, 31, 23, 59);
        } else if (season.equalsIgnoreCase("Fall")) {
            semesterName = "Fall " + year;
            semesterStart = LocalDateTime.of(year, 8, 1, 0, 0);
            semesterEnd = LocalDateTime.of(year, 12, 31, 23, 59);
        }
    }

    public void saveToDatabase(Connection connection) throws SQLException {
        String query = "INSERT INTO Semester (id, semstername, semesterstart, semesterend) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, semesterName);
            statement.setTimestamp(3, Timestamp.valueOf(semesterStart));
            statement.setTimestamp(4, Timestamp.valueOf(semesterEnd));
            statement.executeUpdate();
        }
    }
}
