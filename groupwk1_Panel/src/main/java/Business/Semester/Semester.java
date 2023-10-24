/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Semester;

import java.time.LocalDateTime;

/**
 *
 * @author 15469
 */
public class Semester {
    LocalDateTime startTime;
    LocalDateTime endTime;
    String id;
    String semName;
    
    public Semester(int year,String period,String id,String semName) {
        int startmonth=0;
        int endmonth=0;
        if(period.equals("Spring")){
            startmonth=1;
            endmonth=6;
        }else{
            startmonth=9;
            endmonth=11;            
        }
        this.id=id;
        this.semName=semName;
        startTime = LocalDateTime.of(year, startmonth, 1,0,0);
        endTime = LocalDateTime.of(year, endmonth, 30,24,0);  
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }
    
    
}
