/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnectionHandler {
    
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static Connection connection;
    
    
    public static void setConnection(String connURL,String connUSERNAME,String connPass)
    {
        URL=connURL;
        USERNAME=connUSERNAME;
        PASSWORD=connPass;
        
    }
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection successfully established.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
