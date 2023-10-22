/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Person.Student;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class StudentDirectory{
    ArrayList<Student> studentList;
    
    public StudentDirectory() {
        studentList=new ArrayList<>();
    }
    
    public boolean delete(Student p){
        return studentList.remove(p);
    }

    public Student newStudent(Student p) {
        studentList.add(p);
        return p;
    }

    public Student findStudent(String id) {

        for (Student p : studentList) {

            if (p.getUserbyName(id)!=null) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
