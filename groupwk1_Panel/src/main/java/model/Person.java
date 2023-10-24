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
public class Person {
    
    private String name;
    private String NUID;
    private ArrayList<User> users;

    public Person(){
        
    }
    public Person(String name, String NUID) {
        this.name = name;
        this.NUID = NUID;
        this.users = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNUID() {
        return NUID;
    }

    public void setNUID(String NUID) {
        this.NUID = NUID;
    }

    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public User getUserbyName(String username){
        ArrayList<User> findusers = this.users;
        for(User us:findusers){
            if(us.getUsername().equals(username)){
                return us;
            }
        }
        return null;
    }
    
     public void addUser(User user){
        users.add(user);
    }
    
    public void deleteUser(User us){
        users.remove(us);
    }
    
    public boolean checkLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getNowpwd().equals(password)) {
                return true;
            }
        }
        return false;
    }
   
    
    public String toText() {
        StringBuilder text = new StringBuilder();
        text.append("name:").append(name).append("\n");
        text.append("NUID:").append(NUID).append("\n");
        text.append("users:\n");
        for (User user : users) {
            text.append(user.toText());
        }
        return text.toString();
    }
    
}
