/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Trainer;
import java.sql.Connection;
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
public class TrainerDAO extends DAOConnection {
   
    public TrainerDAO(){
       setConnection();
   }
     
    public List<Trainer> getListOfTrainers() {
        List<Trainer> trainers = new ArrayList();
        String query = "select * from trainer";
        Statement st=null;
        ResultSet rs=null;
        
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Trainer trainer = new Trainer(rs.getString("trainerId"),rs.getString("firstName"),rs.getString("lastName"));
                trainers.add(trainer);
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
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, e);
               
            }
        }
        return trainers;
    }

    public Trainer getTrainerById(String id) {
        String query = "select * from trainer where trainerId = ?";
        Trainer trainer = new Trainer();
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            trainer.setTrainerId(rs.getString(1));
            trainer.setLastName(rs.getString(2));
            trainer.setFirstName(rs.getString(3));
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trainer;
    }

    public void insertTrainer(String trainerId, String lastName,String firstName) {
        String query = "INSERT INTO trainer VALUES (?,?,?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, trainerId);
            pst.setString(2, lastName);
            pst.setString(3, firstName);
            
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
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void deleteTrainerById(String id){
        String query = "delete from trainer where trainerId = ?";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            int result = pst.executeUpdate();
            if(result>0){
                System.out.println("Trainer with: "+id+" Successfully deleted");
            }else{
                System.out.println("Trainer with id "+id+" was not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void updateTrainerById(String trainerId, String lastName,String firstName){
        String query = "update trainer set lastName = ?,firstName = ? where trainerId = ? ";
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
                pst = conn.prepareStatement(query);
                pst.setString(1, lastName);
                pst.setString(2, firstName);
                pst.setString(3,trainerId);
             
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
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
