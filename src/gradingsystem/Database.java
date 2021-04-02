/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DinoMerx
 */
public class Database {
    public void db(){
    String databaseURL = "jdbc:ucanaccess://src/resources/GradingSystem.accdb";
        
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            
            System.out.println("Connected to MS Access database.");
            
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
