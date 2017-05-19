import java.util.ArrayList;

public class Course  {
	
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
	

	public boolean equals(String s)
	{
		return (name.equals(s));
	}

	public boolean setRoom (String s)
	{
		Room room = Room.getRoom(s); //get room called s
		return setRoom(room);
	}

	public boolean setRoom(Room room)
	{
		if (getRegistered()>room.getMaxCapacity())
		{
			return false; //more registered students than places in the room!!
		}

		boolean bool = room.addElement(timings);
		
		
		if (bool)
		{
			
			this.room.remove(name); //course is no longer given in that room
			this.room = room;
			room.addCourse(this);
			//need to empty old room, if any

			if (capacity>room.getMaxCapacity())
			{
				capacity = room.getMaxCapacity();
				//max number of students who can register should be at most as much as the room's capacity
			}
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

	public void removeStudent(Student s)
	{
		for(int i=0;i<students.size();i++)
		{
			if (students.get(i).equals(s)) {
				students.remove(i);
				return; //student can register course only once
			}
		}

	}

	public boolean increaseCapacity(int extra) 
	{
		//Increase capacity by the specified amount
		if (capacity + extra <= room.getMaxCapacity())
		{
			capacity += extra;
			return true;
		}
		return false;
	}
	
	public int getRegistered()
	{
		//Get the number of registered students
		return students.size();
	}
	
	public boolean setTeacher(Teacher teacher)
	{
		if (teacher.addcourse(this))
		{
			this.teacher = teacher;
			return true;
		}

		return false;
	}
	
	public Teacher getTeacher()
	{
		return teacher;
	}

	void print()
	{
		System.out.println("Name: " + name);
		System.out.println("Teacher: " + teacher.getName());
		System.out.println("Capacity: " + capacity);
		System.out.println("Registered: " + getRegistered());
		System.out.println("Location: " + room.getName());
	}

	public String toString()
	{
		return name + ": @" + timings.toString() + " [" + teacher + "]" + "[" + room.getName() + "]" + "[" +  getRegistered() + "]" + "[" + capacity + "]";
	}
	
	Course(String name)
	{
		this.name = name;
		students = new ArrayList<Student>();
		teacher = new Teacher();

		
		timings = new Schedule();
		room = Room.getRoom(); //Room is TBA
		capacity = room.getMaxCapacity();
		
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
