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
	 * -getReigstered
	 * 
	 */

	String name;
	
	private Teacher teacher;
	private ArrayList<Student> students;
	
	private int capacity;
	
	ScheduleElement timing; //timing of the course
	
	
	void setTime(int hour, int minutes)
	{
		//Set the timing of the course
		
		timing = new ScheduleElement(name);
		timing.setTime(hour,minutes);
	}
	
	void increaseCapacity(int extra) 
	{
		//Increase capacity by the specified amount
		capacity += extra;
	}
	
	int getRegistered()
	{
		//Get the number of registered students
		return students.size();
	}

	
}
