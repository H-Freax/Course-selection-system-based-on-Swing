/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Rate.Rate;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */

////have name,id,role
public class Professor extends Person{
    double rating;              //rate for professor
    ArrayList<Rate>ratelist;    //rate for course
    String region;
    String language;
    boolean enabled;
    
    
    public Professor(String name, String NUID,String role,String language,String region,boolean enabled) {
        super(name,NUID,role);
        ratelist=new ArrayList<>();
        this.language=language;
        this.region=region;
        this.enabled=enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean addRating(Rate rate){
        return ratelist.add(rate);
    }
    public boolean deleteRating(Rate rate){
        return ratelist.remove(rate);
    }
    
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    
    public ArrayList<Rate> getRatelist() {
        return ratelist;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    


    
    
    @Override
    public String getRole(){
        return  "Professor";
    }    
}
