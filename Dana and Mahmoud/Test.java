
public class Test {

	public static void main(String[] args) {
		
		/*
		 * Class used to test Schedules.
		 * There are also some tests of Day, ScheduleTime and ScheduleElement;
		 * the building blocks of Schedule. 
		 */
		
		//Testing days
		System.out.println(Day.Saturday);
		System.out.println(Day.Sunday.compareTo(Day.Sunday));
		System.out.println(Day.Sunday.compareTo(Day.Monday));
		System.out.println(Day.Saturday.compareTo(Day.Sunday));
		

		System.out.println(Day.Friday.nextDay());
		System.out.println(Day.Sunday.nextDay());
		
		System.out.println();
		
		//Testing ScheduleTime
		ScheduleTime time=  new ScheduleTime(10,50);
		System.out.println(time); //10:50
		
		System.out.println(time.setTime(25, 0)); //false
		System.out.println(time); //still 10:50!
		
		time.setTime(10, 5);
		System.out.println(time); //10:05
		
		ScheduleTime time2 = new ScheduleTime();
		
		time2.setTime("0:50");
		System.out.println(time2); //0:50
		
		System.out.println(time.add(time2)); //10:55 
		System.out.println();
		
		
		//Testing scheduleElement
		ScheduleElement elem = new ScheduleElement();//0:00-23:59
		elem.setStartTime(10,5); //10:05-23:59
		System.out.println(elem);
		elem.setDuration(0, 50); //0:50
		System.out.println(elem); //10:05-10:55
		
		elem.setTime(11, 00);
		System.out.println(elem); //11:00-11:50
		
		ScheduleElement elem2 = new ScheduleElement();
		elem2.setStartTime(12,00); //12:00-23:59
		
		System.out.println(elem2); 
		System.out.println();
		
		//Testing schedule
		Schedule sc = new Schedule();
		sc.addElement(elem); 
		System.out.println(sc.hasConflict(elem2));
		
		sc.addElement(elem2);
		elem2.setDuration(2, 00);
		ScheduleElement elem3 = new ScheduleElement();
		elem3.setTime(15, 40);
		
		System.out.println(elem3);
		System.out.println(sc.hasConflict(elem3));
		
		sc.addElement(elem3);
		elem3 = new ScheduleElement();
		elem3.setDuration(0,20);
		elem3.setTime(15,00);
		
		ScheduleElement elem4 = new ScheduleElement();
		elem4.setDuration(0,20);
		elem4.setTime(15,00);
		
		elem4.setDay(Day.Wednesday);
		
		sc.addElement(elem3.clone());
		System.out.println(sc.hasConflict(elem4));
		System.out.println(sc.hasConflict(elem3));
		System.out.println();
		
		sc.addElement(elem4);
		sc.print();
		
		System.out.println();
		
		elem3.setDay(Day.Monday);
		sc.addElement(elem3.clone());
		elem3.setDay(Day.Thursday);
		sc.addElement(elem3.clone());
		
		sc.print();
		
		System.out.println();
		
		//Testing operations with many schedules
		Schedule sc2 = new Schedule();
		sc2.addElement(elem); 
		sc2.print();
		System.out.println(sc.hasConflict(sc2)); //true
		System.out.println(sc2.hasConflict(sc)); //true
		
		Schedule sc3 = new Schedule();
		elem = new ScheduleElement();
		elem.setDay(Day.Saturday);
		sc3.addElement(elem); 
		sc3.print();
		System.out.println(sc.hasConflict(sc3)); //false
		System.out.println(sc3.hasConflict(sc)); //false
		
		sc3.addSchedule(sc2);
		sc3.print();
		System.out.println(sc.hasConflict(sc3)); //true
		System.out.println(sc3.hasConflict(sc));//true
		
		System.out.println();
		
		sc2 = new Schedule();
		sc2.addElement(elem);
		sc2.print();
		System.out.println(sc2.hasConflict(sc)); //false 
		System.out.println(sc.hasConflict(sc2)); //false
		sc2.addSchedule(sc);
		sc2.print();
		
	}

}
