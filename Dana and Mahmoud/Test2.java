
public class Test2 {
/*
 * Class used to test courses
 * 
 */
	public static void main(String[] args) {
		
	//Some courses 
	Course Math261 = new Course("Math 261");
	Course Math241 = new Course("Math 241");
	Course Cvsp205 = new Course("Cvsp 205");
	Course Eece442 = new Course("Eece 442");
	Course Eece501 = new Course("Eece 501");
	
	
	//Inserting courses in the schedule
	Schedule schedule = new Schedule();
	
	ScheduleElement time = new ScheduleElement();
	
	time.setStartTime(11,00);
	time.setEndTime(11,50);
	
	time.setDay(Day.Monday);
	
	Math261.addTiming(time);
	time.setDay(Day.Wednesday);
	Math261.addTiming(time);
	time.setDay(Day.Friday);
	Math261.addTiming(time);
	
	schedule.addElement(Math261.getTimings());
	schedule.print();
	System.out.println();
	
	time.setTime(13,00);
	time.setDay(Day.Monday);
	Math241.addTiming(time);
	time.setDay(Day.Wednesday);
	Math241.addTiming(time);
	time.setDay(Day.Friday);
	Math241.addTiming(time);
	
	Math241.getTimings().print(); //Printing the schedule of a course
	System.out.println();
	
	schedule.addElement(Math241.getTimings());
	schedule.print();
	System.out.println();
	
	time.setTime(12,00);
	time.setDay(Day.Monday);
	Cvsp205.addTiming(time);
	time.setDay(Day.Wednesday);
	Cvsp205.addTiming(time);
	time.setDay(Day.Friday);
	Cvsp205.addTiming(time);
	
	schedule.addElement(Cvsp205.getTimings());
	
	time.setDay(Day.Tuesday);
	time.setEndTime(19,30);
	time.setStartTime(18,00);
	
	Eece501.addTiming(time);
	
	schedule.addElement(Eece501.getTimings());
	
	schedule.print();
	System.out.println();
	
	System.out.println(Math261.addStudent(new Student())); //no capacity..
	System.out.println();
	Math261.print();
	System.out.println();
	
	
	System.out.println(Math241.addStudent(new Student())); //no capacity
	System.out.println();
	//Test inputting data into courses
	Math241.setTeacher(new Teacher("Hazar Abu Khuzam"));
	Math241.increaseCapacity(25); //adding capacity


	Math241.print();
	System.out.println();
	
	for (int i=0; i<10; i++)
	{
		System.out.println(Math241.addStudent(new Student())); //students register
	
	}
	
	System.out.println();
	Math241.print(); //checking if they registered
	System.out.println();
	
	for (int i=0; i<18; i++)
	{
		System.out.println(Math241.addStudent(new Student())); //more students register
	
	}
	
	
	System.out.println();
	Math241.print(); //oh no.. section full!
	
	//removing something from schedule
	schedule.remove(Math241.getName());
	System.out.println();
	schedule.print();
	System.out.println();
	
	time.setTime(10,00);
	Eece442.addTiming(time);
	time.setTime(11,31);
	Eece442.addTiming(time);
	
	Eece442.getTimings().print();
	System.out.println(schedule.addElement(Eece442.getTimings()));
	
	System.out.println();
	schedule.print();
	System.out.println();
	
	schedule.remove(Eece442.getName());
	System.out.println();
	schedule.print();
	System.out.println();
	
	schedule.remove(Cvsp205.getName());
	System.out.println();
	schedule.print();
	System.out.println();
	
	}
}
