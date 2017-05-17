import java.util.ArrayList;

/**
 * Created by user on 16-Apr-17.
 */
public class Teacher extends user {

    data_storage d;
    int dborder;

    @Override
    public int getTab() {
        return 2;
    }



    Teacher(String name, int id, String password)
    {
        super(name,id,password);
    }

    Teacher()
    {

    }
}
