
public class ScheduleElement implements Comparable<ScheduleElement> {
	
	/**
	 * ScheduleElement are used to make schedules.
	 * a ScheduleElement has:
	 * -A date
	 * -A start time
	 * -An end time
	 * -A title
	 * -A location
	 * 
	 * --For now a scheduleElement only lasts for one day- might extend it
	 * so an element can have more days
	 */
	
	private ScheduleTime startTime; //start time
	private ScheduleTime endTime; //end time
	private String name; //For now will use strings for name and location-might change later
	private String location;
	private String day; //TODO find a method for days (objects maybe?)
	
	
	@Override
	public int compareTo(ScheduleElement o) {
		// Comparing two scheduleElements is simple:
		//if there's a conflict- if they intersect we retrun 0
		//if this happens before o we return -1
		//otherwise we return 1
		
		
		//This comparaison works because we made sure endTime is always less than startTime:
		//An event can't end before starting
		if (startTime.compareTo(o.endTime) > 0 ) //it starts after the other event ends
		{
			return 1;
		}
		else if (endTime.compareTo(o.startTime) < 0) //it ends before the other event starts
		{
			return -1;
		}
		else
		{
			return 0; //theres a conflict!!
		}
		
	}
	
	
	//Basic getters and setters
	
	public void setDay(String day)
	{
		this.day = day;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public boolean setStartTime(String s)
	{
		ScheduleTime temp = new ScheduleTime();
		boolean result= temp.setTime(s);
		
		//startTime before endTime or endTime not defined
		if (endTime != null && temp.compareTo(endTime) > 0) 
		{
			return false;
			
		}
		
		startTime = temp;
		return result;
	}
	
	public boolean setStartTime(int hours, int minutes)
	{
		ScheduleTime temp = new ScheduleTime(hours,minutes);
		return (setStartTime(temp.getTime())); 
	}
	
	//TODO add conditions to make sure end time happens after start time
	public boolean setEndTime(String s)
	{
		
		ScheduleTime temp = new ScheduleTime();
		boolean result= temp.setTime(s);
		
		//startTime before endTime or endTime not defined
		if (startTime != null && temp.compareTo(startTime) < 0) 
		{
			return false;
			
		}
		
		endTime = temp;
		return result;
	}
	
	public boolean setEndTime(int hours, int minutes)
	{
		ScheduleTime temp = new ScheduleTime(hours,minutes);
		return (setStartTime(temp.getTime())); 
	}
	
	public void setDuration(int hours,int minutes)
	{
		setEndTime(startTime.add(hours,minutes).getTime());
		//Just in case an event takes more than 24h..
		//TODO deal with this issue
	}
	
	//Constructors
	ScheduleElement()
	{
		//startTime = new ScheduleTime();
		//endTime = new ScheduleTime();
		location = "TBA"; //Default location
	
	}
	
	
	ScheduleElement(String name)
	{
		this();
		this.name = name;
	}
	
	



}
