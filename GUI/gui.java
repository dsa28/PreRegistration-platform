import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import java.util.Vector;

/**
 * Created by mahmoudsafar on 4/17/17.
 */
public class gui {
    private JTextField usernameInput;
    private JPanel form;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JLabel errorLabel;
    private JTabbedPane states;
    private JTabbedPane menu;
    private JTextField enterCourseNumberTextField;
    private JTextField courseAbbreviation;
    private JButton searchButton;

    private JList list1;
    private JButton logoutButton;
    private JLabel loggedInAsUsernameLabel;
    private JLabel statistic1Label;
    private JLabel statistic2Label;
    private JList list2;
    private JList list3;
    private JTextField receiverUsernameTextField;
    private JTextPane textPane1;
    private JButton sendMessageButton;
    private JList list4;
    private JButton registerButton;
    private JList list5;


    //Demo Variables
    public String usernameStudent = "Mariam Jeha";
    int studentCourseCount = 3;
    int studentCoursesTakenCount = 4;
    Vector<String> studentCourses = new Vector<String>(1);



    //

    //States Tabs Indices --Not sure if needed but it does help...
    private int loginTab = 0;
    private int userBackendTab = 1;

    //Menus Tabs Indices
    //int ...


    // private UserSystem userSystem;

    //Below should include all functions to be defined and triggered upon any input being done on the form


    public gui() {
        //Demo Purposes

        studentCourses.add("ACCT 210 -------- Malik -------- MWF 11->12 -------- Cap: 15/30");
        studentCourses.add("Fina 210 -------- Lama -------- TR 1->12:30 -------- Cap: 30/30");
        studentCourses.add("Math 201 -------- Jack -------- MWF 9->10 -------- Cap: 20/40");
        studentCourses.add("Math 210 -------- Bassam -------- TR 9->10 -------- Cap: 38/40");

        //Dashboard
        loggedInAsUsernameLabel.setText("Welcome, " + usernameStudent);
        statistic1Label.setText("Number of Current Courses: " + String.valueOf(studentCourseCount));
        statistic2Label.setText(String.valueOf("Number of Courses Taken So Far: " +studentCoursesTakenCount));
        list5.setListData(studentCourses);


        //Messages
        final String[] inbox = {"New Course: EECE 437 | From: Fadi Z. | Content: Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                "New Course: EECE 430 | From: Nadia M. | Content: Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                "New Course: EECE 503X | From: Wassim M. | Content: Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                "New Course: EECE 550 | From: Maria K. | Content: Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                "New Course: EECE 100 | From: Alia K. | Content: Lorem ipsum dolor sit amet, consectetur adipiscing elit. "};


        list3.setListData(inbox);





        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CHeck if credentials are correct and login
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logout and go back to login screen
                
        }});

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get Courses by interfacing with DB

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add to courses

            
            }
        });
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Message Sent!
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(new gui().form);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
