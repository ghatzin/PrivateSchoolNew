/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author George
 */
public class User {
    
    protected String userId;
    protected String username;
    protected String password;
    protected String role;

    public User(){
        
    }
    
    public User(String username,String password){
        
        this.username=username;
        this.password=password;
    }
    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

   
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    public void setuserName(String userName){
        this.username=userName;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getuserName(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
