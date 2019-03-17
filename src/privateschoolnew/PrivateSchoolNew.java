/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

/**
 *
 * @author George
 */
import java.util.*;
import entities.*;
import DAO.*;


public class PrivateSchoolNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Student> students=new ArrayList<Student>();
        List<Course> courses=new ArrayList<Course>();
        List<Trainer> trainers=new ArrayList<Trainer>();
        List<Assignment> assignments=new ArrayList<Assignment>();
        Map<Course,Student> studentsPerCourses=new HashMap<Course,Student>();
        StudentPerCourse1 studentPerCourse=new StudentPerCourse1();
        
        StudentDAO studentDAO=new StudentDAO();
        students=studentDAO.getListOfStudents();
        CourseDAO courseDAO=new CourseDAO();
        courses=courseDAO.getListOfCourses();
        TrainerDAO trainerDAO=new TrainerDAO();
        trainers=trainerDAO.getListOfTrainers();
        AssignmentDAO assignmentDAO=new AssignmentDAO();
        assignments=assignmentDAO.getListOfAssignments();
        StudentCourseDAO studentCourseDAO=new StudentCourseDAO();
        //studentPerCourse.setStudentsPerCourses(studentCourseDAO.getStudentsPerCourses());
        
        
        printStudents(students);
        printCourses(courses);
        printTrainers(trainers);
        printAssignments(assignments);
        //printStudentsPerCourses(studentPerCourse.getStudentsPerCourses());
        
        
        //studentCourseDAO.deleteStudentFromCourse("VasvNik");
        //printStudentsPerCourses(studentCourseDAO.getStudentsPerCourses());
        
        //Course course=studentCourseDAO.getCourseByStudentId("EPAKOU");
        //System.out.println(course);
        //studentsPerCourses.remove(course);
        //printStudentsPerCourses(studentsPerCourses);
        //studentCourseDAO.deleteStudentFromCourse("EPAKOY");
        //printStudentsPerCourses(studentCourseDAO.getStudentsPerCourse());
        
        //studentCourseDAO.deleteStudentFromCourse("EPAKOU");
        
        //studentCourseDAO.addStudentToCourse("JAVABC7PT","EPAKOU");
        
        
        //Course course=courseDAO.getCoursetById("JAVABC7FT");
        
        //students=studentPerCourse.getStudentsByCourse(course);
        
        //printStudents(students);
        
        
        //assignmentDAO.deleteAssignmentById("ass1");
         //trainerDAO.deleteTrainerById("AL005");
         
         //assignmentDAO.insertAssignment("ass1","Assignment 1","Initial Implementation of a private school","2019-02-18",0.20,0.80);
         //trainerDAO.insertTrainer("AL005","Loulakis","Anastasios");
         
         //assignmentDAO.updateAssignmentById("ass2","Assignment 2","Initial Database Design of a private school","2019-03-05",0.10,0.90);
         
         //trainerDAO.updateTrainerById("AL005","Lelakis","Anastasios");
         
         //printAssignments(assignments);
         
         UserDAO userDAO=new UserDAO();
         User user=userDAO.getUser("ghatzin","gha350aca");
         System.out.println(user.getuserName());
         System.out.println(user.getPassword());
         Student student=null;
         Trainer trainer=null;
         User user1=userDAO.getUser("ghatzin","gha350aca");
         Student stud=null;
        
         //if (user1 instanceof Student)
               //(user1);
               
        
         
        
         
         //if (user.getRoleId()==1)
             //student=userDAO.getStudent("ghatzin","gha350aca");
         //else if (user.getRoleId()==2)
              //trainer=userDAO.getTrainer("", password)
         
         //System.out.println(student);
    
    }
    
    
    public static void printStudents(List<Student> students){
        for (Student student:students)
            System.out.println(student);
        
    }
    
     public static void printCourses(List<Course> courses){
         for (Course course:courses)
            System.out.println(course);
        
    }
     
    public static void printTrainers(List<Trainer> trainers){
        for (Trainer trainer:trainers)
            System.out.println(trainer);
        
    }
    
     public static void printAssignments(List<Assignment> assignments){
        for (Assignment assignment:assignments)
            System.out.println(assignment);
        
    }
     
     public static void printStudentsPerCourses(Map<Course,Student> map){
        
        for (Map.Entry<Course,Student> entry : map.entrySet()) {
		    System.out.println(entry.getKey().toString() + " = " + entry.getValue().toString());
        }
     }
}
