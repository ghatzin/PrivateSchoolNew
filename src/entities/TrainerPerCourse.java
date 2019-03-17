/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author George
 */
public class TrainerPerCourse {
    
    private Trainer trainer;
    private Course course;
    
    public TrainerPerCourse(Trainer trainer,Course course){
        this.trainer=trainer;
        this.course=course;
    }
    
    public void setTrainer(Trainer trainer){
        this.trainer=trainer;
    }
    
    public void setCourse(Course course){
        this.course=course;
    }
    
    public Trainer getTrainer()
    {
        return trainer;
    }
    
    public Course getCourse(){
        
        return course;
    }
    
}
