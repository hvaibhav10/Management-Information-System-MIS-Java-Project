package missystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author DIPAK
 *
 *
 *
 */
public class login extends JFrame implements ActionListener {

    JPanel p1, p2, p3, main;
    JButton loginButton, resetButton, logo, menubar;
    Border blackline;
    ImageIcon icon;
    JLabel usernameLabel,label;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;

    public login() {

        icon = new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\login.jpeg");

        blackline = BorderFactory.createLineBorder(Color.black, 5);
        
        Color c1=Color.decode("#51087E");
        Color c2=Color.decode("#A020F0");

        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(null);
        getContentPane().setBackground(c2);
        setLocationRelativeTo(null);
        
        
        label = new JLabel(": Student Login :");
        label.setSize(480, 30);
        label.setLocation(10, 10);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));

        menubar = new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1050, 60, 60, 60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(menubar);

        p1 = new JPanel();
        p1.setLocation(50, 50);
        p1.setSize(1080, 750);
        p1.setBackground(c1);
        p1.setBorder(BorderFactory.createLineBorder(Color.black,18));
        p1.setLayout(null);
        p1.setVisible(true);

        main = new JPanel(null);
        main.setLocation(280, 50);
        main.setSize(500, 650);
        main.setBackground(Color.white);
        main.setVisible(true);
        main.setBorder(blackline);

        // Add a JLabel and a JTextField for the username
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernameLabel.setSize(400, 50);
        usernameField.setSize(400, 50);

        usernameLabel.setLocation(50, 270);
        usernameField.setLocation(50, 320);

        usernameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 25));

        main.add(usernameLabel);

        main.add(usernameField);
        
        main.add(label);

        // Add a JLabel and a JPasswordField for the password
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordLabel.setSize(400, 50);
        passwordField.setSize(400, 50);

        passwordLabel.setLocation(50, 390);
        passwordField.setLocation(50, 450);

        passwordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 25));

        main.add(passwordLabel);

        main.add(passwordField);

        // Add a JButton for the login
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
        loginButton.setSize(190, 50);
        loginButton.setLocation(50, 550);
        loginButton.addActionListener(this);

        // Add a JButton for the resetButton
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 25));
        resetButton.setSize(190, 50);
        resetButton.setLocation(260, 550);
        resetButton.addActionListener(this);

        main.add(loginButton);
        main.add(resetButton);

        p1.add(main);

        logo = new JButton(icon);
        logo.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        logo.setLocation(130, 45);
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
            new MISSYSTEM();
        }

        if (ae.getSource() == resetButton) 
        {
            usernameField.setText(null);
            passwordField.setText(null);
        }
        
        if (ae.getSource() == loginButton) {

            String username = usernameField.getText();
            System.out.println("Username: " + username);

            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            System.out.println("Password: " + password);

            try {

                ResultSet rs = null;
                Connection con = null;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis", "root", "root");
                Statement stmt;
                stmt = con.createStatement();
                String query;

                rs = stmt.executeQuery("SELECT * FROM student_login WHERE  enrollment_no ='" + username + "' AND  password ='" + password + "'");

                if (rs.next()) {

                    String us = rs.getString("enrollment_no");
                    String ps = rs.getString("password");

                    System.out.println("Username: " + us);
                    System.out.println("Password: " + ps);

                    this.setVisible(false);
                    new studentdashboard(us);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password of username");
                    usernameField.setText(null);
                    passwordField.setText(null);
                }

                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

}
