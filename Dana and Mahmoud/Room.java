import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	
	/**
	 * A Room has:
	 * a maximum number of students it can fit
	 * a name (indicating its location)
	 * 
	 * a schedule- to make sure no 2 different classes happen in the same room
	 * at the same time 
	 * 
	 */
	
	
	
	
	private int maxCapacity;
	private String name; //we are assuming each room has a unique name which will be used as key in the hashmap
	
	private Schedule schedule = new Schedule(); //Schedule to make sure no two courses happen at the same time
	
	static public HashMap<String,Room> rooms = new HashMap<String,Room>(); //the rooms of aub
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public void addCourse(Course course)
	{
		courses.add(course);
	}
	
	public void empty()
	{
		//To delete all courses from a room, we need to update them one by one
		//and let them know we changed room
		//observer pattern
		for (int i=0; i<courses.size();i++)
		{
			courses.get(i).setRoom(getRoom()); //make room TBA
		}
		
		courses = new ArrayList<Course>(); //no more courses in the room
		schedule = new Schedule();
	}
	
	public void remove(String name)
	{
		schedule.remove(name);
	}
	
	public boolean addElement(Schedule schedule)
	{
		//When we add a course to a room, we will put its schedule with the room's schedule
		if (hasConflict(schedule))
		{
			return false; //conflict! can't add the course :( 
		}
		
		this.schedule.addElement(schedule);
		return true;
	}
	
	public boolean addElement(ScheduleElement element)
	{
		Schedule tempschedule = new Schedule();
		tempschedule.addElement(element);
		return addElement(tempschedule);
	}
	
	
	
	public Schedule getSchedule()
	{
		return schedule;
	}
	
	public boolean hasConflict(ScheduleElement elem)
	{
		return this.schedule.hasConflict(elem);
	}
	
	public boolean hasConflict(Schedule schedule)
	{
		return this.schedule.hasConflict(schedule);
	}
	
	public void setMaxCapacity(int max)
	{
		maxCapacity = max;
	}
	
	public int getMaxCapacity()
	{
		return maxCapacity;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void print()
	{
		System.out.println(name);
		schedule.print();
	}
	
	static public Room getRoom()
	{
		return new Room(); //only exception to singleton rooms is TBA.. can have as many instances as we want
	}
	
	//Instead of a constructor we will use a getter
	static public Room getRoom(String name)
	{
		if (rooms.containsKey(name))
		{
			return rooms.get(name);
		}
		
		return addRoom(name);
	}
	
	static private Room addRoom(String name) //Create new room- something like a constructor
	{
		Room room = new Room();
		room.name = name;
		rooms.put(room.name, room);
		
		return room;
	}
	
	//Each room has a schedule-- to enforce that one room does not have two different objects
	//Which could create a conflict and defeat the point of the schedule,
	//We will use something similar to a singleton design pattern
	//By making the constructors private and only allowing users to access rooms from our stored rooms
	private Room ()
	{
		name= "TBA";
		maxCapacity = 100;
	}
	
	

}
