/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Student;

import Business.Profiles.*;
import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

//改动 referance
    ArrayList<StudentProfile> studentProfileList;
    

    public StudentDirectory() {

     studentProfileList = new ArrayList();

    }

    //step1 ：传人的信息，但信息比较少
    public StudentProfile newStudentProfile(Person p) {
//person->Studentprofile(StudentAccount)
        StudentProfile sp = new StudentProfile(p);
        studentProfileList.add(sp);
        return sp;
    }

      public void addStudentProfile(StudentProfile p) {
//        StudentProfile sp = new StudentProfile(p);
        studentProfileList.add(p);
       
    }
      
    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentProfileList) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }

    public ArrayList<StudentProfile> getStudentProfileList() {
        return studentProfileList;
    }

    public void setStudentProfileList(ArrayList<StudentProfile> studentProfileList) {
        this.studentProfileList = studentProfileList;
    }
    
    
}
