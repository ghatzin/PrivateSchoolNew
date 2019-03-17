/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author George
 */
import entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentCourseDAO extends DAOConnection {
    
    public StudentCourseDAO(){
        setConnection();
    }
    
    
    public void addStudentToCourse(String courseId,String studentId){
        
        String query = "INSERT INTO studentpercourse VALUES (?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,studentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
            }
            pst.close();
            closeConnection();
        } catch(SQLException x){
            System.out.println(x.getMessage());
        }finally{
            try {
                
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void deleteStudentFromCourse(String studentId){
        
        String query="delete from studentpercourse where studentId = ?";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,studentId);
            int result = pst.executeUpdate();
            if(result>0){
                System.out.println("Student with: "+studentId+" Successfully deleted");
            }else{
                System.out.println("Student with id "+studentId+" was not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
   
    
    public Course getCourseByStudentId(String studentId){
         String query = "select sc.courseId,c.title,c.stream,c.enrollType,c.startDate,c.endDate " +
                        "from studentpercourse sc,course c where sc.courseId=c.courseId and sc.studentId= ?";
          
          Connection conn = getConnection();
          PreparedStatement pst = null;
          ResultSet rs=null;
          Course course=null;
          try {
              pst = conn.prepareStatement(query);
              pst.setString(1, studentId);
              rs = pst.executeQuery();
              rs.next();
              course = new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          return course;
    }
    
    public void updateStudentPerCourse(String courseId,String studentId){
         String query = "update studentpercourse set courseId=?,studentId=? where studentId=? and courseId=?"; 
          
          Connection conn = getConnection();
          PreparedStatement pst = null;
          ResultSet rs=null;
          Course course=null;
          try {
              pst = conn.prepareStatement(query);
              pst.setString(1,courseId);
              pst.setString(2,studentId);
              pst.setString(3,studentId);
              pst.setString(4,courseId);
              rs = pst.executeQuery();
              rs.next();
              course = new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
    private Course getCourse(String courseId){
        
        CourseDAO courseDAO=new CourseDAO();
        return courseDAO.getCoursetById(courseId); 
    }
    
    private Student getStudent(String studentId)
    {
        StudentDAO studentDAO=new StudentDAO();
        return studentDAO.getStudentById(studentId);
        
    }
    
}
