/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class TrainerPerCourse {
    
   
    private Course course;
    private List<Trainer> trainers;
    
    public TrainerPerCourse(){
        
        trainers=new ArrayList<>();
    }
    
    public TrainerPerCourse(Course course){
        trainers=new ArrayList<>();
        this.course=course;
    }
    
    
    public void setTrainers(List<Trainer> trainers){
        
        this.trainers=trainers;
    }
   
    
    public void addTrainer(Trainer trainer){
        trainers.add(trainer);
    }
    
    public void setCourse(Course course){
        this.course=course;
    }
    
    public List<Trainer> getTrainers()
    {
        return trainers;
    }
    
    public Course getCourse(){
        
        return course;
    }
    
}
