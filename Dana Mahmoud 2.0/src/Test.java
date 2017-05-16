/**
 * Created by Dana on 5/16/2017.
 */
public class Test {

    public static void main(String[] args) {
        data_storage db = new data_storage();


        Course Math227 = new Course("Math227");
        Course Math251 = new Course("Math251");
        Course Math210 = new Course("Math210");
        Course EECE437 = new Course("EECE437");

        db.addCourse(Math227);
        db.addCourse(Math251);
        db.addCourse(Math210);
        db.addCourse(EECE437);

        Course find = db.retrieveCourse("Math227");
        find.print();

        System.out.println();

        find = db.retrieveCourse("Math219");
        find.print();


    }
}
