import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Teacher {
    ArrayList<String> courses;
    data_storage d;
    int dborder;
    boolean isconflict=false;//to be edited
    Teacher(ArrayList<String> course, data_storage dd, int order)
    {
        courses=course;
        d=dd;
        dborder=order;
    }
    public void addcourse(String course)
    {
        if(!isconflict) {
                d.alluserinfo.get(dborder).add(course);
                courses.add(course);
        }
    }
    public void opencapacity(String course, Student s)
    {
        int getregistered=0, roommaxcapacity=0;//get from arguments and db, set to 0 just to compile
        if(getregistered<roommaxcapacity) {
            course.addCapacity(1);
            course.addstudent(s);
        }
    }
    public ArrayList<String> getSections()
    {
        return courses;
    }
    public void removecourse(String c)
    {
        for(int i=0;i<courses.size();i++)
            if(courses.get(i).equals(c))
                courses.remove(c);
    }
    
}
