/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Feedback;

/**
 *
 * @author 15469
 */
public class CourseFeedback extends Feedback{
    String id;
    public CourseFeedback(String feedback,String id) {
        super(feedback);
        this.id = id;
    }
    
}