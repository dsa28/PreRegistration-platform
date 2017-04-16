import java.util.ArrayList;

public class Course {
	
	/**
	 * Course is used to represent a course.
	 * It has the list of students taking the course
	 * The timing of the course
	 * 
	 * 
	 * Course implements the following methods:
	 * -setTime
	 * -increaseCapacity
	 * -addStudent
	 * -getReigstered
	 * -getScheduleElement
	 * -addTiming
	 * -setTimings
	 * -clearTimings
	 * -setTeacher
	 * -getTeacher
	 *
	 */

	String name;
	
	private Teacher teacher;
	private ArrayList<Student> students;
	
	private int capacity;
	
	private Schedule timings; //timing of the course

	
	public Schedule getTimings()
	{
		//Get the timing for a course
		return timings;
	}
	
	public void setTimings(Schedule timings)
	{
		this.timings = timings;
	}
	
	public boolean addTiming(ScheduleElement time)
	{
		
		//Add a timing for the course
		
		ScheduleElement temp = time.clone();
		temp.setName(name);
		
		return timings.addElement(temp);
	}
	
	public void clearTimings()
	{
		timings= new Schedule();
	}
	
	public boolean addStudent(Student student)
	{
		if (students.size() < capacity) //there's enough capacity for the student
		{
			students.add(student);
		}
		return false; //not enough places :( 
	}
	
	public void increaseCapacity(int extra) 
	{
		//Increase capacity by the specified amount
		capacity += extra;
	}
	
	public int getRegistered()
	{
		//Get the number of registered students
		return students.size();
	}
	
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	
	public Teacher getTeacher()
	{
		return teacher;
	}
	
	Course(String name)
	{
		this.name = name;
		students = new ArrayList<Student>();
		teacher = new Teacher();
		
		capacity = 0;
		
		timings = new Schedule();
		
	}
	
	Course(String name, int capacity)
	{
		this(name);
		this.capacity = capacity;
	}


	
}
