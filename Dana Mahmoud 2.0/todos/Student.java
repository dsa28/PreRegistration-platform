import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Student extends user {

    ArrayList<String> courses;
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

/*
    Student(ArrayList<String> course, ddb dd, int order)
    {
        courses=course;
        ddb d = dd;
        dborder = order;
    }
    public void addcourse(String c)
    {
        if(!isconflict) {
            d.alluserinfo.get(dborder).add(c);
            courses.add(c);
        }
    }
    public void removecourse(String c)
    {
        for(int i=0;i<courses.size();i++)
            if(courses.get(i).equals(c))
                courses.remove(c);
    }*/
}
