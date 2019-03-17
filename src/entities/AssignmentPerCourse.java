/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;

public class AssignmentPerCourse {
    
    private List<Assignment> assignments;
    private Course course;
    
    
    public AssignmentPerCourse(){
        assignments=new ArrayList<Assignment>();
    }
    
    public AssignmentPerCourse(Assignment assignments,Course course){
        this.assignments=new ArrayList<Assignment>();
        this.course=course;
    }
    
    public void setAssignment(Assignment assignment){
        
        assignments.add(assignment);
    }
    
    public void setCourse(Course course){
        
        this.course=course;
    }
    
    public Course getCourse(){
        
        return course;
    }
    
    public Assignment getAssignmentById(String assignmentId){
        
        Assignment assignment=new Assignment();
        
        for (int i=0;i<assignments.size();i++){
            if (assignments.get(i).getAssignmentId().equalsIgnoreCase(assignmentId))
                    assignment=assignments.get(i);
        }
        
        return assignment;
    }

    
}
