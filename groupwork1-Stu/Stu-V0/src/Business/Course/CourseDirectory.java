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
    //全局变量（唯一）  -Jinming
    
    static ArrayList<Course> courselist;
    
      public CourseDirectory (){
          
       courselist = new ArrayList();

    }

    public Course newCourse(String id, String type, String name, String intro) {

        Course p = new Course( id,  type,  name,  intro);
        courselist.add(p);
        return p;
    }

    public Course findCourse(String id) {

        for (Course p : courselist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
    }

    public static ArrayList<Course> getCourselist() {
        return courselist;
    }

    public static void setCourselist(ArrayList<Course> courselist) {
        CourseDirectory.courselist = courselist;
    }
 
    
}
