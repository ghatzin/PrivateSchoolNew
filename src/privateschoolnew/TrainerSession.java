/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import entities.Trainer;
import java.time.LocalDate;

/**
 *
 * @author George
 */
public class TrainerSession{
     
    private LocalDate loginDateTime;
    private Trainer trainer;
    
    public TrainerSession(Trainer trainer){
        
        this.loginDateTime=LocalDate.now();
        this.trainer=trainer;
    }
    
    public Trainer getTrainer(){
         return trainer;
    }
    
     public String getLoginDateTime(){
        
        return loginDateTime.toString();
    }
    
}
