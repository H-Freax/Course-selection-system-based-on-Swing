/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

// Create person objects to represent customer organizations. 
        Person person005 = persondirectory.newPerson("Dell");
        Person person006 = persondirectory.newPerson("Microsoft");
        Person person007 = persondirectory.newPerson("Google");
        Person person008 = persondirectory.newPerson("JP Morgan");
        Person person009 = persondirectory.newPerson("State street"); //we use this as customer

// Create Customers


// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

        
 //Create Student  -zhiyu ma       
        Person person011 = persondirectory.newPerson("State street"); //we use this as customer
        StudentDirectory studirectory = business.getStudentDirectory();
        StudentProfile studprofile = studirectory.newStudentProfile(person011);
        
//Create Professor   - zhiyu ma
        Person person010 = persondirectory.newPerson("State street"); //we use this as customer
        FacultyDirectory facdirectory = business.getFacultyDirectory();
        FacultyProfile facprofile = facdirectory.newFacultyProfile(person010);
        
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "XXXX"); /// order products for one of the customers and performed by a sales person
       //testing - zhiyu ma
        UserAccount ua4 = uadirectory.newUserAccount(facprofile, "professor", "XXXX");
        UserAccount ua5 = uadirectory.newUserAccount(studprofile, "student", "XXXX");
        return business;

    }

}
