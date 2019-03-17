/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public abstract class DAOConnection {
    
    protected String URL;
    protected String USERNAME;
    protected String PASSWORD;
    protected  Connection connection;
    
    
    public void setConnection()
    {
        URL = "jdbc:mysql://localhost:3306/privateschool?serverTimezone=UTC";
        USERNAME = "root";
        PASSWORD = "password";
        connection=null;
    }
    
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //System.out.println("Connection successfully established.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public  void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
