/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Feedback;

/**
 *
 * @author 15469
 */
public class ProfessorFeedback extends Feedback{
    String id;
    public ProfessorFeedback(String feedback,String id) {
        super(feedback);
        this.id=id;
    }
    
}
