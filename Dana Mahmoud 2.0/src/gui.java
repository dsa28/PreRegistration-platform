import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
    private JList STUDENTinbox;
    private JTextField receiverIDTextField;
    private JTextPane STUDENTmessageContent;
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
    private JTabbedPane tabbedPane2;
    private JList ADMINcourses;
    private JList ADMINrooms;
    private JButton assignRoomButton;
    private JButton refreshButton1;
    private JButton refreshButton2;
    private JButton refreshRequestsButton1;
    private JList sentRequests;


    private data_storage databaseConnection = new data_storage();
    private RequestClient requestClient = new RequestClient();
    private MessageClient messageClient = new MessageClient();



    private user loggedInUser;


    //Not used?
    // private UserSystem userSystem;

    //Below should include all functions to be defined and triggered upon any input being done on the form

    /*
    Things we should implement:
    1) Admin can add users -- done
    2) Teachers can add courses -- done
    3) Login as admin, teacher or student -- done

    4) Search for courses --  done

    5) Students can pre-register courses --done
    6) Check schedules  -- done
    7) Get messages
    8) Send messages

    9) Request courses -- done
    10) Approve/reject courses --done
    11) Check requests -- done

    12) Teachers add new course -- done
    13) Students remove course -- done
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
                String courseName = requestClient.getNextRequest(Integer.parseInt(req)).getCourseName();
                Course c = databaseConnection.retrieveCourse(courseName);
                loggedInUser.addcourse(c);


            }
            else
            {
                requestClient.rejectCourse(Integer.parseInt(req));
            }


        }


    }

    void schedule(JList list) //displays schedule for students or teachers
    {
        DefaultListModel model = new DefaultListModel();

        loggedInUser.getSchedule().start();
        ScheduleElement r = loggedInUser.getSchedule().getElement();


        while(r!= null) {

            model.addElement(r.toString());
            r = loggedInUser.getSchedule().getElement();

        }


        list.setModel(model);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisible(true);

    }


    //helper function to get all courses with the name "search"
    //or all courses if search is left blank
    DefaultListModel getCourse(String search)
    {

        DefaultListModel model = new DefaultListModel();

        databaseConnection.start();
        Course c = databaseConnection.retrieveCourse(search);


        while(c!= null) {

            model.addElement(c.toString());
            c = databaseConnection.retrieveCourse(search);

        }

        return model;

    }



    public gui() {



        //Already saved data
        databaseConnection.addUser("Dana", 201501455, "password", "Student");
        databaseConnection.addUser("Antonio", 201402582, "password", "Student");
        databaseConnection.addUser("Fares", 20160000, "password", "Student");
        databaseConnection.addUser("Zaraket", 1, "password", "Teacher");
        databaseConnection.addUser("Karameh", 2, "password", "Teacher");
        databaseConnection.addUser("Bazzi", 3, "password", "Teacher");

        databaseConnection.addUser("Admin",0,"password", "Admin");

        Course Math227 = new Course("MATH 227",20);
        Course Math251 = new Course("MATh 251",40);
        Course Math210 = new Course("MATH 210",20);
        Course EECE437 = new Course("EECE 437",15);

        ScheduleElement time1 = new ScheduleElement();
        ScheduleElement time2;
        ScheduleElement time3;

        time1.setStartTime(10,00);
        time1.setEndTime(10,50);

        time1.setDay(Day.Monday);

        time2 = time1.clone();
        time2.setDay(Day.Wednesday);

        time3 = time1.clone();
        time3.setDay(Day.Friday);

        EECE437.addTiming(time1);
        EECE437.addTiming(time2);
        EECE437.addTiming(time3);

        Math210.addTiming(time1);
        Math210.addTiming(time2);
        Math210.addTiming(time3);

        time1.setTime(12,00);
        time2.setTime(12,00);
        time3.setTime(12,00);

        Math227.addTiming(time1);
        Math227.addTiming(time2);
        Math227.addTiming(time3);

        databaseConnection.addCourse(Math227);
        databaseConnection.addCourse(Math251);
        databaseConnection.addCourse(Math210);
        databaseConnection.addCourse(EECE437);

        Room.getRoom("Nicely 224");
        Room.getRoom("Bechtel 111");
        Room.getRoom("WHCR");
        Room.getRoom("Fisk 321");
        Room.getRoom("Bechtel 110");
        Room.getRoom("Nicely 220");



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
                    userIDinput.setText("");
                    passwordInput.setText("");

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
                    ADMINaddUserName.setText("");
                    ADMINaddUserPassword.setText("");
                    ADMINaddUserID.setText("");
                    ADMINuserRole.setSelectedIndex(0);
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

                Object[] clear = {};
                TEACHERcoursesManager.setListData(clear);
                TEACHERrequests.setListData(clear);
                requestStatistics.setListData(clear);
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


                Object[] clear = {};

                STUDENTschedule.setListData(clear);
                searchResults.setListData(clear);
                sentRequests.setListData(clear);

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

                days.add(false); //No courses on sunday, its always false
                days.add(mondayCheckBox.isSelected());
                days.add(tuesdayCheckBox.isSelected());
                days.add(wednesdayCheckBox.isSelected());
                days.add(thursdayCheckBox.isSelected());
                days.add(fridayCheckBox.isSelected());
                days.add(saturdayCheckBox.isSelected());

                boolean needsVoting = TEACHERaddCourseIsVoted.isSelected();


                Course course = new Course(courseName);
                course.increaseCapacity(capacity);

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

                    i++;
                }


                if (course.setTeacher((Teacher)loggedInUser))//Because teacher tab is only accessible to teachers, loggedInUser is necessarily a teacher
                {
                    databaseConnection.addCourse(course); //only add a course if the teacher's schedule allows it
                }

                TEACHERaddCourseName.setText("");
                TEACHERaddCourseCapacity.setText("");
                TEACHERfromHrs.setSelectedIndex(0);
                TEACHERfromMins.setSelectedIndex(0);
                TEACHERtillHrs.setSelectedIndex(0);
                TEACHERtillMins.setSelectedIndex(0);

                mondayCheckBox.setSelected(false);
                tuesdayCheckBox.setSelected(false);
                wednesdayCheckBox.setSelected(false);
                thursdayCheckBox.setSelected(false);
                fridayCheckBox.setSelected(false);
                saturdayCheckBox.setSelected(false);

                TEACHERaddCourseIsVoted.setSelected(false);


            }
        });


        //Teacher Course Manager
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                schedule(TEACHERcoursesManager);


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


                String c;
                for (Object course :
                        listOfCourses) {

                    c = (String) course;
                    c = c.substring(c.indexOf("[") + 1, c.indexOf("]"));

                    System.out.println(c);
                    //remove course from student schedule having name c
                    loggedInUser.removecourse(c);
                    databaseConnection.removeCourse(c);
                }
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


                ArrayList<Request> requests = requestClient.getRequestsForTeacher(loggedInUser.getId());

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

            }
        });

        //Student Schedule
        refreshScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                schedule(STUDENTschedule);


            }
        });

        removeCoursesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {


                List listOfCourses = STUDENTschedule.getSelectedValuesList();
                //Approve the above requests
                String c;
                for (Object course :
                        listOfCourses) {

                    c = (String) course;
                    c = c.substring(c.indexOf("[") + 1, c.indexOf("]"));

                    System.out.println(c);
                    //remove course from student schedule having name c
                    loggedInUser.removecourse(c);

                }

            }
        });


        //Student Schedule
        refreshScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                schedule(STUDENTschedule);


            }
        });

        removeCoursesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        List listOfCourses = STUDENTschedule.getSelectedValuesList();

                        String c;
                        for (Object course :
                                listOfCourses) {

                            c = (String) course;
                            c = c.substring(c.indexOf("[") + 1, c.indexOf("]"));

                            //remove course from student schedule having name c
                            loggedInUser.removecourse(c);


                        }


                    }

                });



        searchCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String search = enterCourseNameTextField.getText();


                DefaultListModel model = getCourse(search);


                searchResults.setModel(model);
                searchResults.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                searchResults.setVisible(true);



            }
        });


        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List listOfCourses =  searchResults.getSelectedValuesList();
                Course course;
                //Approve the above requests
                String c;
                for (Object courses:
                        listOfCourses) {

                    c = (String) courses;
                    c = c.substring(0, c.indexOf(": @"));


                    databaseConnection.start();
                    course =databaseConnection.retrieveCourse(c);


                    System.out.println(loggedInUser.addcourse(course));


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

                requestTeacherID.setText("");
                requestCourseName.setText("");
                requestNote.setText("");

            }
        });


        //Admin Backend Manage Rooms
        refreshButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultListModel model = getCourse("");  //get all courses

                ADMINcourses.setModel(model);
                ADMINcourses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                ADMINcourses.setVisible(true);

                DefaultListModel rooms = new DefaultListModel();

                for (Room r: Room.rooms.values()) //get all rooms
                {
                    rooms.addElement(r.getName());
                }


                ADMINrooms.setModel(rooms);
                ADMINrooms.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                ADMINrooms.setVisible(true);


            }
        });

        //Assign a room to a course
        assignRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object courses =  ADMINcourses.getSelectedValue();
                Object rooms = ADMINrooms.getSelectedValue();

                Course course;
                //Approve the above requests

                String s;

                s = (String) courses; //only one course can be selected
                s = s.substring(0, s.indexOf(": @"));


                databaseConnection.start();
               course = databaseConnection.retrieveCourse(s);

               s = (String) rooms;
               course.setRoom(s);

               course.print();


                }
        });
        refreshButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Message> inbox = messageClient.getInbox(loggedInUser.getId());
                Vector<String> inboxString = new Vector<>();

                int senderID;
                String senderName;

                for (Message m :
                        inbox) {

                    senderID = m.getSenderID();
                    senderName = databaseConnection.getUserName(senderID);
                    inboxString.add(senderName + " [" + m.getSenderID() + "]: " + m.getContent());
                }


                STUDENTinbox.setListData(inboxString);
            }
        });
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = STUDENTmessageContent.getText();
                int receiver = Integer.parseInt(receiverIDTextField.getText());

                messageClient.sendMessage(loggedInUser.getId(), receiver, content);

                STUDENTmessageContent.setText("");
                receiverIDTextField.setText("");
            }
        });

        //Student Requests
        refreshRequestsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get requests sent from students to the teacher

                ArrayList<Request> requests = requestClient.viewSentRequests(loggedInUser.getId());
                Vector<String> reqStrings = new Vector<>();

                for (Request r :
                   requests  ) {

                    if (r.getStudentID() == loggedInUser.getId()) {
                        reqStrings.add(r.getRequestID() + "::[" + r.getState() + "] To: " + r.getTeacherID() + ", Course: " + r.getCourseName() +
                                ", Request Note: " + r.getRequestText());
                    }

                }

                sentRequests.setListData(reqStrings);







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

