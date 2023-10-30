/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Course.Course;
import Business.Person.Professor;
import Business.Person.Student;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDirectory {
    private List<Professor> professors;

    private Connection connection;

    public ProfessorDirectory() {
        professors = new ArrayList<>();
        connection = MySQLConnectionUtil.getConnection();
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

        //内存查询不到教授信息，就查询数据库
        return loadProfessorFromDatabase(null, username);
    }

    // 根据ID获取教授
    public Professor getProfessorById(String personID) {

        for (Professor professor : professors) {
            if (professor.getPersonID().equals(personID)) {
                return professor;
            }
        }

        //内存查询不到教授信息，就查询数据库
        return loadProfessorFromDatabase(personID, null);
    }

    // 从数据库加载教授
    public Professor loadProfessorFromDatabase(String personID, String username) {
        Professor professor = null;
        try {
            professor = Professor.loadFromDatabase(connection, personID, username);
            if (professor != null) {
                addProfessor(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库异常！！");
        }

        return professor;
    }

    // 保存教授信息到数据库
    public void saveProfessorToDatabase(Professor professor) throws SQLException {
        if (getProfessorById(professor.getPersonID()) == null) {
            professor.saveToDatabase(connection);
            addProfessor(professor);
        } else {
            professor.updateProfessorInDatabase(connection);
        }
    }

    // 根据教授ID删除教授
    public void deleteProfessorById(String personID) throws SQLException {
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
    public void loadAllProfessorsFromDatabase() throws SQLException {
        String query = "SELECT * FROM Professor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String personID = resultSet.getString("id");
                Professor professor = getProfessorById(personID);
                if (professor == null) {
                    professor = Professor.loadFromDatabase(connection, personID, null);
                    if (professor != null) {
                        addProfessor(professor);
                    }
                }
            }
        }
    }

    /**
     * 查询所有学生，并判断是否选过教授的课
     * */
    public List<Student> getStudentsByKeyword(String keyword, Professor professor) throws SQLException {

        List<Student> studentList = new ArrayList<>();

        String query = "  select s.id, max(s.username) username, max(s.gpa) gpa,  max(p.PersonName) name, " +
                " group_concat(distinct pp.PersonName) professorNames , group_concat(distinct cp.professor_id) professorIds " +
                "  from student s left join person p on p.PersonID = s.id " +
                "  left join coursestudent cs on s.id = cs.studuent_id " +
                "  left join course c on cs.course_id = c.id " +
                "  left join courseprofessor cp on cp.course_id = c.id  " +
                "  left join person pp on pp.PersonID = cp.professor_id  " ;
        if(keyword != null){
            query = query + "where p.PersonName like concat('%',?,'%') or s.id =? or pp.PersonName like concat('%',?,'%')";
        }
        query = query + " group by s.id";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if(keyword != null){
                statement.setString(1, keyword);
                statement.setString(2, keyword);
                statement.setString(3, keyword);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = Student.resultSetToCourse(resultSet);
                if(student.getProfessorList().contains(professor.getPersonID())){
                    student.setMyStu(true);
                }
                studentList.add(student);
            }
        }
        return studentList;
    }
}
