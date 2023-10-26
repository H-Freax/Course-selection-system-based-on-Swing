package Business.Directory;

import Business.Person.Professor;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDirectory {
    private List<Professor> professors;

    public ProfessorDirectory() {
        professors = new ArrayList<>();
    }

    // 添加新教授
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public Professor getProfessorByusername(String username) {
        for (Professor professor : professors) {
            if (professor.getUsername().equals(username)) {
                return professor;
            }
        }
        return null;
    }
    // 根据ID获取教授
    public Professor getProfessorById(String personID) {
        for (Professor professor : professors) {
            if (professor.getPersonID().equals(personID)) {
                return professor;
            }
        }
        return null;
    }

    // 从数据库加载教授
    public Professor loadProfessorFromDatabase(Connection connection, String personID) throws SQLException {
        Professor professor = Professor.loadFromDatabase(connection, personID);
        if (professor != null) {
            addProfessor(professor);
        }
        return professor;
    }

    // 保存教授信息到数据库
    public void saveProfessorToDatabase(Connection connection, Professor professor) throws SQLException {
        if (getProfessorById(professor.getPersonID()) == null) {
            professor.saveToDatabase(connection);
            addProfessor(professor);
        } else {
            professor.updateProfessorInDatabase(connection);
        }
    }

    // 根据教授ID删除教授
    public void deleteProfessorById(Connection connection, String personID) throws SQLException {
        Professor professor = getProfessorById(personID);
        if (professor != null) {
            professors.remove(professor);
            String deleteQuery = "DELETE FROM Professor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
                statement.setString(1, personID);
                statement.executeUpdate();
            }
        }
    }

    // 获取所有教授
    public List<Professor> getProfessors() {
        return professors;
    }

    // 从数据库加载所有教授
    public void loadAllProfessorsFromDatabase(Connection connection) throws SQLException {
        String query = "SELECT * FROM Professor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String personID = resultSet.getString("id");
                Professor professor = getProfessorById(personID);
                if (professor == null) {
                    professor = Professor.loadFromDatabase(connection, personID);
                    if (professor != null) {
                        addProfessor(professor);
                    }
                }
            }
        }
    }
}
