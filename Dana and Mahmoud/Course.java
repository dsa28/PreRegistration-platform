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

	private String name;
	
	private Teacher teacher;
	private ArrayList<Student> students;
	
	private int capacity;
	
	private Schedule timings; //timing of the course
	private Room room; //room of the course

	public String getName()
	{
		return name;
	}
	
	public Room getRoom()
	{
		return room;
	}
	

	public boolean setRoom(Room room)
	{
		boolean bool = room.addElement(timings);
		
		
		if (bool)
		{
			
			this.room.remove(name); //course is no longer given in that room
			this.room = room;
			//need to empty old room, if any
		}
		
		return bool;
	}
	
	public Schedule getTimings()
	{
		//Get the timing for a course
		return timings;
	}
	
	
	
	public boolean addTiming(ScheduleElement time)
	{
		
		//Add a timing for the course
		
		if (room.hasConflict(time)) //if the room is taken at that time we cant
		{
			return false;
		}
		
		ScheduleElement temp = time.clone();
		temp.setName(name);
		temp.setLocation(room.getName());
		
	
		boolean added= timings.addElement(temp); //temporary boolean
		if (added) //added the timing
		{

			room.addElement(temp); //add new timings
		}
		
		return added;
	}
	
	public void clearTimings()
	{
		timings= new Schedule();
		room.remove(name); //no more timings- we need to remove them from the room
	}
	
	public boolean addStudent(Student student)
	{
		if (students.size() < capacity) //there's enough capacity for the student
		{
			students.add(student);
			return true;
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

	void print()
	{
		System.out.println("Name: " + name);
		System.out.println("Teacher: " + teacher.name);
		System.out.println("Capacity: " + capacity);
		System.out.println("Registered: " + getRegistered());
		System.out.println("Location: " + room.getName());
	}
	
	Course(String name)
	{
		this.name = name;
		students = new ArrayList<Student>();
		teacher = new Teacher();
		
		capacity = 0;
		
		timings = new Schedule();
		room = Room.getRoom(); //Room is TBA 
		
	}
	
	Course(String name, int capacity)
	{
		this(name);
		
		if (capacity >= 0)
		{
			this.capacity = capacity;
		}
	}


	
}
