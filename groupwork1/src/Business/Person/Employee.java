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

////have name,id,role
public class Employee extends Person{
    boolean enabled;
    String pwd;
    
    public Employee(String name, String NUID,String role,String pwd,boolean enabled) {
        super(name,NUID,role);
        this.pwd=pwd;
        this.enabled=enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public String getRole(){
        return  "Employee";
    }
}
