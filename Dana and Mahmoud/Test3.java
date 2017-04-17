
public class Test3 {

	public static void main(String[] args) {
		/*
		 * Class to test rooms
		 */
		
		ScheduleElement elem = new ScheduleElement();
		elem.setStartTime(12,00);
		elem.setEndTime(12,50);
		elem.setDay(Day.Monday);
		
		Course Math227 = new Course("Math 227");
		Math227.addTiming(elem);
		elem.setDay(Day.Wednesday);
		Math227.addTiming(elem);
		elem.setDay(Day.Friday);
		Math227.addTiming(elem);
		
		//Checking if we always get the same room
		
		Room room = Room.getRoom("room 1");
		room.setMaxCapacity(22);
		
		Room room2 = Room.getRoom("room 1");
		
		
		System.out.println(room2.equals(room)); //true
		System.out.println(room2.getMaxCapacity()); //ok!
		
		room2.setMaxCapacity(25);
		System.out.println(room.getMaxCapacity()); //25
		
		//Adding classes in rooms!
		room.addElement(Math227.getTimings());
		System.out.println(room2.hasConflict(Math227.getTimings())); //true
		
		System.out.println();
		Room.getRoom("room 1").print();
		
		Course Math261 = new Course("Math 261");
		ScheduleElement time = new ScheduleElement();
		
		time.setStartTime(11,00);
		time.setEndTime(11,50);
		
		time.setDay(Day.Monday);
		
		Math261.addTiming(time);
		time.setDay(Day.Wednesday);
		Math261.addTiming(time);
		time.setDay(Day.Friday);
		Math261.addTiming(time);
		
		
		System.out.println();
		
		Math261.setRoom(room2);
		room.print();
		System.out.println();
		
		time.setTime(11, 00);
		System.out.println(Math261.addTiming(time));
		
		
		time.setTime(12,55);
		System.out.println(time);
		System.out.println(Math261.addTiming(time));
		
		
		Math261.getTimings().print();
		
		System.out.println();
		room.print();
		System.out.println();
		
		Room nicely221 = Room.getRoom("Nicely 221");
		Math261.setRoom(nicely221);
		System.out.println();
		room.print();
		System.out.println();
		
		System.out.println();
		nicely221.print();
		System.out.println();
		
		nicely221.empty();
		nicely221.print();
		
		System.out.println();
		Math261.print();
	
		
	}

}
