/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Assignment;
import entities.AssignmentPerCourse;
import entities.Course;
import entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class AssignmentPerCourseDAO extends DAOConnection {
    
    
    public AssignmentPerCourseDAO(){
       setConnection();
   }
     
    public AssignmentPerCourse getAssignmentPerCourse(String courseId) {
        
        CourseDAO courseDAO=new CourseDAO();
        List<Assignment> assignments=new ArrayList<Assignment>();
        AssignmentPerCourse assignmentsPerCourse=new AssignmentPerCourse();
        Course course=courseDAO.getCoursetById(courseId);
        assignmentsPerCourse.setCourse(course);
        
        
        String query = "select apc.assignmentId,apc.title,apc.description,apc.submissionDate,apc.oralMark,apc.totalMark " +
                       "from assignmentpercourse apc,assignment a where apc.assignmentId = ? and apc.assignmentId=a.assignmentId";
        
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
             
             pst = conn.prepareStatement(query);
             pst.setString(1,courseId);
             rs = pst.executeQuery();
             while(rs.next())
             {
              Assignment assignment=new Assignment();   
              assignment.setAssignmentId(rs.getString(1));
              assignment.setTitle(rs.getString(2));
              assignment.setSubmissionDate(rs.getString(3));
              assignment.setOralMark(rs.getDouble(4));
              assignment.setTotalMark(rs.getDouble(5));
              assignmentsPerCourse.setAssignment(assignment);
            }
            
           
            return assignmentsPerCourse;
             
             
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return assignmentsPerCourse;
    }
    
    public void insertAssignmentToCourse(String courseId,String assignmentId)
    {
        String query = "INSERT INTO assignmentpercourse VALUES (?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,assignmentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
            }
            pst.close();
            closeConnection();
        } catch(SQLException x){
            x.getMessage();
        }finally{
            try {
                
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
    }
      
    public void deleteAssignmentFromCourse(String assignmentId){
        
        String query = "delete from assignmentpercourse where assignmentId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,assignmentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully deleted");
            } else {
                System.out.println("Failed to delete record");
            }
            pst.close();
            closeConnection();
        } catch(SQLException x){
            x.getMessage();
        }finally{
            try {
                
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public void updateAssignmentPerCourse(String courseId,String assignmentId){
        
        String query = "update assignmentpercourse set courseId=?,assignmentId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,assignmentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully deleted");
            } else {
                System.out.println("Failed to delete record");
            }
            pst.close();
            closeConnection();
        } catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
}
