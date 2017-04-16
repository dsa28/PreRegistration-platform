import java.util.ArrayList;

class Schedule {
	
	/**
	 *Schedule class is used to store events (ScheduleElement) by timing.
	 *It can also detect conflicts.
	 *
	 *Schedule implements the following methods:
	 *-addElement()
	 *-hasConflict()
	 *
	 *A schedule is basically an ordered list of elements with binary search and insertion
	 */
	
	private ArrayList<ScheduleElement> elements;
	
	
	boolean addElement(ScheduleElement element)
	{
		if (hasConflict(element))
		{
			return false;
		}
		
		insert(element);
		return true;
	}
	
	boolean addElement (Schedule schedule)
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
	
	boolean hasConflict(ScheduleElement element)
	{
		return hasConflict(element,0,elements.size()-1);
	}
	
	
	boolean hasConflict(Schedule schedule)
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
		//TODO arrange it so its done in O(log n) -- binary search
		
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