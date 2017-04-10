
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
	
	ScheduleElement(String name, String startTime)
	{
		this(name);
		this.startTime.setTime(startTime);
	}
	
	ScheduleElement(String name, String startTime, String endTime)
	{
		this(name,startTime);
		this.endTime.setTime(endTime);
	}

}
