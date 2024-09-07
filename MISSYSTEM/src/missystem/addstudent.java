package missystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author DIPAK
 */
public class addstudent extends JFrame implements ActionListener {

    JLabel profile, enrollmentLabel, nameLabel, genderLabel, dobLabel, emailLabel, departmentLabel, resultLabel, attendanceLabel, marksLabel, feesLabel, addressLabel, phoneLabel;
    JTextField enrollmentField, nameField, genderField, dobField, emailField, departmentField, resultField, attendanceField, marksField, feesField, phoneField;
    JTextArea addressArea;
    JButton browseButton, saveButton, resetButton, profilepath;
    JDateChooser dobDateChooser;
    String path;

    JPanel p1, p2, p3, main, p4, p5, p6, p7, p8, p9;
    JButton loginButton, registerButton, logo,menubar;
    Border blackline;
    ImageIcon icon;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;

    JRadioButton maleRadioButton;
    JRadioButton femaleRadioButton;
    ButtonGroup genderButtonGroup;
    JRadioButton selectedButton;
    
     JOptionPane dai;

    JComboBox<String> departmentComboBox;

    public addstudent() {

        path = "C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\login.jpeg";
        
           Color c1=Color.decode("#51087E");
        Color c2=Color.decode("#A020F0");
        
//        Color c2=Color.decode("#7B3F00");
//       Color c1=Color.decode("#362624");

        blackline = BorderFactory.createLineBorder(Color.black, 18);
        TitledBorder border = BorderFactory.createTitledBorder(": ADD STUDENT INFORMATION :");
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("Arial", Font.BOLD, 25));
        border.setTitlePosition(TitledBorder.CENTER);
        border.setBorder(blackline);

        setTitle("ADDING STUDENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(null);
        getContentPane().setBackground(c2);
        setLocationRelativeTo(null);

        menubar=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1090,40,60,60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD,25));
        
        p1 = new JPanel();
        p1.setLocation(15, 15);
        p1.setSize(1150, 830);
        p1.setBackground(c1);
        p1.setBorder(border);
//         p1.setBorder(blackline);
        p1.setLayout(new GridLayout(0, 2, 20, 20));
        p1.setVisible(true);

        p2 = new JPanel();
        p2.setLocation(10, 10);
        p2.setSize(575, 830);
        p2.setBackground(c1);
//        p2.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        p2.setLayout(new GridLayout(0, 1, 10, 10));
        p2.setVisible(true);

        p3 = new JPanel();
        p3.setLocation(150, 0);
        p3.setSize(575, 830);
        p3.setBackground(c1);
//        p3.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        p3.setLayout(null);
        p3.setVisible(true);

        enrollmentLabel = new JLabel("Enrollment No.:");
        enrollmentLabel.setBackground(Color.orange);
        enrollmentLabel.setForeground(Color.white);
        enrollmentLabel.setBounds(10, 20, 100, 25);
        enrollmentLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(enrollmentLabel);

        enrollmentField = new JTextField(20);
        enrollmentField.setBounds(120, 20, 200, 25);
        enrollmentField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(enrollmentField);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 100, 25);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(120, 50, 200, 25);
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.white);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 25));

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 25));
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 25));

        genderButtonGroup = new ButtonGroup();

        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        selectedButton = null;
        if (maleRadioButton.isSelected()) {
            selectedButton = maleRadioButton;
        } else if (femaleRadioButton.isSelected()) {
            selectedButton = femaleRadioButton;
        }

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderLabel.setBounds(10, 80, 100, 25);
        p2.add(genderLabel);
        p2.add(genderPanel);

        phoneLabel = new JLabel("Phone no :");
        phoneLabel.setForeground(Color.white);
        phoneLabel.setBounds(10, 110, 100, 25);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(120, 110, 200, 25);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(phoneField);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.white);
        emailLabel.setBounds(10, 140, 100, 25);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(emailLabel);
//
        emailField = new JTextField(20);
        emailField.setBounds(120, 140, 200, 25);
        emailField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(emailField);
//
//        departmentLabel = new JLabel("Department:");
//        departmentLabel.setBounds(10, 170, 100, 25);
//        departmentLabel.setFont(new Font("Arial", Font.PLAIN,25));
//        p2.add(departmentLabel);
//

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setForeground(Color.white);
        departmentLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        String[] departmentOptions = {"Computer Science", "Electronics", "Mechanical", "Civil"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(departmentLabel);
        p2.add(departmentComboBox);

//        departmentField = new JTextField(20);
//        departmentField.setBounds(120, 170, 200, 25);
//        departmentField.setFont(new Font("Arial", Font.PLAIN,25));
//        p2.add(departmentField);
//
        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.white);
        resultLabel.setBounds(10, 200, 100, 25);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(resultLabel);

        resultField = new JTextField(20);
        resultField.setBounds(120, 200, 200, 25);
        resultField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(resultField);

        attendanceLabel = new JLabel("Attendance:");
        attendanceLabel.setForeground(Color.white);
        attendanceLabel.setBounds(10, 230, 100, 25);
        attendanceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(attendanceLabel);

        attendanceField = new JTextField(20);
        attendanceField.setBounds(120, 230, 200, 25);
        attendanceField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(attendanceField);

        marksLabel = new JLabel("Marks:");
        marksLabel.setForeground(Color.white);
        marksLabel.setBounds(10, 260, 100, 25);
        marksLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(marksLabel);

        marksField = new JTextField(20);
        marksField.setBounds(120, 260, 200, 25);
        marksField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(marksField);

        profile = new JLabel("CHOOSE PROFILE :");
        profile.setForeground(Color.white);
        profile.setBounds(10, 50, 400, 50);
        profile.setFont(new Font("Arial", Font.BOLD, 25));

        profilepath = new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\login.jpeg"));
        profilepath.setBounds(200, 120, 200, 200);
        profilepath.setEnabled(true);
        profilepath.setFont(new Font("Arial", Font.PLAIN, 25));

        browseButton = new JButton("Upload");
        browseButton.setBounds(250, 340, 100, 25);
        browseButton.addActionListener(this);

        addressLabel = new JLabel("Address :");
        addressLabel.setForeground(Color.white);
        addressLabel.setBounds(10, 360, 200, 100);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 25));

        addressArea = new JTextArea();
        addressArea.setBounds(30, 440, 500, 200);
        addressArea.setFont(new Font("Arial", Font.PLAIN, 25));
        addressArea.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

        saveButton = new JButton("SAVE");
        saveButton.setBounds(50, 700, 200, 50);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        saveButton.addActionListener(this);

        resetButton = new JButton("RESET");
        resetButton.setBounds(300, 700, 200, 50);
        resetButton.setFont(new Font("Arial", Font.PLAIN, 25));
        resetButton.addActionListener(this);

        p3.add(profile);
        p3.add(profilepath);
        p3.add(browseButton);
        p3.add(addressLabel);
        p3.add(addressArea);
        p3.add(saveButton);
        p3.add(resetButton);

        p1.add(p2);
        p1.add(p3);
        this.add(menubar);
        add(p1);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == browseButton) {

            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                profilepath.setIcon(new ImageIcon(path));
                // Do something with the selected file path
            } else if (result == JFileChooser.CANCEL_OPTION) {
                // User clicked the "Cancel" button
            }
        }

        
        if(ae.getSource() == resetButton)
        {
                enrollmentField.setText(null);
                nameField.setText(null);
                emailField.setText(null);
                resultField.setText(null);
               attendanceField.setText(null);
                marksField.setText(null);
                phoneField.setText(null);
                addressArea.setText(null);
                path = "C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\login.jpeg";
               profilepath.setIcon(new ImageIcon(path));
              
        }
        
        if (ae.getSource() == saveButton) {

            System.out.println("clicked");
            


            try {
                ResultSet rs = null;
                Connection con = null;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis", "root", "root");
                Statement stmt;
                stmt = con.createStatement();

                String enrollmentQ = null, nameQ = null, genderQ = null, dobQ = null, emailQ = null, departmentQ = null, resultQ = null, attendanceQ = null, marksQ = null, feesQ = null, phoneQ = null, addressQ = null;

                JRadioButton selectedButton = null;
                if (maleRadioButton.isSelected()) {
                    selectedButton = maleRadioButton;
                } else if (femaleRadioButton.isSelected()) {
                    selectedButton = femaleRadioButton;
                }
                if (selectedButton != null) {
                    genderQ = selectedButton.getText();
                }

                enrollmentQ = enrollmentField.getText();
                int en = 0;
                en = Integer.parseInt(enrollmentQ);
                nameQ = nameField.getText();
                emailQ = emailField.getText();
                resultQ = resultField.getText();
                attendanceQ = attendanceField.getText();
                marksQ = marksField.getText();
                phoneQ = phoneField.getText();
                addressQ = addressArea.getText();
                departmentQ = (departmentComboBox.getSelectedItem()).toString();

                System.out.println("" + enrollmentQ);
                System.out.println("" + nameQ);
                System.out.println("" + emailQ);
                System.out.println("" + resultQ);
                System.out.println("" + attendanceQ);
                System.out.println("" + marksQ);
                System.out.println("" + phoneQ);
                System.out.println("" + departmentQ);
                System.out.println("" + addressQ);
                System.out.println("" + genderQ);

                System.out.println("" + path);

               dai=new JOptionPane();
                 dai.setPreferredSize(new Dimension(400, 400)); 
                 
                 boolean b=true;
                 
                 
                 if(en == 0 || nameQ.isEmpty() || genderQ.isEmpty() || emailQ.isEmpty() ||departmentQ.isEmpty() || resultQ.isEmpty() || attendanceQ.isEmpty() || marksQ.isEmpty() || phoneQ.isEmpty() ||addressQ.isEmpty() )
                 {
                     b=false;
                             
                             
                 }
                 
                 
                  
                
                if (b) {

                    stmt.executeUpdate("INSERT INTO student_info (enrollmentno, name, gender, phone, email,department, result, attendence, marks, profilepath, address) VALUES (" + en + ", '" + nameQ + "', '" + genderQ + "', '" + phoneQ + "', '" + emailQ + "','" + departmentQ + "', '" + resultQ + "', '" + attendanceQ + "', '" + marksQ + "', '" + path + "', '" + addressQ + "')");
                    
                    String temp_ps="System@123";
                    
                    stmt.executeUpdate("INSERT INTO student_login(enrollment_no, name, password)VALUES('" +enrollmentQ+ "',  '" + nameQ + "',  '" + temp_ps + "')");
                    dai.showMessageDialog(null, "Information Saved Succesfully!");
                    this.setVisible(false);
                    new studentpanel();
                   
                     

                }
                else 
                {
                    dai.showMessageDialog(null, "Fill all the Fields!");
                    
                }

                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
                dai.showMessageDialog(null, ""+e);
            }
        }

         if (ae.getSource() == menubar) {
            this.setVisible(false);
            new studentpanel();
        }
        
    }

    public static void main(String[] args) {
        addstudent frame = new addstudent();
    }

    private void setBorder(TitledBorder titledBorder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
