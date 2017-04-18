import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Student extends user {
ArrayList<String> courses;
data_storage d;
int dborder;
boolean isconflict=false;
    Student(ArrayList<String> course, data_storage dd, int order)
    {
        courses=course;
        d=dd;
        dborder=order;
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
    }
}
