import java.util.ArrayList;

/**
 * Created by user on 05-Apr-17.
 */
public class preregistration {
    public User_System system;
    public gui2 gui;
    public static void main(String arg[])
    {
        preregistration k=new preregistration();
    }
    preregistration()
    {
        system=new User_System();
        gui=new gui2(system);
    }
}
