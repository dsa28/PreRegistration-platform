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
    private ddb databaseConnection = new ddb();
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


    public gui() {


        //Login State
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int userID = Integer.parseInt(userIDinput.getText());

                char[] passwordChar = passwordInput.getPassword();

                String password = new String(passwordChar);


                boolean access = databaseConnection.checkCredentials( userID, password);

                if (access == true)
                {
                    //TODO: User details should be added;
                    String name;
                    int id;
                    String role;
                    loggedInUser = new user();
                    if( role == "Student") {
                        states.setSelectedIndex(1);
                    }
                    else if (role == "Teacher")
                    {
                        states.setSelectedIndex(2);
                    }
                    else if (role == "Admin")
                    {
                        states.setSelectedIndex(3);
                    }
                    else
                    {
                        //Impossible
                    }

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
