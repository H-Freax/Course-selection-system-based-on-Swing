/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.time.LocalDateTime;

/**
 *
 * @author 15469
 */
public class Course {
    String id;
    String name;
    String intro;
    int point;
    String topic;
    String semesterid;
    String status;
    String professor;
    String location;
    int stuLimited;
    int stuCount;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    
    
    
    public Course(LocalDateTime lastUpdate,LocalDateTime lastActive,int stuLimited,String location,int point,String intro,String id, String name, String topic, String semester, String status, String professor) {
        this.beginTime=lastActive;
        this.endTime=lastUpdate;
        this.intro=intro;
        this.id = id;
        this.point=point;
        this.name = name;
        this.topic = topic;
        this.semesterid = semester;
        this.status = status;
        this.professor = professor;
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

    
    
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStuLimited() {
        return stuLimited;
    }

    public void setStuLimited(int stuLimited) {
        this.stuLimited = stuLimited;
    }

    public int getStuCount() {
        return stuCount;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
        this.semesterid = semesterid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    
    

    
    
}
