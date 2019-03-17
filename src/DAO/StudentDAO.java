/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entities.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author George
 */
public class StudentDAO extends DAOConnection
{
   
   public StudentDAO(){
       setConnection();
   }
     
    public List<Student> getListOfStudents() {
        List<Student> list = new ArrayList();
        String query = "select * from student";
        Statement st=null;
        ResultSet rs=null;
        
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Student s = new Student(rs.getString("studentId"),rs.getString("firstName"),
                                        rs.getString("lastName"),rs.getString("dateOfBirth"),
                                        rs.getDouble("tuitionFees"));
               
                list.add(s);
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
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, e);
               
            }
        }
        return list;
    }

    public Student getStudentById(String id) {
        String query = "select * from student where studentId = ?";
        Student s = new Student();
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            s.setStudentId(rs.getString(1));
            s.setLastName(rs.getString(2));
            s.setFirstName(rs.getString(3));
            s.setDateOfBirth(rs.getString(4));
            s.setTuitionFees(rs.getDouble(5));
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;
    }

    public void insertStudent(String studentId, String lastName,String firstName,String dateOfBirth,double grade) {
        String query = "INSERT INTO student VALUES (?,?,?,?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, studentId);
            pst.setString(2, lastName);
            pst.setString(3, firstName);
            pst.setString(4, dateOfBirth);
            pst.setDouble(5, grade);
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
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void deleteStudentById(String id){
        String query = "delete from student where studentId = ?";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            int result = pst.executeUpdate();
            if(result>0){
                System.out.println("Student with: "+id+" Successfully deleted");
            }else{
                System.out.println("Student with id "+id+" was not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void updateStudentById(String student_Id, String lastName,String firstName,String dateOfBirth,double tuitionFees){
        String query = "update student set lastName = ?,firstName = ?, dateOfBirth = ?, tuitionFees = ? where studentId = ? ";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
                pst = conn.prepareStatement(query);
                pst.setString(1, lastName);
                pst.setString(2, firstName);
                pst.setString(3, dateOfBirth);
                pst.setDouble(4,tuitionFees);
                pst.setString(5,student_Id);
             
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
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

