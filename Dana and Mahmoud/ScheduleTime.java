
public class ScheduleTime implements Comparable<ScheduleTime>{
	
	/**
	 * ScheduleTime is used to represent the start or end time
	 * of ScheduleElement.
	 * ScheduleTime implements Comparable interface
	 * 
	 * ScheduleTime has the following constructors:
	 * -By default: time is 00:00
	 * -Specify hours and minutes: time will take the value specified (if valid), 0 otherwise
	 * 
	 * 
	 * ScheduleTime has the following methods:
	 * -setTime(int hours, int minutes): Specify the time we want
	 * -compareTo(ScheduleTime a) (from Comparable interface): compares to the ScheduleTime a
	 * -getHours: returns the hours
	 * -getMinutes: returns the minutes
	 * -getTime: returns the time as a string "hh:mm"
	 * 
	 * This class is used for abstraction purposes only- user shouldn't have to use it
	 * 
	 * 
	 */
	
	//For the timing of an event, we only care about hours and minutes
	//Hours will be represented in a 24h system (13:00 instead of 1:00 pm)
	
	private int time; //To facilitate comparing times (among other operations,the time will be represented as an int)
	//hours hours minutes minutes

	
	public int getHours()
	{
		return time/100;
	}
	
	public int getMinutes()
	{
		return time%100;
	}
	
	
	
	@Override
	public String toString()
	{ 
		String s = getHours() + ":";
		if (getMinutes() < 10)
		{
			s += "0";
		}
		
		s += getMinutes();
		
		return s;

	}

	public boolean setTime(String s)
	{
		int mid = s.indexOf(":");
		if (mid < 0)
		{
			return false; //Wrong format!!
		}
		
			try
			{
				int hours = Integer.parseInt(s.substring(0,mid));
				int minutes = Integer.parseInt(s.substring(mid+1));
			
				return setTime(hours,minutes);
			}
			catch(NumberFormatException e)
			{
				return false;
			}

	}
	
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
	
	
	//Compare two ScheduleTimes
	@Override
	public int compareTo(ScheduleTime time) {
		
		
		if (this.time == time.time)
		{
			return 0; //if they are equal return 0
		}
		
		if (this.time > time.time)
		{
			return 1; //if the first time is bigger return 1
		}
		
		return -1; //if the second time is bigger return -1 
		
	}
	
	public ScheduleTime add(ScheduleTime op2)
	{
		//add schedule time elements
	
		
		int minutes = op2.getMinutes();
		int hours = op2.getHours();

		
		return add(hours,minutes);
	
	}
	
	public ScheduleTime add(int hours, int minutes)
	{
		int tempmins = (this.getMinutes()+minutes)%60; //in case of carry
		int temphours = (this.getHours()+hours+ tempmins/60)%24; //in case we move on to another day
		
		ScheduleTime result = new ScheduleTime(temphours,tempmins);
		return result;
	}
	
	public ScheduleTime getDifference(ScheduleTime t)
	{
		//Return the difference between two timings (in absolute value)
		ScheduleTime time1 = this;
		ScheduleTime time2 = t; //time2 is the biggest time
		
		
		if (this.compareTo(t) > 1)
		{
			time1 = t;
			time2 = this;
		}
		
		int carry = 0;
		
		int minutes = (time2.getMinutes() - time1.getMinutes()); //Difference in minutes is at most 59!
		
		
		if (minutes < 0)
		{
			minutes += 60; //positive number
			carry = -1;
		}
		int hours = time2.getHours() - time1.getHours() + carry;

		ScheduleTime result = new ScheduleTime(hours,minutes);
	
		return result;
		
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
