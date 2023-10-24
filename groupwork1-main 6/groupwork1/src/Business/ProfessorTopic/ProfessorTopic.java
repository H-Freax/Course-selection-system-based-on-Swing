/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.ProfessorTopic;

/**
 *
 * @author 15469
 */
// professor teaching topic
public class ProfessorTopic {
    String pid;
    String topic;

    public ProfessorTopic(String pid, String topic) {
        this.pid = pid;
        this.topic = topic;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
}
