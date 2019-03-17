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
public class HeadMaster extends User {
    
    private String administratorId;
    private String firstName;
    private String lastNAme;
    
    
    public HeadMaster(){
        
        super();
    }
    
    
    public HeadMaster(String administratorId,String firstName,String lastName){
        
        super();
        this.administratorId=administratorId;
        this.firstName=firstName;
        this.lastNAme=lastName;
        
    }

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }
    
    
}
