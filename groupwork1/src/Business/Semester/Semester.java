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

    public Semester(int year,String period) {
        int startmonth=0;
        int endmonth=0;
        if(period.equals("Spring")){
            startmonth=1;
            endmonth=6;
        }else{
            startmonth=9;
            endmonth=11;            
        }
        LocalDateTime startTime = LocalDateTime.of(year, startmonth, 1,0,0);
        LocalDateTime endTime = LocalDateTime.of(year, endmonth, 30,24,0);  
    }
    
    
}
