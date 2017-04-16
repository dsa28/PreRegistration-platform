
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
	
	schedule.addSchedule(Math261.getTimings());
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
	
	schedule.addSchedule(Math241.getTimings());
	schedule.print();
	System.out.println();
	
	time.setTime(12,00);
	time.setDay(Day.Monday);
	Cvsp205.addTiming(time);
	time.setDay(Day.Wednesday);
	Cvsp205.addTiming(time);
	time.setDay(Day.Friday);
	Cvsp205.addTiming(time);
	
	schedule.addSchedule(Cvsp205.getTimings());
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
	
	for (int i=0; i<18; i++)
	{
		System.out.println(Math241.addStudent(new Student())); //more students register
	
	}
	
	
	System.out.println();
	Math241.print(); //oh no.. section full!
	
	}
}
