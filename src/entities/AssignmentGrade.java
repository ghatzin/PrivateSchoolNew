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
public class AssignmentGrade {
    
    private Student student;
    private Assignment assignment;
    private double grade;
    
    
    public AssignmentGrade(Student student,Assignment assignment,double grade){
        this.student=student;
        this.assignment=assignment;
        this.grade=grade;
    }
    
    public Assignment getAssignmentByCourse(Course course,String AssignmentId){
        
        
        
    }
    
    public Student getStudent(){
        return student;
    }
     
    public Assignment getAssignment(){
        
        return assignment;
    }
    
    public void setGrade(double grade){
        this.grade=grade;
    }
    
    public double getGrade(){
        
        return grade;
    }
}
