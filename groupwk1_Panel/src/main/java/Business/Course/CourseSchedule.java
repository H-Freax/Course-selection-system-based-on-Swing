package Business.Course;

import java.time.LocalDateTime;

/**
 *
 * @author 15469
 */
public class CourseSchedule {
    String course_id;
    String weekday;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public CourseSchedule(String course_id, String weekday, LocalDateTime beginTime, LocalDateTime endTime) {
        this.course_id = course_id;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    
    
}
