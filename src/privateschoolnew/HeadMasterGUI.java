/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import entities.HeadMaster;
import entities.HeadMasterCommand;
import java.util.Scanner;

/**
 *
 * @author George
 */
public class HeadMasterGUI {
    
    private int userChoice;
    private HeadMasterCommand headMasterCommands;
    private Scanner inputScanner;
    
    public HeadMasterGUI(HeadMasterCommand headMasterCommand,Scanner sc){
        this.headMasterCommands=headMasterCommand;
        inputScanner=sc;
    }
   
    public void showMenuChoices(){
        System.out.println("1.Create Course");
        System.out.println("2.Get Course   ");
        System.out.println("3.Update Course");
        System.out.println("4.Delete Course");
    }


    public void setUserChoise(int userChoise){
        this.userChoice=userChoise;
    }
    
    
   
    
    
    public void executeCommand(){
        
        switch (this.userChoice)
        {
            case 1:System.out.println("Give courseId:");
                   String courseId=inputScanner.next();
                   System.out.println("Give course title");
                   String courseTitle=inputScanner.next();
                   System.out.println("Give course stream");
                   String courseStream=inputScanner.next();
                   System.out.println("Give Enrollment Type:");
                   String enrollType=inputScanner.next();
                   System.out.println("Give start date:");
                   String startDate=inputScanner.next();
                   System.out.println("Give end date:");
                   String endDate=inputScanner.next();
                   headMasterCommands.addCourse(courseId, endDate, startDate, enrollType, startDate, endDate);
                   break;
            
        }
            
                
        
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*stem.out.println("7.Update Assignment");
        System.out.println("8.Delete Assignment");  
        System.out.println("9.Create Trainer");
        System.out.println("10.Get Trainer   ");
        System.out.println("11.Update Trainer");
        System.out.println("12.Delete Trainer");
        System.out.println("13.Create User");
        System.out.println("14.Get User   ");
        System.out.println("15.Update User");
        System.out.println("16.Delete User");  
        System.out.println("17.Enroll Student  to Course");
        System.out.println("18.Get Student Enroll to Course");
        System.out.println("19.Update Student Enroll to Course");
        System.out.println("20.Delete Student Enroll to Course");
        System.out.println("21.Display Students Enroll to Course");
        System.out.println("22.Enroll Trainer  to Course");
        System.out.println("23.Get Trainer Enroll to Course");
        System.out.println("24.Update Trainer Enroll to Course");
        System.out.println("25.Delete Trainer Enroll to Course");
        System.out.println("26.Display Trainers For Course ");
        System.out.println("27.Enroll Assignment  to Course");
        System.out.println("28.Get Assignement for Course");
        System.out.println("29.Update Assignement for Course");
        System.out.println("30.Delete Assignemnt for Course");
        System.out.println("31.Display Assignemnts For Course ");*/
    
     
    
    
    
}
