/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author DinoMerx
 */

public class UserInterface {
    String databaseURL = "jdbc:ucanaccess://src/resources/GradingSystem.accdb";
    Database dbObject = new Database();
    Connection con = null;
    java.sql.Statement st = null;
    
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
    
    JComboBox section = new JComboBox();
    
    //Add Section Inputs
    //1
    JTextField asec = new JTextField(4);
    JTextField asub = new JTextField(4);
    
    JButton bas1 = new JButton("Next");
    JButton bas2 = new JButton("Cancle");
    
    //2
    JButton bas11 = new JButton("Next");
    JButton bas12 = new JButton("Cancle");
    
    JTextField assn = new JTextField(3);
    
    //3
    JButton bas21 = new JButton("Next");
    JButton bas22 = new JButton("Cancle");
    
    JTextField asid = new JTextField(10);
    JTextField asfn = new JTextField(32);
    
    //GradingSystem Inputs
    JButton bgs1 = new JButton("Add Student");
    JButton bgs2 = new JButton("Add Grade");
    JButton bgs3 = new JButton("Edit Grade Component");
    JButton bgs4 = new JButton("Edit Student Grade");
    JButton bgs5 = new JButton("Back");
    
    
    String sd = "A66"; 
    
    JFrame f;
    
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
           
            section.setBounds(85,50,110,20);
            
            f.add(mlb1);
            f.add(bm1);
            f.add(bm2);

            f.add(section);
            
            f.setVisible(true);
            f.setSize(300,200);
        }
        
        public void UIGradingSystem(){
            JLabel gslb1 = new JLabel("Grading System");
            JLabel gslb2 = new JLabel("Section : " + sd);
            
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
                }
            });
                
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
        
        public void UIAddSection1(){
            JLabel lblas = new JLabel("Add Section");
            JLabel lblsec = new JLabel("Section:");
            JLabel lblsub = new JLabel("Subject:");
            
            lblas.setBounds(95,30,110,20);
            lblsec.setBounds(35,60,110,20);
            lblsub.setBounds(35,90,110,20);
            
            asec.setBounds(95,60,110,20);
            asub.setBounds(95,90,110,20);
            
            bas1.setBounds(50,120,80,20);
            bas2.setBounds(150,120,80,20);
            
            bas1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String tbl = "CREATE TABLE asecasub("
                    + "StudentID INT NOT NULL,"
                    + "FullName(45) NOT NULL,"
                    + "PRIMARY KEY (StudentID))";
                
            try {
            
                con = DriverManager.getConnection(databaseURL);
                st = con.createStatement();
                st.execute(tbl);
                System.out.println("Table Created");
                
            } catch (SQLException t) {
            
                t.printStackTrace();
            
            }
                
                as1.dispose();
            } 
            });
            
            as1.add(asec);
            as1.add(asub);
            as1.add(lblas);
            as1.add(lblsec);
            as1.add(lblsub);
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
                as1.remove(lblsub);
                as1.remove(bas1);
                as1.remove(bas2);
                as1.remove(asec);
                as1.remove(asub);
                as1.removeWindowListener(this);
            }
        });
            
        }
        
        public void UIAddSection2(){
            JLabel lblas2 = new JLabel("Add Students");
            JLabel lbldes1 = new JLabel("Enter Number of Students");
            
            lblas2.setBounds(100,30,110,20);
            lbldes1.setBounds(65,45,200,20);
            
            bas11.setBounds(50,100,80,20);
            bas12.setBounds(150,100,80,20);
            bas11.addActionListener(new UIAddSection2());
            
            assn.setBounds(100,70,80,20);
            
            as2.add(lblas2);
            as2.add(lbldes1);
            as2.add(assn);
            as2.add(bas11);
            as2.add(bas12);
            
            as2.setLayout(null);
            as2.setVisible(true);
            as2.setSize(300,200);
            
            as2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                as2.remove(lblas2);
                as2.remove(lbldes1);
                as2.remove(assn);
                as2.remove(bas11);
                as2.remove(bas12);
                as2.removeWindowListener(this);
            }
        });
        }
        
        public void UIAddSection3(){
            JLabel lblas3 = new JLabel("Add Students");
            JLabel lbldes2 = new JLabel("Enter Student Information");
            JLabel lblid = new JLabel("StudentID:");
            JLabel lblfn = new JLabel("Full Name:");
            
            lblid.setBounds(35,60,110,20);
            lblfn.setBounds(35,90,110,20);
            lblas3.setBounds(100,20,110,20);
            lbldes2.setBounds(65,35,200,20);
            
            bas21.setBounds(50,120,80,20);
            bas22.setBounds(150,120,80,20);
            
            asid.setBounds(95,60,150,20);
            asfn.setBounds(95,90,150,20);
            
            as3.add(lblid);
            as3.add(lblfn);
            as3.add(asid);
            as3.add(asfn);
            as3.add(bas21);
            as3.add(bas22);
            as3.add(lblas3);
            as3.add(lbldes2);
                        
            as3.setLayout(null);
            as3.setVisible(true);
            as3.setSize(300,200);
            as2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                as3.remove(lblas3);
                as3.remove(lbldes2);
                as3.remove(assn);
                as3.remove(bas11);
                as3.remove(bas12);
                as3.removeWindowListener(this);
            }
        });
        }
        
        public void UIAddStudent(){
            ast.setLayout(null);
            ast.setVisible(true);
            ast.setSize(300,200);
        }
        
        public void UIAddGrade(){
            ag.setLocationRelativeTo(null);
            ag.setLayout(null);
            ag.setVisible(true);
            
            JLabel text1 = new JLabel("Input Component:");
            JTextField textfield1 = new JTextField("enter your text here.");
            JButton submit = new JButton("Submit");
            JButton cancel = new JButton("Cancel");
            
            textfield1.setBounds(150,10,120,20);
            text1.setBounds(20,10,110,20);
            submit.setBounds(60,40,80,20);
            cancel.setBounds(150,40,80,20);
                    
            ag.setLayout(null);
            ag.setSize(300,120);
            ag.add(text1);
            ag.add(textfield1);
            ag.add(submit);
            ag.add(cancel);
            
            ag.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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
            egc.setLayout(null);
            egc.setVisible(true);
            egc.setSize(300,200);
        }
        
        public void UIEditStudentGrade(){
            esg.setLayout(null);
            esg.setVisible(true);
            esg.setSize(300,200);
        }
        
        public class UIMenu implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs5 = (JButton)e.getSource();
                f.setVisible(true);
                gs.setVisible(false);
                UIMenu();
            }
        }
        
        public class UIGradingSystem implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                bm1 = (JButton)e.getSource();
                UIGradingSystem();
            }
        }
        
        public class UIAddSection implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                bm2 = (JButton)e.getSource();
                UIAddSection1();
            }
        }
        
        public class UIAddSection1 implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bas1 = (JButton)e.getSource();
                UIAddSection2();
            }
        }
        
        public class UIAddSection2 implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bas11 = (JButton)e.getSource();
                UIAddSection3();
            }
        }
        
        public class UIAddSection3 implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bas21 = (JButton)e.getSource();
                UIAddSection3();
            }
        }
        
        public class UIAddStudent implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs1 = (JButton)e.getSource();
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
