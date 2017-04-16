
public enum Day
{
	/**
	 * Day enum is used to represent days in schedules.
	 * Day has the following functions:
	 * -nextDay: move to the next day
	 * -compareTo: returns the difference in days between 2 days-
	 * 0 if same day
	 * negative if first day comes before second
	 * positive if first day comes after second
	 */
	
	Monday(0),
	Tuesday (1),
	Wednesday (2),
	Thursday (3),
	Friday (4),
	Saturday (5),
	Sunday(6);
	
	private int num;
	
	Day(int num)
	{
		this.num = num;
	}
	
	Day nextDay()
	{
		int temp;
		temp = (num+1)%7; //day should be between 0 and 6
	
		return Day.values()[temp];
	}
	

}