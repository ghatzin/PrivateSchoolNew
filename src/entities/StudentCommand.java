/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DAO.CourseScheduleDAO;
import DAO.StudentDAO;

/**
 *
 * @author George
 */
public class StudentCommand {

    private StudentDAO studentDAO;
    private CourseScheduleDAO courseScheduleDAO;
    private Student student;
    
    public StudentCommand(){
        
    }
    
    public StudentCommand(Student student){
        this.student=student;
        
    }
    
    public void seeAssignmentsToSubmitPerCourse()
    {
        
    }
    
    public void SubmitAssignmnet(){
        
        
    }
    
    public void seeDailySchedule(){
        
        
    }
    
    
}
