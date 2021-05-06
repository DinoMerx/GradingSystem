/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author DinoMerx
 */
public class GradingSystem {

    /**
     * @param args the command line arguments
     */
    
    
    public static void gui(){
        JPanel exit = new JPanel();
        JPanel minimize = new JPanel();
    
        JFrame f = new JFrame();
        
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        exit.setBackground(Color.red);
        
        f.add(exit);
        
    }
    
    public static void main(String[] args) {
        UserInterface UIObject = new UserInterface();
        UIObject.UIEditGradeComponent();
        //gui();
        
    }
}
