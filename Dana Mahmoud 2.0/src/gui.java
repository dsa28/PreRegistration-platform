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
    private JTextField ADMINaddUserID;
    private JTextField ADMINaddUserPassword;
    private JButton addUserButton;
    private JTextField ADMINaddUserName;
    private JComboBox ADMINuserRole;
    private JLabel ADMINisAdded;
    private JTabbedPane tabbedPane1;
    private JTextField TEACHERaddCourseName;
    private JTextField TEACHERaddCourseCapacity;
    private JTextField TEACHERaddCourseID;
    private JButton submitButton;


    private data_storage databaseConnection = new data_storage();
   //TODO: Usersystem
    // private User_System user_system = new User_St



   private user loggedInUser;



    //

    //States Tabs Indices --Not sure if needed but it does help...
    private int loginTab = 0;
    private int userBackendTab = 1;

    //Menus Tabs Indices
    //int ...


    // private UserSystem userSystem;

    //Below should include all functions to be defined and triggered upon any input being done on the form

    /*
    Things we should implement:
    1) Admin can add users -- done
    2) Teachers can add courses -- done
    3) Login as admin, teacher or student --teacher and student done, still need admin

    4) Search for courses -- partially done

    5) Students can pre-register courses
    6) Check schedules
    7) Get messages
    8) Send messages

     */

    public gui() {

        databaseConnection.addUser("Dana", 201501455, "password", "Student");
        databaseConnection.addUser("Antonio", 201402582, "password", "Student");
        databaseConnection.addUser("Fares", 20160000, "password", "Student");
        databaseConnection.addUser("Zaraket", 1, "password", "Teacher");
        databaseConnection.addUser("Karameh", 2, "password", "Teacher");
        databaseConnection.addUser("Bazzi", 3, "password", "Teacher");

        //Login State
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int userID = Integer.parseInt(userIDinput.getText());

                char[] passwordChar = passwordInput.getPassword();
                String password = new String(passwordChar);
                //boolean access = true;

                loggedInUser = databaseConnection.checkCredentials(userID,password);
                //access= databaseConnection.checkCredentials( userID, password);
                //boolean access = databaseConnection;

                if (loggedInUser !=null)
                {
                    states.setSelectedIndex(loggedInUser.getTab()); //get tab according to user type


                    loginError.setText("");
                    System.out.println("Logged In as " + userIDinput.getText());
                    System.out.println(password);

                }
                else
                {
                    loginError.setText("Wrong Credentials");
                    System.out.println("Wrong Credentials, log in unsuccessful::" + userID + ", " +password);

                }
            }
        });


        //Admin adds a user
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userName = ADMINaddUserName.getText();
                String password = ADMINaddUserPassword.getText();
                int userID = Integer.parseInt(ADMINaddUserID.getText());
                String userRole = String.valueOf(ADMINuserRole.getSelectedItem());

                boolean isAdded = databaseConnection.addUser(userName, userID, password, userRole);

                if (isAdded == true)
                {
                    ADMINisAdded.setText("User was Added");
                }
                else
                {
                    ADMINisAdded.setText("User already exists");
                }

            }
        });

        //Teacher: Add Courses
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = TEACHERaddCourseName.getText();
                String courseID = TEACHERaddCourseID.getText();
                int capacity = Integer.parseInt(TEACHERaddCourseCapacity.getText());

                Course course = new Course(courseName+courseID, capacity);

                databaseConnection.addCourse(course);

            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loggedInUser = null; //log out of logged in user
                states.setSelectedIndex(0); //go back to login screen


            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO fix this for multiple courses..
               Course course = null;

                course = databaseConnection.retrieveCourse(courseAbbreviation.getText() + enterCourseNumberTextField.getText());
                course.print();

              // while(course != null);

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
