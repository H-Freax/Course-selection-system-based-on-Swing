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
public class Professor extends Person{
    double rating;
    ArrayList<Rate>ratelist;

    public Professor(String name, String NUID,String role) {
        super(name,NUID,role);
        ratelist=new ArrayList<>();
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

    public void setRatelist(ArrayList<Rate> ratelist) {
        this.ratelist = ratelist;
    }


    
    
    @Override
    public String getRole(){
        return  "Professor";
    }    
}
