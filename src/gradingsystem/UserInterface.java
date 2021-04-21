/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
/**
 *
 * @author DinoMerx
 */

public class UserInterface {
    String databaseURL = "jdbc:ucanaccess://src/resources/GradingSystem.accdb";
    Database dbObject = new Database();
    Connection con = null;
    PreparedStatement st = null;
    String driverName = "com.mysql.jdbc.Driver";
    
    // JFrames
    final JFrame gs = new JFrame("Grading System");
    final JFrame as1 = new JFrame("Add Section");
    final JFrame as2 = new JFrame("Add Students");
    final JFrame as3 = new JFrame("Add Students");
    final JFrame ast = new JFrame("Add Student");
    final JFrame ag = new JFrame("Add Grade");
    final JFrame egc = new JFrame("Edit Grade Component");
    final JFrame esg = new JFrame("Edit Student Grade");
    
    
    
    //Menu Inputs
    JButton bm1 = new JButton("Edit Section");
    JButton bm2 = new JButton("Add Section");
        
    JComboBox sectionList = new JComboBox();
    
    //Add Section Inputs
    JTextField asec = new JTextField(4);
    
    JButton bas1 = new JButton("Next");
    JButton bas2 = new JButton("Cancel");
    
    //GradingSystem Inputs
    JLabel gslb1 = new JLabel("Grading System");
    
    JButton bgs1 = new JButton("Add Student");
    JButton bgs2 = new JButton("Add Grade");
    JButton bgs3 = new JButton("Edit Grade Component");
    JButton bgs4 = new JButton("Edit Student Grade");
    JButton bgs5 = new JButton("Back");
    
    //Add Grade
    JButton submit = new JButton("Submit");
    JTextField textfield1 = new JTextField("enter your input here.");
    JButton cancel = new JButton("Cancel");
    //Add Student
    JTextField enterNameTF = new JTextField(); 
    JButton ASTSubmit = new JButton("Submit");
    JButton ASTBack = new JButton("Back");
    JLabel gslb2 = new JLabel();
    
    //Edit Grade Component
    JComboBox tableList = new JComboBox();
    String selectedSection;  
    JLabel enterName = new JLabel("Full Name (Temporary)");  

    JFrame f;
    // UIMenu, aka the main screen
        public void UIMenu(){
            
            f = new JFrame("Grading System");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            
            JLabel mlb1 = new JLabel("Grading System");
            
            mlb1.setBounds(95,30,110,20);
            
            bm1.setBounds(20,80,110,20);
            bm2.setBounds(150,80,110,20);
            
            bm1.addActionListener(new UIGradingSystem());
            bm2.addActionListener(new UIAddSection());
            
            sectionList.setBounds(85,50,110,20);
            
            f.add(mlb1);
            f.add(bm1);
            f.add(bm2);

            f.add(sectionList);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setSize(300,200);
            
            gs.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.remove(mlb1);
                f.remove(bm1);
                f.remove(bm2);
                f.remove(sectionList);

                f.removeWindowListener(this);
            }
            
        });
            
        }
        //Second screen when you click edit section
        public void UIGradingSystem(){
            selectedSection = (String)sectionList.getSelectedItem();
            System.out.println("you selected: " + selectedSection);
            JLabel gslb2 = new JLabel("Section : " + selectedSection);
            gslb1.setBounds(95,30,110,20);
            gslb2.setBounds(105,50,110,20);
            
            bgs1.setBounds(60,80,160,20);
            bgs2.setBounds(60,110,160,20);
            bgs3.setBounds(60,140,160,20);
            bgs4.setBounds(60,170,160,20);
            bgs5.setBounds(60,200,160,20);
            
            bgs1.addActionListener(new UIAddStudent());
            bgs2.addActionListener(new UIAddGrade());
            bgs3.addActionListener(new UIEditGradeComponent());
            bgs4.addActionListener(new UIEditStudentGrade());
            bgs5.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                f.setVisible(true); 
                gs.remove(gslb2);
                gs.remove(gslb1);
                gs.remove(bgs1);
                gs.remove(bgs2);
                gs.remove(bgs3);
                gs.remove(bgs4);
                gs.remove(bgs5);
                gs.dispose();
                }
            });
            gs.setLocationRelativeTo(null);   
            gs.add(gslb1);
            gs.add(gslb2);
            gs.add(bgs1);
            gs.add(bgs2);
            gs.add(bgs3);
            gs.add(bgs4);
            gs.add(bgs5);
            
            gs.setLayout(null);
            gs.setVisible(true);
            gs.setSize(300,300);
            
            gs.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gs.remove(gslb1);
                gs.remove(gslb2);
                gs.remove(bgs1);
                gs.remove(bgs2);
                gs.remove(bgs3);
                gs.remove(bgs4);
                gs.remove(bgs5);
                gs.removeWindowListener(this);
            }
        });
            
        }
        
        public void UIAddSection(){
            JLabel lblas = new JLabel("Add Section");
            JLabel lblsec = new JLabel("Section:");
            
            lblas.setBounds(100,30,110,20);
            lblsec.setBounds(35,60,110,20);
            
            asec.setBounds(95,60,110,20);
            
            bas1.setBounds(50,120,80,20);
            bas2.setBounds(150,120,80,20);
            
            bas1.addActionListener(new section());
            bas1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                bas1.removeActionListener(this);
                asec.removeActionListener(this);
                
                f.setVisible(true); 
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas2);
                as1.remove(asec);
                as1.dispose();
                }
            });
            bas2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                f.setVisible(true); 
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas1);
                as1.remove(bas2);
                as1.remove(asec);
                as1.dispose();
                }
            });
            
            as1.setLocationRelativeTo(null);
            as1.add(asec);
            as1.add(lblas);
            as1.add(lblsec);
            as1.add(bas1);
            as1.add(bas2);
            
            as1.setLayout(null);
            as1.setVisible(true);
            as1.setSize(300,200);
            
            as1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas1);
                as1.remove(bas2);
                as1.remove(asec);
                as1.removeWindowListener(this);
            }
        });
        }
        
        public class section implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            sectionList.addItem(asec.getText());
        }
    }
        
        public void UIAddStudent()
        {
            
                    
            ASTBack.setBounds(150,100,100,30);
            ASTSubmit.setBounds(25,100,100,30);
            enterName.setBounds(25,20,200,30);
            enterNameTF.setBounds(25,60,235,30);
            
            ASTSubmit.addActionListener(new AddStudentSubmit() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                    String name = enterNameTF.getText();
                    Connection ASTCon = DriverManager.getConnection(databaseURL);
                    Statement astST = ASTCon.createStatement();
                    System.out.println(selectedSection);
                    String astSQL2 = "INSERT INTO " + selectedSection + " (Full_Name) VALUES (?)";
                    PreparedStatement astPS = ASTCon.prepareStatement(astSQL2);
                    astPS.setString(1,name);
                    astPS.executeUpdate();
                    
                        
                        
                    // database code here
                    System.out.println("Submitted");
                    ast.remove(ASTBack);
                    ast.remove(ASTSubmit);
                    ast.remove(enterName);
                    ast.remove(enterNameTF);
                    ASTSubmit.removeActionListener(this);
                    ast.dispose();
                    }
                    catch(Exception z)
                    {
                        z.printStackTrace();
                    }

                }
            });
            
            ast.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ast.remove(enterName);
                     ast.remove(enterNameTF);
                     ast.remove(ASTSubmit);
                     ast.remove(ASTBack);   
                as3.removeWindowListener(this);
            }
        });
            
            ast.add(enterName);
            ast.add(enterNameTF);
            ast.add(ASTSubmit);
            ast.add(ASTBack);
           
            ast.setLocationRelativeTo(null);
            ast.setLayout(null);
            ast.setVisible(true);
            ast.setSize(300,200);
        }
        
        public void UIAddGrade(){
            
            JLabel text1 = new JLabel("Input Component:");
            
            textfield1.setBounds(150,10,120,20);
            text1.setBounds(20,10,110,20);
            submit.setBounds(60,40,80,20);
            cancel.setBounds(150,40,80,20);
            
            submit.addActionListener(new Submit());
            cancel.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                gs.setVisible(true);
                ag.setVisible(false);
                }
            });

            ag.setLayout(null);
            ag.setSize(300,120);
            ag.add(text1);
            ag.add(textfield1);
            ag.add(submit);
            ag.add(cancel);
            ag.setLocationRelativeTo(null);
            ag.setVisible(true);
            
            ag.addWindowListener(new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent e) 
                {
                System.out.println("WindowClosingDemo.windowClosing");
                ag.remove(text1);
                ag.remove(textfield1);
                ag.remove(submit);
                ag.remove(cancel);
                ag.removeWindowListener(this);
                
                }
            });
            
        }
        
        public void UIEditGradeComponent(){
            
            
            
            egc.add(tableList);
            tableList.setBounds(20,10,110,20);
            
            egc.setLayout(null);
            egc.setVisible(true);
            egc.setSize(800,720);
            egc.setLocationRelativeTo(null);
        }
        
        public void UIEditStudentGrade(){
            esg.setLocationRelativeTo(null);
            esg.setLayout(null);
            esg.setVisible(true);
            esg.setSize(300,200);
        }
        
        public class Submit implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e) {
                submit = (JButton)e.getSource();
                /*
                try {
            
                con = DriverManager.getConnection(databaseURL);
                st = con.createStatement();
                st.execute(tbl);
                System.out.println("Table Created");
                */
                String columnName = textfield1.getText();
                try
                {
                    //ResultSet resultSubmit = st.executeQuery(sql);
                    con = DriverManager.getConnection(databaseURL);
                    Statement submitST = con.createStatement();
                    System.out.println("Submitted");  
                    String submitsql = "ALTER TABLE test" 
                                      +" ADD " + columnName + " integer";
                    submitST.execute(submitsql);
                    
                } catch (SQLException E) 
                {
                    E.printStackTrace();
                }
                
            }   
        }
        
        public class UIMenu implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs5 = (JButton)e.getSource();
                
                gs.remove(bgs1);
                gs.remove(bgs2);
                gs.remove(bgs3);
                gs.remove(bgs4);
                gs.remove(bgs5);
                UIMenu();
            }
        }
        
        public class AddStudentSubmit implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ASTSubmit = (JButton)e.getSource();
                
                ast.remove(ASTBack);
                ast.remove(ASTSubmit);
                ast.remove(enterName);
                ast.remove(enterNameTF);
            }
        }
        
        public class UIGradingSystem implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) 
            {
                f.setVisible(false);
                bm1 = (JButton)e.getSource();
                UIGradingSystem();
                ag.setVisible(false);
                
                /*try
                {
                    ResultSet rs;
                  con = DriverManager.getConnection(databaseURL);
                  Statement submitST = con.createStatement();
                  rs = submitST.executeQuery("select * from " + selectedSection);
                  
                  ResultSetMetaData metaData = rs.getMetaData();
                  int columnCount = metaData.getColumnCount();
                  
                  while(rs.next())
                  {
                  for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                  }
                    System.out.printf("%n");
   
                  }
                                    
                } catch (SQLException g)
                {
                 g.printStackTrace();
                }
                */
            }
        }
        
        public class UIAddSection implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                bm2 = (JButton)e.getSource();
                UIAddSection();
            }
        }
        
        public class UIAddStudent implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs1 = (JButton)e.getSource();
                bgs1.removeActionListener(new UIAddStudent());
                UIAddStudent();
            }
        }
        
        public class UIAddGrade implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs2 = (JButton)e.getSource();
            
                UIAddGrade();
            }
        }
        
        public class UIEditGradeComponent implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs3 = (JButton)e.getSource();
                UIEditGradeComponent();
            }
        }
        
        public class UIEditStudentGrade implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs4 = (JButton)e.getSource();
                UIEditStudentGrade();
            }
        }
}
