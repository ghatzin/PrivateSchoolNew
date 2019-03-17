/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AssignmentDAO extends DAOConnection {
    
    public AssignmentDAO(){
       setConnection();
   }
     
    public List<Assignment> getListOfAssignments() {
        List<Assignment> assignments = new ArrayList();
        String query = "select * from assignment";
        PreparedStatement st=null;
        ResultSet rs=null;
        
        try {
            st = getConnection().prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                Assignment assignment = new Assignment(rs.getString("assignmentId"),rs.getString("title"),
                                        rs.getString("description"),rs.getString("submissionDate"),
                                        rs.getDouble("oralMark"),rs.getDouble("totalMark"));
               
                assignments.add(assignment);
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
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, e);
               
            }
        }
        return assignments;
    }

    public Assignment getAssignmentById(String id) {
        String query = "select * from assignment where assignmentId = ?";
        Assignment assignment = new Assignment();
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            assignment.setAssignmentId(rs.getString(1));
            assignment.setTitle(rs.getString(2));
            assignment.setDescription(rs.getString(3));
            assignment.setSubmissionTime(rs.getString(4));
            assignment.setOralMark(rs.getDouble(5));
            assignment.setTotalMark(rs.getDouble(6));
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return assignment;
    }

    public void insertAssignment(String assignmentId, String title,String description,String submissionDate,double oralMark,double totalMark) {
        String query = "INSERT INTO assignment VALUES (?,?,?,?,?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, assignmentId);
            pst.setString(2, title);
            pst.setString(3, description);
            pst.setString(4, submissionDate);
            pst.setDouble(5, oralMark);
            pst.setDouble(6, totalMark);
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
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void deleteAssignmentById(String id){
        String query = "delete from assignment where assignmentId = ?";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            int result = pst.executeUpdate();
            if(result>0){
                System.out.println("Assignemnt with: "+id+" Successfully deleted");
            }else{
                System.out.println("Assignment with id "+id+" was not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void updateAssignmentById(String assignmentId, String title,String description,String submissionDate,double oralMark, double totalMark){
        String query = "update assignment set title = ?,description = ?, submissionDate = ?, oralMark = ?, totalMark = ? where assignmentId = ? ";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
                pst = conn.prepareStatement(query);
                pst.setString(1, title);
                pst.setString(2, description);
                pst.setString(3, submissionDate);
                pst.setDouble(4,oralMark);
                pst.setDouble(5,totalMark);
                pst.setString(6,assignmentId);
                
             
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
