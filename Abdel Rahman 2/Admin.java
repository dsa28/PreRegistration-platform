

/**
 * Created by user on 05-Apr-17.
 */
public class Admin {
data_storage d;
int threshold;
    Admin()
    {
    
    }
    public void setthreshold(int t)
    {
        threshold=t;
    }
    public int getthreshold()
    {
        return threshold;
    }
    public void setroom(Course c, Room room)
    {
        c.setRoom(room)
    }
}
