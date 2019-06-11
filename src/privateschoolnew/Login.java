/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import DAO.UserDAO;
import entities.*;



public class Login {

    private String userName;
    private String password;
    private String role;
    private User user;
   
    
    
    
    
    public Login(){
        
        user=null;
    }
    
    
    public Login(String userName,String password,String role){
        this();
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }
    
    public void setUserName(String userName){
        
       this.userName=userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void setPassword(String password){
        
        this.password=password;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    public void checkUserCredentials(){
        UserDAO userDAO=new UserDAO();
        user=userDAO.getUser(userName,password,role);
      
    } 
    
    
    public boolean hasSuccessfullLogin(){
        if (user!=null)
           return true;
        else 
           return false;
    }
    
    
    public User getUser(){
        return user;
    }
    
    
}       
 
