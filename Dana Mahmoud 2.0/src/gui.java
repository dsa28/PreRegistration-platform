import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by mahmoudsafar on 4/17/17.
 */
public class gui {
    private JTextField userIDinput;
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
    private JLabel loginError;
    private JTextField textField1;
    private ddb databaseConnection = new ddb();

    //Demo Variables
    public String usernameStudent = "Mariam Jeha";
    int studentCourseCount = 3;
    int studentCoursesTakenCount = 4;
    Vector<String> studentCourses = new Vector<String>(1);

    String toNJA;






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





        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                states.setSelectedIndex(0);
                if (userIDinput.getText() == "nja10")
                {
                    inbox[0] = toNJA;

                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] geolCourses = {"GEOL 205 -------- Raghida -------- MWF 12->1 -------- Cap: 21/30", "GEOL 205 -------- Raghida -------- MWF 1->2 -------- Cap: 10/30"};

                list4.setListData(geolCourses);

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add to courses

                if(list4.getSelectedValue() == "GEOL 205 -------- Raghida -------- MWF 12->1 -------- Cap: 21/30") {
                    studentCourses.add("GEOL 205 -------- Raghida -------- MWF 12->1 -------- Cap: 22/30");
                    list5.setListData(studentCourses);
                }


            }
        });
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toNJA = textPane1.getText();
                textPane1.setText("Message Sent Successfully!");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int userID = Integer.parseInt(userIDinput.getText());

                char[] passwordChar = passwordInput.getPassword();

                String password = new String(passwordChar);

                System.out.println(password);


                boolean access = databaseConnection.checkCredentials( userID, password);

                if (access == true)
                {
                    states.setSelectedIndex(1);
                    loginError.setText("");
                    System.out.println("Logged In as " + userIDinput.getText());
                    System.out.println(password);
                }
                else
                {
                    loginError.setText("Wrong Credentials");
                    System.out.println("Wrong Credentials, log in unsuccessful");

                }
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
