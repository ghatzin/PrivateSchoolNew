/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO extends DAOConnection {
     
    public CourseDAO(){
       setConnection();
   }
     
    public List<Course> getListOfCourses() {
        List<Course> list = new ArrayList();
        String query = "select * from course";
        Statement st=null;
        ResultSet rs=null;
        
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Course course = new Course(rs.getString("courseId"),rs.getString("title"),
                                        rs.getString("stream"),rs.getString("enrollType"),
                                        rs.getString("startDate"),rs.getString("endDate"));
               
                list.add(course);
            }
            
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        finally
        {
            try{
                
                rs.close();
                st.close();
                closeConnection();
            }
            catch (SQLException e)
            {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, e);
               
            }
        }
        return list;
    }

    public Course getCoursetById(String id) {
        String query = "select * from course where courseId = ?";
        Course course = new Course();
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,id);
            rs = pst.executeQuery();
            rs.next();
            course.setCourseId(rs.getString(1));
            course.setTitle(rs.getString(2));
            course.setStream(rs.getString(3));
            course.setType(rs.getString(4));
            course.setStartDate(rs.getString(5));
            course.setEndDate(rs.getString(6));
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return course;
    }

    public void insertCourse(String courseId, String title,String stream,String enrollType,String startDate,String endDate) {
        String query = "INSERT INTO course VALUES (?,?,?,?,?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,courseId);
            pst.setString(2,title);
            pst.setString(3,stream);
            pst.setString(4,enrollType);
            pst.setString(5,startDate);
            pst.setString(6,endDate);
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
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void deleteCourseById(String id){
        String query = "delete from course where courseId = ?";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            int result = pst.executeUpdate();
            if(result>0){
                System.out.println("Course with: "+id+" Successfully deleted");
            }else{
                System.out.println("Course with id "+id+" was not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void updateCourseById(String courseId, String title,String type,String stream,String startDate,String endDate){
        String query = "update course set title = ?, stream = ?, enrollType = ?, startDate = ?,endDate = ? where courseId = ? ";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
                pst = conn.prepareStatement(query);
                pst.setString(1, title);
                pst.setString(2, stream);
                pst.setString(3, type);
                pst.setString(4,startDate);
                pst.setString(5,endDate);
                pst.setString(6,courseId);
             
                int result = pst.executeUpdate();
                if(result>0){
                    System.out.println("successfully updated");
                }else{
                    System.out.println("customer not updated");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    
}
