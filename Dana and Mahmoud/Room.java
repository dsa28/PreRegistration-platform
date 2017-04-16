
public class Room {
	
	/**
	 * A Room has:
	 * a maximum number of students it can fit
	 * a name (indicating its location)
	 * 
	 * possibly a schedule- to make sure no 2 different classes happen in the same room
	 * at the same time  (??)
	 * 
	 */
	
	private int maxCapacity;
	private String name;
	
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
	
	Room ()
	{
		name= "TBA";
		maxCapacity = 0;
	}
	
	Room(String name)
	{
		this();
		this.name = name;
	}

}
