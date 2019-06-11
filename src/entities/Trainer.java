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
public class Trainer extends User {
    
    private String trainerId;
    private String firstName;
    private String lastName;
   
    
    public Trainer(){
        super();
    }
    
    public Trainer(String trainerId,String lastName,String firstName)
    {
        this.trainerId=trainerId;
        this.firstName=firstName;
        this.lastName=lastName;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String toString()
    {
        return trainerId+" "+firstName+" "+lastName+" "+role;
    }
}
