/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Course;
import entities.CourseSchedule;
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
public class CourseScheduleDAO extends DAOConnection {
    
    public CourseScheduleDAO(){
        
        setConnection();
    }
    
    public void insertCourseSchedule(String deliveryDate,String syllabusReference,String learningObjectives,String courseId)
    {
        String query = "INSERT INTO courseschedule VALUES (?,?,?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, deliveryDate);
            pst.setString(2, syllabusReference);
            pst.setString(3, learningObjectives);
            pst.setString(4, courseId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
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
                Logger.getLogger(CourseScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteCourseSchedule(String courseId)
    {
        String query = "delete from courseschedule where courseId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
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
                Logger.getLogger(CourseScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
    public void updateCourseSchedule(String deliverDate,String syllabusReference,String learningObjectives,String courseId)
    {
        String query = "update courseschedule set  syllabusReference = ?, learningObjectives = ? where courseId = ? and deliveryDate=?"; 
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,syllabusReference);
            pst.setString(2,learningObjectives);
            pst.setString(3,courseId);
            pst.setString(4,deliverDate);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Not success");
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
                Logger.getLogger(CourseScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
    public List<CourseSchedule> getCourseScheduleById(String courseId)
    {
            
        CourseDAO courseDAO=new CourseDAO();
        Course course=courseDAO.getCoursetById(courseId);
       
        List<CourseSchedule> courseScheduleContents=new ArrayList<CourseSchedule>();
        
        String query = "select  deliveryDate,syllabusReference,learningObjectives " +
                       "from courseschedule cs,course c where cs.courseId=? and cs.courseId=c.courseId";
        
        Connection con=getConnection();
        PreparedStatement pst=null;
        ResultSet rs = null;
        try {
             
             pst = con.prepareStatement(query);
             pst.setString(1,courseId);
             rs = pst.executeQuery();
            
             while(rs.next())
             {
               
               CourseSchedule courseSchedule=new CourseSchedule();
               courseSchedule.setCourse(course); 
               courseSchedule.setDeliveryDate(rs.getString(1));
               courseSchedule.setLearningObjectives(rs.getString(2));
               courseSchedule.setSyllabusReference(rs.getString(3));
               courseScheduleContents.add(courseSchedule);
            }
     
           
        } catch(SQLException x)
        {
            x.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex)
            {
                Logger.getLogger(CourseScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return courseScheduleContents;
    }  
    
    
    
}    


