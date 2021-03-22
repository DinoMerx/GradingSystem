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
    
    //Menu Inputs
    JButton bm1 = new JButton("Edit Section");
    JButton bm2 = new JButton("Add Section");
    
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
            
            bm1.addActionListener(new UIGradingSystem());
            bm1.setBounds(20,80,110,20);
            bm2.setBounds(150,80,110,20);
            
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
            
            gs.add(gslb1);
            gs.add(gslb2);
            gs.add(bgs1);
            gs.add(bgs2);
            gs.add(bgs3);
            gs.add(bgs4);
            
            gs.setVisible(true);
            gs.setSize(300,300);
            
            gs.setLayout(null);
        }
        public class UIGradingSystem implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bm1 = (JButton)e.getSource();
                UIGradingSystem();
    }
        }
}
