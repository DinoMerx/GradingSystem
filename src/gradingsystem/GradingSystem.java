/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;

import javax.swing.*;

/**
 *
 * @author DinoMerx
 */
public class GradingSystem {

    /**
     * @param args the command line arguments
     */
    JFrame f; 
        public void Menu(){
            f = new JFrame("Grading System");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            
            f.setVisible(true);
            f.setSize(300,200);
        }
    public static void main(String[] args) {
        System.out.println("Hello John");
        GradingSystem event = new  GradingSystem();
        event.Menu();
    }
    
}
