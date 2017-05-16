
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dana on 5/16/2017.
 */
public class data_storage {


    //Courses
    private ArrayList<Course> courses;
    private HashMap<Teacher,Teacher> teachers;
    private HashMap<Student,Student> students;


    private HashMap<user,user> users;


    //Add and retrieve courses
    public Course retrieveCourse(String course) {

       for (int i=0; i<courses.size();i++)
       {
           if (courses.get(i).equals(course))
           {
               return courses.get(i);
           }
       }

       return null;
    }

    public void addCourse (Course course)
    {
        courses.add(course);
    }


    public boolean addUser(String name, int id, String password, String role)
    {
        user User = new user();

        if (role.equals("Student"))
        {
            User = new Student(name,id,password);

        }
        else if (role.equals("Teacher"))
        {
            User = new Teacher(name,id,password);
        }
        else if (role.equals("Admin"))
        {
            // return new Admin(name,id,password);

        }
        else
        {
            return false;
        }


        if (users.get(User) == null)
        {
            users.put(User,User);
            return true;
        }

        return false;

    }

    public void printUsers()
    {
        for (user i: users.keySet())
        {
            i.print();
        }
    }

    public user checkCredentials(int userid, String password) {

        //Check if user info is valid and return in
        //TODO move to User_System or remove user system
       user tempuser = users.get(new user(userid));

       if (tempuser != null)
       {
            return tempuser.checkPassword(password);
       }
        return tempuser;
    }

    public data_storage()
    {
        courses = new ArrayList<Course>();
        teachers = new HashMap<Teacher,Teacher>();
        students = new HashMap<Student,Student>();

        users = new HashMap<user,user>();

    }



    public String retrieveMessages(int userid) {

        try{
            Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
            //Open a connection using JDBC driver name and database URL
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
            Statement stmt = con.createStatement();
            //select the Message sent (most recent one for this user)
            //TODO: if demanded, select a message with a specific timestamp
            ResultSet rs = stmt.executeQuery("select MessageBody from messages where UserID = '"+ userid + "'");

            con.close();
            return rs.getString(0);

        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
            return "Error";
        }
    }
    public void StoreMessage(String messa, int userid, String datetimee) {//date time should be of the following format
        //yyyy-mm-dd hh:mm:ss.xxxxx

        try{
            Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
            //Open a connection using JDBC driver name and database URL
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
            Statement stmt = con.createStatement();
            //store a message
            stmt.executeUpdate("insert into 'messages' (UserID, MessageTimestamp, MessageBody) VALUE ( '"+ userid + "','" + datetimee  + "','" + messa + "')");
            System.out.println("DONE");
            con.close();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }





}