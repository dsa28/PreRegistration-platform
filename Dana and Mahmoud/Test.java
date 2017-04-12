
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Testing ScheduleTime
		ScheduleTime time=  new ScheduleTime(10,50);
		System.out.println(time);
		
		time.setTime(25, 0);
		System.out.println(time);
		
		time.setTime(10, 5);
		System.out.println(time);
		
		ScheduleTime time2 = new ScheduleTime();
		
		time2.setTime("0:50");
		System.out.println(time2);
		
		System.out.println(time.add(time2));
		
		
		//Testing scheduleElement
		ScheduleElement elem = new ScheduleElement();
		elem.setStartTime(10,5);
		System.out.println(elem);
		elem.setDuration(0, 50);
		System.out.println(elem);
		
		elem.changeTime(11, 00);
		System.out.println(elem);
		
		ScheduleElement elem2 = new ScheduleElement();
		elem2.setStartTime(12,00);
		
		System.out.println(elem2);
		//Testing schedule
		Schedule sc = new Schedule();
		sc.addElement(elem);
		System.out.println(sc.hasConflict(elem2));
		
		sc.addElement(elem2);
		elem2.setDuration(2, 00);
		ScheduleElement elem3 = new ScheduleElement();
		elem3.changeTime(15, 40);
		
		System.out.println(elem3);
		System.out.println(sc.hasConflict(elem3));
		
		sc.addElement(elem3);
		elem3 = new ScheduleElement();
		elem3.setDuration(0,20);
		elem3.changeTime(15,00);
		
		sc.addElement(elem3);
		
		sc.print();
	}

}
