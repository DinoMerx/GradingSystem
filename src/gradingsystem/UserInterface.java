/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DinoMerx
 */

public class UserInterface {
    JButton bm1 = new JButton("Edit Section");
    JButton bm2 = new JButton("Add Section");
    
    JComboBox section = new JComboBox();
    
    JFrame f; 
        public void Menu(){
            f = new JFrame("Grading System");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            
            JLabel mlb1 = new JLabel("Grading System");
            
            mlb1.setBounds(95,30,110,20);
            
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
}
