package missystem;
/**
 *
 * @author VARAD GONDEPATIL
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class MISSYSTEM extends JFrame implements ActionListener {
 
    JPanel p1,p2,p3,main;
    JButton student,teacher;
    Border blackline ;
    ImageIcon icon,icon2;
    JLabel label;
    
    
    public MISSYSTEM() {
        
       icon = new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\student.png");
       icon2 = new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\teacher.png");
       
       Color c=Color.decode("#0A0A0A");
       Color c2=Color.decode("#666666");
       
       
        label = new JLabel(": STUDENT INFORMATION SYSTEM  :");
        label.setSize(1080, 50);
        label.setLocation(50, 10);
        label.setBackground(c);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));
      
       blackline = BorderFactory.createLineBorder(Color.black, 5);
        TitledBorder border = BorderFactory.createTitledBorder(": STUDENT SECTION :");
        border.setTitleColor(Color.BLACK);
        border.setTitleFont(new Font("Arial", Font.BOLD, 25));
        border.setTitlePosition(TitledBorder.BELOW_TOP);
        border.setBorder(blackline);
        
        TitledBorder border2 = BorderFactory.createTitledBorder(": FACULTY SECTION :");
        border2.setTitleColor(Color.BLACK);
        border2.setTitleFont(new Font("Arial", Font.BOLD, 25));
        border2.setTitlePosition(TitledBorder.BELOW_TOP);
        border2.setBorder(blackline);
        
        setTitle("MIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,900);
        setLayout(null);
        getContentPane().setBackground(c2);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setLocation(50,70);
        p1.setSize(1080,750);
        p1.setBackground(Color.white);
//         p1.setBackground(c2);
        p1.setBorder(BorderFactory.createLineBorder(Color.black,18));
        p1.setLayout(null);
        p1.setVisible(true);
       
        
        main=new JPanel();
        main.setLayout(new GridLayout(1,2,50,50));
        main.setLocation(50,50);
        main.setSize(980,650);
        main.setBackground(Color.white);
//        main.setBackground(c2);
        main.setVisible(true);
        
        
        p2=new JPanel();
        p2.setBorder(border);
        p2.setLocation(50,50);
        p2.setSize(100,100);
        p2.setBackground(Color.red);
        p2.setLayout(new GridLayout(1,2,50,50));
        p2.setVisible(true);
        
        
        p3=new JPanel();
        p3.setBorder(border2);
        p3.setLocation(50,50);
        p3.setSize(100,100);
        p3.setBackground(Color.orange);
        p3.setLayout(new GridLayout(1,2,50,50));
        
        main.add(p2);
        main.add(p3);

        p1.add(main);
        
        
        student=new JButton(icon);
        student.setSize(100,100);
        student.setBorder(blackline);
        student.addActionListener(this);
        p2.add(student);
        
        
       teacher=new JButton(icon2);
        teacher.setSize(100,100);
        teacher.setBorder(blackline);
        teacher.addActionListener(this);
        p3.add(teacher);
        

        
         this.add(label);
        add(p1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
      
      
      
    if(ae.getSource()== student)
    {
      this.setVisible(false);
      System.out.println("going");

      new login();
      
    }
    
    if(ae.getSource()== teacher)
    {
      this.setVisible(false);
      System.out.println("going");
      new tlogin();
      
    }
    
      
      
      
    }

    public static void main(String[] args) {
        MISSYSTEM frame = new MISSYSTEM();
    }
}