import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
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
    private JComboBox TEACHERfromHrs;
    private JComboBox TEACHERfromMins;
    private JComboBox TEACHERtillHrs;
    private JComboBox TEACHERtillMins;


    private data_storage databaseConnection = new data_storage();
    private RequestClient requestClient = new RequestClient();



    private user loggedInUser;


    //Not used?
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

    9) Request courses -- done
    10) Approve/reject courses --done
    11) Check requests -- done
     */

    //Helper functions to avoid duplicate code
    public void logout()
    {
        loggedInUser = null; //No longer a logged in user
        states.setSelectedIndex(0); //go back to login screen
    }

    public void approveCourse(boolean param)
    {

        List listOfCourses = TEACHERrequests.getSelectedValuesList();
        //Reject the above requests
        String req;

        for (Object request: listOfCourses) {

            req = (String) request;
            req = req.substring(0, req.indexOf("::"));

            if (param)
            {
                requestClient.approveCourse(Integer.parseInt(req));
            }
            else
            {
                requestClient.rejectCourse(Integer.parseInt(req));
            }


        }


    }





    public gui() {



        //Already saved data
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


                if (databaseConnection.addUser(userName, userID, password, userRole))
                {
                    ADMINisAdded.setText("User was Added");
                }
                else
                {
                    ADMINisAdded.setText("User already exists");
                }

            }
        });


        //Logout Actions:
        //Teacher
        TEACHERlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               logout();

            }
        });

        //Admin
        ADMINlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logging out as null
               logout();

            }
        });
        STUDENTlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                logout();

            }
        });


        //Teacher adds a course (either to be set or asked to be voted on).
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String courseName = TEACHERaddCourseName.getText();
                int capacity = Integer.parseInt(TEACHERaddCourseCapacity.getText());
                int timeFromHour = Integer.parseInt(String.valueOf(TEACHERfromHrs.getSelectedItem()));
                int timeFromMinutes = Integer.parseInt(String.valueOf(TEACHERfromMins.getSelectedItem()));
                int timeTillHour = Integer.parseInt(String.valueOf(TEACHERtillHrs.getSelectedItem()));
                int timeTillMinutes = Integer.parseInt(String.valueOf(TEACHERtillMins.getSelectedItem()));

                ArrayList<Boolean> days = new ArrayList<Boolean>();
                days.add(mondayCheckBox.isSelected());
                days.add(tuesdayCheckBox.isSelected());
                days.add(wednesdayCheckBox.isSelected());
                days.add(thursdayCheckBox.isSelected());
                days.add(fridayCheckBox.isSelected());
                days.add(saturdayCheckBox.isSelected());

                boolean needsVoting = TEACHERaddCourseIsVoted.isSelected();

                Course course = new Course(courseName);
                course.increaseCapacity(capacity);

                course.setTeacher((Teacher)loggedInUser);
                //Because teacher tab is only accessible to teachers, loggedInUser is necessarily a teacher


                ScheduleElement time;

                int i =0;
                for (Day d: Day.values())
                {
                    if (days.get(i)) //course offered this day
                    {
                        time = new ScheduleElement(); //store timing in a schedule element
                        time.setStartTime(timeFromHour,timeFromMinutes);
                        time.setEndTime(timeTillHour, timeTillMinutes);
                        time.setDay(d);

                        course.addTiming(time); //add timing
                    }
                }


                course.print();

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
        refreshRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get requests sent from students to the teacher


                DefaultListModel model = new DefaultListModel();

                requestClient.start();
                Request r = requestClient.getNextRequest(loggedInUser);;


              while(r!= null) {

                  model.addElement(r.toString());
                  r = requestClient.getNextRequest(loggedInUser);

                }


                TEACHERrequests.setModel(model);
                TEACHERrequests.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                TEACHERrequests.setVisible(true);



            }
        });


        //Approve a course
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                approveCourse(true);
            }
        });


        //Reject a course
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                approveCourse(false);
            }
        });




        //Request Statistics
        refreshStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> courses = new Vector<>();
                Vector<Integer> count = new Vector<Integer>();

              /*)  ArrayList<Request> requests = requestClient.getRequestsForTeacher(loggedInUser.getId());

                for (Request r: requests) {

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
*/
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
