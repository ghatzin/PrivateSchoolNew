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
public class CourseSchedule {
    
    private Course course;
    private String deliveryDate;
    private String syllabusReference;
    private String learningObjectives;
  
    
    public CourseSchedule(){
        
    }
    
    public CourseSchedule(Course course){
        
        this.course=course;
    }
    
    
    public void setCourse(Course course){
        
        this.course=course;
    }
    
    public Course getCourse(){
        
        return this.course;
    }
    
    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSyllabusReference() {
        return syllabusReference;
    }

    public void setSyllabusReference(String syllabusReference) {
        this.syllabusReference = syllabusReference;
    }

    public String getLearningObjectives() {
        return learningObjectives;
    }

    public void setLearningObjectives(String learningObjectives) {
        this.learningObjectives = learningObjectives;
    }

    
    public String toString(){
        
        return deliveryDate+" "+syllabusReference+" "+learningObjectives;
    }
   
    
}
