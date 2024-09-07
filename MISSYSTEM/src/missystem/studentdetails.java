package missystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DIPAK
 */
public class studentdetails extends JFrame implements ActionListener {

    JLabel profile, enrollmentLabel, nameLabel, genderLabel, dobLabel, emailLabel, departmentLabel, resultLabel, attendanceLabel, marksLabel, feesLabel, addressLabel, phoneLabel;
    JTextField enrollmentField, nameField, genderField, dobField, emailField, departmentField, resultField, attendanceField, marksField, feesField, phoneField;
    JTextArea addressArea;
    JButton browseButton, saveButton, editButton,deleteButton, profilepath,menubar;
    JDateChooser dobDateChooser;
    String path;

    JPanel p1, p2, p3, main, p4, p5, p6, p7, p8, p9;
    JButton loginButton, registerButton, logo;
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
    
    int en2;

    public studentdetails(int en) {
        
        Color c2=Color.decode("#7B3F00");
       Color c1=Color.decode("#362624");
        
        en2=en;

        blackline = BorderFactory.createLineBorder(Color.black,18);
        TitledBorder border = BorderFactory.createTitledBorder(": STUDENT INFORMATION :");
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("Arial", Font.BOLD, 25));
        border.setTitlePosition(TitledBorder.CENTER);
        border.setBorder(blackline);

        
          menubar=new JButton(new ImageIcon("C:\\Users\\DIPAK\\Desktop\\MIS\\pic\\back.jpeg"));
        menubar.setBackground(Color.yellow);
        menubar.setBounds(1090,40,60,60);
        menubar.addActionListener(this);
        menubar.setFont(new Font("Arial", Font.BOLD,25));
        this.add(menubar);
        
        setTitle("STUDENT DETAILS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(null);
        getContentPane().setBackground(c2);
        setLocationRelativeTo(null);

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
        departmentLabel.setFont(new Font("Arial", Font.BOLD, 25));
        String[] departmentOptions = {"Computer Science", "Electronics", "Mechanical", "Civil"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
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
        profile.setForeground(Color.WHITE);
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
        saveButton.setBounds(30, 700, 150, 50);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        saveButton.addActionListener(this);

        editButton = new JButton("EDIT");
        editButton.setBounds(210, 700, 150, 50);
        editButton.setFont(new Font("Arial", Font.PLAIN, 25));
        editButton.addActionListener(this);
        
        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(380, 700, 150, 50);
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 25));
        deleteButton.addActionListener(this);

        
        

        p3.add(profile);
        p3.add(profilepath);
        p3.add(browseButton);
        p3.add(addressLabel);
        p3.add(addressArea);
        p3.add(saveButton);
        p3.add(editButton);
        p3.add(deleteButton);

        p1.add(p2);
        p1.add(p3);
        add(p1);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                browseButton.setVisible(false);
                try {

                    ResultSet rs = null;
                    Connection con = null;
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis", "root", "root");
                    Statement stmt;
                    stmt = con.createStatement();
                    String query;

                    rs = stmt.executeQuery("SELECT * FROM student_info WHERE  enrollmentno =" + en + "");

                    if (rs.next()) {

                        int en = rs.getInt("enrollmentno");

                        String name = rs.getString("name");
                        String department = rs.getString("department");

                        enrollmentField.setText("" + rs.getInt("enrollmentno"));
                        nameField.setText(rs.getString("name"));
                        emailField.setText(rs.getString("email"));
                        resultField.setText(rs.getString("result"));
                        attendanceField.setText(rs.getString("attendence"));
                        marksField.setText(rs.getString("marks"));
                        phoneField.setText(rs.getString("phone"));
                        addressArea.setText(rs.getString("address"));
                        profilepath.setIcon(new ImageIcon(rs.getString("profilepath")));

                        if (rs.getString("gender").equals("Male")) {
                            maleRadioButton.setSelected(true);

                        } else {
                            femaleRadioButton.setSelected(true);

                        }

                        if (rs.getString("department").equals("Computer Science")) {
                            departmentComboBox.setSelectedItem("Computer Science");
                        } else if (rs.getString("department").equals("Electronics")) {
                            departmentComboBox.setSelectedItem("Electronics");
                        } else if (rs.getString("department").equals("Mechanical")) {
                            departmentComboBox.setSelectedItem("Mechanical");
                        } else {
                            departmentComboBox.setSelectedItem("Civil");
                        }

                        System.out.println("Window opened");
                        enrollmentField.setEditable(false);
                        nameField.setEditable(false);
                        emailField.setEditable(false);
                        resultField.setEditable(false);
                        attendanceField.setEditable(false);
                        marksField.setEditable(false);
                        phoneField.setEditable(false);
                        addressArea.setEditable(false);
                        departmentComboBox.setEditable(false);
                        maleRadioButton.setEnabled(false);
                        femaleRadioButton.setEnabled(false);

                    }

                    stmt.close();
                    con.close();

                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println(ex);
                }

//             end   
            }
        });

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == editButton) {
            enrollmentField.setEditable(true);
            nameField.setEditable(true);
            emailField.setEditable(true);
            resultField.setEditable(true);
            attendanceField.setEditable(true);
            marksField.setEditable(true);
            phoneField.setEditable(true);
            addressArea.setEditable(true);
            departmentComboBox.setEditable(true);
            maleRadioButton.setEnabled(true);
            femaleRadioButton.setEnabled(true);
            browseButton.setVisible(true);

        }
        
        if (ae.getSource() == saveButton) 
        {
        
            try{
        
        ResultSet rs = null;
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis","root","root"); 
        Statement stmt;
        stmt = con.createStatement();
        String query;
 
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
                 
                 boolean b=false;
                 
                 if(en != 0 && nameQ != null)
                 {  
                    
                     if(genderQ != null && dobQ == null)
                     {
                         if(emailQ != null && departmentQ != null)
                         {
                             if(resultQ != null && attendanceQ != null)
                             {
                             
                                 if(marksQ != null && feesQ == null)
                                 {
                                     if(phoneQ != null && addressQ != null)
                                     {
                                         b=true;
                                           System.out.println("true in");
                                     }
                                 }
                             }
                         }
                     }
                 }
                
                if (b) {

                  
                        
                       stmt.executeUpdate("UPDATE student_info SET name = '" + nameQ + "',gender = '" + genderQ + "',phone = '" + phoneQ + "',email = '" + emailQ + "',department = '" + departmentQ + "',result = '" + resultQ + "',attendence = '" + attendanceQ + "',marks = '" + marksQ + "',profilepath = '" + path + "',address='" + addressQ + "' WHERE enrollmentno = " + en + "");

//                       stmt.executeUpdate("UPDATE student_login SET name = '" + nameQ + "',password  = '" + nameQ +"' WHERE enrollment_no =' " + en + "");

                    
                    dai.showMessageDialog(null, "Information Updated Succesfully!");
                    this.setVisible(false);
                    new studentpanel();
                   
                    
                }
                else 
                {
                    dai.showMessageDialog(null, "Fill all the Fields!");
                    
                }
        
        
        
        
        stmt.close();
        con.close();
        
        
        }
        catch(ClassNotFoundException | SQLException e){ System.out.println(e);}
        }
        
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
        
        
        if (ae.getSource() == deleteButton) {
        
             try{
        
        ResultSet rs = null;
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/mis","root","root"); 
        Statement stmt;
        stmt = con.createStatement();
        String query;
 
       
         stmt.executeUpdate("DELETE FROM student_info WHERE enrollmentno = " +en2+ "");
         dai.showMessageDialog(null, "Information Deleted Succesfully!");
        this.setVisible(false);
        new studentpanel();


        
        
        stmt.close();
        con.close();
        
        
        }
        catch(ClassNotFoundException | SQLException e){ System.out.println(e);}
        }
        
         if (ae.getSource() == menubar) {
            this.setVisible(false);
            new studentpanel();
        }
    }

    public static void main(String[] args) {
        studentdetails frame = new studentdetails(2);
    }

}
