package Business.Semester;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public void setId(String id) {
        this.id = id;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public void setSemesterStart(LocalDateTime semesterStart) {
        this.semesterStart = semesterStart;
    }

    public void setSemesterEnd(LocalDateTime semesterEnd) {
        this.semesterEnd = semesterEnd;
    }
    
    
    

    public static List<Semester> getAllSemestersFromDatabase(Connection connection) throws SQLException {
        List<Semester> semesters = new ArrayList<>();
        String query = "SELECT * FROM Semester";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String semesterName = resultSet.getString("semstername");
                LocalDateTime semesterStart = resultSet.getTimestamp("semesterstart").toLocalDateTime();
                LocalDateTime semesterEnd = resultSet.getTimestamp("semesterend").toLocalDateTime();
                Semester semester = new Semester(id, semesterName, semesterStart, semesterEnd);
                semesters.add(semester);
            }
        }
        return semesters;
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
    public static Semester loadFromDatabaseByName(Connection connection, String semesterName) throws SQLException {
        String query = "SELECT * FROM Semester WHERE semstername = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, semesterName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
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
