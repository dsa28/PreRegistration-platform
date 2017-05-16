
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
	
	Sunday(0),
	Monday(1),
	Tuesday (2),
	Wednesday (3),
	Thursday (4),
	Friday (5),
	Saturday (6);
	
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