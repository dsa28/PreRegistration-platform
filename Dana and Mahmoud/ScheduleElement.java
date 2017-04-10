
public class ScheduleElement {
	
	/**
	 * ScheduleElement are used to make schedules.
	 * a ScheduleElement has:
	 * -A date
	 * -A start time
	 * -An end time
	 * -A title
	 * -A location
	 */
	
	private ScheduleTime startTime; //start time
	private ScheduleTime endTime; //end time
	private String name; //For now will use strings for name and location-might change later
	private String location;
	private String day; //TODO find a method for days (objects maybe?)
	
	
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
		return startTime.setTime(s);
	}
	
	public boolean setStartTime(int hours, int minutes)
	{
		return startTime.setTime(hours,minutes);
	}
	
	public boolean setEndTime(String s)
	{
		return endTime.setTime(s);
	}
	
	public boolean setEndTime(int hours, int minutes)
	{
		return endTime.setTime(hours,minutes);
	}
	
	//Constructors
	ScheduleElement()
	{
		startTime = new ScheduleTime();
		endTime = new ScheduleTime();
		location = "TBA"; //Default location
	
	}
	
	
	ScheduleElement(String name)
	{
		this();
		this.name = name;
	}
	
	ScheduleElement(String name,int StartHour,int StartMinute)
	{
		this(name);
		startTime.setTime(StartHour,StartMinute);
	}
	
	
	
	ScheduleElement(String name,String day, String startTime, String endTime)
	{
		this(name);
		
		this.day = day;
		
		this.startTime.setTime(startTime);
		this.endTime.setTime(endTime);
	}

}
