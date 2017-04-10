
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScheduleTime time=  new ScheduleTime(10,50);
		System.out.println(time.getTime());
		
		time.setTime(25, 0);
		System.out.println(time.getTime());
		
		time.setTime(10, 5);
		System.out.println(time.getTime());
		
	
	}

}
