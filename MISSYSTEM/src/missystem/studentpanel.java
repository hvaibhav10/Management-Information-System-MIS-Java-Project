
package missystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;


/**
 *
 * @author DIPAK
 */
public class studentpanel extends JFrame implements ActionListener 
{
 
    
    JPanel p1,p2,p3,main;
    JButton add,registerButton,logo,list,searchbtn,menubar;
    Border blackline ;
    ImageIcon icon;
    JLabel usernameLabel;
        JTextField usernameField ,search;
        JLabel passwordLabel;
        JPasswordField passwordField ;
        JTable table;
        DefaultTableModel model ;
        
        
   
    
    public studentpanel() {
        
    Color c1=Color.decode("#362624");
        
    
       blackline = BorderFactory.createLineBorder(Color.white,3);
  
        setTitle("STUDENT PANEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,900);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setLocation(15,15);
        p1.setSize(1150,830);
        p1.setBackground(c1);
        p1.setBorder(blackline);
        p1.setLayout(null);
        p1.setVisible(true);
       
        add=new JButton("ADD STUDENT +");
        add.setBackground(Color.orange);
        add.setBounds(10,20, 250,60);
        add.addActionListener(this);
        add.setFont(new Font("Arial", Font.BOLD,25));
        
        list=new JButton("STUDENT LIST");
        list.setBackground(Color.RED);
        list.setBounds(280,20, 250,60);
        list.addActionListener(this);
        list.setFont(new Font("Arial", Font.BOLD,25));
        
        
        search=new JTextField();
        search.setBounds(560,20, 250,60);
        search.setFont(new Font("Arial", Font.BOLD,25));
        search.setBorder(BorderFactory.createLineBorder(Color.black,3));
        
         searchbtn=new JButton("SEARCH");
        searchbtn.setBackground(Color.green);
        searchbtn.setBounds(810,20, 250,60);
        searchbtn.addActionListener(this);
        searchbtn.setFont(new Font("Arial", Font.BOLD,25));
        
        menubar=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1080,20,60,60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD,25));
        
        
         model= new DefaultTableModel();
        model.addColumn("Enrollment Number");
        model.addColumn("Name");
        model.addColumn("Department");
      

        // Create the JTable using the model
        table = new JTable(model);
        table.setBorder(BorderFactory.createLineBorder(Color.white,6));
        
        
        
        
        Font font;
        font = new Font("Arial", Font.PLAIN, 30);
        table.setFont(font);

        // Set the font size of the table header
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.black);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 30));
        
       int rowHeight = 40;
       table.setRowHeight(rowHeight);

        // Add the table to a JScrollPane and display it in a JFrame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25,100,1100,690);
        p1.add(scrollPane);
        
        p1.add(add);
        p1.add(list);
        p1.add(search);
        p1.add(searchbtn);
        p1.add(menubar);
        
     
        add(p1);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) 
{
    if(ae.getSource()== add)
    {
        this.setVisible(false);
       new addstudent();
        
    }
    else if(ae.getSource()== list)
    {
        model.setRowCount(0);
       try{
          
        ResultSet rs = null;
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis","root","root"); 
        Statement stmt;
        stmt = con.createStatement();
        String query;
            
            rs = stmt.executeQuery("SELECT enrollmentno, name,department FROM student_info");

            boolean b=true;
             while (rs.next()) {
                 
               

                 
                int en = rs.getInt("enrollmentno");

                String name = rs.getString("name");
                String department = rs.getString("department");

                System.out.println("enrollmentno: " + en);
                System.out.println("name: " + name);
                System.out.println("department: " + department);
                
                 model.addRow(new Object[] {en, name,department});
                
                b=false;
          } 
            if(b){
               JOptionPane.showMessageDialog(null, "No Student found!");

           }
        
        
        stmt.close();
        con.close();
        
        
        }
        catch(ClassNotFoundException | SQLException e){ System.out.println(e);}
    }
        
    
    if(ae.getSource()== searchbtn)
    {
        
        
        try{
            
            int  en=Integer.parseInt(search.getText());
          
        ResultSet rs = null;
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis","root","root"); 
        Statement stmt;
        stmt = con.createStatement();
        String query;
            
            rs = stmt.executeQuery("SELECT * FROM student_info WHERE  enrollmentno ="+en+"");

           if (rs.next()) {
       
               this.setVisible(false);
               new studentdetails(en);
                
            } else {
                JOptionPane.showMessageDialog(null, "No Student found!");
            }
        
        
        stmt.close();
        con.close();
        
        
        }
        catch(Exception e ){  JOptionPane.showMessageDialog(null,e);}
    
    }
     if (ae.getSource() == menubar) {
            this.setVisible(false);
            new teacherdashboard();
        }
        
}   
     public static void main(String[] args) {
        studentpanel frame = new studentpanel();
    }

    
}
