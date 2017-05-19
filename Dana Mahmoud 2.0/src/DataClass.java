
/**
 * Created by Dana on 5/19/2017.
 */
public class DataClass {

    static void  fillData(data_storage databaseConnection)
    {
        //Class used to fill hard coded data in the application
        //We use this class to isolate populating the data from the actual code, making it easier to both fill data
        //and get rid of all hardcoded data
        //and making the actual code more readable

        //Already saved data

        //Students
        databaseConnection.addUser("Dana", 201501455, "password", "Student");
        databaseConnection.addUser("Antonio", 201402582, "password", "Student");
        databaseConnection.addUser("Fares", 201600000, "password", "Student");
        databaseConnection.addUser("Rabih", 201400000, "password", "Student");
        databaseConnection.addUser("Jon Snow", 201201111, "password", "Student");
        databaseConnection.addUser("Daenerys", 201200000, "dragon", "Student");
        databaseConnection.addUser("Barry Allen", 201301455, "flash", "Student");

        //Teachers
        databaseConnection.addUser("Fadi Zaraket", 10, "password", "Teacher");
        databaseConnection.addUser("Fadi Karameh", 11, "password", "Teacher");
        databaseConnection.addUser("Louay Bazzi", 12, "password", "Teacher");
        databaseConnection.addUser("Wassim Masri", 13, "password", "Teacher");
        databaseConnection.addUser("Imad El Hajj", 14, "password", "Teacher");
        databaseConnection.addUser("Hazem Hajj", 15, "password", "Teacher");

        databaseConnection.addUser("Lama Hamandi", 16, "password", "Teacher");
        databaseConnection.addUser("Ali Chehab", 17, "password", "Teacher");
        databaseConnection.addUser("Ali Kanso", 18, "password", "Teacher");
        databaseConnection.addUser("Ibrahim Abu Faycal", 19, "password", "Teacher");

        databaseConnection.addUser("Dolly Fayyad", 20, "password", "Teacher");
        databaseConnection.addUser("Florian Bertrand", 21, "password", "Teacher");
        databaseConnection.addUser("Hazar Abu Khuzam", 22, "password", "Teacher");
        databaseConnection.addUser("Kamal Makdisi", 23, "password", "Teacher");

        databaseConnection.addUser("Zaher Dawy", 24, "password", "Teacher");
        databaseConnection.addUser("Mariette Awada", 25, "password", "Teacher");

        databaseConnection.addUser("Amin John Kurani", 26, "password", "Teacher");
        databaseConnection.addUser("Christopher Nassar", 27, "password", "Teacher");
        databaseConnection.addUser("", 28, "password", "Teacher");
        databaseConnection.addUser("Ibrahim Abu Faycal", 29, "password", "Teacher");


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
