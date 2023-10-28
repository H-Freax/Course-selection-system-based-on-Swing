/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonSchedule {
    private List<Course> personSchedule;
    private Connection connection;

    private Person person;

    public PersonSchedule(Connection connection, Person person) {
        personSchedule = new ArrayList<>();
        this.connection = connection;
        this.person = person;
    }

    public List<Course> getPersonSchedule() {
        return personSchedule;
    }

    public void addCourseToSchedule(Course course) throws SQLException {
        // 添加到内存
        personSchedule.add(course);

        // 添加到数据库
        saveCourseToScheduleInDatabase(course);
    }

    public void removeCourseFromSchedule(Course course) throws SQLException {
        // 从内存中删除
        personSchedule.remove(course);

        // 从数据库中删除
        deleteCourseFromScheduleInDatabase(course);
    }

    public Course getCourseFromScheduleById(String courseId) {
        for (Course course : personSchedule) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void loadPersonScheduleFromDatabase() throws SQLException {
        String query = "select pc.personid, c.*  from personschedule pc left join course c " +
                "on pc.course_id = c.id where pc.personid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, person.getPersonID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.resultSetToCourse(resultSet);
                personSchedule.add(course);
            }
        }
    }


    private void saveCourseToScheduleInDatabase(Course course) throws SQLException {
        String query = "INSERT INTO personschedule (course_id) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }

    private void deleteCourseFromScheduleInDatabase(Course course) throws SQLException {
        String query = "DELETE FROM personschedule WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }
}
