/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;

public class StudentsPerCourse {
    
    private Course course;
    private List<Student> students;
    
    public StudentsPerCourse(){
        
        this.students=new ArrayList<Student>();
    }
    
    public void StudentsPerCourse(Course course,List<Student> students)
    {
        this.course=course;
        this.students=students;
    }
    
    public void setCourse(Course course){
        this.course=course;
    }
    
    public Course getCourse(){
        
        return course;
    }
    
    public void setStudent(Student student){
        students.add(student);
    }
    
    public void setStudents(List<Student> students){
        this.students=students;
    }
    
    public List<Student> getStudents(){
        
        return students;
    }
    
    
    
    
}
