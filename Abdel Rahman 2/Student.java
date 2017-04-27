import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Student extends user {

ArrayList<Course> courses;
Schedule schedule;

data_storage d;
int dborder;


	Student()
	{
		
	}
	
    
    Student(ArrayList<String> course, data_storage dd, int order)
    {
       courses = new ArrayList<Course>();
       
       for (int i=0; i < course.size(); i++) //transform strings into courses
       {
    	   courses.add(new Course(course.get(i)));
       }
       
       d=dd;
       dborder=order;
    }
    
    public void addcourse(Course c)
    {
        if(schedule.addElement(c.getTimings())) {
            d.alluserinfo.get(dborder).add(c.toString());
            courses.add(c);
        }
    }
    
    public void removecourse(String c)
    {
        for(int i=0;i<courses.size();i++)
        {
        	if(courses.get(i).equals(c))
                courses.remove(c);
        }
        
        schedule.remove(c); //remove the element from the schedule as well
        
    }
   
    public void requestcapacity(String course, Teacher t)
    {
        Message m=new Message(dborder, dborder, course);
       // m.send(t, course, "capacity");
    }
}
