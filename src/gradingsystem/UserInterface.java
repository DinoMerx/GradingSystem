/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.sql.*;
import javax.swing.border.*;
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
    JTextField asec = new JTextField("enter input");
    
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
    
    JPanel exit = new JPanel();
    JPanel minimize = new JPanel();
    JPanel title = new JPanel();
    
    private Point currentLocation;
    
        public void UIMenu(){
            f = new JFrame("Grading System");
            
            title.setBackground(Color.RED);
            title.setBounds(0,0,350,30);
            JLabel tb = new JLabel("GRADING SYSTEM");
            tb.setBounds(20,20,110,20);
            title.add(tb);
            
            exit.setBackground(Color.RED);
            exit.setBounds(320,0,30,30);
            JLabel x = new JLabel("X");
            x.setBounds(20,20,110,20);
            exit.add(x);
            
            minimize.setBackground(Color.RED);
            minimize.setBounds(290,0,30,30);
            JLabel m = new JLabel("−");
            m.setBounds(20,20,110,20);
            minimize.add(m);
            
            JPanel pbm1 = new RoundedPanel(30, Color.WHITE);
            pbm1.setBounds(20,100,150,150);
            pbm1.setLayout(null);
            bm1.setBounds(20,100,110,20);
            bm1.addActionListener(new UIGradingSystem());
            JLabel bm1lbl = new JLabel("<html><div style='text-align: center;'>This is where you Edit and View Section</div><html>");
            bm1lbl.setBounds(20,20,110,50);
            pbm1.add(bm1);
            pbm1.add(bm1lbl);
            
            JPanel pbm2 = new RoundedPanel(30, Color.WHITE);
            pbm2.setBounds(180,100,150,150);
            pbm2.setLayout(null);
            bm2.setBounds(20,100,110,20);
            bm2.addActionListener(new UIAddSection());
            JLabel bm2lbl = new JLabel("<html><div style='text-align: center;'>This is where you Add Section</div><html>");
            bm2lbl.setBounds(20,20,110,50);
            pbm2.add(bm2lbl);
            pbm2.add(bm2);
            
            JLabel mlbl = new JLabel("Grading System");
            
            mlbl.setBounds(120,40,110,20);
            sectionList.setBounds(110,60,110,20);
            
            f.add(mlbl);
            f.add(sectionList);
            
            f.add(pbm1);
            f.add(pbm2);
            f.add(exit);
            f.add(minimize);
            f.add(title);
            
            f.setUndecorated(true);
            f.setLayout(null);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setSize(350,350);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            exit.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    System.exit(0);
                }
            });
            
            minimize.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    f.setState(Frame.ICONIFIED);
                }
            });
            
            title.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentLocation = e.getPoint();
            }
             });
            
            title.addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Point currentScreenLocation = e.getLocationOnScreen();
                    f.setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y);
                }
            });
            
            gs.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.remove(mlbl);
                f.remove(bm1);
                f.remove(bm2);
                f.remove(sectionList);
                
                f.removeWindowListener(this);
            }
            
        });
        }
        
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
                
                try
                {
                    Connection ASTCon = DriverManager.getConnection(databaseURL);
                    Statement astST = ASTCon.createStatement();
                    String asSQL = "CREATE TABLE PLACEHOLDER " +
                                   "(id INTEGER not NULL, "
                                 + "PRIMARY KEY ( id ))";
                   String asSQL2 ="ALTER TABLE PLACEHOLDER" +
                                   " RENAME TO " + asec.getText();
                   astST.execute(asSQL);
                   astST.execute(asSQL2);
                   
                }
                catch(Exception p)
                {
                    p.printStackTrace();
                }
                
                
                f.setVisible(true); 
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas2);
                
                //.removeActionListener(this);
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
                    //String astSQL2 = "ALTER TABLE A01"
                            //+ " RENAME TO " + name; 
                    String astSQL2 = "INSERT INTO " + selectedSection + " (Full_Name) VALUES (?)";
                    PreparedStatement astPS = ASTCon.prepareStatement(astSQL2);
                   astPS.setString(1,name);
                         
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
                ag.remove(textfield1);
                ag.remove(submit);
                ag.remove(cancel);
                ag.remove(text1);
                cancel.removeActionListener(this);
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
            String[] columnNames = {"StudentID", "LastName", "FirstName", "Middle Name"};
            
            String[][] data = {
                {"2019105311", "GARCIA", "DIGGO KID ANDRES", "PALISOC"}
            };
            
            JTable egctable = new JTable(data, columnNames);
            
            JScrollPane egcsp = new JScrollPane(egctable);
            
            egcsp.setBounds(150,10,600,500);
            tableList.setBounds(20,10,110,20);
            
            egc.add(egcsp);
            egc.add(tableList);
            
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
                    String submitsql = "ALTER TABLE " + selectedSection +
                                       " ADD " + columnName + " INTEGER";
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

        class RoundedPanel extends JPanel
        {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
            }
        }
