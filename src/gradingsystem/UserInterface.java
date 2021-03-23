/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author DinoMerx
 */

public class UserInterface {
    
    final JFrame gs = new JFrame("Grading System");
    final JFrame as = new JFrame("Add Section");
    final JFrame ast = new JFrame("Add Student");
    final JFrame ag = new JFrame("Add Grade");
    final JFrame egc = new JFrame("Edit Grade Component");
    final JFrame esg = new JFrame("Edit Student Grade");
    
    //Menu Inputs
    JButton bm1 = new JButton("Edit Section");
    JButton bm2 = new JButton("Add Section");
    JButton bm3 = new JButton("Grade Percentage");
    
    JComboBox section = new JComboBox();
    
    //GradingSystem Inputs
    JButton bgs1 = new JButton("Add Student");
    JButton bgs2 = new JButton("Add Grade");
    JButton bgs3 = new JButton("Edit Grade Component");
    JButton bgs4 = new JButton("Edit Student Grade");
    
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
            bm3.setBounds(70,110,140,20);
            
            bm1.addActionListener(new UIGradingSystem());
            bm2.addActionListener(new UIAddSection());
            bm3.addActionListener(new UISliders());
            

            section.setBounds(85,50,110,20);
            
            f.add(mlb1);
            f.add(bm1);
            f.add(bm2);
            f.add(bm3);
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
            
            bgs1.addActionListener(new UIAddStudent());
            bgs2.addActionListener(new UIAddGrade());
            bgs3.addActionListener(new UIEditGradeComponent());
            bgs4.addActionListener(new UIEditStudentGrade());
            
            
            gs.add(gslb1);
            gs.add(gslb2);
            gs.add(bgs1);
            gs.add(bgs2);
            gs.add(bgs3);
            gs.add(bgs4);
            
            gs.setLayout(null);
            gs.setVisible(true);
            gs.setSize(300,300);
            
            gs.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                gs.remove(gslb1);
                gs.remove(gslb2);
                gs.remove(bgs1);
                gs.remove(bgs2);
                gs.remove(bgs3);
                gs.remove(bgs4);
                gs.removeWindowListener(this);
            }
        });
            
        }
        
        public void UIAddSection(){
            as.setLayout(null);
            as.setVisible(true);
            as.setSize(300,200);
        }
        
        public void UIAddStudent(){
            ast.setLayout(null);
            ast.setVisible(true);
            ast.setSize(300,200);
        }
        
        public void UIAddGrade(){
            ag.setLayout(null);
            ag.setVisible(true);
            ag.setSize(300,200);
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
        public class UIGradingSystem implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bm1 = (JButton)e.getSource();
                UIGradingSystem();
            }
        }
        
        public class UIAddSection implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bm2 = (JButton)e.getSource();
                UIAddSection();
            }
        }
        
        public class UISliders implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                ConnectedSliders CSObject = new ConnectedSliders();
                bm3 = (JButton)e.getSource();
                SwingUtilities.invokeLater(new Runnable()
        {
                @Override
                    public void run()
                    {
                        CSObject.createAndShowGUI();
                    }
                });
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
