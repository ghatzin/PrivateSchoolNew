/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author George
 */
public class Assignment {
    
    private String assignmentId;
    private String title;
    private String description;
    private String submissionDate;
    private String submissionTime;
    private double oralMark;
    private double totalMark;
    
    
    public Assignment(){
        
    }
    
    
    public Assignment(String assignmentId,String title,String description,String submissionDate,double oralMark,double totalMark)
    {
        this.assignmentId=assignmentId;
        this.title=title;
        this.description=description;
        this.submissionDate=submissionDate;
        this.oralMark=oralMark;
        this.totalMark=totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setSubmissionTime(String submissionTime){
         this.submissionTime=submissionTime;
    }
    
    public String getSubmissionTime(){
        
        return submissionTime;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }
    
    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }
    
   /* public LocalDateTime getSubmissionDateTime(){
        
        return submissionDate.atTime(submissionTime);
    }
    
    public String getSubmissionDateTimeAsString(){
        
        return submissionDate.getDayOfMonth()+" "+
               submissionDate.getMonth()+" "+
               submissionDate.getYear()+" "+
               submissionTime.toString();
    }*/
    
    public String toString(){
        
        return this.assignmentId+" "+this.title+" "+this.description+" "+this.oralMark+" "+
               this.totalMark+" "+getSubmissionDate();
    }
    
}
