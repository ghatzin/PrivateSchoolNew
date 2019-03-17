/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Course;
import entities.Student;
import entities.StudentsPerCourse;
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
public class StudentsPerCourseDAO extends DAOConnection {
    
    public StudentsPerCourseDAO(){
       setConnection();
   }
     
    public StudentsPerCourse getStudentsPerCourse(String courseId) {
        
        CourseDAO courseDAO=new CourseDAO();
        List<Student> students=new ArrayList<Student>();
        StudentsPerCourse studentsPerCourse=new StudentsPerCourse();
        Course course=courseDAO.getCoursetById(courseId);
        
        String query = "select spc.studentId,s.firstName,s.lastName,s.dateOfBirth,s.tuitionFees from studentpercourse spc,student s "+
                       "where spc.courseId = ? and spc.studentId=s.studentId";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
             
             pst = conn.prepareStatement(query);
             pst.setString(1,courseId);
             rs = pst.executeQuery();
             while(rs.next())
             {
              Student student=new Student();   
              student.setStudentId(rs.getString(1));
              student.setLastName(rs.getString(2));
              student.setFirstName(rs.getString(3));
              student.setDateOfBirth(rs.getString(4));
              student.setTuitionFees(rs.getDouble(5));
              students.add(student);
            }
            
            studentsPerCourse.setCourse(course);
            studentsPerCourse.setStudents(students);
             
             
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
        return studentsPerCourse;
    }
    
    public void insertStudentToCourse(String courseId,String studentId)
    {
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
      
    public void deleteStudentFromCourse(String studentId){
        
        String query = "delete from studentpercourse where studentId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,studentId);
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
    
    
    public void updateStudentPerCourse(String courseId,String studentId){
        
        String query = "update studentpercourse set courseId=?,studentId=?";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,studentId);
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
