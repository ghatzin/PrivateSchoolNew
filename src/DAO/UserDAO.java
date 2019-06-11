/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entities.HeadMaster;
import entities.Student;
import entities.Trainer;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class UserDAO extends DAOConnection {
    
    
    public UserDAO(){
        setConnection();
    }
    
    public User getUser(String userName,String password,String role)
    {
        
        String query = "select * from usercredentials where username = ? and userPassword=MD5(?) and role= ?";
        User user = new User();
        Connection conn = getConnection(); 
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,password);
            pst.setString(3,role);
            rs = pst.executeQuery();
            rs.next();
            user.setUserId(rs.getString(1));
            user.setuserName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRole(rs.getString(4));
            if (user.getRole().equalsIgnoreCase("student"))
            {
                user=new Student();
                user=getStudent(userName,password);
            }
            else if (user.getRole().equalsIgnoreCase("trainer"))
            {
                user=new Trainer();
                user=getTrainer(userName,password);
            }
            else if (user.getRole().equalsIgnoreCase("headmaster"))
            {
                user=new HeadMaster();
                user=getHeadMaster(userName,password);
            }
            
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }
    
     public Student getStudent(String userName,String password)
    {
        
        String query = "select us.studentId,s.lastName,s.firstName,s.dateOfBirth,s.tuitionFees from student s, usercredentials uc, userstudent us " +
                       "where uc.username = ? and uc.userPassword=MD5(?) and uc.userId=us.userId and us.studentId=s.studentId";
        Student student = new Student();
        Connection conn = getConnection(); 
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,password);
            rs = pst.executeQuery();
            rs.next();
            student.setStudentId(rs.getString(1));
            student.setLastName(rs.getString(2));
            student.setFirstName(rs.getString(3));
            student.setDateOfBirth(rs.getString(4));
            student.setTuitionFees(rs.getDouble(5));
            student.setRole("student");
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return student;
    }
     
      public Trainer getTrainer(String userName,String password)
      {
        
        String query = "select ut.trainerId,t.lastName,t.firstName from trainer t, usercredentials uc, usertrainer ut " +
                       "where uc.username = ? and uc.userPassword=MD5(?) and uc.userId=ut.userId and ut.trainerId=t.trainerId";
        Trainer trainer = new Trainer();
        Connection conn = getConnection(); 
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,password);
            rs = pst.executeQuery();
            rs.next();
            trainer.setTrainerId(rs.getString(1));
            trainer.setLastName(rs.getString(2));
            trainer.setFirstName(rs.getString(3));
            trainer.setRole("trainer");
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trainer;
    }
    
      
     public HeadMaster getHeadMaster(String userName,String password){
         
        String query = "select ua.administratorId,a.lastName,a.firstName from administrator a, usercredentials uc, useradministrator ua " +
                       "where uc.username = ? and uc.userPassword=MD5(?) and uc.userId=ua.userId and ua.administratorId=a.administratorId";
         
        HeadMaster headMaster = new HeadMaster();
        Connection conn = getConnection(); 
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,password);
            rs = pst.executeQuery();
            rs.next();
            headMaster.setAdministratorId(rs.getString(1));
            headMaster.setFirstName(rs.getString(2));
            headMaster.setLastNAme(rs.getString(3));
            headMaster.setRole("headmaster");
        }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return headMaster;
         
     }
     
     public void insertUser(String userId,String userName,String password,String role,String id)
     {
        String query = "INSERT INTO usercredentials (userId,username,userPassword,role)  VALUES (?,?,MD5(?),?)";
        Connection con=null;
        PreparedStatement pst=null;
        
        try {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,userName);
            pst.setString(3, password);
            pst.setString(4,role);
            pst.executeUpdate();
            pst.close();
            closeConnection();
            if (role.equalsIgnoreCase("student"))
                insertStudent(userId,id);
            else if (role.equalsIgnoreCase("trainer"))
                insertTrainer(userId,id);
            else if (role.equalsIgnoreCase("headmaster"))
                insertHeadMaster(userId,id);
        } catch(SQLException x){
            x.printStackTrace();
        }finally{
            try 
            {
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
     
     public void insertStudent(String userId,String studentId)
     {
          
          String query="insert into userstudent (userId,studentId) values (?,?)";
          
          Connection con=null;
          PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,studentId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
     }//end insrt student
     
     public void insertTrainer(String userId,String trainerId)
     {
         
         String query="insert into usertrainer (userId,trainerId) values (?,?)";
          
          Connection con=null;
          PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,trainerId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
         
     }//end of insert trainer
     
     
     public void insertHeadMaster(String userId,String administratorId)
     {
         
         String query="insert into useradministrator (userId,administratorId) values (?,?)";
          
          Connection con=null;
          PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,administratorId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully inserted");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
         
     }//end of insert headMaster
     
    
     public void deleteUser(String userId,String roleId)
     {
         
         String query="delete from usercredentials where userId=? and role=?";
        
          
         Connection con=null;
         PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,roleId);
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully deleted");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
     }
     
    public void updateUserRole(String userId,String role)
    {
         String query="update usercredentials set role=? where userId=?";
        
          
         Connection con=null;
         PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,role);
            pst.setString(2,userId);
            //pst.setString(3,role);
            //pst.setString(4,userId);
            
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
  
    }
    
    
    public void updateUserId(String userId,String userName,String userPassword,String role)
    {
         String query="update usercredentials set userId=? where username=? and userPassword=MD5(?) and role=?";
        
          
         Connection con=null;
         PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userId);
            pst.setString(2,userName);
            pst.setString(3,userPassword);
            pst.setString(4,role);
            
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
  
    }
    
    public void updateUserNamePassword(String userId,String userName,String userPassword,String role)
    {
         String query="update usercredentials set username=?,userPassword=MD5(?) where userId=? and role=?";
        
          
         Connection con=null;
         PreparedStatement pst=null;
        
          try 
          {
            con=getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,userPassword);
            pst.setString(3,userId);
            pst.setString(4,role);
            
            int noumero = pst.executeUpdate();
            if (noumero > 0) {
                System.out.println("Record succesfully updated");
            } else {
                System.out.println("Not success");
            }
         }catch(SQLException x){
            x.printStackTrace();
        }finally{
            try {
     
                pst.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
  
    }

}
         
         
 
