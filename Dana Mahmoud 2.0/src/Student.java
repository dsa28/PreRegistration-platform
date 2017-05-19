import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Student extends user {


    ddb d;
    int dborder;

    @Override
    public int getTab()
    {
        return 1;
    }

    Student(String name, int id, String password)
    {
        super(name,id,password);
    }


    public boolean addcourse(Course c)
    {
        if (super.getSchedule().hasConflict(c.getTimings()))
        {
            return false;
        }

        if (c.addStudent(this))
        {
            super.addcourse(c);
          // if( c.addStudent(this)) //need to register the student to the course
          // {
               c.print();
               return true;
          // }

          // removecourse(c.getName()); //not enough capacity in the course! need to remove it

        }
        return false;
    }

    public Course removecourse(String s)
    {
        Course c = super.removecourse(s);

        if(c!= null)
        {
            c.removeStudent(this);
        }

        return c;

    }



}
