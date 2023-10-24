/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author freax
 */
public class PersonList {
    private ArrayList<Person> personhistory;
    
    public PersonList(){
        this.personhistory = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonhistory() {
        return personhistory;
    }

    public void setUserhistory(ArrayList<Person> personhistory) {
        this.personhistory = personhistory;
    }
    
    public void addPerson(Person person){
        personhistory.add(person);
    }
    
    public void deletePerson(Person person){
        personhistory.remove(person);
    }
    
    public Person searchPersonByNUID(String searchid){
        for(Person person: personhistory){
            if(person.getNUID().equals(searchid)){
                return person;
            }
        }
        return null;
    }
    
    public Person searchPersonByusername(String username){
        for(Person person: personhistory){
            ArrayList<User> users = person.getUsers();
            for(User user: users){
                if(user.getUsername().equals(username)){
                    return person;
            }
        }
            
        }
        return null;
    }
    
    public String toText() {
        StringBuilder text = new StringBuilder();
        for (Person person : personhistory) {
            text.append(person.toText()).append("\n");
        }
        return text.toString();
    }
    
     

}
