package missystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DIPAK
 */
public class teacherdashboard extends JFrame implements ActionListener 
{
 
    
    JPanel p1,p2,p3,main,menu;
    JButton student,dept,course,settings;
    JButton loginButton,registerButton,logo,menubar;
    Border blackline ;
    ImageIcon icon;
    JLabel usernameLabel;
        JTextField usernameField ;
        JLabel passwordLabel;
        JPasswordField passwordField ;
        
        ImageIcon sticon;
        
        JLabel bg;
    
    public teacherdashboard() {
        
    
        setTitle("TEACHER DASHBOARD");
    
       blackline = BorderFactory.createLineBorder(Color.black,5);
       TitledBorder borderstudent = BorderFactory.createTitledBorder(": STUDENTS :");
        borderstudent.setTitleColor(Color.BLACK);
        borderstudent.setTitleFont(new Font("Arial", Font.BOLD, 25));
        borderstudent.setTitlePosition(TitledBorder.BELOW_TOP);
        borderstudent.setBorder(blackline);
        
        TitledBorder bordercourse = BorderFactory.createTitledBorder(": COURSES :");
        bordercourse.setTitleColor(Color.red);
        bordercourse.setTitleFont(new Font("Arial", Font.BOLD, 25));
        bordercourse.setTitlePosition(TitledBorder.BELOW_TOP);
        bordercourse.setBorder(blackline);
        
        TitledBorder borderdept = BorderFactory.createTitledBorder(": DEPARTMENT :");
        borderdept.setTitleColor(Color.red);
        borderdept.setTitleFont(new Font("Arial", Font.BOLD, 25));
        borderdept.setTitlePosition(TitledBorder.BELOW_TOP);
        borderdept.setBorder(blackline);
        
        TitledBorder borderset = BorderFactory.createTitledBorder(": SETTINGS :");
        borderset.setTitleColor(Color.black);
        borderset.setTitleFont(new Font("Arial", Font.BOLD, 25));
        borderset.setTitlePosition(TitledBorder.BELOW_TOP);
        borderset.setBorder(blackline);
  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,900);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        
        
         Color c=Color.decode("#51087E");
        
        p1=new JPanel();
        p1.setLocation(15,15);
        p1.setSize(1150,830);
        p1.setBackground(c);
        p1.setBorder(blackline);
        p1.setLayout(null);
        p1.setVisible(true);
        
        menu=new JPanel();
        menu.setLocation(15,280);
        menu.setSize(1115,500);
        menu.setBackground(Color.yellow);
         menu.setBackground(c);
//        menu.setBorder(blackline);
        menu.setLayout(new GridLayout(2,2,20,20));
        menu.setVisible(true);
        
        
        bg=new JLabel(": TEACHER DASHBOARD :");
        bg.setLocation(40,40);
        bg.setSize(1000,150);
        bg.setForeground(Color.WHITE);
        bg.setFont(new Font("Arial", Font.BOLD,50));
//        bg.setBackground(Color.decode("#6C0BA9"));
        bg.setHorizontalAlignment(SwingConstants.CENTER);
        bg.setBorder(BorderFactory.createLineBorder(Color.white,3));
        bg.setVisible(true);
        
       
          menubar=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1090,40,60,60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD,25));
        this.add(menubar);
        
        sticon=new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\s1.jpeg");
        student=new JButton();
        student.setPreferredSize(new Dimension(sticon.getIconWidth(), sticon.getIconHeight()));
        student.setIcon(sticon);
        
        

        student.setBackground(Color.orange);
        student.setBorder(borderstudent);
        student.setText("STUDENT");
        student.addActionListener(this);
        student.setBackground(Color.white);
        
        dept=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\dept2.png"));
        dept.setBackground(Color.orange);
        dept.setBorder(borderdept);
        dept.setBackground(Color.white);
        
        course=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\c1.png"));
        course.setBorder(bordercourse);
        course.setBackground(Color.white);
        
        settings=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\st2.png"));
        settings.setBorder(borderset);
        settings.setBackground(Color.white);
        settings.addActionListener(this);
        
        menu.add(student);
        menu.add(course);
        menu.add(dept);
        menu.add(settings);
        
       
        p1.add(menu);
        p1.add(bg);
     
        add(p1);
        setTitle("TEACHER DASHBOARD");
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) 
{
    
    
     if (ae.getSource() == menubar) {
            this.setVisible(false);
            new tlogin();
        }
        
    
    if(ae.getSource()== student)
    {
        this.setVisible(false);
       new studentpanel();
        
    }
    
    if(ae.getSource()== settings)
    {
        this.setVisible(false);
       new settings();
        
    }
    
}
    
    
     public static void main(String[] args) {
        teacherdashboard frame = new teacherdashboard();
    }

    
}
