import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Student extends user {


    ddb d;
    int dborder;

    @Override
    public int getTab()
    {
        return 1;
    }

    Student(String name, int id, String password)
    {
        super(name,id,password);
    }


}
