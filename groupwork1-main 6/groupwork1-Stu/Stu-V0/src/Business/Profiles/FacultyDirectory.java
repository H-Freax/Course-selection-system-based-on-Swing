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


public class FacultyDirectory {
    ArrayList<FacultyProfile> facultylist;

    public FacultyDirectory() {


        facultylist = new ArrayList();

    }

    public FacultyProfile newFacultyProfile(Person p) {

        FacultyProfile sp = new FacultyProfile(p);
        facultylist.add(sp);
        return sp;
    }

    public FacultyProfile findFaculty(String id) {

        for (FacultyProfile sp : facultylist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
 
}
