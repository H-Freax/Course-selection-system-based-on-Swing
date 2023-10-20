/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class Directory {
    ArrayList<Person> personlist;
    
public Directory (){         
       personlist = new ArrayList();
    }

    public boolean delete(Person p){
        return personlist.remove(p);
    }

    public Person newPerson(String name, String NUID,String role) {

        Person p = new Person(name,NUID,role);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String name) {

        for (Person p : personlist) {

            if (p.getUserbyName(name)!=null) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
