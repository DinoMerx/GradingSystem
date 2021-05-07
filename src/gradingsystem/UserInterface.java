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
import javax.swing.table.DefaultTableModel;
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
    
    //Percent
    String PerformanceTask;
    String WrittenWork;
    String Test;
    //calculation
    /*
    PERFORMANCETASKTOTAL
    SQL = "Select PerformanceTask from SECTIONSUBJECT"
     ResultSet rs; 
     String querySQL =  "select PerformanceTask from Percentage";
     Statement qSTMT = con.createStatement();
     rs = qSTMT.executeQuery(querySQL);
     
     while(rs.next())
    {
    PTInteger = rs.getString("PerformanceTask")
    PTInteger = Integer.parseInt(PTInteger);
    PerformanceTaskTotal = PerformanceTaskTotal + PTInteger; 
    }
    */
    //CODE TO GET THAT THURDY
    /*DatabaseMetaData dbm2 = con.getMetaData();
                ResultSet rs; 
                String querySQL =  "select PerformanceTask from Percentage";
                Statement qSTMT = con.createStatement();
                rs = qSTMT.executeQuery(querySQL);
                
                if(rs.next())
                {
                    PerformanceTask = rs.getString("PerformanceTask");
                    WrittenWork = rs.getString("Written Work(Q/SW)");
                    Test = rs.getString("Test");
                    
                    PerformanceTask = Float.parseFloat(PerformanceTask);
                    WrittenWork= Float.parseFloat(WrittenWork);
                    Test=Float.parseFloat(Test);
                }*/
    
    public ActionListener actionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
                UIAddSection();
                }   
        
    };
    
    // JFrames
    final JFrame gs = new JFrame("Grading System");
    final JFrame as1 = new JFrame("Add Section");
    final JFrame as2 = new JFrame("Add Students");
    final JFrame as3 = new JFrame("Add Students");
    final JFrame ast = new JFrame("Add Student");
    final JFrame ag = new JFrame("Add Grade");
    final JFrame egc = new JFrame("Edit Grade Component");
    final JFrame ep = new JFrame("Edit Percentage");
    final JFrame esg = new JFrame("Edit Student Grade");
    final JFrame f = new JFrame("Grading System");
    final JFrame sg = new JFrame("Student Grade");
    final JFrame EW = new JFrame("Error: Section Already Exists!");
    
    //Menu Inputs
    JButton bm1 = new JButton("Edit Section");
    JButton bm2 = new JButton("Add Section");
    JLabel mlbl = new JLabel("Grading System");   
    JComboBox sectionList = new JComboBox();
    JComboBox sectionList1 = new JComboBox();
    
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
    JButton bgs5 = new JButton("View Student Grade");
    JButton bgs6 = new JButton("Back");
    
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
    
    //View Student Grade
    JButton sgback = new JButton("Back");

    
    
    // UIMenu, aka the main screen
    
    JPanel exit = new JPanel();
    JPanel minimize = new JPanel();
    JPanel title = new JPanel();
    //H

    //Edit Student Grade
    JButton addSubj = new JButton("Add Subject");
    JButton assSubj = new JButton("Assign Subject");
    JTextField SubjTF = new JTextField("enter your input here");
    JComboBox subjectList = new JComboBox();
    

    private Point currentLocation;
        
        public void UIMenu(){
            
            
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
            
            
            
            
            JLabel bm2lbl = new JLabel("<html><div style='text-align: center;'>This is where you Add Section</div><html>");
            bm2lbl.setBounds(20,20,110,50);
            pbm2.add(bm2lbl);
            pbm2.add(bm2);
            
            bm2.addActionListener(new UIAddSection());
            
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
            
            try
            {
                PreparedStatement uiST;
                String uiSQL = " SELECT SECTION FROM SectionList ";
                con = DriverManager.getConnection(databaseURL); 
                uiST = con.prepareStatement(uiSQL);
                ResultSet uiRS = uiST.executeQuery();
                while(uiRS.next())
                {
                  sectionList.addItem(uiRS.getString("SECTION"));
                }
                uiRS.close();
                
            }
            catch(SQLException PE)
            {
                PE.printStackTrace();
            }
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
            bgs6.setBounds(60,230,160,20);
            
            bgs1.addActionListener(new UIAddStudent());
            bgs2.addActionListener(new UIAddGrade());
            bgs3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    UIEditGradeComponent();
                    bgs3.removeActionListener(this);
                    gs.remove(gslb2);
                    gs.remove(gslb1);
                    gs.remove(bgs1);
                    gs.remove(bgs2);
                    gs.remove(bgs3);
                    gs.remove(bgs4);
                    gs.remove(bgs5);
                }
            });
            bgs4.addActionListener(new UIEditStudentGrade());
            bgs5.addActionListener(new UIStudentGrade());
            bgs6.addActionListener(new ActionListener()
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
                gs.remove(bgs6);
                gs.dispose();
                bgs6.removeActionListener(this);
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
            gs.add(bgs6);
            
            gs.setLayout(null);
            gs.setVisible(true);
            gs.setSize(300,320);
            
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
            f.setVisible(false);
            JLabel lblas = new JLabel("Add Section");
            JLabel lblsec = new JLabel("Section:");
            
            lblas.setBounds(100,30,110,20);
            lblsec.setBounds(35,60,110,20);
            
            asec.setBounds(95,60,110,20);
            
            bas1.setBounds(50,120,80,20);
            bas2.setBounds(150,120,80,20);
            
            
            bas1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                
                try // TODO: If section name exists, do nothing. Else, execute asSQL,2,3
                {  
                int tester = 0;
                DatabaseMetaData dbm = con.getMetaData();
                boolean exists = con.getMetaData().getTables(null, null, asec.getText(), null).next();
                
                if(exists)
                {
                  JOptionPane.showMessageDialog(null, "Section already Exists!");
                    //Statement stmt = con.createStatement();
                    System.out.println("Section already exists!"); 
                }   
                    
                    
                    
                    /*System.out.println("Initial Tester Value: " + tester);
                    String currentTable = tables.getString(3);
                    String currentSection = asec.getText();
                    System.out.println("CurrentTable: " + currentTable);
                    System.out.println("CurrentSection: " + currentSection);
                    if(currentSection.equals(currentTable));
                    {
                    tester = 1;
                    }*/
                    //DEBUGGER V
                    //System.out.println("THIS IS CURRENT DATA: " + asec.getText());
                    //System.out.println("THIS IS TABLE DATA: " + tables.getString(3));
                    //System.out.println("TESTER VALUE = " + tester);
                    
                
                
                /*if (tester == 1)
                {
                    
                    //String sqlDELTABLE = "DROP TABLE PLACEHOLDER";
                    //stmt.executeUpdate(sqlDELTABLE);
                }*/
                else
                {
                    System.out.println("Creating section...");
                    Connection ASTCon = DriverManager.getConnection(databaseURL);
                    Statement astST = ASTCon.createStatement();
                    
                ResultSet data = dbm.getTables(null, null, "%", null);
                while(data.next())
                {
                if(data.getString(3).equals("GENERICINSERT_PLACEHOLDER"))
                {
                    String sqlDELETE = "DROP GENERICINSERT_PLACEHOLDER";
                    Statement stDEL = con.createStatement();
                    stDEL.execute(sqlDELETE);
                    stDEL.close();
                }
                }
                     
                    String asSQL = "CREATE TABLE PLACEHOLDER "  +
                                   "(id AUTOINCREMENT PRIMARY KEY, FULL_NAME varchar(255), PERFORMANCE_TASK float, WRITTEN_WORK float, LONG_TEST float, WEIGHTED_AVERAGE  "
                                 + ")";
                    String asSQL2 ="ALTER TABLE PLACEHOLDER" +
                                   " RENAME TO " + asec.getText();
                    String asSQL3 = " INSERT INTO SectionList(SECTION) VALUES(?)";
                    String asSQL4 = "CREATE TABLE " + asec.getText()+"GRADES "
                            + "(ID int, PERFORMANCE_TASK float, WRITTEN_WORK float, LONG_TEST float, PRIMARY KEY(ID))";
                    
                    PreparedStatement asSQL4STMT = con.prepareStatement(asSQL4);
                    asSQL4STMT.execute();
                    String asSQL5;
                    for (int counter = 1; counter <= 10; counter++)
                    {
                        asSQL5= "INSERT INTO " + asec.getText()+ "GRADES(ID) VALUES("+counter+")";
                        PreparedStatement asSQL5STMT = con.prepareStatement(asSQL5);
                        asSQL5STMT.executeUpdate();
                    }
   
                    

                    
                    
                    PreparedStatement astST2 = ASTCon.prepareStatement(asSQL3);
                    
                    
                    
                    sectionList.addItem(asec.getText());
                   
                    
                   
                   astST.execute(asSQL);
                   astST.execute(asSQL2);
                   astST2.setString(1,asec.getText());
                   astST2.executeUpdate();
                   
                   
                   
                   bas1.removeActionListener(this);
                   astST.close();
                   astST2.close();
                   ASTCon.close(); 
                f.setVisible(true); 
                SwingUtilities.updateComponentTreeUI(f);
                   f.invalidate();
                   f.validate();
                   f.repaint();
                SwingUtilities.updateComponentTreeUI(as1);
                   as1.invalidate();
                   as1.validate();
                   as1.repaint();   
                
                
                
                as1.remove(lblsec);
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas2); //test1
                as1.dispose();
                bas1.removeActionListener(this);
                
                f.setVisible(true);
                
                }
                   
                }
                catch(SQLException p)
                {
                    p.printStackTrace();
                }
               
                
                
                
                
                
                }
            });
            
            bas2.addActionListener(new ActionListener() //button Back in adoasjdiowadhjfioweqjfrio
            {
                public void actionPerformed(ActionEvent e)
                {

                as1.dispatchEvent(new WindowEvent(as1, WindowEvent.WINDOW_CLOSING));    
                as1.remove(lblas);
                as1.remove(lblsec);
                as1.remove(bas1);
                as1.remove(bas2);
                as1.remove(asec);
                as1.setVisible(false);
                as1.dispose();
                f.dispose();
                f.setVisible(true); 
                bas2.removeActionListener(this);
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
                f.setVisible(true);
                as1.dispose();
                as1.dispatchEvent(new WindowEvent(as1, WindowEvent.WINDOW_CLOSING));
                for( ActionListener al : bas2.getActionListeners() ) {
                bas2.removeActionListener( al );
                }
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
                    String astSQL2 = "INSERT INTO " + selectedSection + " (FULL_NAME,PERFORMANCE_TASK,WRITTEN_WORK,LONG_TEST,WEIGHTED_AVERAGE) VALUES (?,?,?,?,?)";
                    PreparedStatement astPS = ASTCon.prepareStatement(astSQL2);
                    astPS.setString(1,name);
                    astPS.setInt(2,0);
                    astPS.setInt(3,0);
                    astPS.setInt(4,0);
                    astPS.setInt(5,0);
                    astPS.executeUpdate();   
                    astPS.close();
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
            ASTBack.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ast.remove(enterName);
                    ast.remove(enterNameTF);
                    ast.remove(ASTSubmit);
                    ast.remove(ASTBack);   
                    ast.setVisible(false);
                    ASTSubmit.removeActionListener(this);
                }
            });
            
            ast.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ast.remove(enterName);
                    ast.remove(enterNameTF);
                    ast.remove(ASTSubmit);
                    ast.remove(ASTBack);   
                ast.removeWindowListener(this);
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
            JLabel textS = new JLabel("Select Student: ");
            JLabel text1 = new JLabel("Select component type: ");
            JLabel text2 = new JLabel("Number: ");
            JLabel textScore = new JLabel("Score: ");
            
            JTextField textScorefield = new JTextField();
            JComboBox studentList = new JComboBox();
           
            try
            {
            PreparedStatement studentST;
            String studentSQL = "SELECT FULL_NAME FROM " + selectedSection;
            studentST = con.prepareStatement(studentSQL);
            ResultSet studentRS = studentST.executeQuery();
            while(studentRS.next())
            {
                studentList.addItem(studentRS.getString("FULL_NAME"));
            }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            JComboBox numberList = new JComboBox();
            
            numberList.addItem("1");
            numberList.addItem("2");
            numberList.addItem("3");
            numberList.addItem("4");
            numberList.addItem("5");
            numberList.addItem("6");
            numberList.addItem("7");
            numberList.addItem("8");
            numberList.addItem("9");
            numberList.addItem("10");
            
            
            JComboBox componentList = new JComboBox();
            componentList.addItem("Performance Task");
            componentList.addItem("Long Test");
            componentList.addItem("Written Works");
            
            componentList.setBounds(20,30,150,20);
            numberList.setBounds(80,60,50,20);
            
            textfield1.setBounds(150,10,120,20);
            text1.setBounds(20,10,150,20);
            text2.setBounds(20,60,150,20);
            textS.setBounds(20,80,150,20);
            submit.setBounds(60,150,80,20);
            cancel.setBounds(150,150,80,20);
            textScore.setBounds(20,130,80,20);
            textScorefield.setBounds(100,130,80,20);
            studentList.setBounds(10,100,270,20);
            
            submit.addActionListener(new Submit()
            {
                public void actionPerformed(ActionEvent e)
                {
                try
                {
                if( componentList.getSelectedItem() == "Performance Task" )
                {
                    String TFStringValue = textScorefield.getText();
                    System.out.println("Stored value: " + TFStringValue);
                    System.out.println(textScorefield.getText());
                    String sql = "UPDATE " + selectedSection + " SET PERFORMANCE_TASK = PERFORMANCE_TASK + ? WHERE FULL_NAME = ?";
                    PreparedStatement AddGradeST = con.prepareStatement(sql);
                    
                    float intScoreTF = Float.parseFloat(TFStringValue);
                    AddGradeST.setFloat(1, intScoreTF);
                    AddGradeST.setString(2,(String)studentList.getSelectedItem());
                    
                    AddGradeST.executeUpdate();
                    
                    
                    
                    
                }
                else if ( componentList.getSelectedItem() == "Long Test")
                {
                    
                }
                else if ( componentList.getSelectedItem() == "Written Works")
                {
                    
                }
                }
                catch(Exception f)
                {
                    f.printStackTrace();
                }
                
                }
            });
            cancel.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                ag.remove(text1);
                ag.remove(textfield1);
                ag.remove(submit);
                ag.remove(cancel);
                ag.remove(numberList);
                ag.remove(componentList);
                ag.remove(textS);
                ag.remove(text2);
                ag.remove(textScorefield);
                ag.remove(textScore);
                ag.setVisible(false);
                cancel.removeActionListener(this);
                }
            });
            ag.add(studentList);
            ag.add(numberList);
            ag.add(componentList);
            ag.setLayout(null);
            ag.setSize(300,250);
            ag.add(text1);
            ag.add(textS);
            ag.add(text2);
            ag.add(submit);
            ag.add(cancel);
            ag.add(textScorefield);
            ag.add(textScore);
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
                ag.remove(numberList);
                ag.remove(componentList);
                ag.remove(textS);
                ag.remove(text2);
                ag.remove(textScorefield);
                ag.remove(textScore);
                ag.removeWindowListener(this);
                
                }
            });
            
        }
        
        public void UIEditGradeComponent()
        {
            gs.setVisible(false);
            JButton egcB1 = new JButton("Edit Percentage");
            JButton egcB2 = new JButton("Back");
            
            egcB1.setBounds(10,10,130,20);
            egcB2.setBounds(10,30,130,20);
            ep.add(egcB2);
            ep.add(egcB1);
            
            egcB1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                egc.dispose();
                egcB1.removeActionListener(this);
                UIEditPercentage();
                gs.setVisible(false);
                }
            }
                );
            
            egcB2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                UIGradingSystem();
                ep.dispose();
                }
            });
            
            ep.setLayout(null);
            ep.setSize(250,200);
            ep.setVisible(true);
            ep.setLocationRelativeTo(null);
            
        }
        
            public void UIEditPercentage(){

                JLabel wwlbl = new JLabel("Written Works:");
                JLabel ltlbl = new JLabel("Long Test:");
                JLabel ptlbl = new JLabel("Performance Task:");

                JTextField ww = new JTextField();
                JTextField lt = new JTextField();
                JTextField pt = new JTextField();

                JButton bts = new JButton("Submit");
                JButton btc = new JButton("Cancel");

                bts.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                     try
                {


                String sqlUpdatePercentage = "UPDATE Percentage "
                        + "SET PerformanceTask =? WHERE ID = 1" ;
                String sqlUpdatePercentage2 = "UPDATE Percentage "
                        + "SET WrittenWork =? WHERE ID = 1" ;
                String sqlUpdatePercentage3 = "UPDATE Percentage "
                        + "SET Test =? WHERE ID = 1" ;
                PreparedStatement UpdateSTMT = con.prepareStatement(sqlUpdatePercentage);
                PreparedStatement UpdateSTMT2 = con.prepareStatement(sqlUpdatePercentage2);
                PreparedStatement UpdateSTMT3 = con.prepareStatement(sqlUpdatePercentage3);
                
                float ParsePT = Float.parseFloat(pt.getText());
                float ParseWW = Float.parseFloat(ww.getText());
                float ParseLT = Float.parseFloat(lt.getText());
                
                float percentDecimal1 = ParsePT / 100;
                float percentDecimal2 = ParseWW / 100;
                float percentDecimal3 = ParseLT / 100;       
                
                String PT = String.valueOf(percentDecimal1);
                String WW = String.valueOf(percentDecimal2);
                String LT = String.valueOf(percentDecimal3);
                
                UpdateSTMT.setString(1,PT);
                UpdateSTMT2.setString(1,WW);
                UpdateSTMT3.setString(1,LT);

                UpdateSTMT.executeUpdate();
                UpdateSTMT2.executeUpdate();
                UpdateSTMT3.executeUpdate();
                }
                catch (SQLException f)
                {
                    f.printStackTrace();
                }   
                    }    
                    });
            
            
            wwlbl.setBounds(20,30,110,20);
            ltlbl.setBounds(20,50,110,20);
            ptlbl.setBounds(20,70,110,20);
            
            ww.setBounds(150,30,50,20);
            lt.setBounds(150,50,50,20);
            pt.setBounds(150,70,50,20);
            
            bts.setBounds(20,100,80,20);
            btc.setBounds(120,100,80,20);
            
            egc.add(wwlbl);
            egc.add(ltlbl);
            egc.add(ptlbl);
            egc.add(ww);
            egc.add(lt);
            egc.add(pt);
            egc.add(bts);
            egc.add(btc);
            
            egc.setLayout(null);
            egc.setVisible(true);
            egc.setSize(250,200);
            egc.setLocationRelativeTo(null);
        }
        
        public void UIEditStudentGrade(){
            
            addSubj.setBounds(15,60,110,20);
            assSubj.setBounds(15,90,110,20);
            SubjTF.setBounds(130,60,130,20);
            subjectList.setBounds(160,90,110,20);
            
            esg.add(addSubj);
            esg.add(SubjTF);
            esg.add(assSubj);
            esg.add(subjectList);
            
            assSubj.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                try
                {
                Connection esgCon = DriverManager.getConnection(databaseURL);
                
                Statement esgST = esgCon.createStatement();
                
                String esgSQL = "CREATE TABLE PLACEHOLDER2"
                        + "(id AUTOINCREMENT PRIMARY KEY)";
                esgST.execute(esgSQL);
                
                
               
                
                String esgSQL2a = "UPDATE SectionList SET " + SubjTF.getText()
                        + " = ? WHERE SECTION = ?";
                
                PreparedStatement esgPS = con.prepareStatement(esgSQL2a);
                esgPS.setObject(1, selectedSection + SubjTF.getText());
                esgPS.setString(2, selectedSection);
                esgPS.executeUpdate();
                String esgSQL3 = "ALTER TABLE PLACEHOLDER2"
                        + " RENAME TO " + selectedSection + SubjTF.getText();
                esgST.execute(esgSQL3);
                }
                catch(SQLException EZ)
                {
                    EZ.printStackTrace();
                }
                assSubj.removeActionListener(this);
                }
                
            });
            
            addSubj.addActionListener(new ActionListener()
            {
             public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                       Connection assST = DriverManager.getConnection(databaseURL);
                       Statement esgST = assST.createStatement(); 
                                // Move this to add subject
                       String esgSQL2 = "ALTER TABLE SectionList"
                               + " ADD " + SubjTF.getText() + " varchar(255)";
                       subjectList.addItem(SubjTF.getText());
                
                       esgST.execute(esgSQL2);
                    }
                    catch(Exception pe)
                    {
                        pe.printStackTrace();
                    }
                    addSubj.removeActionListener(this);
                }   
            });
            
            esg.setLocationRelativeTo(null);
            esg.setLayout(null);
            esg.setVisible(true);
            esg.setSize(300,200);
        }
        
        public void UIStudentGrade() {
            DefaultTableModel cn = new DefaultTableModel(new String[]{"ID", "Fullname", "WrittenWork", "PerformanceTask", "Test"}, 0);
            JTable sgtb = new JTable(cn);
            
            String databaseURL = "jdbc:ucanaccess://src/resources/GradingSystem.accdb";
        
            Connection con = null;
            Statement st = null;
            PreparedStatement pst = null;
            
            try {
                
                con = DriverManager.getConnection(databaseURL);
                pst = con.prepareStatement("Select * FROM "+sectionList.getSelectedItem());
                
                
                ResultSet rs = pst.executeQuery();
                
            while(rs.next()){
                String a = rs.getString("id");
                String b = rs.getString("FULL_NAME");
                String c = rs.getString("WRITTEN_WORK");
                String d = rs.getString("PERFORMANCE_TASK");
                String e = rs.getString("LONG_TEST");
                cn.addRow(new Object[]{a, b, c, d, e});
            }    
                
            } catch (SQLException e) {
            
                e.printStackTrace();
            
            }
            
            JScrollPane egcsp = new JScrollPane(sgtb);
            
            sgback.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                gs.setVisible(true); 
                sg.remove(sgback);
                sg.remove(egcsp);
                sg.dispose();
                }
            });
            
            egcsp.setBounds(150,10,600,500);
            
            sgback.setBounds(20,20,100,20);
            
            sg.add(egcsp);
            sg.add(sgback);
            
            sg.setLayout(null);
            sg.setVisible(true);
            sg.setSize(800,720);
            sg.setLocationRelativeTo(null);
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
                    submitST.close();
                    
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
        
        public class UIAddSection implements ActionListener{
        @Override
                public void actionPerformed(ActionEvent e)                   
                {
                    f.setVisible(false);
                    bm2 = (JButton)e.getSource();
                    System.out.println("Add Section");
                    UIAddSection();
                    
                }
        }
        
        public class UIGradingSystem implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) 
            {
                f.setVisible(false);
                bm1 = (JButton)e.getSource();
                UIGradingSystem();
                //ag.setVisible(false);
                
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
        
        public class UIStudentGrade implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                bgs6 = (JButton)e.getSource();
                
                UIStudentGrade();
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
