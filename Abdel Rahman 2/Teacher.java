import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Teacher {
	
    ArrayList<Course> courses;
    Schedule schedule;
    String name; //teacher needs a name
    data_storage d;
    int dborder;
   
    Teacher()
    {
    	name = "TBA";
    }
   
    Teacher(String name)
    {
    	this.name = name;
    }
    
    Teacher(ArrayList<String> course, data_storage dd, int order)
    {
    	this();
    	courses = new ArrayList<Course>();
    	
    	for (int i=0; i<course.size(); i++)
    	{
    		courses.add(new Course(course.get(i)));
    	}
    	
        d=dd;
        dborder=order;
       
    }
    public void addcourse(Course course)
    {
        if(schedule.addElement(course.getTimings())) //tried adding the course- if it works, it will return true
        {
                d.alluserinfo.get(dborder).add(course.toString());
                courses.add(course);
        }
    }
    
    
    public void opencapacity(Course course, Student s)
    {
        
        if(course.increaseCapacity(1)) {

            course.addStudent(s);
        }
    }
    
    public ArrayList<Course> getSections()
    {
        return courses;
    }
    
    public void removecourse(String c)
    {
    	//Remove course from the list of courses
        for(int i=0;i<courses.size();i++)
        {  if(courses.get(i).equals(c))
            {
            	courses.remove(c);
            }
        }
        
        schedule.remove(c); //remove course from schedule
        
    }
    
    public String getName()
    {
    	return name;
    }
}
