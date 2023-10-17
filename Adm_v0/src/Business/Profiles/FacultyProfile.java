/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

/**
 *
 * @author 15469
 */


import Business.Business;
import Business.Person.Person;

import java.util.ArrayList;

public class FacultyProfile extends Profile{

    Person person;
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    public FacultyProfile(Person p) {
        super(p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    
}
