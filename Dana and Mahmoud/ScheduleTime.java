
public class ScheduleTime {
	
	/**
	 * ScheduleTime is used to represent the start or end time
	 * of ScheduleElement
	 */
	
	//For the timing of an event, we only care about hours and minutes
	//Hours will be represented in a 24h system (13:00 instead of 1:00 pm)
	
	private int time; //To facilitate comparing times (among other operations,the time will be represented as an int)
	//hours hours minutes minutes 
	
	
	public boolean setTime(int hours, int minutes) //Can set the time of a schedule event
	{
		
		//hours should be between 0 (12:00 am) and 23 (11 pm)
		if (hours < 0 || hours > 23)
		{
			return false;
		}
		
		//minutes should be between 0 and 59
		if (minutes < 0 || minutes > 59)
		{
			return false;
		}
		
		
		//Time = hour hour: minute minute
		time = hours*100 + minutes;
		
		return true; //successfully set the time
	}
	
	
	//Constructors
	ScheduleTime()
	{
		time = 0; //by default
	}
	
	ScheduleTime(int hours, int minutes)//Can give hours and minutes to get time
	{
		this(); //Call constructor by default
		setTime(hours,minutes); //try setting the time- if not the time will take the default value
		
	}

}
