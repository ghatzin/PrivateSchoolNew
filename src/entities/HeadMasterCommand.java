/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DAO.AssignmentDAO;
import DAO.AssignmentPerCourseDAO;
import DAO.CourseDAO;
import DAO.StudentDAO;
import DAO.StudentPerCourseDAO;
import DAO.TrainerDAO;
import DAO.TrainerPerCourseDAO;
import DAO.UserDAO;
import java.util.List;


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
    private AssignmentPerCourseDAO assignmentCourseDAO;
    private TrainerPerCourseDAO trainerCourseDAO;
    private StudentPerCourseDAO studentCourseDAO;
    private UserDAO userDAO;
    
    
    public HeadMasterCommand(HeadMaster headMaster)
    {
        this.headMaster=headMaster;
        courseDAO=new CourseDAO();
        studentDAO=new StudentDAO();
        assignmentDAO=new AssignmentDAO();
        trainerDAO=new TrainerDAO();
        assignmentCourseDAO=new AssignmentPerCourseDAO();
        trainerCourseDAO=new TrainerPerCourseDAO();
        studentCourseDAO=new StudentPerCourseDAO();
        userDAO=new UserDAO();
    }
    
    public List<Course> getCourses(){
        
        return courseDAO.getListOfCourses();
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
    
    public List<Assignment> getAssignments(){
        
        return assignmentDAO.getListOfAssignments();
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
    
    public List<Trainer> getTrainers(){
        return trainerDAO.getListOfTrainers();
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
    
    public AssignmentPerCourse getAssignmentsPerCourse(String courseId){
        return assignmentCourseDAO.getAssignmentPerCourse(courseId);
    }
    
    public void createAssignmentPerCourse(String courseId,String assignmentId){
        
        assignmentCourseDAO.insertAssignmentToCourse(courseId,assignmentId);
    }
    
    public void updateAssignmentPerCourse(String courseId,String assignmentId){
        
        assignmentCourseDAO.updateAssignmentId(courseId, assignmentId);
    }
    
    public void deleteAssignmentFromCourse(String courseId,String assignmentId){
        
        assignmentCourseDAO.deleteAssignmentFromCourse(courseId,assignmentId);
    }
    
    public void updateCourseIdForAssignment(String courseId,String assignment){
        
        assignmentCourseDAO.updateCourseId(courseId, assignment);
    }
    
    public void updateAssignmentIdForCourse(String courseId,String assignmentId){
        
        assignmentCourseDAO.updateAssignmentId(courseId, assignmentId);
    }
    
    public TrainerPerCourse getTrainersPerCourse(String courseId){
        
        return trainerCourseDAO.getTrainersPerCourse(courseId);
    }
    
    public void assignTrainerToCourse(String coureId,String trainerId){
        
        trainerCourseDAO.insertTrainerToCourse(coureId, trainerId);
    } 
    
    public void deleteTrainerFromCourse(String courseId,String trainerId){
        
        trainerCourseDAO.deleteTrainerFromCourse(courseId,trainerId);
    }
    
    public void updateTrainerForCourse(String courseId,String trainerId){
        
        trainerCourseDAO.updateTrainerId(courseId, trainerId);
    }
    
    public void updateCourseForTainer(String courseId,String trainerId){
        
        trainerCourseDAO.updateCourseId(courseId, trainerId);
    }
    
    
    public StudentsPerCourse getStudentsPerCourse(String courseId){
        
         return studentCourseDAO.getStudentsPerCourse(courseId);
    }
    
    public void createStudentForCourse(String courseId,String studentId){
        
        studentCourseDAO.insertStudentToCourse(courseId, studentId);
    }
    
   
    public void deleteStudentFromCourse(String courseId,String studentId){
        
        studentCourseDAO.deleteStudentFromCourse(courseId,studentId);
    }
    
     public void updateCourseForStudent(String courseId,String studentId){
        
        studentCourseDAO.updateCourseId(courseId, studentId);
    }
    
    public void updateStudentForCourse(String courseId,String studentId){
        
        studentCourseDAO.updateCourseId(courseId,studentId);
    }
    
    
}
