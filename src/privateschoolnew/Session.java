/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import entities.Student;
import entities.Trainer;
import entities.User;
import java.time.*;

/**
 *
 * @author George
 */
public abstract class Session {

    private LocalDate loginDateTime;
    
    public Session()
    { 
        this.loginDateTime=LocalDate.now();  
    }
    
    public String getTimeStamp(){
        
        return loginDateTime.toString();
    }
    
    abstract public User getUser();
    
    
    
}
