package gradingsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Lumtao
 */
import java.sql.*;
import javax.swing.JOptionPane;




public class NewClass {
    
    public static Connection connect()
            {
                Connection con=null;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GradingSystem?","root","janjan632");
                    JOptionPane.showMessageDialog(null, "connection success");
                    
                } catch (Exception e)
                {
                    System.out.println("inter.NewClass.connect()");
                }
                return con;
            }
    
}
