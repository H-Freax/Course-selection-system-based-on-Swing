package Business.Course;

import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    private List<Course> courseSchedule;
    private Connection connection;
    private List<CourseInfo> courseInfoList;

    public CourseSchedule(Connection connection) {
        courseSchedule = new ArrayList<>();
        this.connection = connection;
        courseInfoList = new ArrayList<>();
    }

     public void loadCourseInfoFromDatabase() throws SQLException {
        String query = "SELECT course_id, weekday, starttime, endtime FROM CourseSchedule";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String courseId = resultSet.getString("course_id");
                String weekday = resultSet.getString("weekday");
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");

                CourseInfo courseInfo = new CourseInfo(courseId, weekday, starttime, endtime);
                courseInfoList.add(courseInfo);
            }
        }
    }

     public void addCourseInfoList(String cId, String week, String start, String end){
         CourseInfo e = new CourseInfo(cId, week, start, end);
         courseInfoList.add(e);
     }
     
     
     
    public List<CourseInfo> getCourseInfoList() {
        return courseInfoList;
    }

    // CourseInfo类用于存储从数据库中读取的课程信息
    public static class CourseInfo {
        private String courseId;
        private String weekday;
        private String starttime;
        private String endtime;

        public CourseInfo(String courseId, String weekday, String starttime, String endtime) {
            this.courseId = courseId;
            this.weekday = weekday;
            this.starttime = starttime;
            this.endtime = endtime;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        // 这里可以添加课程信息的getter方法
        public String getCourseId() {
            return courseId;
        }

        public String getWeekday() {
            return weekday;
        }

        public String getStarttime() {
            return starttime;
        }

        public String getEndtime() {
            return endtime;
        }
    }
    
    
    
    
    
    
    
    public void addCourseToSchedule(Course course) throws SQLException {
        // 添加到内存
        courseSchedule.add(course);

        // 添加到数据库
        saveCourseToScheduleInDatabase(course);
    }

    public void removeCourseFromSchedule(Course course) throws SQLException {
        // 从内存中删除
        courseSchedule.remove(course);

        // 从数据库中删除
        deleteCourseFromScheduleInDatabase(course);
    }

    public Course getCourseFromScheduleById(String courseId) {
        for (Course course : courseSchedule) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void loadCourseScheduleFromDatabase() throws SQLException {
        String query = "SELECT * FROM CourseSchedule";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = Course.getCourseFromDatabase(connection, resultSet.getString("courseId"));
                courseSchedule.add(course);
            }
        }
    }

    public List<Course> getAllCoursesInSchedule() {
        return courseSchedule;
    }

    private void saveCourseToScheduleInDatabase(Course course) throws SQLException {
        String query = "INSERT INTO CourseSchedule (courseId) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }

    public void saveCourseScheduleInDatabase(CourseInfo course) throws SQLException {
        String query = "INSERT INTO CourseSchedule (courseId) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getWeekday());
            statement.setString(3, course.getStarttime());
            statement.setString(4, course.getEndtime());
            statement.executeUpdate();
        }
    }
    
    
    public void insertCourseInfoIntoDatabase(CourseInfo course) throws SQLException {
    String query = "INSERT INTO CourseSchedule (course_id, weekday, starttime, endtime) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, course.getCourseId());
        statement.setString(2, course.getWeekday());
        statement.setString(3, course.getStarttime());
        statement.setString(4, course.getEndtime());
        statement.executeUpdate();
    }
}
    
    
    
    public void updateCourseInfoInDatabase(CourseInfo course1,CourseInfo course) throws SQLException {
    String query = "UPDATE CourseSchedule SET course_id=?,weekday = ?, starttime = ?, endtime = ? WHERE course_id = ? AND weekday = ? AND starttime = ? AND endtime = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getWeekday());
            statement.setString(3, course.getStarttime());
            statement.setString(4, course.getEndtime());
            statement.setString(5, course1.getCourseId());
            statement.setString(6, course1.getWeekday());
            statement.setString(7, course1.getStarttime());
            statement.setString(8, course1.getEndtime());
        statement.executeUpdate();
    }
}
    public void deleteCourseInfoFromDatabase(CourseInfo course) throws SQLException {
    String query = "DELETE FROM CourseSchedule WHERE course_id = ? AND weekday = ? AND starttime = ? AND endtime = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, course.getCourseId());
        statement.setString(2, course.getWeekday());
        statement.setString(3, course.getStarttime());
        statement.setString(4, course.getEndtime());
        statement.executeUpdate();
    }
}

    
    private void deleteCourseFromScheduleInDatabase(Course course) throws SQLException {
        String query = "DELETE FROM CourseSchedule WHERE courseId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getId());
            statement.executeUpdate();
        }
    }
    
    
    
    
    
    
    
}
