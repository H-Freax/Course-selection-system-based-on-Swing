/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

/**
 *
 * @author 15469
 */
public class Student extends Person{
    double GPA;
    
    public Student(String name, String NUID,String role) {
        super(name,NUID,role);

    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    
    @Override
    public String getRole(){
        return  "Student";
    }
}
