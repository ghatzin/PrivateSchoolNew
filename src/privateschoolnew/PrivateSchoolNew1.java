/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschoolnew;

import entities.*;
import DAO.*;
import java.util.*;

public class PrivateSchoolNew1 {


    public static void main(String[] args) {
   
        /*Scanner inputScanner=new Scanner(System.in);        
        System.out.println("Give your uer name:");
        String userName=inputScanner.next();
        System.out.println("Give your password:");
        String password=inputScanner.next();
        System.out.println("Give your role:");
        String role=inputScanner.next();
        Login userLogin=new Login(userName,password,role);
        userLogin.checkUserCredentials();
        
        if (userLogin.hasSuccessfullLogin())
            System.out.println("You have sucesfull login");
        else
            System.out.println("Invalid credentials");*/
         
       // UserDAO userDAO=new UserDAO();
       // userDAO.insertUser("8","vvasileiadis","vyron34","trsiner","VV001");
       
       StudentsPerCourseDAO studentsPerCourseDAO=new StudentsPerCourseDAO();
       StudentsPerCourse studentsPerCourse=new StudentsPerCourse();
       studentsPerCourse=studentsPerCourseDAO.getStudentsPerCourse("JAVABC7FT");
       
       System.out.println(studentsPerCourse.getCourse());
       
       for (Student student:studentsPerCourse.getStudents())
            System.out.println(student);
       
       
       StudentDAO studentDAO=new StudentDAO();
       //studentDAO.insertStudent("NIKVASV","VASVETAKIS","NIKOS","1974-11-05",2.500);
       studentsPerCourseDAO.deleteStudentFromCourse("NIKVASV");
       
       
       
        
        
        
        
    }
    
}