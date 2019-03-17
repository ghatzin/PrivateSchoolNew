/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;


import java.util.*;
import entities.*;
import java.time.LocalDate;
/**
 *
 * @author George
 */
public class StudentSession extends Session {
    
    private LocalDate loginDateTime;
    private Student student;
    
    public StudentSession(Student student)
    {
        this.loginDateTime=LocalDate.now();
        this.student=student;
    }
    
    
    
    public User getUser()
    {
        return student;
    }
    
    public String getLoginDateTime(){
        
        return loginDateTime.toString();
    }
    
}
