/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Person.Employee;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */


public class EmployeeDirectory{
    ArrayList<Employee> employeeList;
    
    public EmployeeDirectory() {
        employeeList=new ArrayList<>();
    }
    
    public boolean delete(Employee p){
        return employeeList.remove(p);
    }

    public Employee newEmployee(Employee p) {
        employeeList.add(p);
        return p;
    }

    public Employee findEmployee(String id) {

        for (Employee p : employeeList) {

            if (p.getUserbyName(id)!=null) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
    
}
