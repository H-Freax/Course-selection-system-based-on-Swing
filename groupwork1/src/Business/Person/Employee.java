/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class Employee extends Person{
    
    
    public Employee(String name, String NUID,String role) {
        super(name,NUID,role);

    }
    
    @Override
    public String getRole(){
        return  "Employee";
    }
}
