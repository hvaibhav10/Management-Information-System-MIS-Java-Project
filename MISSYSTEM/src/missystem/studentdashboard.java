
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
public class studentdashboard extends JFrame implements ActionListener {

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
    int en;

    public studentdashboard(String s) {
        en=en2=Integer.parseInt(s);
      
         Color c2=Color.decode("#7B3F00");
       Color c1=Color.decode("#362624");
       
       
       
//        Color c1=Color.decode("#51087E");
//        Color c2=Color.decode("#A020F0");

        blackline = BorderFactory.createLineBorder(Color.black, 18);
        TitledBorder border = BorderFactory.createTitledBorder(": STUDENT INFORMATION :");
        border.setTitleColor(Color.white);
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
        enrollmentLabel.setForeground(Color.white);
        enrollmentLabel.setBackground(Color.orange);
        enrollmentLabel.setBounds(10, 20, 100, 25);
        enrollmentLabel.setFont(new Font("Arial", Font.BOLD, 25));
        p2.add(enrollmentLabel);

        enrollmentField = new JTextField(20);
        enrollmentField.setBounds(120, 20, 200, 25);
        enrollmentField.setFont(new Font("Arial", Font.PLAIN, 25));
        p2.add(enrollmentField);

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(10, 50, 100, 25);
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

        

        
        

        p3.add(profile);
        p3.add(profilepath);
        p3.add(browseButton);
        p3.add(addressLabel);
        p3.add(addressArea);
       

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
       
         if(ae.getSource()== menubar)
    {
            this.setVisible(false);
            new login();
    }
    }

    public static void main(String[] args) {
       studentdashboard frame = new studentdashboard("197004");    }

}
