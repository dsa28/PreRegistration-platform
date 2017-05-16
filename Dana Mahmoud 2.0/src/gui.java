import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    private JTextField enterCourseNameTextField;
    private JButton searchCourseButton;

    private JButton STUDENTlogoutButton;
    private JList list3;
    private JTextField receiverUsernameTextField;
    private JTextPane textPane1;
    private JButton sendMessageButton;
    private JList searchResults;
    private JButton addCourseButton;
    private JList STUDENTschedule;
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
    private JTextField TEACHERaddCourseTimeTill;
    private JTextField TEACHERaddCourseTimeFrom;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JButton TEACHERlogoutButton;
    private JButton ADMINlogoutButton;
    private JCheckBox TEACHERaddCourseIsVoted;
    private JList TEACHERcoursesManager;
    private JButton deleteButton;
    private JButton setButton;
    private JList TEACHERrequests;
    private JButton approveButton;
    private JButton rejectButton;
    private JButton refreshButton;
    private JButton refreshRequestsButton;
    private JCheckBox saturdayCheckBox;
    private JButton refreshScheduleButton;
    private JButton removeCoursesButton;
    private JTextField requestTeacherID;
    private JTextField requestCourseName;
    private JTextField requestNote;
    private JButton sendRequestButton;
    private JList requestStatistics;
    private JButton refreshStatisticsButton;


    private data_storage databaseConnection = new data_storage();
    private RequestClient requestClient = new RequestClient();



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

                //TODO: Uncomment, and fix.
                //Course course = new Course(courseName+courseID, capacity);

                //databaseConnection.addCourse(course);

            }
        });

        //Logout Actions:
        //Teacher
        TEACHERlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logging out as null
                loggedInUser = null;
                states.setSelectedIndex(0);

            }
        });

        //Admin
        ADMINlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logging out as null
                loggedInUser = null;
                states.setSelectedIndex(0);

            }
        });
        STUDENTlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logging out as null
                loggedInUser = null;
                states.setSelectedIndex(0);
            }
        });

        //Teacher adds a course (either to be set or asked to be voted on).
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = TEACHERaddCourseName.getText();
                int capacity = Integer.parseInt(TEACHERaddCourseCapacity.getText());
                int timeFrom = Integer.parseInt(TEACHERaddCourseTimeFrom.getText());
                int timeTill = Integer.parseInt(TEACHERaddCourseTimeTill.getText());

                ArrayList<Boolean> days = new ArrayList<Boolean>();
                days.add(mondayCheckBox.isSelected());
                days.add(tuesdayCheckBox.isSelected());
                days.add(wednesdayCheckBox.isSelected());
                days.add(thursdayCheckBox.isSelected());
                days.add(fridayCheckBox.isSelected());
                days.add(saturdayCheckBox.isSelected());

                boolean needsVoting = TEACHERaddCourseIsVoted.isSelected();

                //TODO: Add to courses list.



            }
        });


        //Teacher Course Manager
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Get all courses added
                //TEACHERcoursesManager.setListData( [A list here should be inserted] );

            }
        });

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List listOfCourses = TEACHERcoursesManager.getSelectedValuesList();
                //TODO: For every course in the above list, set the course (not voted on anymore)
                // (This probably needs a new member in the course class).


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List listOfCourses = TEACHERcoursesManager.getSelectedValuesList();
                //TODO: Delete the course from the Teacher's courses using the above list
            }
        });

        //Teacher's Requests
        //Note: Usually new requests are pending
        //Mahmoud:: Will create a new class "request" :: Done.
        refreshRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get requests sent from students to the teacher
                ArrayList<Request> requests = requestClient.getRequestsForTeacher(loggedInUser.getId());

                Vector<String> requestStrings = new Vector<>();
                for (Request r: requests) {
                    requestStrings.add( r.getRequestID() + "::["+ r.getState() + "] From: " + r.getStudentID() + ", Course: " + r.getCourseName() +
                    ", Request Note: " + r.getRequestText());
                }

                TEACHERcoursesManager.setListData(requestStrings);

            }
        });
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List listOfCourses =  TEACHERcoursesManager.getSelectedValuesList();
                //Approve the above requests
                String req;
                for (Object request:
                     listOfCourses) {

                    req = (String) request;
                    req = req.substring(0, req.indexOf("::"));

                    requestClient.approveCourse(Integer.parseInt(req));


                }
            }
        });
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List listOfCourses = TEACHERcoursesManager.getSelectedValuesList();
                //Reject the above requests
                String req;
                for (Object request:
                        listOfCourses) {

                    req = (String) request;
                    req = req.substring(0, req.indexOf("::"));

                    requestClient.rejectCourse(Integer.parseInt(req));


                }
            }
        });

        //Request Statistics
        refreshStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> courses = new Vector<>();
                Vector<Integer> count = new Vector<Integer>();

                ArrayList<Request> requests = requestClient.getRequestsForTeacher(loggedInUser.getId());

                for (Request r:
                     requests) {

                    if(!courses.contains(r.getCourseName()))
                    {
                        courses.add(r.getCourseName());
                        count.add(1);
                    }
                    else
                    {
                     count.set(courses.indexOf(r.getCourseName()), count.get(courses.indexOf(r.getCourseName())) + 1);
                    }

                }

                Vector <String> coursesStrings = new Vector<>();
                for (int i = 0; i < courses.size(); i++){

                    coursesStrings.add(courses.get(i) + ": " +count.get(i) + " requests.");
                }

                requestStatistics.setListData(coursesStrings);

            }
        });

        //Student Schedule
        refreshScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Get all courses from student's schedule
                Vector<String> courses = new Vector<>();
                //Get Courses, and add them to courses

                //TODO:Put the strings into courses in this format:
                //foreach..
                //{
                //courses.add(courseName + ": @" + courseTime + " " + courseDates + " in " + room + " [" + teacherName +"] [Status:" + isConflict +"]");
                //}

                //STUDENTschedule.setListData(courses);
            }
        });

        removeCoursesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Remove courses from student
                List listOfCourses =  STUDENTschedule.getSelectedValuesList();
                //Approve the above requests
                String c;
                for (Object course:
                        listOfCourses) {

                    c = (String) course;
                    c = c.substring(0, c.indexOf(": @"));

                    //remove course from student schedule having name c


                }

            }
        });

        //TODO:Courses Search
        searchCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = enterCourseNameTextField.getText();
                //TODO: Get all courses with search term
                Vector<String> courses = new Vector<>();
                //Get Courses, and add them to courses

                //TODO:Put the strings into courses in this format:
                //foreach..
                //{
                //courses.add(courseName + ": @" + courseTime + " " + courseDates + " in " + room + " [" + teacherName +"] [Status:" + isConflict +"]");
                //}

                searchResults.setListData(courses);


            }
        });

        //TODO:Add course to student schedule
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List listOfCourses =  searchResults.getSelectedValuesList();
                //Approve the above requests
                String c;
                for (Object course:
                        listOfCourses) {

                    c = (String) course;
                    c = c.substring(0, c.indexOf(": @"));

                    //TODO:add courses to schedule of name c


                }


            }

        });

        //Student Requests
        sendRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int teacherID = Integer.parseInt(requestTeacherID.getText());
                String courseName = requestCourseName.getText();
                String note = requestNote.getText();
                int studentID = loggedInUser.getId();

                requestClient.sendRequest(teacherID, studentID, courseName, note);


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
