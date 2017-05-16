import java.util.ArrayList;

/**
 * Created by user on 05-Apr-17.
 */
public class User_System {

    public data_storage db;
    ArrayList<ArrayList<String>> a;

   /* User_System()
    {
        db = new data_storage();
        a= db.alluserinfo;//useless, just for testing
        printusers();
    }
    public ArrayList<Integer> check(String id, String pin)
    {
        ArrayList<Integer> info= db.auth(id,pin);//here create new user with given info from db
        if(info.size()!=0)
        {
            return info;
        }
        ArrayList<Integer> c=new ArrayList<>();
        c.add(-1);
        c.add(-1);
        return c;
    }
    public void printusers()
    {
        for(ArrayList<String> s:a) {
            for(String k:s)
                System.out.print(k+", ");
            System.out.println();
        }
    }
    */
}
