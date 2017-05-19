
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
        databaseConnection.addUser("Antonio", 201402582, "apple", "Student");
        databaseConnection.addUser("Mahmoud", 201502345, "password", "Student");

        databaseConnection.addUser("Fares", 1000, "password", "Student");
        databaseConnection.addUser("Rabih", 1001, "password", "Student");
        databaseConnection.addUser("Jon", 1003, "password", "Student");
        databaseConnection.addUser("Daenerys", 1004, "dragon", "Student");
        databaseConnection.addUser("Barry", 1005, "password", "Student");
        databaseConnection.addUser("Selena", 1006, "password", "Student");
        databaseConnection.addUser("Oliver", 1007, "password", "Student");
        databaseConnection.addUser("Clay", 1008, "hannah", "Student");

        databaseConnection.addUser("Hannah", 1013, "password", "Student");
        databaseConnection.addUser("Toufic", 1009, "password", "Student");
        databaseConnection.addUser("AbedelRahman", 1010, "password", "Student");
        databaseConnection.addUser("Abbas", 1011, "password", "Student");
        databaseConnection.addUser("Stephen", 1020, "password", "Student");
        databaseConnection.addUser("Kevin", 1012, "password", "Student");
        databaseConnection.addUser("Aicha", 1014, "password", "Student");

        databaseConnection.addUser("Sawsan", 1015, "password", "Student");
        databaseConnection.addUser("Bahia", 1016, "password", "Student");
        databaseConnection.addUser("Nadeen", 1017, "password", "Student");
        databaseConnection.addUser("Harry", 1018, "magic", "Student");
        databaseConnection.addUser("Ron", 1002, "password", "Student");
        databaseConnection.addUser("Jad", 1019, "password", "Student");

        databaseConnection.addUser("A", 1021, "password", "Student");
        databaseConnection.addUser("Tyrion", 1022, "password", "Student");
        databaseConnection.addUser("Mohammad", 1023, "password", "Student" );



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
        databaseConnection.addUser("Sophie Moufawad", 28, "password", "Teacher");
        databaseConnection.addUser("Ibrahim Abu Faycal", 29, "password", "Teacher");


        //Admins
        databaseConnection.addUser("Admin",0,"password", "Admin");


        user User;

        //Courses
        Course Math261 = new Course("MATH 261",20);
        Course Math251 = new Course("MATH 251",40);
        Course Math210 = new Course("MATH 210",20);
        Course EECE437 = new Course("EECE 437",15);
        Course EECE442 = new Course("EECE 442", 20);
        Course ENGL206 = new Course("ENGL 206" ,25);
        Course Math241 = new Course("MATH 241", 20);
        Course EECE435L = new Course("EECE 435L", 10);
        Course EECE501 = new Course("EECE 501", 100);


        ScheduleElement t = new ScheduleElement();
        t.setStartTime(2,00);
        t.setEndTime(5,00);
        t.setDay(Day.Thursday);

        EECE435L.addTiming(t);



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

        EECE437.setTeacher((Teacher)(databaseConnection.checkCredentials(10,"password")));

        Math210.addTiming(time1);
        Math210.addTiming(time2);
        Math210.addTiming(time3);

        Math210.setTeacher((Teacher)(databaseConnection.checkCredentials(21,"password")));

        time1.setTime(12,00);
        time2.setTime(12,00);
        time3.setTime(12,00);

        Math261.addTiming(time1);
        Math261.addTiming(time2);
        Math261.addTiming(time3);

        Math251.addTiming(time1);
        Math251.addTiming(time2);
        Math251.addTiming(time3);

        Math251.setTeacher( (Teacher)(databaseConnection.retrieveUser(20)));

        time1.setTime(9,00);
        time2.setTime(9,00);
        time3.setTime(9,00);

        EECE442.addTiming(time1);
        EECE442.addTiming(time2);
        EECE442.addTiming(time3);

        EECE442.setTeacher((Teacher)(databaseConnection.checkCredentials(29,"password")));

        t.setDay(Day.Tuesday);
        t.setTime(18,00);

        EECE501.addTiming(t);
        EECE501.setTeacher((Teacher)(databaseConnection.checkCredentials(25,"password")));

        time1.setTime(1,00);
        time2.setTime(1,00);
        time3.setTime(1,00);

        ENGL206.addTiming(time1);
        ENGL206.addTiming(time2);
        ENGL206.addTiming(time3);

        ENGL206.setTeacher( (Teacher)(databaseConnection.retrieveUser(26)));


        (databaseConnection.retrieveUser(201501455)).addcourse(ENGL206);
        (databaseConnection.retrieveUser(201402582)).addcourse(ENGL206);
        (databaseConnection.retrieveUser(1001)).addcourse(ENGL206);
        (databaseConnection.retrieveUser(1004)).addcourse(ENGL206);

        //add students to courses
        //eece 435L should be full
        for (int i=1000; i <1015; i++)
        {
            User = databaseConnection.checkCredentials(i, "password");
            if (User != null)
            {
                User.addcourse(EECE435L);
                User.addcourse(EECE437);

                if (i% 4 == 0)
                {
                    User.addcourse(Math261);
                    System.out.println(i + " Math 261");
                }

                if (i % 3 == 0)
                {
                    User.addcourse(EECE442);
                    System.out.println(i + " EECE 442");
                }


            }
        }


        for (int i=1000; i <1030; i++)
        {
            User = databaseConnection.checkCredentials(i, "password");
            if (User != null) {
                User.addcourse(EECE501);

            }
        }


        databaseConnection.addCourse(Math261);
        databaseConnection.addCourse(Math251);
        databaseConnection.addCourse(Math210);
        databaseConnection.addCourse(EECE437);
        databaseConnection.addCourse(EECE435L);

        databaseConnection.addCourse(EECE442);
        databaseConnection.addCourse(EECE501);
        databaseConnection.addCourse(ENGL206);
        databaseConnection.addCourse(Math241);

        Room.getRoom("Nicely 224");
        Room.getRoom("Bechtel 111");
        Room.getRoom("WHCR");
        Room.getRoom("Fisk 321");
        Room.getRoom("Bechtel 110");
        Room.getRoom("Nicely 220");
    }

}
