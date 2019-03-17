/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;

public class StudentPerCourse1 {
    
    private Map<Course,Student> studentsPerCourses;
    private List<Student> studentsPerCourse;
    //private Course course;
   //private List<Student> students;
    
    
    
    
    
    public StudentPerCourse1()
    {
        studentsPerCourses=new HashMap<Course,Student>();
        studentsPerCourse=new ArrayList<Student>();
    }
    
    public StudentPerCourse1(Course course,Student student)
    {
        this();
        studentsPerCourses.put(course,student);
    }
    
    
    
    /*public StudentPerCourse1(Course course,Student student){
        
        this.course=course;
    }*/
    
    
    public void addStudentToCourse(Course course,Student student){
        studentsPerCourses.put(course,student);
    }
    
    public void setStudentsPerCourses(Map<Course,Student> coursesStudents)
    {
        studentsPerCourses=coursesStudents;
    }
    
    public Map<Course,Student> getStudentsPerCourses(){
        
        return studentsPerCourses;
    }
    
    
    public List<Student> getStudentsByCourse(Course course)
    {
        List<Student> students=new ArrayList<Student>();
        
        for (Map.Entry<Course,Student> entry : studentsPerCourses.entrySet()) 
        {
			// Check if value matches with given value
	     if (entry.getKey().equals(course))
                 students.add(entry.getValue());
			
        }
        
        return students;
    }
    
    /*public List<Student> getStudentPerCourse(){
          return students;
    }*/
    
    /*public Student getStudent(){
        return student;
    }
    
    public Course getCourse(){
        return course;
    }*/
}
