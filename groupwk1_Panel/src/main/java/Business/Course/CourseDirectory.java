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

    public CourseDirectory(Connection connection) {
        courses = new ArrayList<>();
        this.connection = connection;
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
    public Course findCourseIdByName(String courseName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                return course;
            }
        }
        return null; // Handle the case where the course is not found, possibly by showing an error message.
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
        String query = "SELECT c.*, cs.studuent_id, cs.score, person.PersonName professor, css.weekday FROM CourseStudent cs left join  Course c on cs.course_id = c.id " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "left join CourseSchedule css on c.id = css.course_id " +
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

    public void addCourseProfessor(Connection connection, String courseId, String professorId) throws SQLException {
        String query = "INSERT INTO CourseProfessor (course_id, professor_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseId);
            statement.setString(2, professorId);
            statement.executeUpdate();
        }
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public List<CourseVO> loadCourseListFromDatabase(String keyWords) throws SQLException{
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id, max(c.statue) statue, max(c.begintime) begintime, max(c.endtime) endtime, " +
                "max(c.location) location, max(c.introduction) introduction, max(c.point) point, " +
                "max(c.studentlimited) studentlimited,max(css.weekday) weekday, max(c.studentcount) studentcount, s.semstername, " +
                "c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics FROM Course c " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "left join CourseTopic ct on c.id = ct.course_id " +
                "left join Semester s on s.id = c.semesterid " +
                "left join CourseSchedule css on c.id = css.course_id " +
                "where c.statue ='Open' ";

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
            if(keyWords != null){
                statement.setString(1, keyWords);
                statement.setString(2, keyWords);
                statement.setString(3, keyWords);
                statement.setString(4, keyWords);
                statement.setString(5, keyWords);
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
            course.setWeekday(vo.getWeekday());
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

    public List<CourseVO> loadCourseListByStudentIdListSemFromDatabase(String keyWords, String studentId, List<String> semesters ) throws SQLException {
        List<CourseVO> list = new ArrayList<>();
        for(String s :semesters){
            List<CourseVO> cv = loadCourseListByStudentIdSemFromDatabase(keyWords,studentId,s);
           for(CourseVO courseVO: cv){
               list.add(courseVO);
           }
        }
        return list;
    }

    public List<CourseVO> loadCourseListByStudentIdSemFromDatabase(String keyWords, String studentId, String semester ) throws SQLException{
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id, max(c.statue) statue, max(cs.score) score, max(c.begintime) begintime, max(c.endtime) endtime, " +
                "max(c.location) location, max(c.introduction) introduction, max(c.point) point, " +
                "max(c.studentlimited) studentlimited, max(c.studentcount) studentcount, s.semstername, " +
                "c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics, " +
                "max(s.id) semesterid, max(css.weekday) weekday " +
                "FROM Course c " +
                "LEFT JOIN CourseProfessor cp ON c.id = cp.course_id " +
                "LEFT JOIN Professor p ON cp.professor_id = p.id " +
                "LEFT JOIN Person person ON p.id = person.PersonID " +
                "LEFT JOIN CourseTopic ct ON c.id = ct.course_id " +
                "LEFT JOIN Semester s ON s.id = c.semesterid " +
                "LEFT JOIN CourseStudent cs ON cs.course_id = c.id " +
                "LEFT JOIN CourseSchedule css ON css.course_id = c.id "+
                "WHERE s.semstername = ? AND cs.studuent_id = ?";

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
            statement.setString(1, semester);
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
                System.out.println("course.getScore():"+course.getScore());
            }
        }

        courses = list.stream().map(vo ->{
            Course course = new Course();
            course.setId(vo.getId());
            course.setName(vo.getName());
            course.setWeekday(vo.getWeekday());
            course.setBeginTime(vo.getBeginTime());
            course.setEndTime(vo.getEndTime());
            course.setSemesterId(vo.getSemesterId());
            course.setIntroduction(vo.getIntroduction());
            course.setLocation(vo.getLocation());
            course.setPoint(vo.getPoint());
            course.setProfessor(vo.getProfessor());
            course.setStatus(vo.getStatus());
            course.setTopics(vo.getTopics());
            System.out.println("score:::"+vo.getScore());
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
    public List<CourseVO> loadCourseListFromDatabase(String keyWords, String professorId) throws SQLException{
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id, max(c.statue) statue, max(c.begintime) begintime, max(c.endtime) endtime, " +
                "max(c.location) location, max(c.introduction) introduction, max(c.point) point, " +
                "max(c.studentlimited) studentlimited, max(c.studentcount) studentcount, s.semstername, " +
                "c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics, " +
                "max(s.id) semesterid, max(css.weekday) weekday " +
                "FROM Course c " +
                "LEFT JOIN CourseProfessor cp ON c.id = cp.course_id " +
                "LEFT JOIN Professor p ON cp.professor_id = p.id " +
                "LEFT JOIN Person person ON p.id = person.PersonID " +
                "LEFT JOIN CourseTopic ct ON c.id = ct.course_id " +
                "LEFT JOIN Semester s ON s.id = c.semesterid " +
                "LEFT JOIN CourseStudent cs ON   c.id = cs.course_id " +
                "LEFT JOIN CourseSchedule css ON   c.id = css.course_id "+
                "WHERE c.statue = 'Open' ";

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

        query = query + " group by language, region, professor, c.name, s.semstername,css.weekday";

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
            course.setWeekday(vo.getWeekday());
            course.setProfessor(vo.getProfessor());
            course.setStatus(vo.getStatus());
            course.setTopics(vo.getTopics());
            return course;
        }).collect(Collectors.toList());
        return list;
    }

    //FacultyCurrentCourse
    public List<CourseVO>  loadCourseListByProfessorIdFromDatabase(String keyWords, String professorId, String semester) throws SQLException {
        List<CourseVO> list = new ArrayList<>();
        String query = "SELECT max(c.id) id , max(c.statue) statue , max(c.begintime) begintime , max(c.endtime) endtime ," +
                " max(c.location) location , max(c.introduction) introduction , max(c.point) point , " +
                "max(c.studentlimited) studentlimited , max(c.studentcount) studentcount, s.semstername," +
                "max(css.weekday) weekday, " +
                " c.name, p.language, p.region, person.PersonName professor, group_concat(ct.topic) topics FROM Course c " +
                "left join CourseProfessor cp on c.id  = cp.course_id " +
                "left join Professor p on cp.professor_id = p.id " +
                "left join Person person on p.id = person.PersonID " +
                "left join CourseTopic ct on c.id = ct.course_id " +
                "left join Semester s on s.id = c.semesterid " +
                "left join CourseSchedule css on c.id = css.course_id "+
                "where c.statue ='Open' and s.semstername = ? and p.id = ?";


        if(keyWords != null){
            query = query  +
                    "and ( person.PersonName like concat('%',?,'%') " +
                    "or p.language like concat('%',?,'%') " +
                    "or p.region like concat('%',?,'%') " +
                    "or c.name like concat('%',?,'%') " +
                    "or ct.topic like concat('%',?,'%'))" ;
        }
        query = query + " group by c.id, c.statue, c.begintime, c.endtime, c.location, c.introduction, c.point, c.studentlimited, c.studentcount, s.semstername, css.weekday, c.name, p.language, p.region, person.PersonName";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, semester);
            statement.setString(2, professorId);
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
                System.out.println("course.getName():"+course.getName());
            }
        }

        courses = list.stream().map(vo ->{
            Course course = new Course();
            course.setId(vo.getId());
            course.setName(vo.getName());
            course.setWeekday(vo.getWeekday());
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

}

