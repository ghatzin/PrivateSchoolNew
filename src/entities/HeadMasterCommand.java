/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DAO.AssignmentDAO;
import DAO.CourseDAO;
import DAO.StudentDAO;
import DAO.TrainerDAO;

/**
 *
 * @author George
 */
public class HeadMasterCommand {
    
    private HeadMaster headMaster;
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;
    private AssignmentDAO assignmentDAO;
    private TrainerDAO trainerDAO;
    
    
    public HeadMasterCommand(HeadMaster headMaster)
    {
        this.headMaster=headMaster;
        courseDAO=new CourseDAO();
        studentDAO=new StudentDAO();
        assignmentDAO=new AssignmentDAO();
        trainerDAO=new TrainerDAO();
    }
    
    public void addCourse(String courseId, String title,String stream,String enrollType,String startDate,String endDate){
        courseDAO.insertCourse(courseId, title, stream, enrollType, startDate, endDate);
    }
    
    public void deleteCourse(String courseId){
        
         courseDAO.deleteCourseById(courseId);
    }
    
    public void updateCourse(String courseId, String title,String type,String stream,String startDate,String endDate){
        
         courseDAO.updateCourseById(courseId,title,type,stream,startDate,endDate);
    }
    
    public Course getCourse(String courseId){
        
      return courseDAO.getCoursetById(courseId);
    }
    
    public void createAssignment(String assignmentId, String title,String description,String submissionDate,double oralMark,double totalMark)
    {
        assignmentDAO.insertAssignment(assignmentId, title, description, submissionDate, oralMark, totalMark);
    }        
    
    public void deleteAssignment(String assignmentId){
        
        assignmentDAO.deleteAssignmentById(assignmentId);
    }
    
    public void updateAssignment(String assignmentId, String title,String description,String submissionDate,double oralMark,double totalMark)
    {
        assignmentDAO.updateAssignmentById(assignmentId, title, description, submissionDate, oralMark, totalMark);
    }
    
    public Assignment getAssignment(String assignmentId){
       return  assignmentDAO.getAssignmentById(assignmentId);
    }
    
    
    public void createTrainer(String trainerId, String lastName,String firstName){
        
        trainerDAO.insertTrainer(trainerId, lastName, firstName);
    }
    
  
    public void deleteTrainer(String trainerId){
        trainerDAO.deleteTrainerById(trainerId);
    }

    public void updateTrainer(String trainerId, String lastName,String firstName){
        
        trainerDAO.updateTrainerById(trainerId, lastName, firstName);
    }
    
    
    public Trainer getTrainer(String trainerId){
        
        return trainerDAO.getTrainerById(trainerId);
    }
    
    
 
}
