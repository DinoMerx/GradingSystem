/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author DinoMerx
 */
public class Database {

    public void db(){
        String databaseURL = "jdbc:ucanaccess://src/resources/GradingSystem.accdb";
        
        Connection con = null;
        Statement st = null;
        
        try {
            
            con = DriverManager.getConnection(databaseURL);
            st = con.createStatement();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        
    }
}
 
