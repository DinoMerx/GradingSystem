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
        
        try {
            Connection connection = DriverManager.getConnection(databaseURL);  
            Statement st = connection.createStatement();
            
            String sql = "SELECT * From A66OJT";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String firstname = rs.getString("FirstName");
                String WW1 = rs.getString("WW1");
                String PT1 = rs.getString("PT1");
                String TEST1 = rs.getString("TEST1");
                System.out.println(WW1);
                System.out.println(PT1);
                System.out.println(TEST1);
                
                int TOTAL = Integer.parseInt(WW1)+Integer.parseInt(PT1)+Integer.parseInt(TEST1);
                
                System.out.println(TOTAL);
                st.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
            }
           
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
 
