/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Directory.ProfessorDirectory;
import Business.Directory.StudentDirectory;
import Business.Directory.PersonDirectory;
import Business.Directory.EmployeeDirectory;
/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role

    EmployeeDirectory employeedirectory;


    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory();


    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }



    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }



}
