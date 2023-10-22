/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class CourseDirectory {
    ArrayList<Course> courselist;
    
    public CourseDirectory(){
        courselist = new ArrayList<>();
    }
    
    public boolean Add(Course course){
        return courselist.add(course);
    }
    
    public boolean Delete(Course course){
        return courselist.remove(course);
    }
    
    public Course Find(Course course){
        Course newcourse=null;
        for(Course obj : courselist){
            if(obj.equals(course)){
                newcourse=course;
                break;
            }
        }
        return newcourse;
    }
    
    
}
