/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

/**
 *
 * @author 15469
 */


import Business.Person.Person;

public class FacultyProfile extends Profile{
    
//Profile 已经有person了
//    Person person;
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
