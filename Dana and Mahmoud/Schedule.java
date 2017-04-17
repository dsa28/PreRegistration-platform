import java.util.ArrayList;

class Schedule {
	
	/**
	 *Schedule class is used to store events (ScheduleElement) by timing.
	 *It can also detect conflicts.
	 *
	 *Schedule implements the following methods:
	 *-addElement()
	 *-hasConflict()
	 *-remove(String name) -- remove all events with the name "name"
	 *-contains(String name) -- checks if the schedule has events with the name "name"
	 *
	 *A schedule is basically an ordered list of elements with binary search and insertion
	 */
	
	private ArrayList<ScheduleElement> elements;
	
	
	public boolean addElement(ScheduleElement element)
	{
		if (hasConflict(element))
		{
			return false;
		}
		
		insert(element);
		return true;
	}
	
	public boolean addElement (Schedule schedule)
	{
		if (!hasConflict(schedule)){
		
		for (int i=0; i<schedule.elements.size(); i++)
		{
			insert(schedule.elements.get(i));
		}
		
		return true;
		
		}
		
		return false; //theres a conflict- couldnt add
	}
	
	public boolean hasConflict(ScheduleElement element)
	{
		return hasConflict(element,0,elements.size()-1);
	}
	
	
	public boolean hasConflict(Schedule schedule)
	{
		for (int i=0; i<elements.size(); i++)
		{
			if (schedule.hasConflict(elements.get(i)))
			{
				return true; //check conflict for each element
			}
		}
		
		return false; //no conflict
	}
	
	
	public void remove(String name)
	{
		//remove all elements with the name "name"
		for (int i=0; i<elements.size();)
		{
			if (elements.get(i).getName().equals(name))
			{
				//has the name we are looking for-- need to deleted it
				elements.remove(i);
			}
			else
			{
				i++;
			}
		}
		
	}
	
	//helper function for binary search
	private boolean hasConflict(ScheduleElement element,int start, int end)
	{
		if (start>end) //base case
		{
			return false; //checked all entries- no conflict
		}
		
		int index = (start+end)/2;
		int temp = element.compareTo(elements.get(index));
		
		if (temp == 0)
		{
			return true; //oh no! there's a conflict
		}
		
		if (temp < 0)
		{
			return hasConflict(element,start,index-1);
		}
		
		return hasConflict(element,index+1,end);
	}
	
	//Function insert to help us keep the elements sorted
	//They need to be sorted for us to detect conflicts
	private void insert(ScheduleElement elem)
	{
		int location = 0;//to take into account the first element
	
		
		while (location<elements.size() && elem.compareTo(elements.get(location)) > 0 ) //element is bigger than following one
		{
			location++;
		}
	
		elements.add(location, elem);
	}
	
	void print()
	{
		for (int i=0; i < elements.size(); i++)
		{
			System.out.println(elements.get(i));
		}
	}
	
	//Constructors
	Schedule()
	{
		elements = new ArrayList<ScheduleElement>();
	}
	
	
	
}