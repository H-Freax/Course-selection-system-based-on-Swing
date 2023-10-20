/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Rate;

/**
 *
 * @author 15469
 */

//rating for course-professor
public class Rate {
    String professor_id ;
    String studuent_id ;
    String course_id ;
    String scorepart1 ;
    String scorepart2 ;
    String scorepart3 ;
    String scorepart4; 
    String comment;
    String score;

    public Rate(String professor_id, String studuent_id, String course_id, String scorepart1, String scorepart2, String scorepart3, String scorepart4, String comment, String score) {
        this.professor_id = professor_id;
        this.studuent_id = studuent_id;
        this.course_id = course_id;
        this.scorepart1 = scorepart1;
        this.scorepart2 = scorepart2;
        this.scorepart3 = scorepart3;
        this.scorepart4 = scorepart4;
        this.comment = comment;
        this.score = score;
    }

    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }

    public String getStuduent_id() {
        return studuent_id;
    }

    public void setStuduent_id(String studuent_id) {
        this.studuent_id = studuent_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getScorepart1() {
        return scorepart1;
    }

    public void setScorepart1(String scorepart1) {
        this.scorepart1 = scorepart1;
    }

    public String getScorepart2() {
        return scorepart2;
    }

    public void setScorepart2(String scorepart2) {
        this.scorepart2 = scorepart2;
    }

    public String getScorepart3() {
        return scorepart3;
    }

    public void setScorepart3(String scorepart3) {
        this.scorepart3 = scorepart3;
    }

    public String getScorepart4() {
        return scorepart4;
    }

    public void setScorepart4(String scorepart4) {
        this.scorepart4 = scorepart4;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    
}
