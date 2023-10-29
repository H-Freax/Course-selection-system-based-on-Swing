/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;
import Tools.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDirectory {
    private List<Course> courses;

    private Connection connection;


    public CourseDirectory() {
        courses = new ArrayList<>();
        this.connection = MySQLConnectionUtil.getConnection();
    }

    public void addCourse(Course course) throws SQLException {
        // 添加到内存
        courses.add(course);

        // 添加到数据库
        course.saveToDatabase(connection);
    }

    public void removeCourse(Course course) throws SQLException {
        // 从内存中删除
        courses.remove(course);

        // 从数据库中删除
        course.deleteFromDatabase(connection);
    }

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    //
    public List<Course> getCourseByStudentId(String studentId) {

        return null;
    }

    public void loadCoursesFromDatabase() throws SQLException {
        String query = "SELECT * FROM Course";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.resultSetToCourse(resultSet);
                courses.add(course);
                //Course表没有教授字段
            }
        }
    }

    public Course loadCourseFromDatabase(String courseId) throws SQLException {
        String query = "SELECT * FROM Course where id =?";
        Course course = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                course = Course.resultSetToCourse(resultSet);
            }
        }
        return course;
    }

    //根据studentId查询Course
    public void loadCoursesFromDatabase(String studentId) throws SQLException {
        String query = "SELECT c.*, cs.studuent_id, cs.score, person.PersonName professor FROM CourseStudent cs left join  Course c on cs.course_id = c.id " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "where cs.studuent_id=?" ;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.resultSetToCourse(resultSet);
                courses.add(course);
            }
        }
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public List<CourseVO> loadCourseListFromDatabase(String keyWords, String professorId) throws SQLException{
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id , max(c.statue) statue , max(c.begintime) begintime , max(c.endtime) endtime ," +
                " max(c.location) location , max(c.introduction) introduction , max(c.point) point , " +
                "max(c.studentlimited) studentlimited , max(c.studentcount) studentcount, s.semstername," +
                " c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics FROM Course c " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "left join CourseTopic ct on c.id = ct.course_id " +
                "left join Semester s on s.id = c.semesterid " +
                "where c.statue ='Open' ";

                if(keyWords != null){
                    query = query  +
                            "and ( person.PersonName like concat('%',?,'%') " +
                            "or p.language like concat('%',?,'%') " +
                            "or p.region like concat('%',?,'%') " +
                            "or c.name like concat('%',?,'%') " +
                            "or ct.topic like concat('%',?,'%')) " ;
                }

                if(professorId != null){
                    query = query + "and p.id = ? ";
                }

        query = query + " group by language, region, professor, c.name, s.semstername ";

        try (PreparedStatement statement = connection.prepareStatement(query)) {


            if(keyWords != null){
                statement.setString(1, keyWords);
                statement.setString(2, keyWords);
                statement.setString(3, keyWords);
                statement.setString(4, keyWords);
                statement.setString(5, keyWords);
                if(professorId != null){
                    statement.setString(6, professorId);
                }
            }else{
                if(professorId != null){
                    statement.setString(1, professorId);
                }
            }

            System.out.println(statement.toString());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CourseVO course = CourseVO.resultSetToProfessorCourseVO(resultSet);
                list.add(course);
            }
        }
        courses = list.stream().map(vo ->{
            Course course = new Course();
            course.setId(vo.getId());
            course.setName(vo.getName());
            course.setBeginTime(vo.getBeginTime());
            course.setEndTime(vo.getEndTime());
            course.setIntroduction(vo.getIntroduction());
            course.setLocation(vo.getLocation());
            course.setPoint(vo.getPoint());
            course.setProfessor(vo.getProfessor());
            course.setStatus(vo.getStatus());
            course.setTopics(vo.getTopics());
            return course;
        }).collect(Collectors.toList());
        return list;
    }

    public List<CourseVO> loadCourseListByStudentIdFromDatabase(String keyWords, String studentId, String statue ) throws SQLException{
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id , max(c.statue) statue , max(cs.score) score , max(c.begintime) begintime , max(c.endtime) endtime ," +
                " max(c.location) location , max(c.introduction) introduction , max(c.point) point , " +
                "max(c.studentlimited) studentlimited , max(c.studentcount) studentcount, s.semstername," +
                " c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics FROM Course c " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "left join CourseTopic ct on c.id = ct.course_id " +
                "left join Semester s on s.id = c.semesterid " +
                "left join CourseStudent cs on cs.course_id = c.id " +
                "where c.statue = ? and cs.studuent_id = ?";

        if(keyWords != null){
            query = query  +
                    "and ( person.PersonName like concat('%',?,'%') " +
                    "or p.language like concat('%',?,'%') " +
                    "or p.region like concat('%',?,'%') " +
                    "or c.name like concat('%',?,'%') " +
                    "or ct.topic like concat('%',?,'%'))" ;
        }
        query = query + " group by language, region, professor, c.name, s.semstername ";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, statue);
            statement.setString(2, studentId);
            if(keyWords != null){
                statement.setString(3, keyWords);
                statement.setString(4, keyWords);
                statement.setString(5, keyWords);
                statement.setString(6, keyWords);
                statement.setString(7, keyWords);
            }

            System.out.println(statement.toString());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CourseVO course = CourseVO.resultSetToCourseVO(resultSet);
                list.add(course);
            }
        }

        courses = list.stream().map(vo ->{
            Course course = new Course();
            course.setId(vo.getId());
            course.setName(vo.getName());
            course.setBeginTime(vo.getBeginTime());
            course.setEndTime(vo.getEndTime());
            course.setIntroduction(vo.getIntroduction());
            course.setLocation(vo.getLocation());
            course.setPoint(vo.getPoint());
            course.setProfessor(vo.getProfessor());
            course.setStatus(vo.getStatus());
            course.setTopics(vo.getTopics());
            course.setScore(vo.getScore());
            return course;
        }).collect(Collectors.toList());
        return list;

    }

    public void dropCourse(String id, String personID) throws SQLException {
        //update student count

        getCourseById(id).updateStudentCountInCourse(MySQLConnectionUtil.getConnection(),-1);

        //delete

        getCourseById(id).removeEnrolledStudent(MySQLConnectionUtil.getConnection(),personID);

    }
}
