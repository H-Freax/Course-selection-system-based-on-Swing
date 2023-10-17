/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */

//你们两个写的不一样，看看怎么搞s
public class Course {
    String id;
    String type;
    String name;
    String intro;
    ArrayList<FacultyProfile> facultylist;
    ArrayList<StudentProfile> studentlist;

    public Course(String id, String type, String name, String intro) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.intro = intro;
        this.facultylist = new ArrayList<>();
        this.studentlist = new ArrayList<>();
    }

    public boolean AddFaculty(){
        return true;
    }
    
    public boolean DeleteFaculty(){
        return true;
    }
    
    public boolean AddStudent(){
        return true;
    }
    
    public boolean DeleteStudent(){
        return true;
    }
    
    public boolean isMatch(String id) {
        if (getId().equals(id)) {
            return true;
        }
        return false;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public ArrayList<FacultyProfile> getFacultylist() {
        return facultylist;
    }

    public void setFacultylist(ArrayList<FacultyProfile> facultylist) {
        this.facultylist = facultylist;
    }

    public ArrayList<StudentProfile> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(ArrayList<StudentProfile> studentlist) {
        this.studentlist = studentlist;
    }
    
    
}
