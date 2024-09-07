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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author DIPAK
 */
public class settings extends JFrame implements ActionListener {

    JPanel p1, p2, p3, main;
    JButton registerButton, resetButton, logo, menubar;
    Border blackline;
    ImageIcon icon;
    JLabel usernameLabel, nameLable, label;
    JTextField usernameField, nameField;
    JLabel passwordLabel;
    JPasswordField passwordField;

    public settings() {
        
        Color c2=Color.decode("#7B3F00");
       Color c1=Color.decode("#362624");

        label = new JLabel(": Adding New Admin :");
        label.setSize(480, 30);
        label.setLocation(10, 10);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));

        icon = new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\login.jpeg");

        blackline = BorderFactory.createLineBorder(Color.black, 5);

        setTitle("SETTINGS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(null);
        getContentPane().setBackground(c2);
        setLocationRelativeTo(null);

        p1 = new JPanel();
        p1.setLocation(50, 20);
        p1.setSize(1080, 800);
        p1.setBackground(c1);
        p1.setBorder(BorderFactory.createLineBorder(Color.black, 18));
        p1.setLayout(null);
        p1.setVisible(true);

        main = new JPanel(null);
        main.setLocation(280, 50);
        main.setSize(500, 700);
        main.setBackground(Color.white);
        main.setVisible(true);
        main.setBorder(blackline);

        menubar = new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1050, 40, 60, 60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(menubar);

        nameLable = new JLabel("Faculty Name:");
        nameField = new JTextField(20);
        nameLable.setSize(400, 50);
        nameField.setSize(400, 50);

        nameLable.setLocation(50, 270);
        nameField.setLocation(50, 320);

        nameLable.setFont(new Font("Arial", Font.BOLD, 25));
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));

        main.add(nameLable);

        main.add(nameField);
        main.add(label);

        // Add a JLabel and a JTextField for the username
        usernameLabel = new JLabel("Faculty Id:");
        usernameField = new JTextField(20);
        usernameLabel.setSize(400, 50);
        usernameField.setSize(400, 50);

        usernameLabel.setLocation(50, 380);
        usernameField.setLocation(50, 430);

        usernameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 25));

        main.add(usernameLabel);

        main.add(usernameField);

        // Add a JLabel and a JPasswordField for the password
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordLabel.setSize(400, 50);
        passwordField.setSize(400, 50);

        passwordLabel.setLocation(50, 480);
        passwordField.setLocation(50, 530);

        passwordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 25));

        main.add(passwordLabel);

        main.add(passwordField);

        // Add a JButton for the login
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 25));
        registerButton.setSize(190, 50);
        registerButton.setLocation(50, 600);
        registerButton.addActionListener(this);

        // Add a JButton for the register
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 25));
        resetButton.setSize(190, 50);
        resetButton.setLocation(260, 600);
        resetButton.addActionListener(this);
        main.add(registerButton);
        main.add(resetButton);

        p1.add(main);

        logo = new JButton(icon);
        logo.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        logo.setLocation(130, 45);
//        logo.setLocation(130, 10);
        logo.setSize(230, 230);
        logo.setBackground(Color.red);
        logo.setLayout(null);
        logo.setVisible(true);

        main.add(logo);

        add(p1);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == menubar) {
            this.setVisible(false);
            new teacherdashboard();
        }

        if (ae.getSource() == resetButton) {

            usernameField.setText(null);
            passwordField.setText(null);
            nameField.setText(null);
        }

        if (ae.getSource() == registerButton) {

            
            String teacherid = usernameField.getText();
            System.out.println("Username: " + teacherid);

            String name = nameField.getText();
            System.out.println("Name: " + name);

            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            System.out.println("Password: " + password);
            
            boolean b=true;
           
            
            if (teacherid.isEmpty() || name.isEmpty() || password.isEmpty()) {

                    b=false;
  
            }
            
            if(b)
            {
                 

            try {

                ResultSet rs = null;
                Connection con = null;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis", "root", "root");
                Statement stmt;
                stmt = con.createStatement();
                String query;

                stmt.executeUpdate("INSERT INTO teacher_login(teacher_id , name, password)VALUES('" + teacherid + "',  '" + name + "',  '" + password + "')");
                JOptionPane.showMessageDialog(null, "New Admin Created Succesfully!");
                this.setVisible(false);
                new tlogin();

                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null,e);
            }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Fill all the Fields!");
            
            }
            
           
        }

    }

    public static void main(String[] args) {
        settings frame = new settings();
    }
}
