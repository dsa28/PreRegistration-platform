import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */

public class user {

    protected String name;
    protected int id;
    protected String password;

    protected Schedule schedule;
    protected ArrayList<Course> courses;

    public String toString()
    {
        return name;
    }

    public Schedule getSchedule()
    {
        return schedule;
    }


    public int getId()
    {
        return id;
    }

    //Both students and teachers need to be able to add courses
    public boolean addcourse(Course c) {

        if (schedule.addElement(c.getTimings())) //course got added fine, no conflict
        {
            courses.add(c); //added course
            return true;
        }

        return false;
    }


    //both students and teachers need to be able to remove courses
    public void removecourse(String c)
    {
        for(int i=0;i<courses.size();i++)
        {
            if (courses.get(i).equals(c)) {
                courses.remove(i);
            }
        }

        schedule.remove(c); //need to also remove course from schedule
    }


    public user checkPassword(String password)
    {
        if (this.password.equals(password))
        {
            return this;
        }

        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof  user)
        {
            return id == ((user) o).id;
        }

        return false;
    }

    @Override
    public int hashCode() //hashcode so we can store users in a hashmap
    {
        return id;
    }

    public void print()
    {
        System.out.println(name);
    }

    public int getTab()
    {
        //Function get tab is used for GUI
        //it is used to determine the type of GUI to be used depending on the user
        //1 for student
        //2 for teacher
        //3 for admin
        return 3;
    }

    String getName()
    {
        return name;
    }

    user()
    {
        name = "TBA";
        id = 0;
    }

    user(int id)
    {
        this.id = id;
        courses = new ArrayList<Course>();
        schedule = new Schedule();
    }

    user(String name, int id, String password)
    {
        this(id);
        this.name = name;
        this.password = password;
    }


}

