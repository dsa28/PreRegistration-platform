
/**
 * Created by Dana on 5/19/2017.
 */
public class DataClass {

    static void  fillData(data_storage databaseConnection)
    {
        //Class used to fill hard coded data in the application
        //We use this class to isolate populating the data from the actual code, making it easier to both fill data
        //and get rid of all hardcoded data

        //Already saved data

        //Students
        databaseConnection.addUser("Dana", 201501455, "password", "Student");
        databaseConnection.addUser("Antonio", 201402582, "password", "Student");
        databaseConnection.addUser("Fares", 20160000, "password", "Student");

        //Teachers
        databaseConnection.addUser("Zaraket", 1, "password", "Teacher");
        databaseConnection.addUser("Karameh", 2, "password", "Teacher");
        databaseConnection.addUser("Bazzi", 3, "password", "Teacher");

        //Admins
        databaseConnection.addUser("Admin",0,"password", "Admin");


        //Courses
        Course Math227 = new Course("MATH 227",20);
        Course Math251 = new Course("MATh 251",40);
        Course Math210 = new Course("MATH 210",20);
        Course EECE437 = new Course("EECE 437",15);

        ScheduleElement time1 = new ScheduleElement();
        ScheduleElement time2;
        ScheduleElement time3;

        time1.setStartTime(10,00);
        time1.setEndTime(10,50);

        time1.setDay(Day.Monday);

        time2 = time1.clone();
        time2.setDay(Day.Wednesday);

        time3 = time1.clone();
        time3.setDay(Day.Friday);

        EECE437.addTiming(time1);
        EECE437.addTiming(time2);
        EECE437.addTiming(time3);

        Math210.addTiming(time1);
        Math210.addTiming(time2);
        Math210.addTiming(time3);

        time1.setTime(12,00);
        time2.setTime(12,00);
        time3.setTime(12,00);

        Math227.addTiming(time1);
        Math227.addTiming(time2);
        Math227.addTiming(time3);

        databaseConnection.addCourse(Math227);
        databaseConnection.addCourse(Math251);
        databaseConnection.addCourse(Math210);
        databaseConnection.addCourse(EECE437);

        Room.getRoom("Nicely 224");
        Room.getRoom("Bechtel 111");
        Room.getRoom("WHCR");
        Room.getRoom("Fisk 321");
        Room.getRoom("Bechtel 110");
        Room.getRoom("Nicely 220");
    }

}
