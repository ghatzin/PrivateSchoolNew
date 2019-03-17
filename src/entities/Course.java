/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Course {
    
    private String courseId;
    private String title;
    private String stream;
    private String type;
    private String startDate;
    private String endDate;
    private List<Student> students;
    private List<Assignment> assignments;
    private List<Trainer> trainers;
    
    public Course(){
        
    }
      
    public Course(String courseId,String title,String stream,String type,String startDate,String endDate)
    {
        
        this.students=new ArrayList<Student>();
        this.assignments=new ArrayList<Assignment>();
        this.trainers=new ArrayList<Trainer>();
        this.courseId=courseId;
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startDate=startDate;
        this.endDate=endDate;
    }

  

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public void addStudent(Student student){
        students.add(student);
    }
    
    public void addTrainer(Trainer trainer)
    {
        trainers.add(trainer);
    }
    
    public void addAssignment(Assignment assignment){
        
        assignments.add(assignment);
    }
    
    public List<Student> getStudents(){
        
        return students;
    }
    
    public List<Trainer> getTrainers(){
        
        return trainers;
    }
    
    public List<Assignment> getAssignments(){
        return assignments;
    }
    
    /*public String getStartDateAsString(){
        
        return getStartDate().getDayOfMonth()+" "+
               getStartDate().getDayOfWeek()+" "+
               getStartDate().getYear();
    
    }
    
    public String getEndDateAsString(){
        
        return getEndDate().getDayOfMonth()+" "+
               getEndDate().getDayOfWeek()+" "+
               getEndDate().getYear();
    
    }*/
    
    public String toString(){
        
        return courseId+" "+title+","+stream+","+type+","+getStartDate()+","+getEndDate();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.courseId, other.courseId)) {
            return false;
        }
        return true;
    }
    
   
}
