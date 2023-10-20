/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Directory;

import Business.Person.Professor;
import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class ProfessorDirectory {
    ArrayList<Professor> professorList;
    
    public ProfessorDirectory() {
        professorList=new ArrayList<>();
    }
    
    public boolean delete(Professor p){
        return professorList.remove(p);
    }

    public Professor newProfessor(Professor p) {
        professorList.add(p);
        return p;
    }

    public Professor findProfessor(String id) {

        for (Professor p : professorList) {

            if (p.getUserbyName(id)!=null) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
 
}
