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
public class Student extends User {
    
    private String studentId;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private double tuitionFees;
    
    
    public Student(){
        super();
    }
    
   
    
    public Student(String studentId,String lastName,String firstName,String dateOfBirth,double tuitionFees)
    {
       this.studentId=studentId;
       this.firstName=firstName;
       this.lastName=lastName;
       this.dateOfBirth=dateOfBirth;
       this.tuitionFees=tuitionFees;
    }

    public void setStudentId(String studentId){
        
        this.studentId=studentId;
    }
    
    public String getStudentId(){
        
        return studentId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
    
    
    public String toString(){
        
        return studentId+" "+firstName+" "+lastName+" "+dateOfBirth+" "+tuitionFees;
    }
    
}
