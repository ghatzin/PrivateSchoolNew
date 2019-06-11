/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import entities.*;
import DAO.*;
import java.util.*;

public class PrivateSchoolNew {


    public static void main(String[] args) {
   
        Scanner inputScanner=new Scanner(System.in);        
        System.out.println("Give your uer name:");
        String userName=inputScanner.next();
        System.out.println("Give your password:");
        String password=inputScanner.next();
        System.out.println("Give your role:");
        String role=inputScanner.next();
        Login userLogin=new Login(userName,password,role);
        userLogin.checkUserCredentials();
        
        if (userLogin.hasSuccessfullLogin())
        {
            System.out.println("You have sucesfull login");
        }
        else
        {
            System.out.println("Invalid credentials");
        }
        
        User user=userLogin.getUser();
        System.out.println(user);
        UserDAO userDAO=new UserDAO();
        userDAO.deleteUser("4","trainer");
        userDAO.updateUserNamePassword("3","epakou","epakou35","student");
        userDAO.insertUser("7","xgionela","xgionella34","student","XGION102");
        userDAO.updateUserRole("3","student");
        
        
        
        
        user=userDAO.getUser("ghatzin","gha350aca","student");
        System.out.println(user);
        
        userDAO.insertUser("8","vvasileiadis","vyron34","trainer","VV001");
       
        StudentPerCourseDAO studentPerCourseDAO=new StudentPerCourseDAO();
        StudentsPerCourse studentsPerCourse=new StudentsPerCourse();
        studentsPerCourse=studentPerCourseDAO.getStudentsPerCourse("JAVABC7FT");
       
        System.out.println(studentsPerCourse.getCourse());
       
        for (Student student:studentsPerCourse.getStudents())
            System.out.println(student);
       
       
       StudentDAO studentDAO=new StudentDAO();
       studentDAO.insertStudent("NIKVASV","VASVETAKIS","NIKOS","1974-11-05",2.500);
       studentPerCourseDAO.deleteStudentFromCourse("JAVABC7FT","NIKVASV");
       
       
       
       
       CourseScheduleDAO courseScheduleDAO=new CourseScheduleDAO(); 
       
       courseScheduleDAO.insertCourseSchedule("2019-03-05","Fundamentals of OO programming","OO Programming","JAVABC7FT");
       courseScheduleDAO.updateCourseSchedule("2019-03-05","Fundamentals of Object Oriented Programming","OO Programming","JAVABC7FT");
       List<CourseSchedule> courseSchedule=new ArrayList<CourseSchedule>();
       courseSchedule=courseScheduleDAO.getCourseScheduleById("JAVABC7FT");
               
               
       courseScheduleDAO.deleteCourseSchedule("JAVABC7FT");
        
        
        
    }
    
}
