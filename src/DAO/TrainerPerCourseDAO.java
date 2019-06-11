/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Course;
import entities.Student;
import entities.Trainer;
import entities.TrainerPerCourse;
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
public class TrainerPerCourseDAO extends DAOConnection {
        
    public TrainerPerCourseDAO(){
       setConnection();
   }
     
    public TrainerPerCourse getTrainersPerCourse(String courseId) {
        
        CourseDAO courseDAO=new CourseDAO();
        TrainerPerCourse trainersPerCourse=new TrainerPerCourse();
        Course course=courseDAO.getCoursetById(courseId);
        
        String query = "select tpc.trainerId,tpc.lastName,tpc.firstName from trainerpercourse tpc,trainer t "+
                       "where tpc.trainerId = ? and tpc.trainerId=t.trainerId";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
             
             pst = conn.prepareStatement(query);
             pst.setString(1,courseId);
             rs = pst.executeQuery();
             while(rs.next())
             {
              Trainer trainer=new Trainer();   
              trainer.setTrainerId(rs.getString(1));
              trainer.setLastName(rs.getString(2));
              trainer.setFirstName(rs.getString(3));
              trainersPerCourse.addTrainer(trainer);
            }
            
            trainersPerCourse.setCourse(course);
             
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trainersPerCourse;
    }
    
    public void insertTrainerToCourse(String courseId,String trainerId)
    {
        String query = "INSERT INTO trainerpercourse VALUES (?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,trainerId);
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
                Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
    }
      
    public void deleteTrainerFromCourse(String courseId,String trainerId){
        
        String query = "delete from trainertpercourse where courseId=? and trainerId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,trainerId);
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
                Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public void updateCourseId(String courseId,String studentId){
        
        String query = "update trainerpercourse set courseId=? where trainerId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,studentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Failed to update record");
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
                Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void updateTrainerId(String courseId,String trainerId)
    {
        
        String query = "update trainerpercourse set trainerId=? where courseId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,trainerId);
            pst.setString(2,courseId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Failed to update record");
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
                Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
}
